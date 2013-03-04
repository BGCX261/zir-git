package tests.search;

import static org.junit.Assert.*;

import java.util.LinkedList;
import java.util.List;

import index.Index;
import index.Indexer;
import index.Posting;

import org.junit.Test;

import search.BooleanSearcher;

public class BooleanSearcherTest {

	@Test
	public void mergeTwoPosting() {
		Posting p1 = new Posting();
		p1.addDoc(0);
		p1.addDoc(1);
		p1.addDoc(2);
		
		Posting p2 = new Posting();
		p2.addDoc(0);
		p2.addDoc(1);
		
		Posting p3 = new Posting();
		p3.addDoc(4);
		p3.addDoc(6);
		
		
		Index mockIndex = new Index();
		BooleanSearcher searcher = new BooleanSearcher(mockIndex);
		Posting answer = searcher.merge(p2, p1);
		
		assertEquals(answer.getDocList().get(0).getDocID(), 0);
		assertEquals(answer.getDocList().get(1).getDocID(), 1);
		
		
       answer = searcher.merge(p2, p3);
		
		assertEquals(true, answer == null);
	}
	
	@Test
	public void mergeMultiplePosting()
	{
		Posting p1 = new Posting();
		p1.addDoc(0);
		p1.addDoc(1);
		p1.addDoc(2);
		
		Posting p2 = new Posting();
		p2.addDoc(0);
		p2.addDoc(1);
		
		
		Posting p3 = new Posting();
		p3.addDoc(1);
		
		Posting p4 = new Posting();
		p4.addDoc(0);
		
		List<Posting> p1List = new LinkedList<>();
		p1List.add(p1);
		p1List.add(p2);
		p1List.add(p3);
		
		
		Index mockIndex = new Index();
		BooleanSearcher searcher = new BooleanSearcher(mockIndex);
		Posting answer = searcher.merge(p1List);
		
		assertEquals(answer.getDocList().get(0).getDocID(), 1);
		assertEquals(answer.getDocList().size(), 1);
		
		p1List.add(p4);
        answer = searcher.merge(p1List);
		
		assertEquals(true, answer == null);
	}

	@Test
	public void search()
	{
		String d1 = "this text about text mining";
		String d2 = "this text is about social network";
		String d3 = "this text is about data mining";
		
		Index index = new Index();
		Indexer indexer = new Indexer(index);
		indexer.index(d1);
		indexer.index(d2);
		indexer.index(d3);
		
		BooleanSearcher searcher = new BooleanSearcher(index);
		Posting answer = searcher.search("text mining");
		
		assertEquals(answer.getDocList().size(), 2);
		assertEquals(answer.getDocList().get(0).getDocID(), 0);
		assertEquals(answer.getDocList().get(1).getDocID(), 2);
	}
}
