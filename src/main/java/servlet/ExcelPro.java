package servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ExcelPro extends HttpServlet


{


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.setAttribute("content-type", "application/json");
        System.out.println("enter");
        req.getRequestDispatcher("excel").forward(req, resp);
        System.out.println("exit");
    }
}
