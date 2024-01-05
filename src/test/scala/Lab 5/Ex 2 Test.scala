package Lab5

import chisel3._
import org.scalatest._
import chiseltest._

class eMuxTest extends FreeSpec with ChiselScalatestTester {
    "eMux Test" in {
        test(new eMux(UInt(16.W))) {
            C =>
            C.io.in1.poke(5.U)
            C.io.in2.poke(7.U)
            C.io.sel.poke(1.B)
            C.clock.step(50)
        }
    }
}