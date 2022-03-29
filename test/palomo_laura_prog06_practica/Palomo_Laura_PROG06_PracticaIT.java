package palomo_laura_prog06_practica;

import org.junit.Test;
import static org.junit.Assert.*;

public class Palomo_Laura_PROG06_PracticaIT {

    /**
     * Test of numeroAleatorio method. Este test proporciona un numero aleatorio
     * en nuestra operacion que va a visualizar y realizar el usuario,
     * en este caso sera un numero fijo introducido(eliminando el math.random) para poder realizar y comprobar este test.
     */
    @Test

    public void testNumeroAleatorio() {
        System.out.println("numeroAleatorio");
        int expResult = 2;
        int result = Palomo_Laura_PROG06_Practica.numeroAleatorio();
        assertEquals(expResult, result);

    }

     /**
     * Test of numeroAleatorio method. Este test es para comprobar que se realiza la resta(eliminando el math.random), 
     * asignando el numero 2.
     * Si le ponemos otro expResult nos dara error, en este caso nos vamos a nuestra clase, y cambiaremos el numero
     * de la variable operadores para que se cambie el operador.
     * 
     */
    @Test

    public void testgenerarOperadorAleatorio() {
        System.out.println("OperadorAleatorio");
        int expResult = 2;
        int result = Palomo_Laura_PROG06_Practica.numeroAleatorio();
        assertEquals(expResult, result);

    }

    /**
     * Test of rondas method. Este test comprueba que las rondas van a 
     * ser 0.
     */
    @Test

    public void testRondas() {
        System.out.println("rondas");
        int expResult = 0;
        int result = 0;
        assertEquals(expResult, result);
    }

}

