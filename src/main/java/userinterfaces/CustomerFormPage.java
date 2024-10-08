package userinterfaces;

import net.serenitybdd.screenplay.targets.Target;
import net.thucydides.core.webdriver.shadow.ByShadow;
import org.openqa.selenium.By;
import utils.ShadowElementLocator;

public class CustomerFormPage {

    public static final Target SELECT_TYPE_PERSON = Target.the("Selector para persona")
            .located(ShadowElementLocator.locate(
                    By.xpath("(//siigo-dropdownlist-web)[2]"), "i.mdc-select__dropdown-icon"));

    public static final Target UL_SELECT_TYPE_PERSON = Target.the("Lista de selección de tipo de persona")
            .located(ShadowElementLocator.locate(
                    By.xpath("(//siigo-dropdownlist-web)[2]"), "ul"
            ));

    public static final Target SELECT_TYPE_IDENTIFICATION = Target.the("Selector de identificación")
            .located(ShadowElementLocator.locate(
                    By.xpath("(//siigo-dropdownlist-web)[3]"),
                    "i.mdc-select__dropdown-icon"
            ));

    public static final Target UL_SELECT_TYPE_IDENTIFICATION = Target.the("Lista de tipo de identificación")
            .located(ShadowElementLocator.locate(
                    By.xpath("(//siigo-dropdownlist-web)[3]"), "ul"
            ));

    public static final Target INPUT_IDENTIFICATION = Target.the("Campo para identificación")
            .located(ShadowElementLocator.locate(By.xpath("//siigo-identification-input-web[@class='hydrated']"), "input"));

    public static final Target INPUT_BRANCH_CODE = Target.the("Campo para código de sucursal")
            .located(ShadowElementLocator.locate(By.xpath("(//siigo-textfield-web)[1]"), "input"));

    public static final Target INPUT_NAME = Target.the("Campo para nombre")
            .located(ShadowElementLocator.locate(By.xpath("(//siigo-textfield-web)[2]"), "input"));

    public static final Target INPUT_LASTNAME = Target.the("Campo para apellido")
            .located(ShadowElementLocator.locate(By.xpath("(//siigo-textfield-web)[3]"), "input"));

    public static final Target INPUT_TRADE_NAME = Target.the("Campo para nombre comercial")
            .located(ShadowElementLocator.locate(By.xpath("(//siigo-textfield-web)[5]"), "input"));

    public static final Target LBL_CITY = Target.the("Etiqueta de ciudad")
            .located(ShadowElementLocator.locate(By.xpath("(//siigo-autocomplete-web)[1]"), "#labelAutocompleteSelectItemcity"));

    public static final Target INPUT_CITY = Target.the("Campo para ciudad")
            .located(ShadowElementLocator.locate(By.xpath("(//siigo-autocomplete-web)[1]"), "input"));

    public static final Target CONTAINER_CITIES = Target.the("Contenedor de opciones de ciudades")
            .located(ShadowElementLocator.locate(By.xpath("(//siigo-autocomplete-web)[1]"), "#tableAutocompletecity > tbody"));

    public static final Target INPUT_ADDRESS  = Target.the("Campo para dirección")
            .located(ShadowElementLocator.locate(By.xpath("(//siigo-textfield-web)[6]"), "input"));

    public static final Target INPUT_EMAIL  = Target.the("Campo para correo electrónico")
            .located(ShadowElementLocator.locate(By.xpath("(//siigo-textfield-web)[9]"), "input"));

    public static final Target INPUT_PHONENUMBER  = Target.the("Campo para teléfono")
            .located(ShadowElementLocator.locate(By.xpath("(//siigo-phone-web)[1]"), "input[aria-labelledby='inputNumber0']"));

    public static final Target SELECT_TYPE_IVA  = Target.the("Selector de régimen IVA")
            .located(ShadowElementLocator.locate(By.xpath("(//siigo-dropdownlist-web)[4]"), "i.mdc-select__dropdown-icon"));

    public static final Target UL_SELECT_TYPE_IVA  = Target.the("Lista de régimen IVA")
            .located(ShadowElementLocator.locate(
                    By.xpath("(//siigo-dropdownlist-web)[4]"), "ul"
            ));

    public static final Target INPUT_INDICATIVE_FACTURACION  = Target.the("Campo para indicativo de teléfono")
            .located(ShadowElementLocator.locate(By.xpath("(//siigo-textfield-web)[10]"), "input"));

    public static final Target INPUT_PHONENUMBER_FACTURACION  = Target.the("Campo para teléfono de facturación")
            .located(ShadowElementLocator.locate(By.xpath("(//siigo-textfield-web)[11]"), "input"));

    public static final Target INPUT_POSTAL_CODE_FACTURACION  = Target.the("Campo para código postal")
            .located(ShadowElementLocator.locate(By.xpath("(//siigo-textfield-web)[12]"), "input"));

    public static final Target SELECT_FISCAL_RESPONSIBILITY  = Target.the("Selector de responsabilidad fiscal")
            .locatedBy("//div[contains(text(),'{0}')]");

    public static final Target INPUT_CONTACT_NAME  = Target.the("Campo para nombre de contacto")
            .located(ByShadow.cssSelector("input", "siigo-textfield-web[name='FirstName']"));

    public static final Target LABEL_CONTACT  = Target.the("contactos")
            .locatedBy("//h3[contains(text(),'Contactos')]");

    public static final Target INPUT_CONTACT_LASTNAME  = Target.the("Campo para apellido de contacto")
            .located(ByShadow.cssSelector("input", "siigo-textfield-web[name='LastName']"));

    public static final Target INPUT_CONTACT_EMAIL  = Target.the("Campo para correo de contacto")
            .located(ByShadow.cssSelector("input", "siigo-emailinput-web[name='Email']"));

    public static final Target INPUT_POSITION_CONTACT  = Target.the("Campo para cargo de contacto")
            .located(ByShadow.cssSelector("input", "siigo-textfield-web[name='Charge']"));

    public static final Target INPUT_CONTACT_INDICATIVE  = Target.the("Campo para indicativo de contacto")
            .located(ByShadow.cssSelector("input", "siigo-textfield-web[name='Indicative']"));

    public static final Target INPUT_CONTACT_PHONENUMBER  = Target.the("Campo para número de teléfono de contacto")
            .located(ByShadow.cssSelector("input", "siigo-textfield-web[name='Number']"));

    public static final Target BTN_SAVE  = Target.the("Botón para guardar")
            .locatedBy("//button[contains(text(),'Guardar')]");

    public static final Target LABEL_VALIDATE  = Target.the("Etiqueta de validación")
            .locatedBy("//*[@id=\"main\"]/div/app-third-party-view/div/div[1]/div[1]/h2");

}
