package Mysqljdbc;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTable;
import java.awt.Font;
import javax.swing.JTextField;
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
public class catm {

    JFrame frmCategoryManagement;
    private JTextField t_odc;
    private JTextField t_omc;
    private JTextField t_ndc;
    private JTextField t_nmc;
    int id;

    /**
     * Create the application.
     */
    public catm(int n) {
        id = n;
        initialize();
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        frmCategoryManagement = new JFrame();
        frmCategoryManagement.setTitle("category management");
        frmCategoryManagement.setBounds(100, 100, 790, 512);
        frmCategoryManagement.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frmCategoryManagement.getContentPane().setLayout(null);

        JLabel odc = new JLabel("old DetailClass");
        odc.setVisible(false);
        odc.setFont(new Font("宋体", Font.PLAIN, 16));
        odc.setBounds(256, 105, 131, 45);
        frmCategoryManagement.getContentPane().add(odc);

        JLabel omc = new JLabel("old MajorClass");
        omc.setVisible(false);
        omc.setFont(new Font("宋体", Font.PLAIN, 16));
        omc.setBounds(256, 175, 152, 45);
        frmCategoryManagement.getContentPane().add(omc);

        JLabel ndc = new JLabel("new DetailClass");
        ndc.setVisible(false);
        ndc.setFont(new Font("宋体", Font.PLAIN, 16));
        ndc.setBounds(256, 246, 131, 45);
        frmCategoryManagement.getContentPane().add(ndc);

        JLabel nmc = new JLabel("new MajorClass");
        nmc.setVisible(false);
        nmc.setFont(new Font("宋体", Font.PLAIN, 16));
        nmc.setBounds(256, 327, 131, 33);
        frmCategoryManagement.getContentPane().add(nmc);

        t_odc = new JTextField();
        t_odc.setVisible(false);
        t_odc.setBounds(397, 105, 317, 34);
        frmCategoryManagement.getContentPane().add(t_odc);
        t_odc.setColumns(10);

        t_omc = new JTextField();
        t_omc.setVisible(false);
        t_omc.setBounds(397, 175, 317, 34);
        frmCategoryManagement.getContentPane().add(t_omc);
        t_omc.setColumns(10);

        t_ndc = new JTextField();
        t_ndc.setVisible(false);
        t_ndc.setBounds(397, 246, 317, 34);
        frmCategoryManagement.getContentPane().add(t_ndc);
        t_ndc.setColumns(10);

        t_nmc = new JTextField();
        t_nmc.setVisible(false);
        t_nmc.setBounds(397, 320, 317, 34);
        frmCategoryManagement.getContentPane().add(t_nmc);
        t_nmc.setColumns(10);

        JLabel result = new JLabel("");
        result.setFont(new Font("宋体", Font.PLAIN, 16));
        result.setBounds(256, 24, 441, 33);
        frmCategoryManagement.getContentPane().add(result);

        JButton btninsert = new JButton("insert");
        btninsert.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                result.setText(null);
                if(btninsert.getText().equals("insert"))
                {
                    btninsert.setText("verify");
                    ndc.setVisible(true);
                    nmc.setVisible(true);
                    t_ndc.setVisible(true);
                    t_nmc.setVisible(true);
                }
                else
                {
                    String str[] = new String[4];
                    str[0] = t_ndc.getText();
                    str[1] = t_nmc.getText();
                    if(test4.insert(str)==1)
                        result.setText("Insert successfully!");
                    else
                        result.setText("Insert failed!");
                    btninsert.setText("insert");
                    t_ndc.setText(null);
                    t_nmc.setText(null);
                    ndc.setVisible(false);
                    nmc.setVisible(false);
                    t_ndc.setVisible(false);
                    t_nmc.setVisible(false);
                }
            }
        });
        btninsert.setFont(new Font("宋体", Font.PLAIN, 16));
        btninsert.setBounds(23, 50, 152, 45);
        frmCategoryManagement.getContentPane().add(btninsert);

        JButton btndelete = new JButton("delete");
        btndelete.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                result.setText(null);
                if(btndelete.getText().equals("delete"))
                {
                    btndelete.setText("verify");
                    odc.setVisible(true);
                    omc.setVisible(true);
                    t_odc.setVisible(true);
                    t_omc.setVisible(true);
                }
                else
                {
                    String str[] = new String[2];
                    str[0] = t_odc.getText();
                    str[1] = t_omc.getText();
                    if(test4.delete(str)==1)
                        result.setText("Delete successfully!");
                    else
                        result.setText("Delete failed!");
                    btndelete.setText("delete");
                    t_odc.setText(null);
                    t_omc.setText(null);
                    odc.setVisible(false);
                    omc.setVisible(false);
                    t_odc.setVisible(false);
                    t_omc.setVisible(false);
                }
            }
        });
        btndelete.setFont(new Font("宋体", Font.PLAIN, 16));
        btndelete.setBounds(23, 132, 152, 45);
        frmCategoryManagement.getContentPane().add(btndelete);

        JButton btnupdate = new JButton("update");
        btnupdate.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                result.setText(null);
                if(btnupdate.getText().equals("update"))
                {
                    btnupdate.setText("verify");
                    odc.setVisible(true);
                    omc.setVisible(true);
                    t_odc.setVisible(true);
                    t_omc.setVisible(true);
                    ndc.setVisible(true);
                    nmc.setVisible(true);
                    t_ndc.setVisible(true);
                    t_nmc.setVisible(true);
                }
                else
                {
                    String str[] = new String[4];
                    str[0] = t_odc.getText();
                    str[1] = t_omc.getText();
                    str[2] = t_ndc.getText();
                    str[3] = t_nmc.getText();
                    if(test4.update(str)==1)
                        result.setText("Update successfully!");
                    else
                        result.setText("Update failed!");
                    btnupdate.setText("update");
                    t_ndc.setText(null);
                    t_nmc.setText(null);
                    ndc.setVisible(false);
                    nmc.setVisible(false);
                    t_ndc.setVisible(false);
                    t_nmc.setVisible(false);
                    t_odc.setText(null);
                    t_omc.setText(null);
                    odc.setVisible(false);
                    omc.setVisible(false);
                    t_odc.setVisible(false);
                    t_omc.setVisible(false);
                }
            }
        });
        btnupdate.setFont(new Font("宋体", Font.PLAIN, 16));
        btnupdate.setBounds(23, 221, 152, 45);
        frmCategoryManagement.getContentPane().add(btnupdate);

        JButton btnsearch = new JButton("search");
        btnsearch.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if(test4.search()==1)
                    result.setText("Search successfully!");
                else
                    result.setText("Search failed!");
            }
        });
        btnsearch.setFont(new Font("宋体", Font.PLAIN, 16));
        btnsearch.setBounds(23, 320, 152, 45);
        frmCategoryManagement.getContentPane().add(btnsearch);

        JButton btnNewButton = new JButton("back");
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frmCategoryManagement.dispose();
                Bus bbb = new Bus(id);
                bbb.frmMerchant.setVisible(true);
            }
        });
        btnNewButton.setFont(new Font("宋体", Font.PLAIN, 16));
        btnNewButton.setBounds(585, 399, 152, 51);
        frmCategoryManagement.getContentPane().add(btnNewButton);
    }
}
