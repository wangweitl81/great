import subprocess
import os
import shutil

class BazelWSGenerator(object):
    """
    This tool is used to generate WORKSPACE and BUILD files for maven projects
    If the BUILD file already exists, a backup file will be generated named BUILD.bak
    """
    def __init__(self, path):
        #check whether path is a dir
        if not os.path.isdir(path):
            raise AssertionError("Please input a valid directory:")

        #check whether pom.xml exists
        if not os.path.isfile(path + "/pom.xml"):
            raise AssertionError("The directory should contain pom.xml")

        self.path = path
        self.wsfile = open(path + '/WORKSPACE', 'w')

        #first, we'll check whether the BUILD file exists
        if os.path.isfile(path + '/BUILD'):
            print 'As BUILD file already exists, a backup will be created first.\n' 
            shutil.copyfile(path + '/BUILD', path + '/BUILD.bak')

        self.buildf = open(path + '/BUILD', 'w')

    def generateWSContent(self):
        """ write to the content """
        os.chdir(self.path)
        print "Current working dir is: ", os.getcwd()
        proc = subprocess.Popen(['mvn', 'dependency:list'], stdout=subprocess.PIPE)
        output = proc.stdout.read()
        self.filterMavenOutput(output)

    def destroy(self):
        print "Now let's close the workspace&build files."
        self.wsfile.close()
        self.buildf.close()

    def filterMavenOutput(self, content):
        lineArr = content.split("\n")
        #print "content has lines:", len(lineArr)
        
        #prepare the head for the WORKSPACE file
        self.prepareWorkspaceHeader()

        #prepare the head for the BUILD file
        self.prepareBuildHeader()

        i = 0; #iteration
        dependencyCnt = 0;

        for line in lineArr[0:]:
            #print line
            if line.find("The following files have been resolved:") > 0:
                #print i
                break
            else:
                i = i+1

        for line in lineArr[ (i+1) :]:
            if len(line) < 10:
                break
            else:
                dependencyCnt = dependencyCnt + 1
                self.formatDependencyLine(line)

        print "There are totally " + str(dependencyCnt) + " dependencies found."

        #now write the footer part        
        self.prepareWorkspaceFooter()
        self.prepareBuildFooter()        


    def formatDependencyLine(self, line):
        dependencyArr = line[9:].strip().split(":")
        groupId = dependencyArr[0]
        artifactId = dependencyArr[1]
        version = dependencyArr[3]
        
        #calculate the name
        #self.writeLine("maven_jar(")

        name = "/".join(groupId.split("."))+"/" + artifactId
        artifact = groupId + ":" + artifactId + ":" + version

        print "Generated dependency:" + artifact

        template = 'maven_jar(\n\tname=\"{name}\",\n\tartifact = \"{artifact}\",\n)'
        self.writeLine("# " + artifact)
        self.writeLine(template.format(name = name, artifact = artifact))
        self.writeLineToBuild("\t\t" + "\"@" + name + "//jar\",")

    def prepareWorkspaceHeader(self):
        self.writeLine("# The following dependencies were calculated from:")
        self.writeLine("# "+self.path+"/pom.xml\n")

    def prepareWorkspaceFooter(self):
        """ no operation now """

    def prepareBuildHeader(self):
        self.writeLineToBuild("java_library(")
        self.writeLineToBuild("\tname = \"transitive-deps\",")
        self.writeLineToBuild("\tvisibility = [\"//visibility:public\"],")
        self.writeLineToBuild("\texports = [")

    def prepareBuildFooter(self):
        self.writeLineToBuild("\t],")
        self.writeLineToBuild(")")   

    def writeLineToBuild(self, line):
        self.buildf.write(line)
        self.buildf.write("\n")

    def writeLine(self, line):
        self.wsfile.write(line)
        self.wsfile.write("\n")   

def main():
    print "Please input the path of a maven project:"
    while True:
        path = raw_input().strip()
        if os.path.isdir(path):
            break
        else:
            print "please input valid path of a dir:"

    generator = BazelWSGenerator(path)   
    generator.generateWSContent()
    generator.destroy()


if __name__ == "__main__":
    main()
