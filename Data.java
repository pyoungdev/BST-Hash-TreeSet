import java.io.*;
public class Data implements Serializable {
	int size = 0;
	String name;
	transient Cell cell;
	private static final long serialVersionUID = 1234567890L;
	public String toString() {
		return "Data: name = " + name + ", size = " + size
		   + ", cell = " + cell;
	}
	private void writeObject(ObjectOutputStream os) {
		try {
			os.defaultWriteObject();
			os.writeInt(cell.getNumber());
		} catch (Exception e) {e.printStackTrace();}
	}
	private void readObject(ObjectInputStream is) {
		try {
			is.defaultReadObject();
			cell = new Cell(is.readInt());
		} catch (Exception e) {e.printStackTrace(); }		
	}
}

