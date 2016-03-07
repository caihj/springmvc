package com.springapp.mvc;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.net.URL;
import java.util.concurrent.TimeUnit;

/**
 * Created by chj on 2016/3/3.
 */
@RunWith(JUnit4.class)
public class UsageWebdriver {


    @Test
    public void t1() throws Exception
    {
        WebDriver driver = new InternetExplorerDriver();


        driver.get("http://www.baidu.com");

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        Thread.sleep(5000);
        driver.findElement(By.cssSelector("#kw"));


        WebElement kw=driver.findElement(By.id("kw"));


        WebElement su=driver.findElement(By.id("su"));

        kw.sendKeys("汽车");

        su.click();

        Thread.sleep(10000000);


        System.out.println(driver.getPageSource());

        System.out.println(driver.getTitle());

        driver.quit();

    }
}
