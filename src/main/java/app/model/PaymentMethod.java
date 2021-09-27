package app.model;

public enum PaymentMethod {
    CASH("CASH"),
    DEBIT_CARD("DEBIT_CARD"),
    CREDIT_CARD("CREDIT_CARD");

    private String name;

    PaymentMethod(String name) {
        this.name = name;
    }
}
