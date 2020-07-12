package Mysqljdbc;

import org.jfree.chart.ChartPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

import java.sql.*;

public class chart extends ApplicationFrame
{
    public chart( String applicationTitle , String chartTitle )
    {
        super(applicationTitle);
        JFreeChart lineChart = ChartFactory.createLineChart(
                chartTitle,
                "Months","amount of the money",
                createDataset(),
                PlotOrientation.VERTICAL,
                true,true,false);

        ChartPanel chartPanel = new ChartPanel( lineChart );
        chartPanel.setPreferredSize( new java.awt.Dimension( 560 , 367 ) );
        setContentPane( chartPanel );
    }

    private DefaultCategoryDataset createDataset( )
    {
        String[] str = new String[12];
        String[] mon = new String[12];
        mon[0] = "Jan.";
        mon[1] = "Feb.";
        mon[2] = "Mar.";
        mon[3] = "Apr.";
        mon[4] = "May.";
        mon[5] = "Jun.";
        mon[6] = "Jul.";
        mon[7] = "Aug.";
        mon[8] = "Sept.";
        mon[9] = "Oct.";
        mon[10] = "Nov.";
        mon[11] = "Dec.";
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            final String DB_URL = "jdbc:mysql://localhost:3306/mydb?useUnicode=true&characterEncoding=UTF-8&useSSL=false&serverTimezone=UTC";
            conn = (Connection) DriverManager.getConnection(DB_URL, "root", "root");
            String sql;
            sql="select count(HistoryItemPrice*HistoryItemNum) a from historyorder,iteminhistoryorder where HistoryOrderID=HistoryOrder_HistoryOrderID and HistoryOrderDate between '2019-01-01 00:00:00' and '2019-02-01 00:00:00'";
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);
            rs.next();
            str[0] = rs.getString("a");

            sql="select count(HistoryItemPrice*HistoryItemNum) a from historyorder,iteminhistoryorder where HistoryOrderID=HistoryOrder_HistoryOrderID and HistoryOrderDate between '2019-02-01 00:00:00' and '2019-03-01 00:00:00'";
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);
            rs.next();
            str[1] = rs.getString("a");

            sql="select count(HistoryItemPrice*HistoryItemNum) a from historyorder,iteminhistoryorder where HistoryOrderID=HistoryOrder_HistoryOrderID and HistoryOrderDate between '2019-03-01 00:00:00' and '2019-04-01 00:00:00'";
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);
            rs.next();
            str[2] = rs.getString("a");

            sql="select count(HistoryItemPrice*HistoryItemNum) a from historyorder,iteminhistoryorder where HistoryOrderID=HistoryOrder_HistoryOrderID and HistoryOrderDate between '2019-04-01 00:00:00' and '2019-05-01 00:00:00'";
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);
            rs.next();
            str[3] = rs.getString("a");

            sql="select count(HistoryItemPrice*HistoryItemNum) a from historyorder,iteminhistoryorder where HistoryOrderID=HistoryOrder_HistoryOrderID and HistoryOrderDate between '2019-05-01 00:00:00' and '2019-06-01 00:00:00'";
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);
            rs.next();
            str[4] = rs.getString("a");

            sql="select count(HistoryItemPrice*HistoryItemNum) a from historyorder,iteminhistoryorder where HistoryOrderID=HistoryOrder_HistoryOrderID and HistoryOrderDate between '2019-06-01 00:00:00' and '2019-07-01 00:00:00'";
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);
            rs.next();
            str[5] = rs.getString("a");

            sql="select count(HistoryItemPrice*HistoryItemNum) a from historyorder,iteminhistoryorder where HistoryOrderID=HistoryOrder_HistoryOrderID and HistoryOrderDate between '2019-07-01 00:00:00' and '2019-08-01 00:00:00'";
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);
            rs.next();
            str[6] = rs.getString("a");

            sql="select count(HistoryItemPrice*HistoryItemNum) a from historyorder,iteminhistoryorder where HistoryOrderID=HistoryOrder_HistoryOrderID and HistoryOrderDate between '2019-08-01 00:00:00' and '2019-09-01 00:00:00'";
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);
            rs.next();
            str[7] = rs.getString("a");

            sql="select count(HistoryItemPrice*HistoryItemNum) a from historyorder,iteminhistoryorder where HistoryOrderID=HistoryOrder_HistoryOrderID and HistoryOrderDate between '2019-09-01 00:00:00' and '2019-10-01 00:00:00'";
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);
            rs.next();
            str[8] = rs.getString("a");

            sql="select count(HistoryItemPrice*HistoryItemNum) a from historyorder,iteminhistoryorder where HistoryOrderID=HistoryOrder_HistoryOrderID and HistoryOrderDate between '2019-10-01 00:00:00' and '2019-11-01 00:00:00'";
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);
            rs.next();
            str[9] = rs.getString("a");

            sql="select count(HistoryItemPrice*HistoryItemNum) a from historyorder,iteminhistoryorder where HistoryOrderID=HistoryOrder_HistoryOrderID and HistoryOrderDate between '2019-11-01 00:00:00' and '2019-12-01 00:00:00'";
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);
            rs.next();
            str[10] = rs.getString("a");

            sql="select count(HistoryItemPrice*HistoryItemNum) a from historyorder,iteminhistoryorder where HistoryOrderID=HistoryOrder_HistoryOrderID and HistoryOrderDate between '2019-12-01 00:00:00' and '2020-01-01 00:00:00'";
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);
            rs.next();
            str[11] = rs.getString("a");

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
        DefaultCategoryDataset dataset = new DefaultCategoryDataset( );
        for(int i = 0;i<12;i++)
        {
            dataset.addValue( Integer.parseInt(str[i]) , "Order quantity" , mon[i]+"" );
        }

        return dataset;
    }
}