package steps;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

public class MainSearch {

  SelenideElement searchInput = Selenide.$("input.header-search__input[inputmode]");
  @Given("Книга {string} найдена через поиск на главной странице")
  @When("Вводим в строку поиска название интересующего товара: {string} и нажимаем Enter")
  public void searchProduct(String productName) {
    Selenide.clearBrowserCookies();
    Selenide.clearBrowserLocalStorage();
    searchInput.clear();
    searchInput.setValue(productName).pressEnter();
  }


}
