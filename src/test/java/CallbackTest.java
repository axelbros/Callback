import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class CallbackTest {
    @Test
    void shouldSubmitRequest() {
        open("http://localhost:7777");
        SelenideElement form = $(".form");
        form.$("[data-test-id=name] input").setValue("Иванов Иван");
        form.$("[data-test-id=phone] input").setValue("+79999999999");
        form.$("[data-test-id=agreement]").click();
        form.$(".button").click();
        $(".Success_successBlock__2L3Cw").shouldHave(exactText("Ваша заявка успешно отправлена! Наш менеджер свяжется с вами в ближайшее время."));
    }
}
