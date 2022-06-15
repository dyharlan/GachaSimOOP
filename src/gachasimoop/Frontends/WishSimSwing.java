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
    //initialize the frame and other universal stuff
    private JFrame f;
    private JTabbedPane jtp;
    private Image wish1_icon;
    private Image wish10_icon;
    private GBCExtended gbc;
    
    //Character Banner 1
    private CharacterBanner cb;
    private JPanel cb1_panel,cb1_subpanel_1,cb1_subpanel_2,cb1_subpanel_3;
    private JButton cb1_roll1, cb1_roll10, cb1_clearHistory;
    private JLabel cb1_guaranteed1, cb1_guaranteed2,cb1rolls_1, cb1rolls_2, cb1_4star_rolls_1, cb1_4star_rolls_2;
    private JScrollPane cb1_jsp;
    private JTextArea cb1pulls;
    
    //Character Banner 2
    private JPanel cb2_panel,cb2_subpanel_1,cb2_subpanel_2,cb2_subpanel_3;
    private JButton cb2_roll1, cb2_roll10, cb2_clearHistory;
    private JLabel cb2_guaranteed1, cb2_guaranteed2,cb2rolls_1, cb2rolls_2, cb2_4star_rolls_1, cb2_4star_rolls_2;
    private JScrollPane cb2_jsp;
    private JTextArea cb2pulls;
    
    //Weapon Banner 1
    private WeaponBanner wb;
    private JPanel wb_panel,wb_subpanel_1,wb_subpanel_2,wb_subpanel_3;
    private JButton wb_roll1, wb_roll10, wb_clearHistory;
    private JLabel wbrolls_1, wbrolls_2, wb_4star_rolls_1, wb_4star_rolls_2;
    private JScrollPane wb_jsp;
    private JTextArea wbpulls;
    
    //Standard Banner
    private StandardBanner sb;
    private JPanel sb_panel,sb_subpanel_1,sb_subpanel_2,sb_subpanel_3;
    private JButton sb_roll1, sb_roll10, sb_clearHistory;
    private JLabel sbrolls_1, sbrolls_2, sb_4star_rolls_1, sb_4star_rolls_2;
    private JScrollPane sb_jsp;
    private JTextArea sbpulls;
    
    //Constructor
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
        wb = new WeaponBanner();
        sb = new StandardBanner();
        buildCB1();
        buildCB2();
        buildWB();
        buildSB();
    }
    
    //Build the tabs for all the banners.
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
        cb1_clearHistory.addActionListener(l -> cb1pulls.setText(null));
        
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
        cb2_clearHistory.addActionListener(l -> cb2pulls.setText(null));
        
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
    
    private void buildWB(){
        wb_panel = new JPanel();
        wb_subpanel_1 = new JPanel();
        wb_subpanel_2 = new JPanel();
        wb_subpanel_3 = new JPanel();
        
        wb_roll1 = new JButton(new ImageIcon(wish1_icon));
        wb_roll1.setMargin(new Insets(0, 0, 0, 0));
        
        wb_roll10 = new JButton(new ImageIcon(wish10_icon));
        wb_roll10.setMargin(new Insets(0, 0, 0, 0));
        
        wb_clearHistory = new JButton("Clear Wish History");
        wb_clearHistory.addActionListener(l -> wbpulls.setText(null));
        
        wbrolls_1 = new JLabel("Banner Rolls: ");
        wbrolls_2 = new JLabel("0");
        wbrolls_2.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
        wb_4star_rolls_1 = new JLabel("Rolls since last 4*: ");
        wb_4star_rolls_2 = new JLabel("0");
        wb_4star_rolls_2.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
        wbpulls = new JTextArea();
        wb_jsp = new JScrollPane(wbpulls);
        
        wb_panel.setLayout(new BorderLayout());
        wb_panel.add(wb_subpanel_1, BorderLayout.NORTH);
            wb_roll1.setContentAreaFilled(false);
            wb_roll1.setFocusPainted(false);
            wb_roll1.setBorderPainted(true);
            wb_subpanel_1.add(wb_roll1);
            
            wb_roll10.setContentAreaFilled(false);
            wb_roll10.setFocusPainted(false);
            wb_roll10.setBorderPainted(true);
            wb_subpanel_1.add(wb_roll10);
            
            wb_roll1.addActionListener(this);
            wb_roll10.addActionListener(this);
            
        wb_panel.add(wb_subpanel_2, BorderLayout.CENTER);
            
            wb_subpanel_2.add(wbrolls_1);
            wbrolls_2.setPreferredSize(new Dimension(80,40));
            wbrolls_2.setHorizontalAlignment(SwingConstants.CENTER);
            wb_subpanel_2.add(wbrolls_2);
            
            wb_subpanel_2.add(wb_4star_rolls_1);
            wb_4star_rolls_2.setPreferredSize(new Dimension(80,40));
            wb_4star_rolls_2.setHorizontalAlignment(SwingConstants.CENTER);
            wb_subpanel_2.add(wb_4star_rolls_2);
            
        wb_panel.add(wb_subpanel_3,BorderLayout.SOUTH);
            gbc.anchor = GridBagConstraints.NORTHWEST;
            gbc.ipadx = 5;
            gbc.ipady = 5;
            gbc.insets = new Insets(2,2,2,2);
            wb_subpanel_3.setLayout(new GridBagLayout());
            gbc.gbcAdd(wb_subpanel_3, wb_clearHistory,0,0);
            wb_jsp.setPreferredSize( new Dimension(480,480));
            gbc.gbcAdd(wb_subpanel_3, wb_jsp,0,1); 
    }
    
    private void buildSB(){
        sb_panel = new JPanel();
        sb_subpanel_1 = new JPanel();
        sb_subpanel_2 = new JPanel();
        sb_subpanel_3 = new JPanel();
        
        sb_roll1 = new JButton(new ImageIcon(wish1_icon));
        sb_roll1.setMargin(new Insets(0, 0, 0, 0));
        
        sb_roll10 = new JButton(new ImageIcon(wish10_icon));
        sb_roll10.setMargin(new Insets(0, 0, 0, 0));
        
        sb_clearHistory = new JButton("Clear Wish History");
        sb_clearHistory.addActionListener(l -> sbpulls.setText(null));
        
        sbrolls_1 = new JLabel("Banner Rolls: ");
        sbrolls_2 = new JLabel("0");
        sbrolls_2.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
        sb_4star_rolls_1 = new JLabel("Rolls since last 4*: ");
        sb_4star_rolls_2 = new JLabel("0");
        sb_4star_rolls_2.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
        sbpulls = new JTextArea();
        sb_jsp = new JScrollPane(sbpulls);
        
        sb_panel.setLayout(new BorderLayout());
        sb_panel.add(sb_subpanel_1, BorderLayout.NORTH);
            sb_roll1.setContentAreaFilled(false);
            sb_roll1.setFocusPainted(false);
            sb_roll1.setBorderPainted(true);
            sb_subpanel_1.add(sb_roll1);
            
            sb_roll10.setContentAreaFilled(false);
            sb_roll10.setFocusPainted(false);
            sb_roll10.setBorderPainted(true);
            sb_subpanel_1.add(sb_roll10);
            
            sb_roll1.addActionListener(this);
            sb_roll10.addActionListener(this);
            
        sb_panel.add(sb_subpanel_2, BorderLayout.CENTER);
            
            sb_subpanel_2.add(sbrolls_1);
            sbrolls_2.setPreferredSize(new Dimension(80,40));
            sbrolls_2.setHorizontalAlignment(SwingConstants.CENTER);
            sb_subpanel_2.add(sbrolls_2);
            
            sb_subpanel_2.add(sb_4star_rolls_1);
            sb_4star_rolls_2.setPreferredSize(new Dimension(80,40));
            sb_4star_rolls_2.setHorizontalAlignment(SwingConstants.CENTER);
            sb_subpanel_2.add(sb_4star_rolls_2);
            
        sb_panel.add(sb_subpanel_3,BorderLayout.SOUTH);
            gbc.anchor = GridBagConstraints.NORTHWEST;
            gbc.ipadx = 5;
            gbc.ipady = 5;
            gbc.insets = new Insets(2,2,2,2);
            sb_subpanel_3.setLayout(new GridBagLayout());
            gbc.gbcAdd(sb_subpanel_3, sb_clearHistory,0,0);
            sb_jsp.setPreferredSize( new Dimension(480,480));
            gbc.gbcAdd(sb_subpanel_3, sb_jsp,0,1); 
    }
    
    //action listener for all the buttons
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
        
        else if(source == wb_roll1){
            wbpulls.append(wb.roll() + "\n");
            
            wbrolls_2.setText(String.valueOf(wb.getBannerRolls()));
            wb_4star_rolls_2.setText(String.valueOf(wb.get4StarPity())); 
        }
        
        else if(source == wb_roll10){
            for(int i = 0;i < 10;i++){
                wbpulls.append(wb.roll() + "\n");
            }
            
            wbrolls_2.setText(String.valueOf(wb.getBannerRolls()));
            wb_4star_rolls_2.setText(String.valueOf(wb.get4StarPity()));
        }
        
        else if(source == sb_roll1){
            sbpulls.append(sb.roll() + "\n");
            
            sbrolls_2.setText(String.valueOf(sb.getBannerRolls()));
            sb_4star_rolls_2.setText(String.valueOf(sb.get4StarPity())); 
        }
        
        else if(source == sb_roll10){
            for(int i = 0;i < 10;i++){
                sbpulls.append(sb.roll() + "\n");
            }
            
            sbrolls_2.setText(String.valueOf(sb.getBannerRolls()));
            sb_4star_rolls_2.setText(String.valueOf(sb.get4StarPity()));
        }
    }
    
    //start method
    public void startFrontend(){
        f.add(jtp);
       
        jtp.addTab("Character Banner 1", cb1_panel);
        jtp.addTab("Character Banner 2", cb2_panel);
        jtp.addTab("Weapon Banner", wb_panel);
        jtp.addTab("Standard Banner", sb_panel);
       
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
