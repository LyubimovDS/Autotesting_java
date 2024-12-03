package Testing;


import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;


public class StepDefinitions {

    Auto_Test test = new Auto_Test();

    @Given("Добавить петомца с кличкой {string}")
    public void addPet(String petName){test.addPet(petName);}

    @Then("Проверить, что петомец с кличкой {string} есть в базе")
    public void checkPet(String petName){test.checkPet(petName);}
}