public static Name {
    private String firstName;
    private String lastName;
    private char middleInitial;
    // adding two new methods

    public String getNormalOrder() {
        return firstName + " " + middleInitial +". " + lastName;

    }
    public String getReverseOrder() {
        return lastName + " " + firstName +". " + middleInitial;
    }

}