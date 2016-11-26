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
	public void r2Respected(){
		//act
		int valid = mySudoku.r2("417369825632158947958724316825437169791586432346912758289643571573291684164875293");
		//assert
		assertEquals(0,valid);	
	}
	
	@Test
	public void r3Respected(){
		//act
		int valid = mySudoku.r3("417369825632158947958724316825437169791586432346912758289643571573291684164875293");
		//assert
		assertEquals(0,valid);	
	}
	
	@Test
	public void r4Respected(){
		//act
		int valid = mySudoku.r4("417369825632158947958724316825437169791586432346912758289643571573291684164875293");
		//assert
		assertEquals(0,valid);	
	}
	
	@Test(expected = IncorrectSizeException.class)
	public void throwsExceptionWithIllegalSize() throws IncorrectSizeException{
		//act
		mySudoku.verify("58947958724316825437169791586432346912758289643571573291684164875293");	
	}
	
	@Test
	public void hasCorrectOutputIfR1NotRespected() throws IncorrectSizeException{
		//act
		int valid = mySudoku.verify("p17369825632158947958724316825437169791586432346912758289643571573291684164875293");
		//assert
		assertEquals(-1,valid);	
	}
	
	@Test
	public void hasCorrectOutputIfR2NotRespected() throws IncorrectSizeException{
		//act
		int valid = mySudoku.verify("447369825632158947958724316825437169791586432346912758289643571573291684164875293");
		//assert
		assertEquals(-2,valid);	
	}
	
	@Test
	public void hasCorrectOutputIfR3NotRespected() throws IncorrectSizeException{
		//act
		int valid = mySudoku.verify("317369825642158947958724316825437169791586432346912758289643571573291684164875293");
		//assert
		assertEquals(-3,valid);	
	}
	
	@Test
	public void hasCorrectOutputIfR4NotRespected() throws IncorrectSizeException{
		//act
		int valid = mySudoku.verify("417369825632158947958724316825437169791586432346912758289641573571293684364875291");
		//assert
		assertEquals(-4,valid);	
	}
	
	@Test
	public void hasCorrectOutputIfAllRawRespected() throws IncorrectSizeException{
		//act
		int valid = mySudoku.verify("417369825632158947958724316825437169791586432346912758289643571573291684164875293");
		//assert
		assertEquals(0,valid);	
	}
	
}
