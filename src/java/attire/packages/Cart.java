/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package attire.packages;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Monal
 */
public class Cart {
    
    String productId;
    String loginId;
    
    int productCartQty;
    int productQty=0;
    int newProductQty=0;
    
    boolean check = false;
    Connection connect;

    /**
     *
     * @param productId
     * @param loginId
     * @param productCartQty
     */
    public Cart(String productId, String loginId, int productCartQty) {
        
        this.productId = productId;
        this.loginId = loginId;
        this.productCartQty = productCartQty;
    
    }

    Cart() {
        }
    
    /**
     *
     * @return
     */
    public boolean addtoCart(){
        
        connect = new DB_Connection().getConnection();
        
        try{
            PreparedStatement prst = connect.prepareStatement("INSERT INTO cart_items (loginId, productId, productQty, purchased) values(?,?,?,?)");
            prst.setString(1, loginId);
            prst.setString(2, productId);
            prst.setInt(3, productCartQty);
            prst.setString(4, "NO");

            int row = prst.executeUpdate();
            if(row>0){
                
                PreparedStatement prst1 = connect.prepareStatement("SELECT productQty FROM product WHERE productId=?");
                prst1.setString(1, productId);
                
                ResultSet result = prst1.executeQuery();
                
                while(result.next()){
                    productQty = result.getInt("productQty");
                    
                    newProductQty = productQty - productCartQty;
                    
                    PreparedStatement prst2 = connect.prepareStatement("UPDATE product SET productQty=? WHERE productId=?");
                    
                    prst2.setInt(1, newProductQty);
                    prst2.setString(2, productId);
                    
                    int row1 = prst2.executeUpdate();
                    
                    if(row1>0)
                    {
                        check = true;
                    }
                }
             }
            else 
            {
                check=false;
            }
        }
        
        catch(SQLException ex){
            ex.printStackTrace();
        }
        
        return check;
    }
    
    /**
     *
     * @param loginId
     * @return
     */
    public boolean checkout(String loginId){
        Connection connect = new DB_Connection().getConnection();
        int cartId=0;
        try{
            PreparedStatement prst = connect.prepareStatement("SELECT * FROM cart_items WHERE loginId=? AND purchased=?");
            prst.setString(1, loginId);
            prst.setString(2, "NO");
            
            ResultSet result = prst.executeQuery();
            
            while(result.next())
            {
                cartId = result.getInt("cartItemsId");
                
                PreparedStatement prst1 = connect.prepareStatement("UPDATE cart_items SET purchased=? WHERE cartItemsId=? ");
                
                prst1.setString(1, "YES");
                prst1.setInt(2, cartId);
                
                int row = prst1.executeUpdate();
                
                if(row>0)
                {
                    check=true;
                }
            }
        }
        
        catch(SQLException ex){
            ex.printStackTrace();
        }
        
        return check;
    }
    
    /**
     *
     * @param cartId
     * @return
     */
    public boolean deleteCartItem(int cartId){
        
        connect = new DB_Connection().getConnection();
        
        try{
            PreparedStatement prst = connect.prepareStatement("DELETE FROM cart_items WHERE cartItemsId=?");
            prst.setInt(1, cartId);
            
            int row = prst.executeUpdate();
            
            if(row>0)
            {
                check = true;
            }
        }
        
        catch(SQLException ex){
            ex.printStackTrace();
        }
        
        return check;
    }
}
