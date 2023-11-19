import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Course {
    String name;
    int capacity;
    int enrolled;

    public Course(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        this.enrolled = 0;
    }

    public boolean enrollStudent() {
        if (enrolled < capacity) {
            enrolled++;
            return true;
        } else {
            System.out.println("Course is full. Cannot enroll more students.");
            return false;
        }
    }

    public String toString() {
        return "Course: " + name + ", Capacity: " + capacity + ", Enrolled: " + enrolled;
    }
}

class RegistrationSystem {
    List<Course> courses;

    public RegistrationSystem() {
        this.courses = new ArrayList<>();
    }

    public void addCourse(String name, int capacity) {
        Course course = new Course(name, capacity);
        courses.add(course);
    }

    public void displayCourses() {
        for (Course course : courses) {
            System.out.println(course);
        }
    }

    public void enrollStudent() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter course name to enroll:");
        String courseName = scanner.nextLine();

        for (Course course : courses) {
            if (course.name.equals(courseName)) {
                course.enrollStudent();
                System.out.println("Enrolled in " + course.name + " successfully.");
                return;
            }
        }
        System.out.println("Course not found.");
    }
}

public class Student {
    public static void main(String[] args) {
        RegistrationSystem registrationSystem = new RegistrationSystem();
        registrationSystem.addCourse("Java Programming", 20);
        registrationSystem.addCourse("Web Development", 15);
        registrationSystem.addCourse("Data Science", 10);
        registrationSystem.displayCourses();
        registrationSystem.enrollStudent();
        registrationSystem.displayCourses();
    }
}
