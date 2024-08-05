package Testing;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

class fifthTest {

    public HashMap<String, List<String>> createReferenceMap(){

        HashMap<String, List<String>> mainMap = new HashMap<>();

        mainMap.put("Git Pocket Guide", List.of("Richard E. Silverman", "O'Reilly Media"));
        mainMap.put("Learning JavaScript Design", List.of("Addy Osmani", "O'Reilly Media"));
        mainMap.put("Designing Evolvable Web APIs with ASP.NET", List.of("Glenn Block et al.", "O'Reilly Media"));
        mainMap.put("Speaking JavaScript", List.of("Axel Rauschmayer", "O'Reilly Media"));

        return mainMap;
    }


    @Test
    public void workingWithAlerts() {


        HashMap<String, List<String>> mainMap = createReferenceMap();

        open("https://demoqa.com/books");

        for (Map.Entry<String, List<String>> item : mainMap.entrySet()) {

            String key = item.getKey();                     // Получаем ключ
            String author = item.getValue().get(0);         // Получаем значение листа 1
            String publisher = item.getValue().get(1);      // Получаем значение листа 2
            ElementsCollection cell = $$("[role='row']").findBy(text(key)).$$("[role='gridcell']");

            assertEquals(author, cell.get(2).getText());
            assertEquals(publisher, cell.get(3).getText());

            System.out.println(author + " = " + cell.get(2).getText());
            System.out.println(publisher + " = " + cell.get(3).getText());

        }
    }
}