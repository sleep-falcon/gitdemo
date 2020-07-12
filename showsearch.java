package Mysqljdbc;

import java.awt.*;

import javax.swing.JFrame;
import javax.swing.JScrollBar;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;

/**
 * Title	     :
 * Description:
 * Copyright  : Copyright (c) 2006 - 2020
 * @author YUAN Liyao
 * @version
 * @author
 * @version
 */
public class showsearch {

    JFrame frmResult;
    String re;
    JTextArea textArea;
    /**
     * Create the application.
     */
    public showsearch(String rs) {
        re = rs;
        initialize();
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        frmResult = new JFrame();
        frmResult.setTitle("result");
        frmResult.setBounds(100, 100, 798, 552);
        frmResult.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);


        textArea = new JTextArea(1,5);
        textArea.setFont(new Font("宋体", Font.PLAIN, 20));
        textArea.setText(re);
        JScrollPane scrollPane = new JScrollPane(textArea);
        frmResult.getContentPane().add(scrollPane);
    }

}

