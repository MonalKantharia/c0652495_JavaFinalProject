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
public class CartTest extends TestCase {
    
    public CartTest(String testName) {
        super(testName);
    }

    public static Test suite() {
        TestSuite suite = new TestSuite(CartTest.class);
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
     * Test of addtoCart method, of class Cart.
     */
    public void testAddtoCart() {
        System.out.println("addtoCart");
        Cart instance = new Cart();
        boolean expResult = false;
        boolean result = instance.addtoCart();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of checkout method, of class Cart.
     */
    public void testCheckout() {
        System.out.println("checkout");
        String loginId = "";
        Cart instance = new Cart();
        boolean expResult = false;
        boolean result = instance.checkout(loginId);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of deleteCartItem method, of class Cart.
     */
    public void testDeleteCartItem() {
        System.out.println("deleteCartItem");
        int cartId = 0;
        Cart instance = new Cart();
        boolean expResult = false;
        boolean result = instance.deleteCartItem(cartId);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
