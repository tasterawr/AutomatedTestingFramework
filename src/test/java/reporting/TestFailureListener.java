package reporting;

import io.qameta.allure.Allure;
import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.Augmenter;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.ByteArrayInputStream;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TestFailureListener implements ITestListener {

    @Attachment(value = "Screenshot", type = "image/png")
    private void makeScreenshotFile(String mes, WebDriver driver) {
        Allure.addAttachment(mes, new ByteArrayInputStream(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES)));
    }

    private void takeScreenshot(String mes, WebDriver driver) {
        SimpleDateFormat timeScreen = new SimpleDateFormat("dd.mm.yyyy 'at' hh.mm.ss");
        String date = timeScreen.format(new Date());
        makeScreenshotFile(mes + " " + date, driver);
    }
    @Override
    public void onTestFailure(ITestResult result) {
        WebDriver driver = (WebDriver) result.getTestContext().getAttribute("WebDriver");
        takeScreenshot("test failed", driver);
    }
}
