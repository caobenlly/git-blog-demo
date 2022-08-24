package com.example.yourself.Service;

import com.example.yourself.Enity.Department;
import com.example.yourself.Reponsitory.DepartmentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class DepartmentSerive implements IDepartmentService{

    @Autowired
    private DepartmentRepo departmentRepo;


    @Override
    public List<Department> getAll() {
        return departmentRepo.findAll();
    }

    @Override
    public Optional<Department> getOne(Integer id) {
        return departmentRepo.findById(id);
    }

    @Override
    public Department create(Department department) {

        return departmentRepo.save(department);
    }

    @Override
    public Department update(Integer id, Department department) throws ChangeSetPersister.NotFoundException {
        getOne(id)
                .map(dpm ->{
                    department.setId(id);
                    departmentRepo.save(department);
                    return dpm;
                });
        return  department;
    }

    @Override
    public Optional<Department> delete(Integer id) throws ChangeSetPersister.NotFoundException {
        return getOne(id)
                .map(dpm -> {
                    dpm.setId(id);
                    departmentRepo.delete(dpm);
                    return dpm;
                });
    }
}
