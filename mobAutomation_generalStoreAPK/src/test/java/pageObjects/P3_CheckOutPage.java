package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class P3_CheckOutPage {

	public P3_CheckOutPage(AppiumDriver driver) 
	{
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	@AndroidFindBy(id="com.androidsample.generalstore:id/productPrice")
	public List<WebElement> productPrice;
	
	@AndroidFindBy(id= "com.androidsample.generalstore:id/totalAmountLbl")
	public WebElement total;
	
	public By allProductPrice = By.id("com.androidsample.generalstore:id/productPrice");
}
