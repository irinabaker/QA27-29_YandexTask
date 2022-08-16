package com.telran.testTask.fw;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CategoryHelper extends HelperBase{

    public CategoryHelper(WebDriver wd) {
        super(wd);
    }

    public void selectCategoryType(String type) {
        click(By.cssSelector("[href='/catalog--" + type + "?how=dpop&glfilter=&cvredirect=3&filter-express-delivery=1&searchContext=express&track=srch_ddl']"));
    }

    public void selectCatalog(String category) {
        click(By.cssSelector("[href='/catalog--" + category + "/list?filter-express-delivery=1&searchContext=express']"));
    }

    public void selectDepartment(String department) {
        click(By.xpath("//span[text()='" + department + "']"));
    }
}
