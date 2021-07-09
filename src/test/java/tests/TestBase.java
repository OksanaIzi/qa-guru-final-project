package tests;

import com.codeborne.selenide.Configuration;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;

import static com.codeborne.selenide.Selenide.closeWebDriver;
import static com.codeborne.selenide.logevents.SelenideLogger.addListener;
import static helpers.DriverHelper.configureDriver;

public class TestBase {

    @BeforeAll
    static void setUp(){
        configureDriver();
    }

    @AfterEach
    public void addAttachments(){
        closeWebDriver();
    }
}
