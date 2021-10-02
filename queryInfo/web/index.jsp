<%--
  Created by IntelliJ IDEA.
  User: WH
  Date: 2021/9/26
  Time: 21:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>根据省份id获取名称</title>
  </head>
  <script type = "text/javascript">
    function search(){
      //创建异步请求对象
      var xmlHttp = new XMLHttpRequest();

      //绑定事件
      xmlHttp.onreadystatechange = function(){
        if(xmlHttp.readyState == 4 && xmlHttp.status == 200){
          var data = xmlHttp.responseText;
          document.getElementById("proName").value = data;
        }
      }

      //初始化异步对象
      var proId = document.getElementById("proId").value;
      var param = "proId="+proId;
      xmlHttp.open("get","queryInfo?"+param,true);
      //发送请求
      xmlHttp.send();
    }


  </script>
  <body>
  <center>
  <p>根据省份id获取名称</p>
  <table border="2px">
    <tr>
      <td>省份编号：</td>
      <td>
        <input type = "text" name ="id" id = "proId">
        <input type = "button" value = "搜索" onclick = "search()">
      </td>
    </tr>
    <tr>
      <td>省份名称：</td>
      <td><input type = "text" id = "proName"></td>
    </tr>
  </table>
  </center>
  </body>
</html>
