package practica5;

import org.junit.jupiter.api.Test;
import org.springframework.test.util.ReflectionTestUtils;

import java.util.List;

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
     * 7- Lanza Excepción si se quiere añadir un objeto y lista llena
     * 8- Lanza Excepción si se quiere coger un objeto y lista vacia
     * 9-
     *
     */


    @Test
    public void BondedQueue_() {
        var EXPECTED_CAPACITY = 2;
        var bondedQueue = new BoundedQueue<Integer>(EXPECTED_CAPACITY);

        var capacity = (int) ReflectionTestUtils.getField(bondedQueue, "capacity");
        var buffer = (List<Integer>) ReflectionTestUtils.getField(bondedQueue, "buffer");
        var nextItem = (int) ReflectionTestUtils.getField(bondedQueue, "nextItem");
        var nextFreeSlot = (int) ReflectionTestUtils.getField(bondedQueue, "nextFreeSlot");
        var numberOfItems = (int) ReflectionTestUtils.getField(bondedQueue, "numberOfItems");

        assertThat(capacity).isEqualTo(EXPECTED_CAPACITY);
        assertThat(nextItem).isEqualTo(nextFreeSlot).isEqualTo(numberOfItems)
                .isEqualTo(0);
        assertThat(buffer).isEmpty();
    }

    @Test
    public void shouldCreateABoundedQueueCorrectly() {

        var boundedQueue = new BoundedQueue<Integer>(1);
        boundedQueue.put(1);
        System.out.println(boundedQueue.get());
        assertThat(boundedQueue.get()).isEqualTo(1);

    }

    @Test//7- Lanza Excepción si se quiere añadir un objeto y lista llena
    public void shouldThrownAnExceptionIfYouWantToPutAnElementInAFullQueue() {
        var boundedQueue = new BoundedQueue<Integer>(2);
        boundedQueue.put(1);
        boundedQueue.put(1);
        assertThatThrownBy(() -> boundedQueue.put(1)).isInstanceOf(FullQueueException.class);
    }

    @Test//8- Lanza Excepción si se quiere coger un objeto y lista vacia
    public void shouldThrownAnExceptionIfYouWantToGetAnElementInAnEmptyQueue() {
        var boundedQueue = new BoundedQueue<Integer>(1);
        assertThatThrownBy(() -> boundedQueue.get()).isInstanceOf(EmptyQueueException.class);

    }

}
