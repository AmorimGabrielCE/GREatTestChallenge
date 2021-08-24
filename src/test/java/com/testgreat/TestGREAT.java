package com.testgreat;

import org.openqa.selenium.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestGREAT {
    @Test
    public void registerSuccesfully() throws InterruptedException{
        System.setProperty("webdriver.chrome.driver", "Driver//chromedriver.exe");
        ChromeDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        //First step: Access the URL
        driver.get("https://www.organizze.com.br");  
        // Second step: Click on "Cadastre-se"
        driver.findElement(By.xpath("/html/body/main/header/div/div[2]/div[2]/a[2]")).click();
        // Third step must be select "Organizar minhas finanças" option but hasn't this option on screen
        // Fourth step: Fill in E-mail on "Seu email" field
        driver.findElement(By.id("email")).sendKeys("TestGabrielGreat17@gmail.com");
        // Fifth step: Fill in Password on "Senha" field
        driver.findElement(By.id("password")).sendKeys("testaut2020");
        // Sixth step: Fill in Password on "Repetir Senha" field
        driver.findElement(By.id("passwordConfirmation")).sendKeys("testaut2020");
        // Seventh step: Check the "Li e concordo com os termos de uso" option
        driver.findElement(By.id("termsOfUse")).click();
        // Eigth step: Click on "Começar a usar" button
        driver.findElement(By.xpath("//*[text()='Começar a usar']")).click();

        // Assert to validate if displayed message its same as expected.
        Thread.currentThread().sleep(10000);
        Assertions.assertEquals("Parabéns! O Organizze já está preparado para você!", driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/h3")).getText());
        Assertions.assertEquals("Enviamos um e-mail para sua caixa de entrada. Confirme seu cadastro para receber um e-mail importante da nossa equipe.", driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/p")).getText());
        Assertions.assertEquals("Ok, começar agora", driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/a")).getText());
    }

}
