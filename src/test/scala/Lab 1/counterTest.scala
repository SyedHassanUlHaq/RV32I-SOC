package Lab1

import chisel3._
import org.scalatest._
import chiseltest._

class Countertest extends FreeSpec with ChiselScalatestTester {
    "counter Test" in {
        test(new Count(5.U)){ 
            C => 
            C.clock.step(100)
        }
    }
}