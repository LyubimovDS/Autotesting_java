package Testing;

import com.codeborne.selenide.ElementsCollection;
import io.cucumber.datatable.DataTable;

import java.util.List;
import java.util.Map;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class fifthTest {


    public void openSite() {
        open("https://demoqa.com/webtables");
    }


    public void CheckTable() {
        $("[class='web-tables-wrapper']").shouldBe(exist);
    }

    public void addPerson(DataTable tableAddPerson){
        List<Map<String,String>> person = tableAddPerson.asMaps(String.class, String.class);

        for (Map<String, String> columns : person){
            $("#addNewRecordButton").click();
            $("#firstName").val(columns.get("First Name"));
            $("#lastName").val(columns.get("Last Name"));
            $("#userEmail").val(columns.get("Email"));
            $("#age").val(columns.get("Age"));
            $("#salary").val(columns.get("Salary"));
            $("#department").val(columns.get("Department"));
            $("#submit").click();
        }
    }


    public void checkPersons(DataTable table) {
        List<Map<String,String>> tablePersons = table.asMaps(String.class, String.class);

        for (Map<String, String> row : tablePersons) {

            String key = row.get("Email");
            ElementsCollection character = $$("[role='row']").findBy(text(key)).$$("[role='gridcell']");


            System.out.println(row.get("First Name") + " = " + character.get(0).getText());
            System.out.println(row.get("Last Name") + " = " + character.get(1).getText());
            System.out.println(row.get("Email") + " = " + character.get(3).getText());
            System.out.println(row.get("Age") + " = " + character.get(2).getText());
            System.out.println(row.get("Salary") + " = " + character.get(4).getText());
            System.out.println(row.get("Department") + " = " + character.get(5).getText());

            assertEquals(row.get("First Name"), character.get(0).getText());
            assertEquals(row.get("Last Name"), character.get(1).getText());
            assertEquals(row.get("Email"), character.get(3).getText());
            assertEquals(row.get("Age"), character.get(2).getText());
            assertEquals(row.get("Salary"), character.get(4).getText());
            assertEquals(row.get("Department"), character.get(5).getText());
        }
    }
}