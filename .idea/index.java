
import model.Students;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


class index {
    public static List<model.Students> studentList = new ArrayList<>();
    private static final Scanner input = new Scanner(System.in);

    public static void main(String[] args) {

        int choose;
        do {
            Menu();
            System.out.print("\nChoose option (0-6): ");
            choose = getInput();

            switch (choose) {
                case 1:
                 addStudent();
                    break;
                case 2:
                    // displayAllStudents();
                    break;
                case 3:
                    // updateStudent();
                    break;
                case 4:
                    deleteStudent();
                    break;
                case 5:
                    // searchStudent();
                    break;
                case 6:
                    //calculateAverage();
                    break;
                case 0:
                    System.out.println("Thank you for using our system.");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid option, please try again.");
            }
        } while (true);
    }

    private static int getInput() {
        while (true) {
            try {
                int value = input.nextInt();
                input.nextLine();
                return value;
            } catch (Exception e) {
                input.nextLine();
                System.out.print("Invalid input, please enter a number (0-6): ");
            }
        }
    }

    /**
     * Menu
     */
    public static void Menu() {
        System.out.println("\n---Student Management ---");
        System.out.println("\t\t   Menu   ");
        System.out.println("\t\t1. Add New Student");
        System.out.println("\t\t2. Display All Students");
        System.out.println("\t\t3. Update Student");
        System.out.println("\t\t4. Delete Student");
        System.out.println("\t\t5. Search Student by Name");
        System.out.println("\t\t6. Calculate Average (All Students)");
        System.out.println("\t\t0. Exit");

    }
    public static void addStudent() {
        System.out.println("\n---------- Add New Student ----------");

        boolean continueAdding = true;

        /*
         * Initial user prompt
         */

        System.out.println("Do you want to add a student? (Yes/No (exit)): ");
        String initialChoice = input.nextLine().trim().toLowerCase();

        if (initialChoice.equals("yes") || initialChoice.equals("y")) {
            do {
                /*
                 *  Confirmation prompt
                 *  Asking them they want to add a new student / not
                 */

                System.out.println("Are you sure you want to add a new student? (Yes/No (exit)): ");
                String userChoice = input.nextLine().trim().toLowerCase();

                switch (userChoice) {
                    case "yes":
                    case "y":
                        System.out.print("Enter student name: ");
                        String name = input.nextLine();

                        int score;
                        do {
                            System.out.print("Enter student score (0 - 100): ");
                            score = getInput();
                            if (score < 0 || score > 100) {
                                System.out.println("Invalid score, please enter a score between 0 and 100.");
                            }
                        } while (score < 0 || score > 100);

                        int grade;
                        do {
                            System.out.print("Enter student grade (only 10): ");
                            grade = input.nextInt();
                            if (grade != 10) {
                                System.out.println("Invalid grade, please enter a grade 10 only.");
                            }
                        } while (grade != 10);
                        input.nextLine();


                        studentList.add(new Students(name, score, grade));
                        System.out.println("Added student details successfully.");

                        System.out.print("\nDo you want to add another student? (Yes/No (exit)): ");
                        String continueChoice = input.nextLine().trim().toLowerCase();
                        continueAdding = continueChoice.equals("yes") || continueChoice.equals("y");
                        break;

                    case "no":
                    case "n":
                        System.out.println("Adding student process has been canceled.");
                        continueAdding = false;
                        break;

                    default:
                        System.out.println("Invalid input, please enter Yes/No (exit).");
                        break;
                }
            } while (continueAdding);
        } else {
            System.out.println("No student will be added.");
        }
    }


    public static void displayAllStudents() {
        System.out.println("\n---------- All Students ----------");
        if (studentList.isEmpty()) {
            System.out.println("No students available to be displayed yet.");
        } else {
            for (int i = 0; i < studentList.size(); i++) {
                String studentName = studentList.get(i).getStudentName().substring(0,1).toUpperCase() +
                        studentList.get(i).getStudentName().substring(1).toLowerCase();
                int  studentScore = studentList.get(i).getStudentScore();
                int studentGrade = studentList.get(i).getStudentGrade();
                System.out.println("\nStudent #" + (i+1) +":"+
                        " Student Name: " + studentName +" | "+
                        " Student Score: "+ studentScore +" | "+
                        " Student Grade: " + studentGrade);
            }
        }
    }
    public static void searchStudent() {
        System.out.println("\n---------- Search Student ----------");
        if (studentList.isEmpty()) {
            System.out.println("The search did not return any student results at the moment.");
            return;
        }else{
            String choice;
            do {



                System.out.print("\nEnter Student Name: ");
                String studentName = input.nextLine().trim();




                Students foundStudent = null;
                for (Students student : studentList) {
                    if (student.getStudentName().equalsIgnoreCase(studentName)) {
                        foundStudent = student;
                        break;}}

                if (foundStudent != null) {
                    System.out.println("Student  name found: " + foundStudent.getStudentName());
                } else {
                    System.out.println("Student name " + studentName + " not found.");
                }




                System.out.print("\nDo you want to search another student? (Yes/No): ");
                choice = input.nextLine().trim().toLowerCase();

            } while (!choice.equals("no") && !choice.equals("n"));
        }
    }




public static void deleteStudent() {

        System.out.println("\n---------- Delete Student ----------");
        /*
         * It check if student list is empty then it will return message
         */
        if (studentList.isEmpty()) {
            System.out.println("No students available to be deleted yet.");
            return;
        }

        boolean continueDelete = true;


        do {

            System.out.println("Are you sure you want to delete a student? (Yes/No): ");
            String userChoice = input.nextLine().trim().toLowerCase();

            switch (userChoice) {
                case "yes":
                case "y":
                    /*
                     * Outputs all student entries that are currently stored in the system.
                     */

                    System.out.println("\n---------- Current Students ----------");
                    for (int i = 0; i < studentList.size(); i++) {
                        String studentName = studentList.get(i).getStudentName().substring(0, 1).toUpperCase() +
                                studentList.get(i).getStudentName().substring(1).toLowerCase();
                        System.out.println((i + 1) + ". " + "Student Name: " + studentName);
                    }

                    /*
                     * It ask a user to delete name, all user information will be deleted
                     */
                    System.out.print("\nEnter student name to delete: ");
                    String studentToDelete = input.nextLine().trim();
                    boolean studentFound = false;

                    /*
                     * It formats name to be deleted
                     */

                    String formattedName = studentToDelete.substring(0, 1).toUpperCase() + studentToDelete.substring(1).toLowerCase();

                    for (int i = 0; i < studentList.size(); i++) {
                        if (studentList.get(i).getStudentName().equalsIgnoreCase(formattedName)) {
                            model.Students deletedStudent = studentList.remove(i);

                            String studentName = deletedStudent.getStudentName().substring(0, 1).toUpperCase() +
                                    deletedStudent.getStudentName().substring(1).toLowerCase();
                            int studentScore = deletedStudent.getStudentScore();
                            int studentGrade = deletedStudent.getStudentGrade();
                            System.out.println("\n---------- Student Deleted Details ----------" +
                                    "Student Name: " + studentName + " | " +
                                    " Student Score: " + studentScore + "%" + " | " +
                                    " Student Grade: " + studentGrade +
                                    "\nDeleted successfully...");
                            studentFound = true;
                            break;
                        }
                    }

                    if (!studentFound) {
                        System.out.println("No student found with name: " + formattedName);
                    }

                    System.out.println("Are you sure you want to delete another student? (Yes/No (exit): ");
                    String continueChoice = input.nextLine().trim().toLowerCase();

                    continueDelete = continueChoice.equals("yes") || continueChoice.equals("y");
                    break;

                case "no":
                case "n":
                    /*
                      Closes the delete student function and goes back to the menu.
                     */
                    System.out.println("Deleting student process has been canceled.");
                    continueDelete = false;
                    break;

                default:
                    System.out.println("Invalid input, please enter (Yes/No).");
            }
        } while (continueDelete);
    }

}
