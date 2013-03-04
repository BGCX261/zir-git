package index;

public class PostingEntry implements Comparable<PostingEntry>{
	
	int docID;
	
	public int getDocID() {
		return docID;
	}


	public PostingEntry(int docID)
	{
		this.docID = docID;
	}
	
	
	@Override
	public int compareTo(PostingEntry o) {
		return Integer.compare(this.docID, o.docID);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + docID;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PostingEntry other = (PostingEntry) obj;
		if (docID != other.docID)
			return false;
		return true;
	}
	
	
}
