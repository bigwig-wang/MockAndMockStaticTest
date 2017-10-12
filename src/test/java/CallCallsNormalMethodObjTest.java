import com.thoughtworks.service.ClassCallsNormalMethodObj;
import com.thoughtworks.service.Nomarl;
import org.junit.Test;
import org.mockito.Mockito;

import static org.junit.Assert.assertEquals;

/**
 * Created by dhwang on 12/10/2017.
 */
public class CallCallsNormalMethodObjTest {

    @Test
    public void mock_Normal_method() throws Exception {

        //if

        Nomarl normal = Mockito.mock(Nomarl.class);
        ClassCallsNormalMethodObj classCallsNormalMethodObj = new ClassCallsNormalMethodObj(normal);

        Mockito.when(normal.firstNormalMethod()).thenReturn("3");
        Mockito.when(normal.secondNOrmalMethod()).thenReturn("4");


        String result = classCallsNormalMethodObj.excute();

        assertEquals("34",result);

        Mockito.verify(normal).firstNormalMethod();
        Mockito.verify(normal).secondNOrmalMethod();

    }


    @Test
    public void mock_normal_method_second() throws Exception {
        Nomarl normal = Mockito.spy(Nomarl.class);
        ClassCallsNormalMethodObj classCallsNormalMethodObj = new ClassCallsNormalMethodObj(normal);

        Mockito.when(normal.firstNormalMethod()).thenReturn("3");
        Mockito.when(normal.secondNOrmalMethod()).thenReturn("4");


        String result = classCallsNormalMethodObj.excute();

        assertEquals("34",result);

        Mockito.verify(normal).firstNormalMethod();
        Mockito.verify(normal).secondNOrmalMethod();
    }

}
