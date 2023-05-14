package tests;

import org.junit.jupiter.api.AfterAll;
import pages.Pages;

public class BaseTest {

    @AfterAll
    protected static void closeDriver()
    {
        Pages.closeTheDriver();
    }
}
