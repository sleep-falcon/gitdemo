package Mysqljdbc;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
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
public class Bus {

    JFrame frmMerchant;
    int id;

    /**
     * Create the application.
     */
    public Bus(int n) {
        id = n;
        initialize();
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        frmMerchant = new JFrame();
        frmMerchant.setTitle("merchant");
        frmMerchant.setBounds(100, 100, 768, 523);
        frmMerchant.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frmMerchant.getContentPane().setLayout(null);

        JLabel lblNewLabel = new JLabel("welcome!");
        lblNewLabel.setFont(new Font("宋体", Font.PLAIN, 25));
        lblNewLabel.setBounds(487, 63, 195, 63);
        frmMerchant.getContentPane().add(lblNewLabel);

        JButton btnNewButton = new JButton("category management");
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frmMerchant.dispose();
                catm cc = new catm(id);
                cc.frmCategoryManagement.setVisible(true);
            }
        });
        btnNewButton.setFont(new Font("宋体", Font.PLAIN, 16));
        btnNewButton.setBounds(27, 63, 204, 63);
        frmMerchant.getContentPane().add(btnNewButton);

        JButton btnNewButton_1 = new JButton("product management");
        btnNewButton_1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frmMerchant.dispose();
                item c = new item(id);
                c.frmProductManagement.setVisible(true);
            }
        });
        btnNewButton_1.setFont(new Font("宋体", Font.PLAIN, 16));
        btnNewButton_1.setBounds(166, 161, 195, 63);
        frmMerchant.getContentPane().add(btnNewButton_1);

        JButton btnNewButton_2 = new JButton("order management");
        btnNewButton_2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frmMerchant.dispose();
                Border b = new Border(id);
                b.frmOrderManagement.setVisible(true);
            }
        });
        btnNewButton_2.setFont(new Font("宋体", Font.PLAIN, 16));
        btnNewButton_2.setBounds(319, 254, 172, 63);
        frmMerchant.getContentPane().add(btnNewButton_2);

        JButton btnNewButton_3 = new JButton("order statistics");
        btnNewButton_3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frmMerchant.dispose();
                Bstatistics aaa = new Bstatistics(id);
                aaa.frmOrderStatistics.setVisible(true);
            }
        });
        btnNewButton_3.setFont(new Font("宋体", Font.PLAIN, 16));
        btnNewButton_3.setBounds(487, 346, 172, 63);
        frmMerchant.getContentPane().add(btnNewButton_3);

        JButton btnNewButton_4 = new JButton("back");
        btnNewButton_4.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frmMerchant.dispose();
                log fr = new log();
            }
        });
        btnNewButton_4.setFont(new Font("宋体", Font.PLAIN, 16));
        btnNewButton_4.setBounds(86, 389, 111, 44);
        frmMerchant.getContentPane().add(btnNewButton_4);
    }

}