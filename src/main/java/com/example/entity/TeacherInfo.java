package com.example.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Table;
import javax.persistence.Transient;

@Table(name = "teacher_info")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TeacherInfo extends Account{

    @Column(name = "title")
    private String title;

    @Column(name = "collegeID")
    private Long collegeID;

    @Transient
    private String collegeName;
}
