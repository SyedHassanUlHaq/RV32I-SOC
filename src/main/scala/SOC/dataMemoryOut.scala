package SOC

import chisel3._
import chisel3.util._
import caravan.bus.common.{AbstrRequest, AbstrResponse, BusConfig}

class dataMemoryOut (val req:AbstrRequest, val rsp:AbstrResponse)(implicit val config:BusConfig) extends Module {
    val io = IO(new Bundle{            
            val dccmReq = Flipped(Decoupled(req))
            val dccmRsp = Decoupled(rsp)
            //val req = Decoupled(req)
            //val rsp = Flipped(Decoupled(rsp))

    })
    val mem=SyncReadMem(1024,SInt(32.W))
    io.dccmRsp.valid := 0.B
    io.dccmReq.ready := 1.B
    when (io.dccmReq.bits.isWrite === 1.B && io.dccmReq.valid){
        mem.write(io.dccmReq.bits.addrRequest,io.dccmReq.bits.dataRequest.asSInt())
        io.dccmRsp.valid := 1.B
    }
    when (io.dccmReq.bits.isWrite===0.B && io.dccmReq.valid){
        io.dccmRsp.bits.dataResponse := mem.read(io.dccmReq.bits.addrRequest).asUInt()
        io.dccmRsp.valid := 1.B
    }.otherwise{
        io.dccmRsp.bits.dataResponse := 0.U
    }
    io.dccmRsp.bits.error := 0.B
    //io.dccmRsp.ready := 1.B
    //io.dccmReq.bits.activeByteLane := "b1111".U
    //io.dccmReq.bits.dataRequest := io.dataIn.asUInt()
    //io.dccmReq.bits.addrRequest := io.rdAddr
    //io.dccmReq.bits.isWrite := io.writeData
    //io.dccmReq.valid := Mux(io.writeData.asBool | io.readData.asBool(), 1.B, 0.B)
    //io.dataOut := Mux(io.dccmRsp.valid, io.dccmRsp.bits.dataResponse.asSInt(), 0.S)
}