package SANJAY;
import java.util.ArrayList;
import java.util.Scanner;

class Course {
    String courseCode;
    String title;
    String description;
    int capacity;
    String schedule;
    int enrolledStudents;
    public Course(String courseCode, String title, String description, int capacity, String schedule) {
        this.courseCode = courseCode;
        this.title = title;
        this.description = description;
        this.capacity = capacity;
        this.schedule = schedule;
        this.enrolledStudents = 0;
    }
    public boolean hasAvailableSlots() {
        return enrolledStudents < capacity;
    }
    public void enrollStudent() {
        if (hasAvailableSlots()) {
            enrolledStudents++;
        }
    }
    public void dropStudent() {
        if (enrolledStudents > 0) {
            enrolledStudents--;
        }
    }
    public void displayCourseInfo() {
        System.out.println(courseCode + ": " + title);
        System.out.println("Description: " + description);
        System.out.println("Schedule: " + schedule);
        System.out.println("Capacity: " + capacity + ", Enrolled: " + enrolledStudents);
        System.out.println("Available Slots: " + (capacity - enrolledStudents));
    }
}
class Student {
    int studentId;
    String name;
    ArrayList<Course> registeredCourses;
    public Student(int studentId, String name) {
        this.studentId = studentId;
        this.name = name;
        this.registeredCourses = new ArrayList<>();
    }
    public void registerCourse(Course course) {
        if (course.hasAvailableSlots()) {
            registeredCourses.add(course);
            course.enrollStudent();
            System.out.println("Successfully registered for course: " + course.title);
        } else {
            System.out.println("Course is full.");
        }
    }
    public void dropCourse(Course course) {
        if (registeredCourses.contains(course)) {
            registeredCourses.remove(course);
            course.dropStudent();
            System.out.println("Dropped course: " + course.title);
        } else {
            System.out.println("You are not registered in this course.");
        }
    }
    public void displayRegisteredCourses() {
        if (registeredCourses.isEmpty()) {
            System.out.println("No courses registered.");
        } else {
            System.out.println("Registered Courses:");
            for (Course course : registeredCourses) {
                System.out.println(course.courseCode + ": " + course.title);
            }
        }
    }
}
public class STUDENT_COURSE_REGISTRATION_SYSTEM {
    static ArrayList<Course> courses = new ArrayList<>();
    static ArrayList<Student> students = new ArrayList<>();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        courses.add(new Course("CS101", "Introduction to Computer Science", "Basic CS concepts", 30, "MWF 10-11 AM"));
        courses.add(new Course("MATH201", "Calculus I", "Introduction to Calculus", 25, "TTh 12-1:30 PM"));
        courses.add(new Course("PHYS101", "General Physics I", "Fundamental Physics", 20, "MW 2-3:30 PM"));
        students.add(new Student(1, "John Doe"));
        students.add(new Student(2, "Jane Smith"));
        int choice;
        do {
            System.out.println("\n----- Course Registration System -----");
            System.out.println("1. View Available Courses");
            System.out.println("2. Register for a Course");
            System.out.println("3. Drop a Course");
            System.out.println("4. View Registered Courses");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            switch (choice) {
                case 1:
                    viewAvailableCourses();
                    break;
                case 2:
                    registerCourse(sc);
                    break;
                case 3:
                    dropCourse(sc);
                    break;
                case 4:
                    viewRegisteredCourses(sc);
                    break;
                case 5:
                    System.out.println("Exiting the system...");
                    break;
                default:
                    System.out.println("Invalid choice.");
                    break;
            }
        } while (choice != 5);

        sc.close();
    }
    public static void viewAvailableCourses() {
        System.out.println("\nAvailable Courses:");
        for (Course course : courses) {
            course.displayCourseInfo();
            System.out.println("-----------------------------------");
        }
    }
    public static void registerCourse(Scanner sc) {
        System.out.print("\nEnter your student ID: ");
        int studentId = sc.nextInt();
        Student student = findStudentById(studentId);
        if (student != null) {
            System.out.print("Enter the course code to register: ");
            String courseCode = sc.next();
            Course course = findCourseByCode(courseCode);
            if (course != null) {
                student.registerCourse(course);
            } else {
                System.out.println("Course not found.");
            }
        } else {
            System.out.println("Student not found.");
        }
    }
    public static void dropCourse(Scanner sc) {
        System.out.print("\nEnter your student ID: ");
        int studentId = sc.nextInt();
        Student student = findStudentById(studentId);

        if (student != null) {
            System.out.print("Enter the course code to drop: ");
            String courseCode = sc.next();
            Course course = findCourseByCode(courseCode);

            if (course != null) {
                student.dropCourse(course);
            } else {
                System.out.println("Course not found.");
            }
        } else {
            System.out.println("Student not found.");
        }
    }
    public static void viewRegisteredCourses(Scanner sc) {
        System.out.print("\nEnter your student ID: ");
        int studentId = sc.nextInt();
        Student student = findStudentById(studentId);

        if (student != null) {
            student.displayRegisteredCourses();
        } else {
            System.out.println("Student not found.");
        }
    }
    public static Course findCourseByCode(String courseCode) {
        for (Course course : courses) {
            if (course.courseCode.equals(courseCode)) {
                return course;
            }
        }
        return null;
    }
    public static Student findStudentById(int studentId) {
        for (Student student : students) {
            if (student.studentId == studentId) {
                return student;
            }
        }
        return null;
    }
}