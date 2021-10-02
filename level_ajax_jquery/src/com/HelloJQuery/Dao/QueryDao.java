package com.HelloJQuery.Dao;

import com.HelloJQuery.entity.City;
import com.HelloJQuery.entity.Province;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class QueryDao {
    private Connection connection = null;
    private PreparedStatement preparedStatement = null;
    private ResultSet resultSet = null;
    private String url = "jdbc:mysql://127.0.0.1:3306/bjpowernode";
    private String userName = "root";
    private String password = "385024";

    //查询所有省份信息
    public List<Province> queryProvinceList(){
        List<Province> provinces = new ArrayList<>();
        Province p;
       //JDBC
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            connection = DriverManager.getConnection(url,userName,password);

            String sql = "select id, name, jiancheng, shenghui from province order by id";

            preparedStatement = connection.prepareStatement(sql);

            resultSet = preparedStatement.executeQuery();

            //初始化实体类
            while(resultSet.next()){
                p = new Province();
                p.setId(resultSet.getInt("id"));
                p.setName(resultSet.getString("name"));
                p.setShortName(resultSet.getString("jiancheng"));
                p.setCapital(resultSet.getString("shenghui"));

                provinces.add(p);
            }


        } catch (Exception e) {
            e.printStackTrace();
        }finally {
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
            }try{
                if(connection != null){
                    connection.close();
                }
            }catch (Exception e){
                e.printStackTrace();
            }

        }

    return provinces;
    }

    public List<City> queryCityList(Integer cId){
        List<City> citys = new ArrayList<>();
        City city;
        //JDBC
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            connection = DriverManager.getConnection(url,userName,password);

            String sql = "select id, name from city where provinceId = ?";

            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1,cId);
            resultSet = preparedStatement.executeQuery();

            //初始化实体类
            while(resultSet.next()){
                city = new City();
                city.setId(resultSet.getInt("id"));
                city.setName(resultSet.getString("name"));
                citys.add(city);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }finally {
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
            }try{
                if(connection != null){
                    connection.close();
                }
            }catch (Exception e){
                e.printStackTrace();
            }

        }

        return citys;
    }
}
