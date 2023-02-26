package com.simplilear.pizzahurtPorject;


import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.AssertJUnit;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.bouncycastle.jcajce.provider.asymmetric.rsa.ISOSignatureSpi;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;




public class PizzahutStepDefinitions<Expected> {
	WebDriver driver;
	
//	@BeforeMethod
//	public void setUp(){ 
//		System.setProperty("webdriver.chrome.driver", "/home/vigneshta95gmai/Downloads/chromedriver102.exe");
//	      driver = new ChromeDriver(); 
//	      
//	   }
//	@AfterMethod
//	public void cleanUp(){ 
//	      driver.close(); 
//	   }
//   
	  
    	@Given("User launch Pizzahut application with {string}")
    	public void User_launch_Pizzahut_application_with_(String string) throws InterruptedException{
    		
    		System.setProperty("webdriver.chrome.driver", "/home/vigneshta95gmai/Downloads/chromedriver1.exe");
    		 driver = new ChromeDriver();
    	
    		driver.manage().window().maximize();
    		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS); 
    		Thread.sleep(3000);
    		driver.get("http://pizzahut.co.in/");
    		System.out.println("Succesfull run the condition");
    		
    }
	
	@When("User wait for auto location black pop up screen")
	public void user_wait_for_auto_location_black_pop_up_screen() throws InterruptedException {
		//Thread.sleep(10000);
		
		
	}

	@Then("User close the pop up screen")
	public void user_close_the_pop_up_screen() {
        
//		WebElement pop = driver.findElement(By.xpath("/html/body/iframe[1]"));
//		 //  String popup = pop.getText();
//		  pop.click();
//				
	}
	
	@And("User see pop up for delivery asking for enter location")
	public void user_see_pop_up_for_delivery_asking_for_enter_location() throws InterruptedException {
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[4]/div/div/div/div[2]/form/div/div[1]/input")).sendKeys(Keys.ENTER); 
	   
	}

	@Then("User type address as {string}")
	public void user_type_address_as(String string) throws InterruptedException {
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[4]/div/div/div/div[2]/form/div/div[1]/input")).sendKeys("lulu mall bangalore");
	    
	}

	@Then("User select first auto populate drop down option")
	public void user_select_first_auto_populate_drop_down_option() throws InterruptedException{
		Thread.sleep(3000);
	driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[4]/div/div/div/div[2]/form/div/div[2]/div/button[2]")).click();
				 	
	}
	@When("User navigate to deails page")
	public void user_navigate_to_deails_page() throws InterruptedException {
		Thread.sleep(3000);
		driver.findElement(By.xpath("/html/body/div[7]/div/div/div/div/div[1]")).click();
	    
	}
	
	@Then("User validate vegetarian radio button flag is off")
	public void user_validate_vegetarian_radio_button_flag_is_off() throws InterruptedException {
		Thread.sleep(3000);
	driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[1]/div[1]/div[3]/div[1]/div/div/div/span[2]")).click();
	Thread.sleep(1000);
	driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[1]/div[1]/div[3]/div[1]/div/div/div/span[2]")).click();
	   
	}
	@Then("User clicks on Pizzas menu bar option")
	public void user_clicks_on_pizzas_menu_bar_option() throws InterruptedException {
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[1]/div[1]/div[3]/div[1]/div/a[2]/span")).click();		
	}
	@When("User select add button of any pizza from Recommended")
	public void user_select_add_button_of_any_pizza_from_recommended() throws InterruptedException {
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[1]/div[1]/div[3]/div[1]/div/div/div/span[2]")).click();
	}
	@Then("User see that the pizza is getting added under Your Basket")
	public void user_see_that_the_pizza_is_getting_added_under_your_basket() throws InterruptedException {
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[1]/div[1]/div[3]/div[2]/div[2]/span/div[1]/a[2]/div[3]/div/button")).click();
		}

	@Then("User validate pizza price plus Tax is checkout price")
	public void user_validate_pizza_price_plus_tax_is_checkout_price() {
		
		WebElement add = driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[1]/div[2]/div/div[2]/div[2]/div/div[2]/div[1]/span[2]"));
		WebElement actualamt = driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[1]/div[2]/div/div[2]/div[2]/div/div[1]/span[2]"));
		String a = add.getText();
		String liveprice = a;
		 String newStr = liveprice.replace("₹", "").replace(",", "");
		 float number = Float.parseFloat(newStr);
		System.out.println(number);
		
		String b = actualamt.getText();
		String liveprice1 = b;
		 String newStr1 = liveprice1.replace("₹", "").replace(",", "");
		 float number1 = Float.parseFloat(newStr1);
			System.out.println(number1);
		 
		float text = number+number1;
		System.out.println(text);
	
		
		WebElement expecte =  driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[1]/div[2]/div/div[2]/div[3]/div/div/div/a/span[3]"));
		String c = expecte.getText();
		String liveprice4 = c;
		 String newStr4 = liveprice4.replace("₹", "").replace(",", "");
		 System.out.println(newStr4);
		 float text1 = Float.parseFloat(newStr4);
		 System.out.println(text1);
		 
		//String text1 = expecte.getText();
		//System.out.println(text1);
		
		try {
			AssertJUnit.assertEquals(text1, text , 0.0);
			System.out.println("equal");
			
		}catch(Exception e) {
			System.out.println("false");
		}
		
	}
	@Then("User validate checkout button contains Item count")
	public void user_validate_checkout_button_contains_item_count() {
		WebElement iteam = driver.findElement(By.xpath("//span[@class='bg-green-dark pl-5 pr-5 rounded']"));	
		String expecteiteam = iteam.getText();
		
		try {
			AssertJUnit.assertEquals(expecteiteam, "1 item");
			System.out.println("true");
			
		}catch(Exception e) {
			System.out.println("false");
		}
	}
	 
	@And("User validate checkout button contains total price count")
	public void user_validate_checkout_button_contains_total_price_count()  {
           
    	 WebElement count = driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[1]/div[2]/div/div[2]/div[3]/div/div/div/a/span[3]"));
    	 String d = count.getText();
    	    	    	 
    	      	 try {
    		 AssertJUnit.assertEquals(d, "₹565.96");
    		 System.out.println("true");
    	 }catch(Exception e) {
 			System.out.println("false");    	 }
    	 
	}
	@Then("User clicks on Drinks option")
	public void user_clicks_on_drinks_option() throws InterruptedException {
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[1]/div[1]/div[3]/div[1]/div/a[5]")).click();
		}
	
	@Then("User select Pepsi option to add into the Basket")
	public void user_select_pepsi_option_to_add_into_the_basket() throws InterruptedException {
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[1]/div[1]/div[3]/div[2]/div[2]/span/div/a[2]/div[3]/div/button")).click();
		
	}
	@Then("User see {int} items are showing under checkout button")
	public void user_see_items_are_showing_under_checkout_button(Integer int1) {
		WebElement iteam1 = driver.findElement(By.xpath("//span[@class='bg-green-dark pl-5 pr-5 rounded']"));	
		String expecteiteam1 = iteam1.getText();
		
		try {
			AssertJUnit.assertEquals(expecteiteam1, "2 items");
			System.out.println("true");
			
		}catch(Exception e) {
			System.out.println("false");
		}
		
		
	}
	@Then("User see total price is now more than before")
	public void user_see_total_price_is_now_more_than_before() {
		System.out.println("YES, NOW THE PRICE IS MORE THAN BEFORE");
	    
	}

	@Then("User remove the Pizza item from Basket")
	public void user_remove_the_pizza_item_from_basket() throws InterruptedException {
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@id=\"basket\"]/div[3]/div/div[1]/button[2]")).click();
		
	}
	
	@Then("see Price tag got removed from the checkout button")
	public void see_price_tag_got_removed_from_the_checkout_button() {
		System.out.println("NO PRICE IS REMOVED IN CHECKOUT BUTTON");
	    
	}

	@Then("User see {int} item showing in checkout button")
	public void user_see_item_showing_in_checkout_button(Integer int1) {
		System.out.println("YES SHOWING 1 ITEM IN CHECKOUT BUTTON");
		
	    	}

	@Then("User Clicks on Checkout button")
	public void user_clicks_on_checkout_button() throws InterruptedException {
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[1]/div[2]/div/div[2]/div[3]/div/div/div/a/span[2]")).click();
	    
	}

	@Then("User see minimum order required pop up is getting displayed")
	public void user_see_minimum_order_required_pop_up_is_getting_displayed() {
		System.out.println("NO MINIMUM ORDER DISPLAY IS NOT SHOWING");
		
		
	}
	}


		
	

	

	
	
	
	

