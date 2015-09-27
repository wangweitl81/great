import subprocess
import os

class BazelWSGenerator(object):
    """docstring for MyStuff"""
    def __init__(self, path):
        self.path = path

    def generateWSContent(self):
        os.chdir(self.path)
        print "Current working dir is: ", os.getcwd()
        proc = subprocess.Popen(['mvn', 'dependency:list'], stdout=subprocess.PIPE)
        output = proc.stdout.read()
        self.filterMavenOutput(output)

    def filterMavenOutput(self, content):
        lineArr = content.split("\n")
        print "content has lines:", len(lineArr)
        i = 0;
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
                self.formatDependencyLine(line)

    def formatDependencyLine(self, line):
        dependencyArr = line[9:].strip().split(":")
        groupId = dependencyArr[0]
        artifactId = dependencyArr[1]
        version = dependencyArr[3]
        
        #calculate the name
        print "/".join(groupId.split("."))+"/" + artifactId
        print groupId + ":" + artifactId + ":" + version

def main():
    print "Please input the path of a maven project:\n"
    path = raw_input()
    generator = BazelWSGenerator(path)   
    generator.generateWSContent()


 #if __name__ == "__main__":
main()
