package com.udemy.cruddemo.dao;

import com.udemy.cruddemo.entity.Course;
import com.udemy.cruddemo.entity.Instructor;
import com.udemy.cruddemo.entity.InstructorDetail;
import com.udemy.cruddemo.entity.Student;

import java.util.List;

public interface AppDAO {

    void save(Instructor instructor);

    void save(Course course);

    void update(Instructor instructor);

    void update(Course course);

    void update(Student student);

    void deleteInstructorById(int id);

    void deleteInstructorDetailById(int id);

    void deleteCourseById(int id);

    void deleteStudentById(int id);

    Instructor findInstructorById(int id);

    Instructor findInstructorByIdJoinFetch(int id);

    InstructorDetail findInstructorDetailById(int id);

    Course findCourseById(int id);

    Course findCourseAndReviewsByCourseId(int id);

    Course findCourseAndStudentsByCourseId(int id);

    List<Course> findCoursesByInstructorId(int id);

    Student findStudentAndCoursesByStudentId(int id);
}
