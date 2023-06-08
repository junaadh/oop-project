package oopits.guiHandlers;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;

import javax.swing.JButton;
import javax.swing.JLabel;
import oopits.guiHelper;

/**
 * @author Junaadh
 */

 public class monthHandler extends adminLoginHandler {
     
    JLabel text = new JLabel();
    JLabel text2 = new JLabel();
    JButton search = new JButton("Search");
    JButton menu = new JButton("Back");
    
    public monthHandler() {


        text.setText("Energy Usage");
        text.setForeground(Color.WHITE);
        text.setLayout(null);
        text.setBounds(10, 133, 591, 84);
        text.setFont(new Font("Poppins", Font.BOLD, 45));

        text2.setText("Enter month to see usage");
        text2.setForeground(Color.WHITE);
        text2.setLayout(null);
        text2.setBounds(10, 220, 591, 84);
        text2.setFont(new Font("Poppins", Font.BOLD, 20));

        unameText.setText("Month");
        uname.setBounds(10, 394, 520, 46);

        errorMessage.setText("*field cannot be empty");
        errorMessage.setBounds(18, 415, 350, 80);

        search.setFont(new Font("Poppins-SemiBold", Font.PLAIN, 16));
        search.setBackground(Color.decode("#47458"));
        search.setBounds(10, 474, 250, 46);
        search.setForeground(Color.BLACK);
        search.addActionListener(this);

        menu.setFont(new Font("Poppins-SemiBold", Font.PLAIN, 16));
        menu.setBackground(Color.decode("#47458"));
        menu.setBounds(280, 474, 250, 46);
        menu.setForeground(Color.BLACK);
        menu.addActionListener(this);

        this.loginPanel.add(text);
        this.loginPanel.add(text2);
        this.loginPanel.add(menu);
        this.loginPanel.add(search);
        this.loginPanel.remove(registerText);
        this.loginPanel.remove(pass);
        this.loginPanel.remove(registerText);
        this.loginPanel.remove(adminlogin);
        this.loginPanel.remove(back);
        

    }

    @Override
    public void actionPerformed(ActionEvent a) { 
        if (a.getSource() == search) {
            if (guiHelper.checkNoFieldsEmpty(unameIn)) {
                dispose();
                new listHandler("month", null, unameIn.getText());
            } else {
                errorMessage.setVisible(true);
            }
        } else if (a.getSource() == menu) {
            dispose();
            new userHandler(guiHelper.tempLoginCreds());
        }
    }
 }