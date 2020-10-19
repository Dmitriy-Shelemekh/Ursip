import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

class UrsipTest {
    @Test
    public void test() {
        Assert.assertEquals("003", Ursip.generateNum(new ArrayList<>(Arrays.asList(1, 2, 4, 5, 6))));
        Assert.assertEquals("013", Ursip.generateNum(new ArrayList<>(Arrays.asList(11, 12, 14, 15, 16))));
        Assert.assertEquals("112", Ursip.generateNum(new ArrayList<>(Arrays.asList(111, 121, 141, 151, 161))));

        Assert.assertEquals("006", Ursip.generateNum(new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5))));
        Assert.assertEquals("016", Ursip.generateNum(new ArrayList<>(Arrays.asList(11, 12, 13, 14, 15))));
        Assert.assertEquals("116", Ursip.generateNum(new ArrayList<>(Arrays.asList(111, 112, 113, 114, 115))));
    }
}