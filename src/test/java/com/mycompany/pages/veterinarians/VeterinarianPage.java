package com.mycompany.pages.veterinarians;

import net.serenitybdd.annotations.Step;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.By;

import java.util.List;

public class VeterinarianPage extends PageObject {

    @FindBy(xpath = "/html/body/nav/div/div/ul/li[3]/a")
    WebElementFacade veterinarianMenuLink;

    @FindBy(id = "veterinarians")
    WebElementFacade veterinariansTitle;

    @FindBy(id = "vetsTable")
    WebElementFacade veterinariansTable;

    @Step("Click on the owner menu link")
    public void clickOnVeterinariansMenuLink() {
        veterinarianMenuLink.waitUntilClickable().click();
    }

    @Step("Get veterinarians header text")
    public String getVeterinariansHeaderText() {
        return veterinariansTitle.waitUntilVisible().getText();
    }

    @Step("Get name veterinarian")
    public String getNameVeterinarian(String position) {
        List<WebElementFacade> rows = veterinariansTable.find(By.xpath("./tbody")).thenFindAll(By.xpath("./tr"));
        WebElementFacade row = rows.get(Integer.parseInt(position));
        return row.findElement(By.cssSelector("td")).getText();
    }

    @Step("Get speciality veterinarian")
    public String getSpeciality(String position) {
        List<WebElementFacade> rows = veterinariansTable.find(By.xpath("./tbody")).thenFindAll(By.xpath("./tr"));
        WebElementFacade row = rows.get(Integer.parseInt(position));
        List<WebElementFacade> data = row.thenFindAll(By.xpath("./td"));
        WebElementFacade speciality = data.get(data.size()-1);
        return speciality.getText();
    }
}
