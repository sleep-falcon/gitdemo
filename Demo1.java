package Mysqljdbc;

import java.awt.Color;
import java.sql.*;
import java.util.Vector;
import javax.swing.*;

class Demo1 {

    public JTable search(int i, String[] str) {
        Vector<String> columnNameV=new Vector<>();//定义表格列名字向量
        columnNameV.add("Product ID");
        columnNameV.add("Product price");
        columnNameV.add("Sale");
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
            String sql="select HistoryItemID, HistoryItemPrice, sum(HistoryItemNum) as a from historyorder,iteminhistoryorder where HistoryOrderID = HistoryOrder_HistoryOrderID and HistoryOrderDate>'" +start+ "'and HistoryOrderDate<'"+end+"' and HistoryBusinessID = "+i+" group by HistoryItemID, HistoryItemPrice order by a desc";
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);
            int count = 0;
            while(rs.next()&&count<10)
            {
                Vector <String> rowV=new Vector<>();//定义表格行向量
                rowV.add(rs.getString("HistoryItemID"));
                rowV.add(rs.getString("HistoryItemPrice"));
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