package ui;

import model.Controller;

import java.util.Scanner;

public class Main {

    private Scanner sc;
    private Controller controller;


    public Main(){
        sc = new Scanner(System.in);
        controller = new Controller();
    }

    public static void main(String[] args) {

        Main app = new Main();
        int option = 0;

        while (option != 4){

            app.printMenu();
            option = app.getOption();
            app.executeOption(option);

        }

    }

    public void printMenu(){

        System.out.println("1. inscribir ciudadano\n"+
                            "2. consultar cedula \n"+
                            "3. Eliminar ciudadano \n" +
                            "4. salir \n");

    }

    public int getOption(){
        int option = sc.nextInt();
        sc.nextLine();

        return  option;
    }

    public void executeOption(int option){

        switch (option){

            case 1:
                inscribirCiudadano();
                break;

            case 2:
                consultarPorcedula();
                break;

            case 3:
                eliminarCiudadano();
                break;

            case 4:
                System.out.println("bye");
                break;

        }

    }

    public void inscribirCiudadano(){
        String cedula,
        nombre,
        fechaNacimiento,
        ciudadNacimiento;

        System.out.println("digite cedula");
        cedula = sc.nextLine();

        System.out.println("digite el nombre");
        nombre = sc.nextLine();

        System.out.println("digite la fecha de nacimiento");
        fechaNacimiento = sc.nextLine();

        System.out.println("digite ciudad de nacimiento");
        ciudadNacimiento = sc.nextLine();

        controller.inscribirCiudadano(cedula, nombre, fechaNacimiento, ciudadNacimiento);
    }

    public void consultarPorcedula(){

        System.out.println("digite la cedula");
        String cedula = sc.nextLine();

        String response = controller.consultarPorCedula(cedula);

        System.out.println(response);
    }

    public void eliminarCiudadano(){

        System.out.println("digite la cedula");
        String cedula = sc.nextLine();

        controller.eliminarCiudadano(cedula);

    }

}
