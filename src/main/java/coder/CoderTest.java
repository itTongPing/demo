package coder;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.Arrays;

public class CoderTest {

    public static void main(String[] args) throws UnsupportedEncodingException {


        String s1 = URLEncoder.encode("中文", "utf-8");
        String s3 = new String("中文".getBytes("utf-8"));
        byte[] bytes = "中文".getBytes("utf-8");


        System.out.println(Arrays.toString(bytes)+"----");



        System.out.println("对中文编码结果"+s1);
        System.out.println("s3"+s3);
        //编码
        String s = URLDecoder.decode("%E4%B8%AD%E6%96%87", "iso-8859-1");
        System.out.println("对中文解码结果"+s);


        String s2 = URLDecoder.decode("", "UTF-8");
        System.out.println("对中文解码结果"+s2);

    }


}
