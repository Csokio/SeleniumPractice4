package tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pages.InputFormsPage;
import pages.Pages;

public class InputFormTest extends BaseTest{

    InputFormsPage inputFormsPage = new InputFormsPage();

    @Test
    public void testIsChecked()
    {
        inputFormsPage.goToCheckBox();

        Assertions.assertTrue(inputFormsPage.isChecked());
    }

    @Test
    public void testValue()
    {
        Pages.writeFile(inputFormsPage.getValueText(), "actualMap.txt");
    }
}
