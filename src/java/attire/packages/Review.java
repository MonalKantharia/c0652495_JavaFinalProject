/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package attire.packages;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author Monal
 */
public class Review {
    private String productId;
    private String loginId;
    private String review;
    
    Connection connect;
    boolean check = false;
    
    /**
     *
     */
    public Review() {
    }

    /**
     *
     * @param productId
     * @param loginId
     * @param review
     */
    public Review(String productId, String loginId, String review) {
        this.productId = productId;
        this.loginId = loginId;
        this.review = review;
    }

    /**
     *
     * @return
     */
    public String getProductId() {
        return productId;
    }

    /**
     *
     * @param productId
     */
    public void setProductId(String productId) {
        this.productId = productId;
    }

    /**
     *
     * @return
     */
    public String getLoginId() {
        return loginId;
    }

    /**
     *
     * @param loginId
     */
    public void setLoginId(String loginId) {
        this.loginId = loginId;
    }

    /**
     *
     * @return
     */
    public String getReview() {
        return review;
    }

    /**
     *
     * @param review
     */
    public void setReview(String review) {
        this.review = review;
    }
    
    /**
     *
     * @return
     */
    public boolean saveReview(){
        connect = new DB_Connection().getConnection();
        try{
            PreparedStatement prst = connect.prepareStatement("INSERT INTO review (productId, userId, review) values(?,?,?)");
            prst.setString(1, productId);
            prst.setString(2, loginId);
            prst.setString(3, review);
            
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
