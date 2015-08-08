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
public class ProductsTest extends TestCase {
    
    public ProductsTest(String testName) {
        super(testName);
    }

    public static Test suite() {
        TestSuite suite = new TestSuite(ProductsTest.class);
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
     * Test of uploadProducts method, of class Products.
     */
    public void testUploadProducts() {
        System.out.println("uploadProducts");
        Products instance = new Products();
        boolean expResult = false;
        boolean result = instance.uploadProducts();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of uploadProductImage method, of class Products.
     */
    public void testUploadProductImage() {
        System.out.println("uploadProductImage");
        Products instance = new Products();
        boolean expResult = false;
        boolean result = instance.uploadProductImage();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of deleteProduct method, of class Products.
     */
    public void testDeleteProduct() {
        System.out.println("deleteProduct");
        String productId = "";
        String productName = "";
        Products instance = new Products();
        boolean expResult = false;
        boolean result = instance.deleteProduct(productId, productName);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
