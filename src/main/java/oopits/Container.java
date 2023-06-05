package oopits;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class Container {

    public static void registerHandler() {
        ImageIcon image = new ImageIcon("src/main/java/oopits/assets/logo.png");
        JLabel iamgeLabel = new JLabel(image);
        iamgeLabel.setVerticalAlignment(0);
        iamgeLabel.setSize(100, 100);

        JLabel registerText = new JLabel();
        registerText.setText("Create new account");
        registerText.setForeground(Color.WHITE);
        registerText.setLayout(null);
        registerText.setBounds(10, 133, 591, 84);
        registerText.setFont(new Font("Poppins", Font.BOLD, 56));

        //Rounded name = new Rounded(4);
        //name.setBackground(Color.decode("#514B96"));
        //name.setPreferredSize(new Dimension(229, 46));

        JLabel fnameText = new JLabel();
        fnameText.setText("First Name");
        fnameText.setForeground(Color.WHITE);
        fnameText.setLayout(null);
        fnameText.setBounds(18, 7, 100, 12);
        fnameText.setFont(new Font("Poppins", Font.PLAIN, 11));
        fnameText.setFocusable(false);

        JPanel fname = new JPanel();
        fname.setLayout(null);
        fname.setBounds(10, 254, 250, 46);
        fname.setBackground(Color.decode("#514B96"));
        fname.setOpaque(true); 
        fname.add(fnameText);

        JLabel lnameText = new JLabel();
        lnameText.setText("Last Name");
        lnameText.setForeground(Color.WHITE);
        lnameText.setLayout(null);
        lnameText.setBounds(18, 7, 100, 12);
        lnameText.setFont(new Font("Poppins", Font.PLAIN, 11));
        lnameText.setFocusable(false);

        JPanel lname = new JPanel();
        lname.setLayout(null);
        lname.setBounds(280, 254, 250, 46);
        lname.setBackground(Color.decode("#514B96"));
        lname.setOpaque(true);
        lname.add(lnameText);

        JLabel unameText = new JLabel();
        unameText.setText("Username");
        unameText.setForeground(Color.WHITE);
        unameText.setLayout(null);
        unameText.setBounds(18, 7, 100, 12);
        unameText.setFont(new Font("Poppins", Font.PLAIN, 11));
        unameText.setFocusable(false);

        JPanel uname = new JPanel();
        uname.setLayout(null);
        uname.setBounds(10, 314, 520, 46);
        uname.setBackground(Color.decode("#514B96"));
        uname.setOpaque(true);
        uname.add(unameText);

        JLabel passText = new JLabel();
        passText.setText("Password");
        passText.setForeground(Color.WHITE);
        passText.setLayout(null);
        passText.setBounds(18, 7, 100, 12);
        passText.setFont(new Font("Poppins", Font.PLAIN, 11));
        passText.setFocusable(false);

        JPanel pass = new JPanel();
        pass.setLayout(null);
        pass.setBounds(10, 374, 520, 46);
        pass.setBackground(Color.decode("#514B96"));
        pass.setOpaque(true);
        pass.add(passText);

        JButton register = new JButton();
        register.setText("Create Account");
        register.setFont(new Font("Poppins-SemiBold", Font.PLAIN, 16));
        register.setBackground(Color.decode("#47458"));
        register.setBounds(10, 474, 520, 46);
        register.setForeground(Color.BLACK);

        JLabel text = new JLabel();
        text.setText("Already A User? ");
        text.setBounds(18, 534, 216, 25);
        text.setFont(new Font("Poppins", Font.PLAIN, 16));

        JLabel login = new JLabel("Log In");
        login.setBounds(145, 534, 100, 25);
        login.setFont(new Font("Poppins", Font.PLAIN, 16));

        JPanel content = new JPanel();
        content.setLayout(null);
        content.setBounds(65, 65, 593, 563);
        //content.setBackground(Color.cyan);
        content.setOpaque(false);
        content.add(iamgeLabel);
        content.add(registerText);
        content.add(fname);
        content.add(lname);
        content.add(uname);
        content.add(pass);
        content.add(register);
        content.add(text);
        content.add(login);
        


        JFrame frame = new JFrame(); 
        frame.setTitle("Energy Monitor");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setSize(1420, 720);
        frame.setVisible(true);
        //frame.setIconImage(image.getImage());
        frame.getContentPane().setBackground(Color.decode("#4E498D"));
        frame.setOpacity(1);
        frame.add(content);
        frame.setLayout(null);

    }

    public static void loginHandler() {
        
    }
}
