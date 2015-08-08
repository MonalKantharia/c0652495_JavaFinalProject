/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package attire.packages;

import java.io.InputStream;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 *
 * @author Monal
 */
public class UserTest extends TestCase {
    
    public UserTest(String testName) {
        super(testName);
    }

    public static Test suite() {
        TestSuite suite = new TestSuite(UserTest.class);
        return suite;
    }
    
    @Override
    protected void setUp() throws Exception {
        super.setUp();
    }
    
    @Override
    protected void tearDown() throws Exception {
        super.tearDown();
    }

    /**
     * Test of registerUser method, of class User.
     */
    public void testRegisterUser() {
        System.out.println("registerUser");
        User instance = new User();
        boolean expResult = false;
        boolean result = instance.registerUser();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setUserImage method, of class User.
     */
    public void testSetUserImage() {
        System.out.println("setUserImage");
        String loginId = "";
        InputStream inputStream = null;
        User instance = new User();
        boolean expResult = false;
        boolean result = instance.setUserImage(loginId, inputStream);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of checkUserLogin method, of class User.
     */
    public void testCheckUserLogin() {
        System.out.println("checkUserLogin");
        String loginId = "";
        String userPassword = "";
        User instance = new User();
        boolean expResult = false;
        boolean result = instance.checkUserLogin(loginId, userPassword);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of updateUserContact method, of class User.
     */
    public void testUpdateUserContact() {
        System.out.println("updateUserContact");
        String userMob = "";
        String loginId = "";
        User instance = new User();
        boolean expResult = false;
        boolean result = instance.updateUserContact(userMob, loginId);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of updateUserAddress method, of class User.
     */
    public void testUpdateUserAddress() {
        System.out.println("updateUserAddress");
        String loginId = "";
        String userAddress = "";
        User instance = new User();
        boolean expResult = false;
        boolean result = instance.updateUserAddress(loginId, userAddress);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of updateUserPassword method, of class User.
     */
    public void testUpdateUserPassword() {
        System.out.println("updateUserPassword");
        String loginId = "";
        String userPassword = "";
        User instance = new User();
        boolean expResult = false;
        boolean result = instance.updateUserPassword(loginId, userPassword);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
