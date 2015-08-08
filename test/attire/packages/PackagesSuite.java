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
public class PackagesSuite extends TestCase {
    
    public PackagesSuite(String testName) {
        super(testName);
    }
    
    public static Test suite() {
        TestSuite suite = new TestSuite("PackagesSuite");
        suite.addTest(AddtoCartServletTest.suite());
        suite.addTest(GetUserImageTest.suite());
        suite.addTest(ProductInfoUPServletTest.suite());
        suite.addTest(UserTest.suite());
        suite.addTest(UserPasswordUpdateServletTest.suite());
        suite.addTest(UserAddressUpdateServletTest.suite());
        suite.addTest(UserContactUpdateServletTest.suite());
        suite.addTest(UserLoginServletTest.suite());
        suite.addTest(CartTest.suite());
        suite.addTest(GetProductImageTest.suite());
        suite.addTest(DeleteCartItemServletTest.suite());
        suite.addTest(ProfilePhotoServletTest.suite());
        suite.addTest(ReviewTest.suite());
        suite.addTest(AdminTest.suite());
        suite.addTest(ProductImageServletTest.suite());
        suite.addTest(AddReviewServletTest.suite());
        suite.addTest(AdminLoginServletTest.suite());
        suite.addTest(AdminChangePasswordServletTest.suite());
        suite.addTest(DB_ConnectionTest.suite());
        suite.addTest(ProductsTest.suite());
        suite.addTest(ProductDeleteServletTest.suite());
        suite.addTest(UserRegisterServletTest.suite());
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
    
}
