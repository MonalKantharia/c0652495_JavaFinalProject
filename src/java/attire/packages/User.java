/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package attire.packages;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Monal
 */
public class User {
    String userId;
    String userEmail;
    String userPassword;
    String userName;
    String userAddress;
    String userGender;
    String userMobile;
    InputStream inputStream;
    
    boolean check = false;
    Connection connect;
    
    /**
     *
     */
    public User() {
    }

    /**
     *
     * @param userId
     * @param userEmail
     * @param userPassword
     * @param userName
     */
    public User(String userId, String userEmail, String userPassword, String userName) {
        
        this.userId = userId;
        this.userEmail = userEmail;
        this.userPassword = userPassword;
        this.userName = userName;
    }
    
    /**
     *
     * @param userId
     * @param userEmail
     * @param inputStream
     */
    public User(String userId, String userEmail, InputStream inputStream){
        
        this.userId = userId;
        this.userEmail = userEmail;
        this.inputStream = inputStream;
    }
    
    /**
     *
     * @return
     */
    public boolean registerUser(){
        
        connect = new DB_Connection().getConnection();
        
        try{
           //to check wether the user already exists
            PreparedStatement prst = connect.prepareStatement("SELECT * FROM userlogin WHERE userId=? AND userEmail=?");
            prst.setString(1, userId);
            prst.setString(2, userEmail);
            
            PreparedStatement prst1 = connect.prepareStatement("SELECT * FROM userdetails WHERE userId=?");
            prst1.setString(1, userId);
            
            ResultSet result = prst.executeQuery();
            ResultSet result1 = prst1.executeQuery();
            result.next();
            result1.next();
            //System.out.println(result.getString("userId"));
            //System.out.println(result1.getString("userId"));
            
            if(result.next() || result1.next())
            {
                check = false;
            }
            else
            {
                PreparedStatement prst2 = connect.prepareStatement("INSERT INTO userdetails(userId, userName) VALUES(?,?)");
                prst2.setString(1, userId);
                prst2.setString(2, userName);
                
                PreparedStatement prst3 = connect.prepareStatement("INSERT INTO userlogin(userId, userEmail, userPassword) VALUES(?,?,?)");
                prst3.setString(1, userId);
                prst3.setString(2, userEmail);
                prst3.setString(3, userPassword);
                
                int row1 = prst2.executeUpdate();
                int row2 = prst3.executeUpdate();
                
                if(row1>0 || row2>0)
                {
                    check = true;
                }
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
     * @param loginId
     * @param inputStream
     * @return
     */
    public boolean setUserImage(String loginId, InputStream inputStream){
        connect = new DB_Connection().getConnection();
        
        
        try
        {
            PreparedStatement st = connect.prepareStatement("UPDATE userdetails SET userImg=? WHERE userId=?");
            st.setBlob(1, inputStream);
            st.setString(2, loginId);
            
            int row = st.executeUpdate();
            
            if(row>0)
            {
                check = true;
            }
            else
            {
                
                PreparedStatement prst1 = connect.prepareStatement("SELECT userId FROM userlogin WHERE userEmail=?");
                prst1.setString(1, loginId);
                
                ResultSet result = prst1.executeQuery();
                if(result.next())
                {
                    loginId = result.getString("userId");
                    setUserImage(loginId, inputStream);
                }
                else
                {
                    check = false;
                }
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
     * @param loginId
     * @param userPassword
     * @return
     */
    public boolean checkUserLogin(String loginId, String userPassword){
        connect = new DB_Connection().getConnection();
        
        try{
            PreparedStatement prst = connect.prepareStatement("SELECT * FROM userlogin WHERE userId=? AND userPassword=?");
            prst.setString(1, loginId);
            prst.setString(2, userPassword);
            ResultSet rs = prst.executeQuery();
            if(rs.next())
            {
                check = true;
            }
            else
            {
                PreparedStatement prst1 = connect.prepareStatement("SELECT * FROM userlogin WHERE userEmail=? AND userPassword=?");
                prst1.setString(1, loginId);
                prst1.setString(2, userPassword);
                ResultSet result1 = prst1.executeQuery();
                if(result1.next())
                {
                    check = true;
                }
                else
                {
                    check = false;
                }
            }
            
        }catch(SQLException ex)
        {
            ex.printStackTrace();
        }
        
        return check;
    }
    
    /**
     *
     * @param userMob
     * @param loginId
     * @return
     */
    public boolean updateUserContact(String userMob, String loginId){
        connect = new DB_Connection().getConnection();
        
        try{
            PreparedStatement prst = connect.prepareStatement("UPDATE userdetails SET userMobNum=? WHERE userId=?");
            prst.setString(1, userMob);
            prst.setString(2, loginId);
            
            int row = prst.executeUpdate();
            
            if(row>0)
            {
                check = true;
            }
            else
            {
                
                PreparedStatement prst1 = connect.prepareStatement("SELECT userId FROM userlogin WHERE userEmail=?");
                
                prst1.setString(1, loginId);
                
                ResultSet result = prst1.executeQuery();
                if(result.next())
                {
                    loginId = result.getString("userId");
                    updateUserContact(userMob, loginId);
                }
                else
                {
                    check = false;
                }
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
     * @param loginId
     * @param userAddress
     * @return
     */
    public boolean updateUserAddress(String loginId, String userAddress){
        
        System.out.println(userAddress);
        
        
        connect = new DB_Connection().getConnection();
        
        try{
            PreparedStatement prst = connect.prepareStatement("UPDATE userdetails SET userAddress=? WHERE userId=?");
            prst.setString(1, userAddress);
            prst.setString(2, loginId);
            
            int row = prst.executeUpdate();
            
            if(row>0)
            {
                check = true;
            }
            else
            {
                
                PreparedStatement prst1 = connect.prepareStatement("SELECT userId FROM userlogin WHERE userEmail=?");
                prst1.setString(1, loginId);
                
                ResultSet result = prst1.executeQuery();
                if(result.next())
                {
                    loginId = result.getString("userId");
                    updateUserContact(loginId, userAddress);
                }
                else
                {
                    check = false;
                }
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
     * @param loginId
     * @param userPassword
     * @return
     */
    public boolean updateUserPassword(String loginId, String userPassword){
        
        connect = new DB_Connection().getConnection();
        
        try
        {
           
            PreparedStatement prst = connect.prepareStatement("UPDATE userlogin SET userPassword=? WHERE userEmail=?");
            prst.setString(1, userPassword);
            prst.setString(2, loginId);
            
            int row = prst.executeUpdate();
            
            if(row>0){
                check = true;
            }
            else{
                
                PreparedStatement prst1 = connect.prepareStatement("UPDATE userlogin SET userPassword=? WHERE userId=?");
                prst1.setString(1, userPassword);
                prst1.setString(2, loginId);
                
                int row1 = prst1.executeUpdate();
            
                if(row1>0){
                    check = true;
                }
            }
        }
        
        catch(SQLException ex)
        {
            ex.printStackTrace();
        }
            return check;
    }
}
