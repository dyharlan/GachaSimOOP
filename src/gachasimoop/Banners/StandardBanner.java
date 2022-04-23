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
public class StandardBanner extends Banner{
    public String roll()
    {
                //  _____    _____ _                 
                // | ____|  / ____| |                
                // | |__   | (___ | |_ __ _ _ __ ___ 
                // |___ \   \___ \| __/ _` | '__/ __|
                //  ___) |  ____) | || (_| | |  \__ \
                // |____/  |_____/ \__\__,_|_|  |___/
                int rarity = getRarity();
                //You get a std 5*. Either if you reach 90 pulls or randomly, you get a 5* weapon or character.
                if(rarity == 5 || super.getBannerRolls() == 89) 
                {
                    super.resetRolls(); //resets rolls to 0.
                    super.add4StarPity(); //builds 4* pity
                    softPity = 0; //clears accumulated pity.
                    //returns either a 5* weapon or character
                    return (rngd.nextBoolean() == true)? _5_Star__Characters() : _5_Star__Weapons("nr"); 
                }
                //  _  _      _____ _                 
                // | || |    / ____| |                
                // | || |_  | (___ | |_ __ _ _ __ ___ 
                // |__   _|  \___ \| __/ _` | '__/ __|
                //    | |    ____) | || (_| | |  \__ \
                //    |_|   |_____/ \__\__,_|_|  |___/                                                        
                //You obtain a 4*. You also reset the 4* counter
                //You are guaranteed a 4* every 10 pulls, but you also reset the 4* counter.
                else if(rarity == 4 || ( (rarity == 3 || rarity == 4) && get4StarPity() >= 9) )
                {
                    super.reset4StarPity();
                    super.addRolls();
                    // 50/50 chance to get a rate up char or weapon
                    return (rngd.nextFloat() >= 0.5f)? _4_Star__Characters("nr") : _4_Star__Weapons("nr");
                }
                //  _______                         _     
                // |__   __|                       | |    
                //    | |     _ __    __ _   ___   | |__  
                //    | |    | '__|  / _` | / __|  | '_ \ 
                //    | |    | |    | (_| | \__ \  | | | |
                //    |_|    |_|     \__,_| |___/  |_| |_|                                            
                //You stepped on trash.
                else 
                {
                    super.add4StarPity();
                    super.addRolls();
                    return _3_Star__Weapons();
                }         
    }
    
    public int getRarity(){
        float chance;
        if(super.getBannerRolls() >= 73){
            super.softPity+=0.0625f;
            chance = rngd.nextFloat()-softPity;
        }
        else
            chance = rngd.nextFloat();
        
        if(chance <= 0.006f) //rarity is 5* if the number is less than or equal to 0.6% or 0.006
            return 5;
        else if(chance <= 0.051f)// rarity is 4* if the number is less than or equal to 5.1% or 0.051
            return 4;
        else if (chance > 0.051f && chance <= 1f) //3* star...
            return 3;
        else
            return 3;
    }
}
