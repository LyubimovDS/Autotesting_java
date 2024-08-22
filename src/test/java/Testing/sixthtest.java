package Testing;


import org.junit.jupiter.api.Test;
import java.util.List;
import static com.codeborne.selenide.Selenide.*;


class sixthtest {

    public List<String> createMainList(){
        String action = "#addNewRecordButton";
        return List.of(action, "Имя", "Фамилия", "some@mail.ru","18","1000","Some department");
    }
    public List<String> createReplacementList(){
        //String action = "\"[role='rowgroup']\").findBy(text(createMainList.get(1))).$(\"[title=\"Edit\"]";
        return List.of("#edit-record-4", "Другое Имя", "Другая Фамилия", "Other@mail.ru","20","2000","Other department");
    }


    @Test
    public void workingWithWindow() {

        open("https://demoqa.com/webtables");

        methods.createCharacter(createMainList());
        methods.createCharacter(createReplacementList());

        $("#delete-record-4").click();
    }
}