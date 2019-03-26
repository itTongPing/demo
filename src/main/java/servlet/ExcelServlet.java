package servlet;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.applet.Applet;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;

public class ExcelServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        resp.setContentType("text/x-xlw;charset=UTF-8");
        FileInputStream fis = new FileInputStream("D:\\code\\document.txt");
        byte[] bytes = new byte[1024];
        ServletOutputStream out = resp.getOutputStream();

        int length = 0;
        while((length = fis.read(bytes))!=-1){
       out.write(bytes);
        }

        out.close();


    }





}
