package creatingAndAccessingWallet;

import java.awt.Toolkit;
import java.awt.datatransfer.DataFlavor;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class CreateAndAccessWalletMnemonic extends LaunchBrowser{
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
	public void accessWalletMnemonic() throws InterruptedException {
		Thread.sleep(2000);
		
		driver.navigate().to("http://182.176.169.225:9045/access-my-wallet");
		driver.findElement(By.xpath("//span[contains(text(),'Mnemonic Phrase']")).click(); 
		  Thread.sleep(2000);
		  WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));	
	      wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("password"))).sendKeys(pwd);
	        driver.findElement(By.name("confirmPassword")).sendKeys(pwd);
	        //selecting 12 phrase option
	        WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(10));	
		      wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[1]/div/div/div[3]/div/div/div[2]/div/div/div[1]/img"))).click();
		      // passing phrase in all the input fields
		      driver.switchTo().activeElement();
		        Thread.sleep(2000);
		        WebElement input1 = driver.findElement(By.cssSelector("div.MuiFormControl-root:nth-child(1) > div:nth-child(1) > input:nth-child(2)"));
		        input1.click();
		        input1.sendKeys(phraseArray[0]);
		        WebElement input2 = driver.findElement(By.cssSelector("div.MuiFormControl-root:nth-child(2) > div:nth-child(1) > input:nth-child(2)"));
		        input2.click();
		        input2.sendKeys(phraseArray[1]);
		        WebElement input3 = driver.findElement(By.cssSelector("div.MuiFormControl-root:nth-child(3) > div:nth-child(1) > input:nth-child(2)"));
		        input3.click();
		        input3.sendKeys(phraseArray[2]);
		        WebElement input4 = driver.findElement(By.cssSelector("div.MuiFormControl-root:nth-child(4) > div:nth-child(1) > input:nth-child(2)"));
		        input4.click();
		        input4.sendKeys(phraseArray[3]);
		        WebElement input5 = driver.findElement(By.cssSelector("div.MuiFormControl-root:nth-child(5) > div:nth-child(1) > input:nth-child(2)"));
		        input5.click();
		        input5.sendKeys(phraseArray[4]);
		        WebElement input6 = driver.findElement(By.cssSelector("div.MuiFormControl-root:nth-child(6) > div:nth-child(1) > input:nth-child(2)"));
		        input6.click();
		        input6.sendKeys(phraseArray[5]);
		        WebElement input7 = driver.findElement(By.cssSelector("div.MuiFormControl-root:nth-child(7) > div:nth-child(1) > input:nth-child(2)"));
		        input7.click();
		        input7.sendKeys(phraseArray[6]);
		        WebElement input8 = driver.findElement(By.cssSelector("div.MuiFormControl-root:nth-child(8) > div:nth-child(1) > input:nth-child(2)"));
		        input8.click();
		        input8.sendKeys(phraseArray[7]);
		        WebElement input9 = driver.findElement(By.cssSelector("div.MuiFormControl-root:nth-child(9) > div:nth-child(1) > input:nth-child(2)"));
		        input9.click();
		        input9.sendKeys(phraseArray[8]);
		        WebElement input10 = driver.findElement(By.cssSelector("div.MuiFormControl-root:nth-child(10) > div:nth-child(1) > input:nth-child(2)"));
		        input10.click();
		        input10.sendKeys(phraseArray[9]);
		        WebElement input11 = driver.findElement(By.cssSelector("div.MuiFormControl-root:nth-child(11) > div:nth-child(1) > input:nth-child(2)"));
		        input11.click();
		        input11.sendKeys(phraseArray[10]);
		        WebElement input12 = driver.findElement(By.cssSelector("div.MuiFormControl-root:nth-child(12) > div:nth-child(1) > input:nth-child(2)"));
		        input12.click();
		        input12.sendKeys(phraseArray[11]);
		        Thread.sleep(3000);
		        driver.findElement(By.xpath("//span[contains(text(),'Unlock Wallet']"));
		        Thread.sleep(5000);
		      
		        
		
	}
}
