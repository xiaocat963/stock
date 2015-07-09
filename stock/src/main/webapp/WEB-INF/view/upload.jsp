<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>  
    <head>  
        <title>Upload a file please</title>  
    </head>  
    <body>  
        <h1>Please upload a file</h1>  
        <form method="post" action="<%=basePath%>importCompany" enctype="multipart/form-data">  
            <input type="text" name="name"/>  
            <input type="file" name="file"/>  
            <input type="submit"/>  
        </form>  
    </body>  
</html>  