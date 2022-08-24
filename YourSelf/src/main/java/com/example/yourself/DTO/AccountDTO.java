package com.example.yourself.DTO;

public class AccountDTO {

    private Integer id;
    private String username;
    private String department_name;

    public AccountDTO(Integer id, String username, String department_name) {
        this.id = id;
        this.username = username;
        this.department_name = department_name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getDepartment_name() {
        return department_name;
    }

    public void setDepartment_name(String department_name) {
        this.department_name = department_name;
    }
}
