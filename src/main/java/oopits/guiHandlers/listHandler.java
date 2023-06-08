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

import oopits.Company;
import oopits.Initializer;
import oopits.guiHelper;

public class listHandler extends myFrame implements ActionListener {
    
    public String usageText = "Energy Usage";
    JLabel usageTitle = new JLabel(usageText);

    ImageIcon back = new ImageIcon("src/main/java/oopits/assets/back.png");
    ImageIcon backIcon = guiHelper.resizeIcon(back, 50, 50);
    JButton menu = new JButton(backIcon);

    public listHandler() {

        menu.setHorizontalAlignment(SwingConstants.CENTER);
        menu.setVerticalAlignment(SwingConstants.CENTER);
        menu.setBounds(35, 35, 60, 60);
        menu.setBorder(null);
        menu.addActionListener(this);

        usageTitle.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 40));
        usageTitle.setBounds(455, 20, 400, 100);
        usageTitle.setAlignmentX(SwingConstants.CENTER);
        usageTitle.setAlignmentY(SwingConstants.CENTER);

        Company companies[] = Initializer.cList;

        DefaultTableModel cTable = new DefaultTableModel(
            new Object[] {"ID", "Company", "Usage", "Month" }, 0
            
        );

        for (Company company : companies) {
            cTable.addRow(new Object[] {company.getID(), company.getName(), company.getUsage(), company.getMonth()});
        }

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
