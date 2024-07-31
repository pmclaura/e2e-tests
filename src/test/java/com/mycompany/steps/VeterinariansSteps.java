package com.mycompany.steps;

import com.mycompany.pages.veterinarians.VeterinarianPage;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.annotations.Steps;
import net.serenitybdd.core.Serenity;

import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertEquals;

public class VeterinariansSteps {

    @Steps
    VeterinarianPage veterinarianPage;

    @When("el cliente navega al menú encontrar veterinarios")
    public void elClienteNavegaAlMenúEncontrarVeterinarios() {
        veterinarianPage.clickOnVeterinariansMenuLink();
    }

    @Then("la página debe mostrar una lista de veterinarios válida")
    public void laPaginaDebeMostrarUnaListaDeVeterinariosValida() {
        String headerText = veterinarianPage.getVeterinariansHeaderText();
        assertEquals("Veterinarians", headerText);
    }

    @And("el cliente tiene los siguientes datos de los veterinarios:")
    public void elClienteTieneLosSiguientesDatosDeLosVeterinarios(DataTable dataTable) {
        List<Map<String, String>> data = dataTable.asMaps(String.class, String.class);
        for (Map<String, String> row : data) {
            for (Map.Entry<String, String> entry : row.entrySet()) {
                String header = entry.getKey();
                String cell = entry.getValue();
                Serenity.setSessionVariable(header).to(cell);
            }
        }
    }

    @Then("la página debe mostrar la información de los veterinarios")
    public void laPaginaDebeMostrarLaInformacionDeLosVeterinarios() {
        String name = Serenity.sessionVariableCalled("name");
        String specialty = Serenity.sessionVariableCalled("specialty");
        String position = Serenity.sessionVariableCalled("position");
        assertEquals(name, veterinarianPage.getNameVeterinarian(position));
        assertEquals(specialty, veterinarianPage.getSpeciality(position));
    }
}
