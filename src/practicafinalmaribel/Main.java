package practicafinalmaribel;

public class Main {

    public static final int OPCIO_ACABAR_PROGRAMA = 0;
    public static final LT teclat = new LT();

    private static int menuPrincipal() {
        int resultat = OPCIO_ACABAR_PROGRAMA;
        boolean esOpcioCorrecta = false;
        Character aux;

        do {
            System.out.println("***************************************");
            System.out.println("*   MENÚ PRINCIPAL DEL JOC DE PESCA   *");
            System.out.println("***************************************");
            System.out.println("*     1 Alta d'usuari                 *");
            System.out.println("*     2 Baixa d'usuari                *");
            System.out.println("*     3 Pesca en una pesquera         *");
            System.out.println("*     4 Estadístiques per usuari      *");
            System.out.println("*     5 Estadístiques globals         *");
            System.out.println("*     " + OPCIO_ACABAR_PROGRAMA + " Sortir                        *");
            System.out.println("***************************************");
            System.out.print("Opció? ");
            try {
                resultat = teclat.llegirSencer();
            } catch (java.lang.NullPointerException ex) {
                resultat = -1;
            }
            //Per mirar si la opció introduida és vàlida
            esOpcioCorrecta = resultat >= OPCIO_ACABAR_PROGRAMA && resultat <= 5;

            if (!esOpcioCorrecta) {
                System.out.println("\nOpcio incorrecta. Torna a escollir una opcio!!\n");
            }

        } while (!esOpcioCorrecta);

        return resultat;
    }

    private static int menuEscogirPesquera() {
        int resultat = OPCIO_ACABAR_PROGRAMA;
        boolean esOpcioCorrecta = false;
        Character aux;

        do {
            System.out.println("***************************************");
            System.out.println("*   MENÚ PRINCIPAL DEL JOC DE PESCA   *");
            System.out.println("***************************************");
            System.out.println("*     1 Mediterranea                 *");
            System.out.println("*     2 Florida                      *");
            System.out.println("*     " + OPCIO_ACABAR_PROGRAMA + " Sortir                        *");
            System.out.println("***************************************");
            System.out.print("Opció? ");
            try {
                resultat = teclat.llegirSencer();
            } catch (java.lang.NullPointerException ex) {
                resultat = -1;
            }

            esOpcioCorrecta = resultat >= OPCIO_ACABAR_PROGRAMA && resultat <= 2;

            if (!esOpcioCorrecta) {
                System.out.println("\nOpcio incorrecta. Torna a escollir una opcio!!\n");
            }

        } while (!esOpcioCorrecta);

        return resultat;
    }

    private static int menuPescar() {
        int resultat = OPCIO_ACABAR_PROGRAMA;
        boolean esOpcioCorrecta = false;
        Character aux;

        do {
            System.out.println("***************************************");
            System.out.println("*   MENÚ PRINCIPAL DEL JOC DE PESCA   *");
            System.out.println("***************************************");
            System.out.println("*     1 Pescar                        *");
            System.out.println("*     " + OPCIO_ACABAR_PROGRAMA + " Sortir                        *");
            System.out.println("***************************************");
            System.out.print("Opció? ");
            try {
                resultat = teclat.llegirSencer();
            } catch (java.lang.NullPointerException ex) {
                resultat = -1;
            }

            esOpcioCorrecta = resultat >= OPCIO_ACABAR_PROGRAMA && resultat <= 1;

            if (!esOpcioCorrecta) {
                System.out.println("\nOpcio incorrecta. Torna a escollir una opcio!!\n");
            }

        } while (!esOpcioCorrecta);

        return resultat;
    }

    public static void main(String[] args) {

        int opcio = -1;
        SimuladorPesca simuladorPesca = new SimuladorPesca();
        char[] usuari;
        Paraula nomUsuari;
        do {
            opcio = menuPrincipal();

            switch (opcio) {

                case 1:
                    System.out.println("Escriure el nom de l'usuari que vols donar d'alta:");
                    usuari = teclat.llegirln();
                    nomUsuari = new Paraula(usuari);

                    simuladorPesca.altaUsuari(nomUsuari);
                    break;
                case 2:
                    System.out.println("Escriure el nom de l'usuari que vols donar de baixa:");
                    usuari = teclat.llegirln();
                    nomUsuari = new Paraula(usuari);

                    simuladorPesca.baixaUsuari(nomUsuari);
                    break;
                case 3:
                    System.out.println("Escriure el nom de l'usuari que vol pescar:");

                    usuari = teclat.llegirln();
                    nomUsuari = new Paraula(usuari);
                    if (!simuladorPesca.existeixUsuari(nomUsuari)) {
                        System.out.println("L'usuari que has introduit no existeix.");
                    } else {
                        int opcioPesquera = menuEscogirPesquera();
                        int opcioPesca = OPCIO_ACABAR_PROGRAMA;
                        do {
                            opcioPesca = menuPescar();
                            if (opcioPesca != OPCIO_ACABAR_PROGRAMA) {
                                simuladorPesca.pescar(nomUsuari, opcioPesquera);
                            }
                        } while (opcioPesca != OPCIO_ACABAR_PROGRAMA);

                    }
                    break;
                case 4:
                    System.out.println("Escriure el nom de l'usuari per sebre la seva puntuació:");
                    usuari = teclat.llegirln();
                    nomUsuari = new Paraula(usuari);
                    simuladorPesca.mostrarPuntuacio(nomUsuari);
                    break;
                case 5:
                    simuladorPesca.mostrarPuntuacioGlobal();
                    
                    
                    break;
                    
            }

        } while (opcio != OPCIO_ACABAR_PROGRAMA);

    }

}
