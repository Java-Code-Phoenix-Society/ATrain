import dev.jcps.ATrain;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class ATrainTests {
    @Test
    public void deckTest() {
        ATrain at = new ATrain();
        at.init();
        assertNotNull(at.image);
    }
}
