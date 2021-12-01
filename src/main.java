import Committee.SupplyVaccines;
import people.Appointment;
import people.Program;


import java.util.Scanner;
public class main {
    public static void main(String[]args) {
//        int loop = 0;
//        int loop2 = 0;
//        FileOperation f1 = new FileOperation();
//        Scanner sc = new Scanner(System.in);
//        while(loop == 0) {
//            System.out.println("" +
//                    "---------------------\nCommittee menu\n-----------------------\n" +
//                    "(1)About people\n" +
//                    "(2)Manage vaccine\n" +
//                    "(3)Supply vaccine");
//            int choice1 = Integer.parseInt(sc.nextLine());
//            if(choice1 == 1) {
//                while(loop2 == 0) {
//                    System.out.println("" +
//                            "---------------------\nCommittee menu\n-----------------------\n" +
//                            "(1)Add new person\n" +
//                            "(2)Modify person\n" +
//                            "(3)View all people\n" +
//                            "(4)Search specific person\n" +
//                            "(5)Exit");
//                    int choice = Integer.parseInt(sc.nextLine());
//                    if(choice == 1) {
//                        System.out.println("Enter mail address");
//                        String mail = sc.nextLine();
//                        System.out.println("Enter password");
//                        String ps = sc.nextLine();
//                        System.out.println("Enter name");
//                        String name = sc.nextLine();
//                        Committee comObj = new Committee(mail, ps, name,"No");
//                        f1.RegisterPerson(comObj);
//                    }
//                    if(choice == 2) {
//                        System.out.println("Enter mail address you want to modify");
//                        String mail = sc.nextLine();
//                        f1.ModifyPerson(mail);
//                    }
//                    if(choice == 3) {
//                        f1.ViewPerson();
//                    }
//                    if(choice==4){
//                        System.out.println("Enter mail address you want to search");
//                        String mail = sc.nextLine();
//                        f1.SearchPerson(mail);
//                    }
//                    if(choice == 5) {
//                        System.out.println("See you later");
//                        loop = 1;
//                    }
//                }
//            } else if (choice1 == 2) {
//                System.out.println("" +
//                        "---------------------\nManage menu\n-----------------------\n" +
//                        "(1)Add new schedule\n" +
//                        "(2)Remove schedule\n" +
//                        "(3)Modify schedule \n" +
//                        "(4)View all people \n" +
//                        "(5)Search specific person\n" +
//                        "(6)Exit");
//                int choice = Integer.parseInt(sc.nextLine());
//                if(choice == 1) {
//                    System.out.println("Which person do you want to add schedule?");
//                    String mail = sc.nextLine();
//                    f1.AddSchedule(mail);
//                }
//                if(choice == 2) {
//                    System.out.println("Which person do you want to remove schedule?");
//                    String mail = sc.nextLine();
//                    f1.RemoveSchedule(mail);
//                }
//                if(choice == 3) {
//                    System.out.println("Which person do you want to modify schedule?");
//                    String mail = sc.nextLine();
//                    f1.ModifySchedule(mail);
//                }
//                if(choice == 4) {
//                    f1.ViewSchedule();
//                }
//                if(choice == 5) {
//                    System.out.println("Which person do you want to search schedule?");
//                    String mail = sc.nextLine();
//                    f1.SearchSchedule(mail);
//                }
//            }
//
//        }

        Scanner scan = new Scanner(System.in);
        System.out.println("please enter your Email");
        String EnteredEmail = scan.nextLine();
        System.out.println("" +
                "\n1) Register to the vaccination programme" +
                "\n2) Submit vaccination appointment" +
                "\n3) View Vaccination status" +
                "\n4) Exit");
        int choiceFunctionalities = scan.nextInt();
        if(choiceFunctionalities == 1){
            Program program = new Program(EnteredEmail);
            boolean ProgramSection = true;
            while(ProgramSection) {
                System.out.println("" +
                        "\n1) Resister" +
                        "\n2) Modify" +
                        "\n3) View" +
                        "\n4) Exit");
                int choiceProgram = scan.nextInt();
                if(choiceProgram == 1) program.Register();
                if(choiceProgram == 2) program.Change();
                if(choiceProgram == 3) program.View();
                if(choiceProgram == 4) ProgramSection = false;
            }
        }
        if(choiceFunctionalities == 2){
            Appointment appointment = new Appointment(EnteredEmail);
            boolean AppointmentSection = true;
            while(AppointmentSection) {
                System.out.println("" +
                        "\n1) Resister" +
                        "\n2) Modify" +
                        "\n3) View" +
                        "\n4) Exit");
                int choiceAppointment = scan.nextInt();
                if(choiceAppointment == 1) appointment.Register();
                if(choiceAppointment == 2) appointment.Cancel();
                if(choiceAppointment == 3) appointment.View();
                if(choiceAppointment == 4) AppointmentSection = false;
            }
        }
        if(choiceFunctionalities == 3) {
            SupplyVaccines supplyVaccines = new SupplyVaccines();
            supplyVaccines.Add();
        }

    }
}


