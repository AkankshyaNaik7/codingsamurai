
import java.util.ArrayList;
import java.util.Scanner;

class Course {
    private String courseName;
    private ArrayList<Student> students;

    public Course(String courseName) {
        this.courseName = courseName;
        this.students = new ArrayList<>();
    }

    public void addStudent(Student student) {
        students.add(student);
    }

    public ArrayList<Student> getStudents() {
        return students;
    }
    public String getCourseName() {
        return courseName;
    }
}

class Student {
    private String studentName;
    private ArrayList<Double> grades;

    public Student(String studentName) {
        this.studentName = studentName;
        this.grades = new ArrayList<>();
    }

    public void addGrade(double grade) {
        grades.add(grade);
    }

    public double calculateAverage() {
        if (grades.isEmpty()) {
            return 0;
        }
        double total = 0;
        for (double grade : grades) {
            total += grade;
        }
        return total / grades.size();
    }

    public String getStudentName() {
        return studentName;
    }
}

public class StudentGradeCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayList<Course> courses = new ArrayList<>();

        while (true) {
            System.out.println("\nStudent Grade Calculator");
            System.out.println("1. Add Course");
            System.out.println("2. Add Student");
            System.out.println("3. Add Grade");
            System.out.println("4. Calculate Course Average");
            System.out.println("5. Calculate GPA");
            System.out.println("6. Save Student Data");
            System.out.println("7. Load Student Data");
            System.out.println("8. Exit");
            System.out.print("Select an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter the course name: ");
                    String courseName = scanner.nextLine();
                    courses.add(new Course(courseName));
                    break;

                case 2:
                    System.out.print("Enter the student's name: ");
                    String studentName = scanner.nextLine();
                    System.out.print("Select a course to add the student to (by index): ");
                    displayCourses(courses);
                    int courseIndex = scanner.nextInt();
                    scanner.nextLine();
                    if (courseIndex >= 0 && courseIndex < courses.size()) {
                        Course selectedCourse = courses.get(courseIndex);
                        selectedCourse.addStudent(new Student(studentName));
                    } else {
                        System.out.println("Invalid course index.");
                    }
                    break;

                case 3:
                    System.out.print("Enter the student's name: ");
                    studentName = scanner.nextLine();
                    System.out.print("Enter the grade: ");
                    double grade = scanner.nextDouble();
                    for (Course course : courses) {
                        for (Student student : course.getStudents()) {
                            if (student.getStudentName().equals(studentName)) {
                                student.addGrade(grade);
                                break;
                            }
                        }
                    }
                    break;

                case 4:
                    System.out.print("Select a course to calculate the average (by index): ");
                    displayCourses(courses);
                    courseIndex = scanner.nextInt();
                    scanner.nextLine();
                    if (courseIndex >= 0 && courseIndex < courses.size()) {
                        Course selectedCourse = courses.get(courseIndex);
                        double average = calculateCourseAverage(selectedCourse);
                        System.out.println("Course Average: " + average);
                    } else {
                        System.out.println("Invalid course index.");
                    }
                    break;

                case 5:
                    double gpa = calculateGPA(courses);
                    System.out.println("GPA: " + gpa);
                    break;

                case 6:
                    // Implement saving student data to a file
                    // You can use serialization or any other suitable method
                    // Here, you can save the courses and students to a file.
                    System.out.println("Saving student data...");
                    break;

                case 7:
                    // Implement loading student data from a file
                    // You can use deserialization or any other suitable method
                    // Here, you can load the courses and students from a file.
                    System.out.println("Loading student data...");
                    break;

                case 8:
                    System.out.println("Goodbye!");
                    System.exit(0);

                default:
                    System.out.println("Invalid option. Please select a valid option.");
            }
        }
    }

    private static void displayCourses(ArrayList<Course> courses) {
        for (int i = 0; i < courses.size(); i++) {
            System.out.println(i + ". " + courses.get(i).getCourseName());
        }
    }

    private static double calculateCourseAverage(Course course) {
        double totalAverage = 0;
        ArrayList<Student> students = course.getStudents();
        for (Student student : students) {
            totalAverage += student.calculateAverage();
        }
        return students.isEmpty() ? 0 : totalAverage / students.size();
    }

    private static double calculateGPA(ArrayList<Course> courses) {
        double totalPoints = 0;
        double totalCredits = 0;

        for (Course course : courses) {
            double courseAverage = calculateCourseAverage(course);

            // Define your own grading scale and GPA calculation logic here.
            // For example, you can map course averages to GPA values based on your institution's standards.
            // You can also assign different credits to courses and calculate a weighted GPA.
            // Here, we'll use a simple example with an A-F scale.
            totalPoints += mapCourseAverageToGPA(courseAverage);
            totalCredits += 1; // Assuming all courses have equal weight

            // You can add more sophisticated GPA calculations here.
        }

        return totalCredits == 0 ? 0 : totalPoints / totalCredits;
    }

    private static double mapCourseAverageToGPA(double courseAverage) {
        // Define your own mapping logic here based on your grading scale.
        // This is a simple example mapping:
        if (courseAverage >= 90) {
            return 4.0; // A
        } else if (courseAverage >= 80) {
            return 3.0; // B
        } else if (courseAverage >= 70) {
            return 2.0; // C
        } else if (courseAverage >= 60) {
            return 1.0; // D
        } else {
            return 0.0; // F
        }
    }
}
