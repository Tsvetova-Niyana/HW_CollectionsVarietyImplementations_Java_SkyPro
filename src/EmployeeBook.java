import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class EmployeeBook {
    private final Map<String, Employee> employees;

    public EmployeeBook() {
        this.employees = new HashMap<>();
    }

    private String getKey(Employee employee) {
        return employee.getNameEmploy() + " " + employee.getPatronymNameEmploy() + " " + employee.getSurnameEmploy();
    }

    public void addEmployee(Employee employee) {
        employees.put(getKey(employee), employee);
    }

    public void addEmployee(String name,
                            String patronymName,
                            String surname,
                            int department,
                            double salary) {
        addEmployee(new Employee(name, patronymName, surname, department, salary));
    }

    public void removeEmployee(Employee employee) {
        employees.remove(getKey(employee));
    }

    public void removeEmployee(int id) {
        for (Map.Entry<String, Employee> entry : employees.entrySet()) {
            Employee employee = entry.getValue();
            String key = entry.getKey();
            if (employee.getIdEmploy() == id) {
                employees.remove(key);
                break;
            }
        }
    }

    public void changeSalary(Employee employee, double newSalary) {
        String key = getKey(employee);
        if (employees.containsKey(key)) {
            employees.get(key).setSalaryEmploy(newSalary);
        }
    }

    public void changeDepartment(Employee employee, int newDepartment) {
        String key = getKey(employee);
        if (employees.containsKey(key)) {
            employees.get(key).setDepartment(newDepartment);

        }
    }

    public void printEmployeesByDepartment() {
        for (int dept = 1; dept <= 5; dept++) {
            System.out.println("Сотрудники отдела " + dept + ": ");
            for (Employee employee : employees.values()) {
                if (Objects.nonNull(employee) && employee.getDepartment() == dept) {
                    System.out.println(
                            employee.getSurnameEmploy() + " "
                                    + employee.getNameEmploy() + " "
                                    + employee.getPatronymNameEmploy());
                }
            }
        }
    }

    public void getEmployBySalaryLessNum(double number) {
        System.out.println("Сотрудники с зарплатой меньше, чем " + number + ": ");
        for (Employee employee : employees.values()) {
            if (Objects.nonNull(employee) && employee.getSalaryEmploy() < number) {
                System.out.printf(
                        "Код сотрудника: %d" +
                                ", \nФ.И.О сотрудника: %s %s %s" +
                                ", \nЗарплата сотрудника: %.2f%n",
                        employee.getIdEmploy(),
                        employee.getNameEmploy(),
                        employee.getPatronymNameEmploy(),
                        employee.getSurnameEmploy(),
                        employee.getSalaryEmploy()
                );
            }
        }
    }

    public void getEmployBySalaryMoreNum(double number) {
        System.out.println("Сотрудники с зарплатой больше, чем " + number + ": ");
        for (Employee employee : employees.values()) {
            if (Objects.nonNull(employee) && employee.getSalaryEmploy() > number) {
                System.out.printf(
                        "Код сотрудника: %d" +
                                ", \nФ.И.О сотрудника: %s %s %s" +
                                ", \nЗарплата сотрудника: %.2f%n",
                        employee.getIdEmploy(),
                        employee.getNameEmploy(),
                        employee.getPatronymNameEmploy(),
                        employee.getSurnameEmploy(),
                        employee.getSalaryEmploy()
                );
            }
        }
    }

    public void getSalaryIndexing(double indexationCoefficient) {
        for (Employee employee : employees.values()) {
            if (Objects.nonNull(employee)) {
                employee.setSalaryEmploy(employee.getSalaryEmploy() +
                        employee.getSalaryEmploy() * indexationCoefficient / 100);
            }
        }
    }

    public void getSalaryIndexingByDept(double indexationCoefficient, int dept) {
        for (Employee employee : employees.values()) {
            if (Objects.nonNull(employee) && employee.getDepartment() == dept) {
                employee.setSalaryEmploy(employee.getSalaryEmploy() +
                        employee.getSalaryEmploy() * indexationCoefficient / 100);
            }
        }
    }

    public double getAvgSalary() {
        double totalSalary = 0;
        for (Employee employee : employees.values()) {
            if (Objects.nonNull(employee)) {
                totalSalary += employee.getSalaryEmploy();
            }
        }
        return totalSalary / employees.size();
    }

    public double getAvgSalaryByDept(int dept) {

        double totalSalary = 0;
        int countEmpByDept = 0;

        for (Employee employee : employees.values()) {
            if (Objects.nonNull(employee) && employee.getDepartment() == dept) {
                countEmpByDept += 1;
                totalSalary += employee.getSalaryEmploy();
            }
        }

        double avgSalary = totalSalary / countEmpByDept;

        System.out.println("---Подсчет среднего значения зарплат в отделе № " + dept + "---");
        return countEmpByDept == 0 ? 0 : avgSalary;
    }


    public Employee getEmployWithMinSalaryByDept(int dept) {

        double minSalary = Double.MAX_VALUE;
        String key = null;

        for (Map.Entry<String, Employee> entry : employees.entrySet()) {
            Employee employee = entry.getValue();
            if (Objects.nonNull(employee) && employee.getDepartment() == dept
                    && minSalary > employee.getSalaryEmploy()) {
                key = entry.getKey();
                minSalary = employee.getSalaryEmploy();

            }
        }

        System.out.println("---Поиск сотрудника с минимальной зарплатой в отделе № " + dept + "---");
        if (key != null) {
            return employees.get(key);
        } else {
            return null;
        }
    }

    public Employee getEmployWithMinSalary() {

        double minSalary = Double.MAX_VALUE;
        String key = null;

        for (Map.Entry<String, Employee> entry : employees.entrySet()) {
            Employee employee = entry.getValue();
            if (Objects.nonNull(employee) && minSalary > employee.getSalaryEmploy()) {
                key = entry.getKey();
                minSalary = employee.getSalaryEmploy();
            }
        }

        System.out.println("---Поиск сотрудника с минимальной зарплатой---");
        if (key != null) {
            return employees.get(key);
        } else {
            return null;
        }
    }

    public Employee getEmployWithMaxSalaryByDept(int dept) {

        double maxSalary = Double.MIN_VALUE;
        String key = null;


        for (Map.Entry<String, Employee> entry : employees.entrySet()) {
            Employee employee = entry.getValue();
            if (Objects.nonNull(employee) && employee.getDepartment() == dept
                    & maxSalary < employee.getSalaryEmploy()) {
                key = entry.getKey();
                maxSalary = employee.getSalaryEmploy();
            }
        }

        System.out.println("---Поиск сотрудника с максимальной зарплатой в отделе № " + dept + "---");
        if (key != null) {
            return employees.get(key);
        } else {
            return null;
        }
    }

    public Employee getEmployWithMaxSalary() {

        double maxSalary = Double.MIN_VALUE;
        String key = null;

        for (Map.Entry<String, Employee> entry : employees.entrySet()) {
            Employee employee = entry.getValue();
            if (Objects.nonNull(employee) && maxSalary < employee.getSalaryEmploy()) {
                key = entry.getKey();
                maxSalary = employee.getSalaryEmploy();
            }
        }

        System.out.println("---Поиск сотрудника с максимальной зарплатой---");
//        if (key != null) {
//            return employees.get(key);
//        } else {
//            return null;
//        }
        return key != null ? employees.get(key) : null;
    }

    public double getTotalSalaryInMonthByDept(int dept) {

        double totalSalary = 0;

        for (Employee employee : employees.values()) {
            if (Objects.nonNull(employee) && employee.getDepartment() == dept) {
                totalSalary += employee.getSalaryEmploy();
            }
        }

        System.out.println("---Подсчет суммы затрат на зарплаты в месяц в отделе № " + dept + "---");
        return totalSalary;
    }

    public double getTotalSalaryInMonth() {

        double totalSalary = 0;

        for (Employee employee : employees.values()) {
            if (Objects.nonNull(employee)) {
                totalSalary += employee.getSalaryEmploy();
            }
        }

        System.out.println("---Подсчет суммы затрат на на зарплаты в месяц---");
        return totalSalary;
    }

    public void getFullNameAllEmployee() {

        System.out.println("\n---Вывод Ф.И.О. всех сотрудников---\n");

        for (Employee employee : employees.values()) {
            System.out.println(employee.getNameEmploy() + " "
                    + employee.getPatronymNameEmploy() + " "
                    + employee.getSurnameEmploy());
        }
    }

    public void getInfoAllEmployee() {
        System.out.println("---Вывод информации о сотрудниках---\n");

        for (Employee employee : employees.values()) {
            System.out.println(employee);
        }
    }

    public void getInfoAllEmployeeByDept(int dept) {
        System.out.println("---Вывод информации о сотрудниках отдела № " + dept + "---\n");

        for (Employee employee : employees.values()) {
            if (employee.getDepartment() == dept) {
                System.out.printf(
                        "Код сотрудника: %d" +
                                ", \nФ.И.О сотрудника: %s %s %s" +
                                ", \nЗарплата сотрудника: %.2f%n",
                        employee.getIdEmploy(),
                        employee.getNameEmploy(),
                        employee.getPatronymNameEmploy(),
                        employee.getSurnameEmploy(),
                        employee.getSalaryEmploy()
                );
                System.out.println();

            }
        }
    }
}
