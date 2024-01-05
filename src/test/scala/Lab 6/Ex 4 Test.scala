package Lab6

import org.scalatest._
import chisel3._
import chiseltest._

class My_QueueTest extends FreeSpec with ChiselScalatestTester{
    "Queue Test" in {
        test(new My_Queue()){
            C =>
            C.io.in.valid.poke(1.B)
            C.io.in.bits.poke(5.U)
            C.io.out.ready.poke(1.B)
            C.clock.step(50)
        }
    }
}