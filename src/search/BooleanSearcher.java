package search;

import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import index.Index;
import index.Indexer;
import index.Posting;
import index.PostingEntry;
import index.Tokenizer;

/**
 * @author ameertawfik
 *
 */

public class BooleanSearcher {

	Index index;
	
	public BooleanSearcher(Index index)
	{
		this.index = index;
	}
	
	
	/**
	 * Search indexed documents using boolean model. \br
	 * This method assumes a logical And operator between the query keywords.
	 * @param query
	 * @return Posting object that represents the list of documents that contain all keywords. \br
	 *         If there are no documents that contain all keywords, a null is returned.
	 */
	public Posting search(String query)
	{
		String[] keywords = Tokenizer.tokenize(query);
		List<Posting>postings = new LinkedList<>();
		
		for (int i = 0; i < keywords.length; i++)
		{
			postings.add(index.getPosting(keywords[i]));
		}
		
		return merge(postings);
	}
	
	
	/**
	 * Get the intersection between a list of postings
	 * @param postings is a list of postings to be merged
	 * @return A posting of all common documents in all postings or null if there are no common elements.
	 */
	public Posting merge(List<Posting> postings)
	{
		Collections.sort(postings);
		
		
		Iterator<Posting> pItr = postings.iterator();
		Posting answer = pItr.next();
		
		while(pItr.hasNext())
		{
			answer = merge(answer,pItr.next());
			
			if (answer == null)
				return null;
		}
		
		return answer;
	}
	
	
	/**
	 * Get the intersection between postings p1 and p2. It assumes p1 to have less or equal elements as compared to p2.
	 * @param p1 first posting objects
	 * @param p2 first posting object
	 * @return A posting of all common elements or null if no common elements.
	 */
	public Posting merge(Posting p1, Posting p2)
	{
		Iterator<PostingEntry> p1Itr = p1.getDocList().iterator();
		Iterator<PostingEntry> p2Itr = p2.getDocList().iterator();
		
		Posting answer = new Posting();
		
		PostingEntry pe1 = p1Itr.next();
		PostingEntry pe2 = p2Itr.next();
		
		while (pe1 != null && pe2 != null)
		{
			
			if (pe1.compareTo(pe2) == 0)
			{
				answer.addDoc(pe1.getDocID());
				pe1 = (p1Itr.hasNext())?p1Itr.next():null;
				pe2 = (p2Itr.hasNext())?p2Itr.next():null;
			} else if (pe1.compareTo(pe2) < 0){
				pe1 = (p1Itr.hasNext())?p1Itr.next():null;
			} else {
				pe2 = (p2Itr.hasNext())?p2Itr.next():null;
			}
				
		}
		
		
		return (answer.getDocList().size() > 0)?answer: null;
	}
}
