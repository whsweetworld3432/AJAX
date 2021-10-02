package com.HelloAjax.dao;

import com.HelloAjax.entity.Province;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ProvinceDao {
    public Province queryProvinceById(Integer proId){

        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        Province p = new Province();
        try {
            //1.注册驱动
            Class.forName("com.mysql.cj.jdbc.Driver");

            //2.获取连接
            String url = "jdbc:mysql://127.0.0.1:3306/bjpowernode";
            String userName = "root";
            String password = "385024";
            connection = DriverManager.getConnection(url,userName,password);

            //3.获取数据库操作对象
            String sql = "select id,name,jiancheng,shenghui from province where id = ?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,proId.toString());

            //4.执行SQL语句
           resultSet =  preparedStatement.executeQuery();
           //处理查询结果集
            while(resultSet.next()){
                p.setId(Integer.valueOf(resultSet.getString("id")));
                p.setName(resultSet.getString("name"));
                p.setShortName(resultSet.getString("jiancheng"));
                p.setCapital(resultSet.getString("shenghui"));

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            try{
                if(resultSet != null){
                    resultSet.close();
                }
            }catch (Exception e){
                e.printStackTrace();
            }
            try{
                if(preparedStatement != null){
                    preparedStatement.close();
                }
            }catch (Exception e){
                e.printStackTrace();
            }
            try{
                if(connection != null){
                    connection.close();
                }
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        return p;

    }
}
