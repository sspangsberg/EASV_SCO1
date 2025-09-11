public class Main {
    public static void main(String[] args)
    {
        Person p = new Person(
                "Peter",
                "Middle",
                "Petersen",
                35,
                180
        );

        // Long parameter code smells
        printPersonInfo(p);
    }

    static void printPersonName(Person person) {
        System.out.println(person.getFirstName());
        System.out.println(person.getMiddleName());
        System.out.println(person.getLastName());
    }

    static void printPersonInfo(Person person) {
        // many lines of code > 10

        printPersonName(person);

        // Print person data
        System.out.println(person.getAge());
        System.out.println(person.getHeight());
    }
}






