import static org.junit.jupiter.api.Assertions.*;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class LMSApplicationTester {

    @BeforeClass
    public static void oneTimeSetup(){
         
    }

    @AfterClass
    public static void oneTimeTearDown(){

    }

    @BeforeEach
    public static void setup(){

    }

    @AfterEach
    public static void tearDown(){

    }
    
    @Test
    public void testLogin(){
        LMSApplication lms = LMSApplication.getInstance();
        String username = "test";
        String password = "test";
        assertEquals(true, lms.login(username, password));
    }

    @Test
    public void testLogout(){
        LMSApplication lms = LMSApplication.getInstance();
        String username = "test";
        String password = "test";
        lms.login(username, password);
        assertEquals(true, lms.logout());
    }

}
