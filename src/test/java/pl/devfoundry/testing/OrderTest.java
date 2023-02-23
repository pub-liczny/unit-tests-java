package pl.devfoundry.testing;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;

// Testowanie kolekcji
public class OrderTest {

    Order order;

    @BeforeEach     // Tak dla JUnit5
//    @Before       // Tak dla JUnit4
    void initialize() {
//        System.out.println("Inside @BeforeEach method");
        order = new Order();
    }

    @AfterEach      // Tak dla JUnit5
//    @AfterEach        // Tak dla JUnit4
    void cleanUp() {
//        System.out.println("Inside @AfterEach method");
        order.cancel();
    }

    @Test
    void testAssertArrayEquals() {
        // Given
        int[] int1 = {1, 2, 3};
        int[] int2 = {1, 2, 3};

        // Then
        assertArrayEquals(int1, int2);
    }

    @Test
    void mealListShouldBeEmptyAfterCreationOfOrder() {
        // then
        assertThat(order.getMeals()).isNotNull();
        assertThat(order.getMeals()).isEmpty();
        assertThat(order.getMeals().size()).isEqualTo(0);
        assertThat(order.getMeals().size()).isZero();
        assertThat(order.getMeals()).hasSize(0);
        assertThat(order.getMeals()).isEmpty();
        assertThat(order.getMeals()).hasOnlyElementsOfType(Meal.class);

        // inny zapis tego samego
        assertThat(order.getMeals()).isNotNull()
                                    .hasSize(0)
                                    .hasOnlyElementsOfType(Meal.class)
                                    .isEmpty();
        assertThat(order.getMeals().size()).isEqualTo(0)
                                           .isZero();
    }

    @Test
    void addingMealToOrderShouldIncreaseOrderSize() {
        // given
        Meal meal = new Meal(15, "Burger");
        Meal meal2 = new Meal(5, "Sandwich");

        // when
        order.addMealToOrder(meal);

        // then
        assertThat(order.getMeals()).isNotNull();
        assertThat(order.getMeals()).isNotEmpty();
        assertThat(order.getMeals()).hasSize(1);
        assertThat(order.getMeals().size()).isEqualTo(1);
        assertThat(order.getMeals()).contains(meal);
        assertThat(order.getMeals()).doesNotContain(meal2);
    }

    @Test
    void removeMealFromOrderShouldDecreaseOrderSize() {
        // given
        Meal meal = new Meal(15, "Burger");

        // when
        order.addMealToOrder(meal);
        order.removeMealFromOrder(meal);

        // then
        assertThat(order.getMeals()).isNotNull()
                .hasSize(0)
                .hasOnlyElementsOfType(Meal.class)
                .isEmpty();
    }

    @Test
    void mealsShouldBeInCorrectOrderAfterAddingThemToOrder() {
        // given
        Meal meal1 = new Meal(15, "Burger");
        Meal meal2 = new Meal(5, "Sandwich");

        // when
        order.addMealToOrder(meal1);
        order.addMealToOrder(meal2);

        // then
        assertThat(order.getMeals()).contains(meal1, meal2);
        assertThat(order.getMeals()).containsAll(Arrays.asList(meal1, meal2));
        assertThat(order.getMeals()).containsExactlyInAnyOrder(meal2, meal1);
//        assertThat(order.getMeals()).containsExactly(meal2, meal1);       //  sprawdzanie kolejności
    }

    @Test
    void testIfTwoListsAreTheSame(){
        // given
        Meal meal1 = new Meal(15, "Burger");
        Meal meal2 = new Meal(5, "Sandwich");
        Meal meal3 = new Meal(11, "Kebab");

        List meals1 = Arrays.asList(meal1, meal2);
        List meals2 = Arrays.asList(meal1, meal2);

        // then
        assertThat(meals1).isEqualTo(meals2);   // sprawdzenie czy są te same elementy w tej samej kolejnosci
    }


}
