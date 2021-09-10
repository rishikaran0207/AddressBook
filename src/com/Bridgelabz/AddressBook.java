package com.Bridgelabz;
import java.util.Scanner;
class Contactdetails
{
    public String firstname;
    public String lastname;
    public String address;
    public String city;
    public String state;
    public int zip;
    public long phonenumber;
    public String email;


    Contactdetails(String first,String last,String address,String city,String state,int zip,long phonenumber,String email)
    {
        this.firstname= first;
        this.lastname= last;
        this.address=address;
        this.city=city;
        this.state=state;
        this.zip=zip;
        this.phonenumber=phonenumber;
        this.email=email;
    }

}

class Addressbookoptions
{

    int entries=0;
    Contactdetails[] ContactdetailsArray;

    Addressbookoptions()
    {
        ContactdetailsArray = new Contactdetails[5];
    }

    public void add(String first, String last, String address, String city, String state, int zip, long phonenumber, String email)
    {
        ContactdetailsArray[entries]=new Contactdetails(first,last,address,city,state,zip,phonenumber,email);
        entries++;
    }

    public void display(int items) {
        System.out.println("\n\nDisplaying  the contact details....");
        for (int i = 0; i < items; i++) {
            int j = i + 1;
            System.out.println("\n\nThe entry " + j + " is Contact detail of " + ContactdetailsArray[i].firstname);
            System.out.print("\nFirst name: " + ContactdetailsArray[i].firstname);
            System.out.print("\nLast name: " + ContactdetailsArray[i].lastname);
            System.out.print("\nAddress: " + ContactdetailsArray[i].address);
            System.out.print("\nCity: " + ContactdetailsArray[i].city);
            System.out.print("\nState: " + ContactdetailsArray[i].state);
            System.out.print("\nzip: " + ContactdetailsArray[i].zip);
            System.out.print("\nPhone number: " + ContactdetailsArray[i].phonenumber);
            System.out.print("\nEmailId: " + ContactdetailsArray[i].email);

        }
    }

    public void edit(int item,String first, String last, String address, String city, String state, int zip, long phonenumber, String email)
    {
        ContactdetailsArray[item]=new Contactdetails(first,last,address,city,state,zip,phonenumber,email);
    }


}

public class AddressBook {

    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);
        Addressbookoptions option = new Addressbookoptions();
        String[] namelist = new String[5];
        int members = 0;
        char ans;

        do {
            System.out.println("\n\n Here are some option for addressbook");
            System.out.println("1.Add the contact...");
            System.out.println("2.Display the contact....");
            System.out.println("3.Edit the contact...");




            System.out.print("\n\n Enter the choice What you want to do: ");
            int choice = s.nextInt();

            switch (choice) {
                case 1: {
                    System.out.print("\nhow many no of contact to be added:");
                    int contact = s.nextInt();

                    for (int i = 0; i < contact; i++) {
                        String first, last, address, email, city, state;
                        int zip;
                        long phonenumber;
                        int entrynumber = i + 1;
                        System.out.println("\nThe Entry number is " + entrynumber);
                        System.out.print("\nEnter the First name: ");
                        first = s.next();
                        namelist[i] = first;
                        System.out.print("\nEnter the Last name: ");
                        last = s.next();
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
                        option.add(first, last, address, city, state, zip, phonenumber, email);

                        System.out.println("\n" + first + "'s Contact added successfully!!!");

                        members++;
                    }
                    System.out.println("\n" + members + " contact are created...");
                }
                break;


                case 2: {
                    if (members == 0)
                        System.out.println("\n There is no contact to display");
                    else {
                        option.display(members);
                    }
                }
                break;

                case 3:
                {
                    if(members == 0)
                        System.out.println("\n There is no contact to edit!!!!");
                    else {
                        option.display(members);

                        int e = 0;
                        int flag=0;

                        for (int j = 0; j < members; j++) {
                            System.out.print("\n\nWhich person's detail you want edit: ");
                            String name = s.next();
                            if (name.equals(namelist[j])){
                                e = j;
                                j = members + 1;
                                flag=1;
                                String first, last, address, email, city, state;
                                int zip;
                                long phonenumber;
                                System.out.println("\n\n Enter the details to edit :");
                                System.out.print("\nEnter the First name: ");
                                first = s.next();
                                namelist[e] = first;
                                System.out.print("\nEnter the Last name: ");
                                last = s.next();
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
                                option.edit(e, first, last, address, city, state, zip, phonenumber, email);
                            }
                        }
                        if(flag == 0)
                            System.out.println("\n enter the correct name!!!!");
                    }
                }
                break;



            }
            System.out.print("\n\nDo you want to continue press 'y' else 'n':" );
            char ch =s.next().charAt(0);
            ans=ch;
        }while(ans == 'y');

    }
}
