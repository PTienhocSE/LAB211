package controller;

import model.Person;

class PersonWrapper {

    Person p;

    public PersonWrapper() {
    }

    public PersonWrapper(Person p) {
        this.p = p;
    }
}

public class Programming {

    Validation valid = new Validation();

    private Person inputPersonInfo() {
        System.out.println("Input Information of Person");
        System.out.print("Please input name: ");
        String name = valid.checkInputString();
        System.out.print("Please input address: ");
        String address = valid.checkInputString();
        System.out.print("Please input salary: ");
        double salary = valid.checkInputSalary();
        return new Person(name, address, salary);
    }

    private void swap(PersonWrapper person1, PersonWrapper person2) {
        Person temp = person1.p;
        person1.p = person2.p;
        person2.p = temp;
    }

    private void sortBySalary(Person[] persons, PersonWrapper[] listPersonWrapper) {
        int n = persons.length;

        for (int i = 0; i < persons.length; i++) {
            listPersonWrapper[i] = new PersonWrapper(persons[i]);
        }
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (listPersonWrapper[i].p.salary > listPersonWrapper[j].p.salary) {
                    swap(listPersonWrapper[i], listPersonWrapper[j]);
                }
            }
        }
        System.out.println("Sort sussess.");
        return;
    }

    public void run(){
        int n = valid.checkInputNumberPerSon();
        Person[] persons = new Person[n];
        for (int i = 0; i < persons.length; i++) {
            persons[i] = inputPersonInfo();
        }
        PersonWrapper[] listPersonWrapper = new PersonWrapper[persons.length];
        sortBySalary(persons, listPersonWrapper);
        System.out.println("Information of Person you have entered:");
        for (int i = 0; i < persons.length; i++) {
            System.out.println(listPersonWrapper[i].p.toString());

        }
    }
}
