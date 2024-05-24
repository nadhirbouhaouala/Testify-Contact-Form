package Pages;

import java.io.File;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import Utilities.FonctionsUtiles;

public class Formulaire_de_contact {
	
	private WebDriver driver;

    // Constructor
    public Formulaire_de_contact(WebDriver driver) {
        this.driver = driver;
    }
    
    // Elements
	private By prenom = By.xpath("//input[@id='first_24']");
	private By nom = By.xpath("//input[@id='last_24']");
	private By entreprise = By.xpath("//input[@id='input_26']");
	private By adresse = By.xpath("//input[@id='input_15']");
	private By email = By.xpath("//input[@id='input_3']");
	private By codeTel = By.xpath("//input[@id='input_25_area']");
	private By numTel = By.xpath("//input[@id='input_25_phone']");
	private By secteur = By.xpath("//select[@id='input_8']");
	private By text = By.xpath("//textarea[@id='input_6']");
	private By conditions = By.xpath("//input[@id='input_12_0']");
	private By captchaImage = By.xpath("//img[@id='input_7_captcha']");
	private By captchaText = By.xpath("//input[@id='input_7']");
	private By submit = By.xpath("//button[@id='input_16']");
	

    // Methods to interact with elements
    public void setNomComplet(String prenom, String nom) {
        driver.findElement(this.prenom).sendKeys(prenom);
        driver.findElement(this.nom).sendKeys(nom);
    }

    public void setEntreprise(String entreprise) {
        driver.findElement(this.entreprise).sendKeys(entreprise);
    }
    
    public void setAdresse(String adresse) {
    	driver.findElement(this.adresse).sendKeys(adresse);
    }
    
    public void setEmail(String email) {
    	driver.findElement(this.email).sendKeys(email);
    }
    
    public void setTel(String code, String num) {
        driver.findElement(this.codeTel).sendKeys(code);
        driver.findElement(this.numTel).sendKeys(num);
    }
    
    public void setSecteurByIndex(int index) {
    	Select s = new Select(driver.findElement(this.secteur));
    	s.selectByIndex(index);
    }
    
    public void setText(String text) {
    	driver.findElement(this.text).sendKeys(text);
    }
    
    public void acceptConditions() {
    	((JavascriptExecutor) driver).executeScript("arguments[0].click();", driver.findElement(this.conditions));
    }
    
    public void setCaptcha() {
		//télécharger l'image
		String outputImage = "src/test/java/Pages/captcha.png";
		if(FonctionsUtiles.download_base64image_from_url(driver.findElement(this.captchaImage).getAttribute("src"), outputImage )) {
			//recupere le test
			String text = FonctionsUtiles.extractTextFromImage(outputImage);
			driver.findElement(this.captchaText).sendKeys(text);
			File captcha = new File(outputImage);
			//captcha.delete();//comparer si c'est le problème de detection du text ou non
		}
    }

    public void submit() throws InterruptedException {
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", driver.findElement(this.submit));
        Thread.sleep(5000);
        //driver.findElement(this.submit).click();
    }
    
    public void setCaptcha2() {
		//télécharger l'image
		String outputImage = "src/test/java/Pages/captcha2.png";
		if(FonctionsUtiles.download_base64image_from_url(driver.findElement(By.xpath("//img[@id='input_5_captcha']")).getAttribute("src"), outputImage )) {
			//recupere le test
			String text = FonctionsUtiles.extractTextFromImage(outputImage);
			driver.findElement(By.xpath("//input[@id='input_5']")).sendKeys(text);
			File captcha = new File(outputImage);
			//captcha.delete();//comparer si c'est le problème de detection du text ou non
		}
    }
    
    public void submit2() throws InterruptedException {
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", driver.findElement(By.xpath("//button[@id='input_4']")));
        Thread.sleep(5000);
        //driver.findElement(this.submit).click();
    }
    
    public void captchaProblem() {
        // Vérifier si l'élément existe
        if (driver.findElements(By.id("input_4")).size() > 0)
        	System.out.println("C'est un problème de saisie de captcha");
    }

}
