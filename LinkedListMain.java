//Code by Samarth Dave
import java.util.Scanner;
public class LinkedListMain {
	static Scanner s;
	public static void main(String[]args) {
		System.out.println("Linked List by Samarth Dave");
		LinkedList<String> list = new LinkedList<>();
		s = new Scanner(System.in);
		int i, q;
		do {
			i = -1; q = -1;
			System.out.printf("\n%20s\n1.  %-13s  2.  %-13s\n3.  %-13s  4.  %-13s", "-Menu-", "Size", "Print", "Print First", "Print Last");
			System.out.printf("\n5.  %-13s  6.  %-13s\n7.  %-13s  8.  %-13s", "Get Location", "Remove First", "Remove Last", "Remove X");
			System.out.printf("\n9.  %-13s  10. %-13s\n11. %-13s  12. %-13s", "Add First", "Add Last", "Insert", "Set X");
			System.out.printf("\n13. %-13s  14. %-13s\n0. %-13s\n", "Is Empty", "Clear", "Exit");
			i = validInt("Enter selection: ");
			switch(i) {
				case 1:
					//size
					out("The size if the list is " + list.size() + ".");
					break;
				case 2:
					//print
					out("The data in the linked list is: " + list + ".");
					break;
				case 3:
					//print first
					if(list.empty())
						out("The list is empty. You can't get first.");
					else
						out("The first item in the list is: " + list.getFirst() + ".");
					break;
				case 4:
					//print last
					if(list.empty())
						out("The list is empty. You can't get last.");
					else
						out("The last item in the list is: " + list.getLast() + ".");
					break;
				case 5:
					//get location
					if(list.empty()) {
						out("The list is empty. You can't get.");
						break;
					}
					int d = validInt("Enter the index you want: ");
					if(d < 0 || d > list.size()-1)
						out("Error, out of bounds.");
					else
						out("The value at index " + d + " is " + list.get(d) + ".");
					break;
				case 6:
					//remove first
					if(list.empty())
						out("The list is empty, you can't remove.");
					else
						out(list.removeFirst() + " was removed.");
					break;
				case 7:
					//remove last
					if(list.empty())
						out("The list is empty, you can't remove.");
					else
						out(list.removeLast() + " was removed.");
					break;
				case 8:
					//remove x
					if(list.empty()) {
						out("The list is empty. You can't remove.");
						break;
					}
					int e = validInt("Enter the index you want to remove: ");
					if(e < 0 || e > list.size()-1) {
						out("Error, out of bounds.");
						break;
					}
					out(list.remove(e) + " was removed.");
					break;
				case 9:
					//add first
					System.out.print("\nEnter a name: ");
					String b = s.nextLine();
					list.addFirst(b);
					out(b + " was added to first.");
					break;
				case 10:
					//add last
					System.out.print("\nEnter a name: ");
					String c = s.nextLine();
					list.addLast(c);
					out(c + " was added to last.");
					break;
				case 11:
					//insert
					int h = validInt("Enter the index you want to insert at: ");
					if(h < 0 || h > list.size()) {
						out("Error, out of bounds.");
						break;
					}
					System.out.print("\nEnter a name: ");
					String j = s.nextLine();
					list.add(h, j);
					out(j + " was added.");
					break;
				case 12:
					//set x
					if(list.empty()) {
						out("The list is empty. You can't set.");
						break;
					}
					int f = validInt("Enter the index you want to set: ");
					if(f < 0 || f > list.size()-1) {
						out("Error, out of bounds.");
						break;
					}
					System.out.print("\nEnter a replacement string: ");
					String g = s.nextLine();
					out(list.set(f, g) + " was replaced with " + g + ".");
					break;
				case 13:
					//is empty
					if(list.empty())
						out("The list is empty.");
					else
						out("The list is not empty.");
					break;
				case 14:
					//clear
					list.clear();
					out("The list has been emptied.");
					break;
			}
		} while(i != 0);
		s.close();
	}
	public static int validInt(String out) {
		int r = -1;
		System.out.print(out);
		while(!s.hasNextInt()) {
			System.out.print("Invalid input, try again: ");
			s.next();
		}
		r = s.nextInt();
		s.nextLine();
		return r;
	}
	public static void out(String s) {
		System.out.println("\n" + s);
	}
}