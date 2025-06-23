public class StudentEntity {
    private int id;
    private String name;

    public StudentEntity(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public StudentEntity(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}