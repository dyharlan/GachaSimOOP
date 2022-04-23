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
public class CharacterBanner extends Banner{
    
    private String currentRateUp;
    private String rateUp1;
    private String rateUp2;

    private boolean isGuaranteed;
    
    public CharacterBanner(String rateUp1, String rateUp2){
        this.rateUp1 = rateUp1;
        this.rateUp2 = rateUp2;
        isGuaranteed = false;
    }
    
    public void setCBannerRateUp(int b){
        if(b == 1)
            currentRateUp = rateUp1;
        else if (b == 2)
            currentRateUp = rateUp2;
    }
    
    public String roll(){           
                //  _____    _____ _                 
                // | ____|  / ____| |                
                // | |__   | (___ | |_ __ _ _ __ ___ 
                // |___ \   \___ \| __/ _` | '__/ __|
                //  ___) |  ____) | || (_| | |  \__ \
                // |____/  |_____/ \__\__,_|_|  |___/
                int rarity = this.getRarity();
                //If you randomly got a 5* pull or to 90 pulls, and you're guaranteed, you get the rate up character.
                if( (isGuaranteed == true && rarity == 5) || (isGuaranteed == true && super.getBannerRolls() == 89) ) 
                {
                    super.resetRolls(); //resets rolls to 0.
                    super.add4StarPity(); //builds 4* pity
                    isGuaranteed = !isGuaranteed; //resets guarantee
                    softPity = 0; //clears accumulated pity.
                    return currentRateUp; //returns the character rolled
                }
                //If you randomly got a 5* pull or got to 90 pulls but don't have a guarantee, you have a 50/50 chance to get a rate up 5*.
                //Otherwise, guarantees that the next 5* you pull on this banner is the rate up.
                else if(rarity == 5 || super.getBannerRolls() == 89)
                {
                    super.resetRolls();
                    super.add4StarPity();
                    softPity = 0;
                    if(rngd.nextBoolean() == true)
                    {
                       isGuaranteed = false;
                       return currentRateUp;
                    }
                       isGuaranteed = true;
                       return _5_Star__Characters();
                }
                //  _  _      _____ _                 
                // | || |    / ____| |                
                // | || |_  | (___ | |_ __ _ _ __ ___ 
                // |__   _|  \___ \| __/ _` | '__/ __|
                //    | |    ____) | || (_| | |  \__ \
                //    |_|   |_____/ \__\__,_|_|  |___/                                                        
                //You obtain a 4*. You also reset the 4* counter
                //You are also guaranteed a 4* every 10 pulls, but you also reset the 4* counter.
                else if(rarity == 4 || ( (rarity == 3 || rarity == 4) && super.get4StarPity() >= 9) )
                {
                    super.reset4StarPity();
                    super.addRolls();
                    
                    // 50/50 chance to get a rate up char or weapon
                    return (rngd.nextFloat() >= 0.5f)? _4_Star__Characters() : _4_Star__Weapons("nr");
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
    
    public boolean isGuaranteed(){
        return isGuaranteed;
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
