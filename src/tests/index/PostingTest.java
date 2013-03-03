package tests.index;

import static org.junit.Assert.*;
import index.Posting;
import index.PostingEntry;

import org.junit.Test;

public class PostingTest {

	@Test
	public void addDoc() {
		int docID = 0;
		
		Posting p = new Posting();
		p.addDoc(docID);
		
		assertEquals("Adding docID", true, p.getDocList().contains(new PostingEntry(docID) ));
	}

}
