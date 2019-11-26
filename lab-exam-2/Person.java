public class Person {

    protected String name;
    protected int age;

    public Person(String name, int age) {
        setName(name);
        setAge(age);
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getAge() {
        return this.age;
    }

    public boolean isOlder(Person p) {
        return getAge() > p.getAge();
    }

    public String toString() {
        return getName() + ", " + getAge();
    }

}
