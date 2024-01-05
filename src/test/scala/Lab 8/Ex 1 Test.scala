package Lab8

import chisel3._
import org.scalatest._
import chiseltest._

class MaskedReadWriteSmemTest extends FreeSpec with ChiselScalatestTester{
    "mask overloading" in {
        test(new MaskedReadWriteSmem){
            C =>
            C.io.dataIn(2).poke(6.U)
            C.io.enable.poke(1.B)
            C.io.write.poke(1.B)
            C.io.mask(2).poke(1.B)
            C.io.addr.poke(12.U)
            C.clock.step(50)
        }
    }
}