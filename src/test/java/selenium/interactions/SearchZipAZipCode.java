package selenium.interactions;

import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import selenium.SeleniumTestWrapper;
import selenium.pageobjects.SeachZipCodePage;

public class SearchZipAZipCode extends SeachZipCodePage {

	private final Logger log = Logger.getLogger(SearchZipAZipCode.class);

	public SearchZipAZipCode(final WebDriver driver) {
		super(driver);
	}

	public void sendZipCode(String zipCode) throws Exception {
		try {
			SeleniumTestWrapper.takeScreenshot();
			sendElemet(zipCodeSearchTxt, zipCode);
			SeleniumTestWrapper.takeScreenshot();
			log.info("Zip Code " + zipCode + " was sent");
		} catch (Exception e) {
			log.error("It was not possible to send the Zip Code");
			throw e;

		}
	}

	public void clickSearchButton() throws Exception {
		try {
			SeleniumTestWrapper.takeScreenshot();
			waitToElementAndClick(buttonSearch);
			Thread.sleep(4000);
			SeleniumTestWrapper.takeScreenshot();
			log.info("Search button wa clicked");
		} catch (Exception e) {
			log.error("It was not possible to check the results");
			throw e;
		}
	}

	public void checkResults() throws Exception {
		try {
			SeleniumTestWrapper.takeScreenshot();
			int imprimir = 1;
			int contador = 1;
			while (isElementPresent(buttonNext) || imprimir == 1) {
				SeleniumTestWrapper.takeScreenshot();
				if (!isElementPresent(buttonNext)) {
					imprimir = 0;
				}
				List<WebElement> elementTable = driver.findElements(By.xpath("//table//tbody/tr"));
				if (elementTable.size() > 1) {
					for (int i = 2; i <= elementTable.size(); i++) {
						WebElement elementLogradouro = driver
								.findElement(By.xpath("//table//tbody/tr[" + i + "]/td[1]"));
						WebElement elementDistrito = driver.findElement(By.xpath("//table//tbody/tr[" + i + "]/td[2]"));
						WebElement elementLocalidade = driver
								.findElement(By.xpath("//table//tbody/tr[" + i + "]/td[3]"));
						WebElement elementCep = driver.findElement(By.xpath("//table//tbody/tr[" + i + "]/td[4]"));
						System.out.print(elementLogradouro.getText());
						System.out.print(elementDistrito.getText());
						System.out.print(elementLocalidade.getText());
						System.out.print(elementCep.getText() + "/n");
						log.info("Logradouro " + (contador) + " = " + elementLogradouro.getText());
						log.info("Bairro/Distrito " + (contador) + " = " + elementDistrito.getText());
						log.info("Localidade/UF " + (contador) + " = " + elementLocalidade.getText());
						log.info("Cep " + (contador) + " = " + elementCep.getText());
						contador++;
						if ((i - 1) % 50 == 0) {
							waitToElementAndClick(buttonNext);
						}

					}
				} else {
					log.info("No results were found");
				}

				SeleniumTestWrapper.takeScreenshot();
			}
			log.info("There were found " + (contador - 1) + " results");

			SeleniumTestWrapper.takeScreenshot();
		} catch (Exception e) {
			log.error("It was not possible to check the results");
			throw e;
		}
	}

	public void checkResultsNotFound() throws Exception {
		try {
			SeleniumTestWrapper.takeScreenshot();
			verifyTextIsPresent("DADOS NAO ENCONTRADOS");
			SeleniumTestWrapper.takeScreenshot();
		} catch (Exception e) {
			log.error("Message was not found");
			throw e;
		}

	}

}
