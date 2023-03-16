package steps;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import io.cucumber.java.en.Given;

public class MainPage {
  @Given("Открываем главную страницу магазина {string}")
  public void openWebSite(String url) {
    Configuration.timeout = 10000;
    Selenide.open(url);
    Selenide.clearBrowserCookies();
    Selenide.clearBrowserLocalStorage();

  }
}
