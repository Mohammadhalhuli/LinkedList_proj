
//Mohammad hlhwly -1191413
public class TRecord implements Comparable<TRecord>{
	//vare
	long seatNum;
	float grade;
	static String branch;
	public TRecord(String line) {

		int firstQ = line.indexOf(',');
		int secondQ = line.lastIndexOf(',');
		seatNum = Long.parseLong(line.substring(0,firstQ).trim());
		branch = (line.substring(firstQ+1, secondQ).trim());
		grade = Float.parseFloat(line.substring(secondQ+1).trim());
		
	}
	//to String
	public String toString() {		
		return seatNum+","+branch+","+grade;
	}

	@Override
	public int compareTo(TRecord o) {
		if(grade-o.grade ==0)
			return 0;
		else if(grade-o.grade > 0)
			return 1;
		return -1;
	}
	
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof TRecord)
		   return seatNum == ((TRecord)obj).seatNum;
		return false;
	}
}