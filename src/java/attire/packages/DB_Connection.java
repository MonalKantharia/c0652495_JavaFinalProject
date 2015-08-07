/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package attire.packages;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Monal
 */
public class DB_Connection {
    
    Connection connect;
    
    /**
     *
     * @return
     */
    public Connection getConnection(){
        
        String database = "jdbc:mysql://localhost:3306/attiredb";
        String user = "root";
        String password = "";
        
        try{
            Class.forName("com.mysql.jdbc.Driver");
            connect = DriverManager.getConnection(database, user, password);
            
        }
        
        catch(ClassNotFoundException| SQLException ex){
            ex.printStackTrace();
        }
        
        return connect;
    }
}
