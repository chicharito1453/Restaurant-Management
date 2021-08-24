/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TienIch;

import Entity.NHANVIEN;

/**
 *
 * @author HP PC
 */
public class Auth {
    public static NHANVIEN user =null;
    public static void clear(){
        Auth.user=null;
    }
    public static boolean isLogin(){
        return Auth.user!=null;
    }
    public  static boolean isManager(){
        return Auth.isLogin()&&user.getVaiTro().equalsIgnoreCase("QUẢN LÍ");
    }
    
    public  static boolean isCashier(){
        return Auth.isLogin()&&user.getVaiTro().equalsIgnoreCase("THU NGÂN");
    }
}
