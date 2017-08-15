package _6

class Rational(n:Int, d:Int){
     require(d != 0)
     
     private val g = gcd(n, d)
     val num = n / g
     val denom = d /g
     
     def this(n:Int) = this(n,1)
     
     override def toString = num + "/" + denom;
    
     def +(that:Rational) = new Rational(n * that.denom + that.num * d, d * that.denom) 
     def *(that:Rational) = new Rational(n*that.num, d*that.denom)
     //递归必须带返回值
     def gcd(a: Int, b: Int):Int = if (b == 0) a else gcd(b, a % b) 
     
}