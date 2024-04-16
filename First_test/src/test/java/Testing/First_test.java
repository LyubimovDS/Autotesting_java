package Testing;

import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.*;

public class First_test {

    @Test
    public void Check_search(){
        open("https://www.google.com");

        $(byXpath("//textarea[@aria-label=\"Найти\"]")).append("Selenide").pressEnter();

        $("#search").shouldBe(exist);
    }
}
