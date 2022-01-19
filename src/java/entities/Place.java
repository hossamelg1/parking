package entities;

public class Place {

    private int id;
    private int ref;
    private int idSection;
    private boolean filled;
    public int filledCounter;

    private static int count = 0;

    public Place(int id, int ref, int idSection) {
        super();
        this.id = id;
        this.ref = ref;
        this.idSection = idSection;
    }
     public Place(int id, int ref,boolean filled, int idSection) {
        super();
        this.id = id;
        this.ref = ref;
        this.filled = filled;
        this.idSection = idSection;
    }
    
    public Place(int ref,boolean filled) {
        super();
        this.ref = ref;
        this.filled = filled;
    }
    
    public Place(int id, int ref, int idSection, boolean filled, int filledCounter) {
        super();
        this.id = id;
        this.ref = ref;
        this.idSection = idSection;
        this.filled = filled;
        this.filledCounter = filledCounter;
    }

    public void setFilled(boolean filled) {
        this.filled = filled;
    }
    
    
    public Place(int ref, int idSection) {
        super();
        this.id = ++count;
        this.ref = ref;
        this.idSection = idSection;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getRef() {
        return ref;
    }

    public void setFilledCounter(int filledCounter) {
        this.filledCounter = filledCounter;
    }

    public boolean isFilled() {
        return filled;
    }

    public int getFilledCounter() {
        return filledCounter;
    }

    
    
    public void setRef(int ref) {
        this.ref = ref;
    }

    public int getIdSection() {
        return idSection;
    }

    
    
    
    
    public void setIdSection(int idSection) {
        this.idSection = idSection;
    }

    public boolean getTaken() {
        return filled;
    }

    public void setTaken(int ref) {
        this.ref = ref;
    }

}
