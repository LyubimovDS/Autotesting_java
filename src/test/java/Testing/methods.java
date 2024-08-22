package Testing;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.WebElement;

import java.util.HashMap;


import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static org.junit.jupiter.api.Assertions.assertEquals;

class abbreviation {
    public static SelenideElement path (HashMap<String,String> map){
        return $$("[role='row']").findBy(text(map.get("First Name")));
    }
}
class data {
    public static HashMap<String, String> createMap(String firstName,
                                                        String lastName,
                                                        String email,
                                                        String age,
                                                        String salary,
                                                        String department) {
        HashMap<String, String> map = new HashMap<>();

        map.put("First Name", firstName);
        map.put("Last Name", lastName);
        map.put("Email", email);
        map.put("Age", age);
        map.put("Salary", salary);
        map.put("Department", department);

        return map;
    }
}

public class methods {
    public static void createCharacter(HashMap<String, String> map){

        $("#firstName").val(map.get("First Name"));
        $("#lastName").val(map.get("Last Name"));
        $("#userEmail").val(map.get("Email"));
        $("#age").val(map.get("Age"));
        $("#salary").val(map.get("Salary"));
        $("#department").val(map.get("Department"));
        $("#submit").click();
    }

    public static void checkCharacter(HashMap<String, String> map){
        ElementsCollection character = $$("[role='row']").findBy(text(map.get("First Name"))).$$("[role='gridcell']");

        System.out.println(map.get("First Name") + " = " + character.get(0).getText());
        System.out.println(map.get("Last Name") + " = " + character.get(1).getText());
        System.out.println(map.get("Email") + " = " + character.get(3).getText());
        System.out.println(map.get("Age") + " = " + character.get(2).getText());
        System.out.println(map.get("Salary") + " = " + character.get(4).getText());
        System.out.println(map.get("Department") + " = " + character.get(5).getText());

        assertEquals(map.get("First Name"), character.get(0).getText());
        assertEquals(map.get("Last Name"), character.get(1).getText());
        assertEquals(map.get("Email"), character.get(3).getText());
        assertEquals(map.get("Age"), character.get(2).getText());
        assertEquals(map.get("Salary"), character.get(4).getText());
        assertEquals(map.get("Department"), character.get(5).getText());


        }


}
