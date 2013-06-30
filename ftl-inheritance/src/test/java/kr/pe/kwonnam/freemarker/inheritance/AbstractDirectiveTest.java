package kr.pe.kwonnam.freemarker.inheritance;

import freemarker.template.*;
import org.junit.Before;

import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;
import java.util.HashMap;
import java.util.Map;

/**
 * User: KwonNam Son(kwon37xi@gmail.com}
 * Date: 13. 6. 22
 * Time: 오후 4:57
 */
public class AbstractDirectiveTest {

    public static final String PATH_PREFIX = "/kr/pe/kwonnam/freemarker/inheritance";
    protected Map<String, Object> root;
    private Configuration configuration;

    @Before
    public void setUp() {
        configuration = new Configuration();
        configuration.setObjectWrapper(new DefaultObjectWrapper());
        configuration.setClassForTemplateLoading(AbstractDirectiveTest.class, PATH_PREFIX);
        configuration.setDefaultEncoding("UTF-8");
        configuration.setTemplateExceptionHandler(TemplateExceptionHandler.DEBUG_HANDLER);
        configuration.setNumberFormat("####");
        configuration.setIncompatibleEnhancements("2.3.20");

        populateDirectives();

        root = new HashMap<String, Object>();
    }

    private void populateDirectives() {
        Map<String, TemplateDirectiveModel> layoutDirectives = new HashMap<String, TemplateDirectiveModel>();

        layoutDirectives.put("extends", new ExtendsDirective());

        try {
            configuration.setSharedVariable("layout", layoutDirectives);
        } catch (TemplateModelException e) {
            throw new RuntimeException("Template configuration exception", e);
        }
    }

    protected Template getTemplate(String name) {
        try {
            return configuration.getTemplate(name);
        } catch (IOException e) {
            throw new RuntimeException("Template loading exception", e);
        }
    }

    protected String processTemplate(Template template) {
        Writer writer = new StringWriter();

        try {
            template.process(root, writer);
        } catch (Exception e) {
            throw new RuntimeException("Template processing exception", e);
        }

        return writer.toString();
    }

    protected String processTemplate(String templateName) {
        Template template = getTemplate(templateName);
        return processTemplate(template);
    }
}