package _3

object Summer {
    def main(args:Array[String]){
      for(arg <- args){
        println(ChecksumAccumulator.calculate(arg))
      }
    } 
}