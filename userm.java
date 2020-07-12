package Mysqljdbc;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 * Title	     :
 * Description: 用户管理
 * Copyright  : Copyright (c) 2006 - 2020
 * @author YUAN Liyao
 * @version
 * @author
 * @version
 */
public class userm {

    JFrame frmUserManagement;
    private JTextField ID;
    private JTextField password;
    private JTextField name;
    private JTextField info;
    int id;

    /**
     * Create the application.
     */
    public userm(int n) {
        id = n;
        initialize();
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        frmUserManagement = new JFrame();
        frmUserManagement.setTitle("customer management");
        frmUserManagement.setBounds(100, 100, 858, 612);
        frmUserManagement.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frmUserManagement.getContentPane().setLayout(null);

        JLabel lb_ID = new JLabel("customer ID");
        lb_ID.setFont(new Font("宋体", Font.PLAIN, 18));
        lb_ID.setBounds(295, 127, 118, 46);
        lb_ID.setVisible(false);
        frmUserManagement.getContentPane().add(lb_ID);

        JLabel lb_pass = new JLabel("customer password ");
        lb_pass.setVisible(false);
        lb_pass.setFont(new Font("宋体", Font.PLAIN, 16));
        lb_pass.setBounds(260, 199, 167, 46);
        frmUserManagement.getContentPane().add(lb_pass);

        JLabel lb_name = new JLabel("customer name");
        lb_name.setVisible(false);
        lb_name.setFont(new Font("宋体", Font.PLAIN, 16));
        lb_name.setBounds(295, 272, 140, 61);
        frmUserManagement.getContentPane().add(lb_name);

        JLabel lb_info = new JLabel("customer info");
        lb_info.setVisible(false);
        lb_info.setFont(new Font("宋体", Font.PLAIN, 16));
        lb_info.setBounds(295, 346, 157, 56);
        frmUserManagement.getContentPane().add(lb_info);

        JLabel result = new JLabel("");
        result.setFont(new Font("宋体", Font.PLAIN, 20));
        result.setBounds(40, 498, 401, 56);
        frmUserManagement.getContentPane().add(result);

        JButton btnNewButton = new JButton("back");
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frmUserManagement.dispose();
                Admin aa = new Admin(id);
                aa.frmAdministrator.setVisible(true);
            }
        });
        btnNewButton.setFont(new Font("宋体", Font.PLAIN, 20));
        btnNewButton.setBounds(671, 511, 146, 43);
        frmUserManagement.getContentPane().add(btnNewButton);

        ID = new JTextField();
        ID.setVisible(false);
        ID.setBounds(433, 127, 352, 35);
        frmUserManagement.getContentPane().add(ID);
        ID.setColumns(10);

        password = new JTextField();
        password.setBounds(436, 206, 349, 35);
        password.setVisible(false);
        frmUserManagement.getContentPane().add(password);
        password.setColumns(10);

        name = new JTextField();
        name.setBounds(437, 286, 348, 35);
        name.setVisible(false);
        frmUserManagement.getContentPane().add(name);
        name.setColumns(10);

        info = new JTextField();
        info.setVisible(false);
        info.setBounds(436, 357, 349, 35);
        frmUserManagement.getContentPane().add(info);
        info.setColumns(10);

        JLabel cao = new JLabel("");
        cao.setFont(new Font("宋体", Font.PLAIN, 16));
        cao.setBounds(275, 32, 506, 43);
        frmUserManagement.getContentPane().add(cao);

        JButton btnNewButton_1 = new JButton("reset password");
        btnNewButton_1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                result.setText(null);
                if(btnNewButton_1.getText().equals("reset password"))
                {
                    btnNewButton_1.setText("verify");
                    lb_ID.setVisible(true);
                    ID.setVisible(true);
                }
                else{
                    String IID = ID.getText();
                    if(test3.reset(IID)==1)
                    {
                        result.setText("Reset completely!");
                    }
                    else
                        result.setText("Reset failed!");
                    ID.setText(null);
                    btnNewButton_1.setText("reset password");
                    lb_ID.setVisible(false);
                    ID.setVisible(false);
                }
            }
        });
        btnNewButton_1.setFont(new Font("宋体", Font.PLAIN, 15));
        btnNewButton_1.setBounds(24, 430, 155, 46);
        frmUserManagement.getContentPane().add(btnNewButton_1);

        JButton btninsert = new JButton("insert");
        btninsert.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                result.setText(null);
                if(btninsert.getText().equals("insert"))
                {
                    btninsert.setText("verify");
                    lb_ID.setVisible(true);
                    lb_info.setVisible(true);
                    lb_name.setVisible(true);
                    lb_pass.setVisible(true);
                    name.setVisible(true);
                    ID.setVisible(true);
                    info.setVisible(true);
                    password.setVisible(true);
                }
                else{
                    String str[] = new String[4];
                    str[0] = ID.getText();
                    str[1] = password.getText();
                    str[2] = name.getText();
                    str[3] = info.getText();
                    if(test3.insert(str)==1)
                    {
                        result.setText("Insert successfully!");
                    }
                    else
                        result.setText("Insert failed!");
                    btninsert.setText("insert");
                    ID.setText(null);
                    name.setText(null);
                    info.setText(null);
                    password.setText(null);
                    lb_ID.setVisible(false);
                    lb_info.setVisible(false);
                    lb_name.setVisible(false);
                    lb_pass.setVisible(false);
                    name.setVisible(false);
                    ID.setVisible(false);
                    info.setVisible(false);
                    password.setVisible(false);
                }
            }
        });
        btninsert.setFont(new Font("宋体", Font.PLAIN, 17));
        btninsert.setBounds(24, 62, 155, 46);
        frmUserManagement.getContentPane().add(btninsert);

        JButton btndelete = new JButton("delete");
        btndelete.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                result.setText(null);
                if(btndelete.getText().equals("delete"))
                {
                    btndelete.setText("verify");
                    lb_ID.setVisible(true);
                    ID.setVisible(true);
                }
                else{
                    String IID = ID.getText();
                    if(test3.delete(IID)==1)
                    {
                        result.setText("Delete completely!");
                    }
                    else
                        result.setText("Delete failed!");
                    ID.setText(null);
                    btndelete.setText("delete");
                    lb_ID.setVisible(false);
                    ID.setVisible(false);
                }
            }
        });
        btndelete.setFont(new Font("宋体", Font.PLAIN, 17));
        btndelete.setBounds(24, 161, 155, 46);
        frmUserManagement.getContentPane().add(btndelete);

        JButton btnupdate = new JButton("update");
        btnupdate.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                result.setText(null);
                if(btnupdate.getText().equals("update"))
                {
                    cao.setText("please input the product ID to update");
                    cao.setVisible(true);
                    btnupdate.setText("verify");
                    lb_ID.setVisible(true);
                    lb_info.setVisible(true);
                    lb_name.setVisible(true);
                    name.setVisible(true);
                    ID.setVisible(true);
                    info.setVisible(true);
                }
                else{
                    cao.setVisible(false);
                    String str[] = new String[4];
                    str[0] = ID.getText();
                    str[1] = null;
                    str[2] = name.getText();
                    str[3] = info.getText();
                    if(test3.update(str)==1)
                    {
                        result.setText("Update successfully!");
                    }
                    else
                        result.setText("Update failed!");
                    btnupdate.setText("update");
                    name.setText(null);
                    ID.setText(null);
                    name.setText(null);
                    info.setText(null);
                    password.setText(null);
                    lb_ID.setVisible(false);
                    lb_info.setVisible(false);
                    lb_name.setVisible(false);
                    lb_pass.setVisible(false);
                    name.setVisible(false);
                    ID.setVisible(false);
                    info.setVisible(false);
                    password.setVisible(false);
                }

            }
        });
        btnupdate.setFont(new Font("宋体", Font.PLAIN, 17));
        btnupdate.setBounds(24, 257, 155, 46);
        frmUserManagement.getContentPane().add(btnupdate);

        JButton btnsearch = new JButton("search");
        btnsearch.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                result.setText(null);
                if(btnsearch.getText().equals("search"))
                {
                    cao.setText("please input the condition to search");
                    cao.setVisible(true);
                    btnsearch.setText("verify");
                    lb_ID.setVisible(true);
                    lb_info.setVisible(true);
                    lb_name.setVisible(true);
                    lb_pass.setVisible(true);
                    name.setVisible(true);
                    ID.setVisible(true);
                    info.setVisible(true);
                    password.setVisible(true);
                }
                else{
                    cao.setVisible(false);
                    String str[] = new String[4];
                    str[0] = ID.getText();
                    str[1] = password.getText();
                    str[2] = name.getText();
                    str[3] = info.getText();
                    if(test3.search(str)==1)
                    {
                        result.setText("Search successfully!");
                    }
                    else
                        result.setText("Search failed!");
                    btnsearch.setText("search");
                    ID.setText(null);
                    name.setText(null);
                    info.setText(null);
                    password.setText(null);
                    lb_ID.setVisible(false);
                    lb_info.setVisible(false);
                    lb_name.setVisible(false);
                    lb_pass.setVisible(false);
                    name.setVisible(false);
                    ID.setVisible(false);
                    info.setVisible(false);
                    password.setVisible(false);
                }
            }
        });
        btnsearch.setFont(new Font("宋体", Font.PLAIN, 17));
        btnsearch.setBounds(24, 346, 155, 46);
        frmUserManagement.getContentPane().add(btnsearch);
    }
}

