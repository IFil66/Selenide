package steps;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import io.cucumber.java.en.And;



public class ProductCard {

  SelenideElement buttonBuy = Selenide.$("div[itemtype = 'https://schema.org/Offer'] div.action-button");


  @And("Добавляем товар в корзину \\(жмём кнопку {string})")
  public void addProductToBasket(String buttonName) {
    buttonBuy.click();
  }

}
