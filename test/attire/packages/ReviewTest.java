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
public class ReviewTest extends TestCase {
    
    public ReviewTest(String testName) {
        super(testName);
    }

    public static Test suite() {
        TestSuite suite = new TestSuite(ReviewTest.class);
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
     * Test of getProductId method, of class Review.
     */
    public void testGetProductId() {
        System.out.println("getProductId");
        Review instance = new Review();
        String expResult = "";
        String result = instance.getProductId();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setProductId method, of class Review.
     */
    public void testSetProductId() {
        System.out.println("setProductId");
        String productId = "";
        Review instance = new Review();
        instance.setProductId(productId);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getLoginId method, of class Review.
     */
    public void testGetLoginId() {
        System.out.println("getLoginId");
        Review instance = new Review();
        String expResult = "";
        String result = instance.getLoginId();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setLoginId method, of class Review.
     */
    public void testSetLoginId() {
        System.out.println("setLoginId");
        String loginId = "";
        Review instance = new Review();
        instance.setLoginId(loginId);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getReview method, of class Review.
     */
    public void testGetReview() {
        System.out.println("getReview");
        Review instance = new Review();
        String expResult = "";
        String result = instance.getReview();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setReview method, of class Review.
     */
    public void testSetReview() {
        System.out.println("setReview");
        String review = "";
        Review instance = new Review();
        instance.setReview(review);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of saveReview method, of class Review.
     */
    public void testSaveReview() {
        System.out.println("saveReview");
        Review instance = new Review();
        boolean expResult = false;
        boolean result = instance.saveReview();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
