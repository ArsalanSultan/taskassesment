package creatingAndAccessingWallet;

import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class LaunchBrowser {
	
	public WebDriver driver;
		@BeforeClass
	    public void openchrome() throws InterruptedException {
			  System.setProperty("webdriver.chrome.driver", "/home/asd/Downloads/chromedriver_linux64/chromedriver");
			  
			//ChromeOptions chromeoptions=new ChromeOptions();
		  ///chromeoptions.setHeadless(true);
		        driver = new ChromeDriver();//chromeoptions);
		        driver.manage().window().maximize();
		        DesiredCapabilities caps=new DesiredCapabilities();
		        caps.setCapability("resolution", "1680*1050");
		        
		        String webUrl="http://182.176.169.225:9045/";
		        
				driver.get(webUrl);
	    }
		@AfterClass
		public void shut() throws InterruptedException {
			
			Thread.sleep(5000);
			driver.quit();
		
	}
		//generate random password
		public static char[] generatePassword(int length) {
		      String capitalCaseLetters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		      String lowerCaseLetters = "abcdefghijklmnopqrstuvwxyz";
		      String specialCharacters = "!@#$";
		      String numbers = "1234567890";
		      String combinedChars = capitalCaseLetters + lowerCaseLetters + specialCharacters + numbers;
		      Random random = new Random();
		      char[] password = new char[length];

		      password[0] = lowerCaseLetters.charAt(random.nextInt(lowerCaseLetters.length()));
		      password[1] = capitalCaseLetters.charAt(random.nextInt(capitalCaseLetters.length()));
		      password[2] = specialCharacters.charAt(random.nextInt(specialCharacters.length()));
		      password[3] = numbers.charAt(random.nextInt(numbers.length()));
		   
		      for(int i = 4; i< length ; i++) {
		         password[i] = combinedChars.charAt(random.nextInt(combinedChars.length()));
		      }
		      return password;
		   }
}
