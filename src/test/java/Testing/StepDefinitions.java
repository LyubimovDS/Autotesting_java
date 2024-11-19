package Testing;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class StepDefinitions {
    fifthTest test = new fifthTest();

    @Given("Открыть страницу")
    public void openSite(){test.openSite();}

    @Given("Таблица с персоналом")
    public void CheckTable(){test.CheckTable();}

    @And("Добавить персону")
    public void addPerson(DataTable tableAddPerson){test.addPerson(tableAddPerson);}

    @Then("В таблице должен быть персонал")
    public void checkPersons(DataTable tablePersons){test.checkPersons(tablePersons);}


}
