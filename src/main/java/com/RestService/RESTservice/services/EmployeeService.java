package com.RestService.RESTservice.services;

import com.RestService.RESTservice.dto.EmployeeDTO;
import com.RestService.RESTservice.entities.EmployeeEntity;
import com.RestService.RESTservice.repository.EmployeeRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmployeeService {

    final EmployeeRepository employeeRepository;

    final ModelMapper modelMapper;
    //constructor injection
    public EmployeeService(EmployeeRepository employeeRepository, ModelMapper modelMapper) {
        this.employeeRepository = employeeRepository;
        this.modelMapper = modelMapper;
    }

    public EmployeeDTO getEmployeeByID(Long id){

       EmployeeEntity employeeEntity =  employeeRepository.getById(id);

       return modelMapper.map(employeeEntity,EmployeeDTO.class);

    }

    public EmployeeDTO AddNeEmployee(EmployeeDTO employeeDTO){

        EmployeeEntity employeeEntity= modelMapper.map(employeeDTO , EmployeeEntity.class);
        return modelMapper.map( employeeRepository.save(employeeEntity),EmployeeDTO.class); // convert te entiity to DTO as return type is DTO
    }

    public List<EmployeeDTO> getAllEmployees() {

        List<EmployeeDTO> list = new ArrayList<>();
        for (EmployeeEntity employeeEntity : employeeRepository.findAll()) {
            EmployeeDTO map = modelMapper.map(employeeEntity,EmployeeDTO.class);
            list.add(map);
        }
        return list;

        /* instead for loop we can use stream
        return employeeRepository
                .findAll()
                .stream()
                .map(employeeEntity -> modelMapper.map(employeeEntity,EmployeeDTO.class))
                .collect(Collectors.toList());
         */
    }

    public boolean DeleteEmployee(Long id)
    {
        boolean isPresent = employeeRepository.existsById(id);
        if(isPresent) return false ;
        employeeRepository.deleteById(id);
        return true ;

    }
}
