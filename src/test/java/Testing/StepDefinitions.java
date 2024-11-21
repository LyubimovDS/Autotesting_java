package Testing;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.ru.И;

public class StepDefinitions {
    fifthTest test = new fifthTest();

    @Given("Открыть страницу")
    public void openSite(){test.openSite();}

    @Given("Таблица с персоналом")
    public void CheckTable(){test.CheckTable();}

    @Given("Персона с почтой {string}")
    public void checkPerson(String email){test.checkPerson(email);}

    @And("Добавить персону")
    public void addPerson(DataTable tableAddPerson){test.addPerson(tableAddPerson);}

    @And("Изменить персону с почтой {string}")
    public void editPerson(String email, DataTable tableEditPerson){test.editPerson(email, tableEditPerson);}

    @And("Удалить персону с почтой {string}")
    public void deletePerson(String email){test.deletePerson(email);}

    @And("Не должно быть персоны с почтой {string}")
    public void checkDeletePerson(String email){test.checkDeletePerson(email);}

    @Then("В таблице должен быть персонал")
    public void checkTablePersons(DataTable tablePersons){test.checkTablePersons(tablePersons);}
}
