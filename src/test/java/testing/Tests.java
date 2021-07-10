package testing;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.apache.commons.io.filefilter.TrueFileFilter;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static testing.TestHelper.testConfig;

public class Tests {

    @Test
    @Disabled
    public void test(){

        Configuration.startMaximized = true;
        if (!testConfig.testRemoteDriverUrl().equals("")) {
            Configuration.remote = "https://user1:1234@selenoid.autotests.cloud/wd/hub/";
            boolean b = !testConfig.testRemoteDriverUrl().equals("");
            System.out.println(b);
        }
        open("https://m2.ru");
        $("[data-gtm='main-show-search-link-banner-samolet'] > p[class='home-promo2-block-module--title--21mDL markdown-module--h1--2sIse markdown-module--white-variant--3JkiE']")
                .shouldHave(Condition.text("Отвечаем за каждый квадратный метр"));
        System.out.println(testConfig.testValue());
        System.out.println(testConfig.testRemoteDriverUrl());


    }
}
