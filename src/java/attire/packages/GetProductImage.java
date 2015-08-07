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
public class GetProductImage {
    
    /**
     *
     * @param connect
     * @param productId
     * @return
     * @throws Exception
     */
    public static byte[] getImage(Connection connect, String productId) throws Exception{
        Class.forName("com.mysql.jdbc.Driver");
        
        Blob image;
        
        byte[] imageData = null;
        
        PreparedStatement prst = connect.prepareStatement("Select productImg from product where productId=?");
        prst.setString(1, productId);
        
        ResultSet result = prst.executeQuery();
        
        while(result.next())
        {
            image = result.getBlob("productImg");
            imageData = image.getBytes(1, (int)image.length());
        }
        
        return imageData;
    }
}
