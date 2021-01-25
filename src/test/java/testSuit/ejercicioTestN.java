package testSuit;

import org.testng.Assert;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;


import static driver.DriverContext.setUp;

public class ejercicioTestN {

    SoftAssert soft = new SoftAssert();


    @BeforeSuite
    public void metodo1(){
        System.out.println("Inicio de Suit");
        setUp();
    }

    @BeforeMethod
    public void metodo2(){
        System.out.println("Inicio de Test");
    }

    @Test(priority = 1)
    public void metodo3(){
        Assert.assertEquals("Hola", "Hola", "Los String NO son iguales");
        soft.assertEquals("HOLA", "HOLA", "Los String NO son iguales, pero continua el test");
        System.out.println("Test 1");
        soft.assertAll();
    }

    @Test(priority = 2)
    public void metodo4(){
        System.out.println("Test 2");
    }

    @AfterMethod
    public void metodo5(){
        System.out.println("Término de Test");
    }
}
