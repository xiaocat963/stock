<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style type="text/css">

body {
	margin-left: 0px;
	margin-top: 0px;
	margin-right: 0px;
	margin-bottom: 0px;
	overflow:hidden;
	height:1000px;
}

</style></head>

<body>
<table width="100%" height="100%" border="0" cellspacing="0" cellpadding="0">
  <tr>
    <td width="8" bgcolor="#353c44">&nbsp;</td>
    <td width="147" valign="top"><iframe height="100%" width="100%" border="0" frameborder="0" src="${pageContext.request.contextPath }/left" name="leftFrame" id="leftFrame" title="leftFrame"></iframe></td>
    <td width="10" bgcolor="#add2da">&nbsp;</td>
    <td valign="top"><iframe height="100%" width="100%" border="0" frameborder="0" src="${pageContext.request.contextPath }/right" name="rightFrame" id="rightFrame" title="rightFrame"></iframe></td>
    <td width="8" bgcolor="#353c44">&nbsp;</td>
  </tr>
</table>
</body>
</html>