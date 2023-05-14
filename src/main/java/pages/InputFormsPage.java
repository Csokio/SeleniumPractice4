package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.HashMap;
import java.util.List;

public class InputFormsPage extends Pages{

    public InputFormsPage()
    {
        super();
    }


    private final String url = "https://demo.seleniumeasy.com/";
    private final By BUTTON_INPUT_FORMS = By.xpath("//a[text()='All Examples']/following::a[text()='Input Forms']");
    private final By PAGE_CHECKBOX = By.xpath("//ul[@id='treemenu']//a[contains(text(), 'Che')]");
    public void goToCheckBox()
    {
        navigate(url);
        driver.findElement(BUTTON_INPUT_FORMS).click();
        driver.findElement(PAGE_CHECKBOX).click();
    }

    private final By CHECKBOX = By.xpath("//div[text()=\"Multiple Checkbox Demo\"]//following::input[@type=\"checkbox\"]");

    public Boolean isChecked()
    {
        List<WebElement> boxes = driver.findElements(CHECKBOX).subList(1,3);

        for(WebElement box: boxes){
            if(!box.isSelected()){
                box.click();
            }
        }

        for(int i = 0; i < boxes.size(); i++){
            if(boxes.get(i).isSelected()){
                return true;
            }
        }
        return false;
    }

    private final By PAGE_RADIO = By.xpath("//a[text()='All Examples']/following::a[text()='Radio Buttons Demo']");
    private final By BUTTON_FEMALE = By.xpath("//h4[text()='Sex : ']/following::input[@value='Female']");
    private final By BUTTON_MALE = By.xpath("//h4[text()='Sex : ']/following::input[@value='Male']");
    private final By BUTTON_AGES = By.xpath("//input[@name='ageGroup']");
    private final By TEXT_AGES = By.xpath("//p[@class='groupradiobutton']");


    public HashMap<String, String> getValueText()
    {
        navigate(url);
        driver.findElement(BUTTON_INPUT_FORMS).click();
        driver.findElement(PAGE_RADIO).click();
        driver.findElement(BUTTON_MALE).click();
        driver.findElements(BUTTON_AGES).get(1).click();


        javaExecuteScript("getValues();");
        String textAges = driver.findElement(TEXT_AGES).getText();

        StringBuilder stringBuilder = new StringBuilder(textAges);
        stringBuilder.insert(11, ",");

        String[] pairs = stringBuilder.toString().split(",");
        HashMap<String, String> resultMap = new HashMap<>();

        for(String pair: pairs){
            String[] subArray = pair.split(":");
            resultMap.put(subArray[0], subArray[1]);
        }
        return resultMap;
    }
}
