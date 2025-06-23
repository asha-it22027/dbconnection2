import java.util.List;
import java.util.Scanner;

public class StudentConsoleApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StudentManager manager = new StudentManager();

        while (true) {
            System.out.println("\n====== Student Menu ======");
            System.out.println("1. Add Student");
            System.out.println("2. Delete Student");
            System.out.println("3. Update Student");
            System.out.println("4. Search Student");
            System.out.println("5. Show All Students");
            System.out.println("6. Exit");
            System.out.print("Choose option: ");
            int option = sc.nextInt();
            sc.nextLine(); // clear buffer

            switch (option) {
                case 1:
                    System.out.print("Enter name: ");
                    String name = sc.nextLine();
                    manager.addStudent(name);
                    break;
                case 2:
                    System.out.print("Enter ID to delete: ");
                    int delId = sc.nextInt();
                    manager.removeStudent(delId);
                    break;
                case 3:
                    System.out.print("Enter ID to update: ");
                    int updId = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter new name: ");
                    String newName = sc.nextLine();
                    manager.modifyStudent(updId, newName);
                    break;
                case 4:
                    System.out.print("Enter ID to search: ");
                    int searchId = sc.nextInt();
                    StudentEntity result = manager.findStudent(searchId);
                    if (result != null) {
                        System.out.println("Found: ID = " + result.getId() + ", Name = " + result.getName());
                    } else {
                        System.out.println("Student not found.");
                    }
                    break;
                case 5:
                    List<StudentEntity> students = manager.listStudents();
                    for (StudentEntity s : students) {
                        System.out.println(s.getId() + " - " + s.getName());
                    }
                    break;
                case 6:
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid choice!");
            }
        }
    }
}