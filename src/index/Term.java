package index;


public class Term implements Comparable<Term> {
  @Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Term other = (Term) obj;
		if (token == null) {
			if (other.token != null)
				return false;
		} else if (!token.equals(other.token))
			return false;
		return true;
	}


String token;
  int freq;

  public Term(String token)
  {
	  this.token = token;
	  this.freq = 1;
  }
  
  @Override
  public int compareTo(Term o) {
	return Integer.compare(freq, o.freq);

  }
  
  @Override
public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + ((token == null) ? 0 : token.hashCode());
	return result;
}
  
  
  @Override
  public String toString()
  {
	  return token;
  }
}
