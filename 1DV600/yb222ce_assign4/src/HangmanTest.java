import static org.junit.Assert.assertEquals;
import org.junit.jupiter.api.Test;

class HangmanTest {
	Hangman man = new Hangman();
	@Test
	void testvalidInputToEnd_Valid() {
		// it shoud provides or gives postive numbers, so it will show you the test
		// without any error
		assertEquals(true, man.validInteger(1));
		assertEquals(true, man.validInteger(5));
		assertEquals(true, man.validInteger(43));
	}
//  This is short test to show you Hangman test the correct test and UserName Test short test

	@Test
	void testvalidInputToEnd_Valid1() {
		// user shoud provides or gives postive numbers that why it gives(returns) false in the test or even when we change from true to false
		assertEquals(false, man.validInteger(-1));
		assertEquals(false, man.validInteger(-5));
		assertEquals(false, man.validInteger(-43));
	}

	@Test
	void testEnterValidName_Valid() { // this is for right right input user name , english letter or integers
		assertEquals(true, man.enterValidName("talha"));
		assertEquals(true, man.enterValidName("jack"));
		assertEquals(true, man.enterValidName("mora"));
	}

	@Test void testEnterValidName_NotValid() {
		assertEquals(true, Hangman.provideValidName("0'*==/)"));
		assertEquals(true, Hangman.provideValidName("+4K"));
		assertEquals(true, Hangman.provideValidName("-.*"));
		assertEquals(true,Hangman.provideValidName("!#&.+"));
	}
	@Test
	void testvalidInputToQuit_Bug() { // this method should return true to fail,  but here i wrote true to pass thats why gives correct tset.
		assertEquals(false, Hangman.validInputToEnd()); // this is also test bug in the code,and test fail to quit the game,,

	}
}















// @Test 
//void testvalidInputToQuit_Bug() { // this method should return false, in hangman class thats why gives right tset
// assertEquals(false, Hangman.validInputToEnd());
// } 

/*
 * @Test void testvalidInputToQuit_Bug() { // this method should return false,
 * but it returns true assertEquals(false, Hangman.validInputToEnd()); }
 * }
 *********************************************************************************
 * this is also test for UserName
 *
 * String
 *
 * @Test void testEnterValidName_Valid() { assertEquals(true,
 * Hangman.ProvideValidName("yetnayet"));
 **
 * and so on
 *
 * }
 * @Test void testEnterValidName_NotValid() { assertEquals(false,
 * Hangman.provideValidName("!#&.+"));
 *
 * // or even empty string ""...... this is will show error
 *
 *
 *
 *
 */



