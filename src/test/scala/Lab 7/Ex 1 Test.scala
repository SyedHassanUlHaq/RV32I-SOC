package Lab7

import chisel3._
import org.scalatest._
import chiseltest._

class Arbiter_QueueTest extends FreeSpec with ChiselScalatestTester{
    "Arbiter Queue test" in{
        test(new Arbiter_Queue){
            C =>
            C.io.in1.bits.poke(4.U)
            C.io.in1.valid.poke(1.B)
            C.io.in2.bits.poke(7.U)
            C.io.in2.valid.poke(1.B)
            C.io.out.ready.poke(1.B)
            C.clock.step(100)
        }
    }
}