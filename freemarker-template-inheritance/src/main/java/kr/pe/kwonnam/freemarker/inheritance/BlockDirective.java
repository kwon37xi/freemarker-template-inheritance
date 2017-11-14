package kr.pe.kwonnam.freemarker.inheritance;

import static kr.pe.kwonnam.freemarker.inheritance.BlockDirectiveUtils.*;

import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;
import java.util.Map;

import freemarker.core.Environment;
import freemarker.template.TemplateDirectiveBody;
import freemarker.template.TemplateDirectiveModel;
import freemarker.template.TemplateException;
import freemarker.template.TemplateModel;
import freemarker.template.TemplateModelException;

/**
 * User: KwonNam Son(kwon37xi@gmail.com}
 * Date: 13. 6. 30
 * Time: 오후 10:16
 */
public class BlockDirective implements TemplateDirectiveModel {

    public static final String BLOCK_NAME_PARAMETER = "name";

    @Override
    public void execute(Environment env, Map params, TemplateModel[] loopVars, TemplateDirectiveBody body) throws TemplateException, IOException {
        String blockName = getBlockName(env, params, BLOCK_NAME_PARAMETER);
        BlockStack blockStack = getBlockStack(env, blockName);
        
        String bodyResult = getBodyResult(body);

        while (!blockStack.isEmpty()) {
            StringWriter writer = new StringWriter();
            Block block = blockStack.pop();
            block.getType()
                    .write(writer, 
                           bodyResult,
                           block.getContent());
            bodyResult = writer.toString();
        }

        Writer out = env.getOut();
        out.write(bodyResult);
    }

    private BlockStack getBlockStack(Environment env, String blockName) throws TemplateModelException {
        BlockStack blockStack = (BlockStack) env.getVariable(getBlockVarName(blockName));
        if (blockStack == null) {
            blockStack = new BlockStack();
        }
        return blockStack;
    }

}
