package com.lwms.api;

import java.io.UnsupportedEncodingException;

import org.junit.Test;

import com.googlecode.protobuf.format.JsonFormat;
import com.lwms.api.APListProtos.AP;

public class ProtobufJavaTest {

  @Test
  public void testSimpleConversion() {
    // Message someProto = SomeProto.getDefaultInstance();
    AP.Builder ap = AP.newBuilder();
    AP.APStatus status = AP.APStatus.valueOf(AP.APStatus.green_VALUE);
    ap.setId(1);
    ap.setIp("172.32.2.3");
    ap.setName("Cupertino-A001");
    ap.setRegion("California");
    ap.setUptime("10h20m");
    ap.setStatus(status);

    String jsonFormat = JsonFormat.printToString(ap.build());
    System.out.println(jsonFormat);
  }
  
  @Test
  public void testStringLength() throws Exception{
//    String src = "你好";
//    System.out.println(src.length());
//    System.out.println(src.getBytes().length);
    
    String s = "中国"; //这是"你好"的gbk编码的字符串
    String ss;
    try {
      byte[] gbkbytes = s.getBytes("gbk");
      ss = new String(s.getBytes("UTF-8"));
      byte[] utf8Bytes = ss.getBytes();
      System.out.println(ss);
    } catch (UnsupportedEncodingException e) {
      e.printStackTrace();
    }
    
    /*String chinese = "中文";//java内部编码
    String gbkChinese = new String(chinese.getBytes("GBK"),"ISO-8859-1");//转换成gbk编码
    String unicodeChinese = new String(gbkChinese.getBytes("ISO-8859-1"),"GBK");//java内部编码
    System.out.println(unicodeChinese);//中文
    String utf8Chinese = new String(unicodeChinese.getBytes("UTF-8"),"ISO-8859-1");//utf--8编码
    System.out.println(utf8Chinese);//乱码
    unicodeChinese = new String(utf8Chinese.getBytes("ISO-8859-1"),"UTF-8");//java内部编码
    System.out.println(unicodeChinese);//中文
*/  }

}
