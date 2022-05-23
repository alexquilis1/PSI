import java.awt.Desktop;  
import java.io.*;  
public class Sendas {
	
	Sendas(){
		try {
			//constructor of file class having file as argument
			File f = new File("C:\\xampp\\htdocs\\PSI\\ver-sendas.php");
			if(!Desktop.isDesktopSupported()) {
				//check if Desktop is supported by Platform or not
				System.out.println("Not supported");
				return;
			}
			Desktop d = Desktop.getDesktop();
			//checks file exists or not
			if(f.exists()) {
				//opens the specified file
				d.open(f);	
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
