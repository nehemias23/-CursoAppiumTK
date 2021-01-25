package reports;

import driver.DriverContext;
import io.qameta.allure.Allure;
import io.qameta.allure.model.Status;
import io.qameta.allure.model.StepResult;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;
import sun.rmi.rmic.iiop.Generator;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.UUID;

public class ReportAllure {

    private static SoftAssert softAssert = new SoftAssert();
    public static void addStep(String nombreStep, Boolean screenshot, Status status, Boolean fatal) {

        String uuid = UUID.randomUUID().toString();
        StepResult result = new StepResult().setName(nombreStep).setStatus(status);
        Allure.getLifecycle().startStep(uuid, result);
        if (screenshot){

        }
        Allure.getLifecycle().stopStep(uuid);
        softAssert.assertTrue(true, nombreStep);

        if(status.equals(Status.FAILED)){
            softAssert.fail(nombreStep);
        }
        if(fatal){
            Assert.fail("Fallo  " + nombreStep);
        }
        System.out.println("ReporteAllure: " + nombreStep);
    }

    private static void reportScreenshot(){
        File srcFile;
        srcFile = DriverContext.getDriver().getScreenshotAs(Generator.OutputType.);
        File foto = new File(srcFile.getPath());
        InputStream imagen =  null;

        try {
            imagen = new FileInputStream(foto);
        } catch ( FileNotFoundException e) {
            e.printStackTrace();
        }
        Allure.addAttachment("Imagen Adjunta", imagen);
        
    }
}
