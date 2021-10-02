<%--
  Created by IntelliJ IDEA.
  User: WH
  Date: 2021/9/26
  Time: 19:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>局部刷新-ajax</title>
  </head>
  <script type = "text/javascript">
    window.onload = function(){
      //使用内存中的异步对象，代替浏览器发起请求，异步对象使用js创建和管理
      document.getElementById("btn").onclick =  function(){

        //1.创建异步对象
        var xmlHttp = new XMLHttpRequest();
        //2.绑定事件
        xmlHttp.onreadystatechange = function (){
          //处理服务器端返回的数据，更新当前页面
          if(xmlHttp.readyState == 4 && xmlHttp.status == 200){
              var data = xmlHttp.responseText;
              document.getElementById("myText").innerText = data;
          }
        }
        //3.初始化请求数据
        var name = document.getElementById("name").value;
        var weight = document.getElementById("weight").value;
        var height = document.getElementById("height").value;
        var param = "name="+name+"&weight="+weight+"&height="+height;
        //  alert(param);
        xmlHttp.open("get","one?"+param,true);
        //4.发送请求
        xmlHttp.send();
      }
    }

  </script>
  <body>
  <p>局部刷新ajax-计算bmi</p>
  <div>
    姓名：<input type = "text" name = "name" id = "name"><br>
    体重：<input type = "text" name = "weight" id = "weight"><br>
    身高：<input type = "text" name = "height"  id = "height"><br>
    <input type = "button" value = "计算bmi"  id = "btn">
  </div>
  <div id = "myText">

  </div>
  </body>
</html>
