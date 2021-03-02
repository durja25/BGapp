package com.example.bgapp.model;

import java.sql.*;


public class sqlcon  {
    /* I dont know how to connect this to the controller needs more research.
        for now i got volly working so what can you do abt it.
        */
    private static String URL_REGIST= "jdbc:mysql://192.168.43.199:3309/bgapp";
    private String User="gk";
    private String Pass="gk";
    public static Connection getMySqlConn() {


        Connection con = null;
        try {
            System.out.println("1111111111111111");
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("22222222222222222222");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3309/bgapp","gk","gk");
            System.out.println("333333333333333");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return con;
    }

    public static void cleanup(Connection con,Statement st,ResultSet rs,PreparedStatement pstmt){


       try {
           if (rs != null)
                rs.close();
           if (st !=null)
                st.close();
           if (con !=null)
               con.close();
            if (con !=null)
                con.close();


           } catch (SQLException e) {
           e.printStackTrace();
       }
    }


    public static void cleanup(Connection con,Statement st){
        try{
            if (st!=null)
            st.close();
            if (con!=null)
            con.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    }
  /*
        Connection con;
        Statement st;
        ResultSet rs;

        try {
            con = sqlcon.getMySqlConn();
            st=con.createStatement();
            String sql="Insert into stud (name,email,password) Values ('1','"+name+"','"+email+"','"+password+"')";
            int rud = st.executeUpdate(sql);
            if (rud==1) {

                System.out.println("rowupdated successfully");//rowupdated
            }else {
                System.out.println("rowupdated failed");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }*/
