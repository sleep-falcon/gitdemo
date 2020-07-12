package Mysqljdbc;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;

/**
 * Title	     :
 * Description:
 * Copyright  : Copyright (c) 2006 - 2020
 * @author YUAN Liyao
 * @version
 * @author
 * @version
 */
public class Bstatistics {

    JFrame frmOrderStatistics;
    private JTextField stime;
    private JTextField etime;
    private JTable table;
    int id;

    /**
     * Create the application.
     */
    public Bstatistics(int n) {
        id = n;
        initialize();
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        frmOrderStatistics = new JFrame();
        frmOrderStatistics.setTitle("order statistics");
        frmOrderStatistics.setBounds(100, 100, 845, 578);
        frmOrderStatistics.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frmOrderStatistics.getContentPane().setLayout(null);

        JLabel lblNewLabel = new JLabel("start time:");
        lblNewLabel.setFont(new Font("宋体", Font.PLAIN, 16));
        lblNewLabel.setBounds(139, 10, 97, 30);
        frmOrderStatistics.getContentPane().add(lblNewLabel);

        stime = new JTextField();
        stime.setBounds(241, 10, 457, 27);
        frmOrderStatistics.getContentPane().add(stime);
        stime.setColumns(10);

        JLabel lblNewLabel_1 = new JLabel("end time:");
        lblNewLabel_1.setFont(new Font("宋体", Font.PLAIN, 16));
        lblNewLabel_1.setBounds(139, 50, 97, 27);
        frmOrderStatistics.getContentPane().add(lblNewLabel_1);

        etime = new JTextField();
        etime.setBounds(241, 47, 457, 28);
        frmOrderStatistics.getContentPane().add(etime);
        etime.setColumns(10);

        JButton btnNewButton = new JButton("back");
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frmOrderStatistics.dispose();
                Bus bbb = new Bus(id);
                bbb.frmMerchant.setVisible(true);
            }
        });
        btnNewButton.setFont(new Font("宋体", Font.PLAIN, 20));
        btnNewButton.setBounds(691, 480, 117, 38);
        frmOrderStatistics.getContentPane().add(btnNewButton);

        JLabel lblNewLabel_2 = new JLabel("the number of all orders");
        lblNewLabel_2.setFont(new Font("宋体", Font.PLAIN, 14));
        lblNewLabel_2.setBounds(53, 145, 189, 45);
        frmOrderStatistics.getContentPane().add(lblNewLabel_2);

        JLabel lblNewLabel_3 = new JLabel("total price");
        lblNewLabel_3.setFont(new Font("宋体", Font.PLAIN, 14));
        lblNewLabel_3.setBounds(53, 200, 166, 48);
        frmOrderStatistics.getContentPane().add(lblNewLabel_3);

        JLabel renum = new JLabel("");
        renum.setBounds(246, 149, 334, 27);
        frmOrderStatistics.getContentPane().add(renum);

        JLabel reprice = new JLabel("");
        reprice.setBounds(246, 207, 334, 30);
        frmOrderStatistics.getContentPane().add(reprice);

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(79, 276, 525, 210);
        frmOrderStatistics.getContentPane().add(scrollPane);

        JLabel result = new JLabel("No finding!");
        result.setVisible(false);
        result.setFont(new Font("宋体", Font.PLAIN, 13));
        result.setBounds(628, 261, 180, 66);
        frmOrderStatistics.getContentPane().add(result);

        JButton btnsearch = new JButton("search");
        btnsearch.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                renum.setText(null);
                reprice.setText(null);
                result.setVisible(false);
                String[] str = new String[2];
                str[0] = stime.getText();
                str[1] = etime.getText();
                String[] dsb = new String[2];
                dsb[0] = stime.getText();
                dsb[1] = etime.getText();
                Demo1 s = new Demo1();
                try {
                    if (table != null) {// 先判断表模型是否为空,如果不是则先清除表
                        JFrame f = new JFrame();
                        f.remove(table);
                    }
                    str= searcher.search(id,str);
                    renum.setText(str[0]);
                    reprice.setText(str[1]);
                    table = s.search(id,dsb);// 表赋值
                    table.setAutoCreateRowSorter(true);
                    scrollPane.setViewportView(table);
                } catch (Exception ex) {
                    result.setVisible(true);
                }
            }
        });
        btnsearch.setFont(new Font("宋体", Font.PLAIN, 16));
        btnsearch.setBounds(35, 87, 147, 48);
        frmOrderStatistics.getContentPane().add(btnsearch);

        JButton btncl = new JButton("search by class");
        btncl.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                tan tt = new tan(id);
                tt.frmSearchByClass.setVisible(true);
            }
        });
        btncl.setFont(new Font("宋体", Font.PLAIN, 14));
        btncl.setBounds(662, 179, 147, 38);
        frmOrderStatistics.getContentPane().add(btncl);
    }
}

