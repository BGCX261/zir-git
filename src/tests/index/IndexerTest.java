package tests.index;

import static org.junit.Assert.*;
import index.Index;
import index.Indexer;
import index.PostingEntry;
import index.Tokenizer;

import org.junit.Test;

public class IndexerTest {

	@Test
	public void add() {
		//two things should take place: the term is added and the docID is added to its list.
		// if a term is not new, then its posting should contains both docIDs.
		
		int docID1 = 1, docID2= 2;
		String word1 = "ameer", word2 = "ameer";
		
		Index index = new Index();
		Indexer indexer = new Indexer(index);
		indexer.add(word1, docID1);
		assertEquals("Testing adding a new term",true, index.getPosting(word1)!=null);
		assertEquals("Testing adding docID to the new term posting", 
				true, 
				index.getPosting(word1).getDocList().contains(new PostingEntry(docID1)));
		
		indexer.add(word1, docID2);
		assertEquals("Testing adding docID to the existing term posting", 
				true, 
				index.getPosting(word1).getDocList().contains(new PostingEntry(docID2)));
		assertEquals("Testing adding docID to the existing term posting", 
				true, 
				index.getPosting(word1).getDocList().size() == 2);
	}
	
	@Test
	public void index()
	{
		String d1 = "A simple text";
		String d2 = "Another text";
		
		Index index = new Index();
		Indexer indexer = new Indexer(index);
		indexer.index(d1);
		indexer.index(d2);
		
		// to test accuracy: the words following should have been added: "a", "simple", "text" and "another"
		
		assertEquals(true, index.getPosting("A") != null);
		assertEquals(true, index.getPosting("simple") != null);
		assertEquals(true, index.getPosting("text") !=null);
		assertEquals(true, index.getPosting("Another") !=null);
		assertEquals(false,index.getPosting("nothing") !=null);
		
		assertEquals(2, index.getPosting("text").getDocList().size());// the word "text" should have two posting entries
 
	}

}
