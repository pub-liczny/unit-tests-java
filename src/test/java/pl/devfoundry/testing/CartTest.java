package pl.devfoundry.testing;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.*;

//@Disabled
@DisplayName("Test cases for Cart")
class CartTest {

//    @Ignore   // Dla JUunit4
//    @Disabled
    @DisplayName("Cart is able to process 1000 orders in 100 ms")
    @Test   // Dla JUnit4 dodawłąo się do adnotacji (timeout = 100)
    void simulateLargeOrder() {
        //given
        Cart cart = new Cart();

        //when
        //then
        assertTimeout(Duration.ofMillis(100), cart::simulateLargeOrder);
    }
}