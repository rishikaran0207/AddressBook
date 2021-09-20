package com.Bridgelabz;
import java.util.*;


class AddressBook {
    public static ArrayList<ContactDetails> contactdetails = new ArrayList<ContactDetails>();
    public static Map<String, ContactDetails> contactDetailsMap = new HashMap<String, ContactDetails>();
    public static int entries = 0, cityentry =0, stateentry =0;
    public static String[] namelist = new String[5];
    public static Scanner scan = new Scanner(System.in);


    public static void main(String[] args) {


        AddressBook option = new AddressBook();


        int members = 0;

        char ans;

        do {
            System.out.println("\n\n Here are some option for addressbook");
            System.out.println("1.Add the contact...");
            System.out.println("2.Display the contact....");
            System.out.println("3.Edit the contact...");
            System.out.println("4.Delete the contact...");
            System.out.println("5.search by city or state");


            System.out.print("\n\n Enter the choice What you want to do: ");
            int choice = scan.nextInt();

            switch (choice) {
                case 1: {
                    System.out.print("\nhow many no of contact to be added:");
                    int contact = scan.nextInt();

                    for (int i = 0; i < contact; i++) {
                        String firstname = null, lastname, address, email, city, state;
                        Integer zip;
                        Long phonenumber;
                        int entrynumber = i + 1;
                        System.out.println("\nThe Entry number is " + entrynumber);
                        System.out.print("\nEnter the First name: ");
                        firstname = scan.next();
                        int c = 0;
                        while (c < contactdetails.size())
                            if (!(contactdetails.get(c).getFirstname().equals(firstname))) {
                                c++;
                            } else {
                                System.out.println("\nName is Already taken");
                                System.out.print("\nEnter the First name: ");
                                firstname = scan.next();
                            }
                        namelist[i] = firstname;
                        System.out.print("\nEnter the Last name: ");
                        lastname = scan.next();
                        System.out.print("\nEnter the Address: ");
                        address = scan.next();
                        System.out.print("\nEnter the city: ");
                        city = scan.next();
                        System.out.print("\nEnter the state: ");
                        state = scan.next();
                        System.out.print("\nEnter the zip: ");
                        zip = scan.nextInt();
                        System.out.print("\nEnter the phone number: ");
                        phonenumber = scan.nextLong();
                        System.out.print("\nEnter the EmailID: ");
                        email = scan.next();
                        option.add_contact(firstname, lastname, address, city, state, zip, phonenumber, email);

                        System.out.println("\n" + firstname + "'scan Contact added successfully!!!");

                        members++;
                    }
                    System.out.println("\n" + members + " contact are created...");
                }
                break;


                case 2: {
                    if (members == 0)
                        System.out.println("\n There is no contact to display_all_contact");
                    else {
                        option.map_all_contact();
                        option.display_all_contact();
                        System.out.println("\n\nMapping of the contact details:");
                        System.out.println("Map:" + contactDetailsMap);
                    }
                }
                break;

                case 3: {
                    if (members == 0)
                        System.out.println("\n There is no contact to edit_contact!!!!");
                    else {
                        option.display_all_contact();

                        int e = 0;
                        int flag = 0;
                        System.out.print("\n\nWhich person'scan detail you want edit_contact: ");
                        String name = scan.next();
                        for (int j = 0; j < members; j++) {

                            if (name.equals(namelist[j])) {
                                e = j;
                                j = members + 1;
                                flag = 1;
                                String firstname = null, lastname, address, email, city, state;
                                int zip;
                                long phonenumber;
                                System.out.println("\n\n Enter the details to edit_contact :");
                                System.out.print("\nEnter the First name: ");
                                firstname = scan.next();
                                int c = 0;
                                while (c < contactdetails.size())
                                    if (!(contactdetails.get(c).getFirstname().equals(firstname))) {
                                        c++;
                                    } else {
                                        System.out.println("\nName is Already taken");
                                        System.out.print("\nEnter the First name: ");
                                        firstname = scan.next();
                                    }
                                System.out.print("\nEnter the Last name: ");
                                lastname = scan.next();
                                System.out.print("\nEnter the Address: ");
                                address = scan.next();
                                System.out.print("\nEnter the city: ");
                                city = scan.next();
                                System.out.print("\nEnter the state: ");
                                state = scan.next();
                                System.out.print("\nEnter the zip: ");
                                zip = scan.nextInt();
                                System.out.print("\nEnter the phone number: ");
                                phonenumber = scan.nextLong();
                                System.out.print("\nEnter the EmailID: ");
                                email = scan.next();
                                option.edit_contact(e, firstname, lastname, address, city, state, zip, phonenumber, email);
                            }
                        }
                        if (flag == 0)
                            System.out.println("\n enter the correct name!!!!");
                    }
                }
                break;

                case 4: {
                    if (members == 0)
                        System.out.println("\n There is no contact to delete_contact!!!!");
                    else {
                        option.display_all_contact();


                        int e = 0;
                        int flag = 0;
                        System.out.print("\n\nWhich person'scan detail you want delete_contact: ");
                        String name = scan.next();
                        for (int j = 0; j < members; j++) {

                            if (name.equals(namelist[j])) {

                                e = j;
                                j = members + 1;
                                flag = 1;
                                option.delete_contact(e);
                                for (int k = e; k < members - 1; k++) {
                                    namelist[k] = namelist[k + 1];
                                }
                            }
                        }


                        if (flag == 1)
                            System.out.println("\ndeleted successfully!!!!");
                        else
                            System.out.println("\n enter correct name!!!!");
                    }
                }
                break;

                case 5: {
                    if (members == 0)
                        System.out.println("\n There is no contact to delete_contact!!!!");
                    else {
                        option.view_by_state_or_city();
                    }

                }
                break;
            }
            System.out.print("\n\nDo you want to continue press 'y' else 'n':");
            char ch = scan.next().charAt(0);
            ans = ch;


        } while (ans == 'y');


    }

    public void add_contact(String firstname, String lastname, String address, String city, String state, int zip,
                            long phonenumber, String email) {
        ContactDetails details = new ContactDetails(firstname, lastname, address, city, state, zip, phonenumber, email);
        contactdetails.add(details);
        entries++;


    }

    public void display_all_contact() {
        System.out.println("\n\nDisplaying  the contact details....");
        Iterator itr = contactdetails.iterator();
        while (itr.hasNext()) {
            ContactDetails details = (ContactDetails) itr.next();
            System.out.print("\n\nFirst name: " + details.getFirstname());
            System.out.print("\nLast name: " + details.getLastname());
            System.out.print("\nAddress: " + details.getAddress());
            System.out.print("\nCity: " + details.getCity());
            System.out.print("\nState: " + details.getState());
            System.out.print("\nzip: " + details.getZip());
            System.out.print("\nPhone number: " + details.getPhonenumber());
            System.out.print("\nEmailId: " + details.getEmail());
        }

    }

    public void edit_contact(int index, String firstname, String lastname, String address, String city, String
            state, int zip, long phonenumber, String email) {
        contactdetails.set(index, new ContactDetails(firstname, lastname, address, city, state, zip, phonenumber, email));
    }

    public void delete_contact(int e) {
        contactdetails.remove(e);
    }

    public void map_all_contact() {
        for (int i = 0; i < entries; i++) {
            Integer a = i + 1;
            contactDetailsMap.put(contactdetails.get(i).getFirstname(), contactdetails.get(i));
        }
    }

    public void map_all_person_by_state(int i) {
        contactDetailsMap.put(contactdetails.get(i).getFirstname(), contactdetails.get(i));
    }

    public void map_all_person_by_city(int i) {
        contactDetailsMap.put(contactdetails.get(i).getFirstname(), contactdetails.get(i));
    }


    public void view_by_state_or_city() {
        System.out.println("\nBy which you what to search city or state..");
        String type = scan.next();
        switch (type.toLowerCase()) {
            case "state": {
                System.out.println("\nEnter the state:");
                String checkstate = scan.next();
                System.out.println("\nDetails of persons in " + checkstate + " state");
                int check = 0, i = 0;
                while (check < entries) {
                    if (checkstate.equals(contactdetails.get(i).getState())) {
                        map_all_person_by_state(i);
                        System.out.println("\n" + contactDetailsMap);
                        check++;
                        i++;
                        stateentry++;
                    } else {
                        check++;
                        i++;
                    }
                }
                if (stateentry == 0)
                    System.out.println("\nNo entries are there.....");
                else
                    System.out.println("\n There are "+stateentry+" contact persons in the state");
            }
            break;

            case "city": {
                System.out.println("\nEnter the city:");
                String checkcity = scan.next();
                int check = 0, i = 0;
                System.out.println("\nDetails of persons in " + checkcity + " city");
                while (check < entries) {
                    if (checkcity.equals(contactdetails.get(i).getCity())) {
                        map_all_person_by_city(i);
                        System.out.println("\n" + contactDetailsMap);
                        check++;
                        i++;
                        cityentry++;
                    } else {
                        check++;
                        i++;
                    }
                }
                if (cityentry == 0)
                    System.out.println("\nNo entries are there.....");
                else
                    System.out.println("\n There are "+cityentry+" contact persons in the city");

            }
            break;
        }
    }

}