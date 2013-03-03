package tests.index;

import static org.junit.Assert.*;
import index.Tokenizer;

import org.junit.Test;

public class TokenizerTest {

	@Test
	public void tokenize() 
	{
		String text = "This is a simple white space tokenizer of english text.";
		
		String[] tokens = Tokenizer.tokenize(text);
		String[] words = text.split("\\s");
		
		assertArrayEquals("Testing whgit space tokenization", words, tokens);
	}

}
