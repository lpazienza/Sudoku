package org.univoulu.tol.sqatlab.sudoku;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class TestSudokuVerifier {
	SudokuVerifier mySudoku;
	
	@Before
	public void setUp(){
		mySudoku = new SudokuVerifier();
	}

	@Test
	public void r1Respected() {
		//act
		int valid = mySudoku.r1("417369825632158947958724316825437169791586432346912758289643571573291684164875293");
		//assert
		assertEquals(0,valid);
	}
	@Test
	public void differentDigitsIsTrue(){
		assertTrue(mySudoku.differentDigits("256438971"));
	}
	
	@Test
	public void differentDigitsIsFalse(){
		assertFalse(mySudoku.differentDigits("112345678"));
	}
	
	@Test
	public void r3Respected(){
		//act
		int valid = mySudoku.r3("417369825632158947958724316825437169791586432346912758289643571573291684164875293");
		//assert
		assertEquals(0,valid);
		
		
	}
	
	@Test
	public void r2Respected(){
		//act
		int valid = mySudoku.r2("417369825632158947958724316825437169791586432346912758289643571573291684164875293");
		//assert
		assertEquals(0,valid);
		
		
	}

}
