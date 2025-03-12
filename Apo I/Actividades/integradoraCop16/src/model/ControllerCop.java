package model;

public class ControllerCop {

    //Atributos
    private int contadorLugares;//contador de lugares
    private int contadorComunidades = 0;//contador de comunidades
    private int contadorRepresentante = 0;//contador de representantes

    //Relaciones con otras clases
    private Voluntario objVoluntario;
    private Ruta[] rutas;//arreglo de rutas
    private Caminata objCaminata;//objeto de caminata
    private LugarBiodiverso[] lugaresBiodiversos;//arreglo de lugares biodiversos
    private Comunidad[] comunidades;//arreglo de comunidades
    
    //Constantes
    public final static int MAXRUTAS = 3;
    public final static int MAXLUGARES = 100;
    public final static int MAXCOMUNIDADES = 30;
    public final static int MAXREPRESENTANTES = 30;

    //Metodos

    public ControllerCop() {
        rutas = new Ruta[MAXRUTAS];
        lugaresBiodiversos = new LugarBiodiverso[MAXLUGARES];
        comunidades = new Comunidad[MAXCOMUNIDADES];

        rutasPorDefecto();
        lugaresPorDefecto();
        comunidadesPorDefecto();
    }
    /**
     * @return Un mensaje que muestre el departamento con más lugares registrados.
     */
    public String mostrarDepartamentoMasLugares() {
        String mensaje = "";

        int[] totalLugaresDep = new int[4];
        totalLugaresDep[0] = contadorLugares(EnumDepartamento.CHOCO);
        totalLugaresDep[1] = contadorLugares(EnumDepartamento.VALLE);
        totalLugaresDep[2] = contadorLugares(EnumDepartamento.CAUCA);
        totalLugaresDep[3] = contadorLugares(EnumDepartamento.NARIÑO);

        EnumDepartamento[] departamentos = new EnumDepartamento[4];

        departamentos[0] = EnumDepartamento.CHOCO;
        departamentos[1] = EnumDepartamento.VALLE;
        departamentos[2] = EnumDepartamento.CAUCA;
        departamentos[3] = EnumDepartamento.NARIÑO;

        //Ordenar los departamentos
        for (int i = 0; i < totalLugaresDep.length - 1; i++) {
            for (int j = 0; j < totalLugaresDep.length - 1 - i; j++) {
                if (totalLugaresDep[j] < totalLugaresDep[j + 1]) {
                    int temporal = totalLugaresDep[j];
                    totalLugaresDep[j] = totalLugaresDep[j + 1];
                    totalLugaresDep[j + 1] = temporal;

                    EnumDepartamento temporalDept = departamentos[j];
                    departamentos[j] = departamentos[j + 1];
                    departamentos[j + 1] = temporalDept;
                }
            }
        }

        mensaje = "El departamento con más lugares registrados es: " + departamentos[0];
        return mensaje;
    }

    /**
     * @param enumDepartamento El departamento a consultar.
     * @return Cantidad de lugares registrados en el departamento.
     */
    public int contadorLugares(EnumDepartamento enumDepartamento){
        int contadorTemp = 0;
        for (int i = 0; i < contadorLugares; i++) {
            if (lugaresBiodiversos[i].getDepartamento() == enumDepartamento) {
                contadorTemp ++;
            }
        }
        return contadorTemp;
    }

    public void comunidadesPorDefecto(){
        comunidades[contadorComunidades] = new Comunidad("Comunidad Purace", 20, 2, 1, "Andres Felipe Solarte", "3147453455");
        
        comunidades[contadorComunidades] = new Comunidad("Comunidad Farallones", 30, 1, 3, "Mariana Rojas Rincon", "3122695029");

        comunidades[contadorComunidades] = new Comunidad("Comunidad Uramba Bahia Mejia", 40,3,4, "Enrique Muñoz Peña", "3142460451");
    }

    public void lugaresPorDefecto() {//lugares con valores predeterminados
        Comunidad comunidadPurace = comunidades[0];
        lugaresBiodiversos[0] = new LugarBiodiverso("Parque Nacional Natural Farallones de Cali", 1965,
                "C:/Users/Usuario/Documents/Farallones", 1968, 1, 1, 20000000, 3, comunidadPurace);

        Comunidad comunidadFarrallones = comunidades[1];
        lugaresBiodiversos[1] = new LugarBiodiverso("Parque nacional natural Purace", 919,
                "C:/Users/Usuario/Documents/Purace", 1968, 6, 15, 90000000, 1, comunidadFarrallones);

        Comunidad comunidadBahia = comunidades[2];
        lugaresBiodiversos[2] = new LugarBiodiverso("Parque Nacional Natural Uramba Bahía Málaga", 471,
                "C:/Users/Usuario/Documents/Malaga", 2010, 5, 1, 100000000, 1, comunidadBahia);

        contadorLugares = 3;
    }

    public void rutasPorDefecto() {//rutas con valores predeterminados
        rutas[0] = new Ruta("Farallones", "Calle 16 - Universidad del Valle", "6", "40", "4", "00");
        rutas[1] = new Ruta("Oriente", "Bulevar del Rio", "7", "00", "1", "00");
        rutas[2] = new Ruta("Ladera", "Bulevar del Rio", "7", "00", "3", "00");
    }

    /**
     * @return Un mensaje con las rutas disponibles.
     */
    public String mostrarRuta() {
        String mensaje = "Selecciona una ruta: ";
        for (int i = 0; i < MAXRUTAS; i++) {
            mensaje += "\n" + (i + 1) + "." + rutas[i].getNombreRuta();
        }
        return mensaje;
    }

    /**
     * @param opcion La opción de la ruta escogida por el usuario.
     * @return boolean = true si la opción es válida, boolean = false no es una opcion válida.
     */
    public boolean rutaEscogida(int opcion) {
        boolean valorFinal;

        switch(opcion){
            case 1:
            valorFinal = true;
            break;

            case 2: 
            valorFinal = true;
            break;

            case 3:
            valorFinal = true;
            break;

            default: 
            valorFinal = false;
            break;
        }
        return valorFinal;
    }

    
    /**
     * @param nombre Nombre del voluntario.
     * @param id Identificación del voluntario.
     * @return Un mensaje de bienvenida al voluntario registrado.
     */
    public String registrarVoluntario(String nombre, String id) {
        objVoluntario = new Voluntario(nombre, id);
        return objVoluntario.toString();
    }

      /**
     * @param opcion Opción seleccionada de la ruta.
     * @return Mensaje con la información de la ruta.
     */
    public String mostrarInformacionRuta(int opcion) {
        String mensaje;
        mensaje = rutas[opcion - 1].toString();
        return mensaje;
    }

    /**
     * @param cantidadParticipantes Cantidad de participantes en la caminata.
     * @param cantidadGuias Cantidad de guías en la caminata.
     * @param temperatura Temperatura ambiente.
     * @param humedadRelativa Humedad relativa.
     * @return Un mensaje con la información de la caminata registrada.
     */
    public String registrarCaminata(int cantidadParticipantes, int cantidadGuias, double temperatura, double humedadRelativa) {
        objCaminata = new Caminata(cantidadParticipantes, cantidadGuias, temperatura, humedadRelativa);
        return "\n" + objCaminata.toString() + objCaminata.toStringBus();
    }
    
    /**
     * @param nombreLugar Nombre del lugar biodiverso.
     * @param areaLugar Area del lugar biodiverso (km2).
     * @param imagenLugar Ruta de la imagen del lugar.
     * @param aperturaAño Año de apertura del lugar.
     * @param aperturaMes Mes de apertura del lugar.
     * @param aperturaDia Día de apertura del lugar.
     * @param recursosEconomicos Recursos económicos necesarios para mantener el lugar.
     * @param departamento Número del departamento en el que se encuentra el lugar.
     * @return el "0" indica que el lugar fue registrado con éxito, el "1" indica que no se ha podido registrar el lugar.
     */
    public int registrarLugarBiodiverso(String nombreLugar, double areaLugar, String imagenLugar, int aperturaAño,int aperturaMes, int aperturaDia, double recursosEconomicos, int departamento, int numComunidad) {
        if (contadorLugares < MAXLUGARES) {
            Comunidad escogerComunidad = comunidades[numComunidad-1];
            lugaresBiodiversos[contadorLugares] = new LugarBiodiverso(nombreLugar, areaLugar, imagenLugar, aperturaAño, aperturaMes, aperturaDia, recursosEconomicos, departamento, escogerComunidad);
            contadorLugares++;
            return 0;
        } else {
            return 1;
        }
    }

    /**
    * @return Un mensaje que muestre los lugares disponibles.
    */
    public String mostrarLugares(){
        String mensaje = "Selecciona un lugar: ";
        for (int i = 0; i < contadorLugares; i++) {
            mensaje += "\n" + (i + 1) + "." + lugaresBiodiversos[i].getNombreLugar();
        }
        return mensaje;
    }

    /**
    * @return mensaje con la lista de comunidades registradas en el sistema o un mensaje representado que no hay comunidades registradas.
    */
    public String mostrarComunidades(){
        String mensaje = "";
        if(contadorComunidades == 0){
            mensaje = "No existen comunidades registradas en el sistema. Por favor registra alguna desde el menu.";
        }else{
            mensaje += "Ingresa el numero de la comunidad que pertenece al lugar.";
            for(int i = 0; i < comunidades.length; i++){
                if(comunidades[i] != null){
                    mensaje += "\n" + (i+1) + ". " + comunidades[i].getNombreComunidad() + ".";
                }
            }
        }
        return mensaje;
    }

    /**
    * @param opcion  El número del lugar (índice en el arreglo `lugaresBiodiversos`) donde se desea añadir la especie.
    * @param nombreEspecie El nombre de la especie que se quiere agregar.
    * @param imagenEspecie La ruta de la imagen de la especie.
    * @param cantidadEjemplares La cantidad de ejemplares de la especie que se desean agregar.
    * @param numEspecie El número que representa el tipo de especie (1 para Fauna, 2 para Flora).
    * @return Un mensaje indicando el resultado de la operación, ya sea confirmando que la especie fue añadida correctamente o indicando que no se pueden añadir más especies.
    */
    public String agregarEspecieEnLugar(int opcion, String nombreEspecie, String imagenEspecie, int cantidadEjemplares, int numEspecie){
        
        String mensaje = "";

        boolean verificarAgregarEspecie = lugaresBiodiversos[opcion-1].anadirEspecie(nombreEspecie, imagenEspecie, cantidadEjemplares, numEspecie);

        if(verificarAgregarEspecie == true){
            mensaje = "La especie " + nombreEspecie + " fue relacionada correctamente al lugar " + lugaresBiodiversos[opcion-1].getNombreLugar() + "."; 
        }else{
            mensaje = "No se pueden añadir mas especies";
        }
        return mensaje;
    }

    /**
    * @return Un mensaje con la lista de lugares ordenados de menor a mayor área.
    */
    public String ordenarLugarPorArea() {
        String mensaje = "";
        LugarBiodiverso[] ordenarLugares = new LugarBiodiverso[contadorLugares];

        for (int i = 0; i < contadorLugares; i++) {
            ordenarLugares[i] = lugaresBiodiversos[i];
        }

        for (int i = 0; i < ordenarLugares.length - 1; i++) {
            for (int j = 0; j < ordenarLugares.length - 1 - i; j++) {
                if (ordenarLugares[j].getAreaLugar() > ordenarLugares[j + 1].getAreaLugar()) {
                    LugarBiodiverso temporal = ordenarLugares[j];
                    ordenarLugares[j] = ordenarLugares[j + 1];
                    ordenarLugares[j + 1] = temporal;
                }
            }
        }
        for(int i=0; i<ordenarLugares.length; i++){
            mensaje += (i+1) + ". " + ordenarLugares[i].getNombreLugar() + " - " + ordenarLugares[i].getAreaLugar() + " km2.\n";
        }
        return mensaje;
    }

    /**
    * @param nombreComunidad Nombre de la comunidad a registrar.
    * @param cantidadHabitantes Cantidad de habitantes en la comunidad.
    * @param numRaza Número que representa el tipo de raza de la comunidad (1. Afrocolombiano, 2. Indígena, 3. Raizal).
    * @param numProblemas Número que representa el problema principal de la comunidad (1. Falta de hospital, 2 Falta de escuela, 3. Falta de agua potable, 4. Falta de acceso a alimentos básicos).
    * @param nombreRepresentante Nombre del representante de la comunidad.
    * @param celularRepresentante Número de celular del representante de la comunidad.
    * @return Un mensaje que muestre si fue registrado exitosamente o no pudo ser registrado.
    */
    public String registrarComunidad(String nombreComunidad, int cantidadHabitantes, int numRaza, int numProblemas, String nombreRepresentante, String celularRepresentante){
        String mensaje = "";

        if((contadorComunidades < MAXCOMUNIDADES)&(contadorRepresentante < MAXREPRESENTANTES)){
            comunidades[contadorComunidades] = new Comunidad(nombreComunidad, cantidadHabitantes, numRaza, numProblemas, nombreRepresentante, celularRepresentante);
            mensaje = "Comunidad registrada correctamente";
            contadorComunidades ++;
            contadorRepresentante ++;
        } else {
            mensaje = "No se pueden registrar más comunidades.";
        }
        return mensaje;
    }

    /**
    * @param opcion             El número del lugar en el cual se encuentra la especie a modificar (índice en el arreglo `lugaresBiodiversos`).
    * @param seleccionEspecie   El número que representa la especie a modificar dentro del lugar.
    * @param numEspecie         El número que representa el tipo de especie (1 para Fauna, 2 para Flora).
    * @param imagenEspecie      La URL o nombre del archivo de imagen que representa a la especie.
    * @param cantidadEjemplares La nueva cantidad de ejemplares de la especie.
    * @param atributoEspecie    El atributo que se desea modificar (1. Tipo de especie, 2. Imagen de la especie, 3. Cantidad de ejemplares).
    * @return mensaje Un mensaje indicando si la modificación fue exitosa o no.
    */
    public String modificarEspecie(int opcion, int seleccionEspecie, int numEspecie, String imagenEspecie, int cantidadEjemplares, int atributoEspecie){
        String mensaje = "";

        switch (atributoEspecie) {
            case 1:
                mensaje = lugaresBiodiversos[opcion-1].modificarEspecies(opcion, numEspecie, imagenEspecie, cantidadEjemplares, atributoEspecie);
                break;

            case 2:
                mensaje = lugaresBiodiversos[opcion-1].modificarEspecies(opcion, numEspecie, imagenEspecie, cantidadEjemplares, atributoEspecie);
                break;

            case 3:
                mensaje = lugaresBiodiversos[opcion-1].modificarEspecies(opcion, numEspecie, imagenEspecie, cantidadEjemplares, atributoEspecie);
                break;
        }
        return mensaje;
    }

    /**
    * @param departamento El número del departamento donde se desea buscar el lugar (índice en el arreglo `lugaresBiodiversos`).
    * @return dept El nombre del lugar correspondiente al índice del departamento.
    */
    public String buscarLugar(int departamento){
        String dept = "";

        dept = lugaresBiodiversos[departamento-1].getNombreLugar();

        return dept;
    }

    /**
     * @param opcion El número del lugar (índice en el arreglo `lugaresBiodiversos`) para el cual se desean ver las especies.
     * @return mensaje Un mensaje que contiene la lista de especies registradas en el lugar o un mensaje indicando que no hay especies.
     */
    public String mostrarEspecies(int opcion){
        String mensaje;

        mensaje = lugaresBiodiversos[opcion-1].mostrarEspecies();

        
        return mensaje;
    }

    /**
     * @param opcionProblema El número que representa el tipo de problema a buscar (1. Falta de hospital, 2. Falta de escuela, etc.).
     * @return mensaje Un mensaje con la lista de comunidades que tienen el problema especificado o un mensaje indicando que no se encontraron comunidades con dicho problema.
     */
    public String buscarComunidadConProblema(int opcionProblema){

        String mensaje = "";
        int contador = 0;
    
        for (int i = 0; i < comunidades.length; i++) {
            if (comunidades[i] != null) {  
                EnumProblemas problema = comunidades[i].getEnumProblemas();
    
                if ((opcionProblema == 1 && problema == EnumProblemas.FALTADEHOSPITAL) || 
                    (opcionProblema == 2 && problema == EnumProblemas.FALTADEESCUELA)) {
    
                    mensaje += "(Lugar " + (contador + 1) + ")\n";
                    mensaje += "Nombre de la comunidad: " + comunidades[i].getNombreComunidad() + "\n";
                    mensaje += "Cantidad de habitantes: " + comunidades[i].getCantidadHabitantes() + "\n";
                    mensaje += "Tipo de raza: " + comunidades[i].getEnumRaza() + "\n\n";
                    contador++;
                }
            }
        }
    
        if (contador == 0) {
            mensaje = "No se encontraron comunidades con el tipo de problema seleccionado.";
        }
    
        return mensaje;
    }

    /**
     * @return mensaje Un mensaje con el nombre del lugar que tiene la mayor cantidad de especies o un mensaje indicando que no se encontraron lugares con especies.
     */
    public String mostrarLugarConMasEspecies() {
        String mensaje = "";
        int maximoEspeciesContador = -1;
        LugarBiodiverso lugarConMasEspecies = null; 
    
        for (int i = 0; i < contadorLugares; i++) {
            if (lugaresBiodiversos[i] != null) {
                int especiesContador = lugaresBiodiversos[i].getContadorEspecies(); 

                if (especiesContador > maximoEspeciesContador) {
                    maximoEspeciesContador = especiesContador;
                    lugarConMasEspecies = lugaresBiodiversos[i]; 
                }
            }
        }

        if(maximoEspeciesContador == 0){
            mensaje = "No hay un lugar que tenga mayor especies.";
        }else{
            if (lugarConMasEspecies != null) {
                mensaje = "El lugar con mayor cantidad de especies es: \n" + lugarConMasEspecies.getNombreLugar() + " con " + maximoEspeciesContador + " especies.";
            } else {
                mensaje = "No hay lugares registrados con especies.";
            }
    
        }
    
        return mensaje;
    }

}

