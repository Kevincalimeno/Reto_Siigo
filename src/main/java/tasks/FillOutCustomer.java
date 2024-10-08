package tasks;

import interactions.SelectFromList;
import models.DataCustomer;
import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.JavaScriptClick;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static userinterfaces.CustomerFormPage.*;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class FillOutCustomer implements Task {

    private DataCustomer dataCustomer;

    public FillOutCustomer(DataCustomer dataCustomer) {
        this.dataCustomer = dataCustomer;
    }

    public static FillOutCustomer form(DataCustomer dataCustomer) {
        return Instrumented.instanceOf(FillOutCustomer.class).withProperties(dataCustomer);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                WaitUntil.the(SELECT_TYPE_PERSON, isVisible()).forNoMoreThan(10).seconds(),
                JavaScriptClick.on(SELECT_TYPE_PERSON),
                SelectFromList.on(UL_SELECT_TYPE_PERSON, dataCustomer.getSlttipo(), "span"),
                JavaScriptClick.on(SELECT_TYPE_IDENTIFICATION),
                SelectFromList.on(UL_SELECT_TYPE_IDENTIFICATION, dataCustomer.getSlttipo_identificacion(), "span"),
                Enter.theValue(dataCustomer.getTxtidentificacion()).into(INPUT_IDENTIFICATION),
                Enter.theValue(dataCustomer.getTxtcodigo_sucursal()).into(INPUT_BRANCH_CODE),
                Enter.theValue(dataCustomer.getTxtnombre()).into(INPUT_NAME),
                Enter.theValue(dataCustomer.getTxtapellido()).into(INPUT_LASTNAME),
                Enter.theValue(dataCustomer.getTxtnombre_comercial()).into(INPUT_TRADE_NAME),
                Click.on(LBL_CITY),
                Enter.theValue(dataCustomer.getTxtciudad()).into(INPUT_CITY),
                SelectFromList.on(CONTAINER_CITIES, dataCustomer.getTxtciudad(), "div"),
                Enter.theValue(dataCustomer.getTxtdireccion()).into(INPUT_ADDRESS),
                Enter.theValue(dataCustomer.getTxtcorreo_factura()).into(INPUT_EMAIL),
                Enter.theValue(dataCustomer.getTxttelefono()).into(INPUT_PHONENUMBER),
                JavaScriptClick.on(SELECT_TYPE_IVA),
                SelectFromList.on(UL_SELECT_TYPE_IVA, dataCustomer.getSlttipo_regimen(), "span"),
                Enter.theValue(dataCustomer.getTxtindicativo()).into(INPUT_INDICATIVE_FACTURACION),
                Enter.theValue(dataCustomer.getTxttelefono1()).into(INPUT_PHONENUMBER_FACTURACION),
                Enter.theValue(dataCustomer.getTxtcodigo_postal()).into(INPUT_POSTAL_CODE_FACTURACION),
                Click.on(SELECT_FISCAL_RESPONSIBILITY.of(dataCustomer.getRbresponsabilidad_fiscal())),
                Click.on(LABEL_CONTACT),
                Enter.theValue(dataCustomer.getTxtnombre_contacto()).into(INPUT_CONTACT_NAME),
                Enter.theValue(dataCustomer.getTxtapellidos_contacto()).into(INPUT_CONTACT_LASTNAME),
                Enter.theValue(dataCustomer.getTxtcorreo_contacto()).into(INPUT_CONTACT_EMAIL),
                Enter.theValue(dataCustomer.getTxtcargo_contacto()).into(INPUT_POSITION_CONTACT),
                Enter.theValue(dataCustomer.getTxtindicativo_contacto()).into(INPUT_CONTACT_INDICATIVE),
                Enter.theValue(dataCustomer.getTxttelefono_contacto()).into(INPUT_CONTACT_PHONENUMBER),
                Click.on(BTN_SAVE),
                WaitUntil.the(SELECT_TYPE_PERSON, isVisible()).forNoMoreThan(60).seconds());
    }
}
