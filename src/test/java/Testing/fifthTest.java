package Testing;


import com.codeborne.selenide.ElementsCollection;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.jupiter.api.Test;

import javax.swing.*;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class fifthTest {

   @Given("Открыть страницу")
    public void openSite(){open ("https://demoqa.com/webtables");}

    @Given("Таблица с персоналом")
    public void CheckTable(){$("[class='web-tables-wrapper']").shouldBe(exist);}

    @Then("В таблице должен быть персонал")
    public void checkPersons(DataTable table){
        List<List<String>> person = table.asLists(String.class);

        for (List<String> row : person){

            String key = row.get(0);
            ElementsCollection cell = $$("[role='row']").findBy(text(key)).$$("[role='gridcell']");
            int i = 0;
            for (String item: row){
                assertEquals(item, cell.get(i).getText());
                System.out.println(item + " = " + cell.get(i).getText());
                i++;
            }
        }
    }

   /* public void workingWithAlerts() {

        open("https://demoqa.com/books");

        for (Map.Entry<String, List<String>> item : createReferenceMap().entrySet()) {

            String key = item.getKey();                     // Получаем ключ
            String author = item.getValue().get(0);         // Получаем 1 значение листа
            String publisher = item.getValue().get(1);      // Получаем 2 значение листа

            ElementsCollection cell = $$("[role='row']").findBy(text(key)).$$("[role='gridcell']");

            assertEquals(author, cell.get(2).getText());
            assertEquals(publisher, cell.get(3).getText());

            System.out.println(author + " = " + cell.get(2).getText());
            System.out.println(publisher + " = " + cell.get(3).getText());

        }
    }*/
}