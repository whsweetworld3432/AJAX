package com.HelloAjax.util;

import com.HelloAjax.entity.Province;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class TestJson {
    public static void main(String[] args) throws JsonProcessingException {
        Province p = new Province();
        p.setId(1);
        p.setName("河北");
        p.setShortName("冀");
        p.setCapital("石家庄");

        //使用Jackson 把 p转换为json
        ObjectMapper objectMapper = new ObjectMapper();

        String objectJson = objectMapper.writeValueAsString(p);  //要抛出异常

        System.out.println("转化的Json == "+objectJson);
    }
}
