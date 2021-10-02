<%--
  Created by IntelliJ IDEA.
  User: WH
  Date: 2021/10/2
  Time: 9:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>json</title>
</head>
<body>
<script type = "text/javascript" src = "js/jquery-3.4.1.js"></script>
<script type = "text/javascript">
   $(function (){
       $.ajax({
           url:"onesJson",
           type:"get",
           dataType:"json",
           success:function(data){
                alert(data.key1.id);
           }
       })
   })
</script>
</body>
</html>
