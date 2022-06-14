/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gachasimoop.Frontends;

import java.awt.Container;
import java.awt.GridBagConstraints;
import javax.swing.JComponent;

/**
 * Wrapper class for the various fields of GridBagConstraints.
 * @author Harlan Dy - 1CSA
 */
public class GBCExtended extends GridBagConstraints{
    //set the weight of the spaces between each component
    public void setWeight(double x, double y){
        this.weightx = x;
        this.weighty = y;
    }
    //add a component with a container that uses GridBagLayout
    public void gbcAdd(Container con,JComponent jc, int x, int y){
            gridx = x;
            gridy = y;
            super.gridwidth = 1;
            super.gridheight = 1;
            super.fill = GridBagConstraints.NONE;
            con.add(jc, this);
    }
    //Overloaded version that allows user to fill the spaces of each components' occupied width and/or height.   
    public void gbcAdd(Container con,JComponent jc, int x, int y, int gridwidth, int gridheight, boolean hfill, boolean vfill){
        gridx = x;
        gridy = y;
        this.gridwidth = gridwidth;
        this.gridheight = gridheight;
        if(vfill && hfill)
            super.fill = GridBagConstraints.BOTH;
        else if(hfill)
            super.fill = GridBagConstraints.HORIZONTAL;
        else if(vfill)
            super.fill = GridBagConstraints.VERTICAL;
        
        con.add(jc, this);
    }
    
}
