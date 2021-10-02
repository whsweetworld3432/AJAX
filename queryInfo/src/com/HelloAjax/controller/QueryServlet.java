package com.HelloAjax.controller;

import com.HelloAjax.dao.ProvinceDao;
import com.HelloAjax.entity.Province;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class QueryServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       Province province =null;  //来接受查询结果
        //通过请求对象获取请求参数
       String proId =  req.getParameter("proId");

       //通过调用Dao对象里的 queryProvinceNameById方法 得到 城市id对应的城市名称
        //                      proId.trim().length > 0
        if(proId != null && !"".equals(proId.trim())){
            ProvinceDao dao = new ProvinceDao();
            province = dao.queryProvinceById(Integer.valueOf(proId));
        }
        PrintWriter out = null;
        resp.setContentType("application/json; charset = utf-8");
        out = resp.getWriter();
        //把province 转化为json
        ObjectMapper objectMapper = new ObjectMapper();
        String obJson = objectMapper.writeValueAsString(province);
        out.print(obJson);
        out.flush();
       //通过resp 将结果写入到响应体

    }
}
