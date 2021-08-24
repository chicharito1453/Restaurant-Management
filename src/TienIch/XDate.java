/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TienIch;

import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;

/**
 *
 * @author HP PC
 */
public class XDate {
    static  SimpleDateFormat f = new SimpleDateFormat();
    public static Date toDate(String date, String p){
        try {
            f.applyPattern(p);
            return f.parse(date);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    
   public static String toString(Date date, String p){
        f.applyPattern(p);
        return f.format(date);
    }
   public static Date addDays(Date date, Long d){
        date.setTime(date.getTime()+d*24*60*60*1000);
        return date;
    }
   public static Date now() {
        return new Date(); 
    }
}
