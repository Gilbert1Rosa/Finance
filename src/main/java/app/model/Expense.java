package app.model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity(name = "Expenses")
@Table(name = "Expenses", schema = "")
public class Expense {
    @Id
    @GeneratedValue(generator = "UUID2")
    @GenericGenerator(name = "UUID2", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "id", columnDefinition = "VARCHAR(255)")
    private String id;
    private String title;
    private String category;
    @Column(name = "descr")
    private String description;
    @Column(name = "expense_date", columnDefinition = "DATETIME")
    private LocalDateTime date;
    @Column(name = "total_amount")
    private double totalAmount;
    private double taxes;
    @Column(name = "payment_method")
    @Enumerated(EnumType.STRING)
    private PaymentMethod paymentMethod;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public double getTaxes() {
        return taxes;
    }

    public void setTaxes(double taxes) {
        this.taxes = taxes;
    }

    public PaymentMethod getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(PaymentMethod paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public static class Builder {
        private Expense instance;

        public Builder create() {
            instance = new Expense();
            return this;
        }

        public Builder setId(String id) {
            instance.setId(id);
            return this;
        }

        public Builder setTitle(String title) {
            instance.setTitle(title);
            return this;
        }

        public Builder setCategory(String category) {
            instance.setCategory(category);
            return this;
        }

        public Builder setDescription(String description) {
            instance.setDescription(description);
            return this;
        }

        public Builder setDate(LocalDateTime date) {
            instance.setDate(date);
            return this;
        }

        public Builder setTotalAmount(double totalAmount) {
            instance.setTotalAmount(totalAmount);
            return this;
        }

        public Builder setTaxes(double taxes) {
            instance.setTaxes(taxes);
            return this;
        }

        public Builder setPaymentMethod(PaymentMethod paymentMethod) {
            instance.setPaymentMethod(paymentMethod);
            return this;
        }

        public Expense get() {
            return instance;
        }
    }
}
