package Mysqljdbc;
//
import java.sql.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

//商品的
public class test2 {
    static String pro[]= new String[7];

    static {
        pro[0]="ItemID";
        pro[1]="ItemName";
        pro[2]="ItemPrice";
        pro[3]="MajorClass";
        pro[4]="DetaileClass";
        pro[5]="Itemexplain";
        pro[6]="Business_BusinessID";
    }


    public static  int delete(String id)
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
            String sql = "delete from Items where ItemID"+"="+ i;
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
            String sql = "insert into items(ItemID, ItemName, ItemPrice, MajorClass, DetaileClass, Itemexplain, Business_BusinessID) values("+i+",'"+str[1]+"',"+Double.parseDouble(str[2])+",'"+str[3]+"','"+str[4]+"','"+str[5]+"',"+Integer.parseInt(str[6])+")";
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
            String sql="update Items set ";
            int count =0;
            for (int c = 1; c < 6; c++) {
                if(!str[c].equals("")&&count==0) {
                    sql = sql+ pro[c]+ "= '"+str[c]+"'";
                    count++;
                }
                else if(!str[c].equals(""))
                {
                    sql = sql+", "+ pro[c]+" = '"+str[c]+"'";
                }
            }
            sql = sql + " where "+pro[0]+"="+i+" and Business_BusinessID = "+Integer.parseInt(str[6]);
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
            String sql="select * from Items where ";
            int count =0;
            for (int c = 0; c < 6; c++) {
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
                sql = sql+ pro[6]+" = "+Integer.parseInt(str[6]);
            else
                sql = sql+" and "+ pro[6]+" = "+Integer.parseInt(str[6]);
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);
            ssr = new StringBuilder();
            ssr.append(pro[0]+"---"+pro[1]+"---"+pro[2]+"---"+pro[3]+"---"+pro[4]+"---"+pro[5]+"---"+pro[6]+"\n");
            while(rs.next())
            {
                loginsuccess = 1;
                ssr.append(rs.getString(pro[0])+"-----");
                ssr.append(rs.getString(pro[1])+"-----");
                ssr.append(rs.getString(pro[2])+"-----");
                ssr.append(rs.getString(pro[3])+"-----");
                ssr.append(rs.getString(pro[4])+"-----");
                ssr.append(rs.getString(pro[5])+"-----");
                ssr.append(rs.getString(pro[6])+"\n");
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
