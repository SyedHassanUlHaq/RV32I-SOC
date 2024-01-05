package Lab3

import chisel3._
import org.scalatest._
import chiseltest._

class decoderTest extends FreeSpec with ChiselScalatestTester{
    "decoder With Valid" in {
        test(new decoder_with_valid) {
            C =>
            C.io.in.poke("b01".U)
            C.clock.step(50)
        }
    }
}