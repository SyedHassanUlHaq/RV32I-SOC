package Lab6

import chisel3._
import org.scalatest._
import chiseltest._

class shift_registerTest extends FreeSpec with ChiselScalatestTester{
    "Shif_Register" in{
        test(new shift_register()){
            C =>
            C.io.in.poke(3.U)
            C.clock.step(50)
        }
    }
}