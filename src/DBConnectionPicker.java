import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class DBConnectionPicker {
	
	WebDriver driver;
	String uname;
	String pword;
	
	public DBConnectionPicker() throws SQLException
	{
		String host = "localhost";
		String port = "3306";
		String user = "root";
		String password = "root"; 
		
		Connection con = DriverManager.getConnection("jdbc:mysql://" + host + ":" + port + "/qadbt", user, password);
		Statement s = con.createStatement();
		ResultSet res = s.executeQuery("select * from credentials");
		res.next();
	    uname = res.getString("username");
		pword = res.getString("password");
		//con.close();
	}
	
	public WebElement username(WebDriver driver) {
		
		this.driver = driver;
		return this.driver.findElement(By.id("email"));
		
	}
	
	
	public WebElement password (WebDriver driver) {
		
		this.driver = driver;
		return this.driver.findElement(By.id("pass"));

	}
	public WebElement logIn (WebDriver driver) {
		
		this.driver = driver;
		return this.driver.findElement(By.xpath("//input[@type='submit']"));

	}


	public void fblogin() {
		System.setProperty("webdriver.chrome.driver", "./Driver/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.navigate().to("https://www.facebook.com/");
		username(driver).sendKeys(uname);
		password(driver).sendKeys(pword);
		logIn(driver).click();
		
	}

}
