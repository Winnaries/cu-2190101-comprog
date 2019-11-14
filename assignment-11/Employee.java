public class Employee {

    private static String company = "Tekkaden Co,Ltd.";
    private int id;
    private int salary;
    private String name;

    public Employee() {
        setId(1);
        setSalary(15000);
        setName("no one");
    }

    public Employee(int id, int salary, String name) {
        setId(id);
        setSalary(salary);
        setName(name);
    }

    public Employee(Employee employee) {
        setId(employee.getId());
        setSalary(employee.getSalary());
        setName(employee.getName());
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
        if (getSalary() == employee.getSalary()) return 0;
        return getSalary() > employee.getSalary() ? 1 : -1;
    }

    public void promote(int promotion) {
        setSalary(getSalary() + promotion);
    }

}
