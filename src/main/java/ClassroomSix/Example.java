package ClassroomSix;

import com.github.javafaker.Faker;

public class Example {
    public static void main(String[] args) {
        System.out.println("This is maven project");
        Employee employeeOne = new Employee("Janis", "Direktors", 1000.32);
        System.out.println(employeeOne.toString());

        Faker faker = new Faker();
        Employee employeeTwo = new Employee(faker.name().firstName(), faker.company().
                profession(), faker.number().randomDouble(2, 100, 2000));

        System.out.println(faker.name().firstName());
        System.out.println(faker.name().lastName());
        System.out.println(faker.company().profession());
        System.out.println(faker.aviation().airport());
        System.out.println(faker.chuckNorris().fact());
        System.out.println(faker.animal().name());
        System.out.println(employeeTwo);
        Employee employeeTree = new Employee();
        System.out.println(employeeTree);

        for (int j = 0; j < 100; j++) {
            Employee employee = new Employee();
            System.out.println(employee);
        }

    }
}
