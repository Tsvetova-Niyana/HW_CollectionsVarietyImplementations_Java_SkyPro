public class Main {

    public static void main(String[] args) {
        /*
        7. Создать внутри класса с методом main поле типа Employee[10], которое будет выполнять роль
        «хранилища» для записей о сотрудниках.
        8. Создать статические методы, которые будут взаимодействовать с массивом и предоставлять результат:
            1. Получить список всех сотрудников со всеми имеющимися по ним данными (вывести в консоль значения
            всех полей (toString)).
            2. Посчитать сумму затрат на зарплаты в месяц.
            3. Найти сотрудника с минимальной зарплатой.
            4. Найти сотрудника с максимальной зарплатой.
            5. Подсчитать среднее значение зарплат (можно использовать для этого метод из пункта b).
            6. Получить Ф. И. О. всех сотрудников (вывести в консоль).

         Создать дополнительные статические методы для решения следующих задач.

        1. Проиндексировать зарплату (вызвать изменение зарплат у всех сотрудников на величину аргумента в %).
        2. Получить в качестве параметра номер отдела (1–5) и найти (всего 6 методов):
            1. Сотрудника с минимальной зарплатой.
            2. Сотрудника с максимальной зарплатой.
            3. Сумму затрат на зарплату по отделу.
            4. Среднюю зарплату по отделу (учесть, что количество людей в отделе отличается от employees.length).
            5. Проиндексировать зарплату всех сотрудников отдела на процент, который приходит в качестве параметра.
            6. Напечатать всех сотрудников отдела (все данные, кроме отдела).
        3. Получить в качестве параметра число и найти:
            1. Всех сотрудников с зарплатой меньше числа (вывести id, Ф. И. О. и зарплатой в консоль).
            2. Всех сотрудников с зарплатой больше (или равно) числа (вывести id, Ф. И. О. и зарплатой в консоль).
         */

        EmployeeBook employeeBook = new EmployeeBook();
        Employee employee1 = new Employee("Яков", "Артёмович", "Грачев", 2, 36570);
        employeeBook.addEmployee("Иван", "Иванович", "Иванов", 1, 60500);
        Employee employee2 = new Employee("Владимир", "Петрович", "Никонов", 1, 26760);
        employeeBook.addEmployee("Василий", "Васильевич", "Васильев", 2, 33000);
        employeeBook.addEmployee("Яков", "Артёмович", "Грачев", 2, 36570);
        employeeBook.addEmployee("Аркадий", "Сергеевич", "Голованов", 3, 25400);
        employeeBook.addEmployee("Ника", "Фёдоровна", "Сухарева", 3, 57030);
        employeeBook.addEmployee("Петр", "Петрович", "Петров", 4, 53000);
        employeeBook.addEmployee("Вениамин", "Валентинович", "Сидоров", 5, 46050);
        employeeBook.addEmployee("Арина", "Вадимовна", "Соколова", 5, 44500);
        employeeBook.addEmployee("Андрей", "Ильич", "Семин", 5, 62188);
        employeeBook.addEmployee(employee1);
        employeeBook.addEmployee(employee2);


        // Получение списка всех сотрудников со всеми имеющимися по ним данными
        employeeBook.getInfoAllEmployee();

        // Удаление сотрудника по коду
        employeeBook.removeEmployee(1);

        // Получение списка всех сотрудников со всеми имеющимися по ним данными после удаления
        System.out.println("Получение списка всех сотрудников со всеми имеющимися по ним данными после удаления по коду");
        System.out.println("_________________________________________________________________________________________");
        employeeBook.getInfoAllEmployee();

        // Удаление сотрудника по employee

        employeeBook.removeEmployee(employee1);

        // Получение списка всех сотрудников со всеми имеющимися по ним данными после удаления
        System.out.println("Получение списка всех сотрудников со всеми имеющимися по ним данными после удаления по employee");
        System.out.println("_________________________________________________________________________________________");
        employeeBook.getInfoAllEmployee();

        // Изменение зарплаты
        System.out.println("Изменение зарплаты");
        System.out.println("_________________________________________________________________________________________");
        employeeBook.changeSalary(employee2, 36000);
        System.out.println(employee2);

        // Изменение департамента у сотрудника
        System.out.println("Изменение департамента у сотрудника");
        System.out.println("_________________________________________________________________________________________");
        employeeBook.changeDepartment(employee2, 3);
        System.out.println(employee2);

        // Печать всех сотрудников по департаментам
        System.out.println("Печать всех сотрудников по департаментам");
        System.out.println("_________________________________________________________________________________________");
        employeeBook.printEmployeesByDepartment();


        // Получение суммы затрат на зарплаты в месяц
        System.out.println();
        double totalSalary = employeeBook.getTotalSalaryInMonth();
        System.out.println("Сумма затрат на на зарплаты в месяц: " + totalSalary);
        System.out.println();

        // Поиск сотрудника с минимальной зарплатой
        System.out.println(employeeBook.getEmployWithMinSalary());

        // Поиск сотрудника с максимальной зарплатой
        System.out.println(employeeBook.getEmployWithMaxSalary());

        // Получение среднего значения зарплат
        System.out.println("Получение среднего значения зарплат");
        System.out.println("_________________________________________________________________________________________");
        System.out.printf("Среднее значение зарплат: %.3f%n", employeeBook.getAvgSalary());

        // Получение Ф.И.О. всех сотрудников
        employeeBook.getFullNameAllEmployee();

        // Получение заработной платы сотрудников в соответствии с проведенной индексацией по указанному параметру
        System.out.println("\nЗаработная плата сотрудников после индексации");
        System.out.println("_________________________________________________________________________________________");

        employeeBook.getSalaryIndexing(36);
        employeeBook.getInfoAllEmployee();

        // Данные по минимальной зарплате показываются с учетом проведенной индексации (если она была)
        System.out.println();
        System.out.println("_________________________________________________________________________________________");
        System.out.println("Данные по минимальной зарплате показываются с учетом проведенной индексации " +
                "(если она была проведена)");
        System.out.println("_________________________________________________________________________________________");
        System.out.println(employeeBook.getEmployWithMinSalaryByDept(1));
        System.out.println(employeeBook.getEmployWithMinSalaryByDept(2));
        System.out.println(employeeBook.getEmployWithMinSalaryByDept(3));
        System.out.println(employeeBook.getEmployWithMinSalaryByDept(4));
        System.out.println(employeeBook.getEmployWithMinSalaryByDept(5));

        // Данные по максимальной зарплате показываются с учетом проведенной индексации (если она была)
        System.out.println("_________________________________________________________________________________________");
        System.out.println("Данные по минимальной зарплате показываются с учетом проведенной индексации " +
                "(если она была проведена)");
        System.out.println("_________________________________________________________________________________________");
        System.out.println(employeeBook.getEmployWithMaxSalaryByDept(1));
        System.out.println(employeeBook.getEmployWithMaxSalaryByDept(2));
        System.out.println(employeeBook.getEmployWithMaxSalaryByDept(3));
        System.out.println(employeeBook.getEmployWithMaxSalaryByDept(4));
        System.out.println(employeeBook.getEmployWithMaxSalaryByDept(5));


        System.out.println();
        System.out.println("_________________________________________________________________________________________");
        System.out.println(employeeBook.getTotalSalaryInMonthByDept(1));
        System.out.println(employeeBook.getTotalSalaryInMonthByDept(2));
        System.out.println(employeeBook.getTotalSalaryInMonthByDept(3));
        System.out.println(employeeBook.getTotalSalaryInMonthByDept(4));
        System.out.println(employeeBook.getTotalSalaryInMonthByDept(5));


        System.out.println();
        System.out.println("_________________________________________________________________________________________");
        System.out.printf("Средняя зарплата всех соьрудников за месяц из отдела № %d: %.2f%n", 1,
                employeeBook.getAvgSalaryByDept(1));
        System.out.printf("Средняя зарплата всех соьрудников за месяц из отдела № %d: %.2f%n", 2,
                employeeBook.getAvgSalaryByDept(2));
        System.out.printf("Средняя зарплата всех соьрудников за месяц из отдела № %d: %.2f%n", 3,
                employeeBook.getAvgSalaryByDept(3));
        System.out.printf("Средняя зарплата всех соьрудников за месяц из отдела № %d: %.2f%n", 4,
                employeeBook.getAvgSalaryByDept(4));
        System.out.printf("Средняя зарплата всех соьрудников за месяц из отдела № %d: %.2f%n", 5,
                employeeBook.getAvgSalaryByDept(5));

        System.out.println();
        System.out.println("_________________________________________________________________________________________");
        employeeBook.getSalaryIndexingByDept(25, 1);
        employeeBook.getSalaryIndexingByDept(26, 2);
        employeeBook.getSalaryIndexingByDept(27, 3);
        employeeBook.getSalaryIndexingByDept(28, 4);
        employeeBook.getSalaryIndexingByDept(29, 5);

        System.out.println();
        System.out.println("_________________________________________________________________________________________");
        employeeBook.getInfoAllEmployeeByDept(1);
        employeeBook.getInfoAllEmployeeByDept(2);
        employeeBook.getInfoAllEmployeeByDept(3);
        employeeBook.getInfoAllEmployeeByDept(4);
        employeeBook.getInfoAllEmployeeByDept(5);

        System.out.println();
        System.out.println("_________________________________________________________________________________________");
        employeeBook.getEmployBySalaryLessNum(75000);

        System.out.println();
        System.out.println("_________________________________________________________________________________________");
        employeeBook.getEmployBySalaryMoreNum(85000);
    }
}
