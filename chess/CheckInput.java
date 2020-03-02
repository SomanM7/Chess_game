package chess;

public class CheckInput {
	
	
	public static boolean checkCoordinateValidity(String input){
		
		int coordLength = input.length();
		if (coordLength != 2){
			return false;

		}
		else{
			return true;
		}

	}
}

