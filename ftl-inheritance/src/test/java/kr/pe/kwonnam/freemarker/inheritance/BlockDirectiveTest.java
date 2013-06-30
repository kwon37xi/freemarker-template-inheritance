package kr.pe.kwonnam.freemarker.inheritance;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * User: KwonNam Son(kwon37xi@gmail.com}
 * Date: 13. 6. 30
 * Time: 오후 10:19
 */
public class BlockDirectiveTest extends AbstractDirectiveTest {

    @Test
    public void block_append() {
        String result = processTemplate("block_append.ftl");

        assertThat("Append 방식 Block", result, is("{[BlockContents - PutContents]}"));
        System.out.println("block_append : " + result);
    }

    @Test
    public void block_prepend() {
        String result = processTemplate("block_prepend.ftl");
        assertThat("Prepend 방식 Block", result, is("{[PutContents - BlockContents]}"));
        System.out.println("block_prepend : " + result);
    }

    @Test
    public void block_replace() {
        String result = processTemplate("block_replace.ftl");
        assertThat("Replace 방식 Block", result, is("{[PutContents]}"));
        System.out.println("block_replace : " + result);
    }
}
