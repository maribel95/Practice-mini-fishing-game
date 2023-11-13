
package practicafinalmaribel;

//Classe proporcionada pel professor per poder crear paraula
public class Paraula {

    private char[] pal;
    private int n;

    //Métode constructor per defecte que inicialitza una paraula
    public Paraula() {
        pal = new char[30];
        n = 0;
    }

    //Métode per paràmetre on pasam un text en char array
    public Paraula(char[] text) {
        n = text.length;
        pal = new char[n];

        for (int i = 0; i < text.length; i++) {
            pal[i] = text[i];
        }
    }

    public char[] getParaula() {
        return pal;
    }
    
    //Métode per posar una paraula com si fos un métode setter
    public void posar(char c) {
        pal[n++] = c;
    }

    //Métode per saber si la paraula está buida o no
    public boolean buida() {
        return (n == 0);
    }

    //Métode per comparar si dues paraules son iguals
    public static boolean compara(Paraula p1, Paraula p2) {

        boolean sonIguals = true;

        if (p1.n != p2.n) {
            sonIguals = false;
        }

        if (sonIguals) {
            for (int i = 0; i < p1.n && sonIguals; i++) {
                if (p1.pal[i] != p2.pal[i]){
                    sonIguals = false;
                }
            }
        }
        
        return sonIguals;
    }

    public String toString() {
        String res = "";
        for (int i = 0; i < n; i++) {
            res = res + pal[i];
        }
        return res;
    }
}
