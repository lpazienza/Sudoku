package org.univoulu.tol.sqatlab.sudoku;

public class SudokuVerifier {

	public int verify(String candidateSolution) {
		return r1(candidateSolution);
	}
	
	public int r1(String candidato){
		int risultato = 0;
		int[] sudokuArray = new int[candidato.length()];
		
		for(int i = 0;i<candidato.length();i++){
			sudokuArray[i] = Character.getNumericValue(candidato.charAt(i));
			if(sudokuArray[i] < 1){
				risultato = -1;
			}
		}
		return risultato;
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
		int risultato = 0;
		String holder="";
		
		for(int j=0;j<3;j++){
			for(int i=0; i<9;i++){
				for(int k=0; k<3; k++){
					if(j==1){
						k+=3;
					}
					if(j==2){
						k+=6;
					}
					holder+=candidato.charAt(k);
				}
				if(i==2 || i==5 || i==8){
					if(!differentDigits(holder)){
						risultato = -1;
					}
				}
			}
		}
		return risultato;
	}
	
	public int r3(String candidato){
		int risultato = 0;
		int min=0;
		int max=9;
		
		for(int i=0; i<9;i++){
			if(!differentDigits(candidato.substring(min, max))){
				risultato = -1;
			}
			min = max;
			max +=9;
		}
		return risultato;
	}
}
