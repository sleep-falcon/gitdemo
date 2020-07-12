package Mysqljdbc;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPanel;

/**
 * Title	     :
 * Description: 管理商家
 * Copyright  : Copyright (c) 2006 - 2020
 * @author YUAN Liyao
 * @version
 * @author
 * @version
 */
public class merm {

    JFrame frmMerchantManagement;
    private JTextField ID;
    private JTextField pass;
    private JTextField name;
    private JTextField info;
    int id;

    /**
     * Create the application.
     */
    public merm(int n) {
        id = n;
        initialize();
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        frmMerchantManagement = new JFrame();
        frmMerchantManagement.setTitle("merchant management");
        frmMerchantManagement.setBounds(100, 100, 736, 521);
        frmMerchantManagement.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frmMerchantManagement.getContentPane().setLayout(null);

        JLabel lblNewLabel_1 = new JLabel("choose the service");
        lblNewLabel_1.setFont(new Font("宋体", Font.PLAIN, 20));
        lblNewLabel_1.setBounds(27, 68, 197, 36);
        frmMerchantManagement.getContentPane().add(lblNewLabel_1);


        JLabel lb_ID = new JLabel("    merchantID");
        lb_ID.setVisible(false);
        lb_ID.setFont(new Font("宋体", Font.PLAIN, 16));
        lb_ID.setBounds(271, 121, 137, 55);
        frmMerchantManagement.getContentPane().add(lb_ID);

        JLabel lbname = new JLabel("     name");
        lbname.setVisible(false);
        lbname.setFont(new Font("宋体", Font.PLAIN, 16));
        lbname.setBounds(290, 258, 129, 25);
        frmMerchantManagement.getContentPane().add(lbname);

        JLabel lbinfo = new JLabel("     information");
        lbinfo.setVisible(false);
        lbinfo.setFont(new Font("宋体", Font.PLAIN, 16));
        lbinfo.setBounds(271, 317, 149, 31);
        frmMerchantManagement.getContentPane().add(lbinfo);

        JLabel lb_pass = new JLabel("     password");
        lb_pass.setVisible(false);
        lb_pass.setFont(new Font("宋体", Font.PLAIN, 16));
        lb_pass.setBounds(281, 203, 137, 25);
        frmMerchantManagement.getContentPane().add(lb_pass);

        ID = new JTextField();
        ID.setVisible(false);
        ID.setBounds(430, 130, 250, 39);
        frmMerchantManagement.getContentPane().add(ID);
        ID.setColumns(10);

        pass = new JTextField();
        pass.setVisible(false);
        pass.setColumns(10);
        pass.setBounds(430, 189, 250, 39);
        frmMerchantManagement.getContentPane().add(pass);

        name = new JTextField();
        name.setVisible(false);
        name.setColumns(10);
        name.setBounds(430, 244, 250, 39);
        frmMerchantManagement.getContentPane().add(name);

        info = new JTextField();
        info.setVisible(false);
        info.setColumns(10);
        info.setBounds(430, 309, 250, 39);
        frmMerchantManagement.getContentPane().add(info);

        JLabel result = new JLabel("");
        result.setFont(new Font("宋体", Font.PLAIN, 16));
        result.setBounds(361, 39, 268, 39);
        frmMerchantManagement.getContentPane().add(result);

        JLabel cao = new JLabel("please input the merchantID to update");
        cao.setVisible(false);
        cao.setBounds(271, 81, 409, 44);
        frmMerchantManagement.getContentPane().add(cao);

        JButton btninsert = new JButton("insert");
        btninsert.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                result.setText(null);
                if(btninsert.getText().equals("insert"))
                {
                    btninsert.setText("verify");
                    lb_ID.setVisible(true);
                    lb_pass.setVisible(true);
                    lbinfo.setVisible(true);
                    lbname.setVisible(true);
                    ID.setVisible(true);
                    pass.setVisible(true);
                    name.setVisible(true);
                    info.setVisible(true);
                }
                else{
                    String str[] = new String[5];
                    str[0] = ID.getText();
                    str[1] = pass.getText();
                    str[2] = name.getText();
                    str[3] = info.getText();
                    if(test.insert(str)==1)
                    {
                        result.setText("Insert successfully!");
                    }
                    else
                        result.setText("Insert failed!");
                    btninsert.setText("insert");
                    ID.setText(null);
                    pass.setText(null);
                    name.setText(null);
                    info.setText(null);
                    lb_ID.setVisible(false);
                    lb_pass.setVisible(false);
                    lbinfo.setVisible(false);
                    lbname.setVisible(false);
                    ID.setVisible(false);
                    pass.setVisible(false);
                    name.setVisible(false);
                    info.setVisible(false);
                }
            }
        });
        btninsert.setBounds(59, 149, 129, 36);
        frmMerchantManagement.getContentPane().add(btninsert);

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
                    String mID = ID.getText();
                    if(test.delete(mID,"Business")==1)
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
        btndelete.setBounds(59, 236, 129, 36);
        frmMerchantManagement.getContentPane().add(btndelete);

        JButton btnupdate = new JButton("update");
        btnupdate.addActionListener( new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                result.setText(null);
                if(btnupdate.getText().equals("update"))
                {
                    cao.setText("please input the merchantID to update");
                    cao.setVisible(true);
                    btnupdate.setText("verify");
                    lb_ID.setVisible(true);
                    lb_pass.setVisible(true);
                    lbinfo.setVisible(true);
                    lbname.setVisible(true);
                    ID.setVisible(true);
                    pass.setVisible(true);
                    name.setVisible(true);
                    info.setVisible(true);
                }
                else{
                    cao.setVisible(false);
                    String str[] = new String[5];
                    str[0] = ID.getText();
                    str[1] = pass.getText();
                    str[2] = name.getText();
                    str[3] = info.getText();
                    if(test.update(str)==1)
                    {
                        result.setText("Update successfully!");
                    }
                    else
                        result.setText("Update failed!");
                    btnupdate.setText("update");
                    ID.setText(null);
                    pass.setText(null);
                    name.setText(null);
                    info.setText(null);
                    lb_ID.setVisible(false);
                    lb_pass.setVisible(false);
                    lbinfo.setVisible(false);
                    lbname.setVisible(false);
                    ID.setVisible(false);
                    pass.setVisible(false);
                    name.setVisible(false);
                    info.setVisible(false);
            }
        }
    });
        btnupdate.setBounds(59, 317, 129, 36);
        frmMerchantManagement.getContentPane().add(btnupdate);

        JButton btnsearch = new JButton("search");
        btnsearch.addActionListener( new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                result.setText(null);
                if(btnsearch.getText().equals("search"))
                {
                    cao.setText("please input the condition to search");
                    cao.setVisible(true);
                    btnsearch.setText("verify");
                    lb_ID.setVisible(true);
                    lb_pass.setVisible(true);
                    lbinfo.setVisible(true);
                    lbname.setVisible(true);
                    ID.setVisible(true);
                    pass.setVisible(true);
                    name.setVisible(true);
                    info.setVisible(true);
                }
                else{
                    cao.setVisible(false);
                    String str[] = new String[5];
                    str[0] = ID.getText();
                    str[1] = pass.getText();
                    str[2] = name.getText();
                    str[3] = info.getText();
                    if(test.search(str)==1)
                    {
                        result.setText("Search successfully!");
                    }
                    else
                        result.setText("Search failed!");
                    btnsearch.setText("search");
                    ID.setText(null);
                    pass.setText(null);
                    name.setText(null);
                    info.setText(null);
                    lb_ID.setVisible(false);
                    lb_pass.setVisible(false);
                    lbinfo.setVisible(false);
                    lbname.setVisible(false);
                    ID.setVisible(false);
                    pass.setVisible(false);
                    name.setVisible(false);
                    info.setVisible(false);
                }
            }
        });
        btnsearch.setBounds(59, 403, 129, 36);
        frmMerchantManagement.getContentPane().add(btnsearch);

        JButton btnNewButton = new JButton("back");
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frmMerchantManagement.dispose();
                Admin a = new Admin(id);
                a.frmAdministrator.setVisible(true);
            }
        });
        btnNewButton.setFont(new Font("宋体", Font.PLAIN, 16));
        btnNewButton.setBounds(571, 430, 109, 44);
        frmMerchantManagement.getContentPane().add(btnNewButton);

    }
}