<!DOCTYPE html>
<html>
    <head>
        <title>Base Layout</title>
        <meta charset="utf-8">
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
            <div>Footer base must not be shown</div>
        </@layout.block>
    </body>
</html>