import com.codeborne.selenide.*;
import com.codeborne.selenide.SelenideElement;


public class MainSearch {

  SelenideElement searchInput = Selenide.$("input.header-search__input[inputmode]");

  public void searchProduct(String productName) {
    searchInput.setValue(productName).pressEnter();
  }
}
