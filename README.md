# Freemarker Template Inheritance
[![Maven Central](https://maven-badges.herokuapp.com/maven-central/kr.pe.kwonnam.freemarker/freemarker-template-inheritance/badge.svg)](https://maven-badges.herokuapp.com/maven-central/kr.pe.kwonnam.freemarker/freemarker-template-inheritance)

With these template inheritance directives you can manage template layouts..

You don't need to use layout frameworks like [Sitemesh](http://wiki.sitemesh.org/display/sitemesh/Home) or [Apache Tiles](http://tiles.apache.org/).

If you use JSP, refer to [jsp-template-inheritance](https://github.com/kwon37xi/jsp-template-inheritance).

From 0.4.RELEASE, you can downlod this library from the maven central repository.

### Gradle dependencies
```groovy
dependencies {
    compile 'kr.pe.kwonnam.freemarker:freemarker-template-inheritance:0.4.RELEASE'
}
```

### Maven dependencies

```xml
<dependency>
    <groupId>kr.pe.kwonnam.freemarker</groupId>
    <artifactId>freemarker-template-inheritance</artifactId>
    <version>0.4.RELEASE</version>
    <scope>compile</scope>
</dependency>
```

## Spring Framework Settings

### Java Config - refer to ```FreemarkerTemplateinheritanceConfig.java```
```java
@Bean
public Map<String, TemplateModel> freemarkerLayoutDirectives() {
    Map<String, TemplateModel> freemarkerLayoutDirectives = new HashMap<String, TemplateModel>();
    freemarkerLayoutDirectives.put("extends", new ExtendsDirective());
    freemarkerLayoutDirectives.put("block", new BlockDirective());
    freemarkerLayoutDirectives.put("put", new PutDirective());

    return freemarkerLayoutDirectives;
}

@Bean
public FreeMarkerConfigurer freemarkerConfig() {
    FreeMarkerConfigurer freemarkerConfig = new FreeMarkerConfigurer();
    freemarkerConfig.setTemplateLoaderPath("/WEB-INF/ftls/");
    freemarkerConfig.setDefaultEncoding("UTF-8");

    Map<String, Object> freemarkerVariables = new HashMap<String, Object>();
    freemarkerVariables.put("layout", freemarkerLayoutDirectives());

    freemarkerConfig.setFreemarkerVariables(freemarkerVariables);
    return freemarkerConfig;
}

@Bean
public ViewResolver viewResolver() {
    FreeMarkerViewResolver viewResolver = new FreeMarkerViewResolver();
    viewResolver.setCache(false);
    viewResolver.setPrefix("");
    viewResolver.setSuffix(".ftl");
    viewResolver.setContentType("text/html; charset=utf-8");
    return viewResolver;
}
```

### XML Config - refer to ```spring-servlet.xml```
```xml
<import resource="classpath:/kr/pe/kwonnam/freemarker/inheritance/freemarker-layout-directives.xml" />

<bean id="freemarkerConfig" class="org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer">
    <property name="templateLoaderPath" value="/WEB-INF/ftls/"/>
    <property name="defaultEncoding" value="utf-8" />
    <property name="freemarkerVariables">
        <map>
            <entry key="layout" value-ref="freemarkerLayoutDirectives" />
        </map>
    </property>
</bean>
```

## Usage
### base.ftl : layout
```html
<!DOCTYPE html>
<html>
    <head>
        <title>Base Layout</title>
        <@layout.block name="head">
            <script type="text/javascript" src="http://code.jquery.com/jquery-1.10.1.min.js"></script>
        </@layout.block>
    </head>
    <body>
        <@layout.block name="header">
            <h1>Base Layout</h1>
        </@layout.block>
        <div class="base">
            <@layout.block name="contents">
                <h2>Contents will be here</h2>
            </@layout.block>
        </div>
        <@layout.block name="footer">
            <div>Footer base</div>
        </@layout.block>
    </body>
</html>
```

### view.ftl : contents
```html
<@layout.extends name="layouts/base.ftl">
    <@layout.put block="head">
        <script src="//ajax.googleapis.com/ajax/libs/mootools/1.4.5/mootools-yui-compressed.js"></script>
    </@layout.put>
    <@layout.put block="header" type="prepend">
        <h2>Index Page</h2>
    </@layout.put>
    <@layout.put block="contents">
        <p>blah.. blah..</p>
    </@layout.put>
    <@layout.put block="footer" type="replace">
        <hr/>
        <div class="footer">Footer replaced by index</div>
    </@layout.put>
</@layout.extends>
```

### PutType
1. APPEND : The put contents will be appended after block's contents. default.
1. PREPEND : The put contents will be prepended before block's contents.
1. REPLACE : The put contents will replace block's contents. The block's contents will be removed.

### Example
`example` module is a web application layout example. Run the module and browse <http://localhost:8080/index>.
Refer to `index.ftl` and `/layout/base.ftl`

## Known Problems
1. In `<@layout.extends name="">..`, `name` should be absolute path.
1. The content which wraps `<@layout.extends ..>` is shown. So you must not put any content before/after `<@layout.extends ..>`.

## References
1. [Jade](http://jade-lang.com/) template inheritance.
1. [Fwd: template inheritance for freemarker](http://freemarker.624813.n4.nabble.com/Fwd-template-inheritance-for-freemarker-td2296583.html)
