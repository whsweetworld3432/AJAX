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
<script type = "text/javascript" src = "js/jquery-3.4.1.js"></script>
<script type = "text/javascript">
    $(function(){
        $("#search").click(function(){
            //获取请求参数
            var proId = $("#proId").val();
            //JQuery的Ajax请求
            $.ajax({
                url:"queryInfo",
                type:"get",
                data:{
                    "proId":proId
                },
                dataType:"json",
                success:function(data){
                    $("#proName").val(data.name);
                    $("#shortName").val(data.shortName);
                    $("#capital").val(data.capital);
                }
            })
        })

    })


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
