//Code by Samarth Dave
import java.util.Scanner;
public class LinkedListMain {
	public static void main(String[]args) {
		System.out.println("Linked List by Samarth Dave");
		LinkedList<String> list = new LinkedList<>();
		Scanner s = new Scanner(System.in);
		int i = -1, q;
		String b = "";
		while(i != 0) {
			i = -1; q = -1;	b = "";
			System.out.printf("\n%20s\n1.  %-13s  2.  %-13s\n3.  %-13s  4.  %-13s", "-Menu-", "Size", "Print", "Print First", "Print Last");
			System.out.printf("\n5.  %-13s  6.  %-13s\n7.  %-13s  8.  %-13s", "Get Location", "Remove First", "Remove Last", "Remove X");
			System.out.printf("\n9.  %-13s  10. %-13s\n11. %-13s  12. %-13s", "Add First", "Add Last", "Insert", "Set X");
			System.out.printf("\n13. %-13s  14. %-13s\n0. %-13s\n", "Is Empty", "Clear", "Exit");
			i = validInt(s, "Enter selection: ");
			switch(i) {
				case 1:
					System.out.println("\nThe size if the list is " + list.size() + ".");
					break;
				case 2:
					list.print();
					break;
				case 3:
					if(list.getFirst() == null)
						System.out.println("\nThe list is empty. You can't get first.");
					else
						System.out.println("\nThe first item is: " + list.getFirst() + ".");
					break;
				case 4:
					if(list.getLast() == null)
						System.out.println("\nThe list is empty. You can't get last.");
					else
						System.out.println("\nThe last item is: " + list.getLast() + ".");
					break;
				case 5:
					if(!list.empty()) {
						q = validInt(s, "Enter a position you want to get: ");
						if(list.get(q) == null)
							System.out.println("\nError, enter a valid input.");
						else
							System.out.println("\nThe name at the position is: " + list.get(q) + ".");
					} else {
						System.out.println("\nThe list is empty. You can't get anything.");
					}
					break;
				case 6:
					b = list.removeFirst();
					if(b == null) {
						System.out.println("\nLooks like there was nothing to remove.");
					} else {
						System.out.println("\n" + b + " was removed from first.");
					}
					break;
				case 7:
					b = list.removeLast();
					if(b == null) {
						System.out.println("\nLooks like there was nothing to remove.");
					} else {
						System.out.println("\n" + b + " was removed from last.");
					}
					break;
				case 8:
					//remove x
					if(list.empty()) {
						System.out.println("\nThe list is empty. You can't remove anything.");
						break;
					}
					q = validInt(s, "Enter the position you want to remove: ");
					b = list.remove(q);
					if(b == null)
						System.out.println("\nError, enter a valid input.");
					else
						System.out.println("Successfully removed " + b + ".");
					break;
				case 9:
					//add first
					System.out.print("\nEnter a name: ");
					b = s.nextLine();
					list.addFirst(b);
					System.out.println("\n" + b + " was added to first.");
					break;
				case 10:
					//add last
					System.out.print("\nEnter a name: ");
					b = s.nextLine();
					list.addLast(b);
					System.out.println("\n" + b + " was added to last.");
					break;
				case 11:
					//insert
					if(list.empty()) {
						System.out.print("\nThe list is empty. Enter value to add at 0: ");
						b = s.nextLine();
						list.addFirst(b);
					} else {
						q = validInt(s, "The the location you want to add: ");
						if(q < 0 || q > list.size()) {
							System.out.println("\nInvalid input.");
							break;
						}
						System.out.print("Enter the string you want to add: ");
						b = s.nextLine();
						list.add(q, b);
					}
					break;
				case 12:
					//set x
					if(list.empty()) {
						System.out.println("\nList is empty. You can't set in an empty list.");
					} else {
						q = validInt(s, "Enter the location you want to set: ");
						if(q < 0 || q > list.size()-1) {
							System.out.println("\nInvalid index.");
						} else {
							System.out.print("Enter the value you want to set: ");
							b = s.nextLine();
							System.out.println("\n" + list.set(q, b) + " was replaced with " + b + ".");
						}
					}
					break;
				case 13:
					if(list.empty())
						System.out.println("\nThe list is empty.");
					else
						System.out.println("\nThe list is not empty.");
					break;
				case 14:
					list.clear();
					System.out.println("\nThe list has been emptied.");
					break;
			}
			
		}
		s.close();
	}
	public static int validInt(Scanner s, String out) {
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
}