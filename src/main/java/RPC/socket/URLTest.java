package RPC.socket;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

public class URLTest
{

    public static void main(String[] args) throws Exception {
        //创建一个URL的实例
        URL baidu =new URL("http://www.baidu.com");
        URL url =new URL(baidu,"/index.html?username=tom#test");//？表示参数，#表示锚点
        String protocol = url.getProtocol();//获取协议
        url.getHost();//获取主机
        url.getPort();//如果没有指定端口号，根据协议不同使用默认端口。此时getPort()方法的返回值为 -1
        url.getPath();//获取文件路径
        url.getFile();//文件名，包括文件路径+参数
        url.getRef();//相对路径，就是锚点，即#号后面的内容
        url.getQuery();//查询字符串，即参数
        System.out.println(protocol);

        //获取网页信息
        InputStream is = baidu.openStream();

        InputStreamReader isr = new InputStreamReader(is,"UTF-8");

        BufferedReader br = new BufferedReader(isr);

        String data = br.readLine();//读取数据
        while(data!=null){
            System.out.println(data);//输出数据
            data = br.readLine();
        }
        br.close();
        isr.close();
        is.close();


    }
}
