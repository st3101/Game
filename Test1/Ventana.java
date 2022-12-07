import javax.swing.JFrame;

public class Ventana extends JFrame implements Runnable 
{
    public Ventana(int altoPantalla, int largoPantalla)
    {
        setTitle("My Invidader");
		setSize(altoPantalla, largoPantalla);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		setLocationRelativeTo(null);
        setFocusable(true);
		setVisible(true);
    }
    
    @Override
    public void run()
    {

    }

    
}