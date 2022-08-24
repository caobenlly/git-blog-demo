package com.example.yourself.Service;

import com.example.yourself.Enity.Department;
import org.springframework.data.crossstore.ChangeSetPersister;

import java.util.List;
import java.util.Optional;

public interface IDepartmentService {

    List<Department> getAll();

    Optional<Department> getOne(Integer id);

    Department create(Department department);

    Department update(Integer id, Department department) throws ChangeSetPersister.NotFoundException;

    Optional<Department> delete(Integer id) throws ChangeSetPersister.NotFoundException;
}
