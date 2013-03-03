package tests.index;

import static org.junit.Assert.*;
import index.PostingEntry;

import org.junit.Test;

public class PostingEntryTest {

	@Test
	public void compareTo() {
		PostingEntry p1 = new PostingEntry(1);
		PostingEntry p2 = new PostingEntry(2);
		PostingEntry p3 = new PostingEntry(2);
		
		assertEquals("Testing is less than", true, (p1.compareTo(p2) < 0));
		assertEquals("Testing is greater than", true, (p2.compareTo(p1)  > 0));
		assertEquals("Testing is equal to", true, (p3.compareTo(p2)  == 0));
	}

}
