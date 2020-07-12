package Mysqljdbc;

import org.jfree.ui.RefineryUtilities;

import java.awt.EventQueue;

import javax.swing.*;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 * Title	     :
 * Description:
 * Copyright  : Copyright (c) 2006 - 2020
 * @author YUAN Liyao
 * @version
 * @author
 * @version
 */
public class mm {

    JFrame frmOrderStatistics;
    private JTextField textField;
    private JTextField textField_1;
    private JTextField textField_2;
    private JTable table;
    int id;
    /**
     * Create the application.
     */
    public mm(int n) {
        id = n;
        initialize();
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        frmOrderStatistics = new JFrame();
        frmOrderStatistics.setTitle("order statistics");
        frmOrderStatistics.setBounds(100, 100, 771, 483);
        frmOrderStatistics.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frmOrderStatistics.getContentPane().setLayout(null);

        JLabel lblNewLabel = new JLabel("start time:");
        lblNewLabel.setFont(new Font("宋体", Font.PLAIN, 16));
        lblNewLabel.setBounds(99, 10, 97, 30);
        frmOrderStatistics.getContentPane().add(lblNewLabel);

        JLabel lblNewLabel_1 = new JLabel("end time:");
        lblNewLabel_1.setFont(new Font("宋体", Font.PLAIN, 16));
        lblNewLabel_1.setBounds(99, 50, 97, 27);
        frmOrderStatistics.getContentPane().add(lblNewLabel_1);

        textField = new JTextField();
        textField.setColumns(10);
        textField.setBounds(201, 13, 457, 27);
        frmOrderStatistics.getContentPane().add(textField);

        textField_1 = new JTextField();
        textField_1.setColumns(10);
        textField_1.setBounds(201, 50, 457, 28);
        frmOrderStatistics.getContentPane().add(textField_1);

        JButton btnNewButton = new JButton("back");
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frmOrderStatistics.dispose();
                Admin aa = new Admin(id);
                aa.frmAdministrator.setVisible(true);
            }
        });
        btnNewButton.setFont(new Font("宋体", Font.PLAIN, 20));
        btnNewButton.setBounds(599, 378, 117, 38);
        frmOrderStatistics.getContentPane().add(btnNewButton);

        JLabel lblNewLabel_2 = new JLabel("merchant ID:");
        lblNewLabel_2.setFont(new Font("宋体", Font.PLAIN, 16));
        lblNewLabel_2.setBounds(83, 87, 113, 45);
        frmOrderStatistics.getContentPane().add(lblNewLabel_2);

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(83, 153, 486, 272);
        frmOrderStatistics.getContentPane().add(scrollPane);

        textField_2 = new JTextField();
        textField_2.setBounds(201, 91, 457, 30);
        frmOrderStatistics.getContentPane().add(textField_2);
        textField_2.setColumns(10);

        JButton btntu = new JButton("user statistics");
        btntu.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String[] time = new String[2];
                time[0] = textField.getText();
                time[1] = textField_1.getText();
                try {
                    if (table != null) {// 先判断表模型是否为空,如果不是则先清除表
                        JFrame f = new JFrame();
                        f.remove(table);
                    }
                    table = managemts.searchuser(time);// 表赋值
                    table.setAutoCreateRowSorter(true);
                    scrollPane.setViewportView(table);
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
        }});
        btntu.setBounds(589, 130, 131, 44);
        frmOrderStatistics.getContentPane().add(btntu);

        JButton btntb = new JButton("business statistics");
        btntb.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String[] time = new String[2];
                time[0] = textField.getText();
                time[1] = textField_1.getText();
                try {
                    if (table != null) {// 先判断表模型是否为空,如果不是则先清除表
                        JFrame f = new JFrame();
                        f.remove(table);
                    }
                    table = managemts.searchbus(time);// 表赋值
                    table.setAutoCreateRowSorter(true);
                    scrollPane.setViewportView(table);
                } catch (Exception ex) {
                    ex.printStackTrace();
                }

            }
        });
        btntb.setBounds(589, 184, 155, 44);
        frmOrderStatistics.getContentPane().add(btntb);

        JButton btnmon = new JButton("month statistics");
        btnmon.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                LineChart_AWT chart = new LineChart_AWT(
                        "Order quantity Vs Months" ,
                        "2019 order statistics");
                chart.pack( );
                RefineryUtilities.centerFrameOnScreen( chart );
                chart.setVisible( true );

                chart aaa = new chart(
                        "Monthly amount Vs Months" ,
                        "2019 monthly amount statistics");
                aaa.pack( );
                RefineryUtilities.centerFrameOnScreen( aaa );
                aaa.setVisible( true );
            }
        });
        btnmon.setBounds(589, 247, 135, 38);
        frmOrderStatistics.getContentPane().add(btnmon);

        JButton btntt = new JButton("total");
        btntt.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String ssr = textField_2.getText();
                int i = Integer.parseInt(ssr);
                String[] we = managemts.hh(i);
                newtan cc = new newtan(we);
                cc.frame.setVisible(true);
            }
        });
        btntt.setBounds(589, 307, 131, 30);
        frmOrderStatistics.getContentPane().add(btntt);

    }
}