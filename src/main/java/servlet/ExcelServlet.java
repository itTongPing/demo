package servlet;

import org.apache.poi.hssf.usermodel.*;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;

public class ExcelServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {



        try{


            HSSFWorkbook workbook = new HSSFWorkbook();
            // 生成一个表格
            HSSFSheet sheet = workbook.createSheet("test");

            String[] headers = {"aaa","bbb","ccc","ddd"};


            HSSFRow row = sheet.createRow(0);
            for (short i = 0; i < headers.length; i++)
            {
                HSSFCell cell = row.createCell(i);
                cell.setCellValue(headers[i]);
            }

            for(int i = 0;i<50000;i++){
                row = sheet.createRow((i+1));
                HSSFCell cell = row.createCell(0);
                cell.setCellValue("aaa"+i);

                cell = row.createCell(1);
                cell.setCellValue("aaa"+i);

                 cell = row.createCell(2);
                cell.setCellValue("aaa"+i);

                 cell = row.createCell(3);
                cell.setCellValue("aaa"+i);

            }


            resp.setContentType("Application/json,charset = UTF-8");



            resp.setContentType("application/octet-stream");
            resp.setHeader("Content-disposition", "attachment; filename=details.xls");


            resp.flushBuffer();
            workbook.write(resp.getOutputStream());



        }catch(Exception e){

        }



    }




 /*   public HSSFWorkbook getHSSFWorkbook() throws Exception{
        HSSFWorkbook workbook = new HSSFWorkbook();
        // 生成一个表格
        HSSFSheet sheet = workbook.createSheet("test");

        String[] headers = {"aaa","bbb","ccc","ddd"};


       HSSFRow row = sheet.createRow(0);
       for (short i = 0; i < headers.length; i++)
       {
           HSSFCell cell = row.createCell(i);
           HSSFRichTextString text = new HSSFRichTextString(headers[i]);
           cell.setCellValue(text);
       }


       OutputStream os = new FileOutputStream("D:\\a.xls");

       return workbook;

    }*/





}
