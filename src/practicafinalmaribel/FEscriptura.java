package practicafinalmaribel;

import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

//Classe per posibilitar l'escriptura de fitxers
public class FEscriptura {

    private FileWriter output;
    
    //Métode constructor on s'introduirà el nom del fitxer que es voldrà escriure
    public FEscriptura(String nombreFichero) {
        try {
            //Inicialitzam el ficher 
            output = new FileWriter(nombreFichero);
        } catch (IOException ex) {
            Logger.getLogger(FEscriptura.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    //Métode per escriure un text i/o per fer fer un salt de línia
    public void escriure(char[] text, boolean introduirNovaLinea) {
        try {
            output.write(text);

            if (introduirNovaLinea) {
                output.write("\n");
            }
        } catch (IOException ex) {
            Logger.getLogger(FEscriptura.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    //Métode parescut al d'abans, però aquesta vegada amb un String
    public void escriure(String text, boolean introduirNovaLinea) {
        try {
            output.write(text);

            if (introduirNovaLinea) {
                output.write("\n");
            }
        } catch (IOException ex) {
            Logger.getLogger(FEscriptura.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    //Métode indispensable per tancar el fitxer després d'haver escrigut 
    public void tancar() {
        try {
            output.close();
        } catch (IOException ex) {
            Logger.getLogger(FEscriptura.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
