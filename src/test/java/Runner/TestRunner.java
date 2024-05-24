package Runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/java/Features", // Location of the feature files
        glue = {"utility", "StepDefinition"}, // Location of the step definitions
        plugin = {
        			"pretty", 
        			"html:target/cucumber-html-report.html", // Génère un rapport HTML dans le répertoire spécifié : target/cucumber-html-report.
        			"json:target/cucumber-json-report.json" // Génère un rapport au format JSON, stocké dans le fichier cucumber.json
        		}
)
public class TestRunner {

}
