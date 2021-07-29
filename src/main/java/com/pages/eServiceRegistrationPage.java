package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class eServiceRegistrationPage {
    WebDriver driver;

    public eServiceRegistrationPage(WebDriver driver)
    {
        this.driver = driver;

    }
    private By Register = By.xpath("//a[normalize-space()='Register']");
    private By Name = By.xpath("//input[@placeholder='Name']");
    private By Surname = By.xpath("//input[@placeholder='Surname']");
    private By Emailaddress = By.xpath("//input[@placeholder='Email address']");
    private By Username = By.xpath("//input[contains(@placeholder,'User name')]");
    private By Password = By.xpath("//input[@placeholder='Password']");
    private By RegisterBtn = By.xpath("//div[@class='col-4 ng-tns-c184-2']");
    private By RegisterBtn1 = By.xpath("//a[normalize-space()='Register']");



    public void fillContactUsForm(String name, String surname, String emailAddress, String userName,String password) {
        driver.findElement(Name).sendKeys(name);
        driver.findElement(Surname).sendKeys(surname);
        driver.findElement(Emailaddress).sendKeys(emailAddress);
        driver.findElement(Username).sendKeys(userName);
        driver.findElement(Password).sendKeys(password);
    }

        public void clickRegisterBtn()
        {
            driver.findElement(RegisterBtn).click();
        }
    public void clickRegisterBtn1()
    {
        driver.findElement(RegisterBtn1).click();
    }
    }


