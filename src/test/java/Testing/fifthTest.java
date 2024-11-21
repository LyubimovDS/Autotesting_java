package Testing;

import com.codeborne.selenide.ElementsCollection;
import io.cucumber.datatable.DataTable;

import java.util.List;
import java.util.Map;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;
import  org.assertj.core.api.SoftAssertions;


public class fifthTest {


    public void openSite() {
        open("https://demoqa.com/webtables");
    }


    public void CheckTable() {
        $("[class='web-tables-wrapper']").shouldBe(exist);
    }

    public void addPerson(DataTable tablePerson){
        $("#addNewRecordButton").click();
        addData(tablePerson);
    }

    public void checkPerson(String email){
        $$("[role='gridcell']").find(text(email)).shouldBe(exist);
    }

    public void editPerson(String email, DataTable tablePerson){
        $$("[role='row']").find(text(email)).$("[title='Edit']").click();
        addData(tablePerson);
    }

    public void addData(DataTable tablePerson){
        List<Map<String,String>> person = tablePerson.asMaps(String.class, String.class);
        for (Map<String, String> columns : person){
            $("#firstName").val(columns.get("First Name"));
            $("#lastName").val(columns.get("Last Name"));
            $("#userEmail").val(columns.get("Email"));
            $("#age").val(columns.get("Age"));
            $("#salary").val(columns.get("Salary"));
            $("#department").val(columns.get("Department"));
            $("#submit").click();
        }
    }

    public void deletePerson(String email){
        $$("[role='row']").find(text(email)).$("[title='Delete']").click();
    }

    public void checkTablePersons(DataTable table) {
        List<Map<String,String>> tablePersons = table.asMaps(String.class, String.class);

        for (Map<String, String> row : tablePersons) {

            String key = row.get("Email");
            ElementsCollection character = $$("[role='row']").find(text(key)).$$("[role='gridcell']");

            SoftAssertions softAssert = new SoftAssertions();

            softAssert.assertThat(row.get("First Name"))
                    .as(String.format("Проверка имени. Ожидаемое имя \"%s\", фактическое \"%s\"", row.get("First Name"),character.get(0).getText()))
                    .isEqualTo(character.get(0).getText());
            softAssert.assertThat(row.get("Last Name"))
                    .as(String.format("Проверка фамилии. Ожидаемая фамилия \"%s\", фактическая \"%s\"", row.get("Last Name"),character.get(1).getText()))
                    .isEqualTo(character.get(1).getText());
            softAssert.assertThat(row.get("Email"))
                    .as(String.format("Проверка почты. Ожидаемая почта \"%s\", фактическая \"%s\"", row.get("Email"),character.get(3).getText()))
                    .isEqualTo(character.get(3).getText());
            softAssert.assertThat(row.get("Age"))
                    .as(String.format("Проверка возроста. Ожидаемый возраст \"%s\", фактический \"%s\"", row.get("Age"),character.get(2).getText()))
                    .isEqualTo(character.get(2).getText());
            softAssert.assertThat(row.get("Salary"))
                    .as(String.format("Проверка зарплаты. Ожидаемая зарплата \"%s\", фактическая \"%s\"", row.get("Salary"),character.get(4).getText()))
                    .isEqualTo(character.get(4).getText());
            softAssert.assertThat(row.get("Department"))
                    .as(String.format("Проверка департамента. Ожидаемый департамент \"%s\", фактический \"%s\"", row.get("Department"),character.get(5).getText()))
                    .isEqualTo(character.get(5).getText());

            softAssert.assertAll();
        }
    }
    public void checkDeletePerson(String email){
        $$("[role='row']").find(text(email)).should(disappear);
        }
}