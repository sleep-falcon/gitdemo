package Mysqljdbc;

import java.sql.*;

public class order {

    public static int search(int i)
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
            String sql="select OrdersID,OrderTime, Items_ItemID, ItemInOrderPrice, ItemNumber, Users_UsersID, OrderState from orders o, iteminorder i where o.OrdersID = i.Order_OrderID and OrderItemBusinessID = "+i;
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);
            ssr = new StringBuilder();
            ssr.append("OrdersID"+"---"+"OrderTime"+"---"+"ItemID"+"---"+"ItemPrice"+"---"+"Number"+"---"+"UsersID"+"---"+"OrderState"+"\n");
            while(rs.next())
            {
                loginsuccess = 1;
                ssr.append(rs.getString("OrdersID")+"-----");
                ssr.append(rs.getString("OrderTime")+"-----");
                ssr.append(rs.getString("Items_ItemID")+"-----");
                ssr.append(rs.getString("ItemInOrderPrice")+"-----");
                ssr.append(rs.getString("ItemNumber")+"-----");
                ssr.append(rs.getString("Users_UsersID")+"-----");
                ssr.append(rs.getString("OrderState")+"\n");
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
        if(loginsuccess==1)
        {
            String result = ssr.toString();
            showsearch are = new showsearch(result);
            are.frmResult.setVisible(true);
        }

        return loginsuccess;
    }

    public static int deliver(String ssr[],int lo) {
        int loginsuccess= 0;
        Connection conn = null;
        Statement stmt = null;
        int ii;
        try
        {
            ii = Integer.parseInt(ssr[0]);
        }
        catch (Exception e)
        {
            return 0;
        }
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            final String DB_URL = "jdbc:mysql://localhost:3306/mydb?useUnicode=true&characterEncoding=UTF-8&useSSL=false&serverTimezone=UTC";
            conn = (Connection) DriverManager.getConnection(DB_URL, "root", "root");
            String sql="update iteminorder set OrderState = 'delivered' where Order_OrderID = "+ssr[1]+" and OrderItemBusinessID = "+lo +" and Items_ItemID = "+ii+" and OrderState = 'ordered'";
            stmt = conn.createStatement();
            int a = stmt.executeUpdate(sql);
            if(a>0)
            {
                loginsuccess = 1;
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


}
