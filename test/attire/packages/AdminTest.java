/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package attire.packages;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 *
 * @author Monal
 */
public class AdminTest extends TestCase {
    
    public AdminTest(String testName) {
        super(testName);
    }

    public static Test suite() {
        TestSuite suite = new TestSuite(AdminTest.class);
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
     * Test of getAdminEmail method, of class Admin.
     */
    public void testGetAdminEmail() {
        System.out.println("getAdminEmail");
        Admin instance = null;
        String expResult = "";
        String result = instance.getAdminEmail();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setAdminEmail method, of class Admin.
     */
    public void testSetAdminEmail() {
        System.out.println("setAdminEmail");
        String adminEmail = "";
        Admin instance = null;
        instance.setAdminEmail(adminEmail);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getAdminPassword method, of class Admin.
     */
    public void testGetAdminPassword() {
        System.out.println("getAdminPassword");
        Admin instance = null;
        String expResult = "";
        String result = instance.getAdminPassword();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setAdminPassword method, of class Admin.
     */
    public void testSetAdminPassword() {
        System.out.println("setAdminPassword");
        String adminPassword = "";
        Admin instance = null;
        instance.setAdminPassword(adminPassword);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of checkAdminLogin method, of class Admin.
     */
    public void testCheckAdminLogin() {
        System.out.println("checkAdminLogin");
        Admin instance = null;
        boolean expResult = false;
        boolean result = instance.checkAdminLogin();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of changePassword method, of class Admin.
     */
    public void testChangePassword() {
        System.out.println("changePassword");
        String newAdminPassword = "";
        Admin instance = null;
        boolean expResult = false;
        boolean result = instance.changePassword(newAdminPassword);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
