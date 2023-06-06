package oopits.guiHandlers;

import java.awt.Color;
import java.awt.Font;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import java.awt.event.MouseEvent;

import oopits.guiHelper;

public class welcomeHandler extends JFrame implements ActionListener{
    
    
    JButton user = new JButton();
    JButton company = new JButton();
    JButton government = new JButton();
    JButton credits = new JButton();
    
    public welcomeHandler() {
        
        ImageIcon usericn = new ImageIcon("src/main/java/oopits/assets/user.png");
        ImageIcon usericon = guiHelper.resizeIcon(usericn, 40, 40);

        ImageIcon governmenticn = new ImageIcon("src/main/java/oopits/assets/government.png");
        ImageIcon governmenticon = guiHelper.resizeIcon(governmenticn, 40, 40);

        ImageIcon creditsicn = new ImageIcon("src/main/java/oopits/assets/credits.png");
        ImageIcon creditsicon = guiHelper.resizeIcon(creditsicn, 40, 40);

        JLabel helloText = new JLabel("Hello");
        helloText.setFont(new Font("Inter", Font.BOLD, 80));
        helloText.setForeground(Color.MAGENTA);
        helloText.setBounds(520, 200, 230, 100);

        user.setIcon(usericon);
        user.addActionListener(this);
        user.setBorder(null);
        user.setBounds(450, 516, 40, 40);
        user.setToolTipText("");
        user.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent a){
                user.setToolTipText("User Login");
            }
            public void mouseExited(MouseEvent a){
                user.setToolTipText("");
            }
        });

        government.setIcon(governmenticon);
        government.addActionListener(this);
        government.setBorder(null);
        government.setBounds(770, 516, 40, 40);
        government.setToolTipText("");
        government.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent a){
                government.setToolTipText("Governmental Login");
            }
            public void mouseExited(MouseEvent a){
                government.setToolTipText("");
            }
        });

        credits.setIcon(creditsicon);
        //credits.addActionListener();
        credits.setBorder(null);
        credits.setBounds(610, 516, 40, 40);
        credits.setToolTipText("");
        credits.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent a){
                credits.setToolTipText("Display Credits");
            }
            public void mouseExited(MouseEvent a){
                credits.setToolTipText("");
            }
        });


        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setSize(1220, 720);
        panel.setBackground((new Color(0x4AA7BE)));
        panel.add(helloText);
        panel.add(user);        
        panel.add(government);
        panel.add(company);
        panel.add(credits);



        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.getContentPane().add(panel);
        //this.getContentPane().add(helloText);
        this.setSize(1220, 720);
        this.setTitle("Energy Monitor");
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == user) {
            dispose();
            new userLoginHandler();
        } else if (e.getSource() == government) {
            dispose();
            new adminLoginHandler();
        }{
            
        }
    }
    
}


class GradientTextLabel extends JLabel {
    public GradientTextLabel(String text) {
        super(text);
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2d = (Graphics2D) g.create();

        GradientPaint gradient = new GradientPaint(0, 10, new Color(116, 0, 233, 1),
                                    getWidth()*0.4F, getHeight()*0.9F, new Color(0xFF00C7));

        g2d.setPaint(gradient);
        g2d.drawString(getText(), 509, 200);
        g2d.dispose();

    }
}

