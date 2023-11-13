
package practicafinalmaribel;

import java.io.File;

//Classe on manejarem tot el tema fitxers i les funcions del simulador de pesca
public class SimuladorPesca {
    
    //Tots els fitxers amb que treballarem
    private static final String FITXER_USUARIS = "Fitxers/Usuaris/usuaris.txt";
    private static final String FITXER_USUARIS_AUX = "Fitxers/Usuaris/usuaris_aux.txt";

    private static final String FITXER_PESQUERA_MEDITERRANEO = "Fitxers/Pesqueras/mediterraneo.txt";
    private static final String FITXER_PESQUERA_FLORIDA = "Fitxers/Pesqueras/florida.txt";

    private static final String FITXER_PESQUES = "Fitxers/Pesques/pesques.txt";
    private static final String FITXER_PESQUES_AUX = "Fitxers/Pesques/pesques_aux.txt";

    //Atributs per poder dur a terme l'entrada o sortida de dades
    private FEscriptura fitxerEscriptura;
    private FLectura fitxerLectura;

    public SimuladorPesca() {

    }

    public void mostrarPuntuacioGlobal() {

        File fitxerExisteix = new File(FITXER_PESQUES);

        if (!fitxerExisteix.exists()) {
            System.out.println("Ningú ha pescat cap peix!!");
        } else {
            fitxerLectura = new FLectura(FITXER_PESQUERA_MEDITERRANEO);
            mostrarPuntuacioGlobalPesquera(fitxerLectura);

            fitxerLectura = new FLectura(FITXER_PESQUERA_FLORIDA);
            mostrarPuntuacioGlobalPesquera(fitxerLectura);
        }
    }

    private void mostrarPuntuacioGlobalPesquera(FLectura fitxerLectura) {
        FLectura fitxerPesquesLectura = new FLectura(FITXER_PESQUES);

        boolean fitxerAcabat = false;

        while (!fitxerAcabat) {
            char[] registrePeix = fitxerLectura.llegirLinea();

            if (registrePeix != null) {
                Paraula nomPeix = new Paraula();
                int index = 1;
                while (registrePeix[index] == '#') {
                    index++;
                }

                for (int i = index; i < registrePeix.length && registrePeix[index] != '#'; index++) {
                    nomPeix.posar(registrePeix[index]);
                }

                Peix peix = new Peix(nomPeix, 0.0);
                Pescador pescador = null;

                boolean fitxerPesquesAcabat = false;
                fitxerPesquesLectura = new FLectura(FITXER_PESQUES);
                while (!fitxerPesquesAcabat) {
                    char[] registrePesca = fitxerPesquesLectura.llegirLinea();

                    if (registrePesca != null) {
                        int segment = 0;
                        Paraula usuariPuntuacio = new Paraula();
                        Paraula nomPeixPal = new Paraula();
                        boolean esPrimerNum = true;
                        boolean esDecimal = false;
                        int numDecimals = 1;
                        double pesPeix = 0.0;
                        for (int i = 0; i < registrePesca.length; i++) {

                            if (registrePesca[i] == '#') {
                                segment++;
                            } else if (segment == 0) {
                                usuariPuntuacio.posar(registrePesca[i]);
                            } else if (segment == 1) {
                                nomPeixPal.posar(registrePesca[i]);
                            } else {
                                if (registrePesca[i] == '.') {
                                    esDecimal = true;
                                } else {
                                    if (esPrimerNum) {
                                        pesPeix = calcularValorDecimal(registrePesca[i]);
                                        esPrimerNum = false;
                                    } else {
                                        pesPeix = calcularValorDecimal(pesPeix, registrePesca[i], esDecimal, numDecimals);
                                        if (esDecimal) {
                                            numDecimals++;
                                        }
                                    }
                                }
                            }

                        }

                        if (Paraula.compara(peix.getNom(), nomPeixPal)) {
                            if (peix.getPes() < pesPeix) {
                                pescador = new Pescador(usuariPuntuacio);
                                peix = new Peix(peix.getNom(), pesPeix);
                            }
                        }

                    } else {
                        fitxerPesquesAcabat = true;
                    }

                }

                fitxerPesquesLectura.tancar();
                System.out.println("-----------------------------------------------");
                if (pescador != null) {

                    System.out.println(peix);
                    System.out.println("Pescat pel pescador: " + pescador.getNom() + "\n");
                } else {
                    System.out.println("Ningú ha pescat el peix " + peix.getNom() + "\n");
                }

            } else {
                fitxerAcabat = true;
            }

        }

        fitxerLectura.tancar();

    }

    public void mostrarPuntuacio(Paraula usuari) {

        File fitxerExisteix = new File(FITXER_PESQUES);

        if (!fitxerExisteix.exists()) {
            System.out.println("No hi ha pesques per aquest usuari!!");
        } else {

            Pescador pescador = new Pescador(usuari);

            if (!existeixUsuari(usuari)) {
                System.out.println("L'usuari que has introduit no existeix.");
            } else {
                fitxerLectura = new FLectura(FITXER_PESQUES);

                boolean fitxerAcabat = false;
                boolean existeix = false;

                while (!fitxerAcabat && !existeix) {
                    char[] registrePesca = fitxerLectura.llegirLinea();

                    if (registrePesca != null) {
                        int segment = 0;
                        Paraula usuariPuntuacio = new Paraula();
                        Paraula nomPeix = new Paraula();
                        boolean esPrimerNum = true;
                        boolean esDecimal = false;
                        int numDecimals = 1;
                        double pesPeix = 0.0;
                        for (int i = 0; i < registrePesca.length; i++) {

                            if (registrePesca[i] == '#') {
                                segment++;
                            } else if (segment == 0) {
                                usuariPuntuacio.posar(registrePesca[i]);
                            } else if (segment == 1) {
                                nomPeix.posar(registrePesca[i]);
                            } else {
                                if (registrePesca[i] == '.') {
                                    esDecimal = true;
                                } else {
                                    if (esPrimerNum) {
                                        pesPeix = calcularValorDecimal(registrePesca[i]);
                                        esPrimerNum = false;
                                    } else {
                                        pesPeix = calcularValorDecimal(pesPeix, registrePesca[i], esDecimal, numDecimals);
                                        if (esDecimal) {
                                            numDecimals++;
                                        }
                                    }
                                }
                            }

                        }

                        if (Paraula.compara(usuari, usuariPuntuacio)) {
                            pescador.actualitzarMillorPeix(new Peix(nomPeix, pesPeix));
                        }

                    } else {
                        fitxerAcabat = true;
                    }

                }
                System.out.println(pescador);

                fitxerLectura.tancar();

            }
        }

    }

    private double calcularValorDecimal(char num) {
        double valor = (double) Character.getNumericValue(num);
        return valor;
    }

    private double calcularValorDecimal(double anticValor, char num, boolean esDecimal, int numDecimals) {
        double valor = (double) Character.getNumericValue(num);
        if (esDecimal) {
            valor /= Math.pow(10, numDecimals);
        } else {
            anticValor *= 10;
        }

        valor += anticValor;
        return valor;
    }

    public void pescar(Paraula usuari, int numPesquera) {
        // numPesquera:
        // 1. Mediterraneo
        // 2. Florida
        switch (numPesquera) {
            case 1:
                fitxerLectura = new FLectura(FITXER_PESQUERA_MEDITERRANEO);
                break;
            case 2:
                fitxerLectura = new FLectura(FITXER_PESQUERA_FLORIDA);
                break;
        }

        double percentatgePeix = Math.random();

        boolean fitxerAcabat = false;

        while (!fitxerAcabat) {
            //Llegim el contintingut del fitxer i el guardam en un char[]
            char[] lineaPeix = fitxerLectura.llegirLinea();

            if (lineaPeix != null) {
                Peix peix = new Peix(lineaPeix);

                if (percentatgePeix < peix.getProbabilitat()) {
                    escriurePesca(usuari, peix);

                    System.out.println("S'ha pescat satisfactoriament un peix.");
                    System.out.println("Nom del peix: " + peix.getNom() + ".");
                    System.out.println("Tamany: " + String.valueOf(peix.getPes()).substring(0, 5) + " kg.");
                    fitxerAcabat = true;
                }

            } else {
                System.out.println("Error. No s'ha pogut pescar un peix.");
                fitxerAcabat = true;
            }
        }

        fitxerLectura.tancar();

    }

    private void escriurePesca(Paraula usuari, Peix peix) {
        File fitxerExisteix = new File(FITXER_PESQUES);
        String nouRegistrePesca = usuari + "#" + peix.getNom() + "#" + String.valueOf(peix.getPes()).substring(0, 5);
        if (!fitxerExisteix.exists()) {
            fitxerEscriptura = new FEscriptura(FITXER_PESQUES);

            fitxerEscriptura.escriure(nouRegistrePesca, true);
            fitxerEscriptura.tancar();
        } else {
            fitxerEscriptura = new FEscriptura(FITXER_PESQUES_AUX);
            fitxerLectura = new FLectura(FITXER_PESQUES);
            boolean fitxerAcabat = false;

            while (!fitxerAcabat) {
                char[] linea = fitxerLectura.llegirLinea();

                if (linea != null) {
                    // Escrivim els antics usuaris en un fitxer auxiliar
                    Paraula registrePesca = new Paraula(linea);
                    fitxerEscriptura.escriure(registrePesca.getParaula(), true);

                } else {

                    fitxerEscriptura.escriure(nouRegistrePesca, true);
                    fitxerAcabat = true;
                }

            }

            fitxerLectura.tancar();
            fitxerEscriptura.tancar();

            File fitxerBorrar = new File(FITXER_PESQUES);
            fitxerBorrar.delete();
            File fitxerCanviarNom = new File(FITXER_PESQUES_AUX);
            fitxerCanviarNom.renameTo(fitxerBorrar);
        }

    }

    public void altaUsuari(Paraula usuari) {
        File fitxerExisteix = new File(FITXER_USUARIS);

        if (!fitxerExisteix.exists()) {
            escriurePrimerUsuari(usuari);

        } else if (existeixUsuari(usuari)) {
            System.out.println("Error: No pots introduir un usuari que ja existeix!!.");

        } else {
            escriureNouUsuari(usuari);
            System.out.println("Usuari donat d'alta satisfactoriamente.");
        }

    }

    private void escriurePrimerUsuari(Paraula primerUsuari) {
        fitxerEscriptura = new FEscriptura(FITXER_USUARIS);
        fitxerEscriptura.escriure(primerUsuari.getParaula(), true);
        fitxerEscriptura.tancar();
    }

    public boolean existeixUsuari(Paraula nouUsuari) {
        fitxerLectura = new FLectura(FITXER_USUARIS);

        boolean fitxerAcabat = false;
        boolean existeixUsuari = false;

        while (!fitxerAcabat && !existeixUsuari) {
            char[] usuariLectura = fitxerLectura.llegirLinea();

            if (usuariLectura != null) {
                Paraula anticUsuari = new Paraula(usuariLectura);

                if (Paraula.compara(nouUsuari, anticUsuari)) {
                    existeixUsuari = true;
                }

            } else {
                fitxerAcabat = true;
            }

        }

        fitxerLectura.tancar();

        return existeixUsuari;
    }

    private void escriureNouUsuari(Paraula nouUsuari) {
        fitxerEscriptura = new FEscriptura(FITXER_USUARIS_AUX);
        fitxerLectura = new FLectura(FITXER_USUARIS);
        boolean fitxerAcabat = false;

        while (!fitxerAcabat) {
            char[] usuariLectura = fitxerLectura.llegirLinea();

            if (usuariLectura != null) {
                // Escrivim els antics usuaris en un fitxer auxiliar
                Paraula anticUsuari = new Paraula(usuariLectura);
                fitxerEscriptura.escriure(anticUsuari.getParaula(), true);

            } else {
                // Escrivim el nou usuari com el darrer de tots
                fitxerEscriptura.escriure(nouUsuari.getParaula(), true);
                fitxerAcabat = true;
            }

        }

        fitxerLectura.tancar();
        fitxerEscriptura.tancar();

        File fitxerBorrar = new File(FITXER_USUARIS);
        fitxerBorrar.delete();
        File fitxerCanviarNom = new File(FITXER_USUARIS_AUX);
        fitxerCanviarNom.renameTo(fitxerBorrar);

    }

    private void borrarUsuari(Paraula usuari) {

        fitxerEscriptura = new FEscriptura(FITXER_USUARIS_AUX);
        fitxerLectura = new FLectura(FITXER_USUARIS);
        boolean fitxerAcabat = false;

        while (!fitxerAcabat) {
            //Llegim el contintingut del fitxer i el guardam en un char[]
            char[] usuariLectura = fitxerLectura.llegirLinea();

            if (usuariLectura != null) {
                // Escrivim els antics usuaris menys el que volem donar de baixa 
                // en un fitxer auxiliar

                Paraula anticUsuari = new Paraula(usuariLectura); //a usuari lectura hi ha que llevar l'usuari introduit

                if (!Paraula.compara(usuari, anticUsuari)) {
                    fitxerEscriptura.escriure(anticUsuari.getParaula(), true);
                }

            } else {
                fitxerAcabat = true;
            }
        }

        fitxerLectura.tancar();
        fitxerEscriptura.tancar();

        File fitxerBorrar = new File(FITXER_USUARIS);
        fitxerBorrar.delete();
        File fitxerCanviarNom = new File(FITXER_USUARIS_AUX);
        fitxerCanviarNom.renameTo(fitxerBorrar);

    }

    public void baixaUsuari(Paraula usuari) {
        File fitxerExisteix = new File(FITXER_USUARIS);

        if (!fitxerExisteix.exists()) {
            System.out.println("Error: No pots donar de baixa un usuari que no existeix.");

        } else if (existeixUsuari(usuari)) {
            borrarUsuari(usuari);
            System.out.println("Usuari donat de baixa satisfactoriamente.");
        } else {
            System.out.println("Error: No pots donar de baixa un usuari que no existeix.");
        }
    }

}
