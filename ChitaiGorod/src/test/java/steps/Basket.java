package steps;

import com.codeborne.selenide.*;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

import static com.codeborne.selenide.Condition.visible;

public class Basket {
  ElementsCollection cartItems = Selenide.$$(".cart-item");
  SelenideElement counterProductsOfBasket = Selenide.$(".badge-notice");
  private String locatorProductTitle = ".product-title__head";
  private String locatorProductPrice = ".product-price__value";

  @Then("Проверяем, что в корзине один товар")
  public void checkNumberItemsOrder() {
    cartItems.shouldHave(CollectionCondition.size(1));
  }

  @And("Проверяем, что у иконки корзины в шапке страницы цифра соответствует количеству товара в корзине")
  public void checkCounterProductsOfBasket() {
    counterProductsOfBasket.shouldBe(visible).shouldHave(Condition.text("1"));
  }

  @And("Проверяем, что название товара в корзине соответствует выбранному в поиске товару")
  public void checkProductTitle() {
    cartItems.get(0).$(locatorProductTitle).shouldHave(Condition.exactTextCaseSensitive(Variables.productName));
  }

  @And("Проверяем, что цена товара в корзине соответствует выбранному в поиске товару")
  public void checkProductPrice() {
    cartItems.get(0).$(locatorProductPrice).shouldHave(Condition.exactTextCaseSensitive(Variables.productPrice));

  }
}
