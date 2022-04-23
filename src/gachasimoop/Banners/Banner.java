/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gachasimoop.Banners;

import java.util.Random;

/**
 *
 * @author harlan
 */
public abstract class Banner {
    private int bannerRolls;
    private int _4StarPity;
    protected float softPity;
    protected Random rngd = new Random();
    
    public Banner(){
        bannerRolls = 0;
        _4StarPity = 0;
        softPity = 0.0f;
    }
    public abstract int getRarity();
    public abstract String roll();
    
    public void addRolls(){
        bannerRolls++;
    }
    
    public void add4StarPity(){
        _4StarPity++;
    }
    public void resetRolls(){
        bannerRolls = 0;
    }
    
    public void reset4StarPity(){
        _4StarPity = 0;
    }
    
    public int getBannerRolls(){
        return bannerRolls;
    }
    public int get4StarPity(){
        return _4StarPity;
    }
}
