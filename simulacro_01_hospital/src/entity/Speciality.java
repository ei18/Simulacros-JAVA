package entity;

public class Speciality {
    private int id;
    private String name;
    private String description;

    public Speciality(String name, String description) {

        this.name = name;
        this.description = description;
    }

    public Speciality() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return
                "name: " + name + ',' +
                " description: " + description + "\n" +
                "------------------------------";
    }
}
