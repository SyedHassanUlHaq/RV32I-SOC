package Lab8

import chisel3._
import org.scalatest._
import chiseltest._

class memory_assignmentTest extends FreeSpec with ChiselScalatestTester{
    "memory assignment" in {
        test(new memory_assignment){
            C =>
            C.io.Writeaddr.poke(4.U)
            C.io.Readaddr.poke(4.U)
            C.io.requestor(0).bits.poke(3.U)
            C.io.requestor(1).bits.poke(6.U)
            C.io.requestor(2).bits.poke(2.U)
            C.io.requestor(3).bits.poke(4.U)
            C.io.requestor(0).valid.poke(0.B)
            C.io.requestor(1).valid.poke(0.B)
            C.io.requestor(2).valid.poke(1.B)
            C.io.requestor(3).valid.poke(0.B)
            C.clock.step(50)
        }
    }
}