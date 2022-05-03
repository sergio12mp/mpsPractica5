package practica5;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;


public class BoundedQueueTest {
    /**
     * Casos de Prueba
     * <p>
     * 1- Comprobar una creacion correcta
     * 2- Comprobar que se añade
     * 3- Comprobar que se coge
     * 4- Comprobar que esta Completa
     * 5- Comprobar que esta vacio
     * 6- Comprobar el numero de objetos
     */


    @Test
    public void shouldCreateABoundedQueueCorrectly() {

        var boundedQueue = new BoundedQueue<Integer>(10);
        boundedQueue.put(1);
        System.out.println(boundedQueue.get());
        assertThat(boundedQueue.get()).isEqualTo(1);

    }

    @Test
    public void shouldThrownAnExceptionIfYouWantToPutAnElementInAFullQueue() {
        var boundedQueue = new BoundedQueue<Integer>(2);
        boundedQueue.put(1);
        boundedQueue.put(1);
        assertThatThrownBy(() -> boundedQueue.put(1)).isInstanceOf(FullQueueException.class);

    }




}
