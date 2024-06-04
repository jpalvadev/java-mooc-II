public enum Education {
    PHD("Doctoral degree"),
    MA("Masters degree"),
    BA("Bachelors degree"),
    HS("High School diploma");

    private final String degree;

    private Education(String degree) {
        this.degree = degree;
    }

    public String getDegree() {
        return this.degree;
    }
}
