<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ page isELIgnored="false" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery-2.0.3.min.js"></script>
</head>
<body>
	<form action="" name="ajaxForm">
		name:<input type="text" name="name"/><br/>
		age:<input type = "text" name="age"/><br/>
		gender:<input type="radio" value="m" name="gender" checked="checked"/>man <input type="radio" value="w" name="gender"/>woman<br/>
		<input id="save" type="button" value="submit">
	</form>
</body>
<script type="text/javascript">
	$(function(){
		$("#save").on("click", function(){
			$.ajax({
				url: "${pageContext.request.contextPath }/userSave",
				method: "POST",
				data: {
					name : $("input[name='name']").val(),
					age : $("input[name='age']").val(),
					gender : $("input[name='gender']:checked").val(),
				},
				dataType: "json",
				success: function(data){
					alert(data);
				},
				error: function(data){
					alert(data.info);
				}
			});
		});
	});
</script>
</html>