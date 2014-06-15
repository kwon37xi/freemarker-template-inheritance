package kr.pe.kwonnam.freemarker.inheritance;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * User: KwonNam Son(kwon37xi@gmail.com}
 * Date: 13. 6. 30
 * Time: 오후 11:43
 */
public class ExtendsManyTimesTest extends AbstractDirectiveTest {

    @Test
    public void extends_many_times() {
        String result = processTemplate("extends_many_times.ftl");

        assertThat("다차 상속", result, is("{[FirstBlock-FirstBlockChild1-FirstAppendBlockChild2]" +
                "[SecondBlock-SecondBlockChildReplace]" +
                "[ThirdBlock-ThirdBlockChildPrepend2-ThirdBlockChild1]" +
                "[FourthBlock-FourthBlockChildAppend2]" +
                "[FifthBlock-FifthBlockChild1]}"));
    }
}
