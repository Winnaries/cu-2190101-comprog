public class MyCompany {

    public static void main(String[] args) {
        Employee employee1 = new Employee();
        Employee employee2 = new Employee(2, 30000, "Mika");
        System.out.println(employee1.toString());
        System.out.println(employee2.toString());
        employee1.setId(1);
        employee1.setName("Orga");
        employee1.setSalary(70000);
        if (employee1.compareTo(employee2) == -1) System.out.print("Employee2");
        else if (employee1.compareTo(employee2) == 0) System.out.print("No one");
        else System.out.print("Employee1");
        System.out.println(" has more salary.");
        Employee employee3 = new Employee(employee2);
        employee3.promote(40000);
        if (employee1.compareTo(employee3) == -1) System.out.print("Employee3");
        else if (employee1.compareTo(employee3) == 0) System.out.print("No one");
        else System.out.print("Employee1");
        System.out.println(" has more salary.");
        System.out.println(employee1.toString());
        System.out.println(employee2.toString());
        System.out.println(employee3.toString());
    }

}
