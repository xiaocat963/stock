<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ page isELIgnored="false" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>交易信息</title>
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
                <td width="94%" valign="bottom"><span class="STYLE1"> 交易信息列表</span></td>
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
        <td width="10%" height="20" bgcolor="d3eaef" class="STYLE6"><div align="center"><span class="STYLE10">股票代码</span></div></td>
        <td width="15%" height="20" bgcolor="d3eaef" class="STYLE6"><div align="center"><span class="STYLE10">开盘</span></div></td>
        <td width="14%" height="20" bgcolor="d3eaef" class="STYLE6"><div align="center"><span class="STYLE10">收盘</span></div></td>
        <td width="14%" height="20" bgcolor="d3eaef" class="STYLE6"><div align="center"><span class="STYLE10">最高</span></div></td>
        <td width="14%" height="20" bgcolor="d3eaef" class="STYLE6"><div align="center"><span class="STYLE10">最低</span></div></td>
        <td width="14%" height="20" bgcolor="d3eaef" class="STYLE6"><div align="center"><span class="STYLE10">日期</span></div></td>
     	<td width="14%" height="20" bgcolor="d3eaef" class="STYLE6"><div align="center"><span class="STYLE10">交易量</span></div></td>
     	<td width="14%" height="20" bgcolor="d3eaef" class="STYLE6"><div align="center"><span class="STYLE10">交易额</span></div></td>
      </tr>
      <c:forEach items = "${itemList}" var = "deal" >
      <tr>
     	<td height="20" bgcolor="#FFFFFF" class="STYLE6"><div align="center"><span class="STYLE19">${deal.code}</span></div></td>
        <td height="20" bgcolor="#FFFFFF" class="STYLE6"><div align="center"><span class="STYLE19">${deal.open}</span></div></td>
        <td height="20" bgcolor="#FFFFFF" class="STYLE6"><div align="center"><span class="STYLE19">${deal.close}</span></div></td>
        <td height="20" bgcolor="#FFFFFF" class="STYLE6"><div align="center"><span class="STYLE19">${deal.high}</span></div></td>
        <td height="20" bgcolor="#FFFFFF" class="STYLE6"><div align="center"><span class="STYLE19">${deal.low}</span></div></td>
        <td height="20" bgcolor="#FFFFFF" class="STYLE19"><div align="center">${deal.valume}</div></td>
        <td height="20" bgcolor="#FFFFFF" class="STYLE19"><div align="center">${deal.turnover}</div></td>
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
            <td width="37" class="STYLE22"><div align="center">转到</div></td>
            <td width="22"><div align="center">
              <input type="text" name="textfield" id="textfield"  style="width:20px; height:12px; font-size:12px; border:solid 1px #7aaebd;"/>
            </div></td>
            <td width="22" class="STYLE22"><div align="center">页</div></td>
          </tr>
        </table></td>
      </tr>
    </table></td>
  </tr>
</table>

<script type="text/javascript">
</script>
</body>
</html>
