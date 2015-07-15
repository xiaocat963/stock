<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'index.jsp' starting page</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
  </head>
  
  <body>
  	<p align="center" >股票代码：<input type="text" id="stockCode" align="middle" size="5"/>
  	起始日期：<input type="text" id="startDate" align="middle" size="5"/>
  	截止日期：<input type="text" id="endDate" align="middle" size="5"/>
  	<input type="button" value="GO" onclick="refresh()"/>
  	</p>
  	
  	<div id="kmap" style="height:600px;border:1px solid #ccc;padding:10px;"></div>
    <div id="linemap" style="height:600px;border:1px solid #ccc;padding:10px;"></div>
    <p>笔记:</p>
    <textarea rows="30" cols="187"></textarea>
     <script src="${pageContext.request.contextPath }/js/jquery-2.0.3.min.js"></script>
     <script src="${pageContext.request.contextPath }/js/json2.js"></script>
    <script src="${pageContext.request.contextPath }/js/echarts.js"></script>
     <script type="text/javascript">
	     var myChartk;
	     var myChartline;
        require.config({
            paths: {
                echarts: './js'
            }
        });
        require(
            [
                'echarts',
                'echarts/chart/line',   // 按需加载所需图表，如需动态类型切换功能，别忘了同时加载相应图表
                'echarts/chart/k'
            ],
            function (ec) {
            	myChartk = ec.init(document.getElementById('kmap'));            	
                myChartline = ec.init(document.getElementById('linemap'));               
            }
        );
        
        function refresh()
        {
        	var dealCode = document.getElementById("stockCode").value;
        	var startDate = document.getElementById("startDate").value;
        	var endDate = document.getElementById("endDate").value;
        	var targetUrl = "<%=basePath%>echartData?dealCode=" +dealCode+"&startDate="+startDate +"&endDate="+endDate;
    		alert(targetUrl);
    		$.ajax({
     			type: "get",
     			url: targetUrl,
     			success: function(data, textStatus)
     			{
     				if (data!=0)
     				{	
     					alert(data);
     					var str = JSON.parse(data);  
     					alert(str.stockName);
     					myChartk.clear();
      					myChartline.clear();
      					myChartk.setOption({
      	            	    title : {
      	            	        text: str.stockName
      	            	    },
      	            	    tooltip : {
      	            	        trigger: 'axis',
      	            	        formatter: function (params) {
      	            	            var res = params[0].seriesName + ' ' + params[0].name;
      	            	            res += '<br/>  开盘 : ' + params[0].value[0] + '  最高 : ' + params[0].value[3];
      	            	            res += '<br/>  收盘 : ' + params[0].value[1] + '  最低 : ' + params[0].value[2];
      	            	            return res;
      	            	        }
      	            	    },
      	            	    legend: {
      	            	        data:['上证指数']
      	            	    },
      	            	    toolbox: {
      	            	        show : true,
      	            	        feature : {
      	            	            mark : {show: true},
      	            	            dataZoom : {show: true},
      	            	            dataView : {show: true, readOnly: false},
      	            	            magicType: {show: true, type: ['line', 'bar']},
      	            	            restore : {show: true},
      	            	            saveAsImage : {show: true}
      	            	        }
      	            	    },
      	            	    dataZoom : {
      	            	        show : true,
      	            	        realtime: true,
      	            	        start : 50,
      	            	        end : 100
      	            	    },
      	            	    xAxis : [
      	            	        {
      	            	            type : 'category',
      	            	            boundaryGap : true,
      	            	            axisTick: {onGap:false},
      	            	            splitLine: {show:false},
      	            	            data : str.date
      	            	        }
      	            	    ],
      	            	    yAxis : [
      	            	        {
      	            	            type : 'value',
      	            	            scale:true,
      	            	            boundaryGap: [0.01, 0.01]
      	            	        }
      	            	    ],
      	            	    series : [
      	            	        {
      	            	            name:'上证指数',
      	            	            type:'k',
      	            	            data:str.dealPrize    	            	            
      	            	        }
      	            	    ]
      	            	});
      					myChartline.setOption({
                    	    title : {
                    	        text: '未来一周气温变化',
                    	        subtext: str.stockName,
                    	    },
                    	    tooltip : {
                    	        trigger: 'axis'
                    	    },
                    	    legend: {
                    	        data:['每日平均价格','历史平均价格']
                    	    },
                    	    toolbox: {
                    	        show : true,
                    	        feature : {
                    	            mark : {show: true},
                    	            dataView : {show: true, readOnly: false},
                    	            magicType : {show: true, type: ['line', 'bar']},
                    	            restore : {show: true},
                    	            saveAsImage : {show: true}
                    	        }
                    	    },
                    	    calculable : true,
                    	    xAxis : [
                    	        {
                    	            type : 'category',
                    	            boundaryGap : false,
                    	            data : str.date,
                    	        }
                    	    ],
                    	    yAxis : [
                    	        {
                    	            type : 'value',
                    	            axisLabel : {
                    	                formatter: '{value} °C'
                    	            }
                    	        }
                    	    ],
                    	    series : [
                    	        {
                    	            name:'每日平均价格',
                    	            type:'line',
                    	            data:str.average,
                    	            markPoint : {
                    	                data : [
                    	                    {type : 'max', name: '最大值'},
                    	                    {type : 'min', name: '最小值'}
                    	                ]
                    	            }               	            
                    	        },
                    	        {
                    	            name:'历史平均价格',
                    	            type:'line',
                    	            data:str.history
                    	           
                    	        }
                    	    ]
                    	});
     				}
     				else
     				{
     					alert(data);
     				}
     			},
     			error: function(){	
     			}
     		});	
        }
    </script>
  </body>
</html>
