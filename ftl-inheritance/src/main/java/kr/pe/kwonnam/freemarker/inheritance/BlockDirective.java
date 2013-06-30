package kr.pe.kwonnam.freemarker.inheritance;

import freemarker.core.Environment;
import freemarker.template.*;

import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;
import java.util.Map;

/**
 * User: KwonNam Son(kwon37xi@gmail.com}
 * Date: 13. 6. 30
 * Time: 오후 10:16
 */
public class BlockDirective implements TemplateDirectiveModel {
    @Override
    public void execute(Environment env, Map params, TemplateModel[] loopVars, TemplateDirectiveBody body) throws TemplateException, IOException {
        String blockName = getBlockName(env, params);
        PutType putType = getPutType(env, blockName);
        String bodyResult = getBodyResult(env, body);

        Writer out = env.getOut();

        String putContents = getPutContents(env, blockName);

        putType.write(out, bodyResult, putContents);
    }

    private String getBlockName(Environment env, Map params) throws TemplateException {
        SimpleScalar blockNameScalar = (SimpleScalar)params.get("name");
        if (blockNameScalar == null) {
            throw new TemplateException("Block directive must have 'name' attribute.", env);
        }
        String blockName = blockNameScalar.getAsString();
        return blockName;
    }

    private PutType getPutType(Environment env, String blockName) throws TemplateException {
        SimpleScalar putTypeScalar = (SimpleScalar) env.getVariable(PutDirective.PUT_DATA_PREFIX + blockName + ".type");
        if (putTypeScalar == null) {
            return PutType.APPEND;
        }

        return PutType.valueOf(putTypeScalar.getAsString());
    }

    private String getBodyResult(Environment env, TemplateDirectiveBody body) throws IOException, TemplateException {
        if (body == null) {
            return "";
        }

        StringWriter writer = new StringWriter();
        body.render(writer);

        return writer.toString();
    }

    private String getPutContents(Environment env, String blockName) throws TemplateModelException {
        SimpleScalar putContentsModel = (SimpleScalar) env.getVariable(PutDirective.PUT_DATA_PREFIX + blockName + ".contents");
        String putContents = "";
        if (putContentsModel != null) {
            putContents = putContentsModel.getAsString();
        }
        return putContents;
    }
}
