<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ page isELIgnored="false" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>公司基本信息</title>
<style type="text/css">
body {
	margin-left: 3px;
	margin-top: 0px;
	margin-right: 3px;
	margin-bottom: 0px;
}
.STYLE1 {
	color: #e1e2e3;
	font-size: 12px;
}
.STYLE6 {color: #000000; font-size: 12; }
.STYLE10 {color: #000000; font-size: 12px; }
.STYLE19 {
	color: #344b50;
	font-size: 12px;
}
.STYLE21 {
	font-size: 12px;
	color: #3b6375;
}
.STYLE22 {
	font-size: 12px;
	color: #295568;
}
#addCompanyDiv{
	display: none;
	position:absolute;	
	width:600px;
	heigth:400px;
	z-index:200;
	background:#fff;
}
#editCompanyDiv{
	display: none;
	position:absolute;	
	width:600px;
	heigth:400px;
	z-index:200;
	background:#fff;
}
#greybackground{
	background:#000;
	display:block;
	width:100%;
	z-index:100;
	position:absolute;
	top:0;
	left:0;
}
</style>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery-2.0.3.min.js"></script>


</head>

<body>
<table width="100%" border="0" align="center" cellpadding="0" cellspacing="0">
  <tr>
    <td height="30"><table width="100%" border="0" cellspacing="0" cellpadding="0">
      <tr>
        <td height="24" bgcolor="#353c44"><table width="100%" border="0" cellspacing="0" cellpadding="0">
          <tr>
            <td><table width="100%" border="0" cellspacing="0" cellpadding="0">
              <tr>
                <td width="6%" height="19" valign="bottom"><div align="center"><img src="${pageContext.request.contextPath}/images/tb.gif" width="14" height="14" /></div></td>
                <td width="94%" valign="bottom"><span class="STYLE1"> 公司基本信息列表</span></td>
              </tr>
            </table></td>
            <td><div align="right"><span class="STYLE1">
              <input type="checkbox" name="checkbox11" id="checkbox11" />
              全选      &nbsp;&nbsp;<a id="addCompany" style="cursor: pointer;"><img src="${pageContext.request.contextPath}/images/add.gif" width="10" height="10" /> 添加  </a> &nbsp; <a id="delCompany"  style="cursor: pointer;"><img src="${pageContext.request.contextPath}/images/del.gif" width="10" height="10" /> 删除</a>    &nbsp;&nbsp;<a id="editCompany" style="cursor: pointer;"><img src="${pageContext.request.contextPath}/images/edit.gif" width="10" height="10" /> 编辑</a>   &nbsp;&nbsp;<a id="searchCompany" style="cursor: pointer;"><img src="${pageContext.request.contextPath}/images/add.gif" width="10" height="10" /> 查询</a>   &nbsp;</span><span class="STYLE1"> &nbsp;</span></div></td>
          </tr>
        </table></td>
      </tr>
    </table></td>
  </tr>
  <tr>
    <td><table width="100%" border="0" cellpadding="0" cellspacing="1" bgcolor="#a8c7ce">
      <tr>
        <td width="4%" height="20" bgcolor="d3eaef" class="STYLE10"><div align="center">
          <input type="checkbox" name="checkbox" id="checkbox" style ="display:none"/>
        </div></td>
        <td width="10%" height="20" bgcolor="d3eaef" class="STYLE6"><div align="center"><span class="STYLE10">公司代码</span></div></td>
        <td width="15%" height="20" bgcolor="d3eaef" class="STYLE6"><div align="center"><span class="STYLE10">公司名称</span></div></td>
        <td width="14%" height="20" bgcolor="d3eaef" class="STYLE6"><div align="center"><span class="STYLE10">公司状态</span></div></td>
        <td width="14%" height="20" bgcolor="d3eaef" class="STYLE6"><div align="center"><span class="STYLE10">基本操作</span></div></td>
      </tr>
      <c:forEach items = "${itemList}" var = "company" >
      <tr>
        <td height="20" bgcolor="#FFFFFF"><div align="center">
          <input type="checkbox" name = "companyId" value = "${company.companyId}"/>
        </div></td>
        <td height="20" bgcolor="#FFFFFF" class="STYLE6"><div align="center"><span class="STYLE19">${company.code}</span></div></td>
        <td height="20" bgcolor="#FFFFFF" class="STYLE19"><div align="center">${company.name}</div></td>
        <td height="20" bgcolor="#FFFFFF" class="STYLE19"><div align="center"><input type = "hidden" value = "${company.status}"/><c:if test="${company.status==1}">开放</c:if><c:if test="${company.status==0}">关闭</c:if></div></td>
        <td height="20" bgcolor="#FFFFFF"><div align="center" class="STYLE21"><a name='deleteCompany' style="cursor: pointer;">删除 </a></div></td>
      </tr>
      </c:forEach>
    </table>
    </td>
  </tr>
  <tr>
    <td height="30"><table width="100%" border="0" cellspacing="0" cellpadding="0">
      <tr>
        <td width="33%"><div align="left"><span class="STYLE22">&nbsp;&nbsp;&nbsp;&nbsp;共有<strong> 243</strong> 条记录，当前第<strong> 1</strong> 页，共 <strong>10</strong> 页</span></div></td>
        <td width="67%"><table width="312" border="0" align="right" cellpadding="0" cellspacing="0">
          <tr>
<%--             <td width="49"><div align="center"><img src="${pageContext.request.contextPath}/images/main_54.gif" width="40" height="15" /></div></td> --%>
<%--             <td width="49"><div align="center"><img src="${pageContext.request.contextPath}/images/main_56.gif" width="45" height="15" /></div></td> --%>
<%--             <td width="49"><div align="center"><img src="${pageContext.request.contextPath}/images/main_58.gif" width="45" height="15" /></div></td> --%>
<%--             <td width="49"><div align="center"><img src="${pageContext.request.contextPath}/images/main_60.gif" width="40" height="15" /></div></td> --%>
            <td width="37" class="STYLE22"><div align="center">转到</div></td>
            <td width="22"><div align="center">
              <input type="text" name="textfield" id="textfield"  style="width:20px; height:12px; font-size:12px; border:solid 1px #7aaebd;"/>
            </div></td>
            <td width="22" class="STYLE22"><div align="center">页</div></td>
<%--             <td width="35"><img src="${pageContext.request.contextPath}/images/main_62.gif" width="26" height="15" /></td> --%>
          </tr>
        </table></td>
      </tr>
    </table></td>
  </tr>
</table>
<div id="addCompanyDiv">
	公司代码：<input  type="text" name ="addCode"/><br/><br />
 	公司名称：<input  type="text" name ="addName"/><br/><br />
 	公司状态：<input type="radio" name="addStatus" value="1" checked="checked"/>&nbsp;开放&nbsp;&nbsp;&nbsp;<input type="radio" name="addStatus" value="0"/>&nbsp;关闭<br /><br />
 	<input type="button" id="save" value="保存"/>&nbsp;&nbsp;&nbsp;<input type="button" id="addCancel" value="取消"/>
</div>
<div id="editCompanyDiv">
	<input id ="editCompanyId" type="hidden" name ="editCompanyId" />
	公司代码：<input id = "editCode" type="text" name ="editCode"/><br/><br />
 	公司名称：<input id = "editName" type="text" name ="editName"/><br/><br />
	 公司状态：<input type="radio" name="editStatus" value="1" checked="checked"/>&nbsp;开放&nbsp;&nbsp;&nbsp;<input type="radio" name="editStatus" value="0"/>&nbsp;关闭<br/><br />
	<input type="button" id="edit" value="保存"/>&nbsp;&nbsp;&nbsp;<input type="button" id="editCancel" value="取消"/>
</div>
<script type="text/javascript">
$(function(){
	var screenwidth,screenheight,mytop,getPosLeft,getPosTop;
	screenwidth = $(window).width();
	screenheight = $(window).height();
	mytop = $(document).scrollTop();
 	getPosLeft = screenwidth/2 - 260;
	getPosTop = screenheight/2 - 150;
	$("#addCompanyDiv").css({"left":getPosLeft,"top":getPosTop});
	$("#editCompanyDiv").css({"left":getPosLeft,"top":getPosTop});
	$(window).resize(function(){
		screenwidth = $(window).width();
		screenheight = $(window).height();
		mytop = $(document).scrollTop();
		getPosLeft = screenwidth/2 - 260;
		getPosTop = screenheight/2 - 150;
		$("#addCompanyDiv").css({"left":getPosLeft,"top":getPosTop+mytop});
		$("#editCompanyDiv").css({"left":getPosLeft,"top":getPosTop+mytop});
	});
	$(window).scroll(function(){
		screenwidth = $(window).width();
		screenheight = $(window).height();
		mytop = $(document).scrollTop();
		getPosLeft = screenwidth/2 - 260;
		getPosTop = screenheight/2 - 150;
		$("#addCompanyDiv").css({"left":getPosLeft,"top":getPosTop+mytop});
		$("#editCompanyDiv").css({"left":getPosLeft,"top":getPosTop+mytop});
	}); 
	$("#addCompany").click(function(){
		//alert("open");
		$("#addCompanyDiv").fadeIn("fast");
		$("body").append("<div id='greybackground'></div>");
		var documentheight = $(document).height();
		$("#greybackground").css({"opacity":"0.5","height":documentheight});
		return false;
	});
	$("#editCompany").click(function(){
		var editPoint = $("input[name = 'companyId']:checked");
		//alert(editPoint.length);
		if(editPoint.length > 1){
			alert("只能对单条记录进行修改，您当前选中了多条记录！！");
			return;
		}
		if(editPoint.length == 0){
			alert("请选择要修改的记录！！");
			return;
		}
		var company = editPoint.parent().parent().parent();
		var info = company.find("td");
		$("#editCompanyId").val($(info[0]).find("input[name = 'companyId']").val());
		$("#editCode").val($(info[1]).find("span").html());
		$("#editName").val($(info[2]).find("div").html());
		alert($(info[1]).find("span").html());
		$("input[name = 'editStatus']").each(function(i,element){
			if(element.value == $(info[3]).find("input").val()){
				element.checked="checked";
			}
		});
		$("#editCompanyDiv").fadeIn("fast");
		$("body").append("<div id='greybackground'></div>");
		var documentheight = $(document).height();
		$("#greybackground").css({"opacity":"0.5","height":documentheight});
		return false;
	});
	$("#editCancel").click(function() {
		$("#editCompanyDiv").hide();
		$("#greybackground").remove();
		return false;
	});
	$("#addCancel").click(function() {
		$("#addCompanyDiv").hide();
		$("#greybackground").remove();
		return false;
	});
	
	$("a[name='deleteCompany']").on("click",function(){
		var parentPoint = $(this).parent("div").parent().parent();
		var childPoint = parentPoint.find("input[name = 'companyId']");
		$.ajax({
			url:"${pageContext.request.contextPath}/company/deleteCompany",
			method:"POST",
			data:{
				companyId:childPoint.val(),
			},
			dataType:"json",
			success:function(data){
				if(data.code == 200){
					alert("删除成功！");
					parentPoint.remove();
				}else{
					alert("删除失败！");
				}
			}
		}); 
	});

	$("#save").on("click",function(){
		var code = $("input[name='addCode']").val().trim();
		var name = $("input[name='addName']").val().trim();
		if(code == ""|| name ==""){
			alert("公司代码或公司名称不能为空！！！");
			return;
		}
		$.ajax({
			url:"${pageContext.request.contextPath}/company/addCompany",
			method:"POST",
			data:{
				code:code,
				name:name,
				status:$("input[name='addStatus']:checked").val(),
			},
			dataType:"json",
			success:function(data){
				//alert(info);
				 if(data.code == 200){
					alert("保存成功");
				}else if(data.code == 100){
					alert("该公司信息已存在，请核对信息后再保存！！");
				}else{
					alert("保存失败");
				} 
			},
			error:function(e)
			{
				//alert(e);
				console.log(e);
			}
		});
	});
	$("#edit").on("click",function(){
		var code = $("input[name='editCode']").val().trim();
		var name = $("input[name='editName']").val().trim();
		if(code == ""|| name ==""){
			alert("公司代码或公司名称不能为空！！！");
			return;
		}
		//alert($("input[name='editStatus']:checked").val());
		$.ajax({
			url:"${pageContext.request.contextPath}/company/editCompany",
			method:"POST",
			data:{
				companyId:$("#editCompanyId").val(),
				code:code,
				name:name,
				status:$("input[name='editStatus']:checked").val(),
			},
			dataType:"json",
			success:function(data){
				//alert(info);
				 if(data.code == 200){
					alert("保存成功");
				}else if(data.code == 100){
					alert("该公司代码已存在，请核对信息后再保存！！");
				}else{
					alert("保存失败");
				} 
			},
			error:function(e)
			{
				console.log(e);
			}
		});
	});
});

/* function deleteFunction(){
	alert($(this).parent().html());
	 $.ajax({
		url:"${pageContext.request.contextPath}/company/deleteCompany",
		method:"POST",
		data:{
			company:obj,
		},
		dataType:"json",
		success:function(data){
			if(data.code == 200){
				alert("删除成功！");
			}else{
				alert("删除失败！");
			}
		}
	}); 
} */
</script>
</body>
</html>
