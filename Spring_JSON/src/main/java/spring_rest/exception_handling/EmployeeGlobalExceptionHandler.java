package spring_rest.exception_handling;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

//Отдельный класс для отлова ошибок от любого контроллера
@ControllerAdvice
public class EmployeeGlobalExceptionHandler {
    //Делаем вывод ошибки в формате JSON
    @ExceptionHandler
    public ResponseEntity<EmployeeIncorrectData> handleException(NoSuchEmployeeException e){
        EmployeeIncorrectData data = new EmployeeIncorrectData();
        data.setInfo(e.getMessage());
        return new ResponseEntity<>(data, HttpStatus.NOT_FOUND);
    }

    //Обрабатываем любой неверный ввод id
    @ExceptionHandler
    public ResponseEntity<EmployeeIncorrectData> handleException(Exception e){
        EmployeeIncorrectData data = new EmployeeIncorrectData();
        data.setInfo(e.getMessage());
        return new ResponseEntity<>(data, HttpStatus.BAD_REQUEST);
    }
}
