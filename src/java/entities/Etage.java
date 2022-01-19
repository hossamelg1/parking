package entities;

public class Etage {
	private int id;
	private int rank;
	private String nameParking;
	public static int count = 0;
	
	public Etage(int id, int rank, String nameParking) {
		super();
		this.id = id;
		this.rank = rank;
		this.nameParking = nameParking;
	}
	
	public Etage(int rank, String nameParking) {
		super();
		this.id = ++count;
		this.rank = rank;
		this.nameParking = nameParking;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getRank() {
		return rank;
	}

	public void setRank(int rank) {
		this.rank = rank;
	}

	public String getNameParking() {
		return nameParking;
	}

	public void setIdParking(String nameParking) {
		this.nameParking = nameParking;
	}
	

}
