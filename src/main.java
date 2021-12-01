import people.Appointment;
import people.Program;

import java.util.Scanner;


public class main {
    public static void main(String[]args){
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
                int choiceProgram = scan.nextInt();
                if(choiceProgram == 1) appointment.Register();
                if(choiceProgram == 2) appointment.Cancel();
                if(choiceProgram == 3) appointment.View();
                if(choiceProgram == 4) AppointmentSection = false;
            }
        }
    }
}
