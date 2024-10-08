package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.NoSuchElementException;
import java.util.ArrayList;
import java.util.List;

public class ShadowElementLocator extends By {
    private final By shadowHostLocator;
    private final String[] selectors;

    // Constructor que acepta un XPath para el elemento raíz y selectores CSS para los internos
    private ShadowElementLocator(By shadowHostLocator, String... selectors) {
        this.shadowHostLocator = shadowHostLocator; // XPath para el elemento raíz
        this.selectors = selectors; // Selectores CSS para los elementos internos
    }

    // Método de fábrica para crear instancias con el XPath del host
    public static ShadowElementLocator locate(By hostXPath, String... selectors) {
        return new ShadowElementLocator(hostXPath, selectors);
    }

    @Override
    public WebElement findElement(SearchContext context) {
        WebElement hostElement = context.findElement(this.shadowHostLocator);
        SearchContext shadowRoot = hostElement.getShadowRoot();

        if (shadowRoot == null) {
            throw new NoSuchElementException("No se encontró el root de Shadow para: " + this.selectors[0]);
        }

        return findNestedElement(shadowRoot, 0);
    }

    @Override
    public List<WebElement> findElements(SearchContext context) {
        WebElement hostElement = context.findElement(this.shadowHostLocator);
        SearchContext shadowRoot = hostElement.getShadowRoot();

        if (shadowRoot == null) {
            throw new NoSuchElementException("No se encontró el root de Shadow para: " + this.selectors[0]);
        }

        return findNestedElements(shadowRoot, 0);
    }

    // Método auxiliar para encontrar un elemento anidado
    private WebElement findNestedElement(SearchContext context, int depth) {
        WebElement nestedElement = context.findElement(By.cssSelector(this.selectors[depth]));

        if (depth + 1 < this.selectors.length) {
            SearchContext nextShadowRoot = nestedElement.getShadowRoot();
            if (nextShadowRoot == null) {
                throw new NoSuchElementException("No se encontró el root de Shadow para el selector: " + this.selectors[depth]);
            }
            return findNestedElement(nextShadowRoot, depth + 1);
        } else {
            return nestedElement;
        }
    }

    // Método auxiliar para encontrar todos los elementos anidados
    private List<WebElement> findNestedElements(SearchContext context, int depth) {
        List<WebElement> nestedElements = context.findElements(By.cssSelector(this.selectors[depth]));
        List<WebElement> allElements = new ArrayList<>();

        if (depth + 1 < this.selectors.length) {
            for (WebElement parent : nestedElements) {
                SearchContext nextShadowRoot = parent.getShadowRoot();
                if (nextShadowRoot != null) {
                    allElements.addAll(findNestedElements(nextShadowRoot, depth + 1));
                }
            }
        } else {
            allElements.addAll(nestedElements);
        }

        return allElements;
    }
}
