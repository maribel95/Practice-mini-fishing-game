
package practicafinalmaribel;

//Classe on tractarem les dades dels peixos
public class Peix {

    private Paraula nom;
    private double probabilitat;
    private double pes;

    public Peix(char[] peix) {
        // Format del parametre peix hauria de ser #nomPeix#probabilitat#minimPes#maximPes#
        nom = new Paraula();
        inicialitzar(peix);
    }
    
    public Peix(Paraula nom, double pes) {
        this.nom = nom;
        this.pes = pes;
    }
    
    //Métode per transformar les dades del peix en un char array
    private void inicialitzar(char[] peix) {
        // Segment:
        // 1. Nom del peix
        // 2. Probabilitat
        // 3. Minim pes
        // 4. Maxim pes
        int segment = 1;
        double valor = 0.0;
        double probabilitatPeix = 0.0;
        double pesMinim = 0.0;
        double pesMaxim = 0.0;
        
        boolean esPrimerNum = true;
        boolean esDecimal = false;
        int numDecimals = 1;
        int index = 1;
        
        //Això es per botar els hashtags que hi ha enmig de la informació
        while (index < peix.length && peix[index] == '#'){
            index++;
        }
        
        for (int i = index; i < peix.length; i++) {

            if (peix[i] == '#') {
                switch (segment) {
                    case 2:
                        probabilitatPeix = valor;
                        break;
                    case 3:
                        pesMinim = valor;
                        break;
                    case 4:
                        pesMaxim = valor;
                        break;
                }
                segment++;
                esPrimerNum = true;
                esDecimal = false;
                valor = 0.0;
                numDecimals = 1;
                
            } else {

                if (segment == 1) { // Nom peix
                    nom.posar(peix[i]);
                    
                } else if (segment == 2 || segment == 3 || segment == 4) {

                    if (peix[i] == '.') {
                        esDecimal = true;
                    } else {
                        //Esteim calculant el primer nombre davant la coma del decimals
                        if (esPrimerNum) {
                            valor = calcularValorDecimal(peix[i]);
                            esPrimerNum = false; //Això tornarà false perquè només hi ha un primer nombre
                        } else {
                            //Esteim calculant els decimals de darrera la coma
                            valor = calcularValorDecimal(valor, peix[i], esDecimal, numDecimals);
                            //Ho feim per tots els decimals
                            if (esDecimal) {
                                numDecimals++;
                            }
                        }
                    }
                } 

            }

        }

        probabilitat = probabilitatPeix;
        pes = (double) (Math.random() * (pesMaxim - pesMinim)) + pesMinim;
    }

    public Paraula getNom() {
        return nom;
    }

    public double getProbabilitat() {
        return probabilitat;
    }

    public double getPes() {
        return pes;
    }
    
    public void setPes(double nouPes) {
        this.pes = nouPes;
    }

    //Métode per calcular els valors decimals 
    private double calcularValorDecimal(char num) {
        double valor = (double) Character.getNumericValue(num);
        return valor;
    }
    
    //Métode per calcular valors decimals
    private double calcularValorDecimal(double anticValor, char num, boolean esDecimal,int numDecimals) {
        double valor = (double) Character.getNumericValue(num);
        if (esDecimal) {
            valor /= Math.pow(10, numDecimals);
        } else {
            anticValor *= 10;
        }

        valor += anticValor;
        return valor;
    }
    
    @Override
    public String toString() {
        String result = "Nom del peix: " + this.nom + ", pes: " + this.pes + " kg.\n";
        return result; 
    }

}
