package Lab5

import chisel3._
import chiseltest._
import org.scalatest._

class OperatorTest extends FreeSpec with ChiselScalatestTester{
    "Operator Test" in{
        test(new Operator(5, UInt(32.W))(_+_)){
            C =>
            C.io.in(0).poke(7.U)
            C.io.in(1).poke(5.U)
            C.io.in(2).poke(3.U)
            C.clock.step(50)
        }
    }
}