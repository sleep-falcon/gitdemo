package Mysqljdbc;

import java.sql.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

//商家的
public class test {
    static String pro[]= new String[5];

    static {
        pro[0]="BusinessID";
        pro[1]="BusinessCode";
        pro[2]="BusinessName";
        pro[3]="BusinessInfor";
        }


    public static  int logcheck(int loginName,String loginpwd)
    {
        //管理员1，商家2，无0
        int loginsuccess = 0;
        Connection conn = null;
        ResultSet rs = null;
        PreparedStatement ps = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            final String DB_URL = "jdbc:mysql://localhost:3306/mydb?useUnicode=true&characterEncoding=UTF-8&useSSL=false&serverTimezone=UTC";
            conn = (Connection)DriverManager.getConnection(DB_URL,"root","root");
            String sql = "select * from Administrators where AdministratorsID = ? and AdministratorsCode = ?";
            ps = conn.prepareStatement(sql);
            ps.setInt(1, loginName);
            ps.setString(2, loginpwd);
            rs = ps.executeQuery();
            if(rs.next())
            {
                loginsuccess = 1;
            }
            else
            {
                sql = "select * from Business where BusinessID = ? and BusinessCode = ?";
                ps = conn.prepareStatement(sql);
                ps.setInt(1, loginName);
                ps.setString(2, loginpwd);
                rs = ps.executeQuery();
                if(rs.next())
                {
                    loginsuccess = 2;
                }
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        if(rs!=null)
        {
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if(ps!=null)
        {
            try {
                ps.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if(conn!=null)
        {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return loginsuccess;
    }


    public static  int delete(String id,String table)
    {
        //成功1，失败0
        int loginsuccess = 0;
        Connection conn = null;
        Statement stmt = null;
        int i = -1;
        try{
            i = Integer.parseInt(id);
        }
        catch(Exception e1) {
            return 0;
        }
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            final String DB_URL = "jdbc:mysql://localhost:3306/mydb?useUnicode=true&characterEncoding=UTF-8&useSSL=false&serverTimezone=UTC";
            conn = (Connection)DriverManager.getConnection(DB_URL,"root","root");
            String sql = "delete from "+table+" where "+table+"ID"+"="+ i;
            stmt = conn.createStatement();
            int a = stmt.executeUpdate(sql);
            if(a>0)
                    loginsuccess = 1;
                else
                    loginsuccess = 0;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        if(stmt!=null)
        {
            try {
                stmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if(conn!=null)
        {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return loginsuccess;
    }

    public static  int insert(String[] str)
    {
        //成功1，失败0
        int loginsuccess = 0;
        Connection conn = null;
        Statement stmt = null;
        int i = -1;
        try{
            i = Integer.parseInt(str[0]);
        }
        catch(Exception e1) {
            return 0;
        }
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            final String DB_URL = "jdbc:mysql://localhost:3306/mydb?useUnicode=true&characterEncoding=UTF-8&useSSL=false&serverTimezone=UTC";
            conn = (Connection)DriverManager.getConnection(DB_URL,"root","root");
            String sql = "insert into Business(BusinessID, BusinessCode, BusinessName, BusinessInfor) values("+i+",'"+str[1]+"','"+str[2]+"','"+str[3]+"')";
            stmt = conn.createStatement();
            int a = stmt.executeUpdate(sql);
            if(a>0)
                loginsuccess = 1;
            else
                loginsuccess = 0;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        if(stmt!=null)
        {
            try {
                stmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if(conn!=null)
        {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return loginsuccess;
    }


    public static int update(String[] str)
    {
        //成功1，失败0
        int loginsuccess = 0;
        Connection conn = null;
        Statement stmt = null;
        int i = -1;
        if(!str[0].equals(""))
        {
            try{
                i = Integer.parseInt(str[0]);
            }
            catch(Exception e1) {
                return 0;
            }
        }
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            final String DB_URL = "jdbc:mysql://localhost:3306/mydb?useUnicode=true&characterEncoding=UTF-8&useSSL=false&serverTimezone=UTC";
            conn = (Connection) DriverManager.getConnection(DB_URL, "root", "root");
            String sql="update Business set ";
            int count =0;
            for (int c = 1; c < 4; c++) {
                if(!str[c].equals("")&&count==0) {
                    sql = sql+ pro[c]+ "= '"+str[c]+"'";
                    count++;
                }
                else if(!str[c].equals(""))
                {
                    sql = sql+", "+ pro[c]+" = '"+str[c]+"'";
                }
            }
            sql = sql + " where "+pro[0]+"="+i;
            stmt = conn.createStatement();
            int a = stmt.executeUpdate(sql);
            if (a>0)
                loginsuccess = 1;
            else
            {
                loginsuccess = 0;

            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        if(stmt!=null)
        {
            try {
                stmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if(conn!=null)
        {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return loginsuccess;
    }

    public static int search(String[] str)
    {
        //成功1，失败0
        int loginsuccess = 0;
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        StringBuilder ssr = null;
        int i = -1;
        if(!str[0].equals(""))
        {
            try{
                i = Integer.parseInt(str[0]);
            }
            catch(Exception e1) {
                return 0;
            }
        }
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            final String DB_URL = "jdbc:mysql://localhost:3306/mydb?useUnicode=true&characterEncoding=UTF-8&useSSL=false&serverTimezone=UTC";
            conn = (Connection) DriverManager.getConnection(DB_URL, "root", "root");
            String sql="select * from Business where ";
            int count =0;
            for (int c = 0; c < 4; c++) {
                if(!str[c].equals("")&&count==0) {
                    sql = sql+ pro[c]+ "= '"+str[c]+"'";
                    count++;
                }
                else if(!str[c].equals(""))
                {
                    sql = sql+" and "+ pro[c]+" = '"+str[c]+"'";
                }
            }
            if(count==0)
                sql = sql+"1=1";
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql); 
            ssr = new StringBuilder();
            ssr.append(pro[0]+"---"+pro[1]+"---"+pro[2]+"---"+pro[3]+"\n");
            while(rs.next())
            {
                loginsuccess = 1;
                ssr.append(rs.getString(pro[0])+"-----");
                ssr.append(rs.getString(pro[1])+"-----");
                ssr.append(rs.getString(pro[2])+"-----");
                ssr.append(rs.getString(pro[3])+"\n");
            }

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        if(stmt!=null)
        {
            try {
                stmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if(conn!=null)
        {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        String result;
        result = ssr.toString();
        showsearch are = new showsearch(result);
        are.frmResult.setVisible(true);
        return loginsuccess;
    }

}