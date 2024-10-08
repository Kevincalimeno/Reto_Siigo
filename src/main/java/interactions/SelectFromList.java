package interactions;


import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

/**
 * Autor: Miguel Rubide
 * */
public class SelectFromList implements Interaction {

    private final Target listTarget;
    private final String searchText;
    private final String tagName;

    /**
     * Constructor for SelectFromList.
     *
     * @param listTarget the target representing the list element
     * @param searchText the text to search for within the list options
     * @param tagName    the tag name of the list options
     */
    public SelectFromList(Target listTarget, String searchText, String tagName) {
        this.listTarget = listTarget;
        this.searchText = searchText;
        this.tagName = tagName;
    }

    /**
     * Performs the interaction of selecting an option from a list based on the provided search text.
     *
     * @param actor the actor performing the interaction
     * @param <T>   the type of the actor
     */
    @Override
    public <T extends Actor> void performAs(T actor) {
        WebElement listElement = listTarget.resolveFor(actor);
        List<WebElement> options = listElement.findElements(By.tagName(tagName));
        for (WebElement option : options) {
            System.out.println("option: " + option.getText());
            if (option.getText().contains(searchText)) {
                option.click();
                break;
            }
        }
    }

    /**
     * Creates an instance of SelectFromList interaction.
     *
     * @param listTarget the target representing the list element
     * @param searchText the text to search for within the list options
     * @param tagName    the tag name of the list options
     * @return a new instance of SelectFromList
     */
    public static SelectFromList on(Target listTarget, String searchText, String tagName) {
        return Instrumented.instanceOf(SelectFromList.class).withProperties(listTarget, searchText, tagName);
    }
}

