package utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class utilities {
	
	public WebDriver driver;

	public void select_visibletext(WebElement element, String visible_text)
	{
		Select select = new Select(element);
		select.selectByVisibleText(visible_text);
	}
}
