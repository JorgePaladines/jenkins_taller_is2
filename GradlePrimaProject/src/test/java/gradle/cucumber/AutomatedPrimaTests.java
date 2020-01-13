package gradle.cucumber;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.junit.Assert.*;

import GradlePrimaProject.CalcPrima;



public class AutomatedPrimaTests {
	private int edad;
	private int puntos;
	private CalcPrima calculoPrima = new CalcPrima();
	private double resultado;
	
	@Given("La edad del cliente es {int}")
	public void la_edad_del_cliente_es(Integer edad) {
	    this.edad = edad;
	}

	@Given("Sus puntos son {int}")
	public void sus_puntos_son(Integer puntos) {
	    this.puntos = puntos;
	}

	@When("Pide que se calcule el valor de su seguro")
	public void pide_que_se_calcule_el_valor_de_su_seguro() {
	    this.resultado = calculoPrima.calcularPrima(this.edad, this.puntos);
	}

	@Then("Se le dirá que su seguro es {int}")
	public void se_le_dirá_que_su_seguro_es(Integer resultadoEsperado) {
		assertEquals((int)resultadoEsperado, (int)this.resultado);
	}
	
}
