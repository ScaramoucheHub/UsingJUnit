import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class ListOfWorksTests {

    public static ListOfWorks globalWorks = new ListOfWorks();

    // добавляем один элемент
    @Test
    public void addWorkTest() {
        ListOfWorks works = new ListOfWorks();
        works.addWork("Купить продукты");
        Assertions.assertEquals(1, works.size());
    }

    // добавляем несколько элементов
    @ParameterizedTest
    @MethodSource("addWorkArgsProvider")
    public void addWorkParamTest(Pair<String, Integer> pair) {
        globalWorks.addWork(pair.first);
        int expected = pair.second;
        int actual = globalWorks.size();
        Assertions.assertEquals(expected, actual);
    }

    public static Stream<Pair<String, Integer>> addWorkArgsProvider() {
        return Stream.of(new Pair<String, Integer>("Купить продукты", 1),
                new Pair<String, Integer>("Приготовить ужин", 2),
                new Pair<String, Integer>("Помыть посуду", 3),
                new Pair<String, Integer>("Постирать одежду", 4),
                new Pair<String, Integer>("Пропылесосить", 5));
    }

    // удаляем элемент по индексу
    @Test
    public void removeWorkByIndexTest() {
        ListOfWorks works = new ListOfWorks();
        works.addWork("Купить продукты");
        works.addWork("Приготовить ужин");
        works.addWork("Помыть посуду");

        boolean result = works.removeWork(1);
        String expected = "ListOfWorks [Купить продукты, Помыть посуду]";
        String actual = works.toString();

        Assertions.assertTrue(result);
        Assertions.assertEquals(expected, actual);
    }

    // удаляем элемент по некорректному индексу
    @Test
    public void removeWorkByIndexInvalidTest() {
        ListOfWorks works = new ListOfWorks();
        works.addWork("Купить продукты");
        works.addWork("Приготовить ужин");
        works.addWork("Помыть посуду");

        boolean result = works.removeWork(3);
        String expected = "ListOfWorks [Купить продукты, Приготовить ужин, Помыть посуду]";
        String actual = works.toString();

        Assertions.assertFalse(result);
        Assertions.assertEquals(expected, actual);
    }

    // удаляем элемент по значению
    @Test
    public void removeWorkByValueTest() {
        ListOfWorks works = new ListOfWorks();
        works.addWork("Купить продукты");
        works.addWork("Приготовить ужин");
        works.addWork("Помыть посуду");

        boolean result = works.removeWork("Приготовить ужин");
        String expected = "ListOfWorks [Купить продукты, Помыть посуду]";
        String actual = works.toString();

        Assertions.assertTrue(result);
        Assertions.assertEquals(expected, actual);
    }

    // удаляем элемент по некорректному значению
    @Test
    public void removeWorkByValueInvalidTest() {
        ListOfWorks works = new ListOfWorks();
        works.addWork("Купить продукты");
        works.addWork("Приготовить ужин");
        works.addWork("Помыть посуду");

        boolean result = works.removeWork("Пропылесосить");
        String expected = "ListOfWorks [Купить продукты, Приготовить ужин, Помыть посуду]";
        String actual = works.toString();

        Assertions.assertFalse(result);
        Assertions.assertEquals(expected, actual);
    }

    // удаляем элементы по ключевому слову
    @Test
    public void removeWorkByKeywordTest() {
        ListOfWorks works = new ListOfWorks();
        works.addWork("Купить продукты");
        works.addWork("Приготовить ужин");
        works.addWork("Помыть посуду");

        boolean result = works.removeWorksByKeyword("продукты");
        String expected = "ListOfWorks [Приготовить ужин, Помыть посуду]";
        String actual = works.toString();

        Assertions.assertTrue(result);
        Assertions.assertEquals(expected, actual);
    }

    // удаляем элементы по некорректному ключевому слову
    @Test
    public void removeWorkByKeywordInvalidTest() {
        ListOfWorks works = new ListOfWorks();
        works.addWork("Купить продукты");
        works.addWork("Приготовить ужин");
        works.addWork("Помыть посуду");

        boolean result = works.removeWorksByKeyword("Пропылесосить");
        String expected = "ListOfWorks [Купить продукты, Приготовить ужин, Помыть посуду]";
        String actual = works.toString();

        Assertions.assertFalse(result);
        Assertions.assertEquals(expected, actual);
    }

    static class Pair<T, U> {
        private final T first;
        private final U second;

        public Pair(T first, U second) {
            this.first = first;
            this.second = second;
        }

        public T getFirst() {
            return first;
        }

        public U getSecond() {
            return second;
        }

        @Override
        public String toString() {
            return first + " " + second;
        }
    }
}
