package com.example.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Calendar;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "course_select_info")
public class CourseSelectInfo {

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

    @Column(name = "majorID")
    private Long majorID;

    @Column(name = "teacherID")
    private Long teacherID;

    @Column(name = "studentID")
    private Long studentID;

    @Column(name = "status")
    private String status;

    @Transient
    private String teacherName;

    @Transient
    private String majorName;

    @Transient
    private String studentName;

    @Transient
    private String student_name;

    @Transient
    private String courseName;

}
