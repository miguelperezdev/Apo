package model;

public class Comunidad {

    //Atributos
    private String nombreComunidad;
    private int cantidadHabitantes;
    private int numRaza;
    private int numProblemas;

    //Relaciones con otras clases
    private Representante representante;
    private EnumRaza enumRaza;
    private EnumProblemas enumProblemas;

    //Metodos
    /**
     * @param nombreComunidad Nombre de la comunidad.
     * @param cantidadHabitantes Cantidad de habitantes de la comunidad.
     * @param numRaza Número que representa el tipo de raza de la comunidad (1. Afrocolombiano, 2. Indígena, 3. Raizal).
     * @param numProblemas Número que representa el problema principal de la comunidad (1. Falta de hospital, 2. Falta de escuela, 3. Falta de agua potable, 4. Falta de acceso a alimentos básicos).
     * @param nombreRepresentante Nombre del representante de la comunidad.
     * @param celularRepresentante Número de contacto del representante de la comunidad.
     */
    public Comunidad(String nombreComunidad, int cantidadHabitantes, int numRaza, int numProblemas, String nombreRepresentante, String celularRepresentante){
        this.nombreComunidad = nombreComunidad;
        this.cantidadHabitantes = cantidadHabitantes;
        
        switch(numRaza){//asignar el tipo de raza

            case 1:
            enumRaza = EnumRaza.AFROCOLOMBIANO;
            break;

            case 2:
            enumRaza = EnumRaza.INDIGENA;
            break;

            case 3: 
            enumRaza = EnumRaza.RAIZAL;
            break;
        }

        switch(numProblemas){//asignar el problema de la comunidad
            
            case 1:
            enumProblemas = EnumProblemas.FALTADEHOSPITAL;
            break;

            case 2:
            enumProblemas = EnumProblemas.FALTADEESCUELA;
            break;

            case 3:
            enumProblemas = EnumProblemas.FALTADEAGUAPOTABLE;
            break;

            case 4:
            enumProblemas = EnumProblemas.FALTADEACCESOALIMENTOSBASICOS;
            break;
         
        }
    }
    
       /**
        * @return Nombre de la comunidad.
        */
        public String getNombreComunidad(){
            return nombreComunidad;
        }     

        /**
         * @return Cantidad de habitantes.
         */
        public int getCantidadHabitantes() {
            return cantidadHabitantes;
        }

        /**
         * @return Tipo de raza.
         */
        public EnumRaza getEnumRaza() {
            return enumRaza;
        }

        /**
         * @return Problema principal de la comunidad.
         */
        public EnumProblemas getEnumProblemas() {
            return enumProblemas;
        }
}
