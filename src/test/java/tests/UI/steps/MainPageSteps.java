package tests.UI.steps;

import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class MainPageSteps {

    @Step("Open page {url}")
    public MainPageSteps openPage(String url) {
        open(url);
        return this;
    }

    @Step("Check page title")
    public MainPageSteps checkTitle() {
        $("[data-gtm='main-show-search-link-banner-samolet'] > p[class='home-promo2-block-module--title--21mDL markdown-module--h1--2sIse markdown-module--white-variant--3JkiE']")
                .shouldHave(Condition.text("Отвечаем за каждый квадратный метр"));
        return this;
    }
}
