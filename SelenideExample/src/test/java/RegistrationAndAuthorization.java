import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

public class RegistrationAndAuthorization {
  SelenideElement registrationTooltipTitle = Selenide.$("h1.app-title--header-4");
  SelenideElement phoneField = Selenide.$("input[type='tel']");
  SelenideElement buttonGetSms = Selenide.$("button.app-button");
}
