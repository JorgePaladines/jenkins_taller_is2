package GradlePrimaProject;

public class MainPrima {

	public static void main(String[] args) {
		
		CalcPrima calculadora = new CalcPrima();
		try {
			calculadora.retornarPrima(30, 28);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
