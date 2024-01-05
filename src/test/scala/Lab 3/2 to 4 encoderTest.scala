package Lab3

import chisel3._
import org.scalatest._
import chiseltest._

class encoderTest extends FreeSpec with ChiselScalatestTester{
    "encoder test" in{
        test(new encoder2to4){
            C =>
            C.io.in.poke("b0010".U)
            C.clock.step(50)
        }
    }
}