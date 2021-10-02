<%--
  Created by IntelliJ IDEA.
  User: WH
  Date: 2021/9/28
  Time: 9:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>省市级联查询</title>
  </head>
  <script type = "text/javascript" src = "js/jquery-3.4.1.js"></script>
  <script type = "text/javascript">
    //封装Ajax操作
    function dataLoadAjax(){
      $.ajax({
        url:"queryProvinces",
        dataType:"json",
        success:function(data){
          //先删除子对象旧数据
          $("#province").empty();
          $.each(data,function(index, element){
            $("#province").append("<option value = "+element.id+'>'+element.name+"</option");
          })
        }
      })
    }
    $(function(){
        dataLoadAjax();
        //绑定事件
        $("#btnLoad").click(function(){
          //ajax请求
          dataLoadAjax();
        })
          //绑定改变事件
        $("#province").change(function(){
            //获得id
          var id = $("#province>option:selected").val();
          $.get("queryCitys",{"proId":id},callback,"json")
        })
    })
    function callback(data){
      $("#city").empty();
      $.each(data,function(index,element){
        $("#city").append("<option value = "+element.id+">"+element.name+"</option>");
      })
    }
  </script>
  <body>
  <div>
    <table border="2px">
      <tr>
        <td>省份</td>
        <td>
          <select id = "province">
            <option value ="0" selected>----请选择----</option>
          </select>
        </td>
        <td><input type = "button" value = "加载" id = "btnLoad"></td>
      </tr>
      <tr>
        <td>城市:</td>
        <td>
          <select id = "city">
            <option value = "0">----请选择----</option>
          </select>
        </td>
      </tr>
    </table>
  </div>
  </body>
</html>
