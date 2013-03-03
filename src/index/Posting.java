package index;

import java.util.LinkedList;
import java.util.List;

public class Posting {
  List<PostingEntry> docList;
  
  public Posting()
  {
	  docList = new LinkedList<>();
  }
  
  public void addDoc(int docID)
  {
	  PostingEntry entry = new PostingEntry(docID);
      docList.add(entry);
  }
  
  public List<PostingEntry> getDocList()
  {
	  return docList;
  }
}
