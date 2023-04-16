import com.example.Feline;
import com.example.Lion;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mock;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class LionParameterizedTest {

    @Mock
    Feline feline;

    @Parameterized.Parameters(name = "{index}: lion with sex {0} has state of mane {1}")
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {"Самец", true},
                {"Самка", false}
        });
    }

    @Parameterized.Parameter(0)
    public String sex;

    @Parameterized.Parameter(1)
    public boolean hasMane;


    @Test
    public void testDoesHaveMane() throws Exception {
        Lion lion = new Lion(sex, feline);
        assertEquals(hasMane, lion.doesHaveMane());
    }


    @Test(expected = Exception.class)
    public void testLionConstructorWithInvalidSex() throws Exception {
        new Lion("InvalidSex", feline);
    }

    @Test
    public void testLionConstructorExceptionText() {
        try {
            new Lion("Неизвестный пол", feline);
        } catch (Exception e) {
            assertEquals("Используйте допустимые значения пола животного - самец или самка", e.getMessage());
        }
    }


}
