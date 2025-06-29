package com.RestService.RESTservice.controllers;


// Operations
//GET employee
//POST employee
//DELETE / employee / {id
// }

import com.RestService.RESTservice.dto.EmployeeDTO;
import com.RestService.RESTservice.services.EmployeeService;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping(path = "/employees")
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }


    //GET employee
    @GetMapping(path = "/{id}")
    public EmployeeDTO getEmployeeByID(@PathVariable("id") Long employeeId)
    {
        return employeeService.getEmployeeByID(employeeId);
    }
    //GET all employee
    @GetMapping
    public List<EmployeeDTO> getAllEmployee(){
        return employeeService.getAllEmployees();
    }

    //CREATE employee
    @PostMapping
    public EmployeeDTO createNewEmployee(@RequestBody EmployeeDTO employeeDTO){
        return employeeService.AddNeEmployee(employeeDTO) ;
    }

    //DELETE employeee
    @DeleteMapping(path = "/{id}")
    public boolean deleteEmployee(@PathVariable Long id )
    {
        return employeeService.DeleteEmployee(id);
    }

}
