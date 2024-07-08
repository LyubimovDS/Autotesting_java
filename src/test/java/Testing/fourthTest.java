package Testing;

import org.junit.jupiter.api.Test;


import static com.codeborne.selenide.Selenide.*;

class fourthTest {
    @Test
    public void workingWithAlerts() {
        open("https://webdriveruniversity.com/Popup-Alerts/index.html");


        methods useAlert = new methods();


        useAlert.closeAlert();


        useAlert.okAlert();

    }
}