package tests.UI.tests;

import com.codeborne.selenide.Condition;
import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import tests.TestBase;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;

@Tag("ui")
@Owner("OIzibekova")
@Feature("Проверка авторизации")
public class AthorizationTest extends TestBase {

    @Test
    @DisplayName("Авторизация с валидными логином и паролем")
    public void enterValidCredentialsCian(){
        step("Открываем главную страницу", () -> {
            open("https://www.cian.ru/");
        });
        step("Нажимаем на кнопку 'Войти'", () -> {
            $("a[href=\"/authenticate/\"]").click();
        });

        step("Ввод авторизационные данные'", () -> {
            String s_tel = $("div[data-mark=\"Authentication\"] h3").getText();
            System.out.println(s_tel);

            if (s_tel.equals("Вход по телефону")){
                $("button[data-mark=\"SwitchToEmailAuth\"]").click();
            }
            $("input[name=\"username\"]").setValue("oksana.izibekova@mail.ru");
            $("button[data-mark=\"ContinueAuthBtn\"]").click();
            $("input[name=\"password\"]").setValue("Test1212");
            $("button[data-mark=\"ContinueAuthBtn\"]").click();
        });

        step("Проверяем наличие иконки сообщения", () -> {
            $("#header-chats-icon-new a[href=\"//cian.ru/dialogs/\"]").shouldBe(Condition.visible);
        });
    }

    @Test
    @DisplayName("Авторизация с невалидным паролем")
    public void enterInvalidCredentialsCian(){
        step("Открываем главную страницу", () -> {
            open("https://www.cian.ru/");
        });
        step("Нажимаем на кнопку 'Войти'", () -> {
            $("a[href=\"/authenticate/\"]").click();
        });

        step("Нажимаем на кнопку 'Войти'", () -> {
            String s_tel = $("div[data-mark=\"Authentication\"] h3").getText();
            System.out.println(s_tel);

            if (s_tel.equals("Вход по телефону")){
                $("button[data-mark=\"SwitchToEmailAuth\"]").click();
            }
            $("input[name=\"username\"]").setValue("oksana.izibekova@mail.ru");
            $("button[data-mark=\"ContinueAuthBtn\"]").click();
            $("input[name=\"password\"]").setValue("Test121");
            $(byText("Неверный логин или пароль")).shouldBe();
        });
    }
}
