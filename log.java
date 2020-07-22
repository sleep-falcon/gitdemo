package Mysqljdbc;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JPasswordField;

/**
 * Title	     : 登录界面
 * Description: 实现登录功能
 * Copyright  : Copyright (c) 2006 - 2020
 * @author YUAN Liyao
 * @version 1.0
 */
public class log  {

    private JPanel contentPane;
    private JTextField textField;
    private JPasswordField passwordField;
    private JFrame frame;
    private JLabel lblNewLabel_2;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        log start = new log();
    }

    /**
     * Create the frame.
     */
    public log() {
        frame = new JFrame();
        frame.setTitle("Login");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setBounds(100, 100, 835, 538);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        frame.setContentPane(contentPane);
        contentPane.setLayout(null);
        frame.setVisible(true);

        JLabel lblNewLabel = new JLabel("input your userID: ");
        lblNewLabel.setFont(new Font("宋体", Font.BOLD, 20));
        lblNewLabel.setBounds(36, 68, 239, 86);
        contentPane.add(lblNewLabel);

        JLabel lblNewLabel_1 = new JLabel("input your password: ");
        lblNewLabel_1.setFont(new Font("宋体", Font.BOLD, 20));
        lblNewLabel_1.setBounds(36, 236, 239, 94);
        contentPane.add(lblNewLabel_1);

        textField = new JTextField();
        textField.setBounds(285, 81, 303, 42);
        contentPane.add(textField);
        textField.setVisible(true);
        textField.setColumns(10);

        passwordField = new JPasswordField();
        passwordField.setBounds(285, 254, 303, 42);
        passwordField.setVisible(true);
        contentPane.add(passwordField);

        JButton btnNewButton = new JButton("login");
        btnNewButton.setFont(new Font("宋体", Font.BOLD, 18));
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int loginName=-1;
                try{
                    loginName = Integer.parseInt(textField.getText());
                }
                catch(Exception e1)
                {
                    lblNewLabel_2.setText("wrong password or username!");
                    textField.setText(null);
                    passwordField.setText(null);
                }
                if(loginName!=-1) {
                    String loginPaw = passwordField.getText();
                    if (test.logcheck(loginName, loginPaw) == 1) {
                        frame.dispose();
                        Admin nfr = new Admin(loginName);
                        nfr.frmAdministrator.setVisible(true);
                    } else if (test.logcheck(loginName, loginPaw) == 2) {
                        frame.dispose();
                        Bus nfr = new Bus(loginName);
                        nfr.frmMerchant.setVisible(true);
                    } else {
                        lblNewLabel_2.setText("wrong password or username!");
                        textField.setText(null);
                        passwordField.setText(null);
                    }
                }
            }
        });
        btnNewButton.setBounds(398, 395, 160, 42);
        contentPane.add(btnNewButton);

        lblNewLabel_2 = new JLabel("");
        lblNewLabel_2.setBounds(160, 409, 200, 28);
        contentPane.add(lblNewLabel_2);
    }
}

