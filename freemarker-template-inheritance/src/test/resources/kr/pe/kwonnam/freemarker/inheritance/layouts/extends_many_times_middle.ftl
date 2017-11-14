<@layout.extends name="/layouts/extends_many_times_base.ftl">
    <@layout.put block="first">FirstBlockChild1-</@layout.put>
    <@layout.put block="second">SecondBlock will not shown</@layout.put>
    <@layout.put block="third">ThirdBlockChild1</@layout.put>
    <@layout.put block="fifth">FifthBlockChild1</@layout.put>
</@layout.extends>