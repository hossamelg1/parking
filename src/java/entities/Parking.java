package entities;

public class Parking {
	private int id;
	private String quartier;
        private String name;
	private static int count =0;
	
	public Parking(int id,String name, String quartier) {
		super();
		this.id = id;
                this.name = name;
		this.quartier = quartier;
	}
	
	public Parking(String name, String quartier) {
		super();
		this.id = ++count;
		this.name = name;
		this.quartier = quartier;
	}

    public int getId() {
        return id;
    }
    public String getName() {
        return name;
    }

    public String getQuartier() {
        return quartier;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setQuartier(String quartier) {
        this.quartier = quartier;
    }
	
}
