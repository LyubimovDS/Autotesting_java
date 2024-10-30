package Testing;


import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;


public class StepDefinitions {

    cucumber_test test = new cucumber_test();

    @Given("открыть страницу")
    public void openSite(){test.openSite();}

    @And("ввести имя задачи и сохранить задачу")
    public void printNameTask(){test.printNameTask();}

    @Then("проверить наличие созданной задачи")
    public void checkTask(){test.checkTask();}


    @And("отметить задачу выполненной")
    public void markCompleted(){test.markCompleted();}

    @Then("проверить наличие выполненной задачи")
    public void checkCompletedTask(){test.checkCompletedTask();}


    @And("удалить выполненную задачу")
    public void deleteCompletedTask(){test.deleteCompletedTask();}

    @Then("проверить, что выполненной задачи нет")
    public void checkAfterDeleted(){test.checkAfterDeleted();}
}