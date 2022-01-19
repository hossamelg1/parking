package entities;

public class Section {
	private int id;
	private String ref;
	private int idEtage;
	private static int count =0;
	
	public Section(int id, String ref, int idEtage) {
		super();
		this.id = id;
		this.ref = ref;
		this.idEtage = idEtage;
	}
	
	public Section(String ref, int idEtage) {
		super();
		this.id = ++count;
		this.ref = ref;
		this.idEtage = idEtage;
	}

    public int getId() {
        return id;
    }

    public String getRef() {
        return ref;
    }

    public int getIdEtage() {
        return idEtage;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setRef(String ref) {
        this.ref = ref;
    }

    public void setIdEtage(int idEtage) {
        this.idEtage = idEtage;
    }

   
}
