import java.time.LocalDate;

public class Expense {
    private String title;
    private String category;
    private double amount;
    private LocalDate date;

    public Expense(String title, String category, double amount, LocalDate date) {
        this.title = title;
        this.category = category;
        this.amount = amount;
        this.date = date;
    }

    public String getCategory() {
        return category;
    }

    public double getAmount() {
        return amount;
    }

    public LocalDate getDate() {
        return date;
    }

    @Override
    public String toString() {
        return title + " | " + category + " | ₹" + amount + " | " + date;
    }
}
