package Mysqljdbc;

import javax.swing.*;
import java.sql.*;
import java.util.Vector;

public class managemts {
    public static String[] hh(int i )
    {
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        String[] st = new String[2];
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            final String DB_URL = "jdbc:mysql://localhost:3306/mydb?useUnicode=true&characterEncoding=UTF-8&useSSL=false&serverTimezone=UTC";
            conn = (Connection) DriverManager.getConnection(DB_URL, "root", "root");
            String sql="select sum(HistoryItemNum*HistoryItemPrice) a from historyorder,iteminhistoryorder where HistoryOrderID = HistoryOrder_HistoryOrderID and HistoryBusinessID = "+i;
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);
            if(rs.next())
                st[1] = rs.getString("a");
            else
                st[1] = "0";
            sql="select count(HistoryOrderID) a from historyorder,iteminhistoryorder where HistoryOrderID = HistoryOrder_HistoryOrderID and HistoryBusinessID = "+i;
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);
            if(rs.next())
                st[0] = rs.getString("a");
            else
                st[0] = "0";
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
        return st;
    }

    public static JTable searchuser(String[] str) {
        Vector<String> columnNameV=new Vector<>();//定义表格列名字向量
        columnNameV.add("User ID");
        columnNameV.add("User Name");
        columnNameV.add("sum");
        Vector <Vector<String>> tableValueV = new Vector<>();
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        StringBuilder ssr = null;
        Date start = new Date(searcher.str2Date(str[0]));
        Date end = new Date(searcher.str2Date(str[1]));
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            final String DB_URL = "jdbc:mysql://localhost:3306/mydb?useUnicode=true&characterEncoding=UTF-8&useSSL=false&serverTimezone=UTC";
            conn = (Connection) DriverManager.getConnection(DB_URL, "root", "root");
            String sql="select HistoryOrderUserID, UserName, sum(HistoryItemNum*HistoryItemPrice) as a from users,iteminhistoryorder,historyorder where HistoryOrderID = HistoryOrder_HistoryOrderID and UsersID = HistoryOrderUserID and HistoryOrderDate>'" +start+ "'and HistoryOrderDate<'"+end+"' group by HistoryOrderUserID, UserName order by a desc";
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);
            int count = 0;
            while(rs.next()&&count<10)
            {
                Vector <String> rowV=new Vector<>();//定义表格行向量
                rowV.add(rs.getString("HistoryOrderUserID"));
                rowV.add(rs.getString("UserName"));
                rowV.add(rs.getString("a"));
                tableValueV.add(rowV);//将表格行向量添加到表格数据向量中
                count++;
            }
            if(count==0)
                return null;
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
        JTable JTable = new JTable(tableValueV, columnNameV);// 创建表格
        return JTable;
    }

    public static JTable searchbus(String[] str) {
        Vector<String> columnNameV=new Vector<>();//定义表格列名字向量
        columnNameV.add("Merchant ID");
        columnNameV.add("Merchant Name");
        columnNameV.add("Sum");
        Vector <Vector<String>> tableValueV = new Vector<>();
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        StringBuilder ssr = null;
        Date start = new Date(searcher.str2Date(str[0]));
        Date end = new Date(searcher.str2Date(str[1]));
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            final String DB_URL = "jdbc:mysql://localhost:3306/mydb?useUnicode=true&characterEncoding=UTF-8&useSSL=false&serverTimezone=UTC";
            conn = (Connection) DriverManager.getConnection(DB_URL, "root", "root");
            String sql="select BusinessID, BusinessName, sum(HistoryItemNum) as a from business,iteminhistoryorder,historyorder where HistoryOrderID = HistoryOrder_HistoryOrderID and HistoryBusinessID = BusinessID and HistoryOrderDate>'" +start+ "'and HistoryOrderDate<'"+end+"' group by BusinessID, BusinessName order by a desc";
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);
            int count = 0;
            while(rs.next()&&count<10)
            {
                Vector <String> rowV=new Vector<>();//定义表格行向量
                rowV.add(rs.getString("BusinessID"));
                rowV.add(rs.getString("BusinessName"));
                rowV.add(rs.getString("a"));
                tableValueV.add(rowV);//将表格行向量添加到表格数据向量中
                count++;
            }
            if(count==0)
                return null;
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
        JTable JTable = new JTable(tableValueV, columnNameV);// 创建表格
        return JTable;
    }

}
