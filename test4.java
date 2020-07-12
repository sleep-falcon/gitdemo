package Mysqljdbc;


import java.sql.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

//类别的
public class test4 {
    static String pro[]= new String[2];

    static {
        pro[0]="DetailClass";
        pro[1]="MajorClass";
    }


    public static  int delete(String[] str)
    {
        //成功1，失败0
        int loginsuccess = 0;
        Connection conn = null;
        Statement stmt = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            final String DB_URL = "jdbc:mysql://localhost:3306/mydb?useUnicode=true&characterEncoding=UTF-8&useSSL=false&serverTimezone=UTC";
            conn = (Connection)DriverManager.getConnection(DB_URL,"root","root");
            String sql = "delete from class where ";
            if(str[0].equals(""))
            {
                if(str[1].equals(""))
                    return 0;
                else
                    sql = sql + "MajorClass = '"+str[1]+"'";
            }
            else
            {
                if(str[1].equals(""))
                    sql = sql + "DetailClass = '"+str[0]+"'";
                else
                    sql = sql + "DetailClass = '"+str[0]+"' and MajorClass = '"+str[1]+"'";
            }
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
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            final String DB_URL = "jdbc:mysql://localhost:3306/mydb?useUnicode=true&characterEncoding=UTF-8&useSSL=false&serverTimezone=UTC";
            conn = (Connection)DriverManager.getConnection(DB_URL,"root","root");
            String sql = "insert into class(DetailClass, MajorClass) values('"+str[0]+"','"+str[1]+"')";
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
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            final String DB_URL = "jdbc:mysql://localhost:3306/mydb?useUnicode=true&characterEncoding=UTF-8&useSSL=false&serverTimezone=UTC";
            conn = (Connection) DriverManager.getConnection(DB_URL, "root", "root");
            String sql="update class set ";
            int count =0;
            for (int c = 0; c < 2; c++) {
                if(!str[c].equals("")&&count==0) {
                    sql = sql+ pro[c]+ "= '"+str[c+2]+"'";
                    count++;
                }
                else if(!str[c].equals(""))
                {
                    sql = sql+", "+ pro[c]+" = '"+str[c+2]+"'";
                }
            }
            sql = sql + " where ";
            count = 0;
            for (int c = 0; c < 2; c++) {
                if(!str[c].equals("")&&count==0) {
                    sql = sql+ pro[c]+ "= '"+str[c]+"'";
                    count++;
                }
                else if(!str[c].equals(""))
                {
                    sql = sql+" and "+ pro[c]+" = '"+str[c]+"'";
                }
            }
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

    public static int search()
    {
        //成功1，失败0
        int loginsuccess = 0;
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        StringBuilder ssr = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            final String DB_URL = "jdbc:mysql://localhost:3306/mydb?useUnicode=true&characterEncoding=UTF-8&useSSL=false&serverTimezone=UTC";
            conn = (Connection) DriverManager.getConnection(DB_URL, "root", "root");
            String sql="select * from class ";
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);

            ssr = new StringBuilder();
            ssr.append(pro[0]+"---"+pro[1]+"\n");
            while(rs.next())
            {
                loginsuccess = 1;
                ssr.append(rs.getString(pro[0])+"-----");
                ssr.append(rs.getString(pro[1])+"\n");
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
