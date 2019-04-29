/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package costomatricula;
import java.util.Scanner;
import porcentajes.*;
/**
 *
 * @author BrandonVS
 */
public class CostoMatricula {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // Se crea el scanner para poder ingresar variables
        Scanner scan = new Scanner(System.in);
        // Se declaran e inicializan los datos
        double cmatricula = 1330.00;
        double matricula;
        double matriculaf;
        double descuentoCiu;
        double descuentoEd;
        double descuentoEcivil;
        double descuentoCarga;
        // Se piden he ingresan los datos
        System.out.println("Ingrese la ciudad de la que viene el estudiante ");
        String ciudad = scan.nextLine();
        System.out.println("Ingrese la edad del estudiante ");
        int edad = scan.nextInt();
        scan.nextLine();
        
        System.out.println("Ingrese el estado civil del estudiante (Casado o "
                + "Soltero) ");
        String ecivil = scan.nextLine();
        System.out.println("¿El estudiante tiene cargas familiares? (Responder"
                + " con Si o No)");
        String cfami = scan.nextLine();
        // Se comparan los datos con los condicinales if
        if ("Loja".equals(ciudad)|| "Zamora".equals(ciudad)){
            descuentoCiu = Porcentajes.descuentoC;
        } else {
            descuentoCiu = 0;
        }
        if (edad >=17 && edad < 20){
            descuentoEd = Porcentajes.descuentoE;
        } else {
            descuentoEd = 0;
        }
        if ("Casado".equals(ecivil)){
            descuentoEcivil = Porcentajes.descuentoEC;
        } else {
            descuentoEcivil = 0;
        }
        if ("Si".equals(cfami)){
            descuentoCarga = Porcentajes.cargaF;
        } else {
            descuentoCarga = 0;
        }
        // Se calucla la matricula sin el tramite administrativo
        matricula = cmatricula - descuentoCiu - descuentoEd - descuentoEcivil
                - descuentoCarga;
        // Se calcula el costo final de la matricula
        matriculaf = matricula;
        matricula = matricula * Porcentajes.tramiteA;
        matriculaf = matricula + matriculaf;
        // Se imprime el resultado
        System.out.printf("El costo final de la matricula sera: %.2f", 
                matriculaf);
    }
}
