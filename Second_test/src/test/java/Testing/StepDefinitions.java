package Testing;


import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;


public class StepDefinitions {

    Auto_Test test = new Auto_Test();

    @Given("Добавить петомца с кличкой {string} и индификатором {int}" )
    public void addPet(String petName, int petId){test.addPet(petName, petId);}

    @Then("Проверить, что петомец с кличкой {string} и индификатором {int} есть в базе")
    public void getPet(String petName, int petId){test.getPet(petName, petId);}


    @Given("Создать 2 пользователя {string} и {string}")
    public void createUsers(String user1, String user2){test.createUsers(user1,user2);}

    @Then("Проверить, что пользователь {string} создан")
    public void checkUser(String User){test.checkUser(User);}
}