package kr.pe.kwonnam.freemarker.inheritance;

import freemarker.core.Environment;
import freemarker.template.*;

import java.io.IOException;
import java.io.StringWriter;
import java.util.Map;

/**
 * User: KwonNam Son(kwon37xi@gmail.com}
 * Date: 13. 6. 30
 * Time: 오후 10:14
 */
public class PutDirective implements TemplateDirectiveModel {
    public static final String PUT_DATA_PREFIX = PutDirective.class.getCanonicalName() + ".";
    public static final String BLOCK_NAME_PARAMETER = "block";
    public static final String PUT_TYPE_PARAMETER = "type";

    @Override
    public void execute(Environment env, Map params, TemplateModel[] loopVars, TemplateDirectiveBody body) throws TemplateException, IOException {
        String blockName = getBlockName(env, params);
        PutType putType = getPutType(env, params);
        String bodyResult = getBodyResult(body);

        env.setVariable(PUT_DATA_PREFIX + blockName + ".contents", new SimpleScalar(bodyResult));
        env.setVariable(PUT_DATA_PREFIX + blockName + ".type", new SimpleScalar(putType.name()));
    }

    private String getBlockName(Environment env, Map params) throws TemplateException {
        SimpleScalar blockNameScalar = (SimpleScalar) params.get(BLOCK_NAME_PARAMETER);
        if (blockNameScalar == null) {
            throw new TemplateException("Put directive must have 'block' attribute", env);
        }
        String blockName = blockNameScalar.getAsString();
        return blockName;
    }

    private PutType getPutType(Environment env, Map params) {
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

    private String getBodyResult(TemplateDirectiveBody body) throws IOException, TemplateException {
        if (body == null) {
            return "";
        }

        StringWriter writer = new StringWriter();
        body.render(writer);
        return writer.toString();
    }
}