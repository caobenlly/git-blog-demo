package com.example.yourself.Controller;


import com.example.yourself.Enity.Department;
import com.example.yourself.Service.DepartmentSerive;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(("/api/v1/departments"))
public class DepartmentController {

    @Autowired
    private DepartmentSerive departmentSerive;

    @GetMapping()
    public List<Department> getAllDepartment(){
        return departmentSerive.getAll();
    }
    @GetMapping  (value = "/{id}")
    public Optional<Department> getDepartmentById(@PathVariable(name = "id") Integer id){
        return  departmentSerive.getOne(id);
    }

    @PutMapping(value = "/{id}")
    public Department update(@PathVariable(name = "id") Integer id,@RequestBody Department department)
            throws ChangeSetPersister.NotFoundException {
        return departmentSerive.update(id, department);
    }

    @PostMapping
    public Department create(@RequestBody Department department){

        return departmentSerive.create(department);
    }


    @DeleteMapping(value = "/{id}")
    public Optional<Department> create(@PathVariable(name = "id") Integer id) throws ChangeSetPersister.NotFoundException {
        return departmentSerive.delete(id);
    }
}
