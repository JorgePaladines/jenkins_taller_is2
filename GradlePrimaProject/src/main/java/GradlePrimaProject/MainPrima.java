package GradlePrimaProject;

public class MainPrima {

	public static void main(String[] args) {
		
		CalcPrima calculadora = new CalcPrima();
		try {
			calculadora.retornarPrima(65, 26);
			calculadora.retornarPrima(65, 25);
			calculadora.retornarPrima(65, 24);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
