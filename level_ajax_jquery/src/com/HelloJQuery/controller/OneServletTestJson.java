package com.HelloJQuery.controller;

import com.HelloJQuery.entity.Student;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class OneServletTestJson extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //

        Student student = new Student();
        student.setId(1001);
        student.setName("王话");
        student.setAge(20);

        Student student1 = new Student();
        student1.setName("王画");
        student1.setAge(21);
        student1.setId(1002);
        List<Student> studentList =  new ArrayList<>();
        studentList.add(student);;
        studentList.add(student1);;

        String json = "{}";
        ObjectMapper obj = new ObjectMapper();
        resp.setContentType("application/json; charset = utf-8");
        json =  obj.writeValueAsString(studentList);
       //{"key1":{"id":?,"name":"?","age":?},"key2":{"id":?,"name":"?","age":?}}
        String str = "{\"key1\":{\"id\":"+student.getId()+",\"name\":\""+student.getName()+"\",\"age\":"+student.getAge()+"},\"key2\":{\"id\":"+student1.getId()+",\"name\":\""+student1.getName()+"\",\"age\":"+student1.getAge()+"}}";
        resp.getWriter().print(str);
    }
}
