package tests.UI.tests;

import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import tests.TestBase;
import tests.UI.steps.MainPageSteps;

@Tag("ui")
@Owner("OIzibekova")
@Feature("Главная страница")
public class MainPageTests extends TestBase {

    public final static String BASE_URL = "https://www.cian.ru/";

    MainPageSteps steps = new MainPageSteps();


    @Test
    @DisplayName("Проверка заголовка")
    public void checkSuccessfulOpenPage(){
        steps.openPage(BASE_URL)
                .checkTitle();
    }


    @Test
    @DisplayName("Проверка разделов")
    public void checkTopBarMenuItems(){
        steps.openPage(BASE_URL)
                .topBarItems();
    }


    @Test
    @DisplayName("Проверка вкладок")
    public void checkMenuItems(){
        steps.openPage(BASE_URL)
                .checkMenuItems();
    }

}

