/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EssaiFrameChrys.KeyWord;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javafx.scene.control.RadioButton;

/**
 *
 * @author Chrys
 */
public class StateListener  implements ActionListener{

    
    @Override
    public void actionPerformed(ActionEvent e) {
        
        
        System.out.println("source:"+ ((RadioButton)e.getSource()).getText()+ "état:" +((RadioButton)e.getSource()).isSelected());
    }
    
}
