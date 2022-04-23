/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package gachasimoop;

import gachasimoop.Frontends.*;
import java.io.IOException;

/**
 *
 * @author harlan
 */
public class GachaSimMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        if (args.length > 0)
            {
                StringBuilder help = new StringBuilder();
                help.append("\nThese are the valid arguments for GachaSim: \n");
                help.append("--cli or -c: Calls the cli frontend.\n");
                help.append("--javafx or -fx: (Default) Calls the JavaFX-based frontend.\n");
                String one = args[0];
                switch (one.toLowerCase())
                    {
                        case "--cli":
                        case "-c":
                            try{
                                GachaPool.load5StarCharPool("5starchars");
                                GachaPool.load4StarCharPool("4starchars");
                                GachaPool.load5StarWpnPool("5starwpns");
                                GachaPool.load4StarWpnPool("4starwpns");
                    //            GachaPool.load5StarCharPool("/mnt/d/Others/src/GachaSimOOP/src/gachasimoop/5starchars");
                    //            GachaPool.load4StarCharPool("/mnt/d/Others/src/GachaSimOOP/src/gachasimoop/4starchars");
                    //            GachaPool.load5StarWpnPool("/mnt/d/Others/src/GachaSimOOP/src/gachasimoop/5starwpns");
                    //            GachaPool.load4StarWpnPool("/mnt/d/Others/src/GachaSimOOP/src/gachasimoop/4starwpns");
                            }
                            catch(IOException ioe){
                                System.err.println(ioe.toString());
                                System.exit(0);
                            }
                            WishSim.cli();
                            break;
                        case "--javafx":
                        case "-fx":
                            try{
                                GachaPool.load5StarCharPool("5starchars");
                                GachaPool.load4StarCharPool("4starchars");
                                GachaPool.load5StarWpnPool("5starwpns");
                                GachaPool.load4StarWpnPool("4starwpns");
                    //            GachaPool.load5StarCharPool("/mnt/d/Others/src/GachaSimOOP/src/gachasimoop/5starchars");
                    //            GachaPool.load4StarCharPool("/mnt/d/Others/src/GachaSimOOP/src/gachasimoop/4starchars");
                    //            GachaPool.load5StarWpnPool("/mnt/d/Others/src/GachaSimOOP/src/gachasimoop/5starwpns");
                    //            GachaPool.load4StarWpnPool("/mnt/d/Others/src/GachaSimOOP/src/gachasimoop/4starwpns");
                            }
                            catch(IOException ioe){
                                System.err.println(ioe.toString());
                                System.exit(0);
                            }
                            WishSimFX.fx();
                            break;
                        default:
                        case "-h":
                        case "--help":
                            System.out.print(help);
                            break;
                    }
            }
        else
            try{
                    GachaPool.load5StarCharPool("5starchars");
                    GachaPool.load4StarCharPool("4starchars");
                    GachaPool.load5StarWpnPool("5starwpns");
                    GachaPool.load4StarWpnPool("4starwpns");
                    //            GachaPool.load5StarCharPool("/mnt/d/Others/src/GachaSimOOP/src/gachasimoop/5starchars");
                    //            GachaPool.load4StarCharPool("/mnt/d/Others/src/GachaSimOOP/src/gachasimoop/4starchars");
                    //            GachaPool.load5StarWpnPool("/mnt/d/Others/src/GachaSimOOP/src/gachasimoop/5starwpns");
                    //            GachaPool.load4StarWpnPool("/mnt/d/Others/src/GachaSimOOP/src/gachasimoop/4starwpns");
                }
                catch(IOException ioe){
                    System.err.println(ioe.toString());
                    System.exit(0);
                }
            try{
                WishSimFX.fx();
            }
            catch(Exception ex){
                WishSim.cli();
            }
       
    }
    
}
