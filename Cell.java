
class Cell {  // does not implement Serializable
	private int number;
	public Cell (int number) {
		this.number = number;
	}
	public int getNumber() {
		return number;
	}
	public String toString() {
		return "Cell: number = " + number;
	}
}

