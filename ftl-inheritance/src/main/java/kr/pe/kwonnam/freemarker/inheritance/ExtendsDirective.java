package kr.pe.kwonnam.freemarker.inheritance;

import freemarker.core.Environment;
import freemarker.template.*;

import java.io.IOException;
import java.io.StringWriter;
import java.util.Map;

/**
 * User: KwonNam Son(kwon37xi@gmail.com}
 * Date: 13. 6. 12
 * Time: 오후 10:58
 */
public class ExtendsDirective implements TemplateDirectiveModel {

    @Override
    public void execute(Environment env, Map params, TemplateModel[] loopVars, TemplateDirectiveBody body) throws TemplateException, IOException {
        String layoutName =  ((SimpleScalar)params.get("name")).getAsString();

        processBody(body);
        processLayout(env, layoutName);
    }

    private void processBody(TemplateDirectiveBody body) throws TemplateException, IOException {
        if (body == null) {
            return;
        }

        StringWriter fakeOut = new StringWriter();
        body.render(fakeOut);
    }

    private void processLayout(Environment env, String layoutName) throws IOException, TemplateException {
        env.include(layoutName, null, true);
    }
}
