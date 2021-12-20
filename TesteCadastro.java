package seleniumcurso;

import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;



public class TesteCadastro {
	
	private WebDriver driver;
	
	@Before  
	
	//antes de cada teste executar o conteudo desse metodo
	
	   public void Inicializa() {
			
		    driver = new ChromeDriver();
			driver.get("file:" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
			
			
		}
           @Test
           
           public void testeCadastro () {
       		
       		
       		driver.findElement(By.id("elementosForm:nome")).sendKeys("Luiny");
       		driver.findElement(By.id("elementosForm:sobrenome")).sendKeys("Maria");
       		driver.findElement(By.id("elementosForm:sexo:1")).click();
       		driver.findElement(By.id("elementosForm:comidaFavorita:2")).click();
       		
       		new Select(driver.findElement(By.id("elementosForm:escolaridade"))).selectByVisibleText("Mestrado");
       		new Select(driver.findElement(By.id("elementosForm:esportes"))).selectByVisibleText("Futebol");
       		
       		driver.findElement(By.id("elementosForm:cadastrar")).click();
       		
       		Assert.assertTrue(driver.findElement(By.id("resultado")).getText().startsWith("Cadastrado")); //starts with verifica se inicio com cadastrado
       		Assert.assertTrue((driver.findElement(By.id("descNome")).getText()).endsWith("Luiny")); //verifica se terminou com luiny
       		Assert.assertEquals("Sobrenome: Maria", driver.findElement(By.id("descSobrenome")).getText());
       		Assert.assertEquals("Sexo: Feminino", driver.findElement(By.id("descSexo")).getText());
       		Assert.assertEquals("Comida: Pizza", driver.findElement(By.id("descComida")).getText());
       		Assert.assertEquals("Escolaridade: mestrado", driver.findElement(By.id("descEscolaridade")).getText());
       		Assert.assertEquals("Esportes: Futebol", driver.findElement(By.id("descEsportes")).getText());
       		
       		
       		
       		
       		
       		
       		
       		
       		
       				
       		
}@Test
           public void testeNomeObrigatório () {
          		
        	   
          		
          
          	driver.findElement(By.id("elementosForm:cadastrar")).click();
          	Alert alert = driver.switchTo().alert(); //muda o foco para o alerta
            Assert.assertEquals("Nome eh obrigatorio", alert.getText());
               
          	}
           

@ Test
		    public void ValidarSobreNomeObrigatório () {
		  
		    driver.findElement(By.id("elementosForm:nome")).sendKeys("teste");
		    
		    driver.findElement(By.id("elementosForm:cadastrar")).click();
          	Alert alert = driver.switchTo().alert();
          	
          	Assert.assertEquals("Sobrenome eh obrigatorio", alert.getText());
		    
		 
	
}@Test
		    

		 	public void ValidarSexo () {
			
			
			driver.findElement(By.id("elementosForm:nome")).sendKeys("teste"); //preenche os dois obrigatorios
			driver.findElement(By.id("elementosForm:sobrenome")).sendKeys("teste2");
			
			 driver.findElement(By.id("elementosForm:cadastrar")).click(); //clica em cadastrar
	         Alert alert = driver.switchTo().alert(); //altera o foco
	          	
	         Assert.assertEquals("Sexo eh obrigatorio", alert.getText()); //assert equals para ver se ele está solicitando o item obrigatorio
			    
			
			
		 	}
@Test
				public void ValidarComidaVegetariana () {
				
				
				driver.findElement(By.id("elementosForm:nome")).sendKeys("teste"); //item obrigatório preencher
				driver.findElement(By.id("elementosForm:sobrenome")).sendKeys("teste2"); //item obrigatório preencher
				driver.findElement(By.id("elementosForm:sexo:0")).click(); //item obrigatório preencher
				
				driver.findElement(By.id("elementosForm:comidaFavorita:0")).click(); //seleciona carne
				driver.findElement(By.id("elementosForm:comidaFavorita:3")).click(); //seleciona vegetariana
				
				driver.findElement(By.id("elementosForm:cadastrar")).click(); //clica no boyao
				Alert alert = driver.switchTo().alert(); //altera o foco
				
				Assert.assertEquals("Tem certeza que voce eh vegetariano?", alert.getText()); //verifica a mensagem de mal uso do usuário
				




}
@Test
				public void ValidarEsporte () {
								
				driver.findElement(By.id("elementosForm:nome")).sendKeys("teste"); //item obrigatório preencher
				driver.findElement(By.id("elementosForm:sobrenome")).sendKeys("teste2"); //item obrigatório preencher
				driver.findElement(By.id("elementosForm:sexo:0")).click(); //item obrigatório preencher
				
				driver.findElement(By.id("elementosForm:comidaFavorita:0")).click(); //seleciona carne
				
				Select combo = new Select (driver.findElement(By.id("elementosForm:esportes"))); //abre o combo de selecões
				combo.selectByVisibleText("Futebol"); //seleciona esporte
				combo.selectByVisibleText("O que eh esporte?"); //e seleciona que n sabe oq é
				
				driver.findElement(By.id("elementosForm:cadastrar")).click(); //clica no boyao
				Alert alert = driver.switchTo().alert(); //altera o foco
				
				Assert.assertEquals("Voce faz esporte ou nao?", alert.getText()); //verifica a mensagem de mal uso do usuário
				
				
				
				
}
				}
