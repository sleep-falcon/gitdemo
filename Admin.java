package Mysqljdbc;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.GridBagLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 * Title	     :hello
 * Description:
 * Copyright  : Copyright (c) 2006 - 2020
 * @author YUAN Liyao
 * @version
 * @author
 * @version
 */
public class Admin {

    JFrame frmAdministrator;
    int id;


    /**
     * Create the application.
     */
    public Admin(int n) {
        id = n;
        initialize();
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        frmAdministrator = new JFrame();
        frmAdministrator.setTitle("Administrator");
        frmAdministrator.setBounds(100, 100, 715, 405);
        frmAdministrator.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frmAdministrator.getContentPane().setLayout(null);

        JButton btnNewButton = new JButton("manage merchant");
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frmAdministrator.dispose();
                merm fr = new merm(id);
                fr.frmMerchantManagement.setVisible(true);
            }
        });
        btnNewButton.setFont(new Font("宋体", Font.PLAIN, 16));
        btnNewButton.setBounds(271, 176, 161, 47);
        frmAdministrator.getContentPane().add(btnNewButton);

        JButton btnNewButton_1 = new JButton("order statistics");
        btnNewButton_1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frmAdministrator.dispose();
                mm pp = new mm(id);
                pp.frmOrderStatistics.setVisible(true);
            }
        });
        btnNewButton_1.setFont(new Font("宋体", Font.PLAIN, 16));
        btnNewButton_1.setBounds(459, 108, 167, 47);
        frmAdministrator.getContentPane().add(btnNewButton_1);

        JButton btnNewButton_2 = new JButton("manage customer");
        btnNewButton_2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frmAdministrator.dispose();
                userm uu = new userm(id);
                uu.frmUserManagement.setVisible(true);
            }
        });
        btnNewButton_2.setFont(new Font("宋体", Font.PLAIN, 16));
        btnNewButton_2.setBounds(60, 258, 161, 47);
        frmAdministrator.getContentPane().add(btnNewButton_2);

        JLabel lblNewLabel = new JLabel("WELCOME!");
        lblNewLabel.setFont(new Font("宋体", Font.PLAIN, 25));
        lblNewLabel.setBounds(60, 56, 238, 47);
        frmAdministrator.getContentPane().add(lblNewLabel);

        JButton btnNewButton_3 = new JButton("back");
        btnNewButton_3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frmAdministrator.dispose();
                log fr = new log();
            }
        });
        btnNewButton_3.setFont(new Font("宋体", Font.PLAIN, 18));
        btnNewButton_3.setBounds(493, 284, 142, 34);
        frmAdministrator.getContentPane().add(btnNewButton_3);
    }
}

