package palomo_laura_prog06_practica;

import java.util.Scanner;

/**
 *
 * @author Laura Palomo García
 */
public class Palomo_Laura_PROG06_Practica {

// Variables que se utilizaran en las funciones/métodos 
    static int jugador;
    static int posicionJugadores[];
    static String nombres[];
    static int puntuaciones[];
    static int numRondas;


    /**
     * En este método se irán desarrollando las rondas
     */
    public static void iniciarPartida() {
        Scanner teclado = new Scanner(System.in);
        //Se pide el número de jugadores que van a jugar
        System.out.println("¿Cuantos jugadores participaran en el juego(1-6)?");
        jugador = teclado.nextInt();
        /*Si el numero de jugadores que te dan es menor de 1 o mayor de 6
          se vuelve a pedir los jugadores que van a jugar
         */
        while (jugador > 6 || jugador < 1) {
            System.out.println("Numero de Jugadores incorrecto");
            System.out.println("¿Cuantos jugadores participaran en el juego(1-6)?");
            jugador = teclado.nextInt();
        }
        //Se pide el número de rondas que se van a jugar
        while (numRondas != 3 && numRondas != 5 && numRondas != 10 && numRondas != 20) {
            System.out.println("¿Cuántas rondas deseas establecer? \n"
                    + "Introduzca el número correspondiente de unas de las partidas indicadas: \n"
                    + "Partida rapida (3)\n"
                    + "Partida corta (5)\n"
                    + "Partida normal (10)\n"
                    + "Partida larga (20)\n");
            numRondas = teclado.nextInt();
        }
        /*Se crean los Arrays en los que se van a guardar las posiciones,
        los nombres y las puntuaciones de cada jugador
         */
        posicionJugadores = new int[jugador];
        nombres = new String[jugador];
        puntuaciones = new int[jugador];
        //Se ponen las puntuaciones de todos los jugadores a 0
        for (int i = 0; i < puntuaciones.length; i++) {
            puntuaciones[i] = 0;
        }
        //Se piden los nombres de los jugadores y se guardan en el Array de los nombres
        for (int i = 0; i < nombres.length; i++) {
            int numJugador = i + 1;
            System.out.println("Dar nombre del jugador " + numJugador);
            nombres[i] = teclado.next();
        }
        //Se dan posiciones aleatorias a cada jugador(que si se pueden repetir)
        for (int i = 0; i < posicionJugadores.length; i++) {
            int posicion = (int) ((Math.random() * jugador) + 1);
            posicionJugadores[i] = posicion;
        }
        /*Con estos dos bucles se comparan todas las posiciones y
        si alguna de ella se repite se cambia por una nueva posicion, 
        y si esta nueva posicion coincide con otra de las posiciones 
        que ya habia,se vuelve a poner otra nueva posicion hasta que
        en cada casilla del Array haya una posicion distinta
         */
        for (int j = 0; j < posicionJugadores.length; j++) { // creamos la primera variable para la comprobacion
            for (int k = 0; k < posicionJugadores.length; k++) {//creamos la segunda que hara la comprobacion
                if (j != k && posicionJugadores[j] == posicionJugadores[k]) {
                    int nuevaPosicion = (int) ((Math.random() * jugador) + 1);
                    posicionJugadores[j] = nuevaPosicion;
                    j = 0;
                }
            }
        }
        System.out.println("Las posiciones asignadas para los jugadores son:");
        //Se muestran los jugadores con las posiciones correspondientes
        for (int i = 0; i < posicionJugadores.length; i++) {
            System.out.println("Jugador " + nombres[i] + " ,Posición :" + posicionJugadores[i]);
        }
    }
  
    /**
     * @param:operadores, en este caso el 2, solo se hara la resta.
     * @param:operador, con espacio para indicar donde va el operador, en este caso la resta.
     * @return genera un operador de forma aleatoria
     */
    public static String generarOperadorAleatorio() {
        String operador = "";
        //Generación de número aleatorio, en este caso sera fijo para que nos haga una sola operacion, 
        //y al poner dos en la variable operadores nos saldra por pantalla la resta, ya que esta asignada con ese numero.
        int operadores = 2;
        //Switch para escoger uno de los operadores al azar.
        switch (operadores) {
            case 1:
                operador = "+";
                break;
            case 2:
                operador = "-";
                break;
            case 3:
                operador = "*";
                break;
        }
        return operador;
    }

    /**
     * @param:numero fijo.
     * @return genera un numero aleatorio, en este caso he puesto un numero fijo 
     * para poder hacer el test JUnit.
     */
    public static int numeroAleatorio() {
        int numero;
        numero = 2;
        return numero;
    }


    /**
     * En este método se irán desarrollando las rondas
     */
    public static void rondas() {
        Scanner teclado = new Scanner(System.in);
        int numRonda = 1;
        /*Mientras que la variable numRonda sea menor que numRondas,
   que es el numero de rondas que se ha pedido anteriormente
         */
        while (numRonda <= numRondas) {
            System.out.println("Ronda " + numRonda);
           
            /* En este caso he puesto un numero fijo , es decir el tres para que solo se pueda realizar una operacion 
            * con dos numeros, pero podriamos ponerle otro numero y que sean mas valores o el math.random.
             */
            int longitudOperacion = 3;
            //Esto son mas variables que se utilizan a lo largo del método    
            int numero, operaciones = 0;
            int numeros[] = new int[longitudOperacion];
            String operadores[] = new String[longitudOperacion - 1];
            String pregunta = "";
            /*Estos bucles sirven para que las preguntas se hagan
        por el orden de la posición de los jugadores
             */
            for (int i = 1; i <= jugador; i++) {
                for (int j = 0; j < posicionJugadores.length; j++) {
                    pregunta = "";
                    if (posicionJugadores[j] == i) {
                        System.out.println("Jugador " + nombres[j] + " responda a la siguiente pregunta:");
                        /*Con este bucle genero la pregunta de forma aleatoria
              llamando a los métodos generarOperadorAleatorio() y al método
              numeroAleatorio()
                         */
                        for (int k = 0; k < longitudOperacion; k++) {
                            if (k == longitudOperacion - 1) {
                                numero = numeroAleatorio();
                                pregunta = pregunta + numero;
                                numeros[k] = numero;
                            } else {
                                operadores[k] = generarOperadorAleatorio();
                                numero = numeroAleatorio();
                                pregunta = pregunta + numero + operadores[k];
                                numeros[k] = numero;
                            }
                        }
                        System.out.println("Pregunta: " + pregunta);
                        System.out.println("Realiza la operacion de izquierda a derecha,sin tener en cuenta la prioridad de los operadores");
                        int respuesta = teclado.nextInt();
                        /*Con la siguiente línea guardo en la variable operaciones el primer
                numero aleatorio que se ha generado anteriormente
                         */
                        operaciones = numeros[0];
                        /*Con este bucle calculo las operaciones para verificar si el 
                resultado que da el jugador es correcto o no
                         */
                        for (int k = 0; k < operadores.length; k++) {
                            if (operadores[k].equals("*")) {
                                operaciones = operaciones * numeros[k + 1];
                            }
                            if (operadores[k].equals("+")) {
                                operaciones = operaciones + numeros[k + 1];
                            }
                            if (operadores[k].equals("-")) {
                                operaciones = operaciones - numeros[k + 1];
                            }
                        }
                        //Si la respuesta que da el jugador es corecta
                        if (operaciones == respuesta) {
                            puntuaciones[j]++;
                            System.out.println("Enhorabuena has acertado,obtienes 1 punto");
                        } //Si la respuesta que da el jugador no es corecta
                        else {
                            System.out.println("No has acertado,no ganas ningún punto, la respuesta era: " + operaciones);
                        }
                    }
                }
            }
            //Se muestran las puntuaciones despues de que finalice cada ronda
            System.out.println("Puntuaciones después de la ronda " + numRonda);
            for (int i = 0; i < posicionJugadores.length; i++) {
                System.out.println("Jugador " + nombres[i] + " ,Puntuación: " + puntuaciones[i]);
            }
            //Se incrementa el número de ronda
            numRonda++;
        }
    }


    /**
     * Con este método se muestran las puntuaciones finales de cada jugador 
     * y quien o quienes han ganado el juego.
     */

    public static void resultadosPartida() {
        int mayorPuntuacion = -1;
        //Se muestran las puntuaciones de todos los jugadores
        System.out.println("Puntuaciones finales:");
        for (int i = 0; i < posicionJugadores.length; i++) {
            System.out.println("Jugador " + nombres[i] + " ,Puntuación: " + puntuaciones[i]);
            if (mayorPuntuacion < puntuaciones[i]) {
                mayorPuntuacion = puntuaciones[i];
            }
        }
        //Se muestra el ganador o los ganadores del juego
        System.out.println("El/Los ganador/es es/son:");
        for (int j = 0; j < puntuaciones.length; j++) {
            if (mayorPuntuacion == puntuaciones[j]) {
                System.out.println("Jugador " + nombres[j]);
            }
        }
    }

    /**
     *
     * @param args Aqui se pondran las funciones utilizadas.
     */
    public static void main(String[] args) {
        iniciarPartida();
        rondas();
        resultadosPartida();
    }
}

           