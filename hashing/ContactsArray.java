package hashing;

import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;

public class ContactsArray {

    private static void printContactsInGroups(Contact[] contacts) {
        Map<String, Integer> names = new HashMap<>();
        Map<String, Integer> emails = new HashMap<>();
        Map<String, Integer> phoneNos = new HashMap<>();
        List<ArrayList<Integer>> groups = new ArrayList<ArrayList<Integer>>();
        int index = 0, group_index;

        for(int i = 0; i < contacts.length; i++) {
            if (names.containsKey(contacts[i].name)) {
                group_index = names.get(contacts[i].name);
            } else if (emails.containsKey(contacts[i].email)) {
                group_index = emails.get(contacts[i].email);
            } else if (phoneNos.containsKey(contacts[i].phoneNo)) {
                group_index = phoneNos.get(contacts[i].phoneNo);
            } else {
                names.put(contacts[i].name, index);
                emails.put(contacts[i].email, index);
                phoneNos.put(contacts[i].phoneNo, index++);

                ArrayList<Integer> group = new ArrayList<>();
                group.add(i);
                groups.add(group);
                continue;
            }

            List<Integer> group = groups.get(group_index);
            group.add(i);
        }

        printGroups(groups, contacts);
    }

    private static void printGroups(List<ArrayList<Integer>> groups, Contact[] contacts) {
        for (List<Integer> contactGroup : groups) {
            for(int con : contactGroup) {
                System.out.println(contacts[con].toString());
            }
            System.out.println();
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Contact[] contacts =  { new Contact("Harish", "harish@gmail.com", "1234"),
                                new Contact("Hari", "harish@gmail.com", "2345"),
                                new Contact("Rahul", "rahul@etc.com", "3456"),
                                new Contact("Kiran", "kiran@abc.com", "4567"),
                                new Contact("Sneha", "sneha@yahoo.com", "12345"),
                                new Contact("Naveen", "naveen@gmail.com", "6789"),
                                new Contact("Rakesh", "rakesh@yahoo.com", "7890"),
                                new Contact("Rakesh", "rakeshkumar@gmail.com", "8901"),
                                new Contact("Naveen Kumar", "naveenkumar@gmail.com", "6789"),
                                new Contact("Kiran Kumar", "kirankumar@abc.com", "4567")
                                };
        printContactsInGroups(contacts);
    }

    private static class Contact {
        String name;
        String email;
        String phoneNo;

        Contact(String name, String email, String phoneNo) {
            this.name = name;
            this.email = email;
            this.phoneNo = phoneNo;
        }

        @Override
        public String toString() {
            return "Name : " + this.name + ", Email : " + this.email +
                   ", Phone No : " + this.phoneNo;
        }
    }
}