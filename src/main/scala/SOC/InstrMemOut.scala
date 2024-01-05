package SOC

import chisel3._
import chisel3.util._
import chisel3.util.experimental.loadMemoryFromFile
import caravan.bus.common.{AbstrRequest, AbstrResponse, BusConfig}

class instrMemOut(val req:AbstrRequest, val rsp:AbstrResponse)(implicit val config:BusConfig) extends Module{
    val io = IO(new Bundle{
        val insmReq = Flipped(Decoupled(req))
        val insmRsp = Decoupled(rsp)
    })
    val mem = SyncReadMem(1024, UInt(32.W))
    loadMemoryFromFile(mem, "/home/hassan/Documents/Assemble.txt")
    // io.instr := mem.read(io.addr)
    io.insmRsp.valid := 0.B
    io.insmReq.ready := 1.B
    io.insmRsp.bits.error := 0.B
    when (/*io.insmReq.bits.isWrite===0.B && */io.insmReq.valid){
        io.insmRsp.bits.dataResponse := mem.read(io.insmReq.bits.addrRequest).asUInt()
        io.insmRsp.valid := 1.B
    }.otherwise{
        io.insmRsp.bits.dataResponse := 0.U
    }
    io.insmRsp.bits.error := 0.B
}