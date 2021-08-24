/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TienIch;

import java.awt.Image;
import java.io.File;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import javax.swing.ImageIcon;

/**
 *
 * @author HP PC
 */
public class XImage {
    public static Image getAppIcon(){
        URL u = XImage.class.getResource("/Image/img/Logo.png");
        return new ImageIcon(u).getImage();
    }
    public static ImageIcon read(String file){
        File f = new File("logos",file);
        return new ImageIcon(f.getAbsolutePath());
    }
    public static void save(File src){
        File dst = new File("logos", src.getName());
        if (!dst.getParentFile().exists()) {
            dst.getParentFile().mkdir();
        }
        try {
            Path from = Paths.get(src.getAbsolutePath());
            Path to = Paths.get(dst.getAbsolutePath());
            Files.copy(from, to,StandardCopyOption.REPLACE_EXISTING);
        } catch (Exception e) {
        }
    }
}
