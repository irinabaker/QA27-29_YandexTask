package com.telran.testTask.fw;

import com.telran.testTask.model.Item;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ItemHelper extends HelperBase{

    public ItemHelper(WebDriver wd) {
        super(wd);
    }

    public void typeInSearchInputField(String itemName) {
        type(By.id("header-search"), itemName);
        click(By.cssSelector("[data-r='search-button']"));
    }

    public String getItemNameFromListByNumber(int number) {
        return wd.findElement(By.cssSelector("div:nth-child(" + number + ") ._2UHry")).getText();
    }

    public void filterItem(Item item) {
        jumpDown();
        type(By.cssSelector("._1heDd:nth-child(1) ._3qxDp"), item.getPriceFrom());
        type(By.cssSelector("._1heDd:nth-child(2) ._3qxDp"), item.getPriceTo());
        click(By.xpath("//span[text()='" + item.getBrand() + "']"));
    }
}
