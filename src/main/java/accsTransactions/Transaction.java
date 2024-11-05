package accsTransactions;

public record Transaction(
        Account accFrom,
        Account accTo,
        int value
) {
    public Transaction(Account accFrom, Account accTo, int value) {
        this.accFrom = accFrom;
        this.accTo = accTo;
        this.value = value;
    }

    @Override
    public String toString() {
        return value + " from " + accFrom + " to " + accTo;
    }
}
