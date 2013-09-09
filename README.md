# Freemarker Template Inheritance

With these template inheritance directives you can manage template layouts..

You don't need to use layout frameworks like [Sitemesh](http://wiki.sitemesh.org/display/sitemesh/Home) or [Apache Tiles](http://tiles.apache.org/).

If you use JSP, refer to [jsp-template-inheritance](https://github.com/kwon37xi/jsp-template-inheritance).

## Spring Framework Settings

### Just copy the following five class files into your project.
1. [ExtendsDirective.java](https://github.com/kwon37xi/freemarker-template-inheritance/blob/master/ftl-inheritance/src/main/java/kr/pe/kwonnam/freemarker/inheritance/ExtendsDirective.java)
1. [BlockDirective.java](https://github.com/kwon37xi/freemarker-template-inheritance/blob/master/ftl-inheritance/src/main/java/kr/pe/kwonnam/freemarker/inheritance/BlockDirective.java)
1. [PutDirective.java](https://github.com/kwon37xi/freemarker-template-inheritance/blob/master/ftl-inheritance/src/main/java/kr/pe/kwonnam/freemarker/inheritance/PutDirective.java)
1. [BlockDirectiveUtils.java](https://github.com/kwon37xi/freemarker-template-inheritance/blob/master/ftl-inheritance/src/main/java/kr/pe/kwonnam/freemarker/inheritance/BlockDirectiveUtils.java)
1. [PutType.java](https://github.com/kwon37xi/freemarker-template-inheritance/blob/master/ftl-inheritance/src/main/java/kr/pe/kwonnam/freemarker/inheritance/PutType.java)

### add freemarkerLayoutDirectives to freemarkerConfig
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
`example` module is web application layout example. Run the module and browse `http://localhost:8080/index`.
Look at `index.ftl` and `/layout/base.ftl`

## Known Problems
1. In `<@layout.extends name="">..`, `name` should be absolute path.
1. The content which wraps `<@layout.extends ..>` is shown. So you must not put any content before/after `<@layout.extends ..>`.

## References
1. [Jade](http://jade-lang.com/) template inheritance.
1. [Fwd: template inheritance for freemarker](http://freemarker.624813.n4.nabble.com/Fwd-template-inheritance-for-freemarker-td2296583.html)