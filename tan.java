package Mysqljdbc;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
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
public class tan {

    JFrame frmSearchByClass;
    private JTextField textField;
    private JTextField textField_1;
    int id;

    /**
     * Create the application.
     */
    public tan(int n) {
        id = n;
        initialize();
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        frmSearchByClass = new JFrame();
        frmSearchByClass.setTitle("search by class");
        frmSearchByClass.setBounds(100, 100, 684, 428);
        frmSearchByClass.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frmSearchByClass.getContentPane().setLayout(null);

        JLabel lblNewLabel_2 = new JLabel("the number of all orders");
        lblNewLabel_2.setFont(new Font("宋体", Font.PLAIN, 14));
        lblNewLabel_2.setBounds(65, 173, 189, 45);
        frmSearchByClass.getContentPane().add(lblNewLabel_2);

        JLabel lblNewLabel_3 = new JLabel("total price");
        lblNewLabel_3.setFont(new Font("宋体", Font.PLAIN, 14));
        lblNewLabel_3.setBounds(65, 240, 166, 48);
        frmSearchByClass.getContentPane().add(lblNewLabel_3);

        JLabel renum = new JLabel("");
        renum.setBounds(251, 183, 334, 27);
        frmSearchByClass.getContentPane().add(renum);

        JLabel reprice = new JLabel("");
        reprice.setBounds(251, 245, 334, 30);
        frmSearchByClass.getContentPane().add(reprice);

        JLabel result = new JLabel("No finding!");
        result.setVisible(false);
        result.setFont(new Font("宋体", Font.PLAIN, 16));
        result.setBounds(72, 330, 250, 46);
        frmSearchByClass.getContentPane().add(result);

        JLabel lblNewLabel = new JLabel("major class");
        lblNewLabel.setFont(new Font("宋体", Font.PLAIN, 16));
        lblNewLabel.setBounds(86, 36, 116, 27);
        frmSearchByClass.getContentPane().add(lblNewLabel);

        JLabel lblNewLabel_1 = new JLabel("detail class");
        lblNewLabel_1.setFont(new Font("宋体", Font.PLAIN, 16));
        lblNewLabel_1.setBounds(86, 88, 116, 27);
        frmSearchByClass.getContentPane().add(lblNewLabel_1);

        textField = new JTextField();
        textField.setBounds(237, 36, 258, 27);
        frmSearchByClass.getContentPane().add(textField);
        textField.setColumns(10);

        textField_1 = new JTextField();
        textField_1.setBounds(237, 88, 258, 25);
        frmSearchByClass.getContentPane().add(textField_1);
        textField_1.setColumns(10);
        JButton btnNewButton = new JButton("search");
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                renum.setText(null);
                reprice.setText(null);
                result.setVisible(false);
                String[] str = new String[2];
                str[0] = textField.getText();
                str[1] = textField_1.getText();
                try
                {
                    str = searcher.search2(id,str);
                    renum.setText(str[0]);
                    reprice.setText(str[1]);
                }
                catch(Exception e1)
                {
                    result.setVisible(true);
                }
            }
        });
        btnNewButton.setFont(new Font("宋体", Font.PLAIN, 16));
        btnNewButton.setBounds(502, 341, 149, 35);
        frmSearchByClass.getContentPane().add(btnNewButton);
    }
}