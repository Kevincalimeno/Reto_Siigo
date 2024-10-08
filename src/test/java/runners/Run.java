package runners;


import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(features = "src/test/resources/features/reto_siigo.feature",
        tags = "@Test1",
        glue = "stepdefinitions",
        snippets = CucumberOptions.SnippetType.CAMELCASE)

public class Run {
}
