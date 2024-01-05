package SOC

import chisel3._
import chisel3.util._
import caravan.bus.common.{AbstrRequest, AbstrResponse, BusConfig}

class instMemory (val req:AbstrRequest, val rsp:AbstrResponse)(implicit val config:BusConfig) extends Module {
    val io = IO(new Bundle{
            // val readData = Input(UInt(1.W))
            val Addr = Input(UInt(32.W))
            // val rdAddr = Input(SInt(32.W))    
            val inst = Output(UInt(32.W))
            
            val insmReq = Decoupled(req)
            val insmRsp = Flipped(Decoupled(rsp))
            //val req = Decoupled(req)
            //val rsp = Flipped(Decoupled(rsp))

    })

 //  val mem=Mem(1024,SInt(32.W))
 //   when (io.writeData === 1.B){
 //       mem.write(io.Addr,io.rdAddr)
 //   }
 //   when (io.readData===1.B){
 //       io.inst := mem.read(io.Addr)
 //   }.otherwise{
 //       io.inst := 0.S
 //   }
    io.insmReq.bits.dataRequest := 0.U
    io.insmReq.valid := 0.U
    io.insmReq.bits.isWrite := 0.U
    io.insmReq.bits.activeByteLane := "b1111".U
    // io.insmReq.ready := 0.B

    io.insmRsp.ready := 1.B
    // io.insmReq.bits.activeByteLane := "b1111".U
    // io.insmReq.bits.dataRequest := io.rdAddr.asUInt()
    io.insmReq.bits.addrRequest := io.Addr
    // io.insmReq.bits.isWrite := io.writeData
    // io.insmReq.valid := Mux(io.writeData.asBool | io.readData.asBool(), 1.B, 0.B)
    io.inst := Mux(io.insmRsp.valid, io.insmRsp.bits.dataResponse, 0.U)
}