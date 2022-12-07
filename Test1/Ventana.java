import javax.swing.JFrame;
import java.awt.Canvas;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;

public class Ventana extends JFrame implements Runnable 
{
    private int altoPantalla;
    private int largoPantalla;
    private int fps;
    //private double objetivo = 1000000000/fps;
    //private double tiempo = 0; 
    //private int promedioFps = fps;

    public Canvas canvas;
    private Thread thread;
    private boolean ejecucando = false;
    
    private BufferStrategy buffer;
    private Graphics graficos;

    private int ejeX  = 0;




    public Ventana(int altoPantalla, int largoPantalla,int fps)
    {
        this.fps = fps;
        this.altoPantalla = altoPantalla;
        this.largoPantalla = largoPantalla;


        setTitle("My Invidader");
		setSize(altoPantalla, largoPantalla);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		setLocationRelativeTo(null);
        setFocusable(true);
		setVisible(true);

        canvas = new Canvas();
        canvas.setPreferredSize(new Dimension(altoPantalla,largoPantalla));
        canvas.setMaximumSize(new Dimension(altoPantalla,largoPantalla));
        canvas.setMinimumSize(new Dimension(altoPantalla,largoPantalla));
        canvas.setFocusable(true);

        add(canvas);        
    }   



    private void actualizar()
    {
        ejeX++;
    }

    private void dibujar()
    {
        buffer = canvas.getBufferStrategy();
        
        if(buffer == null)
        {
            canvas.createBufferStrategy(3);
            return;
        }

        graficos = buffer.getDrawGraphics();

        //Limpia la pantalla 
        graficos.clearRect(0, 0, altoPantalla, largoPantalla);
        
        // Sona de dibujo --------------------------

        graficos.drawRect(ejeX, 0, 100, 100);

        // -----------------------------------------

        graficos.dispose();
        buffer.show();
    }

    @Override
    public void run()
    {
        long ahora = 0;
        long ultimoTiempo = System.nanoTime();


        while(ejecucando)
        {
            /* 
            ahora = System.nanoTime();
            tiempo += (ahora - ultimoTiempo)/promedioFps;
            ultimoTiempo = ahora;
        
            if()
            */
            actualizar();
            dibujar();
        }

        stop();
    }

    public void start()
    {
        thread = new Thread(this);
        thread.start();

        ejecucando = true;
    }

    private void stop()
    {
        try 
        {
            thread.join();
            ejecucando = false;
        } 
        catch (InterruptedException e) 
        {
            e.printStackTrace();
        }
    }
    
}