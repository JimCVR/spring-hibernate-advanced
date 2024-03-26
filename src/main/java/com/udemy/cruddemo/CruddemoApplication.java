package com.udemy.cruddemo;

import com.udemy.cruddemo.dao.AppDAO;
import com.udemy.cruddemo.entity.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CruddemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(CruddemoApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(AppDAO appDAO) {
        return runner -> {
            // createInstructor(appDAO);
            // findInstructor(appDAO);
            // deleteInstructor(appDAO);
            // findInstructorDetail(appDAO);
            // deleteInstructorDetail(appDAO);
            // createInstructorWithCourses(appDAO);
            // findInstructorWithCourses(appDAO);
            // findCoursesForInstructor(appDAO);
            // findInstructorWithCoursesJoinFetch(appDAO);
            // updateInstructor(appDAO);
            // updateCourse(appDAO);
            // deleteCourse(appDAO);
            // createCourseAndReviews(appDAO);
            // retrieveCourseAndReviews(appDAO);
            // deleteCourseAndReviews(appDAO);
            // createCourseAndStudents(appDAO);
            // findCourseAndStudents(appDAO);
            // findStudentAndCourses(appDAO);
            // addMoreCoursesForStudent(appDAO);
            // deleteCourse(appDAO);
            deleteStudent(appDAO);

        };
    }

    private void deleteStudent(AppDAO appDAO) {
        int id = 3;
        appDAO.deleteStudentById(id);
        System.out.println("Done!");
    }

    private void addMoreCoursesForStudent(AppDAO appDAO) {
        int id = 1;
        Student student = appDAO.findStudentAndCoursesByStudentId(id);
        var course1 = new Course("learn piano in 100 days");
        var course2 = new Course("Cooking lessons for advanced chefs");
        student.addCourse(course1);
        student.addCourse(course2);
        System.out.println("Student:"+ student);
        System.out.println("Courses:"+ student.getCourses());

        appDAO.update(student);
    }

    private void findStudentAndCourses(AppDAO appDAO) {
        int id = 1;
        Student student = appDAO.findStudentAndCoursesByStudentId(id);
        System.out.println("Student:"+ student);
        System.out.println("Courses:"+ student.getCourses());
    }

    private void findCourseAndStudents(AppDAO appDAO) {
        int id = 14;
        Course course = appDAO.findCourseAndStudentsByCourseId(id);
        System.out.println("Course:"+ course);
        System.out.println("Students:"+ course.getStudents());
    }

    private void createCourseAndStudents(AppDAO appDAO) {
        Course course = new Course("Introduction to bungee jumping");
        course.addStudent(new Student("Silvia", "Gomez","silvia@mail.com"));
        course.addStudent(new Student("Carlos", "Villanueva","carlos@mail.com"));
        course.addStudent(new Student("Luis", "Calleja","luis@mail.com"));

        System.out.println("Saving course: " + course);
        System.out.println("Students: " + course.getStudents());
        appDAO.save(course);
    }

    private void deleteCourseAndReviews(AppDAO appDAO) {
        int id = 13;
        appDAO.deleteCourseById(id);
        System.out.println("DONE!");
    }

    private void retrieveCourseAndReviews(AppDAO appDAO) {
        int id = 13;
        var course = appDAO.findCourseAndReviewsByCourseId(id);
        System.out.println(course);

    }

    private void createCourseAndReviews(AppDAO appDAO) {
        Course course = new Course("Forest survival guide");
        Review review1 = new Review("Great course!!");
        Review review2 = new Review("Not bad, but not great...");
        Review review3 = new Review("The worst course I've ever bought!");
        course.add(review1);
        course.add(review2);
        course.add(review3);

        appDAO.save(course);
    }

    private void deleteCourse(AppDAO appDAO) {
        int id = 11;
        appDAO.deleteCourseById(id);
        System.out.println("Done!");

    }

    private void updateCourse(AppDAO appDAO) {
        int id = 10;

        var course = appDAO.findCourseById(id);

        course.setTitle("Game development crash course");
        appDAO.update(course);
        System.out.println("Done!");
    }

    private void updateInstructor(AppDAO appDAO) {
        int id = 5;

        var instructor = appDAO.findInstructorById(id);

        instructor.setLastName("makarov");
        appDAO.update(instructor);
        System.out.println("Done!");
    }

    private void findInstructorWithCoursesJoinFetch(AppDAO appDAO) {
        int id = 5;
        var instructor = appDAO.findInstructorByIdJoinFetch(id);
        System.out.println("Instructor: " + instructor);
        System.out.println("Courses: " + instructor.getCourses());
    }

    private void findCoursesForInstructor(AppDAO appDAO) {
        var id = 5;
        var instructor = appDAO.findInstructorById(5);
        var courses = appDAO.findCoursesByInstructorId(5);
        instructor.setCourses(courses);
        System.out.println("Instructor: " + instructor);
        System.out.println("Courses: " + instructor.getCourses());
    }

    private void findInstructorWithCourses(AppDAO appDAO) {
        var id = 5;
        var instructor = appDAO.findInstructorById(id);
        System.out.println("Instructor: " + instructor);
        System.out.println("Courses: " + instructor.getCourses());
    }

    private void createInstructorWithCourses(AppDAO appDAO) {
        var instructor = new Instructor("Susan", "public", "susan@mail.com");
        var instructorDetail = new InstructorDetail("youtube/susan",
                "fitness");
        instructor.setInstructorDetail(instructorDetail);
        var course1 = new Course("learn piano in 10 days");
        var course2 = new Course("Cooking lessons for dummies");

        instructor.add(course1);
        instructor.add(course2);
        System.out.println("Instructor: " + instructor);
        System.out.println("Courses: " + instructor.getCourses());
        appDAO.save(instructor);
    }

    private void deleteInstructorDetail(AppDAO appDAO) {
        int id = 3;
        var insDetail = appDAO.findInstructorDetailById(id);
        System.out.println("Deleting: " + insDetail);
        appDAO.deleteInstructorDetailById(id);
    }

    private void findInstructorDetail(AppDAO appDAO) {
        var instructorDetail = appDAO.findInstructorDetailById(2);
        System.out.println("Instructor detail found: " + instructorDetail);
    }

    private void deleteInstructor(AppDAO appDAO) {
        int id = 4;
        System.out.println("Deleting...");
        appDAO.deleteInstructorById(id);
    }

    private void findInstructor(AppDAO appDAO) {
        var instructor = appDAO.findInstructorById(1);
        System.out.println("Instructor found: " + instructor);
    }

    private void createInstructor(AppDAO appDAO) {
        var instructor = new Instructor("MamaDuh", "Lopez", "mamaduh@mail.com");

        var instructorDetail = new InstructorDetail("http://www.luv2code.com/youtube",
                "code");
        instructor.setInstructorDetail(instructorDetail);
        System.out.println(instructor);
        appDAO.save(instructor);
    }

}
