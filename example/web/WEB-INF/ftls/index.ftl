<@layout.extends name="layouts/base.ftl">
    <@layout.put block="head">
        <script src="//ajax.googleapis.com/ajax/libs/mootools/1.4.5/mootools-yui-compressed.js"></script>
    </@layout.put>
    <@layout.put block="header" type="prepend">
        <h2>Index Page</h2>
    </@layout.put>
    <@layout.put block="contents">
        <p>Lorem ipsum dolor sit amet, consectetuer adipiscing elit, sed diam nonummy nibh euismod tincidunt ut laoreet
            dolore magna aliquam erat volutpat. Ut wisi enim ad minim veniam, quis nostrud exerci tation ullamcorper
            suscipit lobortis nisl ut aliquip ex ea commodo consequat. Duis autem vel eum iriure dolor in hendrerit in
            vulputate velit esse molestie consequat, vel illum dolore eu feugiat nulla facilisis at vero eros et accumsan et
            iusto odio dignissim qui blandit praesent luptatum zzril delenit augue duis dolore te feugait nulla facilisi.
            Nam liber tempor cum soluta nobis eleifend option congue nihil imperdiet doming id quod mazim placerat facer
            possim assum. Typi non habent claritatem insitam; est usus legentis in iis qui facit eorum claritatem.
            Investigationes demonstraverunt lectores legere me lius quod ii legunt saepius. Claritas est etiam processus
            dynamicus, qui sequitur mutationem consuetudium lectorum. Mirum est notare quam littera gothica, quam nunc
            putamus parum claram, anteposuerit litterarum formas humanitatis per seacula quarta decima et quinta decima.
            Eodem modo typi, qui nunc nobis videntur parum clari, fiant sollemnes in futurum.</p>
    </@layout.put>
    <@layout.put block="footer" type="replace">
        <hr/>
        <div class="footer">Footer replaced by index</div>
    </@layout.put>
</@layout.extends>