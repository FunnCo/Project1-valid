public enum Columns {
    NAME(0),
    SEX(1),
    AGE(2),
    HEIGHT(3),
    PHONE(4),
    CITY(5);

    private final int columnNumber;

    private Columns(int columnNumber) {
        this.columnNumber = columnNumber;
    }

    public int getColumnNumber() {
        return columnNumber;
    }
}
