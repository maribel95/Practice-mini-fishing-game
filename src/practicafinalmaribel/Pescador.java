
package practicafinalmaribel;

public class Pescador {
    
    private Paraula nom;
    private Peix peix[];
    private int numPeixos;
    
    private static final int MAX_NUM_PEIXOS = 100;


    public Pescador(Paraula nomPescador){
        this.nom = nomPescador;
        this.peix = new Peix[MAX_NUM_PEIXOS];
        this.numPeixos = 0;
    }
    
    public void actualitzarMillorPeix(Peix nouPeix) {
        
        boolean existeixPeix = false;
        
        for (int i = 0; i < this.numPeixos && !existeixPeix; i++) {
            existeixPeix = Paraula.compara(this.peix[i].getNom(), nouPeix.getNom());
            if (existeixPeix) {
                if (this.peix[i].getPes() < nouPeix.getPes()) {
                    this.peix[i].setPes(nouPeix.getPes());
                }
               
            }       
        }
        
        if (!existeixPeix) {
            afegeixNouPeix(nouPeix);
        }
        
    }
    
    public String getNom() {
        return this.nom.toString();
    }
    
    private void afegeixNouPeix(Peix nouPeix) {
        this.peix[this.numPeixos] = nouPeix;
        this.numPeixos += 1;
    }
 
    @Override
    public String toString() {
        String result = "El pescador " + this.nom + " té les següents millors pesques:\n";

        for (int i = 0; i < numPeixos; i++) {
            result += this.peix[i];
        }                           
        result += "\n";
        return result;
    }
            
    
}


