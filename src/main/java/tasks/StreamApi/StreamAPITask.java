package tasks.StreamApi;

import java.util.ArrayList;

public class StreamAPITask {
    public static void startTask(){
        ArrayList<Employee> employees = new ArrayList<>(5);
        Employee emp1 = new Employee("Иван", 34, "Отдел продаж", 45.960);
        Employee emp2 = new Employee("Елизавета", 22, "Отдел кадров", 50.340);
        Employee emp3 = new Employee("Анатолий", 31, "Отдел продаж", 70.000);
        Employee emp4 = new Employee("Илья", 28, "Отдел снабжения", 66.900);
        Employee emp5 = new Employee("Арина", 25, "Отдел кадров", 68.340);

        employees.add(emp1);
        employees.add(emp2);
        employees.add(emp3);
        employees.add(emp4);
        employees.add(emp5);

        double avgSalary = employees.stream()
                                    .filter(emp -> emp.getDepartment() == "Отдел продаж")
                                    .mapToDouble(Employee::getSalary)
                                    .average()
                                    .orElse(0);
        System.out.println("--StreamAPI Task--");
        System.out.println("Средняя зп в отделе продаж: " + avgSalary);
        System.out.println();
    }
}
