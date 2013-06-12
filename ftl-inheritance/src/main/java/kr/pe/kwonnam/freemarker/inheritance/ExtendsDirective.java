package kr.pe.kwonnam.freemarker.inheritance;

import freemarker.core.Environment;
import freemarker.template.*;

import java.io.IOException;
import java.util.Map;

/**
 * User: KwonNam Son(kwon37xi@gmail.com}
 * Date: 13. 6. 12
 * Time: 오후 10:58
 */
public class ExtendsDirective implements TemplateDirectiveModel {

    @Override
    public void execute(Environment env, Map params, TemplateModel[] loopVars, TemplateDirectiveBody body) throws TemplateException, IOException {
        String name =  ((SimpleScalar)params.get("name")).getAsString();

        Template parentTemplate = env.getTemplateForInclusion(name, null, true);

        parentTemplate.process(env.getDataModel(), env.getOut());

    }
}
