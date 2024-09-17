import java.util.ArrayList;
import java.util.List;

abstract class Employee{

    private String name;
    private int id;

    public Employee(String name, int id ){
        this.name = name;
        this.id = id;
    }

    public String getName(){
        return name;
    }

    public int getId(){
        return id;
    }

    public abstract double calculateSalary();

    public String toString(){
        return "Employee [Name=" + name + ", Id=" +id+ ", Salary=" + calculateSalary()+ "]";
    }
}

class FullTimeEmployee extends Employee{

    private double monthlySalary;

    public FullTimeEmployee(String name, int id, double monthlySalary) {
        super(name, id);
        this.monthlySalary = monthlySalary;
    }

    @Override
    public double calculateSalary(){
        return monthlySalary;
    }
}

class PartTimeEmployee extends Employee{

    private int hoursWorked;
    private double hourlyRate;

    public PartTimeEmployee(String name, int id, int hoursWorked, double hourlyRate){
        super(name, id);
        this.hoursWorked = hoursWorked;
        this.hourlyRate = hourlyRate;
    }

    @Override
    public double calculateSalary(){
        return hoursWorked * hourlyRate;
    }

}

class PayrollSystem{

    private List<Employee> employeeList;

    public PayrollSystem(){
        employeeList = new ArrayList<>();
    }

    public void addEmployee(Employee employee){
        employeeList.add(employee);
    }

    public void removeEmployee(int id){
        Employee empRemove = null;

        for (Employee emp: employeeList) {
            if(emp.getId() == id){
                empRemove = emp;
                break;
            }
        }

        if(empRemove != null){
            employeeList.remove(empRemove);
        }
    }

    public void display(){
        for (Employee employee:employeeList) {
            System.out.println(employee);
        }
    }
}

public class Main {
    public static void main(String[] args) {
        PayrollSystem payrollSystem = new PayrollSystem();
        FullTimeEmployee emp1 = new FullTimeEmployee("Swapnil", 1, 100000);
        PartTimeEmployee emp2 = new PartTimeEmployee("Aman", 2, 50, 500);

        payrollSystem.addEmployee(emp1);
        payrollSystem.addEmployee(emp2);

        System.out.println("Employee Details: ");
        payrollSystem.display();

        payrollSystem.removeEmployee(2);
        System.out.println("Employee removed successfully.");

        System.out.println("Employee Details: ");
        payrollSystem.display();

    }

    }
