import java.util.ArrayList;
/**
 * Write a description of class Usuario here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Usuario
{
    // Atributo para el nombre del usuario
    private String nombre;
    // Atributo que almacena gramos totales de proteinas ingeridos
    private float proteinasT;
    // Atributo que almacena gramos totales de carbohidratos ingeridos
    private float carbohidratosT;
    // Atributo que almacena gramos totales de grasas ingeridos
    private float grasasT;
    // Atributo que almacena las calorias totales ingeridas
    private float caloriasT;
    // Atributo que guarda el alimento que más calorías tiene
    private Alimento alimentoMasCalorias;
    // Atributo para almacenar los alimentos ingeridos
    private ArrayList<Alimento> alimentosComidos;
    /**
     * Constructor for objects of class Usuario
     */
    public Usuario(String nombre)
    {
        this.nombre = nombre;
        proteinasT = 0;
        grasasT = 0;
        carbohidratosT = 0;
        caloriasT = 0;
        alimentoMasCalorias = null;
        alimentosComidos = new ArrayList<>();
    }

    /**
     * Este método nos devuelve el nombre del ususario.
     */
    public String getNombre()
    {
        return nombre;
    }

    /**
     * Este método nos devuelve las calorias totales que ha ingerido el usuario.
     */
    public float getCalorias()
    {
        return caloriasT;
    }

    /**
     * El método comer recibe dos parámetros: 
     * el alimento a comer y la cantidad en gramos del mismo que se va a comer el usuario (en ese orden).
     */
    public void comer(Alimento comida, float cantidad)
    {
        alimentosComidos.add(comida);
        proteinasT += (cantidad * comida.getProteinas() / 100);
        grasasT += (cantidad * comida.getGrasas() / 100);
        carbohidratosT += (cantidad * comida.getCarbohidratos() / 100);
        caloriasT += (cantidad * comida.getCalorias() / 100);
        if (alimentoMasCalorias == null) {
            alimentoMasCalorias = comida;
        }
        else if (comida.getCalorias() >= alimentoMasCalorias.getCalorias()) {
            alimentoMasCalorias = comida;
        }
    }

    /**
     * Este método nos muestra el estado actual de un usuario por pantalla.
     * Si el valor del macronutriente no es 0, además nos muestra el porcentaje
     * sobre el total de los macronutrientes ingeridos.
     */
    public void mostrarDatos() 
    {
        float totalNutrientes = (proteinasT + grasasT + carbohidratosT) / 100;
        String datosProteinas = "Gramos totales de proteinas ingeridos:     " + proteinasT;
        String datosCarbohidratos = "Gramos totales de carbohidratos ingeridos: " + carbohidratosT;
        String datosGrasas = "Gramos totales de grasas ingeridos:        " + grasasT;
        if (proteinasT > 0) {
            datosProteinas = datosProteinas + " (" + proteinasT / totalNutrientes + "%)";
        }
        if (carbohidratosT > 0) {
            datosCarbohidratos = datosCarbohidratos + " (" + carbohidratosT / totalNutrientes + "%)";
        }
        if (grasasT > 0) {
            datosGrasas = datosGrasas + " (" + grasasT / totalNutrientes + "%)";
        }
        System.out.println("Nombre:                                    " + nombre);
        System.out.println(datosProteinas);    
        System.out.println(datosCarbohidratos);
        System.out.println(datosGrasas);
        System.out.println("Calorias totales ingeridas:                " + caloriasT);
    }

    /**
     * Este método compara la ingesta de calorías entre dos usuarios y nos muestra la información por pantalla.
     */
    public void comparaComilones(Usuario usuarioComparado) 
    {
        String usuarioMasCalorias = nombre;
        String usuarioMenosCalorias = usuarioComparado.getNombre();
        float maximasCalorias = caloriasT;
        float minimasCalorias = usuarioComparado.getCalorias();
        String mensaje = " ha consumido más calorías que ";
        if (usuarioComparado.getCalorias() == caloriasT) {
            mensaje = " ha consumido las mismas calorías que ";
        }
        else if (usuarioComparado.getCalorias() > caloriasT) {
            maximasCalorias = usuarioComparado.getCalorias();
            minimasCalorias = caloriasT;
            usuarioMasCalorias = usuarioComparado.getNombre();
            usuarioMenosCalorias = nombre;
        } 
        System.out.println(usuarioMasCalorias + mensaje + usuarioMenosCalorias + " (" + maximasCalorias + " frente a " + minimasCalorias + ")");
    }

    /**
     * Este método muestra por pantalla el alimento que contiene más calorias de los cosumidos
     */
    public void alimentoMasCalorias() 
    {
        if (alimentoMasCalorias != null) {
            if (alimentoMasCalorias.getCalorias() > 0) {
                System.out.println("Alimento más calórico ingerido por este usuario hasta el momento: " + alimentoMasCalorias.getNombre() + "(" + 
                alimentoMasCalorias.getCalorias() + " calorías por cada 100 gramos)" );
            }
            else {
                System.out.println("El último alimento ingerido es " + alimentoMasCalorias.getNombre() + ", pero no se han ingerido calorías" );
            }
        }
        else {
            System.out.println("No se ha ingerido ningún alimento aún");
        }
    }

    /**
     * Este método admite un parámetro entero, y nos muestra la posición en la que hemos ingerido un alimento
     * según el parámetro pasado.
     */
    public void mostrarDatosAlimento(int indice) 
    {
        if (indice>= 0 && indice < alimentosComidos.size()) {
            alimentosComidos.get(indice - 1).muestraDatos();
        }
        else {
            System.out.println("El valor introducido para la consulta no es un índice válido o no ha ingerido aún ningún alimento");
        }
    }
    
    /**
     * Este método permite pasar como parámetro el nombre de un alimento e indica si el usuario ha comido ese alimento más de una vez o no y,
     * en caso afirmativo, cuántas veces lo ha hecho
     */
    public void comidosMasDeUnaVez(String nombreAlimento) 
    {
        int contadorAlimentos = 0;
        for (Alimento alimentos : alimentosComidos) {
            if (alimentos.getNombre().contains(nombreAlimento)) {
                contadorAlimentos++;
            }
        }
        if (contadorAlimentos > 1) {
            System.out.println(nombre + " ha comido " + nombreAlimento + " más de una vez, en concreto " + contadorAlimentos + " veces.");
        }
        else {
            System.out.println(nombre + " no ha comido " + nombreAlimento + " más de una vez.");
        }
        
    }
}
