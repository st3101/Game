
public class Inicio 
{
    public static final int altoVentana = 800;
    public static final int anchoVentana = 600;
    public static final int fps = 60;
    public static void main(String[] args) 
    {
        new Ventana(altoVentana,anchoVentana,fps).start();	
    }
}