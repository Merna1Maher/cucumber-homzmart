package org.example.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.example.stepDef.Hooks;

public class homePage {

    public homePage() {
            PageFactory.initElements(Hooks.driver,this);
    }
    @FindBy(xpath = "//div[@id=\"HEADER_MAIN_LOGO\"]")
    public WebElement homeLogo;

    @FindBy(xpath = "//div[@class=\"siteMenu__container\"]//a[@href=\"/en/c/storage\"]")
    public WebElement storage;
    @FindBy(xpath = "//div[@class=\"siteMenu__linksContainer\"]")
    public WebElement dropDownMenu;
    @FindBy(xpath = "//div[@data-v-e10e4622]/a[@href=\"/en/c/storage/kitchen-storage\"]")
    public WebElement kitchenStorage;
    final public By kitchenProducts= By.xpath("//div[@class=\"listing__card\"]//div[@class=\"productCard__container card-item\"]");

    @FindBy(xpath = "//div[@class=\"listing__card\"]//div[@class=\"productCard__container card-item\"][1]")
    public WebElement randomProduct1;

    @FindBy(xpath = "//div[@class=\"listing__card\"]//div[@class=\"productCard__container card-item\"][2]")
    public WebElement randomProduct2;
    @FindBy(xpath = "//button[@class=\"button-with-icon default-bg fullWidth\"]")
    public WebElement addToCartButton;

    @FindBy(xpath = "//div[@class=\"cart__container\"]")
    public WebElement cartPreview;
    @FindBy(xpath = "//div[@id=\"HEADER_CART_BRIEF_GO_TO_CART_BUTTON\"]")
    public WebElement goToCart;

    @FindBy(xpath = "//div[@class=\"listing__card\"]//div[@class=\"productCard__container card-item\"][1]//h3")
    public WebElement productName1Out;

    @FindBy(xpath = "//div[@class=\"listing__card\"]//div[@class=\"productCard__container card-item\"][2]//h3")
    public WebElement productName2Out;

    @FindBy(xpath = "//div[@class=\"productCard__container card-item\"][1]//div[@class=\"productPrices__specialPrice\"]//p")
    public WebElement productPrice1Out;

    @FindBy(xpath = "//div[@class=\"productCard__container card-item\"][2]//div[@class=\"productPrices__specialPrice\"]//p")
    public WebElement productPrice2Out;


    @FindBy(xpath = "//a[@href=\"/en/p/uv-full-kitchen-beige-120-70-35-cm--AMA.KIT.0160\"]/p")
    public WebElement productName2In;

    @FindBy(xpath = "//a[@href=\"/en/p/steel-and-mdf-wood-kitchen-storage-unit-black-and-brown-160-35-65-cm--S.F.STEE-14\"]/p")
    public WebElement productName1In;

    @FindBy(xpath = "//*[@id=\"__next\"]/div/main/div/div/div[1]/div[2]/div/div[2]/div/div/div[1]/div/div[2]/div/p")
    public WebElement productPrice1In;

    @FindBy(xpath = "/html/body/div[2]/div/main/div/div/div[1]/div[2]/div/div[1]/div/div/div[1]/div/div[2]/div/p")
    public WebElement productPrice2In;

    @FindBy(xpath = "//div[@class=\"base-summary_summary__total__UZMgQ\"]//div[@class=\"base-product-price_number__hr3nF\"]/p")
    public WebElement TotalPrice;

    @FindBy(xpath = "//div[@class=\"brz-popup2__close\"]")
    public WebElement popUpClose;
    @FindBy(xpath = "//div[@data-v-d797e979]//div[@class=\"bootstrap-wrapper hz-contain listing\"]")
    public WebElement spaceForHover;
}

