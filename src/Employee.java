import java.util.Objects;

public class Employee {
    /*
    1. Создать класс Employee, который содержит информацию о Ф.И.О., отделе и зарплате сотрудника.
        Отделы для простоты должны быть названы от 1 до 5.
    2. Добавить статическую переменную-счетчик, которая будет отвечать за id.
    3. Добавить в класс Employee поле id, которое проставляется из счетчика, а затем счетчик увеличивает свое
       значение.
    4. Добавить возможность получать значения полей из Employee (геттеры) для всех полей.
    5. Добавить возможность устанавливать значения полей отдела и зарплаты (сеттеры).
    6. По умолчанию все поля должны передавать через конструктор (кроме id) и заполняться в нем
       (включая id, который нужно получить из счетчика).
     */
    private static int idEmploy;
    private final int id;
    private final String name;
    private final String surname;
    private final String patronymName;
    private int department;
    private double salaryEmploy;


    // Формирование конструктора

    public Employee(String name, String patronymName, String surname, int department, double salaryEmploy) {
        this.id = ++idEmploy;
        this.name = name;
        this.surname = surname;
        this.patronymName = patronymName;
        this.department = department;
        this.salaryEmploy = salaryEmploy;
    }

    // Создание геттеров для всех полей
    public int getIdEmploy() {
        return this.id;
    }

    public int getDepartment() {
        return this.department;
    }

    public double getSalaryEmploy() {
        return this.salaryEmploy;
    }


    public String getNameEmploy() {
        return name;
    }

    public String getSurnameEmploy() {
        return surname;
    }

    public String getPatronymNameEmploy() {
        return patronymName;
    }

    // Создание сеттеров для полей отдела и зарплаты
    public void setDepartment(int department) {
        this.department = department;
    }

    public void setSalaryEmploy(double salaryEmploy) {
        this.salaryEmploy = salaryEmploy;
    }

    // Переопределение метода toString для класса Employee
    @Override
    public String toString() {
        return String.format(
                "Код сотрудника: %d" +
                        ", \nФ.И.О сотрудника: %s %s %s" +
                        ", \nОтдел: %d " +
                        ", \nЗарплата сотрудника: %.2f\n",
                id,
                name,
                patronymName,
                surname,
                department,
                salaryEmploy
        );
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return name.equals(employee.name)
                && surname.equals(employee.surname)
                && patronymName.equals(employee.patronymName);
    }

}


