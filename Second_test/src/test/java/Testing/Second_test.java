package Testing;

import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.*;

public class Second_test {
    @Test
    public void check_creating_execution_and_deleting_task() {
        open("https://webdriveruniversity.com/To-Do-List/index.html");


        $("input").val("Сделать что-то").pressEnter();


        $x("//li[text()=\" Сделать что-то\"]").shouldBe(exist).click();


        $x("//li[@class=\"completed\"]").shouldBe(exist);


        $x("//li[text()=\" Сделать что-то\"]//span").hover().click();


        $x("//li[text()=\" Сделать что-то\"]").shouldNotBe();

        // $x("//li[text()=\" Сделать что-то\"]").should(disappear);  или так
    }
}
