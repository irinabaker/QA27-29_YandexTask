package com.telran.testTask.fw;

import com.telran.testTask.utils.MyListener;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import java.util.concurrent.TimeUnit;

public class ApplicationManager {

   // WebDriver wd;
    EventFiringWebDriver wd;

    HomePageHelper homePage;
    CategoryHelper category;
    ItemHelper item;

    public void stop() {
        wd.quit();
    }

    public void init() {
     //  wd = new ChromeDriver();
        wd = new EventFiringWebDriver(new ChromeDriver());
        wd.get("https://yandex.ru/");
        wd.manage().window().maximize();
        wd.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        homePage = new HomePageHelper(wd);
        category = new CategoryHelper(wd);
        item = new ItemHelper(wd);

        wd.register(new MyListener());
    }

    public HomePageHelper getHomePage() {
        return homePage;
    }

    public CategoryHelper getCategory() {
        return category;
    }

    public ItemHelper getItem() {
        return item;
    }
}
