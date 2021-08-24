/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TienIch;

import java.awt.Component;
import javax.swing.JOptionPane;

/**
 *
 * @author HP PC
 */
public class MsgBox {
    public static void alert(Component p, String mess){
        JOptionPane.showMessageDialog(p, mess,"Quản lí quán ăn", JOptionPane.INFORMATION_MESSAGE);
    }
    
    public static boolean confirm(Component p,String mess){
        int a = JOptionPane.showConfirmDialog(p, mess, "Quản lí quán ăn", JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
        return a == JOptionPane.YES_OPTION;
    }
    
    public static String prompt(Component p, String mess){
        return JOptionPane.showInputDialog(p,mess,"Quản lí quán ăn", JOptionPane.INFORMATION_MESSAGE);
    }
}
