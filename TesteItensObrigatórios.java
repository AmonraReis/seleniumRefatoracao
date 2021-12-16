///Nesta bateria de testes realizo a verificação de todos os itens obrigatórios no sistema, validando se estão funcionando de forma correta.





import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class TesteItensObrigatórios {
	
	private WebDriver driver;
	private DSL dsl;

	@Before
	public void inicializa(){
		driver = new ChromeDriver();
		driver.manage().window().setSize(new Dimension(1200, 765));
		driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
		dsl = new DSL(driver);
	}
	
	@Test
	public void testeNomeObrigatório () {
		
		   
		
		WebDriver driver = new ChromeDriver();
		driver.get("file:" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
		dsl.clicarBotao("elementosForm:cadastrar");
		//Alert alert = driver.switchTo().alert(); //muda o foco para o alerta
	    Assert.assertEquals("Nome eh obrigatorio", dsl.alertaObterTexto());
	    
		}


	@ Test
	 public void ValidarSobreNomeObrigatório () {
	 WebDriver driver = new ChromeDriver();
	 driver.get("file:" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
	 
	 dsl.escrever("elementosForm:nome", "teste");
	 
	 dsl.clicarBotao("elementosForm:cadastrar");
		//Alert alert = driver.switchTo().alert();
		
	Assert.assertEquals("Sobrenome eh obrigatorio", dsl.alertaObterTexto());
	 


	}@Test
	 

		public void ValidarSexo () {
		WebDriver driver = new ChromeDriver();
		driver.get("file:" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
		
		dsl.escrever("elementosForm:nome", "teste"); //preenche os dois obrigatorios
		dsl.escrever("elementosForm:sobrenome", "teste2");
		
		dsl.clicarBotao("elementosForm:cadastrar"); //clica em cadastrar
		//Alert alert = driver.switchTo().alert(); //altera o foco
	   	
		 Assert.assertEquals("Sexo eh obrigatorio", dsl.alertaObterTexto()); //assert equals para ver se ele está solicitando o item obrigatorio
		    
		
		
		}
	@Test
			public void ValidarComidaVegetariana () {
			WebDriver driver = new ChromeDriver();
			driver.get("file:" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
			
			dsl.escrever("elementosForm:nome", "teste"); //item obrigatório preencher
			dsl.escrever("elementosForm:sobrenome", "teste2"); //item obrigatório preencher
			dsl.clicarCheck("elementosForm:sexo:0"); //item obrigatório preencher
			
			dsl.clicarCheck("elementosForm:comidaFavorita:0"); //seleciona carne
			dsl.clicarCheck("elementosForm:comidaFavorita:3"); //seleciona vegetariana
			
			dsl.clicarBotao("elementosForm:cadastrar"); //clica no boyao
			//Alert alert = driver.switchTo().alert(); //altera o foco
			
			Assert.assertEquals("Tem certeza que voce eh vegetariano?", dsl.alertaObterTexto()); //verifica a mensagem de mal uso do usuário
			




	}
	@Test
			public void ValidarEsporte () {
			WebDriver driver = new ChromeDriver();
			driver.get("file:" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
			
			dsl.escrever("elementosForm:nome", "teste"); //item obrigatório preencher
			dsl.escrever("elementosForm:sobrenome", "teste2"); //item obrigatório preencher
			dsl.clicarCheck("elementosForm:sexo:0"); //item obrigatório preencher
			
			dsl.clicarCheck("elementosForm:comidaFavorita:0"); //seleciona carne
			
			dsl.selecionarCombo("elementosForm:esportes", "Futebol"); //abre o combo de selecões
			dsl.selecionarCombo("elementosForm:esportes", "O que eh esporte?");
			 //e seleciona que n sabe oq é
			
			dsl.clicarBotao("elementosForm:cadastrar"); //clica no boyao
			//Alert alert = driver.switchTo().alert(); //altera o foco
			
			Assert.assertEquals("Voce faz esporte ou nao?", dsl.alertaObterTexto()); //verifica a mensagem de mal uso do usuário
			
			
			
			
	}
			}
