package Testing;


import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;


public class StepDefinitions {

    cucumber_test test = new cucumber_test();

    @Given("открыть страницу")
    public void openSite(){test.openSite();}

    @And("ввести имя задачи {string} и сохранить задачу")
    public void printNameTask(String nameTask){test.printNameTask(nameTask);}

    @Then("проверить наличие созданной задачи {string}")
    public void checkTask(String nameTask){test.checkTask(nameTask);}


    @And("отметить задачу {string} выполненной")
    public void markCompleted(String nameTask){test.markCompleted(nameTask);}

    @Then("проверить наличие выполненной задачи {string}")
    public void checkCompletedTask(String nameTask){test.checkCompletedTask(nameTask);}


    @And("удалить задачу {string}")
    public void deleteCompletedTask(String nameTask){test.deleteCompletedTask(nameTask);}

    @Then("проверить, что выполненной задачи {string} нет")
    public void checkAfterDeleted(String nameTask){test.checkAfterDeleted(nameTask);}
}