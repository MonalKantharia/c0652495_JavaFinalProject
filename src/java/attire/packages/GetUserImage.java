/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package attire.packages;

import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author Monal
 */
public class GetUserImage {
    
    /**
     *
     * @param connect
     * @param userId
     * @return
     * @throws Exception
     */
    public static byte[] getImage(Connection connect, String userId) throws Exception{
        
        Class.forName("com.mysql.jdbc.Driver");
        
        Blob image;
        byte[] imageData = null;
        
        PreparedStatement prst = connect.prepareStatement("Select userImg from userdetails where userId=?");
        prst.setString(1, userId);
        
        ResultSet result = prst.executeQuery();
        while(result.next()){
            image = result.getBlob("userImg");
            imageData = image.getBytes(1, (int)image.length());
        }
        
        return imageData;
    }
}
