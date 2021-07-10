package tests.UI.tests;

import com.codeborne.selenide.Condition;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import tests.TestBase;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;

public class SearchTests extends TestBase {

    @Test
    @Disabled
    public void searchFlatTest(){
        step("Открываем главную страницу", () -> {
            open("https://www.cian.ru/");
        });
        step("Выбираем вкладку купить", () -> {
            $("a[href=\"/kupit/\"]").click();
            $(byText("Цена")).click();
            $("input[placeholder=\"от\"]").setValue("4000000");
            $("input[placeholder=\"до\"]").setValue("10000000");
            $("#geo-suggest-input").setValue("Ижевск");
            $("span[title=\"Ижевск\"]").click();
            $("a[data-mark=\"FiltersSearchButton\"]").click();
        });
        step("Нажимаем кнопку Найти", () -> {
            $(byText("Найти")).click();
        });
    }

    @Test
    @DisplayName("Оценка стоимости квартиры")
    public void calculateFlatTest(){
        step("Открываем главную страницу", () -> {
            open("https://www.cian.ru/");
        });
        step("Выбираем вкладку купить", () -> {
            $("a[href=\"/kalkulator-nedvizhimosti/\"]").click();
            $("#geo-suggest-input").setValue("Ижевск");
            $("span[title=\"Красногеройская улица, 107, Ижевск, Удмуртская Республика, Россия\"]").click();
            $(byText("Комнат *")).click();
            $(byText("2")).click();
            $("input[placeholder=\"Площадь *\"]").setValue("65");
            $("div[data-name=\"ValuationFiltersSubmit\"] button").click();
        });

        step("Проверяем наличие результата оценки квартиры", () -> {
            $("div[data-name=\"Title\"] h3").shouldHave(Condition.text("Рыночная стоимость квартиры"));
        });
    }

    @Test
    @DisplayName("Расчет ипотечного калькулятора")
    public void openMortgageCalculator(){
        step("Открываем главную страницу", () -> {
            open("https://www.cian.ru/");
        });
        step("Выбираем вкладку ипотка", () -> {
            $("a[href=\"/mortgage/\"]").click();

        });

        step("Проверяем отображение ипотечного калькулятора", () -> {
            $("#__bg h1").shouldHave(Condition.text("Ипотечный калькулятор"));
            $("#__bg p").shouldHave(Condition.text("С возможностью расчета досрочного погашения"));
        });
    }
}
