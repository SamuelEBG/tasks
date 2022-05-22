package pgr112.step10new;

public class Main {
    public static void main(String[] args) {
        Program prod = new Program();
        // prod.personHashSet.forEach(System.out::println);
        prod.getSamplePerson("Anders andersson").ifPresent(System.out::println);
        // prod.addPerson("johan", 5);
        // prod.getPeopleOlderThan(50).forEach(System.out::println);
        prod.youngestPerson().ifPresent(System.out::println);
        prod.oldestPersonName().ifPresent(System.out::println);
    }
}
