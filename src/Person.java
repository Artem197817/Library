import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Person implements Serializable {
    private final String name;
    private final int age;
    private static List<Person> people = new ArrayList<>();
    public static void setPeople(ArrayList<Person> p){
        people = p;
    }
    public static List<Person> getPeople(){
        return people;
    }
    public String getName() {
        return name;
    }
    public int getAge() {
        return age;
    }
    public Person(String name, int age) {
        this.name = name;
        this.age = age;
        people.add(Person.this);
    }
    @Override
    public String toString() {
        return "Person{" +
                "Имя " + name + '\'' +
                ", возраст " + age +
                '}';
    }
    public static Person personNew() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите имя: ");
        String name = sc.nextLine();
        System.out.println(("Введите возраст:"));
        String age = sc.nextLine();
        sc.close();
        int ageInt = 0;
        if (!age.isEmpty() & age.matches("[0-9]*")) {
            ageInt = Integer.parseInt(age);
        }
        return new Person(name, ageInt);
    }

}
