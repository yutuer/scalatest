package _10

abstract class Element {
  def contents:Array[String]
  def height:Int = contents.length
  def width:Int = if(height == 0) 0 else contents(0).length

  def above(that:Element):Element = {
    Element.elem(this.contents ++ that.contents)
  }

  def beside(that:Element):Element = {
    Element.elem(
        for((line1, line2) <- this.contents zip that.contents) yield (line1 + line2)
    )
  }

  override def toString: String = contents mkString "\n"
}

object Element{
  def elem(contents:Array[String]):Element = new ArrayElement(contents)
  def elem(ch:Char, width:Int, height:Int):Element = new UniformElement(ch, width, height)
  def elem(line:String):Element = new LineElement(line)

  private class ArrayElement(val contents:Array[String]) extends Element{}
  private class LineElement(s:String) extends ArrayElement(Array(s)){
    override def height: Int = 1
    override def width: Int = s.length
  }
  private class UniformElement(ch:Char, override val width:Int, override val height:Int) extends Element{
    private val line = ch.toString *  width
    override def contents = Array.fill(height)(line)
  }
}
