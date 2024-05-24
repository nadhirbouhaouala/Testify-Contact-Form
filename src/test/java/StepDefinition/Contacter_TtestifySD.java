package StepDefinition;



import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import Pages.Formulaire_de_contact;
import Utilities.Config;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Contacter_TtestifySD {
	
	private WebDriver driver;
	private String baseUrl;
    private int timeout;
    private Formulaire_de_contact contact;
    

	@Given("un visiteur sur le formulaire de contact")
    public void je_suis_sur_le_formulaire_de_conact() {
        driver = new ChromeDriver();
        
        baseUrl = Config.getProperty("baseUrl");
        timeout = Integer.parseInt(Config.getProperty("timeout"));
        driver.get(baseUrl+"/241263471608354");
		driver.manage().window().maximize();
		
		contact = new Formulaire_de_contact(driver);
    }
	
	@When("je saisie {string} comme prénom, {string} comme nom")
    public void je_saisie_nom_complet(String prenom, String nom) {
    	contact.setNomComplet(prenom, nom);
    }

    @When("je saisie {string} comme entreprise")
    public void je_saisie_entreprise(String entreprise) {
    	contact.setEntreprise(entreprise);
    }
    
    @When("je saisie {string} comme adresse")
    public void je_saisie_adresse(String adresse) {
    	contact.setAdresse(adresse);
    }
    
    @When("je saisie {string} comme email")
    public void je_saisie_email(String email) {
    	contact.setEmail(email);
    }
    
    @When("je saisie {string} et {string} comme numéro de téléphone")
    public void je_saisie_tel(String ref, String num) {
    	contact.setTel(ref, num);
    }
    
    @When("je saisie {string} pour indiquer que l entreprise travaille dans le secteur des fruits secs")
    public void je_saisie_secteur(String secteur) {
    	contact.setSecteurByIndex(Integer.parseInt(secteur));
    }
    
    @When("je saisie {string} comme texte de contact")
    public void je_saisie_text(String text) {
    	contact.setText(text);
    }
    
    @When("je coche que j accepte les conditions")
    public void je_coche_accepter_conditions() {
    	contact.acceptConditions();
    }
    
    @When("je fais le captcha")
    public void je_fais_captcha() {
    	contact.setCaptcha();
    }

    @When("je clique sur le bouton submit")
    public void je_clique_sur_le_bouton_submit() throws InterruptedException {
    	contact.submit();
    }
    
    @When("je fais le captcha2")
    public void je_fais_captcha2() {
    	contact.setCaptcha2();
    }

    @When("je clique sur le bouton submit2")
    public void je_clique_sur_le_bouton_submit2() throws InterruptedException {
    	contact.submit2();
    }

    @Then("je dois avoir le message suivant {string}")
    public void je_dois_voir_le_message(String msg) {
    	if(driver.getPageSource().contains(msg))
			System.out.println("Test Case passed !");
		else {
			System.out.println("Test Case failed !");
			contact.captchaProblem();
		}
		driver.quit();
    }
    
    @Then("je dois avoir le message d erreur suivant {string}")
    public void je_dois_voir_le_message_derreur(String error) {
    	if(driver.getPageSource().contains(error))
			System.out.println("Test Case passed !");
		else
			System.out.println("Test Case failed !");
		driver.quit();
    }

}
