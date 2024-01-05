package Lab2

import chisel3._
import org.scalatest._
import chiseltest._

class MuxlookupTest extends FreeSpec with ChiselScalatestTester{
    "Lookup Test" in {
        test(new MuxLookup()) {
            C =>
            C.io.in0.poke(1.U)
            C.io.in1.poke(9.U)
            C.io.in2.poke(3.U)
            C.io.in3.poke(4.U)
            C.io.in4.poke(5.U)
            C.io.in5.poke(6.U)
            C.io.in6.poke(7.U)
            C.io.in7.poke(8.U)
            C.io.sel.poke(2.U)
            C.clock.step(100)
        }
    }
}