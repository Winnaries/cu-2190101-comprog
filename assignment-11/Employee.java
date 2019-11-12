public class Employee {

    private static String company = "Tekkaden Co,Ltd.";
    private int id;
    private int salary;
    private String name;

    public Employee() {
        this.id = 1;
        this.salary = 15000;
        this.name = "no one";
    }

    public Employee(int id, int salary, String name) {
        this.id = id;
        this.salary = salary;
        this.name = name;
    }

    public Employee(Employee employee) {
        this.id = employee.id;
        this.salary = employee.salary;
        this.name = employee.name;
    }

    public int getId() { return this.id; }
    public void setId(int n) { this.id = Math.max(n, 0); }

    public int getSalary() { return this.salary; }
    public void setSalary(int n) { this.salary = Math.max(n, 0); }

    public String getName() { return this.name; }
    public void setName(String s) { this.name = s; }

    public String getCompany() { return Employee.company; }
    public void setCompany(String s) { Employee.company = s; }

    public String toString() {
        return "(Company: " + getCompany()
                + ", ID: " + getId()
                + ", Salary: " + getSalary()
                + ", Name: " + getName()
                + ")";
    }

    public int compareTo(Employee employee) {
        if (this.salary == employee.salary) return 0;
        return this.salary > employee.salary ? 1 : -1;
    }

    public void promote(int promotion) {
        this.salary += promotion;
    }

}
