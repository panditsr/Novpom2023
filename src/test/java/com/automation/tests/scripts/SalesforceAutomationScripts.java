package com.automation.tests.scripts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.annotations.Parameters;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.ITestListener;
import com.automation.tests.utilities.PropertiesUtility;



public class SalesforceAutomationScripts  extends BaseTest
{
	@BeforeMethod
	public void setUpMethod() {
		System.out.println("inside before automation");}
	@AfterMethod
	public void tearDownMethod() {
		System.out.println("inside after method");}

	@Parameters({"browsername","version"})
	@Test
	public static void loginError_noPassword() throws InterruptedException {
		
	String expected="Please enter your password";
	launchBrowser("firefox");
	maximiseBroser();
	goTourl("https://login.salesforce.com");
	//PropertiesUtility pro=new PropertiesUtility();
	//Properties p=pro.createPropertyObject();
	//pro.loadFile("applicationDataProperties",p);
	//String username=pro.getPropertyValue("login.valid.userid",p);
	//String password=pro.getPropertyValue("login.valid.password",p);
	WebElement usernameEle = driver.findElement(By.name("username"));
	waitForVisibility(usernameEle, 5, 2, "username textbox");
	enterText(usernameEle,"shantala.p@bluesky.com","username textbox");
	//WebElement passwordEle =driver.findElement(By.id("password"));
	//passwordEle.clear();
	WebElement login=driver.findElement(By.id("Login"));
    clickElement(login,"login button","c" );
    Thread.sleep(5000);
    WebElement alert=driver.findElement(By.id("error"));
	alert(driver,expected);
	//Assert.assertEquals(actual,expected);//hard assertion
	//sa.assertEquals(actual,expected);
	//sa.assertAll();

	System.out.println("Please enter your password.");
	closeBrowser();
    
    
	}
	@Parameters("browsername")
	@Test
public static void valid_Username_Password() throws InterruptedException {
		
		String Expectedtext="Home Page ~ Salesforce - Developer Edition";
	launchBrowser("firefox");
	maximiseBroser();
	goTourl("https://login.salesforce.com");
	WebElement usernameEle = driver.findElement(By.name("username"));
	waitForVisibility(usernameEle, 5, 2, "username textbox");
	enterText(usernameEle,"shantala.p@bluesky.com","username textbox");
	WebElement passwordEle =driver.findElement(By.id("password"));
	//passwordEle.clear();
	enterText(passwordEle,"greengrass13","password textbox");
	WebElement login=driver.findElement(By.id("Login"));
    clickElement(login,"login button","c" );
    Thread.sleep(5000);
    String actual=driver.getTitle();
    if(actual.equalsIgnoreCase(Expectedtext))   //injavascript so findElement not possible
   	 {
   		 System.out.println("Test passed-Home page is displayed");
   	 }
   else {
     
   	 System.out.println("Test failed");}
    closeBrowser();
    }
	
	@Parameters("browsername")
    @Test
public static void remember_me() throws InterruptedException {
	
	   String Expectedtext="Home Page ~ Salesforce - Developer Edition";
		launchBrowser("firefox");
		maximiseBroser();
		goTourl("https://login.salesforce.com");
		WebElement usernameEle = driver.findElement(By.name("username"));
		waitForVisibility(usernameEle, 5, 2, "username textbox");
		enterText(usernameEle,"shantala.p@bluesky.com","username textbox");
		WebElement passwordEle =driver.findElement(By.id("password"));
		//passwordEle.clear();
		enterText(passwordEle,"greengrass13","password textbox");
		WebElement rememberme =driver.findElement(By.xpath("/html/body/div[1]/div[1]/div/div/div[2]/div[3]/form/div[3]/label"));
		if(!rememberme.isSelected())
		{
			rememberme.click();
			}
		Thread.sleep(5000);
		//select_Checkbox("string","string");	
		WebElement login=driver.findElement(By.id("Login"));
	    clickElement(login,"login button","c" );
	    Thread.sleep(5000);
	    String actual=driver.getTitle();
	    if(actual.equalsIgnoreCase(Expectedtext))   //injavascript so findElement not possible
	   	 {
	   		 System.out.println("Home page is displayed");
	   	 }
	   else {
	     
	   	 System.out.println("Test failed");
	   	 }
	    
	    WebElement usermenushantala =driver.findElement(By.id("userNavButton"));
	    clickElement(usermenushantala,"usermenushantala button","shantala" );
	    WebElement logoutele =driver.findElement(By.xpath("/html/body/div/div[1]/table/tbody/tr/td[3]/div/div[3]/div/div/div[2]/div[3]/a[5]"));
	    clickElement(logoutele,"logout button","Logout" );
	    System.out.println("Login salesforce page is displayed with username");
	    
	   //SelectfromDropDown("usermenushantala", int 4);
	    
	    //closeBrowser();
	    }
	
	
	@Parameters("browsername")	
@Test
public static void forgot_Password() throws InterruptedException {
	
	String expected="Forgot Your Password";	
	launchBrowser("firefox");
	maximiseBroser();
	goTourl("https://login.salesforce.com");
	//WebElement usernameEle = driver.findElement(By.name("username"));
	//waitForVisibility(usernameEle, 5, 2, "username textbox");
	//enterText(usernameEle,"shantala.p@bluesky.com","username textbox");
	//WebElement passwordEle =driver.findElement(By.id("password"));
	//passwordEle.clear();
	//WebElement login=driver.findElement(By.id("Login"));
    //clickElement(login,"login button","c" );
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
	
	
	@Parameters("browsername")
@Test
public static void Validate_LoginErrorMessage() throws InterruptedException{
	 String expected="Please check your username and password. If you still can't log in, contact your Salesforce administrator.";	
	launchBrowser("firefox");
	maximiseBroser();
	goTourl("https://login.salesforce.com");
	WebElement usernameEle = driver.findElement(By.name("username"));
	waitForVisibility(usernameEle, 5, 2, "username textbox");
	enterText(usernameEle,"123","username textbox");
	WebElement passwordEle =driver.findElement(By.id("password"));
	//passwordEle.clear();
	Thread.sleep(5000);
	enterText(passwordEle,"22131","password textbox");
	WebElement login=driver.findElement(By.id("Login"));
   clickElement(login,"login button","c" );
   Thread.sleep(5000);
   WebElement erroralert=driver.findElement(By.xpath("//*[@id=\"error\"]"));
   Thread.sleep(5000);
   alert(driver,expected);
   Thread.sleep(5000);
	closeBrowser();
}
	@Parameters("browsername")
    @Test
public static void userMenuDropDown() throws Exception {
	//String Expectedtext="Home Page ~ Salesforce - Developer Edition";
	launchBrowser("firefox");
	maximiseBroser();
	goTourl("https://login.salesforce.com");
	WebElement usernameEle = driver.findElement(By.name("username"));
	waitForVisibility(usernameEle, 5, 2, "username textbox");
	enterText(usernameEle,"shantala.p@bluesky.com","username textbox");
	WebElement passwordEle =driver.findElement(By.id("password"));
	enterText(passwordEle,"greengrass13","password textbox");	
	Thread.sleep(5000);	
	WebElement login=driver.findElement(By.id("Login"));
    clickElement(login,"login button","c" );
    Thread.sleep(5000);
   /* String actual=driver.getTitle();
    if(actual.equalsIgnoreCase(Expectedtext))   //injavascript so findElement not possible for title
   	 {
   		 System.out.println("Home page is displayed");
   	 }
   else {
     
   	 System.out.println("Test failed");
   	 }*/
    
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
public static void myProfile() throws Exception {
	
	launchBrowser("firefox");
	maximiseBroser();
	goTourl("https://login.salesforce.com");
	WebElement usernameEle = driver.findElement(By.name("username"));
	waitForVisibility(usernameEle, 5, 2, "username textbox");
	enterText(usernameEle,"shantala.p@bluesky.com","username textbox");
	WebElement passwordEle =driver.findElement(By.id("password"));
	enterText(passwordEle,"greengrass13","password textbox");	
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
	
	
       
	}

