package Testing;

import org.junit.jupiter.api.Test;


import java.util.HashMap;
import java.util.List;

import static com.codeborne.selenide.Selenide.*;

class Map {

    @org.jetbrains.annotations.NotNull
    public static HashMap<String, List<String>> createReferenceMap(){

        HashMap<String, List<String>> mainMap = new HashMap<>();

        mainMap.put("Git Pocket Guide", List.of("Richard E. Silverman", "O'Reilly Media"));
        mainMap.put("Learning JavaScript Design", List.of("Addy Osmani", "O'Reilly Media"));
        mainMap.put("Designing Evolvable Web APIs with ASP.NET", List.of("Addy Osmani", "O'Reilly Media"));
        mainMap.put("Speaking JavaScript", List.of("Axel Rauschmayer", "O'Reilly Media"));

        return mainMap;
    }


    @Test
    public void workingWithAlerts() {

        open("https://demoqa.com/books");

        Map map = new Map();

        for(map.mainMap.Entry<String, List<String>> item : map.mainMap.entrySet()){

            String key = entry.getKey();         // Получаем ключ
            Integer value = entry.getValue();    // Получаем значение


    }
}