/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gachasimoop;
import java.util.Random;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.io.*;
import java.util.ArrayList;
/**
 *
 * @author harlan
 */
public class GachaPool {
    //Loads arrays with 2 rows but no columns. This is because the methods below will auto generate the length
    //depending on the text file that supplies the character names.
    public static String[][] chars = new String[2][]; 
    public static String[][] wpns = new String[2][];
    public static Random rngd = new Random();
    
    
    /**
     * This method loads the first row of the chars array with the possible 5* characters on rate-up banners.
     * The last two columns represent the 5* rate up for Character Rateup-1 and Character Rateup-2 respectively
     * @throws FileNotFoundException
     * @throws IOException 
     * @param file A string that provides the path to the file containing the characters.
     */
    public static void load5StarCharPool(String file) throws FileNotFoundException, IOException
    {
        //Path path = Paths.get("/mnt/d/Others/src/GachaSim/src/GachaSim/res/5starchars");
        Path path = Paths.get(file);
        BufferedReader br = new BufferedReader(new FileReader(file));
        String str;
        //creates a temporary arraylist that dynamically expands depending on the lines supplied by the file.
        ArrayList<String> temp = new ArrayList<>();
        //The scanner object seeks through the file to add every line as an element of the temp arraylist.
        while((str = br.readLine()) != null)
        {
            //A string var is added because for some reason startsWith() doesn't seem to work properly when directly invoked on the scanner.
            //Ignores any line that starts with an equals or space.
            if(str.startsWith("=") || str.startsWith(" "))
               continue;
            //Otherwise, the line is added as an element to the arraylist
            temp.add(str);
        }
        //closes the scanner object.
        br.close();
        //Instantiates row 0 of the chars[] array with the length of the arraylist.
        chars[0] = new String[temp.size()];
        //adds all the elements of the arraylist to said row.
        for(int ctr = 0; ctr < chars[0].length && ctr < temp.size() ; ctr++)
        {
            chars[0][ctr] = temp.get(ctr);
        }
        
    }
    
    public static void load4StarCharPool(String file) throws FileNotFoundException, IOException
    {
        //Path path = Paths.get("/mnt/d/Others/src/GachaSim/src/GachaSim/res/4starchars");
        Path path = Paths.get(file);
        BufferedReader br = new BufferedReader(new FileReader(file));
        String str;
        ArrayList<String> temp = new ArrayList<>();
        while((str = br.readLine()) != null)
        {
            //A string var is added because for some reason startsWith() doesn't seem to work properly when directly invoked on the scanner.
            //Ignores any line that starts with an equals or space.
            if(str.startsWith("=") || str.startsWith(" "))
               continue;
            //Otherwise, the line is added as an element to the arraylist
            temp.add(str);
        }
        br.close();
        chars[1] = new String[temp.size()];
        for(int ctr = 0; ctr < chars[1].length && ctr < temp.size() ; ctr++)
        {
            chars[1][ctr] = temp.get(ctr);
        }
    }
    
    public static void load5StarWpnPool(String file) throws FileNotFoundException, IOException
    {
        //Path path = Paths.get("/mnt/d/Others/src/GachaSim/src/GachaSim/res/5starwpns");
        Path path = Paths.get(file);
        BufferedReader br = new BufferedReader(new FileReader(file));
        String str;
        ArrayList<String> temp = new ArrayList<>();
        while((str = br.readLine()) != null)
        {
            //A string var is added because for some reason startsWith() doesn't seem to work properly when directly invoked on the scanner.
            //Ignores any line that starts with an equals or space.
            if(str.startsWith("=") || str.startsWith(" "))
               continue;
            //Otherwise, the line is added as an element to the arraylist
            temp.add(str);
        }
        br.close();
        wpns[0] = new String[temp.size()];
        
        for(int ctr = 0; ctr < wpns[0].length && ctr < temp.size() ; ctr++)
        {
            wpns[0][ctr] = temp.get(ctr);
        }
    }
    
    public static void load4StarWpnPool(String file) throws FileNotFoundException, IOException
    {
        //Path path = Paths.get("/mnt/d/Others/src/GachaSim/src/GachaSim/res/4starwpns");
        Path path = Paths.get(file);
        BufferedReader br = new BufferedReader(new FileReader(file));
        String str;
        ArrayList<String> temp = new ArrayList<>();
        while((str = br.readLine()) != null)
        {
            //A string var is added because for some reason startsWith() doesn't seem to work properly when directly invoked on the scanner.
            //Ignores any line that starts with an equals or space.
            if(str.startsWith("=") || str.startsWith(" "))
               continue;
            //Otherwise, the line is added as an element to the arraylist
            temp.add(str);
        }
        br.close();
        wpns[1] = new String[temp.size()];
        
        for(int ctr = 0; ctr < wpns[1].length && ctr < temp.size() ; ctr++)
        {
            wpns[1][ctr] = temp.get(ctr);
        }
        
    }
    
    /**
    * @return a random 5* non-rate up character
    */
    public static String _5_Star__Characters()
    {
        return chars[0][rngd.nextInt(chars[0].length-2)];
    }
    
    /**
    * @return a random 4* character alongside the rate ups
    */
    public static String _4_Star__Characters()
    {
        return chars[1][rngd.nextInt(chars[1].length)];
    }
    
    /**
    * @return a random 4* non-rate up character if the "nr" is invoked on the method.
    */
    public static String _4_Star__Characters(String args)
    {
        if(args.toLowerCase() == "nr") 
            return chars[1][rngd.nextInt(chars[1].length-3)];
        else
            return "Error";
    }
    
    /**
    * @return a random 5* weapon with rate-up.
    */
    public static String _5_Star__Weapons()
    {
        return wpns[0][rngd.nextInt(wpns[0].length)];
    }
    
    /**
    * @return a random 5* non-rate up weapon if the "nr" is invoked on the method.
    */
    public static String _5_Star__Weapons(String args)
    {
         if(args.toLowerCase() == "nr") 
            return wpns[0][rngd.nextInt(wpns[0].length-2)];
        else
            return "Error";
    }
    
    public static String _4_Star__Weapons()
    {
        return wpns[1][rngd.nextInt(wpns[1].length)];
    }
    public static String _4_Star__Weapons(String args)
    {
         if(args.toLowerCase() == "nr") 
            return wpns[1][rngd.nextInt(wpns[1].length-5)];
        else
            return "Error";
    }
    //I didn't even bother
    public static String _3_Star__Weapons()
    {
        //String[] wpn = {"Cool Steel", "Dull Blade"} ;
        //return wpn[garborates.nextInt(wpn.length)];
        return "3-star...";
    }
    
}
