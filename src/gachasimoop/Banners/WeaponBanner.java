/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gachasimoop.Banners;
import static gachasimoop.GachaPool.*;


/**
 *
 * @author harlan
 */
public class WeaponBanner extends Banner {
    public String roll(){
        //  _____    _____ _                 
        // | ____|  / ____| |                
        // | |__   | (___ | |_ __ _ _ __ ___ 
        // |___ \   \___ \| __/ _` | '__/ __|
        //  ___) |  ____) | || (_| | |  \__ \
        // |____/  |_____/ \__\__,_|_|  |___/
        int rarity = getRarity();
        //You randomly got a 5* pull or if you reach 80 pulls, you have a 50/50 chance to get a rate up 5*.
        if(rarity == 5 || super.getBannerRolls() == 79){
            super.resetRolls(); //resets pity counter to 0
            super.add4StarPity(); // add 4* pity
            softPity = 0; //resets accumulated odds
            return _5_Star__Weapons(); //pray to God.
        }
        //  _  _      _____ _                 
        // | || |    / ____| |                
        // | || |_  | (___ | |_ __ _ _ __ ___ 
        // |__   _|  \___ \| __/ _` | '__/ __|
        //    | |    ____) | || (_| | |  \__ \
        //    |_|   |_____/ \__\__,_|_|  |___/   
                
        //You obtain a 4*. You also reset the 4* counter
        else if(rarity == 4 || ( (rarity == 3 || rarity == 4) && super.get4StarPity() >= 9) ){
            super.reset4StarPity(); //resets 4* count
            super.addRolls(); //adds pity
            //you either get a rate up 4* weapon or char
            return (rngd.nextFloat() >= 0.5f)? _4_Star__Characters("nr") : _4_Star__Weapons();
        }
             
        //  _______                         _     
        // |__   __|                       | |    
        //    | |     _ __    __ _   ___   | |__  
        //    | |    | '__|  / _` | / __|  | '_ \ 
        //    | |    | |    | (_| | \__ \  | | | |
        //    |_|    |_|     \__,_| |___/  |_| |_|  
                
        //You stepped on dogshit.
        else {
            super.add4StarPity();
            super.addRolls();
            return _3_Star__Weapons();
        }
    }
    public int getRarity(){
        float chance;
        if(super.getBannerRolls() >= 63){
            softPity+=0.0625f;
            chance = rngd.nextFloat()-softPity; 
        }
        else
            //if it's less than 64 pulls, it returns the odds without manipulation.
            chance = rngd.nextFloat();
        
        if(chance <= 0.007f) //rarity is 5* if the number is less than or equal to 0.7% or 0.007
            return 5;
        else if(chance <= 0.06f)// rarity is 4* if the number is less than or equal to 6% or 0.06
            return 4;
        else if (chance > 0.06f && chance <= 1f) //fockin shit
             return 3;
        else
            return 3;
    }

}
