package sweeper.login.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class SecureAreaPage {

    @FindBy(how = How.LINK_TEXT, using = "Resolution Recommendation Tool")
    private WebElement message;
    
    private WebDriver driver;

    public SecureAreaPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(this.driver,this);
    }

    public String getLoginMessage(){
        return   message.getText();
    }
    
    //@FindBy(xpath="//h3/i")
    @FindBy(xpath="//div[@id='root']/div/div/div/div/div/div/ul/li/h3/i")
    private WebElement select;
    
    @FindBy(xpath="//div[@id='root']/div/div/div/div/div/div/ul/li/ul/li/div[2]/i")
    private WebElement select1;
    
    @FindBy(xpath="//li[2]/h3/i")
    private WebElement select2;
    
    @FindBy(xpath="//li[2]/ul/li/div[2]/i")
    private WebElement select3;
    
    @FindBy(xpath="//li[3]/h3/i")
    private WebElement select4;
    
    @FindBy(xpath="//li[3]/ul/li[4]/div[2]/i")
    private WebElement select5;
       		
    @FindBy(xpath="//button")
    private WebElement display;
    
    @FindBy(how = How.CSS, using = "td")
    private WebElement firstElement;
    
    public String displayRule(){
    	select.click();
    	select1.click();
    	select2.click();
    	select3.click();
    	select4.click();
    	select5.click();
    	display.click();
    	return firstElement.getText();
    }
    
    @FindBy(xpath="(//button[@type='button'])[2]")
    private WebElement addbutton;
    
    @FindBy(how = How.ID, using = "name")
    private WebElement name;
    
    @FindBy(how = How.ID, using = "description")
    private WebElement description;
    
    @FindBy(xpath="//button[@type='submit']")
    private WebElement next1;
    
    @FindBy(xpath="(//button[@type='button'])[7]")
    private WebElement andbutton;
    
    @FindBy(xpath="(//button[@type='button'])[9]")
    private WebElement addclause;
    
    @FindBy(xpath="//input")
    private WebElement attributevalue;
    
    @FindBy(xpath="(//button[@type='button'])[12]")
    private WebElement next2;

    @FindBy(xpath="(//button[@type='button'])[15]")
    private WebElement createrulebutton;    
    		
    public void addRule(){
    	addbutton.click();
    	name.sendKeys("probandoXXX");
    	description.sendKeys("descr");
    	next1.click();
    	addclause.click();
    	andbutton.click();
    	andbutton.click();
    	attributevalue.sendKeys("valor1");
    	next2.click();
    	createrulebutton.click();
       	//return "";
    }
}
