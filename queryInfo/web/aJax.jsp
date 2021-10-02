<%--
  Created by IntelliJ IDEA.
  User: WH
  Date: 2021/9/27
  Time: 8:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>aJax请求使用json</title>
</head>

<script type = "text/javascript">
    window.onload = function (){
        document.getElementById("search").onclick = function(){
            //创建异步请求对象 XMLHttpRequest
            var xmlHttp = new XMLHttpRequest();
            //绑定事件
            xmlHttp.onreadystatechange = function(){
                //根据请求状态的变化来处理
                if(xmlHttp.readyState == 4 && xmlHttp.status == 200){
                    var data = xmlHttp.responseText;
                    var jsonObject = eval("("+data+")");
                  //更行页面
                    document.getElementById("proName").value = jsonObject.name;
                    document.getElementById("shortName").value = jsonObject.shortName;
                    document.getElementById("capital").value = jsonObject.capital;
                }
            }

            //初始化异步请求对象
            var method = "get";
            var proId = document.getElementById("proId").value;


            var url = "queryInfo?"+"proId="+proId;
            xmlHttp.open(method,url,true);
            //发送请求
            xmlHttp.send();
        }

    }
</script>
<body>
<center>
    <p style="border: red; size: 40px">aJax请求使用json</p>
    <table border="2px">
        <tr>
            <th>省份编号:</th>
            <th><input type = "text" id= "proId"></th>
            <th><input type = "button" value = "搜索" id = "search"></th>
        </tr>
        <tr>
            <th>省份名称:</th>
            <th><input type = "text" id="proName"></th>
        </tr>
        <tr>
            <th>省份简称:</th>
            <th><input type = "text" id="shortName"></th>
        </tr>
        <tr>
            <th>省会城市:</th>
            <th><input type = "text" id="capital"></th>
        </tr>
    </table>
</center>

</body>
</html>
