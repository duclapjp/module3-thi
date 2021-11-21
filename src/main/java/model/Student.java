package model;

public class Student {
    private int id;
    private String name;
    private String classId;

    public Student() {
    }

    public Student(int id, String name, String classId) {
        this.id = id;
        this.name = name;
        this.classId = classId;
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

    public String getClassId() {
        return classId;
    }

    public void setClassId(String classId) {
        this.classId = classId;
    }
}
