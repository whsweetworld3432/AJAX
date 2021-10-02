package com.HelloJQuery.controller;

import com.HelloJQuery.Dao.QueryDao;
import com.HelloJQuery.entity.City;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class QueryCityServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String json = "{}";
        //获取请求对象的参数信息
        String proId = req.getParameter("proId");
        //获取对应省份的城市
        QueryDao dao = new QueryDao();
        List<City>  cityList = dao.queryCityList(Integer.valueOf(proId));

        //转化json
        if(cityList != null){
            ObjectMapper mapper = new ObjectMapper();
            json = mapper.writeValueAsString(cityList);
        }

        resp.setContentType("application/json; charset = utf-8");
        PrintWriter out = resp.getWriter();
        out.print(json);
        out.flush();
    }
}
