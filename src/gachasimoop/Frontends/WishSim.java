package gachasimoop.Frontends;
import gachasimoop.Banners.*;
import static gachasimoop.GachaPool.*;
import java.util.Scanner;
import java.util.Arrays;
import java.io.*;
/**
 * TODO: FIND SOMEONE TO VERIFY THE ACCURACY OF THE RATES (From my own testing with n=1000, the accumulated rate (1.6%) matches that of what the game presents.)
 * TODO: ADD AN ACTUAL LICENSE
 * TODO: IMPLEMENT FATE POINTS
 * @author dyhar
 */

/**
 *
 * @author harlan
 */
public class WishSim {
    public static void cli(){
        CharacterBanner cb = new CharacterBanner(chars[0][chars[0].length-2], chars[0][chars[0].length-1]);
        Banner wb = new WeaponBanner();
        Banner std = new StandardBanner();
        Scanner input = new Scanner(System.in);
        //BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        boolean isFinished = false;
        int choice;
        while(!isFinished) //keeps the program running until the isFinished flag is turned on.
        {
            if(System.getProperty("os.name").contains("Windows")){
                cls();
            }
            else{
                System.out.print("\033[H\033[2J");
                System.out.flush();
            }
            //System.out.println("\r");
            //The simulator header. W.I.P.
            System.out.println("Welcome to shit gacha!");
            System.out.println(" ");
            //System.out.printf("%.9f\n",Backend.Csoftpity);
            //System.out.printf("%.9f\n",Backend.Wsoftpity);
            //System.out.printf("%.9f\n",Backend.Ssoftpity);
            System.out.println("What do you want to do?\n"
                    + "1. Roll on the 1st Character Banner \n"
                    + "2. Roll on the 2nd Character Banner \n"
                    + "3. Roll on the Weapon Banner \n"
                    + "4. Roll on the Standard Banner\n"
                    + "5. Exit");
            System.out.println(" ");
            System.out.println("Rolls on the Character Banner: " + cb.getBannerRolls());
            System.out.println("Rolls since last 4* on the Character Banner: " + cb.get4StarPity());
            System.out.println("Guaranteed 5* character? " + cb.isGuaranteed());
            System.out.println(" ");
            System.out.println("Rolls on the Weapon Banner: " + wb.getBannerRolls());
            System.out.println("Rolls since last 4* on the Character Banner: " + wb.get4StarPity());
            System.out.println(" ");
            System.out.println("Rolls on the Standard Banner: " + std.getBannerRolls());
            System.out.println("Rolls since last 4* on the Standard Banner: " + std.get4StarPity());
            System.out.println(" ");
            String err = "";
            System.out.println(err);
                choice = input.nextInt();
                switch(choice){
                case 1:
                    cb.setCBannerRateUp(1);
                    CBanner(cb);
                    err = "";
                    break;
                case 2:
                    cb.setCBannerRateUp(2);
                    CBanner(cb);
                    err = "";
                    break;
                case 3:
                    WBanner(wb);
                    err = "";
                    break;
                case 4:
                    StdBanner(std);
                    err = "";
                    break;
                case 5:
                    isFinished = true;
                    //System.exit(0);
                    break;
                default:
                   err = "Invalid input!";
                   break;
                }
            
        }
        
    }
    
    public static void cls(){
    try {
        new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
    } 
    catch (IOException | InterruptedException ex) {
            System.out.println(ex.toString());
        }
    }
    
    public static void CBanner(Banner b){
        Scanner input = new Scanner(System.in);
        CharacterBanner cb = (CharacterBanner) b;
        boolean isFinished = false; 
        //declaring a new scanner class.
        String[] pulls = new String[10];
        Arrays.fill(pulls, "");
        int SinglePullCounter=0;
        int choice;
        
        while(!isFinished){
            if(System.getProperty("os.name").contains("Windows")){
                cls();
            }
            else{
                System.out.print("\033[H\033[2J");
                System.out.flush();
            }
            System.out.println("Rolls on the Character Banner: " + cb.getBannerRolls());
            System.out.println("Rolls since last 4* on the Character Banner: " + cb.get4StarPity());
            System.out.println("Guaranteed 5* character? " + cb.isGuaranteed());
            System.out.println(" ");
            System.out.println(pulls[0]);
            System.out.println(pulls[1]);
            System.out.println(pulls[2]);
            System.out.println(pulls[3]);
            System.out.println(pulls[4]);
            System.out.println(pulls[5]);
            System.out.println(pulls[6]);
            System.out.println(pulls[7]);
            System.out.println(pulls[8]);
            System.out.println(pulls[9]);
            System.out.println(" ");
            //System.out.println(SinglePullCounter);
            System.out.println("What do you want to do?\n"
            + "1. Roll on the Character Banner Once \n"
            + "2. Roll on the Character Banner 10x \n"
            + "3. Go Back.");
            choice = input.nextInt();
            switch(choice){
                case 1://Rolls on the character banner "rate up" once
                    pulls[SinglePullCounter] = cb.roll();
                    SinglePullCounter = (SinglePullCounter+1) % pulls.length; 
                    break;
                case 2:
                    for(SinglePullCounter = 0; SinglePullCounter < pulls.length; SinglePullCounter++)//Rolls on the character banner "rate up" ten times
                        pulls[SinglePullCounter] = cb.roll();
                    break;
                case 3:
                    isFinished = true;
                    break;
            }
            
        }
    }
    
    public static void WBanner(Banner b){
        Scanner input = new Scanner(System.in);
        Banner wb = (WeaponBanner) b;
        boolean isFinished = false; 
        //declaring a new scanner class.
        String[] pulls = new String[10];
        Arrays.fill(pulls, "");
        int SinglePullCounter=0;
        int choice;
        
        while(!isFinished){
            if(System.getProperty("os.name").contains("Windows")){
                cls();
            }
            else{
                System.out.print("\033[H\033[2J");
                System.out.flush();
            }
            System.out.println("Rolls on the Weapon Banner: " + wb.getBannerRolls());
            System.out.println("Rolls since last 4* on the Weapon Banner: " + wb.get4StarPity());
            System.out.println(" ");
            System.out.println(pulls[0]);
            System.out.println(pulls[1]);
            System.out.println(pulls[2]);
            System.out.println(pulls[3]);
            System.out.println(pulls[4]);
            System.out.println(pulls[5]);
            System.out.println(pulls[6]);
            System.out.println(pulls[7]);
            System.out.println(pulls[8]);
            System.out.println(pulls[9]);
            System.out.println(" ");
            System.out.println("What do you want to do?\n"
            + "1. Roll on the Weapon Banner Once \n"
            + "2. Roll on the Weapon Banner 10x \n"
            + "3. Go Back.");
            choice = input.nextInt();
            switch(choice){
                case 1://Rolls on the weapon banner "rate up" once
                    pulls[SinglePullCounter] = wb.roll();
                    SinglePullCounter = (SinglePullCounter+1) % pulls.length; 
                    break;
                case 2:
                    for(SinglePullCounter = 0; SinglePullCounter < pulls.length; SinglePullCounter++)//Rolls on the weapon banner "rate up" ten times
                        pulls[SinglePullCounter] = wb.roll();
                    break;
                case 3:
                    isFinished = true;
                    break;
            }
            
        }
    }
    
    public static void StdBanner(Banner b){
        Scanner input = new Scanner(System.in);
        Banner std = (StandardBanner) b;
        boolean isFinished = false; 
        //declaring a new scanner class.
        String[] pulls = new String[10];
        Arrays.fill(pulls, "");
        int SinglePullCounter=0;
        int choice;
        
        while(!isFinished){
            if(System.getProperty("os.name").contains("Windows")){
                cls();
            }
            else{
                System.out.print("\033[H\033[2J");
                System.out.flush();
            }
            System.out.println("Rolls on the Standard Banner: " + std.getBannerRolls());
            System.out.println("Rolls since last 4* on the Standard Banner: " + std.get4StarPity());
            System.out.println(" ");
            System.out.println(pulls[0]);
            System.out.println(pulls[1]);
            System.out.println(pulls[2]);
            System.out.println(pulls[3]);
            System.out.println(pulls[4]);
            System.out.println(pulls[5]);
            System.out.println(pulls[6]);
            System.out.println(pulls[7]);
            System.out.println(pulls[8]);
            System.out.println(pulls[9]);
            System.out.println(" ");
            System.out.println("What do you want to do?\n"
            + "1. Roll on the Standard Banner Once \n"
            + "2. Roll on the Standard Banner 10x \n"
            + "3. Go Back.");
            choice = input.nextInt();
            switch(choice){
                case 1://Rolls on the weapon banner "rate up" once
                    pulls[SinglePullCounter] = std.roll();
                    SinglePullCounter = (SinglePullCounter+1) % pulls.length; 
                    break;
                case 2:
                    for(SinglePullCounter = 0; SinglePullCounter < pulls.length; SinglePullCounter++)//Rolls on the weapon banner "rate up" ten times
                        pulls[SinglePullCounter] = std.roll();
                    break;
                case 3:
                    isFinished = true;
                    break;
            }
            
        }
    }
}
