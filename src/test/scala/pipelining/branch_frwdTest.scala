package pipelining

import chisel3._
import org.scalatest._
import chiseltest._
import chiseltest.internal.VerilatorBackendAnnotation
import chiseltest.experimental.TestOptionBuilder._


class brnch_frwd_test extends FreeSpec with ChiselScalatestTester{
    "branch forwarding" in {
        test(new decode_frwd()).withAnnotations(Seq(VerilatorBackendAnnotation)){
            C =>
            C.io.id_ex_rdAddr.poke(5.U)
            C.io.id_ex_memRead.poke(false.B)
            C.io.ex_mem_rdAddr.poke(3.U)
            C.io.ex_mem_memRead.poke(true.B)
            C.io.mem_wr_rdAddr.poke(7.U)
            C.io.mem_wr_memRead.poke(true.B)
            C.io.rs1Addr.poke(10.U)
            C.io.rs2Addr.poke(12.U)
            C.io.c_branch.poke(true.B)
        }
    }
}