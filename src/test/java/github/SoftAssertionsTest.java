package github;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class SoftAssertionsTest {

    @BeforeAll
    static void setup() {
        Configuration.startMaximized = true;
    }

    @BeforeEach
    void openWikiPage() {
        // Откройте страницу Selenide в Github
        open("https://github.com/selenide/selenide/");
        // Перейдите в раздел Wiki проекта
        $(byText("Wiki")).click();
    }

    @Test
    void checkSoftAssertion() {
        // Убедитесь, что в списке страниц (Pages) есть страница SoftAssertions
        $(byText("Soft assertions")).shouldBe(visible);
    }


    @Test
    void checkJunitExampleTest() {
        //  - Откройте страницу SoftAssertions, проверьте что внутри есть пример кода для JUnit5
        $(byText("Soft assertions")).click();
        $(byText("Using JUnit5 extend test class:")).shouldBe(visible);
    }
}
