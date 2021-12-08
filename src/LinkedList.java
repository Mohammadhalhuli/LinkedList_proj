//Mohammad hlhwly -1191413
public class LinkedList<T extends Comparable<T>> {
	sNode<T> head;

	public sNode<T> getHead() {
		return head;
	}

	public void setHead(sNode<T> head) {
		this.head = head;
	}

	public void traverse() {
		sNode<T> curr = head;
		System.out.print("Head-->");
		while (curr != null) {
			System.out.print(curr);
			curr = curr.getNext();
		}
		System.out.println("Null");
	}

	public String insert(T data) {
		try {
		sNode<T> newNode = new sNode<>(data);
		if (head == null)
			head = newNode;
		else {
			// define two node Directs Linked list 
			sNode<T> prev = null, curr = head;
			for (; (curr != null)
					&& (newNode.getData().compareTo(curr.getData()) < 0); prev = curr, curr = curr.getNext())
				;

			if (prev != null)
				prev.setNext(newNode);
			else
				head = newNode;
			newNode.setNext(curr);
			return "Done";
		}
		}catch (Exception e) {
			System.out.println("Error");
			// TODO: handle exception
		}
		return null;
	}


	//Deleat for Data
	public boolean delete(T data) {
		try {
		// here to test if list  is empty or not 
		if (head != null) {
			// define two node ( target  , prev) Directs Linked list 
			sNode<T> target = new sNode<>(data);
			sNode<T> prev = null, curr = head;
			boolean exist = false; 
			//The process of comparing higher values
			for (; curr != null; prev = curr, curr = curr.getNext()) {
				if (target.getData().equals(curr.getData())) {
					exist = true;
					break;
				}
			}

			if (exist) {
				if (curr == head)
					head = head.getNext();
				else
					prev.setNext(curr.getNext());
				return true;
			}

		}
		}catch (Exception e) {
			System.out.println("Error");
			// TODO: handle exception
		}
		return false;
	}

	//Search for Data
	public sNode<T> find(T data) {
		try {
		sNode<T> target = new sNode<>(data);
		sNode<T> curr = head;
		boolean exist = false;
		//The process of comparing higher values
		for (; curr != null; curr = curr.getNext()) {
			if (target.getData().equals(curr.getData())) {
				exist = true;
				break;//Stop 
			}
		}
		if (exist)
			return curr;
		}catch (Exception e) {
			System.out.println("Error");
			// TODO: handle exception
		}
		return null;
	}

	
  // calculate the size for the list
	public int size() {	
		sNode curr = head;
		int size = 0; // set size equal zero
		// while  urent not equal 
		while (curr != null) {
			size++;
			curr = curr.getNext();
		}
		return size;
	}

	public String Topten(LinkedList<TRecord> linked) {
		//
		String str = null;//null So be empty before the start
		int length = 10;//top10
		//exist two node Directs Linked list
		sNode<TRecord> curr = linked.head;
		sNode<TRecord> current = linked.head;
		//
		int k =0;
		int u=9;//9 Now there is a value in curr
		while (k <u) {
			//next linked
			current = current.getNext();
			
		k++;
		}
		System.out.println( " the current  is "+ current.getNext().getData());
		//The process of comparing higher values
		//If there is a value from above and there is an instance of it, it is placed
		for (; current != null; current = current.getNext()) {
			if (current.getData().grade == current.getNext().getData().grade) {
				++length;
				//If nothing stops
			} else
				break;
		}
		if (head == null) {
			System.out.println("List is empty");
		}
			/**Print Top 10 */
			int i = 0;
			while(i < length) {
			str += curr.getData() + " \n "; 
			curr = curr.getNext();	//cur++
			i++;
		}
		return str;
	}
	

	public String Return(double elemant) {
		
		int count = 0; 
		sNode<T> curr = head; //
		//exist two node Directs Linked list 
		//Easy going for all values Linked list 
		while (curr != null) {
			//Check if is greater or equal to the value that was set
			if (((TRecord) curr.getData()).grade >= elemant) {
				//count+count
				count++;
			}
			//next linked list 
			curr = curr.getNext();
		}
		//Calculate the sum of numbers divided by the number of digits multiplied by a hundred and a hundred
		double percentage = (count / (double) size()) * 100;
		//print
		return "countre is" + count + "&& percentage" + percentage + "%";
	}
	
	
}
