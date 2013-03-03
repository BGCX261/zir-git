package index;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

import java.util.Map;

public class Indexer {
	Map<Term,Posting> dictionary;
	List<Posting> postings;
	
	int currentDocID = 0;
	
	public Indexer()
	{
		dictionary = new HashMap<>();
		postings = new LinkedList<>();
	}
	
	public void add(String token , int docID)
	{
	  	Term term = new Term(token);
	  	Posting posting = null;
	  	
	  	if (!dictionary.containsKey(term))
	  	{
	  		posting = new Posting();
	  		postings.add(posting);
	  		dictionary.put(term, posting);
	  	} else{ 
	  		posting = dictionary.get(term);
	  	}
	  	
	  	posting.addDoc(docID);
	  	
	}
	
	public void index(String document)
	{
		int docID = currentDocID++;
		
		for (String token : Tokenizer.tokenize(document))
		{
			add(token, docID);
		}
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
