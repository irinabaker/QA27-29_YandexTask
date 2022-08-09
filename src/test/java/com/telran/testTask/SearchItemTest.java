package com.telran.testTask;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class SearchItemTest {

    WebDriver wd;

    @BeforeMethod
    public void setUp() {
        wd = new ChromeDriver();
        wd.get("https://yandex.ru/");
        wd.manage().window().maximize();
        wd.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test
    public void searchItemTest() {
        wd.findElement(By.cssSelector("[data-id='market']")).click();
        switchToNextTab(1);
    }

    public void switchToNextTab(int number) {
        List<String> availableWindows = new ArrayList<>(wd.getWindowHandles());
        if (!availableWindows.isEmpty()) {
            wd.switchTo().window(availableWindows.get(number));
        }
    }
}

    /*   Перейти на Яндекс Маркет
        Выбрать раздел Экспресс
        Выбрать раздел Электроника
        Выбрать раздел Смартфоны
        Зайти в расширенный поиск
        Задать параметр поиска от 20000 до 35000 рублей.
        Выбрать производителя “Apple”
        Применить условия поиска
        Запомнить второй элемент в результатах поиска
        В поисковую строку ввести запомненное значение.
        Найти и проверить, что наименование товара соответствует запомненному значению.*/


