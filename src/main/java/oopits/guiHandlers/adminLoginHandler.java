package oopits.guiHandlers;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import oopits.Admin;
import oopits.guiHelper;

public class adminLoginHandler extends myFrame implements ActionListener {

    JTextField unameIn = new JTextField();
    JPasswordField passIn = new JPasswordField();
    JButton adminlogin = new JButton("Log In");
    JButton back = new JButton("Main Menu");
    JPanel loginPanel = new JPanel();
    JLabel errorMessage;

    protected String type;


    public adminLoginHandler() {

        JLabel registerText = new JLabel();
        registerText.setText("Log In");
        registerText.setForeground(Color.WHITE);
        registerText.setLayout(null);
        registerText.setBounds(10, 133, 591, 84);
        registerText.setFont(new Font("Poppins", Font.BOLD, 56));

        JLabel unameText = new JLabel();
        unameText.setText("Username");
        unameText.setForeground(Color.WHITE);
        unameText.setLayout(null);
        unameText.setBounds(18, 7, 100, 12);
        unameText.setFont(new Font("Poppins", Font.PLAIN, 11));
        unameText.setFocusable(false);
        
        unameIn.setBounds(20, 22, 495, 21);
        unameIn.setBackground(Color.decode("#514B96"));
        unameIn.setForeground(Color.GRAY);
        unameIn.setOpaque(true);
        unameIn.setBorder(null);

        JPanel uname = new JPanel();
        uname.setLayout(null);
        uname.setBounds(10, 314, 520, 46);
        uname.setBackground(Color.decode("#514B96"));
        uname.setOpaque(true);
        uname.add(unameText);
        uname.add(unameIn);

        JLabel passText = new JLabel();
        passText.setText("Password");
        passText.setForeground(Color.WHITE);
        passText.setLayout(null);
        passText.setBounds(18, 7, 100, 12);
        passText.setFont(new Font("Poppins", Font.PLAIN, 11));
        passText.setFocusable(false);

        passIn.setBounds(20, 22, 495, 21);
        passIn.setBackground(Color.decode("#514B96"));
        passIn.setForeground(Color.GRAY);
        passIn.setOpaque(true);
        passIn.setBorder(null);

        JPanel pass = new JPanel();
        pass.setLayout(null);
        pass.setBounds(10, 374, 520, 46);
        pass.setBackground(Color.decode("#514B96"));
        pass.setOpaque(true);
        pass.add(passText);
        pass.add(passIn);

        errorMessage = new JLabel();
        errorMessage.setText("*Both username and password must be entered.");
        errorMessage.setForeground(Color.RED);
        errorMessage.setBounds(18, 404, 350, 80);
        errorMessage.setVisible(false);
        

        adminlogin.setFont(new Font("Poppins-SemiBold", Font.PLAIN, 16));
        adminlogin.setBackground(Color.decode("#47458"));
        adminlogin.setBounds(10, 474, 250, 46);
        adminlogin.setForeground(Color.BLACK);
        adminlogin.addActionListener(this);

        back.setFont(new Font("Poppins-SemiBold", Font.PLAIN, 16));
        back.setBackground(Color.decode("#47458"));
        back.setBounds(280, 474, 250, 46);
        back.setForeground(Color.BLACK);
        back.addActionListener(this);

        loginPanel.setLayout(null);
        loginPanel.setBounds(50, 0, 593, 563);
        loginPanel.setOpaque(false);
        loginPanel.add(registerText);
        loginPanel.add(uname);
        loginPanel.add(pass);
        loginPanel.add(errorMessage);
        loginPanel.add(adminlogin);
        loginPanel.add(back);

        this.add(loginPanel);
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == adminlogin) {
            if (guiHelper.checkNoFieldsEmpty(unameIn, passIn)) {
                System.out.println(Admin.guiAuth(unameIn.getText(), String.valueOf(passIn.getPassword())));
                 
            } else {
                errorMessage.setVisible(true);
            }
        } else if (e.getSource() == back) {
            dispose();
            new welcomeHandler();
        }
    }

}