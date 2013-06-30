package kr.pe.kwonnam.freemarker.inheritance;

import org.junit.Test;

/**
 * User: KwonNam Son(kwon37xi@gmail.com}
 * Date: 13. 6. 22
 * Time: 오후 4:45
 */
public class ExtendsDirectiveTest extends AbstractDirectiveTest {

    @Test
    public void extendsBasic() {
        String result = processTemplate("extends.ftl");

        System.out.println(result);
    }
}