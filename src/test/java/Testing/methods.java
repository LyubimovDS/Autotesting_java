package Testing;

import org.openqa.selenium.Alert;


import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;
import static org.junit.jupiter.api.Assertions.assertEquals;


public class methods {
    public void closeAlert(){

        $("#button4").click();


        Alert alert = switchTo().alert();


        assertEquals("Press a button!", alert.getText());


        alert.dismiss();


        $("#confirm-alert-text").shouldHave(text("You pressed Cancel!"));


        sleep(1000);

    }

    public void okAlert(){

        $("#button4").click();


        Alert alert = switchTo().alert();


        assertEquals("Press a button!", alert.getText());


        alert.accept();


        $("#confirm-alert-text").shouldHave(text("You pressed OK!"));

    }

    }
