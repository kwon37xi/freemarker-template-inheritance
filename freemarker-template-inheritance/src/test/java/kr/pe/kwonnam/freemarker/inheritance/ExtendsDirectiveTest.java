package kr.pe.kwonnam.freemarker.inheritance;

import org.junit.Test;
import org.junit.Assert.*;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * User: KwonNam Son(kwon37xi@gmail.com}
 * Date: 13. 6. 22
 * Time: 오후 4:45
 */
public class ExtendsDirectiveTest extends AbstractDirectiveTest {

    @Test
    public void extends_simple_with_no_body() {
        String result = processTemplate("extends_no_body.ftl");

        assertThat("가장 간단한 상속. 빈 바디", result, is("{[SimpleBase-]}"));
        System.out.println(result);
    }

    @Test
    public void extends_simple_with_assign_body() {
        String result = processTemplate("extends_body.ftl");

        assertThat("간단한 상속. 바디에서 값 설정", result, is("{[SimpleBase-AssignedValue]}"));
        System.out.println(result);
    }
}