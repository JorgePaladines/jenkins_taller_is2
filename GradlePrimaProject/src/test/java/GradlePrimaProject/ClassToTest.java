package GradlePrimaProject;

public class ClassToTest {
	private MyDatabase database;

	ClassToTest(MyDatabase database){
		this.database = database;
	}

	public boolean query(String string) {
		if(string.equals("* from t")) {
			this.database.query(string);
			return true;
		}
		else {
			return false;
		}
	}
	
	
}
