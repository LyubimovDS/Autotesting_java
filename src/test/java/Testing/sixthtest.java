package Testing;


import org.junit.jupiter.api.Test;

import java.util.HashMap;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Selenide.*;


class sixthTest {

    @Test
    public void workingWithWindow() {

        open("https://demoqa.com/webtables");

        HashMap <String, String> mainMap = data.createMap(
                "Имя",
                "Фамилия",
                "soma@mail.ru",
                "18",
                "1000",
                "Some Department");
        HashMap <String, String> replasmentMap = data.createMap(
                "Другое Имя",
                "Другая Фамилия",
                "Other@mail.ru",
                "20",
                "2000",
                "Other Department");

        $("#addNewRecordButton").click();
        methods.createCharacter(mainMap);
        methods.checkCharacter(mainMap);

        abbreviation.path(mainMap).$("[title='Edit']").click();
        methods.createCharacter(replasmentMap);
        methods.checkCharacter(replasmentMap);

        abbreviation.path(replasmentMap).$("[title='Delete']").click();
        abbreviation.path(replasmentMap).shouldNotBe(exist);
    }
}