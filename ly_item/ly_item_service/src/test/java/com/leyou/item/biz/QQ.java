package com.leyou.item.biz;


import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JPasswordField;

import java.awt.Label;
import java.awt.Color;

import javax.swing.JCheckBox;

import java.awt.Button;

import javax.swing.border.CompoundBorder;
import javax.swing.JComboBox;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.Scanner;

public class QQ extends JFrame {

    private JPanel contentPane;
    private JPasswordField passwordField;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    QQ frame = new QQ();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the frame.
     */
    public QQ() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 517, 318);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JPanel panel = new JPanel();
        panel.setBorder(new CompoundBorder(new CompoundBorder(), null));
        panel.setBounds(0, 10, 491, 118);
        contentPane.add(panel);
        panel.setLayout(null);


        JLabel lblImagel = new JLabel(new ImageIcon("./pig/3.png"));
        lblImagel.setBounds(0, 10, 491, 118);
        panel.add( lblImagel);

        JPanel panel_1 = new JPanel();
        panel_1.setBounds(104, 138, 236, 27);
        contentPane.add(panel_1);
        panel_1.setLayout(null);

        JComboBox comboBox = new JComboBox();
        comboBox.setBounds(0, 0, 236, 27);
        Scanner scan = new Scanner(System.in);
        String read = scan.nextLine();
        comboBox.addItem(read);

       /* comboBox.addItem("369431735");
        comboBox.addItem("809619573");*/
        panel_1.add(comboBox);

        JPanel panel_2 = new JPanel();
        panel_2.setBounds(346, 138, 78, 27);
        contentPane.add(panel_2);
        panel_2.setLayout(null);

        Label label = new Label("\u6CE8\u518C\u8D26\u53F7");
        label.setForeground(Color.BLUE);
        label.setAlignment(Label.CENTER);
        label.setBounds(0, 0, 78, 27);
        panel_2.add(label);

        JPanel panel_3 = new JPanel();
        panel_3.setBounds(350, 175, 74, 26);
        contentPane.add(panel_3);
        panel_3.setLayout(null);

        Label label_1 = new Label("\u5FD8\u8BB0\u5BC6\u7801");
        label_1.setAlignment(Label.CENTER);
        label_1.setBounds(0, 0, 72, 23);
        label_1.setForeground(Color.BLUE);
        panel_3.add(label_1);

        JPanel panel_4 = new JPanel();
        panel_4.setBounds(104, 174, 236, 27);
        contentPane.add(panel_4);
        panel_4.setLayout(null);

        passwordField = new JPasswordField();
        passwordField.setBackground(new Color(220, 220, 220));
        passwordField.setBounds(0, 0, 237, 26);
        panel_4.add(passwordField);

        JPanel panel_5 = new JPanel();
        panel_5.setBounds(104, 213, 236, 27);
        contentPane.add(panel_5);
        panel_5.setLayout(null);

        JCheckBox chckbxNewCheckBox = new JCheckBox("\u8BB0\u4F4F\u5BC6\u7801");
        chckbxNewCheckBox.setBounds(21, 5, 90, 23);
        panel_5.add(chckbxNewCheckBox);

        JCheckBox checkBox = new JCheckBox("\u81EA\u52A8\u767B\u5F55");
        checkBox.setBounds(127, 5, 90, 23);
        panel_5.add(checkBox);

        JPanel panel_6 = new JPanel();
        panel_6.setBounds(30, 128, 64, 69);
        contentPane.add(panel_6);



        JLabel lblImage = new JLabel(new ImageIcon("./pig/2.png"));
        lblImage.setBounds(20, 128, 74, 79);
        panel_6.add( lblImage);

        JPanel panel_7 = new JPanel();
        panel_7.setBounds(104, 250, 236, 27);
        contentPane.add(panel_7);
        panel_7.setLayout(null);

        Button button = new Button("\u767B\u5F55");
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
            }
        });
        button.setBackground(new Color(0, 51, 255));
        button.setBounds(0, 0, 236, 28);
        panel_7.add(button);
    }
}
