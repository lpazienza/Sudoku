package org.univoulu.tol.sqatlab.sudoku;

public class SudokuVerifier {

	public int verify(String candidateSolution) throws IncorrectSizeException{
		if(candidateSolution.length() != 81){
			throw new IncorrectSizeException();
		}
		if(r1(candidateSolution) != 0){
			return -1;
		}
		if(r2(candidateSolution) != 0){
			return -2;
		}
		if(r3(candidateSolution) != 0){
			return -3;
		}
		if(r4(candidateSolution) != 0){
			return -4;
		}
		return 0;
	}
	
	public int r1(String candidato){
		for(int i = 0;i<candidato.length();i++){
			if(!Character.isDigit(candidato.toCharArray()[i])){
				return -1;
			}
		}
		return 0;
	}
	
	public boolean differentDigits(String numeri){
		boolean risultato = true;
		if(numeri.length()!=9){
			risultato = false;
		}
		
		for(int i=0; i<numeri.length(); i++){
			for(int j=i+1;j<numeri.length();j++){
				if(numeri.charAt(i) == (numeri.charAt(j))){
					risultato=false;
				}
			}
		}
		return risultato;
	}
	
	public int r2(String candidato){
		String subGrid1, subGrid2, subGrid3 ="";
		
		for(int counter = 0; counter < 3 ; counter ++){
			int min = counter * 27;
			String subString = candidato.substring(min,min + 27);//endIdex non è compreso
			subGrid1 = computeSubGrid(subString,1);
			subGrid2 = computeSubGrid(subString,2);
			subGrid3 = computeSubGrid(subString,3);
			if(!differentDigits(subGrid1) || !differentDigits(subGrid2) || !differentDigits(subGrid3)){
				return -1;
			}
			subGrid1 ="";
			subGrid2 ="";
			subGrid3 ="";
		}
		
		return 0;
	}
	
	public String computeSubGrid(String initialString, int index){
		String subString = "";
		for(int i=0;i<3;i++){
			int min = 9*i + 3*(index-1);
			subString += initialString.substring(min, min + 3);//endIdex non è compreso
		}
		return subString;
	}
	
	public int r3(String candidato){
		int min=0;
		
		for(int i=0; i<9;i++){
			min = 9*i;
			if(!differentDigits(candidato.substring(min, min + 9))){
				return -1;
			}
		}
		return 0;
	}
	
	public int r4(String candidato){
		String column = "";
		for(int j=0;j<9;j++){	
			for(int i=0;i<9;i++){
				column += candidato.charAt(j+(9*i));
			}
			if(!differentDigits(column)){
					return -1;
				}
			column = "";
		}
		return 0;
	}
}
