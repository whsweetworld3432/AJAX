package com.HelloAjax.controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class BmiServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //通过请求对象获取参数信息（请求行）
        String name = req.getParameter("userName");
        String weight = req.getParameter("weight");
        String height = req.getParameter("height");
        PrintWriter out = null;
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
//        System.out.println("您的BMI系数为："+bmi+", "+msg);
//        resp.setContentType("text/html; charset =utf-8");
//        out = resp.getWriter();
//        out.print("<font style = 'color:red; font-size:40px'>"+"您的BMI系数为："+bmi+","+msg+"<font>");
        //把结果写入到request  请求转发
        req.setAttribute("msg",msg);
        req.getRequestDispatcher("/result.jsp").forward(req,resp);
    }
}
