//Mohammad hlhwly -1191413
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;

public class Test<T> {
	static sNode head;
	static LinkedList<TRecord> lStudents = new LinkedList<TRecord>();
	static LinkedList<TRecord> sStudents = new LinkedList<TRecord>();
	public static void main(String[] args) throws IOException  {
		

		File myfile = new File("Gaza_2019.csv");
		System.out.println(myfile.exists());
		
			
			
				Scanner scan = new Scanner(myfile);
				while (scan.hasNextLine()) {
					
					TRecord rec = new TRecord(scan.nextLine());
					if (rec.branch.equals("Scientific")) {
						sStudents.insert(rec);
					} else
						lStudents.insert(rec);
 
				}
				Path fileName = Path.of("demo.txt");
		        String content  = "hello world !! mmmmm";
		        Files.writeString(fileName, content);
		        System.out.println();
//		  sStudents.Return(99.6);
		 // System.out.println("the count "+x);
//		  lStudents.insert(new TRecord("31102105,Literary ,68.9"));
//		  lStudents.traverse();
//		  lStudents.Topten(lStudents);
//		  lStudents.traverse();
//		  System.out.println("the head is "+sStudents.head);
//		  sStudents.insert(new TRecord("31102109,67.6,Scientific"));
//		  sStudents.delete(new TRecord("31102109,Scientific,67.6"));
//		  System.out.println("the value is : "+sStudents.find1(new TRecord("34156255,Scientific,62.9") ));
//		  System.out.println(variance(lStudents));
//		  System.out.println(variance(sStudents)); 
//		  System.out.println("the mode is "+mode(sStudents)); 
//		  System.out.println("the mode is "+mode(lStudents));
//		  System.out.println("the mean is "+mean(sStudents));
//		  System.out.println("the mean is "+ mean(lStudents));
		  System.out.println("the medean is "+ median(lStudents));
		  System.out.println("the medean is "+ median(sStudents));
//		  System.out.println();lStudents.Topten(lStudents);
				lStudents.Topten(lStudents);
	}
	
	public static double mean(LinkedList<TRecord> records) {

		sNode<TRecord> curr = records.head;
		double sum = 0, num = 0, count = 0, mean;

		while (curr != null) {
			num = (curr.getData()).grade;
			sum += num;
			count++;
			curr = curr.getNext();
		}
		mean = sum / count;
		return mean;

	}
	//////////////////////////////////////////////////////////////
	public static float mode(LinkedList<TRecord> records) {
		float maxValue = 0;
		int maxCount = 0,size = records.size();
		sNode<TRecord> curr1 = records.head;
		for (int i = 0; i < size; i++) {
			sNode<TRecord> curr2 = records.head;
			int count = 0;
			for (int j = 0; j < size; ++j) {
		         if (((TRecord) curr2.getData()).grade == ((TRecord) curr1.getData()).grade)
		         ++count;
		        curr2=curr2.getNext();
		      //   curr2.setNext(curr2.getNext());
		      }
		
			 if (count > maxCount) {
		         maxCount = count;
		         maxValue = ((TRecord) curr1.getData()).grade;
		      }
			 curr1=curr1.getNext();
		}
		 return maxValue;
	}
	//////////////////////////////////////////////////////////////
	public static String variance(LinkedList<TRecord> records) {
		sNode<TRecord> curr = records.head;
		double sum = 0, num = 0, count = 0, mean = mean(records);
		double variance = 0;

		while (curr != null) {
			num = (curr.getData()).grade;
			count++;
			variance = variance + Math.pow((num - mean), 2) / (double) count;
			curr = curr.getNext();
		}
		double standardDeviation = Math.sqrt(variance);
		return "the variance :  " + variance + " and the stadred deviaton is : " + standardDeviation;

	}
	//////////////////////////////////////////////////////////////
	public static void add(LinkedList<TRecord> records) {

		sNode<TRecord> newNode = records.head;
		if (head == null)
			head = newNode;
		else {
			sNode prev = null, curr = head;
			for (; (curr != null)
					&& (newNode.getData().compareTo((TRecord) curr.getData()) > 0); prev = curr, curr = curr.getNext())
				;

			if (prev != null)
				prev.setNext(newNode);
			else
				head = newNode;
			newNode.setNext(curr);
		}

	}
	//////////////////////////////////////////////////////////////
	public static double median(LinkedList<TRecord> records) {
		sNode curr = records.head;
		int count = 0;
		int size = (size(records) / 2);
		System.out.println(size);
		if (size(records) % 2 == 1) {
			while (count < size) {
				curr = curr.getNext();
				count++;
			}
			return ((TRecord) curr.getData()).grade;
		} else {

			while (count < size) {
				curr = curr.getNext();
				count++;
			}
			return (double) (((TRecord) (curr.getData())).grade
					+ ((TRecord) (curr.getNext().getData())).grade) / 2;
		}
	}
/*	public static sNode<TRecord> median(LinkedList<TRecord> records) {
		int length = 0;
		sNode<TRecord> n=head;
		while(n != null) {
			++length;
			n=n.getNext();
		}
		sNode<TRecord> curr = records.head;
		int count=0;
		int size=length/ 2;
		if (length % 2 == 1) {
			while(count < size) {
				curr=curr.Next;
				count++;
			
		}
			return curr;
		}
		else {
			return curr ;
		}
//	   halfLength = length/2;
//   while (curr. < halfLength) {
//       curr=curr.getNext();
//   return curr;
	}*/
	//////////////////////////////////////////////////////////////
	public static int size(LinkedList list) {
		sNode curr =list.head;
		int size = 0;
		while (curr != null) {
			size++;
			curr = curr.getNext();
		}
		return size;
	}
	///////////////////////////////////////////////////////////////
	private static void readmyfile(Scanner in) {

		if (in.hasNext()) {
			TRecord c = new TRecord(in.nextLine());
			lStudents.insert(c);
			readmyfile(in);
		}

	}
	///////////////////////////////////////////////////////////////
}
