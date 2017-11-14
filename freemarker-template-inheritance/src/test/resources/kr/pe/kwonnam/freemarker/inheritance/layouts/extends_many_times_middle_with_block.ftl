<@layout.extends name="/layouts/extends_many_times_base.ftl">
    <@layout.put block="first"><@layout.block name="first">FirstBlockChild1-</@layout.block></@layout.put>
    <@layout.put block="second"><@layout.block name="second">SecondBlock will not shown</@layout.block></@layout.put>
    <@layout.put block="third"><@layout.block name="third">ThirdBlockChild1</@layout.block></@layout.put>
    <@layout.put block="fifth">FifthBlockChild1</@layout.put>
</@layout.extends>