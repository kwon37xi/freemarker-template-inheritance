package kr.pe.kwonnam.freemarker.inheritance;

import java.util.Stack;

import freemarker.template.TemplateModel;

/**
 * Stack of {@link Block} objects.
 * 
 * User: Matteo Silvestri(matteosilv@gmail.com}
 * Date: 17. 10. 26
 * Time: 오전 10:38
 */
public class BlockStack extends Stack<Block> implements TemplateModel {

    private static final long serialVersionUID = 1L;

}
