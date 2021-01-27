package selenium;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.junit.Test;
import org.junit.Before;

/**
 * Unit test for simple App.
 */
public class AppTest {

    private WebDriver driver;

    @Before
    public void setUp() {
        System.out.println("Iniciando configuración...");
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
        driver = new ChromeDriver();
        driver.get("https://www.amazon.com");
        driver.manage().window().maximize();
        System.out.println(driver.getCurrentUrl());
        System.out.println(driver.getTitle());
        driver.navigate().to("https://www.google.com");
    }

    @Test
    public void shouldAnswerWithTrue() {
        System.out.println("Iniciando Pruebas Google...");
        System.out.println("Go To Google...");
        WebElement searchbox = driver.findElement(By.name("q"));
        searchbox.sendKeys("HandBook Devops");
        searchbox.submit();
        System.out.println("Search HandBook Devops...");
        assertEquals("HandBook Devops", driver.getTitle().split("-", 0)[0].trim());
        driver.findElement(By.linkText("Imágenes")).click();
        System.out.println("HandBook Devops Imágenes...");
        assertEquals("HandBook Devops - Google Search", driver.getTitle().trim());
        driver.findElement(By.linkText("Shopping")).click();
        System.out.println("HandBook Devops Shopping...");
        assertEquals("HandBook Devops - Google Shopping", driver.getTitle().trim());
    }

    @Test
    public void shouldSearchInAmazon() {
        System.out.println("Iniciando Pruebas Amazon...");
        System.out.println("Go To Amazon...");
        driver.get("https://www.amazon.com");
        WebElement searchbox = driver.findElement(By.id("twotabsearchtextbox"));
        searchbox.sendKeys("The Phoenix Project");
        searchbox.submit();
        System.out.println("Search The Phoenix Project...");
        assertEquals("The Phoenix Project", driver.getTitle().split(":", 0)[1].trim());
    }
}
