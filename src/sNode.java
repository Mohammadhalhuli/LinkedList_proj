//Mohammad hlhwly -1191413
public class sNode<T extends Comparable<T>>{
	private T Data;
	protected sNode<T> Next;
	public sNode(T Data) {
		this.Data=Data;
	}
	/**return T*/
	public T getData() {
		return Data;
	}
	public void setData(T data) {
		Data = data;
	}
	/**return sNode*/
	public sNode<T> getNext() {
		return Next;
	}
	public void setNext(sNode<T> next) {
		Next = next;
	}
	//toString
	@Override
	public String toString() {		
		return "[ " +Data+ "]-->";
	}
}
