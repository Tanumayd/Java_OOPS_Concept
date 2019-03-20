package JLR;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.server.handler.SendKeys;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RTClogin2 {
	
	
	public static void main(String arg[]) throws InterruptedException
	{
		WebDriver driver;
		System.setProperty("webdriver.chrome.driver","D:\\Selenium files\\chromedriver_win32\\chromedriver.exe"); // will find the chrome driver exe file
		driver = new ChromeDriver(); // creating instance 
		driver.get("https://localhost:9443/ccm/web");
		//driver.get("https://l-9604:9443/ccm/web/");// hit URL  amit
		driver.manage().window().maximize();
		
		driver.findElement(By.xpath("//input[@name='j_username']")).sendKeys("myadmin");
		driver.findElement(By.xpath("//input[@name='j_password']")).sendKeys("myadmin");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		
		Thread.sleep(3000);
		//driver.findElement(By.xpath("(//a[text()='Motion Systems'])[1]")).click(); //Select Motion system amit
		driver.findElement(By.xpath("//a[text()='Motion Systems 1']")).click();//Select Motion system 
		Thread.sleep(2000);
		driver.findElement(By.xpath("//span[text()='Work Items']")).click(); // select change request work item
		Thread.sleep(4000);
		driver.findElement(By.xpath("//span[text()='Change Request']")).click();
		Thread.sleep(4000);
		
		//CREATING CR WORK ITEM
		
		
		driver.findElement(By.xpath("//div[@aria-label='Summary']")).sendKeys("Welcome to the Selenium Automation Demo->Change Request 1"); //summary field
		
		driver.findElement(By.xpath("//div[@aria-label='Description']")).sendKeys("1. Creating CR 2. Navigate to link and attachment 3. Link child Task");// describtion field
		
		Thread.sleep(2000);
		WebElement changeReqstType = driver.findElement(By.xpath("//span[text()='Select']")); //change request type
		WebDriverWait wait1 = new WebDriverWait(driver, 15);
		wait1.until(ExpectedConditions.visibilityOf(changeReqstType)).click();
		
		Thread.sleep(2000);
		WebElement changeReqstType2 = driver.findElement(By.xpath("//span[text()='Enhancement']"));
		WebDriverWait wait2 = new WebDriverWait(driver, 30);
		wait2.until(ExpectedConditions.visibilityOf(changeReqstType2)).click();
		
		
		WebElement filedAgainst = driver.findElement(By.xpath("//div[@aria-label='Filed Against Unassigned']")); //filed against
		Thread.sleep(2000);
		filedAgainst.click();
		Thread.sleep(2000);
		WebElement filedAgainstTest1 = driver.findElement(By.xpath("//span[text()='test2']"));
		WebDriverWait wait3 = new WebDriverWait(driver, 30);
		wait3.until(ExpectedConditions.visibilityOf(filedAgainstTest1)).click();
		
				
		WebElement owenedBy = driver.findElement(By.xpath("//div[@aria-label='Owned By (Assigned To) Unassigned']")); //Owned by
		Thread.sleep(2000);
		owenedBy.click();
		WebElement OwenedBy_Myadmin= driver.findElement(By.xpath("(//span[text()='myadmin'])[3]"));
		WebDriverWait wait=new WebDriverWait(driver,10);
		wait.until(ExpectedConditions.visibilityOf(OwenedBy_Myadmin)).click();
		
		driver.findElement(By.xpath("(//button[text()='Save'])")).click(); //save work item
		
		Thread.sleep(4000);
		/*WebElement NewSelect = driver.findElement(By.xpath("//select[@class='Select']")); //New select to Send for Analysis 
		WebDriverWait wait4 = new WebDriverWait(driver, 30);
		wait4.until(ExpectedConditions.visibilityOf(NewSelect)).click();
		Thread.sleep(3000);*/
		Select s2 = new Select(driver.findElement(By.xpath("(//select[@class='Select'])[1]")));  ////
		s2.selectByVisibleText("Send for Analysis");
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("(//button[text()='Save'])")).click();
		Thread.sleep(3000);
		
		driver.findElement(By.xpath("//a[text()='Analysis']")).click();
		Thread.sleep(2000);
		
		//estimate
		driver.findElement(By.xpath("(//div[@class='com-ibm-team-apt-web-ui-internal-parts-DurationWidget'])[1]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//div[@class='com-ibm-team-apt-web-ui-internal-parts-DurationWidget'])[1]/input")).sendKeys("20");
		System.out.println("Estimate is 20 Hrs");
		//impact analysis Assignee
		driver.findElement(By.xpath("(//div[@class='AnchorCommand'])[1]")).click();
		driver.findElement(By.xpath("//a[text()='Show All']")).click();
		Actions action = new Actions(driver);
		Thread.sleep(3000);
		WebElement myadmn=driver.findElement(By.xpath("//option[text()='‎myadmin']"));
		action.doubleClick(myadmn).build().perform();
		
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//div[@class='AnchorCommand'])[3]")).click();
		Thread.sleep(2000);
		WebElement impctSystem= driver.findElement(By.xpath("//select[@id='input']")); //impacted subsysem
		Select s3 = new Select(impctSystem);
		s3.selectByVisibleText("Other");
		driver.findElement(By.xpath("//button[text()='OK']")).click();
		
		String title=driver.getTitle(); // work item id stored
		System.out.println("title"+title);
		String id2 = title.substring(0,title.indexOf(":"));  // get the work item ID
		
		int id= Integer.parseInt(id2.replaceAll("[^0-9]", ""));
		
		System.out.println(id);// get the work item ID
	
		
		driver.findElement(By.xpath("(//div[@class='AnchorCommand'])[5]")).click(); //impacted software componenet
		Thread.sleep(2000);
		WebElement impctSoftwreComp= driver.findElement(By.xpath("//select[@id='input']"));
		Select s4 = new Select(impctSoftwreComp);
		s4.selectByVisibleText("Software Component 1");
		driver.findElement(By.xpath("//button[text()='OK']")).click();
	
		driver.findElement(By.xpath("(//div[@class='AnchorCommand'])[6]")).click();  //required testing
		Thread.sleep(2000);
		
		WebElement ReqTesting= driver.findElement(By.xpath("//select[@id='input']"));
		Select s5 = new Select(ReqTesting);
		s5.selectByVisibleText("VIL");
		driver.findElement(By.xpath("//button[text()='OK']")).click();
		
		
		driver.findElement(By.xpath("(//div[@class='AnchorCommand'])[7]")).click(); //impacted vehicle programmed
		Thread.sleep(2000);
		WebElement ImpVehicleProg= driver.findElement(By.xpath("//select[@id='input']"));
		Select s6 = new Select(ImpVehicleProg);
		s6.selectByVisibleText("Not Applicable");
		driver.findElement(By.xpath("//button[text()='OK']")).click();
	
		JavascriptExecutor js = (JavascriptExecutor) driver;  // scroll down
		js.executeScript("window.scrollBy(0,680)", "");
		Thread.sleep(2000);

		WebElement plannedFor1 = driver.findElement(By.xpath("(//span[text()='Unassigned'])[2]")); //planned for
		WebDriverWait wait13 = new WebDriverWait(driver, 30);
		wait13.until(ExpectedConditions.visibilityOf(plannedFor1)).click();
		 
		Thread.sleep(2000);
		WebElement plannedFor2 = driver.findElement(By.xpath("//span[text()='Sprint 1']"));
		WebDriverWait wait22 = new WebDriverWait(driver, 30);
		wait22.until(ExpectedConditions.visibilityOf(plannedFor2)).click();			
		
		WebElement pcds = driver.findElement(By.xpath("//div[@aria-label='PCDS Gateway Not Applicable']")); //pcds gateway
		WebDriverWait wait6 = new WebDriverWait(driver, 30);
		wait6.until(ExpectedConditions.visibilityOf(pcds)).click();
		
		Thread.sleep(2000);
		WebElement pcds2 = driver.findElement(By.xpath("//span[text()='VPE']"));
		WebDriverWait wait7 = new WebDriverWait(driver, 30);
		wait7.until(ExpectedConditions.visibilityOf(pcds2)).click();	
		
		Thread.sleep(2000);
		WebElement ChangeClassfctn1 = driver.findElement(By.xpath("//div[@aria-label='Change Classification Select']")); //change classification
		WebDriverWait wait10 = new WebDriverWait(driver, 20);
		wait10.until(ExpectedConditions.visibilityOf(ChangeClassfctn1)).click();
		
		Thread.sleep(2000);
		WebElement ChangeClassfctn2 = driver.findElement(By.xpath("//span[text()='Class 1']"));
		WebDriverWait wait11 = new WebDriverWait(driver, 20);
		wait11.until(ExpectedConditions.visibilityOf(ChangeClassfctn2)).click();	
		
		driver.findElement(By.xpath("(//button[text()='Save'])")).click();
		Thread.sleep(2000);
		JavascriptExecutor js3 = (JavascriptExecutor) driver;  // scroll up
		js3.executeScript("window.scrollBy(0,-1400)", "");
		
		System.out.println("Saved in Analysis state");
		//Link & Attachments
		driver.findElement(By.xpath("//a[text()='Links And Attachments']")).click();
		
		WebElement links=driver.findElement(By.xpath("//span[@class='DropdownArrow']")); //select link as child
		WebDriverWait w = new WebDriverWait(driver, 20);
		w.until(ExpectedConditions.visibilityOf(links)).click();
		driver.findElement(By.xpath("(//td[text()='Add Children'])[1]")).click();
		
//CREATING TASK WI		
		
		

	Thread.sleep(2000);
	WebElement type = driver.findElement(By.xpath("//select[@aria-label='Type']"));
	Select link = new Select(type);
	link.selectByVisibleText("Task");

	Thread.sleep(2000);
	driver.findElement(By.xpath("//span[text()='Create Linked Task...']")).click(); //create linked task
	Thread.sleep(4000);
	driver.findElement(By.xpath("(//div[@aria-label='Summary'])[2]")).sendKeys("Welcome to the Selenium Automation Demo->Task 1"); //summary
	Thread.sleep(2000);
	
	WebElement unassigned_OwenedBy= driver.findElement(By.xpath("(//div[@class='com-ibm-team-workitem-web-ui-internal-view-editor-mvvm-views-QueryableComboView NotExpanded'])[2]")); //owned by
	//Thread.sleep(1000);
	unassigned_OwenedBy.click();
	
	Thread.sleep(2000);
	WebElement OwenedBy_Myadmin1= driver.findElement(By.xpath("(//span[text()='myadmin'])[3]"));
	WebDriverWait wait90=new WebDriverWait(driver,10);
	wait90.until(ExpectedConditions.visibilityOf(OwenedBy_Myadmin1)).click();
	
	Thread.sleep(2000);
	
driver.findElement(By.xpath("(//div[@class='AnchorCommand'])[2]")).click();  //task type
Thread.sleep(2000);

WebElement taskType = driver.findElement(By.xpath("//select[@id='input']"));
Select stasktype = new Select(taskType);
stasktype.selectByVisibleText("Test Plan");
Thread.sleep(2000);
driver.findElement(By.xpath("//button[text()='OK']")).click();

	Thread.sleep(2000);
	WebElement filedAgainst22 = driver.findElement(By.xpath("//div[@aria-label='Filed Against Unassigned']")); //filed against
	Thread.sleep(2000);
	filedAgainst22.click();
	
	WebElement filedAgainstTest16 = driver.findElement(By.xpath("//span[text()='test2']"));
	WebDriverWait wait91 = new WebDriverWait(driver, 30);
	wait91.until(ExpectedConditions.visibilityOf(filedAgainstTest16)).click();

	Thread.sleep(2000);
	
	driver.findElement(By.xpath("(//button[text()='Save'])[2]")).click(); //save work item
	
	Thread.sleep(4000);
	System.out.println("Saved Task WI");
		
		
	WebElement plannedFor111 = driver.findElement(By.xpath("(//span[text()='Unassigned'])[3]")); //planned for
	WebDriverWait wait145 = new WebDriverWait(driver, 30);
	wait145.until(ExpectedConditions.visibilityOf(plannedFor111)).click();
	 
	Thread.sleep(2000);
	WebElement plannedFor222 = driver.findElement(By.xpath("//span[text()='Sprint 1']"));
	WebDriverWait wait21 = new WebDriverWait(driver, 30);
	wait21.until(ExpectedConditions.visibilityOf(plannedFor222)).click();	
	
	driver.findElement(By.xpath("(//div[@class='readonly-text'])[1]")).click();  //Estimate
	driver.findElement(By.xpath("(//div[@class='com-ibm-team-apt-web-ui-internal-parts-DurationWidget'])[1]/input")).sendKeys("20");
	
	
	driver.findElement(By.xpath("(//button[text()='Save'])[2]")).click(); 
	
	
	Thread.sleep(3000);
	
	s2 = new Select(driver.findElement(By.xpath("(//select[@class='Select'])[3]")));
	s2.selectByVisibleText("Start Working");
	Thread.sleep(2000);
	driver.findElement(By.xpath("(//button[text()='Save'])[2]")).click(); 
	
	driver.findElement(By.xpath("(//a[text()='Implementation'])[2]")).click();  //implementation tab
	Thread.sleep(2000);
	driver.findElement(By.xpath("(//div[@class='RichTextEditorWidget ViewBorder com-ibm-team-workitem-shared-RichText cke_editable cke_editable_inline cke_contents_ltr'])[3]")).sendKeys("Test Automation");//implementation coment

	Thread.sleep(2000);
	driver.findElement(By.xpath("(//div[@class='readonly-text'])[3]")).click();  //Time spent
	driver.findElement(By.xpath("(//div[@class='com-ibm-team-apt-web-ui-internal-parts-DurationWidget'])[3]/input")).sendKeys("20");
	System.out.println("Time spent 20 Hrs");

	driver.findElement(By.xpath("(//button[text()='Save'])[2]")).click();
	Thread.sleep(2000);
		
	s3= new Select(driver.findElement(By.xpath("(//select[@class='Select'])[3]")));
	s3.selectByVisibleText("Send for Review");	
	driver.findElement(By.xpath("(//button[text()='Save'])[2]")).click(); //save work item
	Thread.sleep(3000);
	Select ReviewComp = new Select(driver.findElement(By.xpath("(//select[@class='Select'])[3]")));
	ReviewComp.selectByVisibleText("Review Completed");
	driver.findElement(By.xpath("(//button[text()='Save'])[2]")).click(); //save work item	
	Thread.sleep(2000);
	driver.findElement(By.xpath("//input[@class='SearchInputText']")).sendKeys(String.valueOf(id));
	driver.findElement(By.xpath("//a[@class='SearchButton SearchButtonEnabled']")).click(); //click search
	Thread.sleep(3000);
	
	//RETURN BACK TO CR
	
	driver.findElement(By.xpath("//a[text()='Authorization']")).click();
	driver.findElement(By.xpath("//div[@aria-label='CCB Feedback']")).sendKeys("NA");
	Thread.sleep(2000);
	
	//Adding approvals
	
			driver.findElement(By.xpath("//span[@aria-label='Add approvals']")).click();
			driver.findElement(By.xpath("//td[text()='Add Approval']")).click();
			driver.findElement(By.xpath("//a[text()='Add Approvers...']")).click();
			Thread.sleep(2000);
			driver.findElement(By.xpath("//input[@class='searchText']")).sendKeys("myadmin");
			Thread.sleep(2000);
			
			s2 = new Select(driver.findElement(By.xpath("//select[@dojoattachpoint='userSelector']")));
			s2.selectByIndex(0);
			driver.findElement(By.xpath("(//button[text()='Add and Close'])")).click();
			Thread.sleep(2000);


			driver.findElement(By.xpath("(//span[@class='SectionMenuDownArrowImageContainer SectionMenuHeight'])[2]")).click();
			driver.findElement(By.xpath("//td[text()='Approved']")).click();
			System.out.println("Approval added with approved state");
	
			driver.findElement(By.xpath("(//button[text()='Save'])[2]")).click();
			Thread.sleep(2000);
			s2 = new Select(driver.findElement(By.xpath("(//select[@class='Select'])[3]")));
			s2.selectByVisibleText("Send to Authorisation");
			driver.findElement(By.xpath("(//button[text()='Save'])[2]")).click();
			
			Thread.sleep(4000);
			//navigate to Change approved
			
			/*s2 = new Select(driver.findElement(By.xpath("(//select[@class='Select'])[1]")));
			s2.selectByVisibleText("Change Approved");
			Thread.sleep(2000);*/
			
			driver.findElement(By.xpath("//option[text()='Change Approved']")).click();
			
			driver.findElement(By.xpath("(//button[text()='Save'])[2]")).click();
			Thread.sleep(3000);
			//navigate to Implementation state
			/*s2 = new Select(driver.findElement(By.xpath("(//select[@class='Select'])[1]")));
			s2.selectByVisibleText("Start Working");
			Thread.sleep(2000);*/
			driver.findElement(By.xpath("//option[text()='Start Working']")).click();
			driver.findElement(By.xpath("(//button[text()='Save'])[2]")).click();
	
	//Correct
			
		//navigate to verification tab
			driver.findElement(By.xpath("//a[text()='Verification']")).click();
			Thread.sleep(2000);
			js3.executeScript("window.scrollBy(0,-1400)", "");		
			Thread.sleep(2000);
			//Verification assignee
			driver.findElement(By.xpath("(//span[text()='Unassigned'])[3]")).click();
			driver.findElement(By.xpath("(//span[text()='myadmin'])[6]")).click();
			
			driver.findElement(By.xpath("//option[text()='Implemented']")).click();
			
			Thread.sleep(2000);
			
			driver.findElement(By.xpath("(//button[text()='Save'])[2]")).click();
			Thread.sleep(2000);
			
			//CORRECT
			JavascriptExecutor js33 = (JavascriptExecutor) driver;  // scroll down
			js33.executeScript("window.scrollBy(0,-1500)", "");
			//Verification result
			driver.findElement(By.xpath("//div[@aria-label='Verification Results Fail']")).click();
			driver.findElement(By.xpath("//span[text()='Pass']")).click();
			
			js3.executeScript("window.scrollBy(0,1700)", "");		
			Thread.sleep(2000);
			
			WebElement radioResult = driver.findElement(By.xpath("(//div[@class='RadioButtonWidget'])[1]"));
			if(radioResult.isDisplayed() && radioResult.isEnabled() && !radioResult.isSelected()){
				
				radioResult.click();
			}
			Thread.sleep(2000);
			
			radioResult = driver.findElement(By.xpath("(//div[@class='RadioButtonWidget'])[3]"));
			if(radioResult.isDisplayed() && radioResult.isEnabled() && !radioResult.isSelected()){
				
				radioResult.click();
			}
			Thread.sleep(2000);
			
			radioResult = driver.findElement(By.xpath("(//div[@class='RadioButtonWidget'])[5]"));
			if(radioResult.isDisplayed() && radioResult.isEnabled() && !radioResult.isSelected()){
				
				radioResult.click();
			}
			Thread.sleep(3000);
			
			
			
			//navigate to Verification Passed state
			
	driver.findElement(By.xpath("//option[text()='Verification Passed']")).click();
	driver.findElement(By.xpath("(//button[text()='Save'])[2]")).click();
	System.out.println("CR is created with one Task closed");
			
			
	//COMPLETED	
			
			
			
	
	
	
	
	
	
		
	}

}
