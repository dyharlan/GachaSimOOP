/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package gachasimoop;

import java.io.IOException;
import java.io.FileNotFoundException;

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
    }
    
}
