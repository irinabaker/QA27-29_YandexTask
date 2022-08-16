package com.telran.testTask.fw;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePageHelper extends HelperBase{

    public HomePageHelper(WebDriver wd) {
        super(wd);
    }

    public void selectMarket() {
        click(By.cssSelector("[data-id='market']"));
    }
}
