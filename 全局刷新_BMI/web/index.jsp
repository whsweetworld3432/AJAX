<%--
  Created by IntelliJ IDEA.
  User: WH
  Date: 2021/9/26
  Time: 17:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>全局刷新BMI</title>
  </head>
  <body>
 <p>BMI</p>
 <center>
    <form action = "/bmi" method="get">
      姓名<input type = "text" name = "userName"><br>
      体重<input type = "text" name = "weight"><br>
      身高<input type = "text" name ="height"><br>
      <input type = submit value="测试"><br>
    </form>
 </center>
  </body>
</html>
