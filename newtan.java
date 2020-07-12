package Mysqljdbc;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;

/**
 * Title	     :
 * Description:
 * Copyright  : Copyright (c) 2006 - 2020
 * @author YUAN Liyao
 * @version
 * @author
 * @version
 */
public class newtan {

    JFrame frame;
    String[] sss;

    /**
     * Create the application.
     */
    public newtan(String[] str) {
        sss = str;
        initialize();
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        frame = new JFrame();
        frame.setBounds(100, 100, 450, 300);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        JLabel lblNewLabel_2 = new JLabel("the number of all orders");
        lblNewLabel_2.setFont(new Font("宋体", Font.PLAIN, 14));
        lblNewLabel_2.setBounds(30, 58, 189, 45);
        frame.getContentPane().add(lblNewLabel_2);

        JLabel lblNewLabel_3 = new JLabel("total price");
        lblNewLabel_3.setFont(new Font("宋体", Font.PLAIN, 14));
        lblNewLabel_3.setBounds(30, 113, 166, 48);
        frame.getContentPane().add(lblNewLabel_3);

        JLabel renum = new JLabel("");
        renum.setText(sss[0]);
        renum.setBounds(215, 64, 211, 33);
        frame.getContentPane().add(renum);

        JLabel reprice = new JLabel("");
        reprice.setText(sss[1]);
        reprice.setBounds(149, 121, 258, 33);
        frame.getContentPane().add(reprice);
    }

}