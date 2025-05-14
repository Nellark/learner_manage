
import java.util.ArrayList;
import java.util.Scanner;

class Student {
    String name;
    int score;
    int grade;

    Student(String name, int score, int grade) {
        this.name = name;
        this.score = score;
        //this.grade = grade ;
        if (grade == 10) {
            this.grade = grade;
        }else {
            System.out.println("Only Grade 10 allowed");
        }
    }

}

public class Main {
    public static void main(String[] args) {
        ArrayList<Student> students = new ArrayList<>();
        Scanner input = new Scanner(System.in);


        students.add(new Student("Jade", 35, 10));
        students.add(new Student("Life", 60, 10));
        students.add(new Student("Jack", 77, 10));

        int select;
        do {
            System.out.println("\n--- Grade 10 Students---");
            System.out.println("1. Display All Students");
            System.out.println("2. Add Student");
            System.out.println("3. Update Student");
            System.out.println("4. Delete Student");
            System.out.println("5. Average Score");
            System.out.println("6. Search Student by Name");
            System.out.println("0. Exit");
            System.out.print("Select a number: ");
            select = Integer.parseInt(input.nextLine());

            switch (select) {
                case 1 -> displayAllStudents(students);
                case 2 -> addStudent(students, input);
                case 3 -> updateStudent(students, input);
                case 4 -> deleteStudent(students, input);
                case 5 -> calculateAverage(students);
                case 6 -> searchStudent(students, input);
                case 0 -> System.out.println("Goodbye!");
                default -> System.out.println("Invalid choice.");
            }

        } while (select != 0);
    }


    static void displayAllStudents(ArrayList<Student> students) {
        if (students.isEmpty()) {
            System.out.println("No students found.");
            return;
        }


        System.out.println("\n--- Student List ---");
        for (int i = 0; i < students.size(); i++) {
            Student s = students.get(i);
            System.out.println((i + 1) + ". Name: " + s.name + ", Score: " + s.score + ",Grade: " + s.grade);
        }
    }

    static void addStudent(ArrayList<Student> students, Scanner input) {
        System.out.print("Enter student name: ");
        String name = input.nextLine();
        System.out.print("Enter student score: ");
        int score = Integer.parseInt(input.nextLine());
        System.out.print("Enter student grade: ");
        int grade = Integer.parseInt(input.nextLine());

        if (grade != 10) {

            System.out.println("Only Grade 10 allowed");

            System.out.print("Enter student grade: ");
            grade = Integer.parseInt(input.nextLine());


            students.add(new Student(name, score, grade));
            System.out.println("Student added!");

        }
    }
        static void updateStudent(ArrayList<Student> students, Scanner input) {
            displayAllStudents(students);
            if (students.isEmpty()) return;


            System.out.print("Are you sure you want to update the student ? (y/n): ");
            String choose = input.nextLine().trim().toLowerCase();
            if (choose.contains("n"))
            {
                System.out.print("Updating student details cancelled ");
            }
            else if(choose.contains("y")) {

                System.out.print("Enter student option to update: (name/score): ");
                String choose1 = input.nextLine().trim().toLowerCase();
                int index;
                String newName;

                switch (choose1) {
                    case "name":
                        System.out.print("Enter student number to update: ");
                        index = Integer.parseInt(input.nextLine()) -1;

                        if (index >= 0 && index < students.size()) {

                            System.out.print("Enter new name: ");
                            newName = input.nextLine();

                            students.get(index).name = newName;

                            System.out.println("Student updated " + newName);
                        }else {
                            System.out.println("Invalid student number.");
                        }

                        break;
                    case "score":

                        System.out.print("Enter student number to update: ");
                        index = Integer.parseInt(input.nextLine()) - 1;

                        if (index >= 0 && index < students.size()) {

                            System.out.print("Enter new score: ");
                            int score = Integer.parseInt(input.nextLine());

                            students.get(index).score = score;

                            System.out.println("Student updated score" );
                        } else {
                            System.out.println("Invalid student number.");
                        }

                        break;
                    default:
                        System.out.println("Invalid choice.");
                        break;


                }
            }else {
                System.out.print("Invalid choice. ");
            }

        }

    }

