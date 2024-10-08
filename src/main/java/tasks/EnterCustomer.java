package tasks;

import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.waits.WaitUntil;
import userinterfaces.MainPage;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class EnterCustomer implements Task {


    public static EnterCustomer form() {
        return Tasks.instrumented(EnterCustomer.class);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        try {
            Thread.sleep(7000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        actor.attemptsTo(
                WaitUntil.the(MainPage.BTN_CREATE,isVisible()).forNoMoreThan(20).seconds(),
                Click.on(MainPage.BTN_CREATE),
                WaitUntil.the(MainPage.BTN_CLIENTS,isVisible()).forNoMoreThan(20).seconds(),
                Click.on(MainPage.BTN_CLIENTS)
        );
    }
}
