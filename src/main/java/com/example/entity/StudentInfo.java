package com.example.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Table;

@Table(name = "student_info")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentInfo extends Account{

    @Column(name = "studentID")
    private String studentID;

    @Column(name = "collegeID")
    private Long collegeID;

    @Column(name = "credit")
    private Integer credit;


}
