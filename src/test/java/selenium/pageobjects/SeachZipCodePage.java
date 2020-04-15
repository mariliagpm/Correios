package selenium.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class SeachZipCodePage extends Pages {


	
	@FindBy(how = How.NAME, using = "relaxation")
    public WebElement zipCodeSearchTxt;
	

	@FindBy(how = How.XPATH, using = "//div[@class=\"btnform\"]//input")
    public WebElement buttonSearch;
	
	@FindBy(how = How.XPATH, using = "/html/body/div[1]/div[3]/div[2]/div/div/div[2]/div[2]/div[2]/div[5]/a")
    public WebElement buttonNext;
	
	
	
	public SeachZipCodePage(final WebDriver driver) {
		super(driver);
	}

	public void open() {
		super.open();
	}

}
