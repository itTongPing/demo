<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.Map" %>
<%@ page import="java.util.HashMap" %>
<%@ page import="com.alibaba.fastjson.JSON" %><%--
  Created by IntelliJ IDEA.
  User: ping.tong
  Date: 3/8/2019
  Time: 11:15 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<script src ="js/jquery-3.3.1.js"></script>

<%

      List list =  new ArrayList();

      Map map1 = new HashMap();

      map1.put("name", "张三");
      map1.put("age","40");



      Map map2 = new HashMap();
      map2.put("name", "李四");
      map2.put("age","35");

     list.add(map1);list.add(map2);

      String json = JSON.toJSONString(list);

      out.write(json);
      System.out.println(json);

%>
