import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class TesteCadastro {
	
	private WebDriver driver;
	private DSL dsl;
	private CampoTreinamentoPage page;

	@Before
	public void inicializa1(){
		driver = new ChromeDriver();
		driver.manage().window().setSize(new Dimension(1200, 765));
		driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
		dsl = new DSL(driver);
		page = new CampoTreinamentoPage (driver);
	}
	


	@Test
	public void testeCadastro () {
	
   		page.setNome( "amonra");
   		page.setSobreNome("reis");
   		page.setSexoMasculino();
   		page.setComidaFavorita();
   		
   		page.setEscolaridade("Mestrado");
   		page.setEsportes("Futebol");
   		page.setCadastrar();
   		
   		Assert.assertTrue(page.obterResultadoCadastro().startsWith("Cadastrado")); //starts with verifica se inicio com cadastrado
   		Assert.assertTrue(page.obterNomeCadastro().endsWith("amonra")); //verifica se terminou com luiny
   		Assert.assertEquals("Sobrenome: reis", page.obterSobreNomeCadastro());
   		Assert.assertEquals("Sexo: Feminino", page.obterSexoCadastro());
   		Assert.assertEquals("Comida: Pizza", page.obterComidaCadastro());
   		Assert.assertEquals("Escolaridade: mestrado", page.obterEscolaridadeCadastro());
   		Assert.assertEquals("Esportes: Futebol", page.obterEsporteCadastro());
   		
   		
   		
   		
   		
   		
   		
   		
   		
   				
   		
}
