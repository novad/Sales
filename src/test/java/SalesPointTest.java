import org.junit.Assert;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class SalesPointTest {

    @Test
    public void printTest() throws Exception{
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        SalesPoint.print(new PrintStream(out));
        String string = out.toString();
        Assert.assertEquals("test", string);

    }
}