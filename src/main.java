import java.io.IOException;
import Committee.SupplyVaccines;
import people.Appointment;
import people.Program;


import java.util.Scanner;

public class main {
    public static void main(String[] args) throws IOException {
        boolean main_loop = true;
        boolean sub_loop = true;
        FileOperation f1 = new FileOperation();
        Scanner sc = new Scanner(System.in);
        while (main_loop) {
            System.out.println("---------------------\n" +
                    "Committee menu\n-----------------------\n" +
                    "(1)About people\n" +
                    "(2)Manage vaccine \n" +
                    "(3)Supply vaccine");
            int main_choice = Integer.parseInt(sc.nextLine());
            if (main_choice == 1) {
                while (sub_loop) {
                    System.out.println("---------------------\n" +
                            "Committee menu\n" +
                            "-----------------------\n" +
                            "(1)Add new person\n" +
                            "(2)Modify person\n" +
                            "(3)View all people\n" +
                            "(4)Search specific person \n" +
                            "(5)Exit");
                    int sub_choice = Integer.parseInt(sc.nextLine());
                    if (sub_choice == 1) {
                        System.out.println("Enter mail address");
                        String mail = sc.nextLine();
                        System.out.println("Enter password");
                        String ps = sc.nextLine();
                        System.out.println("Enter name");
                        String name = sc.nextLine();
                        Committee comObj = new Committee(mail, ps, name, "No");
                        f1.RegisterPerson(comObj);
                    }
                    if (sub_choice == 2) {
                        System.out.println("Enter mail address you want to modify");
                        String mail = sc.nextLine();
                        f1.ModifyPerson(mail);
                    }
                    if (sub_choice == 3) {
                        f1.ViewPerson();
                    }
                    if (sub_choice == 4) {
                        System.out.println("Enter mail address you want to search");
                        String mail = sc.nextLine();
                        f1.SearchPerson(mail);
                    }
                    if (sub_choice == 5) {
                        System.out.println("See you later");
                        sub_loop = false;
                    }
                }
                return;
            }
            if (main_choice == 2) {
                boolean subloop = true;
                while (subloop) {
                    System.out.println("---------------------\n" +
                            "Manage menu\n-----------------------\n" +
                            "(1)Add new schedule\n" +
                            "(2)Remove schedule\n" +
                            "(3)Modify schedule \n" +
                            "(4)View all people \n" +
                            "(5)Search specific person \n" +
                            "(6)Exit");
                    int sub_choice = Integer.parseInt(sc.nextLine());
                    if (sub_choice == 1) {
                        System.out.println("Which person do you want to add schedule?");
                        String mail = sc.nextLine();
                        f1.AddSchedule(mail);
                    }
                    if (sub_choice == 2) {
                        System.out.println("Which person do you want to remove schedule?");
                        String mail = sc.nextLine();
                        f1.RemoveSchedule(mail);
                    }
                    if (sub_choice == 3) {
                        System.out.println("Which person do you want to modify schedule?");
                        String mail = sc.nextLine();
                        f1.ModifySchedule(mail);
                    }
                    if (sub_choice == 4) {
                        f1.ViewSchedule();
                    }
                    if (sub_choice == 5) {
                        System.out.println("Which person do you want to search schedule?");
                        String mail = sc.nextLine();
                        f1.SearchSchedule(mail);
                    }
                    if (sub_choice == 6) {
                        subloop = false;
                    }
                }
            }
            if (main_choice == 3) {
                System.out.println("mainloop for 3");
                return;
            }
            main_loop = false;

            Scanner scan = new Scanner(System.in);
            System.out.println("please enter your Email");
            String EnteredEmail = scan.nextLine();
            System.out.println("" +
                    "\n1) Register to the vaccination programme" +
                    "\n2) Submit vaccination appointment" +
                    "\n3) View Vaccination status" +
                    "\n4) Exit");
            int choiceFunctionalities = scan.nextInt();
            if (choiceFunctionalities == 1) {
                Program program = new Program(EnteredEmail);
                boolean ProgramSection = true;
                while (ProgramSection) {
                    System.out.println("" +
                            "\n1) Resister" +
                            "\n2) Modify" +
                            "\n3) View" +
                            "\n4) Exit");
                    int choiceProgram = scan.nextInt();
                    if (choiceProgram == 1) program.Register();
                    if (choiceProgram == 2) program.Change();
                    if (choiceProgram == 3) program.View();
                    if (choiceProgram == 4) ProgramSection = false;
                }

                if (choiceFunctionalities == 3) {
                    SupplyVaccines supplyVaccines = new SupplyVaccines();
                    supplyVaccines.Add();
                }

            }
        }
    }
}