package model;

public class Controller {

    private BST bst;

    public Controller(){
        bst = new BST();
    }

    public void inscribirCiudadano(String cedula,
                                   String nombre,
                                   String fechaNacimiento,
                                   String ciudadNacimiento){

        Citizen citizen = new Citizen(cedula, nombre, fechaNacimiento, ciudadNacimiento);
        bst.agregar(citizen);
    }

    public String consultarPorCedula(String cedula){

        String response = "";

        Citizen citizen = bst.buscar(cedula);

        if(citizen != null){
            response+= citizen.getNombre() + "\n";
            response+= citizen.getFechaNacimiento() + "\n";
            response+= citizen.getCedula() + "\n";
            response+= citizen.getCiudadNacimiento() + "\n";
            response+= "numero iteraciones: " + bst.nivelesBusqueda(cedula);

        }else{
            response+= "El ciudano no se encuentra registrado.";
        }

        return response;

    }

    public void eliminarCiudadano(String cedula){
        bst.borrar(cedula);
    }


}
