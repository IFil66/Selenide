import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

import java.util.Collections;

public class Basket {

  ElementsCollection cartItems = Selenide.$$(".cart-item");
  SelenideElement orderButton = Selenide.$("div.order-button");

}
