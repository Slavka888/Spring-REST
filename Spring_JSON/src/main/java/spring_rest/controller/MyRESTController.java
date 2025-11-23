package spring_rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import spring_rest.entity.Employee;
import spring_rest.exception_handling.EmployeeIncorrectData;
import spring_rest.exception_handling.NoSuchEmployeeException;
import spring_rest.service.EmployeeService;

import java.util.List;

//Контроллер, который управляет REST запросами и ответами
@RestController
@RequestMapping("/api")
public class MyRESTController {
    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/employees")
    public List<Employee> showAllEmployees(){
        List<Employee> allEmps = employeeService.getAllEmployees();
        return allEmps;
    }

    @GetMapping("/employees/{id}")
    public Employee getEmployee(@PathVariable int id){
        Employee emp = employeeService.getEmployee(id);
        if (emp == null){
            throw new NoSuchEmployeeException("There is no employee with id = "+ id + " in DataBase");
        }

        return emp;
    }

    @PostMapping("/employees")
    public Employee addNewEmployee(@RequestBody Employee emp){
        employeeService.saveEmployee(emp);
        return emp;
    }

    @PutMapping("/employees")
    public Employee updateEmployee(@RequestBody Employee emp){
        employeeService.saveEmployee(emp);
        return emp;
    }

    @DeleteMapping("/employees/{id}")
    public String deleteEmployee(@PathVariable int id){
        Employee emp = employeeService.getEmployee(id);
        if (emp == null){
            throw new NoSuchEmployeeException("There is no employee with id = "+ id + " in DataBase");
        }
        employeeService.deleteEmployee(id);
        return "Employee " + id + " deleted!";
    }
}
