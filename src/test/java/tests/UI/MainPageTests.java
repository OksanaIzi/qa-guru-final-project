package tests.UI;

import com.codeborne.selenide.Condition;
import org.junit.jupiter.api.Test;
import tests.TestBase;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class MainPageTests extends TestBase {

    @Test
    public void checkSussfullOpenPage(){
        open("https://m2.ru");
        $("[data-gtm='main-show-search-link-banner-samolet'] > p[class='home-promo2-block-module--title--21mDL markdown-module--h1--2sIse markdown-module--white-variant--3JkiE']")
                .shouldHave(Condition.text("Отвечаем за каждый квадратный метр"));
    }
}

