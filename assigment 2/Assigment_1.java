// Employee.java - Data Class (SRP)
class Employee {
    String name;
    double salary;

    Employee(String name, double salary) {
        this.name = name;
        this.salary = salary;
    }
}

// PaySlipPrinter.java - Handles Pay Slip Printing (SRP)
class PaySlipPrinter {
    void printPaySlip(Employee employee) {
        System.out.println("Employee: " + employee.name + ", Salary: $" + employee.salary);
    }
}

// EmployeeRepository.java - Interface for Storage (OCP)
interface EmployeeRepository {
    void save(Employee employee);
}

// DatabaseEmployeeRepository.java - Database Storage Implementation (OCP)
class DatabaseEmployeeRepository implements EmployeeRepository {
    @Override
    public void save(Employee employee) {
        System.out.println("Saving " + employee.name + " to database...");
    }
}

// FileEmployeeRepository.java - File Storage Implementation (OCP)
class FileEmployeeRepository implements EmployeeRepository {
    @Override
    public void save(Employee employee) {
        System.out.println("Saving " + employee.name + " to file...");
    }
}

// Main.java - Application Entry Point
public class Assigment_1 {
    public static void main(String[] args) {
        // Creating an employee
        Employee employee = new Employee("John Doe", 50000);

        // Printing pay slip
        PaySlipPrinter printer = new PaySlipPrinter();
        printer.printPaySlip(employee);

        // Saving to Database
        EmployeeRepository dbRepository = new DatabaseEmployeeRepository();
        dbRepository.save(employee);

        // Saving to File
        EmployeeRepository fileRepository = new FileEmployeeRepository();
        fileRepository.save(employee);
    }
}
