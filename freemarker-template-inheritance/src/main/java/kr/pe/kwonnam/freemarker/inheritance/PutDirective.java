package kr.pe.kwonnam.freemarker.inheritance;

import static kr.pe.kwonnam.freemarker.inheritance.BlockDirectiveUtils.getBlockName;
import static kr.pe.kwonnam.freemarker.inheritance.BlockDirectiveUtils.getBlockVarName;
import static kr.pe.kwonnam.freemarker.inheritance.BlockDirectiveUtils.getBodyResult;

import java.io.IOException;
import java.util.Map;

import freemarker.core.Environment;
import freemarker.template.SimpleScalar;
import freemarker.template.TemplateDirectiveBody;
import freemarker.template.TemplateDirectiveModel;
import freemarker.template.TemplateException;
import freemarker.template.TemplateModel;

/**
 * User: KwonNam Son(kwon37xi@gmail.com}
 * Date: 13. 6. 30
 * Time: 오후 10:14
 */
public class PutDirective implements TemplateDirectiveModel {
    public static final String PUT_DATA_PREFIX = PutDirective.class.getCanonicalName() + ".";
    public static final String PUT_BLOCK_NAME_PARAMETER = "block";
    public static final String PUT_TYPE_PARAMETER = "type";

    @Override
    public void execute(Environment env, Map params, TemplateModel[] loopVars, TemplateDirectiveBody body) throws TemplateException, IOException {
        String blockName = getBlockName(env, params, PUT_BLOCK_NAME_PARAMETER);
        PutType putType = getPutType(params);
        String bodyResult = getBodyResult(body);

        Block block = new Block(blockName, putType, bodyResult);

        String blockVarName = getBlockVarName(blockName);
        BlockStack blockStack = (BlockStack) env.getVariable(blockVarName);
        if (blockStack == null) {
            blockStack = new BlockStack();
            env.setVariable(blockVarName, blockStack);
        }
        blockStack.push(block);
    }

    private PutType getPutType(Map params) {
        SimpleScalar putTypeScalar = (SimpleScalar) params.get(PUT_TYPE_PARAMETER);
        PutType putType = null;
        if (putTypeScalar != null) {
            putType = PutType.valueOf(putTypeScalar.getAsString().toUpperCase());
        }

        if (putType == null) {
            putType = PutType.APPEND;
        }
        return putType;
    }
}