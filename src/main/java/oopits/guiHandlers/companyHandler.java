package oopits.guiHandlers;

import java.awt.Color;

import javax.swing.JPanel;

/**
 * @author Junaadh
 */

 public class companyHandler extends myFrame{
 
    public companyHandler( char type) {



        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setSize(1220, 720);
        panel.setBackground(new Color(0x4AA7BE));

        this.getContentPane().add(panel);
    }
 }