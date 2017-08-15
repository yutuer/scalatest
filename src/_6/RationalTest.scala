package _6

object RationalTest {
    
    implicit def intToRational(x:Int) = new Rational(x) 
    
    def main(args: Array[String]){
        val r = new Rational(5)
        val r2 = new Rational(66,42)
        println(r + r2)
        println(r * r2)
        println(r2 * 2)
        println(2 * r2)
        
        println(multiTable())
        val a1 = sum _
        a1(1, 2)
        val s1 = (a:Int, b:Int) => a + b
        s1.apply(1, 2)
        s1(1, 2)
        
    }
    
 		def sum(a:Int, b:Int) = a+b
    
    def makeRowSeq(row:Int) = {
      for(col <- 1 to 10) yield{
        val prod = (row * col).toString();
        val padding = " " * (4 - prod.length())
        padding + prod
      }
    }
    
    def makeRow(row:Int) = makeRowSeq(row).mkString
    
    def multiTable() = {
        val tableSeq = 
          for(row <- 1 to 10) 
          yield makeRow(row)
        
        tableSeq.mkString("\n")
    }
}