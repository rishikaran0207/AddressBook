package com.Bridgelabz;
import java.util.*;


class AddressBook {
    public static ArrayList<String> check = new ArrayList<String>();
    public static ArrayList<ContactDetails> contactdetails = new ArrayList<ContactDetails>();
    public static Map<Integer, ContactDetails> contactDetailsMap = new HashMap<Integer, ContactDetails>();
    public static int entries = 0;
    public static String[] namelist = new String[5];
    public static Scanner s = new Scanner(System.in);


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


            System.out.print("\n\n Enter the choice What you want to do: ");
            int choice = s.nextInt();

            switch (choice) {
                case 1: {
                    System.out.print("\nhow many no of contact to be added:");
                    int contact = s.nextInt();

                    for (int i = 0; i < contact; i++) {
                        String firstname = null, lastname, address, email, city, state;
                        Integer zip;
                        Long phonenumber;
                        int entrynumber = i + 1;
                        System.out.println("\nThe Entry number is " + entrynumber);
                        System.out.print("\nEnter the First name: ");
                        firstname=s.next();
                        int c=0;
                        while(c<contactdetails.size())
                            if(!(contactdetails.get(c).getFirstname().equals(firstname))){
                                c++;
                            }else{
                                System.out.println("\nName is Already taken");
                                System.out.print("\nEnter the First name: ");
                                firstname=s.next();
                            }
                        namelist[i]=firstname;
                        System.out.print("\nEnter the Last name: ");
                        lastname = s.next();
                        System.out.print("\nEnter the Address: ");
                        address = s.next();
                        System.out.print("\nEnter the city: ");
                        city = s.next();
                        System.out.print("\nEnter the state: ");
                        state = s.next();
                        System.out.print("\nEnter the zip: ");
                        zip = s.nextInt();
                        System.out.print("\nEnter the phone number: ");
                        phonenumber = s.nextLong();
                        System.out.print("\nEnter the EmailID: ");
                        email = s.next();
                        option.add(firstname, lastname, address, city, state, zip, phonenumber, email);

                        System.out.println("\n" + firstname + "'s Contact added successfully!!!");

                        members++;
                    }
                    System.out.println("\n" + members + " contact are created...");
                }
                break;


                case 2: {
                    if (members == 0)
                        System.out.println("\n There is no contact to display");
                    else {
                        option.display();
                    }
                }
                break;

                case 3: {
                    if (members == 0)
                        System.out.println("\n There is no contact to edit!!!!");
                    else {
                        option.display();

                        int e = 0;
                        int flag = 0;
                        System.out.print("\n\nWhich person's detail you want edit: ");
                        String name = s.next();
                        for (int j = 0; j < members; j++) {

                            if (name.equals(namelist[j])) {
                                e = j;
                                j = members + 1;
                                flag = 1;
                                String firstname = null, lastname, address, email, city, state;
                                int zip;
                                long phonenumber;
                                System.out.println("\n\n Enter the details to edit :");
                                System.out.print("\nEnter the First name: ");
                                firstname=s.next();
                                int c=0;
                                while(c<contactdetails.size())
                                    if(!(contactdetails.get(c).getFirstname().equals(firstname))){
                                        c++;
                                    }else{
                                        System.out.println("\nName is Already taken");
                                        System.out.print("\nEnter the First name: ");
                                        firstname=s.next();
                                    }
                                System.out.print("\nEnter the Last name: ");
                                lastname = s.next();
                                System.out.print("\nEnter the Address: ");
                                address = s.next();
                                System.out.print("\nEnter the city: ");
                                city = s.next();
                                System.out.print("\nEnter the state: ");
                                state = s.next();
                                System.out.print("\nEnter the zip: ");
                                zip = s.nextInt();
                                System.out.print("\nEnter the phone number: ");
                                phonenumber = s.nextLong();
                                System.out.print("\nEnter the EmailID: ");
                                email = s.next();
                                option.edit(e, firstname, lastname, address, city, state, zip, phonenumber, email);
                            }
                        }
                        if (flag == 0)
                            System.out.println("\n enter the correct name!!!!");
                    }
                }
                break;

                case 4: {
                    if (members == 0)
                        System.out.println("\n There is no contact to delete!!!!");
                    else {
                        option.display();


                        int e = 0;
                        int flag = 0;
                        System.out.print("\n\nWhich person's detail you want delete: ");
                        String name = s.next();
                        for (int j = 0; j < members; j++) {

                            if (name.equals(namelist[j])) {

                                e = j;
                                j = members + 1;
                                flag = 1;
                                option.delete(e);
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

            }

            System.out.print("\n\nDo you want to continue press 'y' else 'n':");
            char ch = s.next().charAt(0);
            ans = ch;
            option.map();
        } while (ans == 'y');


    }

    public void add(String firstname, String lastname, String address, String city, String state, int zip, long phonenumber, String email) {
        ContactDetails details = new ContactDetails(firstname, lastname, address, city, state, zip, phonenumber, email);
        contactdetails.add(details);
        check.add(firstname);
        entries++;


    }

    public void display() {
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
        System.out.println("\n\nMapping of the contact details:");
        System.out.println("Map:" + contactDetailsMap);
    }

    public void edit(int index, String firstname, String lastname, String address, String city, String state, int zip, long phonenumber, String email) {
        contactdetails.set(index, new ContactDetails(firstname, lastname, address, city, state, zip, phonenumber, email));
        check.set(index, firstname);

    }

    public void delete(int e) {
        contactdetails.remove(e);
    }

    public void map() {
        for (int i = 0; i < entries; i++) {
            Integer a = i + 1;
            contactDetailsMap.put(a, contactdetails.get(i));
        }
    }

}