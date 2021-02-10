data class Rectangle(val x:Int, val y: Int, val w: Int, val h: Int)

class Paint{
    var color : Long= 0x00FF00
    var strokeWidth:Int =5
    fun drawRectangle (rect: Rectangle) {
        println("Drawing $rect color: $color stroke: $strokeWidth")
    }
}

fun render(paint: Paint?, rectangles: List<Rectangle?>) {
    if(paint!=null) {
        paint.color=0x00FF00
        rectangles.forEach { rect: Rectangle? -> rect?.let { paint.drawRectangle(it) } }
    }
}

fun main() {
    val rectangle1 = Rectangle(1, 1, 1, 1);
    val rectangle2 = Rectangle(2, 2, 2, 2);
    val list = listOf(rectangle1, rectangle2);
    val paint = Paint();
    render(paint, list);
}