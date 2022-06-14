/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gachasimoop.Frontends;
import gachasimoop.Banners.*;
import static gachasimoop.GachaPool.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import javax.imageio.*;
import java.io.IOException;
/**
 *
 * @author harlan
 */
public class WishSimSwing implements ActionListener{
    private JFrame f;
    private JTabbedPane jtp;
    
    private CharacterBanner cb;
    private JPanel cb1_panel,cb1_subpanel_1,cb1_subpanel_2,cb1_subpanel_3;
    private JButton cb1_roll1, cb1_roll10, cb1_clearHistory;
    private JLabel cb1_guaranteed1, cb1_guaranteed2,cb1rolls_1, cb1rolls_2, cb1_4star_rolls_1, cb1_4star_rolls_2;
    private JScrollPane cb1_jsp;
    private JTextArea cb1pulls;
    
    private JPanel cb2_panel,cb2_subpanel_1,cb2_subpanel_2,cb2_subpanel_3;
    private JButton cb2_roll1, cb2_roll10, cb2_clearHistory;
    private JLabel cb2_guaranteed1, cb2_guaranteed2,cb2rolls_1, cb2rolls_2, cb2_4star_rolls_1, cb2_4star_rolls_2;
    private JScrollPane cb2_jsp;
    private JTextArea cb2pulls;
    
    private Image wish1_icon;
    private Image wish10_icon;
    private GBCExtended gbc;
    
    public WishSimSwing(){
        f = new JFrame("GachaSim beta4");
        jtp = new JTabbedPane(JTabbedPane.TOP);
        gbc = new GBCExtended();
        try{
            wish1_icon = ImageIO.read(getClass().getResource("/gachasimoop/res/wish1.png"));
            wish10_icon = ImageIO.read(getClass().getResource("/gachasimoop/res/wish10.png"));
        }
        catch(IOException ioe){
            JOptionPane.showMessageDialog(null, "Error! Resources were not found.", "Runtime Error",JOptionPane.ERROR_MESSAGE);
        }
        cb = new CharacterBanner(chars[0][chars[0].length-2], chars[0][chars[0].length-1]);
        buildCB1();
        buildCB2();
        
    }
    
    private void buildCB1(){
        cb1_panel = new JPanel();
        cb1_subpanel_1 = new JPanel();
        cb1_subpanel_2 = new JPanel();
        cb1_subpanel_3 = new JPanel();
        
        cb1_roll1 = new JButton(new ImageIcon(wish1_icon));
        cb1_roll1.setMargin(new Insets(0, 0, 0, 0));
        
        cb1_roll10 = new JButton(new ImageIcon(wish10_icon));
        cb1_roll10.setMargin(new Insets(0, 0, 0, 0));
        
        cb1_clearHistory = new JButton("Clear Wish History");
        
        cb1_guaranteed1 = new JLabel("Guaranteed 5*?: ");
        cb1_guaranteed2 = new JLabel("false");
        cb1_guaranteed2.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
        cb1rolls_1 = new JLabel("Banner Rolls: ");
        cb1rolls_2 = new JLabel("0");
        cb1rolls_2.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
        cb1_4star_rolls_1 = new JLabel("Rolls since last 4*: ");
        cb1_4star_rolls_2 = new JLabel("0");
        cb1_4star_rolls_2.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
        cb1pulls = new JTextArea();
        cb1_jsp = new JScrollPane(cb1pulls);
        
        cb1_panel.setLayout(new BorderLayout());
        cb1_panel.add(cb1_subpanel_1, BorderLayout.NORTH);
            cb1_roll1.setContentAreaFilled(false);
            cb1_roll1.setFocusPainted(false);
            cb1_roll1.setBorderPainted(true);
            cb1_subpanel_1.add(cb1_roll1);
            
            cb1_roll10.setContentAreaFilled(false);
            cb1_roll10.setFocusPainted(false);
            cb1_roll10.setBorderPainted(true);
            cb1_subpanel_1.add(cb1_roll10);
            
            cb1_roll1.addActionListener(this);
            cb1_roll10.addActionListener(this);
            
        cb1_panel.add(cb1_subpanel_2, BorderLayout.CENTER);
            cb1_guaranteed2.setPreferredSize(new Dimension(80,40));
            cb1_guaranteed2.setHorizontalAlignment(SwingConstants.CENTER);
            cb1_subpanel_2.add(cb1_guaranteed1);
            cb1_subpanel_2.add(cb1_guaranteed2);
            
            cb1_subpanel_2.add(cb1rolls_1);
            cb1rolls_2.setPreferredSize(new Dimension(80,40));
            cb1rolls_2.setHorizontalAlignment(SwingConstants.CENTER);
            cb1_subpanel_2.add(cb1rolls_2);
            
            cb1_subpanel_2.add(cb1_4star_rolls_1);
            cb1_4star_rolls_2.setPreferredSize(new Dimension(80,40));
            cb1_4star_rolls_2.setHorizontalAlignment(SwingConstants.CENTER);
            cb1_subpanel_2.add(cb1_4star_rolls_2);
            
        cb1_panel.add(cb1_subpanel_3,BorderLayout.SOUTH);
            gbc.anchor = GridBagConstraints.NORTHWEST;
            gbc.ipadx = 5;
            gbc.ipady = 5;
            gbc.insets = new Insets(2,2,2,2);
            cb1_subpanel_3.setLayout(new GridBagLayout());
            gbc.gbcAdd(cb1_subpanel_3, cb1_clearHistory,0,0);
            cb1_jsp.setPreferredSize( new Dimension(480,480));
            gbc.gbcAdd(cb1_subpanel_3, cb1_jsp,0,1);
        
            
    }
    
    private void buildCB2(){
       
        cb2_panel = new JPanel();
        cb2_subpanel_1 = new JPanel();
        cb2_subpanel_2 = new JPanel();
        cb2_subpanel_3 = new JPanel();
        
        cb2_roll1 = new JButton(new ImageIcon(wish1_icon));
        cb2_roll1.setMargin(new Insets(0, 0, 0, 0));
        
        cb2_roll10 = new JButton(new ImageIcon(wish10_icon));
        cb2_roll10.setMargin(new Insets(0, 0, 0, 0));
        
        cb2_clearHistory = new JButton("Clear Wish History");
        
        cb2_guaranteed1 = new JLabel("Guaranteed 5*?: ");
        cb2_guaranteed2 = new JLabel("false");
        cb2_guaranteed2.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
        cb2rolls_1 = new JLabel("Banner Rolls: ");
        cb2rolls_2 = new JLabel("0");
        cb2rolls_2.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
        cb2_4star_rolls_1 = new JLabel("Rolls since last 4*: ");
        cb2_4star_rolls_2 = new JLabel("0");
        cb2_4star_rolls_2.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
        cb2pulls = new JTextArea();
        cb2_jsp = new JScrollPane(cb2pulls);
        
        cb2_panel.setLayout(new BorderLayout());
        cb2_panel.add(cb2_subpanel_1, BorderLayout.NORTH);
            cb2_roll1.setContentAreaFilled(false);
            cb2_roll1.setFocusPainted(false);
            cb2_roll1.setBorderPainted(true);
            cb2_subpanel_1.add(cb2_roll1);
            
            cb2_roll10.setContentAreaFilled(false);
            cb2_roll10.setFocusPainted(false);
            cb2_roll10.setBorderPainted(true);
            cb2_subpanel_1.add(cb2_roll10);
            
            cb2_roll1.addActionListener(this);
            cb2_roll10.addActionListener(this);
            
        cb2_panel.add(cb2_subpanel_2, BorderLayout.CENTER);
            cb2_guaranteed2.setPreferredSize(new Dimension(80,40));
            cb2_guaranteed2.setHorizontalAlignment(SwingConstants.CENTER);
            cb2_subpanel_2.add(cb2_guaranteed1);
            cb2_subpanel_2.add(cb2_guaranteed2);
            
            cb2_subpanel_2.add(cb2rolls_1);
            cb2rolls_2.setPreferredSize(new Dimension(80,40));
            cb2rolls_2.setHorizontalAlignment(SwingConstants.CENTER);
            cb2_subpanel_2.add(cb2rolls_2);
            
            cb2_subpanel_2.add(cb2_4star_rolls_1);
            cb2_4star_rolls_2.setPreferredSize(new Dimension(80,40));
            cb2_4star_rolls_2.setHorizontalAlignment(SwingConstants.CENTER);
            cb2_subpanel_2.add(cb2_4star_rolls_2);
            
        cb2_panel.add(cb2_subpanel_3,BorderLayout.SOUTH);
            gbc.anchor = GridBagConstraints.NORTHWEST;
            gbc.ipadx = 5;
            gbc.ipady = 5;
            gbc.insets = new Insets(2,2,2,2);
            cb2_subpanel_3.setLayout(new GridBagLayout());
            gbc.gbcAdd(cb2_subpanel_3, cb2_clearHistory,0,0);
            cb2_jsp.setPreferredSize( new Dimension(480,480));
            gbc.gbcAdd(cb2_subpanel_3, cb2_jsp,0,1); 
    }
    
    public void actionPerformed(ActionEvent e){
        Object source = e.getSource();
        if(source == cb1_roll1){
            cb.setCBannerRateUp(1);
            cb1pulls.append(cb.roll() + "\n");
            
            cb1_guaranteed2.setText(String.valueOf(cb.isGuaranteed()));
            cb1rolls_2.setText(String.valueOf(cb.getBannerRolls()));
            cb1_4star_rolls_2.setText(String.valueOf(cb.get4StarPity()));
            
            cb2_guaranteed2.setText(String.valueOf(cb.isGuaranteed()));
            cb2rolls_2.setText(String.valueOf(cb.getBannerRolls()));
            cb2_4star_rolls_2.setText(String.valueOf(cb.get4StarPity()));
        }
        
        else if(source == cb1_roll10){
            cb.setCBannerRateUp(1);
            for(int i = 0;i < 10;i++){
                cb1pulls.append(cb.roll() + "\n");
            }
            
            cb1_guaranteed2.setText(String.valueOf(cb.isGuaranteed()));
            cb1rolls_2.setText(String.valueOf(cb.getBannerRolls()));
            cb1_4star_rolls_2.setText(String.valueOf(cb.get4StarPity()));
            
            cb2_guaranteed2.setText(String.valueOf(cb.isGuaranteed()));
            cb2rolls_2.setText(String.valueOf(cb.getBannerRolls()));
            cb2_4star_rolls_2.setText(String.valueOf(cb.get4StarPity()));
        }
        
        else if(source == cb2_roll1){
            cb.setCBannerRateUp(1);
            cb2pulls.append(cb.roll() + "\n");
            
            cb1_guaranteed2.setText(String.valueOf(cb.isGuaranteed()));
            cb1rolls_2.setText(String.valueOf(cb.getBannerRolls()));
            cb1_4star_rolls_2.setText(String.valueOf(cb.get4StarPity()));
            
            cb2_guaranteed2.setText(String.valueOf(cb.isGuaranteed()));
            cb2rolls_2.setText(String.valueOf(cb.getBannerRolls()));
            cb2_4star_rolls_2.setText(String.valueOf(cb.get4StarPity()));
        }
        
        else if(source == cb2_roll10){
            cb.setCBannerRateUp(2);
            for(int i = 0;i < 10;i++){
                cb2pulls.append(cb.roll() + "\n");
            }
            
            cb1_guaranteed2.setText(String.valueOf(cb.isGuaranteed()));
            cb1rolls_2.setText(String.valueOf(cb.getBannerRolls()));
            cb1_4star_rolls_2.setText(String.valueOf(cb.get4StarPity()));
            
            cb2_guaranteed2.setText(String.valueOf(cb.isGuaranteed()));
            cb2rolls_2.setText(String.valueOf(cb.getBannerRolls()));
            cb2_4star_rolls_2.setText(String.valueOf(cb.get4StarPity()));
        }
        
    }
    
    public void startFrontend(){
        f.add(jtp);
       
        jtp.addTab("Character Banner 1", cb1_panel);
        jtp.addTab("Character Banner 2", cb2_panel);
       
       
        f.addWindowListener(new WindowAdapter(){
            public void windowClosing(WindowEvent e){
                System.exit(0);
            }
        });
        
        f.pack();
        f.setResizable(false);
        f.setVisible(true);
    }
    
}
