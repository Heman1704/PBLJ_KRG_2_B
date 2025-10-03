import java.util.HashMap;

class EmployeeNotFoundException extends Exception {
    public EmployeeNotFoundException(String message) {
        super(message);
    }
}

public class EmployeeManager {
    private HashMap<Integer, String> employees;

    public EmployeeManager() {
        employees = new HashMap<>();
    }

    public void addEmployee(int id, String name) {
        employees.put(id, name);
    }

    public String getEmployeeName(int id) throws EmployeeNotFoundException {
        if (!employees.containsKey(id)) {
            throw new EmployeeNotFoundException("Employee with ID " + id + " not found.");
        }
        return employees.get(id);
    }

    public static void main(String[] args) {
        EmployeeManager manager = new EmployeeManager();
        manager.addEmployee(101, "Alice");
        manager.addEmployee(102, "Bob");

        try {
            System.out.println(manager.getEmployeeName(101));
            System.out.println(manager.getEmployeeName(103));
        } catch (EmployeeNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }
}
