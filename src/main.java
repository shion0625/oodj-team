import java.io.IOException;
import java.util.Scanner;

public class main {
    public static void main(String[] args) throws IOException {
        int loop = 0;
        int loop2 = 0;
        FileOperation f1 = new FileOperation();
        Scanner sc = new Scanner(System.in);
        while(loop == 0) {
            System.out.println("---------------------\nCommittee menu\n-----------------------\n(1)About people\n(2)Manage vaccine \n(3)Supply vaccine");
            int choice1 = Integer.parseInt(sc.nextLine());
            if(choice1 == 1) {
                while(loop2 == 0) {
                    System.out.println("---------------------\nCommittee menu\n-----------------------\n(1)Add new person\n(2)Modify person\n(3)View all people\n(4)Search specific person \n(5)Exit");
                    int choice = Integer.parseInt(sc.nextLine());
                    if(choice == 1) {
                        System.out.println("Enter mail address");
                        String mail = sc.nextLine();
                        System.out.println("Enter password");
                        String ps = sc.nextLine();
                        System.out.println("Enter name");
                        String name = sc.nextLine();
                        Committee comObj = new Committee(mail, ps, name,"No");
                        f1.RegisterPerson(comObj);
                    }
                    if(choice == 2) {
                        System.out.println("Enter mail address you want to modify");
                        String mail = sc.nextLine();
                        f1.ModifyPerson(mail);
                    }
                    if(choice == 3) {
                        f1.ViewPerson();
                    }
                    if(choice==4){
                        System.out.println("Enter mail address you want to search");
                        String mail = sc.nextLine();
                        f1.SearchPerson(mail);
                    }
                    if(choice == 5) {
                        System.out.println("See you later");
                        loop = 1;
                    }
                }
            } else if (choice1 == 2) {
                System.out.println("---------------------\nManage menu\n-----------------------\n(1)Add new schedule\n(2)Remove schedule\n(3)Modify schedule \n(4)View all people \n(5)Search specific person \n(6)Exit");
                int choice = Integer.parseInt(sc.nextLine());
                if(choice == 1) {
                    System.out.println("Which person do you want to add schedule?");
                    String mail = sc.nextLine();
                    f1.AddSchedule(mail);
                }
                if(choice == 2) {
                    System.out.println("Which person do you want to remove schedule?");
                    String mail = sc.nextLine();
                    f1.RemoveSchedule(mail);
                }
                if(choice == 3) {
                    System.out.println("Which person do you want to modify schedule?");
                    String mail = sc.nextLine();
                    f1.ModifySchedule(mail);
                }
                if(choice == 4) {
                    f1.ViewSchedule();
                }
                if(choice == 5) {
                    System.out.println("Which person do you want to search schedule?");
                    String mail = sc.nextLine();
                    f1.SearchSchedule(mail);
                }
            }

        }


    }

}
