public class Tools {
    @FunctionalInterface
    interface StringConcatenator {
        String myConcatenation(String str1, String str2);
    }

    public StringConcatenator createMyConcatenation() {
        StringConcatenator concatenator = String::concat;
        return concatenator;
    }

}
