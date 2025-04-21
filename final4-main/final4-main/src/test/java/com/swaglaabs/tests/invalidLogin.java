package com.swaglaabs.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class invalidLogin {
    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com/");
        driver.manage().window().maximize();
    }

    @Test
    public void testInvalidLogin() {
        driver.findElement(By.id("user-name")).sendKeys("wrong_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();

        String errorMsg = driver.findElement(By.cssSelector("[data-test='error']")).getText();
        Assert.assertTrue(errorMsg.contains("Epic sadface"), "Expected error message not shown.");
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}