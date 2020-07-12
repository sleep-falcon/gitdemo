package Mysqljdbc;

import java.awt.EventQueue;

import javax.swing.*;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Title	     :
 * Description:
 * Copyright  : Copyright (c) 2006 - 2020
 * @author YUAN Liyao
 * @version
 * @author
 * @version
 */
public class Border {

    JFrame frmOrderManagement;
    private JTextField input;
    int id;

    /**
     * Create the application.
     */
    public Border(int n) {
        id = n;
        initialize();
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        frmOrderManagement = new JFrame();
        frmOrderManagement.setTitle("order management");
        frmOrderManagement.setBounds(100, 100, 663, 454);
        frmOrderManagement.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frmOrderManagement.getContentPane().setLayout(null);

        JLabel result = new JLabel("");
        result.setFont(new Font("宋体", Font.PLAIN, 14));
        result.setBounds(359, 127, 600, 55);
        frmOrderManagement.getContentPane().add(result);

        JLabel lblNewLabel = new JLabel("input the productID to deliver the products:");
        lblNewLabel.setFont(new Font("宋体", Font.PLAIN, 16));
        lblNewLabel.setBounds(54, 157, 488, 35);
        frmOrderManagement.getContentPane().add(lblNewLabel);

        input = new JTextField();
        input.setBounds(225, 270, 249, 35);
        frmOrderManagement.getContentPane().add(input);
        input.setColumns(10);

        JLabel lblNewLabel_1 = new JLabel("input the productID");
        lblNewLabel_1.setFont(new Font("宋体", Font.PLAIN, 16));
        lblNewLabel_1.setBounds(54, 269, 161, 35);
        frmOrderManagement.getContentPane().add(lblNewLabel_1);

        JLabel lblNewLabel_2 = new JLabel("Tip: you can only manage your order.");
        lblNewLabel_2.setFont(new Font("宋体", Font.PLAIN, 13));
        lblNewLabel_2.setBounds(10, 364, 256, 29);
        frmOrderManagement.getContentPane().add(lblNewLabel_2);

        JLabel lblNewLabel_3 = new JLabel("input order ID");
        lblNewLabel_3.setFont(new Font("宋体", Font.PLAIN, 16));
        lblNewLabel_3.setBounds(54, 217, 161, 29);
        frmOrderManagement.getContentPane().add(lblNewLabel_3);

        JTextField textField = new JTextField();
        textField.setBounds(225, 217, 249, 26);
        frmOrderManagement.getContentPane().add(textField);
        textField.setColumns(10);


        JButton search = new JButton("find all order ");
        search.addActionListener(new AbstractAction() {
            public void actionPerformed(ActionEvent e) {
                if(order.search(id)==0)
                {
                    result.setText("You have no order.");
                }

            }
        });
        search.setFont(new Font("宋体", Font.PLAIN, 16));
        search.setBounds(54, 82, 225, 55);
        frmOrderManagement.getContentPane().add(search);

        JButton update = new JButton("deliver goods");
        update.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String[] oid = new String[2];
                oid[0] = input.getText();
                oid[1] = textField.getText();
                result.setText(null);
                if(order.deliver(oid,id)==1)
                {
                    result.setText("The order is delivered successfully!");
                }
                else
                {
                    result.setText("Something wrong happened!");
                }
            }
        });
        update.setFont(new Font("宋体", Font.PLAIN, 16));
        update.setBounds(313, 325, 142, 35);
        frmOrderManagement.getContentPane().add(update);

        JButton btnNewButton = new JButton("back");
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frmOrderManagement.dispose();
                Bus bbb = new Bus(id);
                bbb.frmMerchant.setVisible(true);
            }
        });
        btnNewButton.setFont(new Font("宋体", Font.PLAIN, 16));
        btnNewButton.setBounds(499, 370, 111, 37);
        frmOrderManagement.getContentPane().add(btnNewButton);
    }
}