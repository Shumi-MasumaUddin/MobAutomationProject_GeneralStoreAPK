package testCases;

import java.io.IOException;
import java.text.DecimalFormat;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.Base;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import pageObjects.P1_HomePage;
import pageObjects.P2_ProductPage;
import pageObjects.P3_CheckOutPage;
import utilities.Utilities_reUseable;

public class Ecommerce extends Base {

	@Test
	public void mySecondTest() throws IOException, InterruptedException {
		AndroidDriver<AndroidElement> driver = capabilities();
		Thread.sleep(2000);
		// driver.findElement(By.id("com.androidsample.generalstore:id/nameField")).sendKeys("Appium");

		P1_HomePage home = new P1_HomePage(driver);
		// home.nameField.sendKeys("appium");
		home.getNameField().sendKeys("appium");
		Thread.sleep(2000);
		Utilities_reUseable util = new Utilities_reUseable(driver);

		
		driver.hideKeyboard();
		  
		home.femaleOption.click(); home.maleOption.click();
		  
		home.dropDownClick.click();
		util.scrollToText("Bangladesh"); Thread.sleep(3000);
		home.ChooseCountryBangladesh.click();
		 
		home.letsShop.click();

		P2_ProductPage products = new P2_ProductPage(driver);
		
		  //Add random products to cart
		  
		 /* products.addToCart.get(0).click(); Thread.sleep(3000);
		 * products.addToCart.get(0).click(); Thread.sleep(3000);
		 * util.scrollToText("Air Jordan 9 Retro"); products.addToCart.get(0).click();
		 * products.addToCart.get(0).click(); util.scrollToText("PG 3");
		 * products.addToCart.get(0).click(); //products.addToCart.get(1).click();
		 * Thread.sleep(3000); products.cart.click(); Thread.sleep(3000);
		 */
		
		// Add all products to cart
		util.scrollNAddToCart(products.addToCartBy, "ADD TO CART");
		Thread.sleep(3000);
		products.cart.click();
		Thread.sleep(3000);

		P3_CheckOutPage cPage = new P3_CheckOutPage(driver);
		
		 // sum of more than 4 products added to cart
		 
		 /* util.scrollDown(.5, .2); double sum = 0; int count =
		 * cPage.productPrice.size();
		 * for (int i = 0; i < count; i++) {
		 * String amount1 = cPage.productPrice.get(i).getText(); 
		 * double amountValue1 = util.getAmount(amount1); 
		 * sum = sum + amountValue1; 
		 * }
		 * sum = Double.parseDouble(new DecimalFormat("##.##").format(sum));//take upto 2 digit after decimal
		 */
		
		//Total price of all products added to cart
		double sum = util.scrollNCollectPrice(cPage.allProductPrice);
		System.out.println("Sum of Products Individually:" + sum);

		String total = cPage.total.getText();//total calculated price of checkout page in text form
		double totalValue = util.getAmount(total);
		totalValue = (double)Math.round(totalValue*100)/100;//round up decimal value
		System.out.println("TotalValue from the application: " + totalValue);

		Assert.assertEquals(sum, totalValue);//assertion or verify

		driver.pressKey(new KeyEvent(AndroidKey.HOME));

		driver.quit();
	}

}
