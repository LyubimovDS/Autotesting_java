package Testing;

import com.codeborne.selenide.ElementsCollection;

import java.util.List;


import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static org.junit.jupiter.api.Assertions.assertEquals;


public class methods {
    public static void createCharacter(List<String> list){

        $(list.get(0)).click();
        $("#firstName").val(list.get(1));
        $("#lastName").val(list.get(2));
        $("#userEmail").val(list.get(3));
        $("#age").val(list.get(4));
        $("#salary").val(list.get(5));
        $("#department").val(list.get(6));
        $("#submit").click();

        //checkCharacter(list);
    }

    public static void checkCharacter(List<String> list){
        ElementsCollection item = $$("[role='row']").findBy(text(list.get(1))).$$("[role='gridcell']");
        String temp = list.get(3);
        list.set(3, list.get(4));
        list.set(4, temp);

        for (int i = 1; i < list.size(); i++) {
            assertEquals(list.get(i), item.get(i-1).getText());
            System.out.println(list.get(i) + " = " + item.get(i-1).getText());
        }
    }
}
