package tests.UI.steps;

import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selectors.byTitle;
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
        $(byTitle("Циан - база недвижимости в Московской области | Продажа, аренда квартир и другой недвижимости")).shouldBe();
        return this;
    }

    @Step("Check top bar menu items")
    public MainPageSteps topBarItems(){
        $("a[data-ref=\"rent\"]").shouldHave(Condition.text("Аренда"));
        $("a[data-ref=\"sale\"]").shouldHave(Condition.text("Продажа"));
        $("a[data-ref=\"newbuildings\"]").shouldHave(Condition.text("Новостройки"));
        $("a[data-ref=\"commercial\"]").shouldHave(Condition.text("Коммерческая"));
        $("a[data-ref=\"calculator\"]").shouldHave(Condition.text("Оценка"));
        $("a[data-ref=\"mortgage\"]").shouldHave(Condition.text("Ипотека"));
        $("#header-sp-link-container a[data-name=\"SpecialPromoLink\"]").shouldBe();
        return this;
    }

    @Step("Check menu items")
    public MainPageSteps checkMenuItems() {
        $("a[href='/kupit/']").shouldBe(Condition.enabled);
        $("a[href='/snyat/']").shouldBe(Condition.enabled);
        $("a[href='/kalkulator-nedvizhimosti/']").shouldBe(Condition.enabled);
        $("a[href='/mortgage/']").shouldBe(Condition.enabled);
        $("a[href='/realtors/']").shouldBe(Condition.enabled);
        $("a[href='https://promo.cian.ru/sday-snimi-2/arenda']").shouldBe();
        return this;
    }
}
