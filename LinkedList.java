//Code by Samarth Dave
public class LinkedList<E> {
	LLNode<E> first, last;
	public LinkedList() {
		first = null;
		last = null;
	}
	public LinkedList(E data) {
		LLNode<E> newNode = new LLNode<E>(data);
		first = newNode;
		last = newNode;
	}
	public E getFirst() {
		if(first == null)
			return null;
		return first.getData();
	}
	public LLNode<E> getFirstNode() {
		return first;
	}
	public E getLast() {
		if(size() == 1)
			return first.getData();
		if(size() == 0)
			return null;
		return last.getData();
	}
	public LLNode<E> getLastNode() {
		return last;
	}
	public E removeFirst() {
		if(size() == 1)
			first = first.getNext();
		LLNode<E> theLink = first;
		if(!empty()) {
			first = first.getNext();
		} else {
			return null;
		}
		return theLink.getData();
	}
	public E removeLast() {
		if(size() > 1) {
			LLNode<E> theLink = first;
			int c = 0;
			while(c != size()-2) {
				if(theLink.getNext() == null) {
					return null;
				} else {
					theLink = theLink.getNext();
				}
				c++;
			}
			E data = theLink.getNext().getData();
			theLink.setNext(null);
			last = theLink;
			return data;
		} else if(size() == 1) {
			E data = first.getData();
			clear();
			return data;
		} else {
			return null;
		}
	}
	public void addFirst(E data) {
		LLNode<E> newFirst = new LLNode<E>(data);
		newFirst.setNext(first);
		first = newFirst;
		if(size() == 2) {
			last = getNode(size()-1);
			last.setNext(null);
		}
	}
	public void addLast(E data) {
		if(size() == 1) {
			last = new LLNode<E>(data);
			first.setNext(last);
			last.setNext(null);
			return;
		}
		if(!empty()) {
			LLNode<E> newLast = new LLNode<E>(data);
			LLNode<E> tempLast = new LLNode<E>(last.getData());
			LLNode<E> theLink = first;
			while(theLink.getNext() != null) {
				if(theLink.getNext() == last) {
					theLink.setNext(tempLast);
					tempLast.setNext(newLast);
					last = newLast;
					return;
				}
				theLink = theLink.getNext();
			}
		} else {
			first.setData(data);
			first.setNext(null);
		}
	}
	public void clear() {
		first = null;
		last = null;
	}
	public int size() {
		int c = 0;
		LLNode<E> theLink = first;
		while(theLink != null) {
			c++;
			theLink = theLink.getNext();
		}
		return c;
	}
	public boolean empty() {
		return size() == 0;
	}
	public E get(int x) {
		int c = 0;
		LLNode<E> theLink = first;
		if(!empty()) {
			while(c != x) {
				if(theLink.getNext() == null) {
					return null;
				} else {
					theLink = theLink.getNext();
				}
				c++;
			}
			return theLink.getData();
		} else {
			System.out.println("Empty linked list. Can't get anything");
			return null;
		}
	}
	public LLNode<E> getNode(int x) {
		int c = 0;
		LLNode<E> theLink = first;
		if(!empty()) {
			while(c != x) {
				if(theLink.getNext() == null) {
					return null;
				} else {
					theLink = theLink.getNext();
				}
				c++;
			}
			return theLink;
		} else {
			System.out.println("Empty linked list. Can't get anything");
			return null;
		}
	}
	public E remove(int x) {
		if(x < 0 || x > size()-1)
			return null;
		if(size() == 1 && x != 0)
			return null;
		LLNode<E> current = first, previous = first;
		int c = 0;
		while(c != x) {
			if(current.getNext() == null) {
				return null;
			} else {
				previous = current;
				current = current.getNext();
			}
			c++;
		}
		if(current == first) {
			first = first.getNext();
		} else {
			previous.setNext(current.getNext());
		}
		return current.getData();
	}
	public void add(int x, E data) {
		if(x < 0 || x > size()) {
			System.out.println("Enter a valid input.");
			return;
		}
		if(empty()) {
			addFirst(data);
		} else if(size() == 1) {
			if(x == 1) {
				addLast(data);
				System.out.println("\nAdded " + data + " at index " + x + ".");
				return;
			} else if(x == 0) {
				addFirst(data);
				System.out.println("\nAdded " + data + " at index 0.");
				return;
			}
			System.out.println("Invalid input.");
			return;
		} else {
			if(x == 0) {
				addFirst(data);
				System.out.println("\nAdded " + data + " at index 0.");
				return;
			} else if(x == size()) {
				addLast(data);
				System.out.println("\nAdded " + data + " at index " + x + ".");
				return;
			} else {
				E a = get(x);
				LLNode<E> addMe = new LLNode<E>(data);
				
				addMe.setNext(getNode(x+1));
				
				getNode(x-1).setNext(addMe);
				
				System.out.println("**" + getNode(x-1).getData() + "**");
				LLNode<E> f = new LLNode<E>(a);
				getNode(x).setNext(f);
				System.out.println("last one " + getLastNode().getData());
				return;
			}
		}
	}
	public E set(int x, E data) {
		if(!empty()) {
			if(x < 0 || x > size()-1)
				return null;
			int c = 0;
			LLNode<E> theLink = first;
			while(c != x) {
				if(theLink.getNext() == null) {
					return null;
				} else {
					theLink = theLink.getNext();
				}
				c++;
			}
			E old = theLink.getData();
			theLink.setData(data);
			return old;
		} else {
			System.out.println("\nThe list is empty. You can't set anything.");
			return null;
		}
	}
	public void print() {
		if(empty()) {
			System.out.println("\nThe list is empty. There is no data.");
		} else {
			LLNode<E> theLink = first;
			System.out.print("\nThe data in the list is: [");
			while(theLink != null) {
				if(theLink.getNext() == null) {
					System.out.print(theLink.getData() + "].\n");
				} else {
					System.out.print(theLink.getData() + ", ");
				}
				theLink = theLink.getNext();
			}
		}
	}
}