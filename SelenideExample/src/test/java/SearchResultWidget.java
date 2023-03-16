import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

public class SearchResultWidget {

  ElementsCollection products = Selenide.$$("[data-chg-product-id]");
//  SelenideElement itemTitle = Selenide.$("product-title__head");


  public SelenideElement getElement(int number) {
    return products.get(number);
  }

  public String getItemName(int number) {
    return products.get(number).getOwnText();
  }

  public void goToProductItem(int number) {
    products.get(number).click();
  }

}
