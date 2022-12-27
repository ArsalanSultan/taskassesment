package creatingAndAccessingWallet;

import java.awt.Toolkit;
import java.awt.datatransfer.DataFlavor;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class CreateAndAccessWalletKeystore extends LaunchBrowser{

	@Test
	public void createWallet() throws InterruptedException {
		Thread.sleep(5000);
		
		driver.findElement(By.xpath("//*[text()='Create A Walllet]")).click();
		char[] pwd = generatePassword(8);
		System.out.println(pwd);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		
      WebElement el =  wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("password"))).sendKeys(pwd);
        driver.findElement(By.name("confirmPassword")).sendKeys(pwd);
        
        Thread.sleep(2000);
        driver.findElement(By.xpath("//span[contains(text(),'Next']")).click();   
        // selecting 12 phrase to proceed
        WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"root\"]/div/div/div[3]/div/div/div[2]/div/div/div[1]/img"))).click();
		
        Thread.sleep(2000);
        driver.findElement(By.xpath("//span[contains(text(),'Copy']")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//span[contains(text(),'Next']")).click(); 
        // getting the copied phrase from clipboard
        String myPhrase = (String) Toolkit.getDefaultToolkit().getSystemClipboard().getData(DataFlavor.stringFlavor);
        // storing each word of phrase in array
        String[] phraseArray = myPhrase.split("\\s+");
        for (int i = 0; i < phraseArray.length; i++) {
            phraseArray[i] = phraseArray[i].replaceAll("[^\\w]", "");
        }
        // for eachWord
        for (String eachWord: phraseArray) {
        	Thread.sleep(2000);
            driver.findElement(By.xpath("//span[contains(text(),"+eachWord+"]")).click(); 
          }
        // move next
        driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/div[3]/div/div/div[3]/div[2]/button/span[1]")).click();
        
        driver.switchTo().activeElement();
        Thread.sleep(2000);
        // download keystore file
        WebDriverWait wait11 = new WebDriverWait(driver, Duration.ofSeconds(10));
		
        WebElement generateKeydstore =  wait11.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'Generate Keystore File']")));
        
        Thread.sleep(5000);
      
        
	}
	@Test
	public void accessWalletKeystore() throws InterruptedException {
		Thread.sleep(2000);
		driver.navigate().to("http://182.176.169.225:9045/access-my-wallet");
		driver.findElement(By.xpath("//span[contains(text(),'Keystore File']")).click(); 
		  Thread.sleep(2000);
		 driver.switchTo().activeElement();
	        Thread.sleep(2000);
	        // upload file
	        WebElement uploadKeystore= driver.findElement(By.xpath("//input[@name='file'"));
			uploadKeystore.sendKeys("/home/asd/Downloads/my_creata_wallet_2022-12-27T09-26-33.562Z");
			// enter password
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			
		     wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("password"))).sendKeys(pwd);
		     Thread.sleep(2000);
				driver.findElement(By.xpath("//span[contains(text(),'Unlock Wallet']"));
		
	
	}
	
	
}
