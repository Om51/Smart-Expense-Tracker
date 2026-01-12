import java.time.LocalDate;
import java.time.Month;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ExpenseService service = new ExpenseService();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n1. Add Expense");
            System.out.println("2. View All Expenses");
            System.out.println("3. Filter by Category");
            System.out.println("4. Monthly Total");
            System.out.println("5. Exit");
            System.out.print("Choose option: ");

            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Title: ");
                    String title = sc.nextLine();

                    System.out.print("Category: ");
                    String category = sc.nextLine();

                    System.out.print("Amount: ");
                    double amount = sc.nextDouble();

                    service.addExpense(
                            new Expense(title, category, amount, LocalDate.now())
                    );
                    System.out.println("Expense added!");
                    break;

                case 2:
                    service.getAllExpenses()
                            .forEach(System.out::println);
                    break;

                case 3:
                    System.out.print("Enter category: ");
                    String cat = sc.nextLine();
                    List<Expense> filtered = service.filterByCategory(cat);
                    filtered.forEach(System.out::println);
                    break;

                case 4:
                    System.out.print("Enter month (e.g. JANUARY): ");
                    Month month = Month.valueOf(sc.nextLine().toUpperCase());
                    System.out.println("Total: ₹" + service.getMonthlyTotal(month));
                    break;

                case 5:
                    System.out.println("Goodbye!");
                    return;

                default:
                    System.out.println("Invalid choice");
            }
        }
    }
}
