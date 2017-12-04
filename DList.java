package reminderApplication;

/**
 * @author Praveen Madiraju
 *
 */
public class DList<T> {

	protected DLLNode<T> header;
	protected DLLNode<T> trailer;

	protected int size;

	/**
	 * 
	 */
	public DList() {
		header = null;
		trailer = null;
		size = 0;

	}

	/**
	 * @return the header
	 */
	public DLLNode<T> getHeader() {
		return header;
	}

	/**
	 * @return the trailer
	 */
	public DLLNode<T> getTrailer() {
		return trailer;
	}

	/**
	 * @return the size
	 */
	public int getSize() {
		return size;
	}

	// add element to the front of the list
	public void addToFront(T elem) {
		DLLNode<T> newNode = new DLLNode<T>(elem);

		if (header == null) {
			header = newNode;
		}
		if (trailer == null)
			trailer = newNode;
		else {
			newNode.setLink(header);
			header.setBack(newNode);
			header = newNode;
		}
		size++;

	}

	// add element to the end of the list
	public void addToLast(T elem) {
		DLLNode<T> newNode = new DLLNode<T>(elem);
		newNode.setLink(null);

		if (trailer == null) {
			trailer = newNode;
			header = newNode;
		} else {
			trailer.setLink(newNode);
			newNode.setBack(trailer);
			trailer = newNode;
		}

		size++;
	}

	public boolean isEmpty() {
		return header == null;
	}
	
	  public String toString() {
		  DLLNode<T> node = header;
		  String result = "";
		  while(node!= null) {
			  result+=node.getInfo();
			  result+="<=>";
			  node = (DLLNode<T>)node.getLink();
		  }
		  result = result.substring(0,result.length()-3);
		  return result;
	  }

	public void print() {
		DLLNode<T> v = header;
		while (v != null) {
			System.out.println(v.getInfo());
			v = (DLLNode) v.getLink();
		}

	}
	
	//2)	Define a recursive method, boolean search (T element) in DList 
	//class that returns true if the element is 
	// found in the double linked list.
	
	public boolean search(T element) {
		return search (header,element);
	}
	
	
	private boolean search(DLLNode<T> node, T element) {
		if(node == null)
			return false;
		if(node.getInfo().equals(element))
			return true;
		else
			return search((DLLNode<T>) node.getLink(),element);
		
	}

	//Given the DList class, implement a void removeLast() method 
	//which removes the last node in the double linked list
	public void removeLast() {
		if (isEmpty()) 
			throw new IllegalStateException("cannot remove from empty DList");
		DLLNode<T> u = trailer.getBack();
		u.setLink(null);
		trailer = u;		
		size--;
	}
	
	// implement stack operations void push(T element) and T pop()
	
	public void push(T element) {
		DLLNode<T> newNode = new DLLNode<T>(element);
		addToLast(element);
	}
	
	public T pop() {
		return null;
	}
	
	
	

}