package com.HelloJQuery.controller;

import com.HelloJQuery.Dao.QueryDao;
import com.HelloJQuery.entity.Province;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class QueryProvinceServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String json = "{}";

        //调用QueryDao来获取省份信息
        QueryDao dao = new QueryDao();
        List<Province> provinceList = dao.queryProvinceList();

        //转换为json
        if(provinceList!=null){
            ObjectMapper mapper = new ObjectMapper();
            json = mapper.writeValueAsString(provinceList);
        }
        //响应
        resp.setContentType("application/json; charset = utf-8");
        PrintWriter out = resp.getWriter();
        out.print(json);
        out.flush();

    }
}
