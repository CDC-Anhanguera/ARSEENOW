/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import java.sql.Connection;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author aryel.sa
 */
public class ConFactoryTest {
    ConFactory instance;
    
    public ConFactoryTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getConnection method, of class ConFactory.
     */
    @Test
    public void testGetConnection() {
        System.out.println("getConnection");
        instance = new ConFactory();
        Connection result = instance.getConnection();
        assertNotNull(result);
    }
    
    @Test (expected=RuntimeException.class)
    public void testGetConnectionFail() {
        System.out.println("getConnection (fail)");
        instance = new ConFactory();
        Connection result = instance.getConnection("ccc","123");
        assertNotNull(result);
    }
    
}
