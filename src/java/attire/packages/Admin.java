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
public class Admin {
    private String adminEmail;
    private String adminPassword;
    Connection connect;
    boolean check = false;

    /**
     *
     * @return
     */
    public String getAdminEmail() {
        return adminEmail;
    }

    /**
     *
     * @param adminEmail
     */
    public void setAdminEmail(String adminEmail) {
        this.adminEmail = adminEmail;
    }

    /**
     *
     * @return
     */
    public String getAdminPassword() {
        return adminPassword;
    }

    /**
     *
     * @param adminPassword
     */
    public void setAdminPassword(String adminPassword) {
        this.adminPassword = adminPassword;
    }

    /**
     *
     * @param adminEmail
     * @param adminPassword
     */
    public Admin(String adminEmail, String adminPassword) {
        
        this.adminEmail = adminEmail;
        this.adminPassword = adminPassword;
    
    }
    
    /**
     *
     * @return
     */
    public boolean checkAdminLogin(){
        try{
            connect = new DB_Connection().getConnection();
        
            PreparedStatement prst = connect.prepareStatement("select * from admin where adminEmail=? and adminPassword=?");
            prst.setString(1, adminEmail);
            prst.setString(2, adminPassword);

            ResultSet result = prst.executeQuery();

            if(result.next())
            {
                check = true;
            }
            
            else{
                check = false;
            }
        }
        
        catch(SQLException ex){
            
            ex.printStackTrace();
        
        }
        
        return check;
    }
    
    /**
     *
     * @param newAdminPassword
     * @return
     */
    public boolean changePassword(String newAdminPassword){
        try{
            connect = new DB_Connection().getConnection();
        
            PreparedStatement prst = connect.prepareStatement("UPDATE admin SET adminPassword=? WHERE adminEmail=? AND adminPassword=?");
            prst.setString(1, newAdminPassword);
            prst.setString(2, adminEmail);
            prst.setString(3, adminPassword);

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

   }
