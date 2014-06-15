package kr.pe.kwonnam.freemarker.inheritance;

import freemarker.core.Environment;
import freemarker.template.SimpleScalar;
import freemarker.template.TemplateDirectiveBody;
import freemarker.template.TemplateException;

import java.io.IOException;
import java.io.StringWriter;
import java.util.Map;

/**
 * User: KwonNam Son(kwon37xi@gmail.com}
 * Date: 13. 7. 1
 * Time: 오전 12:12
 */
public class BlockDirectiveUtils {
    public static String getBodyResult(TemplateDirectiveBody body) throws IOException, TemplateException {
        if (body == null) {
            return "";
        }

        StringWriter writer = new StringWriter();
        body.render(writer);
        return writer.toString();
    }

    public static String getBlockContentsVarName(String blockName) {
        return PutDirective.PUT_DATA_PREFIX + blockName + ".contents";
    }

    public static String getBlockTypeVarName(String blockName) {
        return PutDirective.PUT_DATA_PREFIX + blockName + ".type";
    }

    public static String getBlockName(Environment env, Map params, String paramName) throws TemplateException {

        SimpleScalar blockNameScalar = (SimpleScalar) params.get(paramName);
        if (blockNameScalar == null) {
            throw new TemplateException("This directive must have '" + paramName + "' attribute.", env);
        }
        return blockNameScalar.getAsString();
    }
}
