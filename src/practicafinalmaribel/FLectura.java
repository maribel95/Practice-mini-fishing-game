package practicafinalmaribel;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

//Classe per posibilitar la lectura de fitxers
public class FLectura {

    private FileReader input;
    private BufferedReader lect;
    
    //Métode constructor on s'introduirà el nom del fitxer a llegir
    public FLectura(String nom) {
        try {
            input = new FileReader(nom);
            lect = new BufferedReader(input);
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        }
    }

    //Métode per llegir línia  a línia el fitxer
    public char[] llegirLinea() {
        char[] res = null;
        try {
            String aux = lect.readLine();
            if (aux != null) {
                res = aux.toCharArray();
            } else {
                aux = null;
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return res;
    }

    //Métode indispensable per tancar el fitxer després de la lectura
    public void tancar() {
        try {
            lect.close();
            input.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            try {
                input.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }
}
