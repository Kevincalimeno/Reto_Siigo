package questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.waits.WaitUntil;
import userinterfaces.CustomerFormPage;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class Validate implements Question<Boolean> {

    public final String validateText;


    public Validate(String validateText) {
        this.validateText = validateText;
    }

    public static Validate customer(String questionV) {
        return new Validate(questionV);
    }

    @Override
    public Boolean answeredBy(Actor actor) {
        actor.attemptsTo(WaitUntil.the(CustomerFormPage.LABEL_VALIDATE, isVisible()).forNoMoreThan(15).seconds());

        String textoPagina = CustomerFormPage.LABEL_VALIDATE.resolveFor(actor).getText();
        System.out.println("PAGINA: " + textoPagina);
        System.out.println("PAGINA: " + validateText);
        return textoPagina.equals(validateText);
    }
}
