package com.telran.testTask.fw;

import com.google.common.io.Files;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class HelperBase {

    WebDriver wd;

    public HelperBase(WebDriver wd) {
        this.wd = wd;
    }

    protected void jumpDown() {
        Actions actions = new Actions(wd);
        actions.sendKeys(Keys.PAGE_DOWN).perform();
    }

    public void pause(int millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void type(By locator, String text) {
        click(locator);
        if (text!=null) {
            wd.findElement(locator).clear();
            wd.findElement(locator).sendKeys(text);
        }
    }

    public void click(By by) {
        wd.findElement(by).click();
    }

    public void acceptCookies() {
        click(By.cssSelector("[data-id='button-all']"));
    }

    public void switchToNextTab(int number) {
        List<String> availableWindows = new ArrayList<>(wd.getWindowHandles());
        if (!availableWindows.isEmpty()) {
            wd.switchTo().window(availableWindows.get(number));
        }
    }

    public void takeScreenshot(String pathToFile) {
        File tmp = ((TakesScreenshot) wd).getScreenshotAs(OutputType.FILE);
        File screenshot = new File(pathToFile);
        try {
            Files.copy(tmp,screenshot);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
