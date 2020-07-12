package Mysqljdbc;

import java.sql.*;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class searcher {
    public static String[] search(int i, String[] st)
    {
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        Date start = new Date(str2Date(st[0]));
        Date end = new Date(str2Date(st[1]));
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            final String DB_URL = "jdbc:mysql://localhost:3306/mydb?useUnicode=true&characterEncoding=UTF-8&useSSL=false&serverTimezone=UTC";
            conn = (Connection) DriverManager.getConnection(DB_URL, "root", "root");
            String sql="select sum(HistoryItemNum*HistoryItemPrice) a from historyorder,iteminhistoryorder where HistoryOrderID = HistoryOrder_HistoryOrderID and HistoryOrderDate > '" +start+ "' and HistoryOrderDate < '"+end+"' and HistoryBusinessID = "+i;
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);
            if(rs.next())
                st[1] = rs.getString("a");
            else
                st[1] = "0";
            sql="select count(HistoryOrderID) a from historyorder,iteminhistoryorder where HistoryOrderID = HistoryOrder_HistoryOrderID  and HistoryOrderDate > '" +start+ "' and HistoryOrderDate < '"+end+"' and HistoryBusinessID = "+i;
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

    public static String[] search2(int i, String[] st)
    {
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        String sql = null;
        String sql1 = null;
        if(st[0].equals("")&&st[1].equals(""))
            return null;
        else if(st[0].equals(""))
        {
            sql = "select sum(HistoryItemNum*HistoryItemPrice) a from historyorder,iteminhistoryorder where HistoryOrderID = HistoryOrder_HistoryOrderID and detailclass = '"+st[1]+"' and HistoryBusinessID = "+i;;
            sql1 = "select count(HistoryOrderID) a from historyorder,iteminhistoryorder where HistoryOrderID = HistoryOrder_HistoryOrderID and detailclass = '"+st[1]+"' and HistoryBusinessID = "+i;
        }
        else if(st[1].equals(""))
        {
            sql = "select sum(HistoryItemNum*HistoryItemPrice) a from historyorder,iteminhistoryorder where HistoryOrderID = HistoryOrder_HistoryOrderID and majorclass = '"+st[0]+"' and HistoryBusinessID = "+i;;
            sql1 = "select count(HistoryOrderID) a from historyorder,iteminhistoryorder where HistoryOrderID = HistoryOrder_HistoryOrderID and majorclass = '"+st[0]+"' and HistoryBusinessID = "+i;
        }
        else{
            sql = "select sum(HistoryItemNum*HistoryItemPrice) a from historyorder,iteminhistoryorder where HistoryOrderID = HistoryOrder_HistoryOrderID and majorclass = '"+st[0]+"' and detailclass = '"+st[1]+"' and HistoryBusinessID = "+i;;
            sql1 = "select count(HistoryOrderID) a from historyorder,iteminhistoryorder where HistoryOrderID = HistoryOrder_HistoryOrderID and majorclass = '"+st[0]+"' and detailclass = '"+st[1]+"' and HistoryBusinessID = "+i;
        }
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            final String DB_URL = "jdbc:mysql://localhost:3306/mydb?useUnicode=true&characterEncoding=UTF-8&useSSL=false&serverTimezone=UTC";
            conn = (Connection) DriverManager.getConnection(DB_URL, "root", "root");
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);
            if(rs.next())
                st[1] = rs.getString("a");
            else
                st[1] = "0";
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql1);
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


    public static long str2Date(String dateStr) {
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        try {
            return format.parse(dateStr).getTime();
        } catch (ParseException e) {
            e.printStackTrace();
            return 0;
        }
    }}
