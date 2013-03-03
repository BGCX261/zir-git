package tests.index;

import static org.junit.Assert.*;
import index.Term;

import org.junit.Test;

public class TermTest {

	@Test
	public void testHashCode()
	{
	  Term ameer = new Term("ameer");
	  assertEquals("Testing term has code as similar to its token hash code", ameer.hashCode() , "ameer".hashCode());
	}

}
