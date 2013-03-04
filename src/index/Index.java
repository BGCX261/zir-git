package index;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Index {

	Map<Term,Posting> dictionary;
	List<Posting> postings;
	
	int currentDocID = 0;

	public Index()
	{
		dictionary = new HashMap<>();
		postings = new LinkedList<>();
	}
	
	public Posting getPosting(Term term)
	{
		return dictionary.get(term);
	}
	
	public Posting getPosting(String token)
	{
		return getPosting(new Term(token));
	}
}
