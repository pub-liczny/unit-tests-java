package pl.devfoundry.testing;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.Duration;
import java.util.List;
import java.util.function.Predicate;

import static org.assertj.core.api.Assertions.anyOf;
import static org.assertj.core.api.Assertions.assertThat;
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

    @Test
    void cartShouldNotBeEmptyAfterAddingOrderToCart(){
        //given
        Order order = new Order();
        Cart cart = new Cart();

        //when
        cart.addOrderToCart(order);

        //then
        // To poniżej wyświetli wszystkie niespełnione warunki, a nie zatrzyma się po pierwszym
        assertAll("This is a group of assertions for cart",
                () -> assertThat(cart.getOrders()).isNotNull(),
                () -> assertThat(cart.getOrders()).hasSize(1),
                () -> assertThat(cart.getOrders()).isNotEmpty(),
                () -> assertThat(cart.getOrders()).hasOnlyElementsOfType(Order.class),
                () -> {
                    final List<Meal> meals = cart.getOrders().get(0).getMeals();
                    assertThat(meals).isEmpty();
                }
        );
    }
}