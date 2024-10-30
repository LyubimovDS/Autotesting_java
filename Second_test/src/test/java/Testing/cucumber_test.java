package Testing;



import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

public class cucumber_test {

    String url = "https://webdriveruniversity.com/To-Do-List/index.html";
    String nameTask = "Сделать что-то";
    SelenideElement pathTask = $x("//li[text()=" + nameTask + "]");

    public void openSite() {
        open(url);}

    public void printNameTask(){
        $("input").val(nameTask).pressEnter();}

    public void checkTask(){
        pathTask.shouldBe(exist);}

    public void markCompleted (){
        pathTask.click();}

    public void checkCompletedTask (){
        pathTask.shouldHave(attribute("class","completed"));}

    public void deleteCompletedTask(){
        $x("//li[text()=" + nameTask +"]//span").hover().click();}

    public void checkAfterDeleted(){
        pathTask.should(disappear);}
}
