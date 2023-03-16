import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.logevents.SelenideLogger;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.Map;

import static com.codeborne.selenide.Condition.*;

public class ChitaiGorodTest {

//  @BeforeAll
//  static void init() {
//    SelenideLogger.addListener("allure", n);
//    Configuration.remote = "http://85.119.145.3:4444/wd/hub";
//    Configuration.browser = "firefox";
//    Configuration.browserVersion = "93.0";

//    var caps = new DesiredCapabilities();
//    var options = Map.<String, Object>of("enableVNC", true, "enableVideo", true);
//    caps.setCapability("selenoid:options", options);
//    Configuration.browserCapabilities = caps;
//  }

  private final String MAIN_PAGE_URL = "https://www.chitai-gorod.ru/";


  @Test
  public void buyBook() {
    String productName =  "Незнайка в солнечном городе";
    int numberCard = 1;
    String itemName;

    // Переход на страницу магазина
    Selenide.open(MAIN_PAGE_URL);

    // Вводим в строку поиска название товара
    new MainSearch().searchProduct(productName);

    // Проверяем, что первый товар в результатах поиска в названии содержит текст запроса
    new SearchResultWidget().getElement(numberCard).shouldHave(text(productName));

    // Переходим в карточку первого товара (предварительно сохраняем название корточки в поиске)
    itemName = new SearchResultWidget().getItemName(numberCard);
    new SearchResultWidget().goToProductItem(numberCard);

    // Проверяем, что название карточки товара соответствует названию карточки из результатов поиска
    new ProductCard().cardTitle.shouldHave(text(itemName));

    // Добавляем в корзину (жмём кнопку "Купить")
    new ProductCard().buttonBuy.shouldHave(text("Купить")).click();

    // Проверяем, что
    // 1. Кнопка "Купить" сменилась на "Оформить заказ"
    new ProductCard().buttonBuy.shouldHave(text("Оформить заказ"));

    // 2. У иконки корзины появилась цифра с соответствующим количеством товара
    new ProductCard().counterProductsOfBasket.should(visible).shouldHave(text("1"));

    // Переходим в корзину по кнопке "Оформить заказ"
    new ProductCard().buttonBuy.click();

    // Проверяем, что в корзине 1 товар
    new Basket().cartItems.shouldHave(CollectionCondition.size(1));

    // Проверяем, что название товара в корзине соответствует названию выбранного товара.
    new Basket().cartItems.get(0).$(".product-title__head").shouldHave(text(itemName));

    // Перейти к оформлению товара - нажать на кнопку "Перейти к оформлению"
    new Basket().orderButton.click();

    // Проверить, что появилось всплывающее окно "Вход и регистрация"
    new RegistrationAndAuthorization().registrationTooltipTitle.shouldHave(text("Вход и регистрация"));

    // Проверить, что кнопка "Получить смс-код" недоступна
    new RegistrationAndAuthorization().buttonGetSms.shouldHave(cssClass("disabled"));

    // Добавить номер телефона, проверить, что кнопка "Получить смс-код" стала доступной
    new RegistrationAndAuthorization().phoneField.append("111111111");
    new RegistrationAndAuthorization().buttonGetSms.shouldNotHave(cssClass("disabled"));
  }
}
