package Mysqljdbc;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;

/**
 * Title	     :
 * Description:
 * Copyright  : Copyright (c) 2006 - 2020
 * @author YUAN Liyao
 * @version
 * @author
 * @version
 */
public class item {

    JFrame frmProductManagement;
    private JTextField ID;
    private JTextField name;
    private JTextField price;
    private JTextField major;
    private JTextField detail;
    private JTextField describe;
    int id;

    /**
     * Create the application.
     */
    public item(int i) {
        id = i;
        initialize();
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        frmProductManagement = new JFrame();
        frmProductManagement.setTitle("product management");
        frmProductManagement.setBounds(100, 100, 767, 648);
        frmProductManagement.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frmProductManagement.getContentPane().setLayout(null);

        JLabel lb_detail = new JLabel("     detail class");
        lb_detail.setVisible(false);
        lb_detail.setFont(new Font("宋体", Font.PLAIN, 16));
        lb_detail.setBounds(10, 357, 211, 35);
        frmProductManagement.getContentPane().add(lb_detail);

        JLabel lb_ID = new JLabel("      productID");
        lb_ID.setVisible(false);
        lb_ID.setFont(new Font("宋体", Font.PLAIN, 16));
        lb_ID.setBounds(10, 128, 136, 46);
        frmProductManagement.getContentPane().add(lb_ID);

        JLabel lb_name = new JLabel("          product's name");
        lb_name.setVisible(false);
        lb_name.setFont(new Font("宋体", Font.PLAIN, 16));
        lb_name.setBounds(10, 192, 211, 54);
        frmProductManagement.getContentPane().add(lb_name);

        JLabel lb_price = new JLabel("         product's price");
        lb_price.setVisible(false);
        lb_price.setFont(new Font("宋体", Font.PLAIN, 16));
        lb_price.setBounds(10, 256, 211, 46);
        frmProductManagement.getContentPane().add(lb_price);

        JLabel lb_major = new JLabel("         major classs");
        lb_major.setVisible(false);
        lb_major.setFont(new Font("宋体", Font.PLAIN, 16));
        lb_major.setBounds(10, 312, 194, 35);
        frmProductManagement.getContentPane().add(lb_major);

        JLabel lb_info = new JLabel("      product's describe");
        lb_info.setVisible(false);
        lb_info.setFont(new Font("宋体", Font.PLAIN, 16));
        lb_info.setBounds(10, 409, 202, 35);
        frmProductManagement.getContentPane().add(lb_info);

        ID = new JTextField();
        ID.setVisible(false);
        ID.setBounds(228, 128, 315, 37);
        frmProductManagement.getContentPane().add(ID);
        ID.setColumns(10);

        name = new JTextField();
        name.setVisible(false);
        name.setBounds(231, 192, 312, 39);
        frmProductManagement.getContentPane().add(name);
        name.setColumns(10);

        price = new JTextField();
        price.setVisible(false);
        price.setBounds(229, 256, 314, 35);
        frmProductManagement.getContentPane().add(price);
        price.setColumns(10);

        major = new JTextField();
        major.setVisible(false);
        major.setBounds(229, 306, 314, 35);
        frmProductManagement.getContentPane().add(major);
        major.setColumns(10);

        detail = new JTextField();
        detail.setVisible(false);
        detail.setBounds(231, 357, 312, 29);
        frmProductManagement.getContentPane().add(detail);
        detail.setColumns(10);

        describe = new JTextField();
        describe.setVisible(false);
        describe.setBounds(228, 409, 315, 29);
        frmProductManagement.getContentPane().add(describe);
        describe.setColumns(10);

        JLabel cao = new JLabel("");
        cao.setFont(new Font("宋体", Font.PLAIN, 16));
        cao.setBounds(10, 0, 516, 54);
        frmProductManagement.getContentPane().add(cao);

        JLabel result = new JLabel("");
        result.setBounds(10, 524, 529, 46);
        result.setFont(new Font("宋体", Font.PLAIN, 20));
        frmProductManagement.getContentPane().add(result);

        JButton btnNewButton = new JButton("back");
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frmProductManagement.dispose();
                Bus a = new Bus(id);
                a.frmMerchant.setVisible(true);
            }
        });
        btnNewButton.setFont(new Font("宋体", Font.PLAIN, 20));
        btnNewButton.setBounds(627, 567, 116, 34);
        frmProductManagement.getContentPane().add(btnNewButton);

        JButton btninsert = new JButton("insert");
        btninsert.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                result.setText(null);
                if(btninsert.getText().equals("insert"))
                {
                    btninsert.setText("verify");
                    lb_ID.setVisible(true);
                    lb_detail.setVisible(true);
                    lb_info.setVisible(true);
                    lb_major.setVisible(true);
                    lb_name.setVisible(true);
                    lb_price.setVisible(true);
                    name.setVisible(true);
                    ID.setVisible(true);
                    price.setVisible(true);
                    major.setVisible(true);
                    detail.setVisible(true);
                    describe.setVisible(true);
                }
                else{
                    String str[] = new String[7];
                    str[0] = ID.getText();
                    str[1] = name.getText();
                    str[2] = price.getText();
                    str[3] = major.getText();
                    str[4] = detail.getText();
                    str[5] = describe.getText();
                    str[6] = ""+id;
                    if(test2.insert(str)==1)
                    {
                        result.setText("Insert successfully!");
                    }
                    else
                        result.setText("Insert failed!");
                    btninsert.setText("insert");
                    name.setText(null);
                    ID.setText(null);
                    price.setText(null);
                    major.setText(null);
                    detail.setText(null);
                    describe.setText(null);
                    lb_ID.setVisible(false);
                    lb_detail.setVisible(false);
                    lb_info.setVisible(false);
                    lb_major.setVisible(false);
                    lb_name.setVisible(false);
                    lb_price.setVisible(false);
                    name.setVisible(false);
                    ID.setVisible(false);
                    price.setVisible(false);
                    major.setVisible(false);
                    detail.setVisible(false);
                    describe.setVisible(false);
                }
            }
        });
        btninsert.setBounds(10, 55, 155, 46);
        frmProductManagement.getContentPane().add(btninsert);

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
                    if(test2.delete(IID)==1)
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
        btndelete.setBounds(213, 55, 155, 46);
        frmProductManagement.getContentPane().add(btndelete);

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
                    lb_detail.setVisible(true);
                    lb_info.setVisible(true);
                    lb_major.setVisible(true);
                    lb_name.setVisible(true);
                    lb_price.setVisible(true);
                    name.setVisible(true);
                    ID.setVisible(true);
                    price.setVisible(true);
                    major.setVisible(true);
                    detail.setVisible(true);
                    describe.setVisible(true);
                }
                else{
                    cao.setVisible(false);
                    String str[] = new String[7];
                    str[0] = ID.getText();
                    str[1] = name.getText();
                    str[2] = price.getText();
                    str[3] = major.getText();
                    str[4] = detail.getText();
                    str[5] = describe.getText();
                    str[6] = ""+id;
                    if(test2.update(str)==1)
                    {
                        result.setText("Update successfully!");
                    }
                    else
                        result.setText("Update failed!");
                    btnupdate.setText("update");
                    name.setText(null);
                    ID.setText(null);
                    price.setText(null);
                    major.setText(null);
                    detail.setText(null);
                    describe.setText(null);
                    lb_ID.setVisible(false);
                    lb_detail.setVisible(false);
                    lb_info.setVisible(false);
                    lb_major.setVisible(false);
                    lb_name.setVisible(false);
                    lb_price.setVisible(false);
                    name.setVisible(false);
                    ID.setVisible(false);
                    price.setVisible(false);
                    major.setVisible(false);
                    detail.setVisible(false);
                    describe.setVisible(false);
                }

            }
        });
        btnupdate.setBounds(419, 55, 136, 46);
        frmProductManagement.getContentPane().add(btnupdate);

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
                    lb_detail.setVisible(true);
                    lb_info.setVisible(true);
                    lb_major.setVisible(true);
                    lb_name.setVisible(true);
                    lb_price.setVisible(true);
                    name.setVisible(true);
                    ID.setVisible(true);
                    price.setVisible(true);
                    major.setVisible(true);
                    detail.setVisible(true);
                    describe.setVisible(true);
                }
                else{
                    cao.setVisible(false);
                    String str[] = new String[7];
                    str[0] = ID.getText();
                    str[1] = name.getText();
                    str[2] = price.getText();
                    str[3] = major.getText();
                    str[4] = detail.getText();
                    str[5] = describe.getText();
                    str[6] = ""+id;
                    if(test2.search(str)==1)
                    {
                        result.setText("Search successfully!");
                    }
                    else
                        result.setText("Search failed!");
                    btnsearch.setText("search");
                    name.setText(null);
                    ID.setText(null);
                    price.setText(null);
                    major.setText(null);
                    detail.setText(null);
                    describe.setText(null);
                    lb_ID.setVisible(false);
                    lb_detail.setVisible(false);
                    lb_info.setVisible(false);
                    lb_major.setVisible(false);
                    lb_name.setVisible(false);
                    lb_price.setVisible(false);
                    name.setVisible(false);
                    ID.setVisible(false);
                    price.setVisible(false);
                    major.setVisible(false);
                    detail.setVisible(false);
                    describe.setVisible(false);
                }
            }
        });
        btnsearch.setBounds(602, 55, 141, 46);
        frmProductManagement.getContentPane().add(btnsearch);
    }
}
