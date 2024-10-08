package tasks;

import models.DataLogin;
import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.waits.WaitUntil;
import userinterfaces.HomePage;


import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class LoginWith implements Task {

    private DataLogin dataLogin;

    public LoginWith(DataLogin dataLogin) {
        this.dataLogin = dataLogin;
    }

    public static LoginWith thedata(DataLogin dataLogin) {
        return Instrumented.instanceOf(LoginWith.class).withProperties(dataLogin);
    }


    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                WaitUntil.the(HomePage.TXT_USER, isVisible()).forNoMoreThan(10).seconds(),
                Enter.theValue(dataLogin.getUser()).into(HomePage.TXT_USER),
                Enter.theValue(dataLogin.getPass()).into(HomePage.TXT_PASS),
                Click.on(HomePage.BTN_LOGIN)
        );
    }
}
