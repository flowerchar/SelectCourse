package com.example.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Table;

@Table(name = "admin_info")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AdminInfo extends Account{

    @Column(name = "phone")
    private String phone;
}
