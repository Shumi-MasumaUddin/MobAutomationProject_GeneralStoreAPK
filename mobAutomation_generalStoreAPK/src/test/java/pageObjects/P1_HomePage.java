package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class P1_HomePage {
		
		public P1_HomePage(AppiumDriver driver) 
		{
			PageFactory.initElements(new AppiumFieldDecorator(driver), this);
		}

		@AndroidFindBy(id="com.androidsample.generalstore:id/nameField")
		public WebElement nameField; 			// public List<WebElement> name; -->for FindByElements
		
		@AndroidFindBy(xpath="//*[@text='Female']")
		public WebElement femaleOption; 
		
		@AndroidFindBy(xpath="//*[@text='Male']")
		public WebElement maleOption; 
		
		@AndroidFindBy(id="android:id/text1")
		public WebElement dropDownClick;
		
		@AndroidFindBy(id="com.androidsample.generalstore:id/btnLetsShop")
		public WebElement letsShop;
		
		@AndroidFindBy(xpath="//*[@text='Bangladesh']")
		public WebElement ChooseCountryBangladesh; 
		
		public WebElement getNameField() 
		{
			System.out.println("Trying to find the Name Field");
			return nameField;
		}
		
	}

