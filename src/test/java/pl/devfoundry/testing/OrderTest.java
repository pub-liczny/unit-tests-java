package pl.devfoundry.testing;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;

// Testowanie kolekcji
public class OrderTest {

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
        // Given
        Order order = new Order();

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
        Order order = new Order();

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
        Order order = new Order();

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
        Order order = new Order();

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
