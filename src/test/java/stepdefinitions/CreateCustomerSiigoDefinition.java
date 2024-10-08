package stepdefinitions;

import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import models.DataCustomer;
import models.DataLogin;
import net.serenitybdd.screenplay.GivenWhenThen;
import net.serenitybdd.screenplay.actions.Open;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import questions.Validate;
import tasks.EnterCustomer;
import tasks.FillOutCustomer;
import tasks.LoginWith;

import static utils.Constants.URLBASE;
import static utils.Constants.ZERO;

public class CreateCustomerSiigoDefinition {

    @Before
    public void onStage() {
        OnStage.setTheStage(new OnlineCast());
    }

    @Given("that user starts the siigo website")
    public void thatUserStartsTheSiigoWebsite() {
        OnStage.theActorCalled("Kevin").wasAbleTo(Open.url(URLBASE));
    }

    @When("user logs with the following credentials")
    public void userLogsWithTheFollowingCredentials(io.cucumber.datatable.DataTable data) {
        OnStage.theActorInTheSpotlight().attemptsTo(LoginWith.thedata(DataLogin.setData(data).get(ZERO)));
    }

    @When("user enters the form")
    public void userEntersTheForm() {
        OnStage.theActorInTheSpotlight().attemptsTo(EnterCustomer.form());
    }

    @When("user fill out form with the following data")
    public void userFillOutFormWithTheFollowingData(io.cucumber.datatable.DataTable data) {
        OnStage.theActorInTheSpotlight().attemptsTo(FillOutCustomer.form(DataCustomer.setData(data).get(ZERO)));
    }

    @Then("Validate customer create with text {string}")
    public void validateCustomerCreateWithText(String validateText) {
        OnStage.theActorInTheSpotlight().should(GivenWhenThen.seeThat(Validate.customer(validateText)));
    }
}


