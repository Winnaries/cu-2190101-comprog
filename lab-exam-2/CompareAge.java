public class CompareAge {

    public static void main(String[] args) {
        Person person1 = new Person("Junior", 15);
        Person person2 = new Person("Jame", 25);
        System.out.println(person1.toString());
        System.out.println(person2.toString());
        if (person1.isOlder(person2)) System.out.println(person1.getName());
        else System.out.println(person2.getName());
    }

}
