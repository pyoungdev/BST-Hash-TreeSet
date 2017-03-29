// UseData.java
import java.io.*;
public class UseData {

	public static void main(String[] args) {
		Data data = new Data();
		data.name = "Example";
		data.size = data.name.length();
		data.cell = new Cell(17);
		try {
			FileOutputStream fos = new FileOutputStream("data.ser");
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(data);
			oos.close();
		} catch (Exception e) {
			e.printStackTrace();	
		}
		try {
			FileInputStream fos = new FileInputStream("data.ser");
			ObjectInputStream ois = new ObjectInputStream(fos);
			Data copy = (Data) ois.readObject();
			ois.close();
			System.out.println(copy);
		} catch (Exception e) {
			e.printStackTrace();	
		}
	}

}
