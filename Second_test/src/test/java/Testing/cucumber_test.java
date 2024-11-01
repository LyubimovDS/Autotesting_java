package Testing;



import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class cucumber_test {

    public SelenideElement getPathTask(String nameTask ){
        return $(byText(nameTask));
    }
    public void openSite() {
        open("https://webdriveruniversity.com/To-Do-List/index.html");}

    public void printNameTask(String nameTask){
        $("input").val(nameTask).pressEnter();}

    public void checkTask(String nameTask){
        getPathTask(nameTask).shouldBe(exist);}

    public void markCompleted (String nameTask){
        getPathTask(nameTask).click();}

    public void checkCompletedTask (String nameTask){
        getPathTask(nameTask).shouldHave(attribute("class","completed"));}

    public void deleteCompletedTask(String nameTask){
        getPathTask(nameTask).$("span").hover().click();}

    public void checkAfterDeleted(String nameTask){
        getPathTask(nameTask).should(disappear);}
}
