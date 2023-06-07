package oopits.guiHandlers;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JLabel;

import oopits.User;
import oopits.guiHelper;

public class userLoginHandler extends adminLoginHandler{

    JButton userLogin = new JButton("Log In");
    
    userLoginHandler() {

        userLogin.setFont(new Font("Poppins-SemiBold", Font.PLAIN, 16));
        userLogin.setBackground(Color.decode("#47458"));
        userLogin.setBounds(10, 474, 250, 46);
        userLogin.setForeground(Color.BLACK);
        userLogin.addActionListener(this);

        JLabel text = new JLabel();
        text.setText("Dont have an account yet? ");
        text.setBounds(18, 534, 216, 25);
        text.setFont(new Font("Poppins", Font.PLAIN, 16));

        JLabel register = new JLabel("Register");
        register.setBounds(225, 534, 100, 25);
        register.setForeground(Color.BLUE);
        register.setFont(new Font("Poppins", Font.PLAIN, 16));
        register.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        register.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent a) {
                dispose();
                new registrationHandler();
            
            }   
        });

        this.adminlogin.setVisible(false);
        this.loginPanel.add(userLogin);
        this.loginPanel.add(text);
        this.loginPanel.add(register);
        //this.remove(adminlogin);
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == userLogin) {
            if (guiHelper.checkNoFieldsEmpty(unameIn, passIn)) {
                System.out.println(User.guiLogin(unameIn.getText(), String.valueOf(passIn.getPassword())));
                 
            } else {
                errorMessage.setVisible(true);
            }
        } else if (e.getSource() == back) {
            dispose();
            new welcomeHandler();
        } else {
            return;
        }
    }
    
}