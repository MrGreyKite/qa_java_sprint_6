import com.example.Feline;
import com.example.Lion;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;


@RunWith(MockitoJUnitRunner.class)
public class LionTest {

    @Mock
    Feline feline;

    private Lion lion;

    @Before
    public void setUp() throws Exception {
        lion = new Lion("Самка", feline);
    }

    @Test
    public void testGetKittens() {
            when(feline.getKittens()).thenReturn(1);

            int actualKittens = lion.getKittens();
            System.out.println(actualKittens);
            int expectedKittens = 1;

            assertEquals(expectedKittens, actualKittens);
    }

    @Test
    public void testGetFood() throws Exception {
            when(feline.getFood("Хищник")).thenReturn(Arrays.asList("Животные", "Птицы", "Рыба"));
            assertEquals(Arrays.asList("Животные", "Птицы", "Рыба"), lion.getFood());
    }
}

