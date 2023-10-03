package com.example.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "course_info")
public class CourseInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "credit")
    private Integer credit;

    @Column(name = "required_num")
    private Integer requiredNum;

    @Column(name = "time")
    private String time;

    @Column(name = "location")
    private String location;

    @Column(name = "selected_num")
    private Integer selectedNum;

    @Column(name = "majorID")
    private Long majorID;

    @Column(name = "teacherID")
    private Long teacherID;

    @Transient
    private String teacherName;

    @Transient
    private String majorName;

    @Transient
    private String status;
}
