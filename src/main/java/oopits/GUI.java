package oopits;

import java.awt.*;
import javax.swing.*;


public class GUI{

    public GUI(){
    JFrame frame = new JFrame("My GUI Trial");
    JLabel l = new JLabel();
    JLabel l2 = new JLabel();
    l.setText("Welcome to Climate Change Monitor!");
    l.setForeground(Color.DARK_GRAY);
    l.setFont(new Font("Arial", Font.BOLD, 50));
    l.setOpaque(true);
    l.setBackground(new Color(0xC0DF85));
    l.setHorizontalAlignment(JLabel.CENTER);
    l.setVerticalAlignment(JLabel.TOP);
    // l.setBounds(25, 40, 950, 600);
    l.setBounds(25, 40, 950,60);
    l2.setBackground(Color.LIGHT_GRAY);
    l2.setOpaque(true);
    l2.setText("Special thanks to my team Zameer Sai Ahmad Evan Leron Jonathan Junaadh Naeema Michael Arell!");
    l2.setHorizontalAlignment(JLabel.CENTER);
    l2.setFont(new Font("Arial", Font.BOLD, 19));
    l2.setForeground(Color.DARK_GRAY);
    l2.setVerticalAlignment(0);



    frame.add(l);
    frame.add(l2);
    frame.setBounds(400,220,1000, 700);
    // frame.setLayout(null);
    frame.setVisible(true);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.getContentPane().setBackground(Color.white);
    frame.setBackground(new Color(0x7BC950));

    }
}