package index;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

import java.util.Map;

public class Indexer {
	Index index;
	public Indexer()
	{
	  this.index = new Index();
	}
	
	public Indexer(Index index)
	{
		this.index = index;
	}
	
	public void add(String token , int docID)
	{
	  	Term term = new Term(token);
	  	Posting posting = null;
	  	
	  	if (!index.dictionary.containsKey(term))
	  	{
	  		posting = new Posting();
	  		index.postings.add(posting);
	  		index.dictionary.put(term, posting);
	  	} else{ 
	  		posting = index.dictionary.get(term);
	  	}
	  	
	  	posting.addDoc(docID);
	  	term.freq = posting.getDocList().size();
	  	
	}
	
	public void index(String document)
	{
		int docID = index.currentDocID++;
		
		for (String token : Tokenizer.tokenize(document))
		{
			add(token, docID);
		}
	}
}
