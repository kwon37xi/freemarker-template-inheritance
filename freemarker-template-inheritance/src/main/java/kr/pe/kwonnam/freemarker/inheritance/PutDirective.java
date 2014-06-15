package kr.pe.kwonnam.freemarker.inheritance;

import freemarker.core.Environment;
import freemarker.template.*;

import java.io.IOException;
import java.util.Map;

import static kr.pe.kwonnam.freemarker.inheritance.BlockDirectiveUtils.*;

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

        env.setVariable(getBlockContentsVarName(blockName), new SimpleScalar(bodyResult));
        env.setVariable(getBlockTypeVarName(blockName), new SimpleScalar(putType.name()));
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