	package com.automation.tests.scripts;

import java.util.List;

import java.util.Properties;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.annotations.Parameters;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.ITestListener;

import com.automation.pages.login.LoginPage;
import com.automation.tests.utilities.PropertiesUtility;




public class SalesforceAutomationScripts  extends BaseTest
{
	
	
	@Test
	public  void loginError_noPassword() throws InterruptedException {
		
	String expected="Please enter your password";
	
	PropertiesUtility pro=new PropertiesUtility();
	Properties appPro= pro.loadFile("applicationDataProperties");
	String username=appPro.getProperty("login.valid.userid");
	String password=appPro.getProperty("login.valid.password");
	
	LoginPage loginpage=new LoginPage(driver);
	loginpage.enterUserName(username);
	//loginpage.enterPassword(password);
	loginpage.clickButton();
	loginpage.alertmessage();
   
	WebDriver actual=loginpage.getErrorTextMessage(); // capture alert message
	Assert.assertEquals(actual,expected);//hard assertion
	//sa.assertEquals(actual,expected);
	//sa.assertAll();	

	System.out.println("Please enter your password.");
	
    
    
	}
	
	@Test
public  void valid_Username_Password() throws InterruptedException {
		
		String Expected="Home Page ~ Salesforce - Developer Edition";
	
		PropertiesUtility pro=new PropertiesUtility();
		Properties appPro= pro.loadFile("applicationDataProperties");
		String username=appPro.getProperty("login.valid.userid");
		String password=appPro.getProperty("login.valid.password");	
		
		
		LoginPage loginpage=new LoginPage(driver);
		loginpage.enterUserName(username);
		loginpage.enterPassword(password);
		loginpage.clickButton();
		
		
	
    Thread.sleep(5000);
    String actual=driver.getTitle();
    Assert.assertEquals(actual,Expected,"fail:valid login to salesforce");//hard assertion
   
   
    }
	
	
    @Test
public  void remember_me() throws InterruptedException {
	
	   String Expected="Home Page ~ Salesforce - Developer Edition";
		
	   PropertiesUtility pro=new PropertiesUtility();
		Properties appPro= pro.loadFile("applicationDataProperties");
		String username=appPro.getProperty("login.valid.userid");
		String password=appPro.getProperty("login.valid.password");	
		
		LoginPage loginpage=new LoginPage(driver);
		loginpage.enterUserName(username);
		loginpage.enterPassword(password);
		loginpage.clickButton();
	   
		
		WebElement rememberme =driver.findElement(By.xpath("/html/body/div[1]/div[1]/div/div/div[2]/div[3]/form/div[3]/label"));
		if(!rememberme.isSelected())
		{
			rememberme.click();
			}
		Thread.sleep(5000);
		//select_Checkbox("string","string");	
		
	    Thread.sleep(5000);
	    String actual=driver.getTitle();
	    Assert.assertEquals(actual,Expected,"fail:test case");//hard assert
	   
	    
	    WebElement usermenushantala =driver.findElement(By.id("userNavButton"));
	    clickElement(usermenushantala,"usermenushantala button","shantala" );
	    WebElement logoutele =driver.findElement(By.xpath("/html/body/div/div[1]/table/tbody/tr/td[3]/div/div[3]/div/div/div[2]/div[3]/a[5]"));
	    clickElement(logoutele,"logout button","Logout" );
	    System.out.println("Login salesforce page is displayed with username");
	    
	   //SelectfromDropDown("usermenushantala", int 4);
	    
	    
	    }
	
	
	
@Test
public  void forgot_Password() throws InterruptedException {
	
	String expected="Forgot Your Password";	
	

	   PropertiesUtility pro=new PropertiesUtility();
		Properties appPro= pro.loadFile("applicationDataProperties");
		String username=appPro.getProperty("login.valid.userid");
		String password=appPro.getProperty("login.valid.password");	
		
    WebElement forgotPassword=driver.findElement(By.xpath("//*[@id=\"forgot_password_link\"]"));
    clickElement(forgotPassword,"Forgot Your Password? button","click" );
    WebElement forgottextele=driver.findElement(By.xpath("//*[@id=\"header\"]"));
    getTextFromElement(forgottextele,"Forgot Your Password");
    /*try {
		String actual=getTextFromElement(forgottextele,"forgot header");
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();*/
    WebElement usernameEle = driver.findElement(By.xpath("//*[@id=\"un\"]"));
    enterText(usernameEle,"shantala.p@bluesky.com","username textbox");
    waitForVisibility(usernameEle, 5, 2, "username textbox");
    WebElement continueele = driver.findElement(By.id("continue"));
    clickElement(continueele,"continue button","click" );
    System.out.println("A new page is displayed with the message-Check Your Email");
    WebElement checkemailele = driver.findElement(By.xpath("//*[@id=\"header\"]"));
    getTextFromElement( checkemailele,"Check your email"); 
    System.out.println("We’ve sent you an email with a link to finish resetting your password.");
  
    
	}
	
	
	
@Test
public  void Validate_LoginErrorMessage() throws InterruptedException{
	 String expected="Please check your username and password. If you still can't log in, contact your Salesforce administrator.";	
	

	   PropertiesUtility pro=new PropertiesUtility();
		Properties appPro= pro.loadFile("applicationDataProperties");
		String username=appPro.getProperty("login.invalid.userid");
		String password=appPro.getProperty("login.invalid.password");	
		
	WebElement usernameEle = driver.findElement(By.name("username"));
	waitForVisibility(usernameEle, 5, 2, "username textbox");
	enterText(usernameEle,username,"username textbox");
	WebElement passwordEle =driver.findElement(By.id("password"));
	//passwordEle.clear();
	Thread.sleep(5000);
	enterText(passwordEle,password,"password textbox");
	WebElement login=driver.findElement(By.id("Login"));
   clickElement(login,"login button","c" );
   Thread.sleep(5000);
   WebElement erroralert=driver.findElement(By.xpath("//*[@id=\"error\"]"));
   Thread.sleep(5000);
   alert(driver,expected);
   Thread.sleep(5000);
	
}
	
    @Test
public  void userMenuDropDown() throws Exception {
	String Expected="Home Page ~ Salesforce - Developer Edition";
	

	   PropertiesUtility pro=new PropertiesUtility();
		Properties appPro= pro.loadFile("applicationDataProperties");
		String username=appPro.getProperty("login.valid.userid");
		String password=appPro.getProperty("login.valid.password");	
		
	WebElement usernameEle = driver.findElement(By.name("username"));
	waitForVisibility(usernameEle, 5, 2, "username textbox");
	enterText(usernameEle,username,"username textbox");
	WebElement passwordEle =driver.findElement(By.id("password"));
	enterText(passwordEle,password,"password textbox");	
	Thread.sleep(5000);	
	WebElement login=driver.findElement(By.id("Login"));
    clickElement(login,"login button","c" );
    Thread.sleep(5000);
    String actual=driver.getTitle();
    Assert.assertEquals(actual,Expected,"fail:test case");//hard assert
    
    
    WebElement usermenushantala =driver.findElement(By.id("userNavButton"));
    clickElement(usermenushantala,"usermenushantala button","shantala" );
    Thread.sleep(5000);
    String dropdownchart=driver.findElement(By.xpath("//div[@id='userNavMenu']")).getText();
    System.out.println("dropdownchart");
    //SelectfromDropDown(usermenushantala, "text");
    Thread.sleep(5000);	
   
  
	}
	
	@Parameters("browsername")
    @Test
public  void myProfile() throws Exception {
	

		   PropertiesUtility pro=new PropertiesUtility();
			Properties appPro= pro.loadFile("applicationDataProperties");
			String username=appPro.getProperty("login.valid.userid");
			String password=appPro.getProperty("login.valid.password");	
			
	
	WebElement usernameEle = driver.findElement(By.name("username"));
	waitForVisibility(usernameEle, 5, 2, "username textbox");
	enterText(usernameEle,username,"username textbox");
	WebElement passwordEle =driver.findElement(By.id("password"));
	enterText(passwordEle,password,"password textbox");	
	Thread.sleep(5000);	
	WebElement login=driver.findElement(By.id("Login"));
    clickElement(login,"login button","c" );
    Thread.sleep(5000);
    WebElement usermenushantala =driver.findElement(By.id("userNavButton"));
    clickElement(usermenushantala,"usermenushantala button","shantala" );
    Thread.sleep(5000);
    String dropdownchart=driver.findElement(By.xpath("//div[@id='userNavMenu']")).getText();
    System.out.println("dropdownchart");
    //SelectfromDropDown(usermenushantala, "text");
    Thread.sleep(5000);	
    
    WebElement myprofileele =driver.findElement(By.xpath("/html/body/div/div[1]/table/tbody/tr/td[3]/div/div[3]/div/div/div[2]/div[3]/a[1]"));
    Thread.sleep(5000);	
    
    clickElement(myprofileele,"myprofile","link" );
    Thread.sleep(1000);	
    
    WebElement editprofileele =driver.findElement(By.xpath("/html/body/div[1]/div[2]/table/tbody/tr/td/div/div[2]/div[2]/div[1]/h3/div/div/a/img"));
    Thread.sleep(1000);
    clickElement(editprofileele,"editprofile","button" );
    Thread.sleep(1000);	
    
    driver.switchTo().frame("contactInfoContentId");
    Thread.sleep(3000);	
    
   // WebElement profileframe =driver.findElement(By.xpath("//a[contains(text(),'About')]");
    System.out.println("inside the profile frame");
    
    WebElement aboutele =driver.findElement(By.xpath("//a[contains(text(),'About')]"));
    clickElement(aboutele,"abouttab","tab" );
    Thread.sleep(2000);	
    
    WebElement lastnameele =driver.findElement(By.xpath("//*[@id=\"lastName\"]"));
    enterText(lastnameele,"Panditji","lastname textbox");
    Thread.sleep(2000);	
    
    WebElement saveall =driver.findElement(By.xpath("/html/body/div/div/div/div[2]/form/div/input[1]"));
    clickElement(saveall,"saveall","frame" );
    Thread.sleep(2000);
    
    WebElement postlinkele =driver.findElement(By.id("publisherAttachTextPost ") );
    clickElement(postlinkele,"post","text" );
    Thread.sleep(2000);
    //stuck here badly
   // WebElement postlinkFrameele =driver.findElement(By.xpath("/html/body/div[1]/div[2]/table/tbody/tr/td/div/div[3]/div[1]/div/div[1]/div/div[2]/ul/li[1]/div/div/div[1]/div[1]/div[1]/div[1]/div/div[2]/div[2]/div/div/iframe")  );
	  //driver.switchTo().frame("cke_wysiwyg_frame cke_reset");
    //driver.switchTo().frame(postlinkFrameele);
    driver.switchTo().frame("iframe");
	  Thread.sleep(2000);
	  
	  
	  
	  WebElement postlinktextele =driver.findElement(By.cssSelector("body"));
	  clickElement(postlinktextele,"postlinkarea","text" ); Thread.sleep(2000);
	  postlinktextele.sendKeys("I am working on it.");
	  
	  driver.switchTo().defaultContent();
	 
    
    WebElement sharebuttonele =driver.findElement(By.id("publishersharebutton"));
    clickElement(sharebuttonele,"postlinkarea","text" );
    
    String exptextpost="I am working on it.";
    WebElement textpost =driver.findElement(By.xpath("//p[contains(text(),'i am working on it')]"));
    String gettextpost= textpost.getText();
    System.out.println( gettextpost);
    
    
 
    }
@Test	
public  void mysetting() throws Exception {
		
	    PropertiesUtility pro=new PropertiesUtility();
		Properties appPro= pro.loadFile("applicationDataProperties");
		String username=appPro.getProperty("login.valid.userid");
		String password=appPro.getProperty("login.valid.password");	
		
		WebElement usernameEle = driver.findElement(By.name("username"));
		waitForVisibility(usernameEle, 5, 2, "username textbox");
		enterText(usernameEle,username,"username textbox");
		WebElement passwordEle =driver.findElement(By.id("password"));
		enterText(passwordEle,password,"password textbox");	
		Thread.sleep(5000);	
		WebElement login=driver.findElement(By.id("Login"));
	    clickElement(login,"login button","c" );
	    Thread.sleep(5000);
	    WebElement usermenushantala =driver.findElement(By.id("userNavButton"));
	    clickElement(usermenushantala,"usermenushantala button","shantala" );
	    Thread.sleep(5000);
	    String dropdownchart=driver.findElement(By.xpath("//div[@id='userNavMenu']")).getText();
	    System.out.println("dropdownchart");
	    //SelectfromDropDown(usermenushantala, "text");
	    Thread.sleep(5000);	
	    
	    WebElement mysettingele =driver.findElement(By.xpath("/html/body/div/div[1]/table/tbody/tr/td[3]/div/div[3]/div/div/div[2]/div[3]/a[2]"));
	    Thread.sleep(1000);	
	    
	    clickElement(mysettingele,"mysetting","link" );
	    Thread.sleep(1000);	
	    
	    WebElement personalele =driver.findElement(By.xpath("/html/body/div/div[2]/table/tbody/tr/td[1]/div/div[4]/div[2]/a"));
	    clickElement(personalele,"mysetting","link" );
	    Thread.sleep(1000);	
	    
	    WebElement loginhistory =driver.findElement(By.id("LoginHistory_font"));
	    clickElement(loginhistory,"mysetting ","link" );
	    Thread.sleep(1000);	
	    
	    WebElement downloadloginhistoryele =driver.findElement(By.xpath("/html/body/div/div[2]/table/tbody/tr/td[2]/div[3]/div[1]/div/div[2]/div/a"));
	    clickElement(downloadloginhistoryele,"download ","link" );
	    System.out.println("download completed");
	    
	    WebElement Displayandlayoutele =driver.findElement(By.xpath("//*[@id=\"DisplayAndLayout_font\"]"));
	    clickElement(Displayandlayoutele,"display link ","layout link" );
        Thread.sleep(1000);	
         
        WebElement customizetabele =driver.findElement(By.xpath("//*[@id=\"CustomizeTabs_font\"]"));
        clickElement(customizetabele," customize tab ","tab" );
        Thread.sleep(1000);	
        
        WebElement customappdropdownele=driver.findElement(By.xpath("/html/body/div/div[2]/table/tbody/tr/td[2]/form/div/div[2]/div[2]/table/tbody/tr[1]/td/label"));
        clickElement(customappdropdownele,"app","app");
        Thread.sleep(1000);	
        System.out.println("customapp");
        
        if( customappdropdownele.isDisplayed()) {
			System.out.println(" select drop down is displayed");
		Select select=new Select( customappdropdownele);
		List<WebElement> customlist= select.getOptions();
		for(WebElement ele:customlist) {
			System.out.println(ele.getText());
		}
		}
		else {
			System.out.println("city select drop down is not visible");
		}
        
}
@Test
public  void developerconsol() throws Exception {
	
	 PropertiesUtility pro=new PropertiesUtility();
		Properties appPro= pro.loadFile("applicationDataProperties");
		String username=appPro.getProperty("login.valid.userid");
		String password=appPro.getProperty("login.valid.password");	
		
	WebElement usernameEle = driver.findElement(By.name("username"));
	waitForVisibility(usernameEle, 5, 2, "username textbox");
	enterText(usernameEle,username,"username textbox");
	WebElement passwordEle =driver.findElement(By.id("password"));
	enterText(passwordEle,password,"password textbox");	
	Thread.sleep(5000);	
	WebElement login=driver.findElement(By.id("Login"));
    clickElement(login,"login button","c" );
    Thread.sleep(5000);
    WebElement usermenushantala =driver.findElement(By.id("userNavButton"));
    clickElement(usermenushantala,"usermenushantala button","shantala" );
    Thread.sleep(5000);
    //String dropdownchart=driver.findElement(By.xpath("//div[@id='userNavMenu']")).getText();
    //System.out.println("dropdownchart");
    //SelectfromDropDown(usermenushantala, "text");
    Thread.sleep(5000);	
  
   
    String basewindowhandle=driver.getWindowHandle();
    WebElement consolewindowlinkele =driver.findElement(By.xpath("/html/body/div/div[1]/table/tbody/tr/td[3]/div/div[3]/div/div/div[2]/div[3]/a[3]"));
    clickElement(consolewindowlinkele,"windowlink","developer consol" );
 			Set<String> allwindowhandle=driver.getWindowHandles();
 			for(String handle:allwindowhandle) {
 				if(!basewindowhandle.equals(handle)) {
 					driver.switchTo().window(handle);
 					break;}
 					System.out.println("Window is opened");
 					driver.switchTo().defaultContent();
 					driver.close();
 				}
	}

@Test
public  void logout() throws Exception {
	
    String Expectedurl="https://tekarch-9c-dev-ed.develop.my.salesforce.com/";
	
    PropertiesUtility pro=new PropertiesUtility();
	Properties appPro= pro.loadFile("applicationDataProperties");
	String username=appPro.getProperty("login.valid.userid");
	String password=appPro.getProperty("login.valid.password");	
	
	WebElement usernameEle = driver.findElement(By.name("username"));
	waitForVisibility(usernameEle, 5, 2, "username textbox");
	enterText(usernameEle,username,"username textbox");
	WebElement passwordEle =driver.findElement(By.id("password"));
	enterText(passwordEle,password,"password textbox");	
	Thread.sleep(1000);	
	WebElement login=driver.findElement(By.id("Login"));
   clickElement(login,"login button","c" );
   Thread.sleep(3000);
   WebElement usermenushantala =driver.findElement(By.id("userNavButton"));
   clickElement(usermenushantala,"usermenushantala button","shantala" );
   Thread.sleep(5000);
   //String dropdownchart=driver.findElement(By.xpath("//div[@id='userNavMenu']")).getText();
   //System.out.println("dropdownchart");
   //SelectfromDropDown(usermenushantala, "text");
   WebElement logoutele =driver.findElement(By.xpath("/html/body/div/div[1]/table/tbody/tr/td[3]/div/div[3]/div/div/div[2]/div[3]/a[5]"));
   clickElement(logoutele,"button","logout" );
   Thread.sleep(5000);
   String actual=driver.getCurrentUrl();
   Assert.assertEquals(actual,Expectedurl,"fail:test case");//hard assert
   System.out.println("passed");
}
       
	}


