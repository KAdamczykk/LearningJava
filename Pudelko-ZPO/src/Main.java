public class Main {
    public static void main(String[] args) {
        MyBox box = new MyBox();
        for (Gadzety elem:box.getList()) {
            System.out.println(elem);
        }
        box.detectCaloricFood();
        box.detectNonAttestationChew();
        System.out.println(box.getSummarizedDryFoodCalories());
        MyBox.InMyBox inMyBox = box.new InMyBox();
        inMyBox.upgradeProducerName("Hueueue");
        inMyBox.upgradeFrequency4All();
        for (Gadzety elem:inMyBox.getList()) {
            System.out.println(elem);
        }
        System.out.println(inMyBox.getAverageWetFoodCalories());
        Tools funnyTools = new Tools();
        Tools.StringConcatenator concatenator = funnyTools.createMyConcatenation();

        String result = concatenator.myConcatenation("Hello", "World");
        System.out.println(result); 

    }
}