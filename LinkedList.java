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
		if(last == null)
			return null;
		return last.getData();
	}
	public LLNode<E> getLastNode() {
		return last;
	}
	public E removeFirst() {
		if(size() == 1) {
			E temp = first.getData();
			clear();
			return temp;
		} else if(size() == 2) {
			E tempFirst = first.getData();
			E tempLast = last.getData();
			clear();
			addFirst(tempLast);
			return tempFirst;
		} else {
			E tempFirst = first.getData();
			first = first.getNext();
			return tempFirst;
		}
	}
	public E removeLast() {
		if(size() == 1) {
			E temp = first.getData();
			clear();
			return temp;
		} else if(size() == 2) {
			E tempLast = last.getData();
			E tempFirst = first.getData();
			clear();
			addFirst(tempFirst);
			return tempLast;
		} else {
			E tempLast = last.getData();
			LLNode<E> temp = first;
			while(temp.getNext() != last) {
				temp = temp.getNext();
			}
			temp.setNext(null);
			return tempLast;
		}
	}
	public void addFirst(E data) {
		if(first == null) {
			last = new LLNode<>(data);
			first = last;
		} else {
			LLNode<E> temp = new LLNode<>(data);
			temp.setNext(first);
			first = temp;
		}
	}
	public void addLast(E data) {
		if(last == null) {
			last = new LLNode<E>(data);
			first = last;
		} else {
			LLNode<E> temp = new LLNode<>(data);
			last.setNext(temp);
			last = temp;
		}
	}
	public void clear() {
		first = null;
		last = null;
	}
	public int size() {
		int c = 0;
		LLNode<E> temp = first;
		while(temp != null) {
			c++;
			temp = temp.getNext();
		}
		return c;
	}
	public boolean empty() {
		return size() == 0;
	}
	public E get(int x) {
		int c = 0;
		if(!empty()) {
			LLNode<E> temp = first;
			while(c != x) {
				if(temp.getNext() == null)
					return null;
				else
					temp = temp.getNext();
				c++;
			}
			return temp.getData();
		}
		return null;
	}
	public LLNode<E> getNode(int x) {
		int c = 0;
		LLNode<E> temp = first;
		if(!empty()) {
			while(c != x) {
				if(temp.getNext() == null) {
					return null;
				} else {
					temp = temp.getNext();
				}
				c++;
			}
			return temp;
		}
		return null;
	}
	public E remove(int x) {
		if(size() == 1 && x != 0)
			return null;
		if(x == 0)
			return removeFirst();
		if(x == size()-1)
			return removeLast();
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
			last = current.getNext();
		}
		return current.getData();
	}
	public void add(int x, E data) {
		if(x < 0 || x > size()) {
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
			int c = 0;
			LLNode<E> temp = first;
			while(c != x) {
				if(temp.getNext() == null) {
					return null;
				} else {
					temp = temp.getNext();
				}
				c++;
			}
			E old = temp.getData();
			temp.setData(data);
			return old;
		}
		return null;
	}
	public String toString() {
		if(empty())
			return "[]";
		StringBuilder sb = new StringBuilder();
		sb.append("[");
		LLNode<E> temp = first;
		while(temp != null) {
			sb.append(temp.getData());
			sb.append((temp.getNext() == null) ? "]" : ", ");
			temp = temp.getNext();
		}
		return sb.toString();
	}
}