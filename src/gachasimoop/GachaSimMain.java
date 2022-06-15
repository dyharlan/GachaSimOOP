/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package gachasimoop;

import gachasimoop.Frontends.*;
import java.io.IOException;
import javax.swing.JOptionPane;

/**
 *
 * @author harlan
 */
public class GachaSimMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try{
            GachaPool.load5StarCharPool("5starchars");
            GachaPool.load4StarCharPool("4starchars");
            GachaPool.load5StarWpnPool("5starwpns");
            GachaPool.load4StarWpnPool("4starwpns");      
        }
        catch(IOException ioe){
            JOptionPane.showMessageDialog(null, ioe.toString(), "Runtime Error",JOptionPane.ERROR_MESSAGE);
            System.exit(0);
        }
        if (args.length > 0){
            StringBuilder help = new StringBuilder();
            help.append("\nThese are the valid arguments for GachaSim: \n");
            help.append("--cli or -c: Calls the cli frontend.\n");
            //help.append("--javafx or -fx: (Default) Calls the JavaFX-based frontend.\n");
            help.append("--swing or -sw: (Default) Calls the Swing frontend.\n");
            String one = args[0];
            switch (one.toLowerCase()){
                case "--cli":
                case "-c":
                    WishSim.cli();
                    break;
                case "--swing":
                case "-sw":
                    WishSimSwing ws = new WishSimSwing();
                    ws.startFrontend();
                    break;
                default:
                case "-h":
                case "--help":
                    System.out.print(help);
                    break;
            }
        }
        else{
             WishSimSwing ws = new WishSimSwing();
             ws.startFrontend();
             
        }
            //callFX();
           
    }
    
//    public static void callFX(){
//        try{
//            WishSimFX.fx();
//        }
//        catch(Exception | Error ex){
//            System.err.println("JavaFX Libraries Not Found, falling back to cli...");
//            WishSim.cli();
//        } 
//    }
    
}
