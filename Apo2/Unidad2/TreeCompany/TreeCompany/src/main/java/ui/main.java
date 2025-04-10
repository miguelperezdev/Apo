package ui;
import model.Company;
import model.Employee;
import java.util.Scanner;

public class main {

    public static void main(String[] args){
        Scanner reader = new Scanner(System.in);
        Company icesi = new Company("Universidad Icesi");

        boolean flag = false;
        while(!flag){
            System.out.println("Arbol de empleados");
            System.out.println("1. Añadir un empleado ");
            System.out.println("2. Buscar un empleado por id");
            System.out.println("3. Buscar el id maximo");
            System.out.println("4. Buscar el id minimo");
            System.out.println("5. Eliminar un empleado por id");
            int opt = reader.nextInt();
            reader.nextLine();
            switch (opt){
                case 1:
                    System.out.println("\nIngrese el id");
                    String id = reader.nextLine();
                    System.out.println("Ingrese el nombre");
                    String name = reader.nextLine();
                    System.out.println("Ingrese la oficina");
                    int office = reader.nextInt();
                    icesi.add(id, name, office);
                    break;
                case 2:
                   /* System.out.println("Ingrese la indentidad de el empleado");
                    String ident = reader.nextLine();
                    icesi.search(ident);*/

                    System.out.println("Ingrese la identidad del empleado:");
                    String ident = reader.nextLine();

                    if (ident != null) {
                        System.out.println("Empleado encontrado:");
                        System.out.println("ID: " + icesi.search(ident).getId());
                        System.out.println("Nombre: " + icesi.search(ident).getName());
                        System.out.println("Oficina: " + icesi.search(ident).getOffice());
                    } else {System.out.println("Empleado no encontrado.");}
                    break;

                case 3 :
                    System.out.println(icesi.maximum());
                    break;

                case 4 :
                    System.out.println(icesi.minimum());
                    break;

                case 5 :
                    System.out.println("Ingrese la identidad del empleado que quiere eliminar:");
                    ident = reader.nextLine();
                    Employee eliminado = icesi.remove(ident);

                    if (eliminado != null) {
                        System.out.println("Empleado eliminado con éxito:");
                        System.out.println("ID: " + eliminado.getId());
                        System.out.println("Nombre: " + eliminado.getName());
                        System.out.println("Oficina: " + eliminado.getOffice());
                    } else {
                        System.out.println("No se encontró un empleado con esa identidad.");
                    }
                    break;

                default:
                    System.out.println("La opcion ingresada es incorrecta,intenta de nuevo :");
            }
        }
    }
}
