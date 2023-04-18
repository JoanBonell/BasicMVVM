package cat.udl.hyperion.appmobils.basicmvvm.model;

public class MyDataModel {
    private String name;
    private int age;

    public MyDataModel(String name, int age){
        this.name = name;
        this.age = age;
    }

    //Getters and setters

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
