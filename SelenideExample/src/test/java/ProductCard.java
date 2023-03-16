import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

public class ProductCard {

  SelenideElement cardTitle = Selenide.$("h1");
  SelenideElement buttonBuy = Selenide.$("div[itemtype = 'https://schema.org/Offer'] div.action-button");
  SelenideElement counterProductsOfBasket = Selenide.$(".badge-notice");

}
