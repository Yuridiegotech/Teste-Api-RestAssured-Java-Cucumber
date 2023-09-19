package Runner;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/feature/",
        plugin = { "pretty","html:cucumber-html-report.html","json:cucumber.json" },
        glue = "steps",
        monochrome = true
)
public class RunnerTest {

}
