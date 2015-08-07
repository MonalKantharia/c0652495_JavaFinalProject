/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package attire.packages;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author Monal
 */
public class Products {
    String productId;
    String productCompany;
    String productName;
    String productCategory;
    String productSummary;
    String productTags;
    
    
    int productQty;
    double productPrice;
    InputStream inputStream;
    
    Connection connect;
    boolean check = false;
    
    /**
     *
     */
    public Products()
    {
    }
    
    /**
     *
     * @param productId
     * @param productCompany
     * @param productName
     * @param productCategory
     * @param productSummary
     * @param productTags
     * @param productQty
     * @param productPrice
     */
    public Products(String productId, String productCompany, String productName, String productCategory, String productSummary, String productTags,  int productQty,double productPrice) {
        
        this.productId = productId;
        this.productCompany = productCompany;
        this.productName = productName;
        this.productCategory = productCategory;
        this.productSummary = productSummary;
        this.productTags = productTags;
        this.productQty = productQty;
        this.productPrice = productPrice;
    }
    
    /**
     *
     * @return
     */
    public boolean uploadProducts(){
        connect = new DB_Connection().getConnection();
        
        try{
            String sql = "INSERT INTO product (productId, productCompany, productName, productCategory, productQty, productSummary, productTags, productPrice) values(?,?,?,?,?,?,?,?) ";
            PreparedStatement prst = connect.prepareStatement(sql);
            prst.setString(1,productId);
            prst.setString(2, productCompany);
            prst.setString(3, productName);
            prst.setString(4, productCategory);
            prst.setInt(5, productQty);
            prst.setString(6, productSummary);
            prst.setString(7, productTags);
            prst.setDouble(8, productPrice);
            

            
            int row = prst.executeUpdate();
            if(row>0)
            {
                check=true;
            }
        }
        
        catch(SQLException ex)
        {
            ex.printStackTrace();
        }
        
        
        return check;
    }
    
    /**
     *
     * @param productId
     * @param inputStream
     */
    public Products(String productId, InputStream inputStream){
        
        this.productId = productId;
        this.inputStream = inputStream;
    }
    
    /**
     *
     * @return
     */
    public boolean uploadProductImage()
    {
        
        connect = new DB_Connection().getConnection();
        
        try{
            String sql = "UPDATE product SET productImg=? WHERE productId=?";
            PreparedStatement prst = connect.prepareStatement(sql);
            prst.setBlob(1, inputStream);
            prst.setString(2, productId);
            
            int row = prst.executeUpdate();
            
            if(row>0)
            {
                check = true;
            }
        }
        catch(SQLException ex)
        {
            ex.printStackTrace();
        }
        
        return check;
    }
    
    /**
     *
     * @param productId
     * @param productName
     * @return
     */
    public boolean deleteProduct(String productId, String productName){
        this.productId = productId;
        this.productName = productName;
        
        connect = new DB_Connection().getConnection();
        try{
            PreparedStatement st = connect.prepareStatement("DELETE FROM product WHERE productId=? AND productName=?");
            st.setString(1, productId);
            st.setString(2, productName);
            
            int row = st.executeUpdate();
            if(row>0)
            {
                check = true;
            }
        }
        catch(SQLException ex)
        {
            ex.printStackTrace();
        }
        
        
        return check;
    }
}
