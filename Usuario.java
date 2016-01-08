
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
    // Atributo que almacena las calorias totales ingeridas:
    private float caloriasT;

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
    }

    /**
     * El método comer recibe dos parámetros: 
     * el alimento a comer y la cantidad en gramos del mismo que se va a comer el usuario (en ese orden).
     */
    public void comer(Alimento comida, float cantidad)
    {
        proteinasT += (cantidad * comida.getProteinas() / 100);
        grasasT += (cantidad * comida.getGrasas() / 100);
        carbohidratosT += (cantidad * comida.getCarbohidratos() / 100);
        caloriasT += (cantidad * comida.getCalorias() / 100);
    }

    /**
     * Este método nos muestra el estado actual de un usuario por pantalla.
     */
    public void mostrarDatos() 
    {

        System.out.println("Nombre: " + nombre);
        System.out.println("Gramos totales de proteinas ingeridos: " + proteinasT);
        System.out.println("Gramos totales de carbohidratos ingeridos: " + carbohidratosT);
        System.out.println("Gramos totales de grasas ingeridos: " + grasasT);
        System.out.println("Calorias totales ingeridas: " + caloriasT);
    }
}
