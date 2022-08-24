package com.example.yourself.Reponsitory;

import com.example.yourself.Enity.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepo extends JpaRepository<Department,Integer> {
}
