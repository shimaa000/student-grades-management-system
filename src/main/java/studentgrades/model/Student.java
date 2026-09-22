package studentgrades.model;

public class Student {
    private String id;
    private String name;
    private String major;

    public Student(String id, String name, String major) {
        this.id = id;
        this.name = name;
        this.major = major;
    }

    public String getId() { return id; }
    public String getName() { return name; }
    public String getMajor() { return major; }
}
