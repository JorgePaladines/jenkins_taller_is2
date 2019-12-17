package GradlePrimaProject;

import static org.junit.Assert.*;

import org.junit.Test;

public class PrimaTest {

	@Test
	public void testRetornar_prima() throws Exception{
		CalcPrima calculo = new CalcPrima();
		
		try {
			assertEquals("", 850, (int)calculo.retornarPrima(30, 28));
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		try {
			assertEquals("", 1400, (int)calculo.retornarPrima(20, 25));
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		try {
			calculo.retornarPrima(15, 20);
		}
		catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		try {
			calculo.retornarPrima(17, 20);
		}
		catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		try {
			assertEquals("", 850, (int)calculo.retornarPrima(25, 30));
			
		}
		catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		try {
			assertEquals("", 400, (int)calculo.retornarPrima(55, 5));
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		try {
			calculo.retornarPrima(98, 20);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		try {
			assertEquals("", 750, (int)calculo.retornarPrima(89, 20));
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		try {
			calculo.retornarPrima(89, 55);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		try {
			calculo.retornarPrima(36, 55);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
	}
}
