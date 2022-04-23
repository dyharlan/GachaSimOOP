/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package gachasimoop.Frontends;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import gachasimoop.Banners.*;
import static gachasimoop.GachaPool.*;



import javafx.event.ActionEvent;

/**
 * FXML Controller class
 *
 * @author dyhar
 */
public class WishSimFXController implements Initializable {
    
    @FXML
    private Label guaranteed5;
    @FXML
    private TextArea CharWishHistory;
    @FXML
    private Label CharRolls;
    @FXML
    private Label CharLast4;
    @FXML
    private TextArea CharWishHistory_;
    @FXML
    private Label guaranteed5_;
    @FXML
    private Label CharRolls_;
    @FXML
    private Label CharLast4_;
    @FXML
    private TextArea WpnWishHistory;
    @FXML
    private Label WpnRolls;
    @FXML
    private Label WpnLast4;
    @FXML
    private TextArea StdWishHistory;
    @FXML
    private Label StdRolls;
    @FXML
    private Label StdLast4;
    

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    CharacterBanner cb = new CharacterBanner(chars[0][chars[0].length-2], chars[0][chars[0].length-1]);
    Banner wb = new WeaponBanner();
    Banner std = new StandardBanner();
    @FXML
    private void handleCharRoll(ActionEvent event) {
        cb.setCBannerRateUp(1);
        CharWishHistory.appendText(cb.roll() + "\n");
        guaranteed5.setText(String.valueOf(cb.isGuaranteed()));
        CharRolls.setText(String.valueOf(cb.getBannerRolls()));
        CharLast4.setText(String.valueOf(cb.get4StarPity()));

        guaranteed5_.setText(String.valueOf(cb.isGuaranteed()));
        CharRolls_.setText(String.valueOf(cb.getBannerRolls()));
        CharLast4_.setText(String.valueOf(cb.get4StarPity()));
    }

    @FXML
    private void handleCharRoll10(ActionEvent event) {
       cb.setCBannerRateUp(1);
       for(int ctr = 0 ; ctr < 10 ; ctr++)
       {
           CharWishHistory.appendText(cb.roll() + "\n");
           guaranteed5.setText(String.valueOf(cb.isGuaranteed()));
           CharRolls.setText(String.valueOf(cb.getBannerRolls()));
           CharLast4.setText(String.valueOf(cb.get4StarPity()));

           guaranteed5_.setText(String.valueOf(cb.isGuaranteed()));
           CharRolls_.setText(String.valueOf(cb.getBannerRolls()));
           CharLast4_.setText(String.valueOf(cb.get4StarPity()));
       }
    }

    @FXML
    private void handleCharClearHistory(ActionEvent event) {
        CharWishHistory.clear();
        CharWishHistory_.clear();
    }
    //This Event controls the 2nd banner rate up. During the 2nd half of an update, this mainly duplicates the 1st rate up since i'm too lazy
    // to figure out how to disable this that is reversible.
    @FXML
    private void handleCharRoll_(ActionEvent event) {
        cb.setCBannerRateUp(2);
        CharWishHistory_.appendText(cb.roll() + "\n");
        guaranteed5_.setText(String.valueOf(cb.isGuaranteed()));
        CharRolls_.setText(String.valueOf(cb.getBannerRolls()));
        CharLast4_.setText(String.valueOf(cb.get4StarPity()));
        
        guaranteed5.setText(String.valueOf(cb.isGuaranteed()));
        CharRolls.setText(String.valueOf(cb.getBannerRolls()));
        CharLast4.setText(String.valueOf(cb.get4StarPity()));
    }

    @FXML
    private void handleCharRoll10_(ActionEvent event) {
       cb.setCBannerRateUp(2);
       for(int ctr = 0 ; ctr < 10 ; ctr++)
       {
           CharWishHistory_.appendText(cb.roll() + "\n");
           guaranteed5_.setText(String.valueOf(cb.isGuaranteed()));
           CharRolls_.setText(String.valueOf(cb.getBannerRolls()));
           CharLast4_.setText(String.valueOf(cb.get4StarPity()));
           
           guaranteed5.setText(String.valueOf(cb.isGuaranteed()));
           CharRolls.setText(String.valueOf(cb.getBannerRolls()));
           CharLast4.setText(String.valueOf(cb.get4StarPity()));
       }
    }

    @FXML
    private void handleCharClearHistory_(ActionEvent event) {
        CharWishHistory.clear();
        CharWishHistory_.clear();
    }
    

    @FXML
    private void handleWpnRoll(ActionEvent event) {
        WpnWishHistory.appendText(wb.roll() + "\n");
        WpnRolls.setText(String.valueOf(wb.getBannerRolls()));
        WpnLast4.setText( String.valueOf(wb.get4StarPity()));
    }

    @FXML
    private void handleWpnRoll10(ActionEvent event) {
       for(int ctr = 0 ; ctr < 10 ; ctr++)
       {
            WpnWishHistory.appendText(wb.roll() + "\n");
            WpnRolls.setText(String.valueOf(wb.getBannerRolls()));
            WpnLast4.setText( String.valueOf(wb.get4StarPity()) );
       }
    }

    @FXML
    private void handleWpnClearHistory(ActionEvent event) {
        WpnWishHistory.clear();
    }

    @FXML
    private void handleStdRoll(ActionEvent event) {
        StdWishHistory.appendText(std.roll() + "\n");
        StdRolls.setText(String.valueOf(std.getBannerRolls()));
        StdLast4.setText( String.valueOf(std.get4StarPity()) );
    }

    @FXML
    private void handleStdRoll10(ActionEvent event) {
       for(int ctr = 0 ; ctr < 10 ; ctr++)
       {
           StdWishHistory.appendText(std.roll() + "\n");
           StdRolls.setText(String.valueOf(std.getBannerRolls()));
           StdLast4.setText( String.valueOf(std.get4StarPity()) );
       }
    }

    @FXML
    private void handleStdClearHistory(ActionEvent event) {
        StdWishHistory.clear();
    }

    @FXML
    private void handleExit(ActionEvent event) {
        javafx.application.Platform.exit();
    }

    @FXML
    private void handleHowto(ActionEvent event) {
        
    }

    @FXML
    private void handleAbout(ActionEvent event) {
    }
}
