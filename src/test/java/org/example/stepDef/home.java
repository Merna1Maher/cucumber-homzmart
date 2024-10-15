package org.example.stepDef;

import com.github.javafaker.Faker;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.Pages.homePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;

import java.time.Duration;

public class home {
    homePage home = new homePage();
    Actions action;
    SoftAssert soft = new SoftAssert();
    Faker fake = new Faker();
    WebDriverWait wait ;


    @Given("User will be in Homezmart homepage")
    public void userWillBeInHomezmartHomepage() {
    }

    @When("User hover on Storage")
    public void userHoverOnStorage(){
        action=new Actions(Hooks.driver);
        action.moveToElement(home.storage).perform();

    }

   @Then("User can see the Kitchen Storage subcategory in the dropdown menu")
    public void userCanSeeTheKitchenStorageSubcategoryInTheDropdownMenu() throws InterruptedException {
        soft.assertTrue(home.dropDownMenu.isDisplayed(),"dropDown Menu is not displayed");
         Thread.sleep(1500);
       soft.assertTrue(home.kitchenStorage.getText().toLowerCase().contains("kitchen storage"),"kitchen storage is not including menu");
        soft.assertAll();
    }

    @When("User click on Kitchen Storage")
    public void userClickOnKitchenStorage() throws InterruptedException {
        wait=new WebDriverWait(Hooks.driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class=\"brz-popup2__close\"]")));
        home.popUpClose.click();
        Thread.sleep(2000);
        action=new Actions(Hooks.driver);
        action.moveToElement(home.storage).perform();
        home.kitchenStorage.click();
        action.moveToElement(home.homeLogo).perform();
    }

    @And("add two random products to the cart")
    public void addTwoRandomProductsToTheCart() throws InterruptedException {
        Thread.sleep(2500);
        home.randomProduct1.click();
        wait=new WebDriverWait(Hooks.driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(home.addToCartButton));
        home.addToCartButton.click();
        Hooks.driver.navigate().back();
        Thread.sleep(2000);
        home.randomProduct2.click();
        wait=new WebDriverWait(Hooks.driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(home.addToCartButton));
        home.addToCartButton.click();
        Hooks.driver.navigate().back();
        }

    @And("open the cart preview")
    public void openTheCartPreview() throws InterruptedException {
        Thread.sleep(2000);
        home.cartPreview.click();
        Thread.sleep(1500);
    }

    @Then("User can see all added products in the cart")
    public void userCanSeeAllAddedProductsInTheCart() {
        home.goToCart.click();
        wait=new WebDriverWait(Hooks.driver, Duration.ofSeconds(10));
        WebElement elements = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class=\"Cart_CartCard__container__TyOoP\"]")));

    }

    @When("User verify that the product names and prices match the details of the selected products")
    public void userVerifyThatTheProductNamesAndPricesMatchTheDetailsOfTheSelectedProducts() throws InterruptedException {
        Hooks.driver.navigate().back();
        Thread.sleep(2000);
        String Name1 = home.productName1Out.getText().toLowerCase();
        String Name2 = home.productName2Out.getText().toLowerCase();
        String Price1 = home.productPrice1Out.getText().toUpperCase();
        String Price2 = home.productPrice2Out.getText().toUpperCase();
        home.cartPreview.click();
        home.goToCart.click();
        soft.assertEquals(Name1,home.productName1In.getText().toLowerCase(),"the name is wrong");
        soft.assertEquals(Name2,home.productName2In.getText().toLowerCase(),"the name is not True");
        soft.assertEquals(Price1,home.productPrice1In.getText().toUpperCase(),"Price is Wrong");
        soft.assertEquals(Price2,home.productPrice2In.getText().toUpperCase(),"Price is not True");
        soft.assertAll();

    }

    @Then("User can find that the total price in the cart is calculated correctly")
    public void userCanFindThatTheTotalPriceInTheCartIsCalculatedCorrectly() {
        String productPrice1Text = home.productPrice1In.getText().trim();
        String productPrice2Text =home.productPrice2In.getText().trim();
        String totalPriceText = home.TotalPrice.getText().trim();

        // Convert to double
        double productPrice1 = Double.parseDouble(productPrice1Text.replace(",", ""));
        double productPrice2 = Double.parseDouble(productPrice2Text.replace(",", ""));
        double TotalPrice = Double.parseDouble(totalPriceText.replace(",", ""));

        // Calculate expected total price
        double expectedTotalPrice = productPrice1 + productPrice2;
        soft.assertEquals(TotalPrice,expectedTotalPrice,"they are not equal");
        soft.assertAll();
        }


}

