//public class index {
//    public static void main(String[] args) {
//
//    }
//}



import model.Student;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


class index {
    public static List<model.Student> studentList = new ArrayList<>();
    private static final Scanner input = new Scanner(System.in);

    public static void main(String[] args) {

        int choose;
        do {
            Menu();
            System.out.print("\nChoose option (0-6): ");
            choose = getInput();

            switch (choose) {
                case 1:
                    //  addStudent();
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
                            model.Student deletedStudent = studentList.remove(i);

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
