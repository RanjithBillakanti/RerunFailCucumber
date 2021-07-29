package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class eServicePortal {
    WebDriver driver;

   public eServicePortal(WebDriver driver)
    {
        this.driver = driver;

    }

    private By usernameorEmail = By.xpath("//input[@placeholder='User name or email']");
    private By Password = By.xpath("//input[@placeholder='Password']");
    private By LoginButton = By.xpath("//button[normalize-space()='Log in']");

    /*public void enterUserName(String username)
    {
        driver.findElement(usernameorEmail).sendKeys(username);
    }

    public void enterPassword(String pwd)
    {
        driver.findElement(Password).sendKeys(pwd);
    }

    public void clickOnLogin()
    {
        driver.findElement(LoginButton).click();
    }*/
    public String geteServicePageTitle() {
        return driver.getTitle();
    }


    public eServicePortal doLogin(String un, String pwd) {
        System.out.println("login with: " + un + " and " + pwd);
        driver.findElement(usernameorEmail).sendKeys(un);
        driver.findElement(Password).sendKeys(pwd);
        driver.findElement(LoginButton).click();
        return new eServicePortal(driver);
    }


}
