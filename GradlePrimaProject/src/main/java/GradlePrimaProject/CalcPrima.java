package GradlePrimaProject;

public class CalcPrima {
	
    
	double tarifaBase = 500.0;
    double[] factorEdad = { 2.8, 1.8, 1.0, 0.8, 1.5 };
    int[] reduccion = { 50, 50, 100, 150, 200 };
	 
    
    public CalcPrima() {
		
	}

	public int retornarPrima(int ed, int pts) throws Exception {
    	double pr;
    	if (pts < 1 || pts > 30) {
    		throw new Exception("Puntos fuera del rango v�lido");   		
    	}
    	else {
            pr = calcularPrima(ed, pts);
            if (pr > 0) {
            	System.out.println("El valor es de " + pr);
            }
            else {
            	throw new Exception("Edad fuera del rango v�lido"); 
            }
    	}
    	return (int)pr;
    }
    
	
    public double calcularPrima(int edad, int puntos) {
        double prima;
        int indice = rangoEdad(edad);
        if (indice >= 0) {
            boolean red = aplicaReduccion(indice, puntos);
            double fe = factorEdad[indice];
            double redux = (red) ? reduccion[indice] : 0.0;
            prima = tarifaBase * fe - redux;
        }
        else {
        	prima = indice;
    	}
        return prima;
    }
    
    //retorna el índice que debe usarse en el arreglo, de acuerdo a la edad
    public int rangoEdad(int edad) {
        int index;
    
        if (edad < 18 || edad > 90) {
            return -1;
        }
        else if (edad >= 18 && edad < 25) {
            return 0;
        }
        else if (edad >= 25 && edad < 35) {
            return 1;
        }
        else if (edad >= 35 && edad < 45) {
            return 2;
        }
        else if (edad >= 45 && edad < 65) {
            return 3;
        }
        else {
            return 4;
        }
    }
	
    //indica si se debe o no se debe aplicar la reduccion
    //verdadero si no se han perdido muchos puntos
    //falso si se han perdido puntos
    public boolean aplicaReduccion(int indexEdad, int puntos) {
        
        boolean check = true;
        
        int perdidos = 30 - puntos;
        
        switch (indexEdad) {
            case 0:
                check = (perdidos <= 1);
                break;
            case 1:
               check = (perdidos <= 3);
                break;
            case 2:
              check = (perdidos <= 5);
                break;
            case 3:
              check = (perdidos <= 7);
                break;
            case 4:
              check = (perdidos <= 4);
                break;
            default:
                break;
        }
        
        return check;
    
    }

}
