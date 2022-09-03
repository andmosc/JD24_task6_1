import org.junit.jupiter.api.*;

import java.util.Arrays;
import java.util.List;

public class MainTest {

    private Person person1,person2,person3,person4;
    private Person person5,person6,person7,person8;

    @BeforeEach
    public void setUp() {
        person1 = new Person("Maria1","Ivanova1",17,Sex.WOMAN,Education.HIGHER);
        person2 = new Person("Maria2","Ivanova2",18,Sex.WOMAN,Education.HIGHER);
        person3 = new Person("Maria3","Ivanova3",26,Sex.WOMAN,Education.ELEMENTARY);
        person4 = new Person("Maria4","Ivanova4",61,Sex.WOMAN,Education.HIGHER);

        person5 = new Person("Oleg1","Ivanov1",17,Sex.MAN,Education.HIGHER);
        person6 = new Person("Oleg2","Ivanov2",18,Sex.MAN,Education.HIGHER);
        person7 = new Person("Oleg3","Ivanov3",20,Sex.MAN,Education.ELEMENTARY);
        person8 = new Person("Oleg4","Ivanov4",66,Sex.MAN,Education.HIGHER);
    }

    @Test
    @DisplayName("Несовершеннолетние")
    public void testNumberMinors() {
        List<Person> listPerson = Arrays.asList(person1,person2,person3);
        Long expected = Main.numberMinors(listPerson);
        int actual = 2;
        Assertions.assertEquals(expected,actual);
    }

    @Test
    @DisplayName("Средний возраст")
    public void testNumberAverageAge() {
        List<Person> listPerson = Arrays.asList(person1,person2,person3);
        int expected = Main.numberAverageAge(listPerson);
        int actual = 20;
        Assertions.assertEquals(expected,actual);
    }

    @Nested
    @DisplayName("Фильтрация")
    class Filter {

        @Test
        @DisplayName("18-27 фамилии")
        public void testListConscriptSurname() {
            List<Person> listPerson = Arrays.asList(person1,person2,person3,person7);

            List<String> expected = Main.listConscriptSurname(listPerson);
            List<String> actual = Arrays.asList("Ivanova2","Ivanova3","Ivanov3");

            Assertions.assertEquals(expected,actual);
        }

        @Test
        @DisplayName("Работающие мужчины/женщины")
        public void testListWorkable() {
            List<Person> listPerson = Arrays.asList(person1,person2,
                    person3,person4,person5,person6,person7,person8);

            List<Person> expected = Main.listWorkable(listPerson);
            List<Person> actual = Arrays.asList(person2,person6);

            Assertions.assertEquals(expected,actual);
        }
    }
}
