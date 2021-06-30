import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class CallbackTest {
    @Test
    void shouldSumbitRequest(){
        open("http://http://localhost:9999");
        SelenideElement form = $(".form");
        form.$("[data-test-id=name]").setValue("Александр Иванков");
        form.$("[data-test-id=phone]").setValue("+78685454954");
        form.$("[data-test-id=agreement]").click();
        form.$("[role=button]").click();
        $(".allert-succes").shouldHave(exactText("Ваша заявка успешно отправлена! Наш менеджер свяжется с вами в ближайшее время."));

    }
}
