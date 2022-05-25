import java.awt.Desktop;  
import java.net.URL;  
public class Sendas {
	
	Sendas(){
			try {
				Desktop.getDesktop().browse(new URL("http://localhost/PSI/ver-sendas.php?id=2").toURI());
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
