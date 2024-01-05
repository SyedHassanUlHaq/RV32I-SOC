package cachePipelining

import chisel3._
import org.scalatest._
import chiseltest._

class Topfile_Test extends FreeSpec with ChiselScalatestTester{
    "Top Test" in {
        test(new Top){
            C =>
            C.clock.step(100)
        }
    }
}