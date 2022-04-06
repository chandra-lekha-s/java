package ZMS;


import java.sql.Time;
import java.util.Date;
import java.util.Scanner;

// Animals      Birds       Aquatic     Vaccine 
// Employees    Donors      Owners      Visitors    Care_taker

// class C1 M1
// Class C2 M2 obj of M1 => obj
// main obj2 

// Anonymous Object 
// new test().d()


//   ZOO MANAGEMENT SYSTEM

// new instance method

class basic1{

    private static String adminId= "chandu123",adminPassword= "chandu890";
    private static String customerId= "chandu",customerPassword= "chandu";
    static{
        System.out.println("\n\t WELCOME TO BENGALURU ZOO");
    }
    public static void main(String args[]){

        System.out.println("\t\tHELLO "+args[0]);
        int choice;
        String userId,userPassword;
        Scanner sc = new Scanner (System.in);

        System.out.print("\nEnter the user type : \n\t 1. Admin \n\t 2. User \nEnter your choice :");
        choice=sc.nextInt();
        userId=sc.nextLine();        

        switch(choice){
            case 1: System.out.print("Enter admin ID : ");
                    userId=sc.nextLine();
                    System.out.print("Enter admin password : ");
                    userPassword=sc.nextLine();

                    if(userId.equals(adminId) & userPassword.equals(adminPassword)){
                        System.out.print("\nWelcome admin");
                        Users adminObj=new Users();
                        adminObj.admin();

                    }
                    else{
                        System.out.print("\nINVALID CREDENTIALS");
                    }
                    break;

            case 2: System.out.print("Enter user ID : ");
                    userId=sc.nextLine();
                    System.out.print("Enter user password : ");
                    userPassword=sc.nextLine();

                    if(userId.equals(customerId) & userPassword.equals(customerPassword)){
                        System.out.println("Welcome "+userId);
                        Users userObj=new Users();
                        userObj.user();
                    }
                    else{
                        System.out.println("INVALID CREDENTIALS");
                    };
                    break;
            
            default:System.out.println("INVALID CHOICE");break;
        }
        sc.close();
    }
}

////////////////////////         U S E R S       /////////////////////////////

class Users{

    public void admin(){
        int choice=0,loop=1;
        Scanner sc = new Scanner (System.in);
        
        System.out.println("Enter your choice\n\t 1. View tickets booked \n\t 2. Care taker \n\t 3. Set ticket price  \n\t 5. Log out");

        while(loop==1){
            System.out.println("\nEnter your choice : ");
        choice=sc.nextInt();
        switch(choice){

            case 1 :   Tickets obj1 = new Tickets();
                        obj1.verify();
                        break;
        
            case 2 :   Care_taker ct1 = new Care_taker(12,"Siya",965485214,"sia@gmail.com","Banglore",10000,"Land","night"),
                                  ct2=new Care_taker(41,"Ram","night"),
                                  ct3=new Care_taker(10,"Sam",854769325,"sam@gmail.com","Banglore",15000,"Land","night"){
                                        public void get_details() {
                                              System.out.println("\nCare taker ID : "+c_id+"\nName : "+c_name+"\nShift : "+shift+"\nContact : "+c_contact+"\nEmail : "+c_email+"\nAddress : "+c_address);
                                            }
                                  };
                        // ANONYMOUS CLASS
                        
                        // SHALLOW COPY
                        Care_taker ct4=ct1;

                        System.out.println("\nOBJECT 1");
                        ct1.get_details();

                        System.out.println("\nOBJECT 4 SHALLOW COPY OF OBJECT 1 - CHAGE SHIFT");
                        ct4.change_of_shift("morning");

                        System.out.println("\nOBJECT 2 ");
                        ct2.get_details();

                        // DEEP COPY
                        Care_taker ct5= new Care_taker(41,"Chandu","morning");
                        ct5.c_id=ct2.c_id;
                        ct5.c_name=ct2.c_name;
                        ct5.shift=ct2.shift;

                        // System.out.println("\nOBJECT 5 DEEP COPY OF OBJECT 2");
                        // ct5.get_details();
                        
                        System.out.println("\nOBJECT 2 - CHANGE SHIFT");
                        // ct1.change_of_shift("morning");
                        ct2.change_of_shift("morning");

                        System.out.println("\nOBJECT 5 DEEP COPY OF OBJECT 2");
                        ct5.get_details();

                        System.out.println("\nOBJECT 3 : ANONYMOUS CLASS");
                        ct3.get_details();
                        break;

            // STATIC METHOD
            case 3 :    System.out.println("Enter the ticket price : ");
                        float price=sc.nextFloat();
                        Tickets.set_price(price);
                        Tickets.VIP.vip_pass(price);
                        Tickets.VIP.vip_pass(price, 10);
                     break;
                                
            case 5 :    loop=0;break;
            default : loop=1;
        }
    }

        sc.close();
    }

 

    public void user(){
        int choice=0,loop=1;
        Scanner sc = new Scanner (System.in);
        
        System.out.println("Enter your choice\n\t 1. Advance booking \n\t 2. Cancel booking \n\t 3. VIP passes \n\t 5. Log out");

        while(loop==1){
            System.out.println("Enter your choice : ");
        choice=sc.nextInt();
        switch(choice){

            case 1 :    System.out.println(("Enter the no. of tickets : "));
                        int no_of_ticket=sc.nextInt();
                        // Date date=sc.next();
                        // Date date = new Date(2000, 11, 21);;
                        Tickets obj1 = new Tickets();
                        obj1.advance_booking(no_of_ticket);
                        break;

            case 2 :    System.out.println(("Enter the ticket ID : "));
                        int id=sc.nextInt();
                        Tickets obj2 = new Tickets();
                        obj2.cancel_booking(id);
                        break;

            case 3 :    Tickets obj3 = new Tickets();
                        obj3.advance_booking();
                        break;

            case 5 :    loop=0;
        }
    }

        sc.close();
    }

}

////////////////////////         O W N E R       /////////////////////////////

class Owner{
    int id;
    String name;
    int contact;
    int a_id;
    String email;
    String address;

    public void get_details(){}
    public void most_owned(){}
    public void least_owned(){}
    public void adopt(){}
}

////////////////////////         V I SI T O R S       /////////////////////////////

class Visitors{
    int v_id;
    String v_name;
    int v_contact;
    String v_email;
    int count;

    public void get_details(){}
    public void most_visited(){}
    public void least_visited(){}
}


////////////////////////////////     B A S I C   2     //////////////////



//  VACCINE     CARE_TAKER      SECURITY      MANAGER

class Vaccine{
    int v_id;
    String v_name;
    String v_description;
    int min_age;
    int max_age;
    String animal_type;
    int dose_count;

    public void get_details(){}
    public void most_used(){}
    public void least_used(){}
    public void on_demand(){}
}

class Manager{
    int e_id;
    String e_name;
    int e_contact;
    String e_email;
    String e_address;
    int salary;
    Date joining_date;
    String department;
    String shift;
     
    public void get_details(){}

    public void change_of_department(String department){
        this.department=department;
    }
    public void change_of_shift(String shift){
        this.shift=shift;
    }
    private void payment(){
        int payment_id ;
        String e_name ;
        String mode ;
        Date date ;
        Time Ranking;
    }
}

class Security{
    int e_id;
    String e_name;
    int e_contact;
    String e_email;
    String e_address;
    int salary;
    String shift;
    Date joining_date;

    public void get_details(){}
    public void change_of_shift(){}
    private void payment(){}
}

class Care_taker{
    int c_id;
    String c_name;
    int c_contact;
    String c_email;
    String c_address;
    int c_salary;
    String animal_type;
    String shift;


    // CONSTRUCTOR OVERLOADING
    public Care_taker(int c_id, String c_name, String shift){
        this.c_id=c_id;
        this.c_name=c_name;
        this.shift=shift;
    }

    public  Care_taker(int c_id,String c_name,int c_contact,String c_email,String c_address,int c_salary,String animal_type,String shift){
        this(c_id,c_name,shift);
        this.c_contact=c_contact;
        this.c_email=c_email;
        this.c_address=c_address;
        this.c_salary=c_salary;
        this.animal_type=animal_type;
    }

    
    public void get_details(){
        System.out.println("\nCare taker ID : "+c_id+"\nName : "+c_name+"\nShift : "+shift);
    }
    public void change_of_shift(String shift){
        this.shift=shift;
        System.out.println("\nCare taker ID : "+c_id+"\nName : "+c_name+"\nShift : "+shift);
    }
    public void change_of_department(){}
    private void payment(){}
}



/////////////////////////////       B A S I C   3        //////////////////

// Tickets      DONATIONS

class Tickets{
    Date date;
    // static int ticket_id;

    // STATIC VARIABLES
    int no_of_ticket;
    static float price=60;
    static int max_ticket=10;

    static int Tickets[] =new int[20]; //    No. of tickets ;
    static int ticketId; 

    // public void advance_booking(int no_of_ticket,Date date){

    // METHOD OVERLOADING
    public void advance_booking(int no_of_ticket){
        // ticket_id=ticket_id+1;
        // this.date=date;
        this.no_of_ticket=no_of_ticket;

        if(no_of_ticket>max_ticket){
            System.out.println("You are exceeding the max ticket numbers");
        }else{

            Tickets[ticketId]=no_of_ticket;
            ticketId=ticketId+1;

            System.out.println("Your ticket Id is "+ticketId+" for "+no_of_ticket+" members on 30/03/2022");
            System.out.println("Per ticket price is "+price+"\nTicket price is "+(no_of_ticket*price));
        }
    }

    public void advance_booking(){
        System.out.println("Your booking for VIP pass was successful");
    }

    public void cancel_booking(int id){

        if(id<=ticketId & Tickets[id-1]!=0){ 
            System.out.println("Cancellation for "+Tickets[id-1]+" members with ticket id "+id+" is successful");
            Tickets[id-1]=0;
        }else{
            System.out.println("Invalid Ticket ID");
        }

    }
    public void verify(){
        for(int i=0;i<20;i++){
            if(Tickets[i]!=0){
                System.out.println("Ticket ID : "+(i+1)+" for "+Tickets[i]+" members");
            }
        }
    }

    public void max_tickets(){
        Scanner sc=new Scanner(System.in); 
        System.out.println("Enter the max. no. of tickets that a person can buy : ");
        max_ticket=sc.nextInt();
        sc.close();
    }

    // STATIC CLASS AND METHODS
    // NESTED STATIC 

    static class VIP{
        
        public static void vip_pass(float price){
            System.out.println("The new VIP pass price is "+(price+30));
        }
        public static void vip_pass(float price,int members){
            System.out.println("The new VIP pass discount for "+members+" members is 5% and discount price will be "+(((price+30)*members*5/100)));
            
        }
    }

    public static void set_price(float price){
        
        System.out.println("The new ticket price is "+price);
       
        // VIP.vip_pass(price,10);
        // VIP.vip_pass(price);
    }

    public void payment(){}
}

///////////////////////// DONATION ////////////////////////

class Donation{
    int d_id;
    String d_name;
    int d_contact;
    String d_email;
    String d_address;
    String amount;
    Date date_of_record;
    float min_amt;

    public void get_details(){}
    public void most_donated(){}
    public void least_donated(){}
    public void freq_donators(){}
    public void donate(){}
    public void min_amount(float min_amt){
        this.min_amt=min_amt;
    }
}


///////////////////////         B A S I C   4       /////////////

// ANIMALS

class Zoo_animals{
    String rareAnimal;
    String rareBird;
    String rareAquatic;
    public void rare_animal(){
        System.out.println("The rare land animal is "+rareAnimal);
    }
    public void rare_aquatic(){
        System.out.println("The rare land animal is "+rareAnimal);
    }
    public void rare_bird(){
        System.out.println("The rare land animal is "+rareAnimal);
    }
}

class Animals extends Zoo_animals{

    int no_of_animals;
    int a_id;
    String animal_type;
    int DOB;
    int DOA;
    int cost;
    int maintenance; 
    int care_taker_id;
    int popular;

    public void get_details(){}
    public void most_expensive(){}
    public void least_expensive(){}
    public void top_popular(){}
    public void most_rare(){}
}

class Birds extends Zoo_animals{

    int no_of_birds;
    int a_id;
    String bird_type;
    int DOB;
    int DOA;
    int cost;
    int maintenance; 
    int care_taker_id;
    int popular;

    public void get_details(){}
    public void most_expensive(){}
    public void least_expensive(){}
    public void top_popular(){}
    public void most_rare(){}
}

class Aquatic extends Zoo_animals{
    int a_id;
    String aquatic_type;
    int DOB;
    int DOA;
    int cost;
    int maintenance; 
    int care_taker_id;
    int popular;

    public void get_details(){}
    public void most_expensive(){}
    public void least_expensive(){}
    public void top_popular(){}
    public void most_rare(){}
}
