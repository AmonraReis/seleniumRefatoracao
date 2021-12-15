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

	@Before
	public void inicializa1(){
		driver = new ChromeDriver();
		driver.manage().window().setSize(new Dimension(1200, 765));
		driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
		dsl = new DSL(driver);
	}
	


	@Test
	public void testeCadastro () {
	
   		dsl.escrever("elementosForm:nome", "amonra");
   		dsl.escrever("elementosForm:sobrenome", "reis");
   		dsl.clicarRadio("elementosForm:sexo:1");
   		dsl.clicarRadio("elementosForm:comidaFavorita:2");
   		
   		dsl.selecionarCombo("elementosForm:escolaridade", "Mestrado");
   		dsl.selecionarCombo("elementosForm:esportes", "Futebol");
   		
   		dsl.clicarBotao("elementosForm:cadastrar");
   		
   		Assert.assertTrue(driver.findElement(By.id("resultado")).getText().startsWith("Cadastrado")); //starts with verifica se inicio com cadastrado
   		Assert.assertTrue((driver.findElement(By.id("descNome")).getText()).endsWith("amonra")); /
   		Assert.assertEquals("Sobrenome: reis", dsl.obterTexto("descSobrenome"));
   		Assert.assertEquals("Sexo: Feminino", dsl.obterTexto("descSexo"));
   		Assert.assertEquals("Comida: Pizza", dsl.obterTexto("descComida"));
   		Assert.assertEquals("Escolaridade: mestrado", dsl.obterTexto("descEscolaridade"));
   		Assert.assertEquals("Esportes: Futebol", dsl.obterTexto("descEsportes"));
   		
   		
   		
   		
   		
   		
   		
   		
   		
   				
   		
}


       
}


