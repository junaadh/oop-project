package oopits.guiHandlers;

/**
 * @author Junaadh
 */

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import oopits.Helper;
import oopits.guiHelper;

public class listHandler extends myFrame implements ActionListener {
    
    public String usageText = "Energy Usage";
    JLabel usageTitle = new JLabel(usageText);

    ImageIcon back = new ImageIcon("src/main/java/oopits/assets/back.png");
    ImageIcon backIcon = guiHelper.resizeIcon(back, 50, 50);
    JButton menu = new JButton(backIcon);
    DefaultTableModel cTable;

    public listHandler( String type, String company, String month ) {

        switch (type) {
            case "list":
                cTable = Helper.guiDisplayTableList();
                break;

            case "company":
                cTable = Helper.guiDisplaySortedByComp(company);
                break;

            case "month":
                cTable = Helper.guiDisplaySortedByMonth(month);
                break;

            case "baduse":
                cTable = Helper.guiDisplayMisuse();
                break;
        }

        menu.setHorizontalAlignment(SwingConstants.CENTER);
        menu.setVerticalAlignment(SwingConstants.CENTER);
        menu.setBounds(35, 35, 60, 60);
        menu.setBorder(null);
        menu.addActionListener(this);

        usageTitle.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 40));
        usageTitle.setBounds(455, 20, 400, 100);
        usageTitle.setAlignmentX(SwingConstants.CENTER);
        usageTitle.setAlignmentY(SwingConstants.CENTER);

        JTable table = new JTable(cTable);
        JScrollPane scrollpane = new JScrollPane(table);
        table.setAlignmentX(SwingConstants.CENTER);
        table.setAlignmentY(SwingConstants.CENTER);
        table.setBackground(new Color(0x4AA7BE));
        table.setGridColor(Color.BLUE);
        table.setEnabled(false);
        
        scrollpane.setAlignmentX(SwingConstants.CENTER);
        scrollpane.setAlignmentY(SwingConstants.CENTER);
        scrollpane.setBounds(215, 150, 800, 400);
        

        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setSize(1220, 720);
        panel.setBackground(new Color(0x4AA7BE));
        panel.add(menu);
        panel.add(usageTitle);
        panel.add(scrollpane);

        this.getContentPane().add(panel);
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == menu) {
            dispose();
            new userHandler(guiHelper.tempLoginCreds());
        } 
    }
    
}
