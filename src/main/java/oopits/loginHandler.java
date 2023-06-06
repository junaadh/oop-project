package oopits;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class loginHandler extends myFrame implements ActionListener {

    JTextField unameIn = new JTextField();
    JPasswordField passIn = new JPasswordField();
    JButton login = new JButton("Log In");
    JPanel loginPanel = new JPanel();
    JLabel register = new JLabel("Register");
    JLabel text = new JLabel();
    protected String type;


    loginHandler( String type ) {

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

        login.setFont(new Font("Poppins-SemiBold", Font.PLAIN, 16));
        login.setBackground(Color.decode("#47458"));
        login.setBounds(10, 474, 520, 46);
        login.setForeground(Color.BLACK);
        login.addActionListener(this);

        text.setText("Dont have an account yet? ");
        text.setBounds(18, 534, 216, 25);
        text.setFont(new Font("Poppins", Font.PLAIN, 16));

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

        loginPanel.setLayout(null);
        loginPanel.setBounds(50, 0, 593, 563);
        loginPanel.setOpaque(false);
        loginPanel.add(registerText);
        loginPanel.add(uname);
        loginPanel.add(pass);
        loginPanel.add(login);
        loginPanel.add(text);
        loginPanel.add(register);

        this.add(loginPanel);
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == login) {
            if (guiHelper.checkNoFieldsEmpty(unameIn, passIn)) {
                switch (type) {
                    case "user":
                        System.out.println(User.guiLogin(unameIn.getText(), String.valueOf(passIn.getPassword())));
                        break;
                    
                    case "admin":
                        register.setVisible(false);
                        text.setVisible(false);
                        break;
                
                    default:
                        break;
                }
            }
        }
    }
}
