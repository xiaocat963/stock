<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ page isELIgnored="false" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
	<frameset rows="127,*,11" frameborder="no" border="0" framespacing="0">
		<frame src="${pageContext.request.contextPath }/top" name="topFrame" scrolling="no"
			noresize="noresize" id="topFrame" />
		<frame src="${pageContext.request.contextPath }/center" name="mainFrame" id="mainFrame" />
		<frame src="${pageContext.request.contextPath }/down" name="bottomFrame" scrolling="no"
			noresize="noresize" id="bottomFrame" />
	</frameset>
<noframes>
<body>
</body>
</noframes>
</html>