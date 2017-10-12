import com.thoughtworks.service.ClassCallsStaticMethodObj;
import com.thoughtworks.service.Static;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockSettings;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import static org.junit.Assert.assertEquals;

/**
 * Created by dhwang on 11/10/2017.
 */

@RunWith(PowerMockRunner.class)
@PrepareForTest(Static.class)
public class ClassCallsStaticMethodObjTest {
    private ClassCallsStaticMethodObj classCallsStaticMethodObj;

    @Test
    public void test_method_that_call_static_method() {
        classCallsStaticMethodObj = new ClassCallsStaticMethodObj();

        //classCallsStaticMethodObj = Mockito.mock(ClassCallsStaticMethodObj.class);
        //mock static class
        PowerMockito.mockStatic(Static.class);

        //mock static method
        String value  = "3";

        //if we mock one class ,then the any method in this class we will not excute.
        Mockito.when(Static.firstStaticMethod(3)).thenReturn(value);
        Mockito.when(Static.secondeMethod()).thenReturn("4");


        String result = classCallsStaticMethodObj.excute(3);

        //verify call times ,before we call static method like Static.firstStaticMethod(3) we should verifyStatic(Static) that indicate
        //we call the firstStaticMethod for one time
        PowerMockito.verifyStatic(Static.class,Mockito.times(1));

        //this two line explains the firstStaticMethod was call By one time
        assertEquals("34",result);
        System.out.println(Static.firstStaticMethod(3));


        // IMPORTANT: You need to call verifyStatic(Class) per method verification,
        // so call verifyStatic(Class) again
        PowerMockito.verifyStatic(Static.class,Mockito.times(1));
        Static.secondeMethod();


    }

    //like this,if we mock the Static class,and we use Static.firstStaticMethod ,that we will not call the method actually.
    @Test
    public void test_first_static_method_single() throws Exception {
        PowerMockito.mockStatic(Static.class);

        //this always return null result ,because we have not this class


        PowerMockito.verifyStatic(Static.class,Mockito.times(0));
        String s = Static.firstStaticMethod(3);
        System.out.println("mock class and get the result of a static method in the class   " + s);
    }

    @Test
    public void test_second_static_method_single() throws Exception {

        PowerMockito.mockStatic(Static.class);

        PowerMockito.verifyStatic(Static.class,Mockito.times(0));
        //like this write,not represent we will call the secondMehod,just represent the secondeMethod
        Static.secondeMethod();

    }
}
