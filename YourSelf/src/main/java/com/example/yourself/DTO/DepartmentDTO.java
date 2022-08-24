package com.example.yourself.DTO;

import java.util.List;

public class DepartmentDTO {

    private Integer id;
    private String name;
    private List<String> userameAccInDp;


    public DepartmentDTO(Integer id, String name, List<String> userameAccInDp) {
        this.id = id;
        this.name = name;
        this.userameAccInDp = userameAccInDp;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getUserameAccInDp() {
        return userameAccInDp;
    }

    public void setUserameAccInDp(List<String> userameAccInDp) {
        this.userameAccInDp = userameAccInDp;
    }
}
