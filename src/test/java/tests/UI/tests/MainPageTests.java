package tests.UI.tests;

import com.codeborne.selenide.Condition;
import org.junit.jupiter.api.Test;
import tests.TestBase;
import tests.UI.steps.MainPageSteps;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class MainPageTests extends TestBase {

    public final static String BASE_URL = "https://m2.ru";

    MainPageSteps steps = new MainPageSteps();

    @Test
    public void checkSuccessfulOpenPage(){
        steps.openPage(BASE_URL)
                .checkTitle();
    }

    @Test
    public void checkSuccessfulOpenPage2(){
        steps.openMainPage(BASE_URL);
        steps.checkText();
    }
}

