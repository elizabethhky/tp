package seedu.address.model.pet.predicates;

import org.junit.jupiter.api.Test;
import seedu.address.testutil.TypicalPets;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class PriceContainsKeywordsPredicateTest {
    @Test
    public void equals() {
        List<Double> firstPredicateKeywordList = Collections.singletonList(5.6);
        List<Double> secondPredicateKeywordList = Arrays.asList(6.6, 5.5);

        PriceContainsKeywordsPredicate firstPredicate = new PriceContainsKeywordsPredicate(
                firstPredicateKeywordList);
        PriceContainsKeywordsPredicate secondPredicate = new PriceContainsKeywordsPredicate(
                secondPredicateKeywordList);

        assertTrue(firstPredicate.equals(firstPredicate));

        // same values -> returns true
        PriceContainsKeywordsPredicate firstPredicateCopy = new PriceContainsKeywordsPredicate(
                firstPredicateKeywordList);
        assertTrue(firstPredicate.equals(firstPredicateCopy));

        // different types -> returns false
        assertFalse(firstPredicate.equals(1));

        // null -> returns false
        assertFalse(firstPredicate.equals(null));

        // different person -> returns false
        assertFalse(firstPredicate.equals(secondPredicate));
    }

    @Test
    public void test_priceContainsKeywords_returnsTrue() {
        // One keyword
        PriceContainsKeywordsPredicate predicate = new PriceContainsKeywordsPredicate(
                Collections.singletonList(66.66));
        assertTrue(predicate.test(TypicalPets.PLUM));

        // Multiple keywords
        predicate = new PriceContainsKeywordsPredicate(Arrays.asList(110.1, 66.66));
        assertTrue(predicate.test(TypicalPets.PLUM));
    }

    @Test
    public void test_priceDoesNotContainKeywords_returnsFalse() {
        // One keyword
        PriceContainsKeywordsPredicate predicate = new PriceContainsKeywordsPredicate(
                Collections.singletonList(110.1));
        assertFalse(predicate.test(TypicalPets.PLUM));

        // Multiple keywords
        predicate = new PriceContainsKeywordsPredicate(Arrays.asList(110.1, 56.56));
        assertFalse(predicate.test(TypicalPets.PLUM));
    }
}
