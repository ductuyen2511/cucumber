package utils;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ScreenshotUtil {

    // Method to capture screenshot
    public static void captureScreenshot(WebDriver driver, String scenarioName, io.cucumber.java.Status status) {
        // Take screenshot as a file
        File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

        // Create a folder for each scenario (if it doesn't exist already)
        String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        String scenarioFolderPath = "target/screenshots/" + scenarioName;

        // Create the folder if it doesn't exist
        File scenarioFolder = new File(scenarioFolderPath);
        if (!scenarioFolder.exists()) {
            scenarioFolder.mkdirs();
        }

        // Define the screenshot file path within the scenario folder
        String screenshotPath = scenarioFolderPath + "/" + status + "_" + timestamp + ".png";

        try {
            // Save the screenshot to the specified folder
            FileHandler.copy(screenshot, new File(screenshotPath));
            System.out.println("Screenshot saved to: " + screenshotPath);
        } catch (IOException e) {
            System.out.println("Failed to save screenshot: " + e.getMessage());
        }
    }
}