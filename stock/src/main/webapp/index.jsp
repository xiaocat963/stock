<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>用户登录</title>
<style type="text/css">
	#formDiv{
		position: absolute;                    /*绝对定位*/   
		top: 50%;                              /* 距顶部50%*/   
		left: 50%;                             /* 距左边50%*/   
		height: 200px;  margin-top: -100px;    /*margin-top为height一半的负值*/   
		width: 400px;  margin-left: -200px;    /*margin-left为width一半的负值*/   
	}
</style>
</head>
<body>
    <div id="formDiv">
		<form action="<%=basePath%>login.do" method="post">
			 <fieldset>
			    <span style="color: red">${param.info }</span>
			    <legend>用户登录</legend>
		    	<table>
			    	<tr>
			    		<td>用户名：</td>
			    		<td><input type="text" name="username"/></td>
			    	</tr>
			    	<tr>
			    		<td>密&nbsp;码：</td>
			    		<td><input type="password" name="password"/></td>
			    	</tr>
			    	<tr>
			    		<td colspan="2" style="text-align: center;"><input type="submit" value="登录"></td>
			    	</tr>
		   	 	</table>
	   	 	</fieldset>
		</form>
    </div>
</body>
</html>