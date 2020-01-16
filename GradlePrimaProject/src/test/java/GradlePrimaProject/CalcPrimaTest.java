package GradlePrimaProject;

import static org.junit.Assert.*;

import org.junit.Test;

public class CalcPrimaTest {
	
	//PRUEBA DE SISTEMA
	
    int[] E = { 18,19,23,20,22,24,25,26,33,34,35,36,43,44,45,46,63,64,65,66,89,90 };
    int[] P = { 30,29,28,27,2,1,26,27,28,25,24,25,26,23,22,23,21,24,25,26,27,24 };
    int[] Pr = { 1350,1350,1400,1400,1400,1400,900,850,850,900,500,400,400,500,400,250,400,250,750,550,550,750 };
    
	@Test
	public void testCalcPrimaValidos() {
		CalcPrima calculadora = new CalcPrima();
		for (int i = 0;i<22;i++) {
			int index=i+1;
			System.out.println("\n CP"+index);
			try {
				assertEquals(Pr[i], calculadora.retornarPrima(E[i], P[i]));
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
	}
	@Test(expected=Exception.class)
	public void testCalcPrimaCP23() throws Exception{
		CalcPrima calculadora = new CalcPrima();
		calculadora.retornarPrima(16, 1);
		
	}
	@Test(expected=Exception.class)
	public void testCalcPrimaCP24() throws Exception{
		CalcPrima calculadora = new CalcPrima();
		calculadora.retornarPrima(17, 30);
		
	}
	@Test(expected=Exception.class)
	public void testCalcPrimaCP25() throws Exception{
		CalcPrima calculadora = new CalcPrima();
		calculadora.retornarPrima(91, 28);
		
	}
	@Test(expected=Exception.class)
	public void testCalcPrimaCP26() throws Exception{
		CalcPrima calculadora = new CalcPrima();
		calculadora.retornarPrima(92,28);
		
	}
	@Test(expected=Exception.class)
	public void testCalcPrimaCP27() throws Exception{
		CalcPrima calculadora = new CalcPrima();
		calculadora.retornarPrima(30, -1);
		
	}
	@Test(expected=Exception.class)
	public void testCalcPrimaCP28() throws Exception{
		CalcPrima calculadora = new CalcPrima();
		calculadora.retornarPrima(40, 0);
		
	}
	@Test(expected=Exception.class)
	public void testCalcPrimaCP29() throws Exception{
		CalcPrima calculadora = new CalcPrima();
		calculadora.retornarPrima(50, 31);
		
	}
	@Test(expected=Exception.class)
	public void testCalcPrimaCP30() throws Exception{
		CalcPrima calculadora = new CalcPrima();
		calculadora.retornarPrima(60, 32);
		
	}
	@Test(expected=Error.class)
	public void testCalcPrimaCP31() throws Error{
		CalcPrima calculadora = new CalcPrima();
		calculadora.retornarPrima("xyz", 32);
		
	}
	@Test(expected=Error.class)
	public void testCalcPrimaCP32() throws Error{
		CalcPrima calculadora = new CalcPrima();
		calculadora.retornarPrima(28, "ábc");
		
	}
	
}
