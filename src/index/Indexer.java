package index;

import java.util.HashMap;

import java.util.Map;

public class Indexer {
	Map<Term,Posting> dictionary;
	int currentDocID = 0;
	
	public Indexer()
	{
		dictionary = new HashMap<>();
	}
	
	public void add(String token , int docID)
	{
	  	Term term = new Term(token);
	  	Posting posting = dictionary.get(term);
	  	
	  	if (!dictionary.containsKey(term))
	  	{
	  		posting = new Posting();
	  	}
	  	
	  	posting.addDoc(docID);
	  	dictionary.put(term, posting);
	}
	
	public void index(String document)
	{
		int docID = currentDocID++;
		
		for (String token : Tokenizer.tokenize(document))
		{
			add(token, docID);
		}
	}
	
}
