package Lab6

import chisel3._
import org.scalatest._
import chiseltest._

class counter_with_xorTest extends FreeSpec with ChiselScalatestTester{
    "XOR counter Test" in {
        test(new counter_with_xor(32)){
            C =>
            C.clock.step(50)
        }
    }
}