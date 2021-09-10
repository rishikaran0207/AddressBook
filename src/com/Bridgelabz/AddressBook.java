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
                    System.out.println("\n"+members+" contact are created...");
                }
                break;


                case 2: {
                    if(members == 0)
                        System.out.println("\n There is no contact to display");
                    else {
                        option.display(members);
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
