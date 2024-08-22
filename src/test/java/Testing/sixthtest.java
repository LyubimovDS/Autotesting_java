package Testing;


import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;


class sixthtest {

    @Test
    public void workingWithWindow() {

        open("https://demoqa.com/webtables");

        $("#addNewRecordButton").click();
        methods.createCharacter(data.createMap(
                "Имя",
                "Фамилия",
                "soma@mail.ru",
                "18",
                "1000",
                "Some Department"));
        $$("[role='row']").findBy(text("Имя")).$("[title='Edit']").click();
        methods.createCharacter(data.createMap(
                "Другое Имя",
                "Другая Фамилия",
                "Other@mail.ru",
                "20",
                "2000",
                "Other Department"));
        $$("[role='row']").findBy(text("Другое Имя")).$("[title='Delete']").click();
    }
}