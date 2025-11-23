package spring_mvc_json;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import spring_mvc_json.entity.Employee;

import java.util.List;

@Component
public class Communication {
    @Autowired
    private RestTemplate restTemplate;

    private final String URL = "http://localhost:8080/Spring_JSON/api/employees";

    public List<Employee> getAllEmployees(){

        ResponseEntity<List<Employee>> responseEntity =
                restTemplate.exchange(URL, HttpMethod.GET, null, new ParameterizedTypeReference<List<Employee>>() {});
        List<Employee> allEmployees = responseEntity.getBody();
        return allEmployees;
    }

    public Employee getEmployee(int id){
        Employee emp = restTemplate.getForObject(URL+"/"+id, Employee.class);

        return emp;
    }

    public void saveEmployee(Employee employee){
        int id = employee.getId();

        if (id == 0){
            //Будет возвращаться новосозданный работник, поэтому указываем String
            ResponseEntity<String> responseEntity = restTemplate.postForEntity(URL, employee, String.class);
            System.out.println("New employee was added");
            System.out.println(responseEntity.getBody());
        }
        else{
            restTemplate.put(URL, employee);
            System.out.println("Employee with ID " + id + " was updated");
        }
    }

    public void deleteEmployee(int id){
        restTemplate.delete(URL+"/"+id);
        System.out.println("Employee with ID " + id + " was deleted");
    }
}
