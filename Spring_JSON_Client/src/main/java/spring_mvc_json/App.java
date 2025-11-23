package spring_mvc_json;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import spring_mvc_json.configuration.MyConfig;
import spring_mvc_json.entity.Employee;

import java.util.List;

public class App {
    public static void main( String[] args ) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MyConfig.class);
        Communication communication = context.getBean("communication", Communication.class);
        List<Employee> allEmployees = communication.getAllEmployees();
        allEmployees.stream().forEach(el -> System.out.println(el));
        System.out.println("---------------------");
        Employee empByID = communication.getEmployee(2);
        System.out.println(empByID);
        System.out.println("---------------------");
        Employee emp = new Employee("Kolya", "Zaev", "Delivery", 4234);
        communication.saveEmployee(emp);
        emp.setId(9);
        communication.deleteEmployee(emp.getId());
        System.out.println("---------------------");
        allEmployees = communication.getAllEmployees();
        allEmployees.stream().forEach(el -> System.out.println(el));
    }
}
