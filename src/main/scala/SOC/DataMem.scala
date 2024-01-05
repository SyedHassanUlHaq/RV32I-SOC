package SOC

import chisel3._
import chisel3.util._
import caravan.bus.common.{AbstrRequest, AbstrResponse, BusConfig}

class dataMemory (val req:AbstrRequest, val rsp:AbstrResponse)(implicit val config:BusConfig) extends Module {
    val io = IO(new Bundle{
            val writeData = Input(UInt(1.W))
            val readData = Input(UInt(1.W))
            val rdAddr = Input(UInt(10.W))
            val dataIn = Input(SInt(32.W))    
            val dataOut = Output(SInt(32.W))
            
            val dccmReq = Decoupled(req)
            val dccmRsp = Flipped(Decoupled(rsp))
            //val req = Decoupled(req)
            //val rsp = Flipped(Decoupled(rsp))

    })

 //  val mem=Mem(1024,SInt(32.W))
 //   when (io.writeData === 1.B){
 //       mem.write(io.rdAddr,io.dataIn)
 //   }
 //   when (io.readData===1.B){
 //       io.dataOut := mem.read(io.rdAddr)
 //   }.otherwise{
 //       io.dataOut := 0.S
 //   }
    io.dccmRsp.ready := 1.B
    io.dccmReq.bits.activeByteLane := "b1111".U
    io.dccmReq.bits.dataRequest := io.dataIn.asUInt()
    io.dccmReq.bits.addrRequest := io.rdAddr
    io.dccmReq.bits.isWrite := io.writeData
    io.dccmReq.valid := Mux(io.writeData.asBool | io.readData.asBool(), 1.B, 0.B)
    io.dataOut := Mux(io.dccmRsp.valid, io.dccmRsp.bits.dataResponse.asSInt(), 0.S)
}