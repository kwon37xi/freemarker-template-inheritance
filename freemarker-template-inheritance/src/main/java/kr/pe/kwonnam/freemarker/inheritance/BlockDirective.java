package kr.pe.kwonnam.freemarker.inheritance;

import freemarker.core.Environment;
import freemarker.template.*;

import java.io.IOException;
import java.io.Writer;
import java.util.Map;

import static kr.pe.kwonnam.freemarker.inheritance.BlockDirectiveUtils.*;

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
        PutType putType = getPutType(env, blockName);
        String bodyResult = getBodyResult(body);

        Writer out = env.getOut();

        String putContents = getPutContents(env, blockName);

        putType.write(out, bodyResult, putContents);
    }

    private PutType getPutType(Environment env, String blockName) throws TemplateException {
        SimpleScalar putTypeScalar = (SimpleScalar) env.getVariable(getBlockTypeVarName(blockName));
        if (putTypeScalar == null) {
            return PutType.APPEND;
        }

        return PutType.valueOf(putTypeScalar.getAsString());
    }

    private String getPutContents(Environment env, String blockName) throws TemplateModelException {
        SimpleScalar putContentsModel = (SimpleScalar) env.getVariable(getBlockContentsVarName(blockName));
        String putContents = "";
        if (putContentsModel != null) {
            putContents = putContentsModel.getAsString();
        }
        return putContents;
    }
}
