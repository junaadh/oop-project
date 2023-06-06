package oopits;

// created by @junaadh at 20230606 05:33.

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;



public class registrationHandler extends myFrame implements ActionListener{
    
    
    JButton register = new JButton();
    JTextField fnameIn = new JTextField();
    JTextField lnameIn = new JTextField();
    JTextField unameIn = new JTextField();
    JPasswordField passIn = new JPasswordField("");
    JPanel registrationPanel = new JPanel();


    public registrationHandler() {
        ImageIcon image = new ImageIcon("src/main/java/oopits/assets/c.png");
        JLabel imageLabel = new JLabel();
        imageLabel.setIcon(image);
        imageLabel.setBounds(720, 100,500,500);
        

        JLabel registerText = new JLabel();
        registerText.setText("Create new account");
        registerText.setForeground(Color.WHITE);
        registerText.setLayout(null);
        registerText.setBounds(10, 133, 591, 84);
        registerText.setFont(new Font("Poppins", Font.BOLD, 56));

        JLabel fnameText = new JLabel();
        fnameText.setText("First Name");
        fnameText.setForeground(Color.WHITE);
        fnameText.setLayout(null);
        fnameText.setBounds(18, 7, 100, 12);
        fnameText.setFont(new Font("Poppins", Font.PLAIN, 11));
        fnameText.setFocusable(false);
        
        fnameIn.setBounds(20, 22, 235, 21);
        fnameIn.setBackground(Color.decode("#514B96"));
        fnameIn.setForeground(Color.GRAY);
        fnameIn.setOpaque(true);
        fnameIn.setBorder(null);

        JPanel fname = new JPanel();
        fname.setLayout(null);
        fname.setBounds(10, 254, 250, 46);
        fname.setBackground(Color.decode("#514B96"));
        fname.setOpaque(true); 
        fname.add(fnameText);
        fname.add(fnameIn);

        JLabel lnameText = new JLabel();
        lnameText.setText("Last Name");
        lnameText.setForeground(Color.WHITE);
        lnameText.setLayout(null);
        lnameText.setBounds(18, 7, 100, 12);
        lnameText.setFont(new Font("Poppins", Font.PLAIN, 11));
        lnameText.setFocusable(false);

        lnameIn.setBounds(20, 22, 235, 21);
        lnameIn.setBackground(Color.decode("#514B96"));
        lnameIn.setForeground(Color.GRAY);
        lnameIn.setOpaque(true);
        lnameIn.setBorder(null);
        
        JPanel lname = new JPanel();
        lname.setLayout(null);
        lname.setBounds(280, 254, 250, 46);
        lname.setBackground(Color.decode("#514B96"));
        lname.setOpaque(true);
        lname.add(lnameText);
        lname.add(lnameIn);

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

        register.setText("Create Account");
        register.setFont(new Font("Poppins-SemiBold", Font.PLAIN, 16));
        register.setBackground(Color.decode("#47458"));
        register.setBounds(10, 474, 520, 46);
        register.setForeground(Color.BLACK);
        register.addActionListener(this);

        JLabel text = new JLabel();
        text.setText("Already A User? ");
        text.setBounds(18, 534, 216, 25);
        text.setFont(new Font("Poppins", Font.PLAIN, 16));

        JLabel login = new JLabel("Log In");
        login.setBounds(145, 534, 100, 25);
        login.setFont(new Font("Poppins", Font.PLAIN, 16));
        login.setForeground(Color.BLUE);
        login.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        login.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent a) {
                dispose();
                new loginHandler();
            }   
        });

        registrationPanel.setLayout(null);
        // registrationPanel.setBounds(65, 65, 593, 563);
        registrationPanel.setBounds(50, 0, 593, 563);
        //registrationPanel.setBackground(Color.cyan);
        registrationPanel.setOpaque(false);
        // registrationPanel.add(imageLabel);
        registrationPanel.add(registerText);
        registrationPanel.add(fname);
        registrationPanel.add(lname);
        registrationPanel.add(uname);
        registrationPanel.add(pass);
        registrationPanel.add(register);
        registrationPanel.add(text);
        registrationPanel.add(login);

        this.add(registrationPanel);
        this.add(imageLabel);

    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==register) {
            if (guiHelper.checkNoFieldsEmpty(fnameIn, lnameIn, unameIn, passIn)) {
                if (prompts.terms()) {
                    User.guiRegister(fnameIn.getText() + "," +  lnameIn.getText() + "," +  unameIn.getText() + "," +  String.valueOf(passIn.getPassword()) + "\n");
                    
                } else {
                    prompts.registrationFail("Please agree to the terms and conditions");
                }
                
            }
        }
    }

        
    
}
