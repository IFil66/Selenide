package steps;

import com.codeborne.selenide.*;
import io.cucumber.java.en.And;


public class SearchResultWidget extends Variables {

  ElementsCollection products = Selenide.$$("[data-chg-product-id]");
  SelenideElement cart = Selenide.$(".header-cart");
  private String locatorOfProductItem = ".product-title__head";
  private String locatorProductPrice = ".product-price__value";

  @And("Переходим в {string} по счёту карточку товара из поисковой выдачи, кликнув на неё")
  public void goToProductItem(String numberCard) {
    // Сохранение названия и цены выбранного товара (необходимы для шага проверки)
    int number = Integer.parseInt(numberCard) -1;
    Variables.productPrice = products.get(number).$(locatorProductPrice).getOwnText();
    Variables.productName = products.get(number).$(locatorOfProductItem).getOwnText();
    // Непосредственно начинка метода goToProductItem
    products.get(number).click();
  }


  @And("Переходим в корзину - кликаем по иконке корзины \\(пакет)")
  public void goToBasket() {
    cart.click();
  }

}
