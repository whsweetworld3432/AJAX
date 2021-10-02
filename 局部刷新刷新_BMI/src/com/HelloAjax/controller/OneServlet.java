package com.HelloAjax.controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class OneServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //通过请求对象获取参数信息
        System.out.println("hello");

        //
        PrintWriter out = null;
        resp.setContentType("text/jsp; charset = utf-8");
        out = resp.getWriter();


        String name = req.getParameter("name");
        String weight = req.getParameter("weight");
        String height = req.getParameter("height");


        //计算bmi
        float bmi = Float.valueOf(weight) / Float.valueOf(height)/Float.valueOf(height);

        //返回结果
        String msg;
        if(bmi <= 18.5){
            msg = "体重过轻";
        }else if(bmi > 18.5 && bmi <= 23.9){
            msg = "体重正常";
        }else if(bmi > 23.9 && bmi<= 27){
            msg = "体重过重";
        }else if(bmi > 27 && bmi <= 32){
            msg = "体重肥胖";
        }else{
            msg = "体重非常肥胖";
        }
        out.print(name+",你的BMI系数为："+bmi+", "+msg);
        out.flush();
        System.out.println(name+",你的BMI系数为："+bmi+", "+msg);
    }
}
