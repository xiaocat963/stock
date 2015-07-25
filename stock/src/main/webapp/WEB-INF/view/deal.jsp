<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ page isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %> 
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>交易信息</title>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery-2.0.3.min.js"></script>
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
            <td>
           <form name="searchForm" action="${pageContext.request.contextPath}/deal/findAllDeal">
            <div align="right"><span class="STYLE1">
              &nbsp;&nbsp; 股票代码：<input type="text" name="code" value="${criteria.code }"/> 起始日期：<input type="text" name="startDate" value="${criteria.startDate}"/>&nbsp;&nbsp;结束日期：<input type="text" name="endDate" value="${criteria.endDate}"/>&nbsp;&nbsp;<input type="button" name="searchBtn" value="查询"/>  &nbsp;</span><span class="STYLE1"> &nbsp;</span></div>
              <input type="hidden" name="pageNo" value="${pageNo }"/>
              </form>
              </td>
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
        <td height="20" bgcolor="#FFFFFF" class="STYLE6"><div align="center"><span class="STYLE19"><fmt:formatDate value="${deal.date}" pattern="yyyy-MM-dd" /></span></div></td>
        <td height="20" bgcolor="#FFFFFF" class="STYLE19"><div align="center">${deal.volume}</div></td>
        <td height="20" bgcolor="#FFFFFF" class="STYLE19"><div align="center">${deal.turnover}</div></td>
      </tr>
      </c:forEach>
    </table>
    </td>
  </tr>
   <tr>
    <td height="30"><table width="100%" border="0" cellspacing="0" cellpadding="0">
      <tr>
        <td width="33%"><div align="left"><span class="STYLE22"><a name="pre" disabled="true" style="cursor: pointer;">上一页</a>&nbsp;&nbsp;共有<strong>${totalItem}</strong> 条记录，当前第<strong> ${pageNo }</strong> 页，共 <strong>${totalPage}</strong> 页 &nbsp;&nbsp;<a name="after" style="cursor: pointer;">下一页</a></span></div></td>
        <td width="67%"><table width="312" border="0" align="right" cellpadding="0" cellspacing="0">
          <tr>
            <td width="37" class="STYLE22"><div align="center">转到</div></td>
            <td width="22"><div align="center">
              <input type="text" name="goPage" style="width:20px; height:12px; font-size:12px; border:solid 1px #7aaebd;"/>
            </div></td>
            <td width="22" class="STYLE22"><div align="center">页</div></td>
          </tr>
        </table></td>
      </tr>
    </table></td>
  </tr>
</table>

<script type="text/javascript">
$(function(){
	//查询
	$("input[name='searchBtn']").on("click", function(){
		$("input[name='pageNo']").val(1);
		$("form[name='searchForm']").submit();
	});
	
	$("a[name='pre']").on("click", function(){
		var pageNo = ${pageNo};
		if(pageNo == "1"){
			alert("已经是第一页了");
			return false;
		}
		$("input[name='pageNo']").val(parseInt(pageNo) - 1);
		$("form[name='searchForm']").submit();
	});
	
	$("input[name='goPage']").on("keypress", function(e){
		if(e.keyCode == "13"){
			var pageNo = parseInt($(this).val());
			var totalPage = ${totalPage};
			if(pageNo < 1 || pageNo > totalPage){
				alert("输入的页数超出了范围");
				return false;
			}
			$("input[name='pageNo']").val(pageNo);
			$("form[name='searchForm']").submit();;
		}
	});
	
	$("a[name='after']").on("click", function(){
		var pageNo = ${pageNo};
		if(pageNo == "${totalPage}"){
			alert("已经是最后一页了");
			return false;
		}
		$("input[name='pageNo']").val(parseInt(pageNo) + 1);
		$("form[name='searchForm']").submit();
	});
})
</script>
</body>
</html>
