package Lab7

import chisel3._
import org.scalatest._
import chiseltest._

class My_QueueTest extends FreeSpec with ChiselScalatestTester{
    "My Queue test" in {
        test(new My_Queue){
            C =>
            C.io.f2.poke(1.B)
            C.io.r2.poke(1.B)
            C.clock.step(50)
        }
    }
}