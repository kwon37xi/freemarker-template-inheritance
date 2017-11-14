<@layout.extends name="/layouts/extends_many_times_middle_with_block.ftl">
    <@layout.put block="first" type="append">FirstAppendBlockChild2</@layout.put>
    <@layout.put block="second" type="replace">SecondBlockChildReplace</@layout.put>
    <@layout.put block="third" type="prepend">ThirdBlockChildPrepend2-</@layout.put>
    <@layout.put block="fourth" type="append">FourthBlockChildAppend2</@layout.put>
</@layout.extends>