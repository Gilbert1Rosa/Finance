package app.controller.model;

public enum QueryType {
    ALL("ALL"),
    DATE_BETWEEN("DATE_BETWEEN"),
    BY_TITLE("BY_TITLE"),
    BY_CATEGORY("BY_CATEGORY"),
    CATEGORY_PERCENTAGE("CATEGORY_PERCENTAGE");

    private final String name;

    QueryType(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public static QueryType getQueryTypeByName(String name) {
        QueryType[] types = QueryType.values();
        QueryType found = null;
        for (QueryType type : types) {
            if (type.getName().equals(name)) {
                found = type;
            }
        }
        return found;
    }
}
