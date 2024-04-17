package SOC

import chisel3._
import chisel3.util._
import caravan.bus.common.{AbstrRequest, AbstrResponse, BusConfig, BusDevice, BusHost}
import caravan.bus.tilelink.{TLRequest, TLResponse, TilelinkConfig, TilelinkAdapter}

class Top extends Module{
    val io = IO(new Bundle() {
    })
    implicit val config = TilelinkConfig()
    val core: Core = Module(new Core(/*req, rsp*/ new TLRequest,new TLResponse))
    
    val dMem_ = Module(new dataMemoryOut(new TLRequest, new TLResponse))
    val dMem_Adapter = Module(new TilelinkAdapter())

    val iMem_ = Module(new instrMemOut(new TLRequest, new TLResponse))
    dontTouch(iMem_.io)
    val iMem_Adapter = Module(new TilelinkAdapter())

    dMem_Adapter.io.reqIn <> core.io.dmemReq
    core.io.dmemRsp <> dMem_Adapter.io.rspOut
    dMem_.io.dccmReq <> dMem_Adapter.io.reqOut
    dMem_Adapter.io.rspIn <> dMem_.io.dccmRsp

    iMem_Adapter.io.reqIn <> core.io.imemReq
    core.io.imemRsp <> iMem_Adapter.io.rspOut
    iMem_.io.insmReq <> iMem_Adapter.io.reqOut
    iMem_Adapter.io.rspIn <> iMem_.io.insmRsp
}