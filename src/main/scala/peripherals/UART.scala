package jigsaw.peripherals.UART

import chisel3._
import chisel3.util._
import caravan.bus.common.{BusConfig, AbstrRequest, AbstrResponse}
import jigsaw.peripherals.UART._

class uart(val req:AbstrRequest, val rsp:AbstrResponse)(implicit val config:BusConfig) extends Module {
    val io = IO(new Bundle{
        val request = Flipped(Decoupled(req))   // req aaygi
        val response = Decoupled(rsp)           // resp jaayga
        val cio_uart_rx_i = Input(Bool())

        val cio_uart_tx_o = Output(Bool())
        val cio_uart_intr_tx_o = Output(Bool())
        //val valid_check = Output(Bool())
    })

    io.request.ready := 1.B

    /*io.valid_check := io.request.valid

    when (io.request.valid){
        val uart = Module (new UartTOP)
        uart.io.wdata := io.request.bits.dataRequest
        uart.io.addr := io.request.bits.addrRequest(7,0)
        uart.io.we := io.request.bits.isWrite
        uart.io.ren := ~io.request.bits.isWrite

        io.request.ready := 1.B

        //io.response.bits.dataResponse := uart.io.rdata
        //io.response.valid := 1.B

        io.response.bits.dataResponse := RegNext(Mux(io.response.ready , uart.io.rdata , 0.U))
        io.response.valid := RegNext(io.request.valid)

        //io.response.bits.error := uart.io.intr_tx

        io.response.bits.error := RegNext(Mux(io.response.ready , uart.io.intr_tx , 0.U))


        io.cio_uart_intr_tx_o := uart.io.intr_tx
        io.cio_uart_tx_o := uart.io.tx_o
        uart.io.rx_i := io.cio_uart_rx_i
    }.otherwise{
        io.request.ready := 1.B

        io.response.bits.dataResponse := 0.U
        io.response.bits.error := 0.B
        io.response.valid := 0.B

        io.cio_uart_intr_tx_o := DontCare
        io.cio_uart_tx_o := DontCare  
    }*/

    val uart_top = Module (new UartTOP)

 
    val write_register, read_register  = Wire(Bool())
    val data_reg = Wire(UInt(32.W))
    val addr_reg = Wire(UInt(8.W))

    write_register := Mux(io.request.fire(), io.request.bits.isWrite, false.B)
    read_register := Mux(io.request.fire(), !io.request.bits.isWrite, false.B)
    data_reg := io.request.bits.dataRequest
    addr_reg := io.request.bits.addrRequest(7,0)
    uart_top.io.wdata := data_reg
    uart_top.io.addr := addr_reg
    uart_top.io.we := write_register
    uart_top.io.ren := read_register

    io.response.bits.dataResponse := RegNext(Mux(io.response.ready , uart_top.io.rdata , 0.U))
    io.response.valid := RegNext(Mux(write_register || read_register, true.B, false.B))
    io.response.bits.error := RegNext(Mux(io.response.ready , uart_top.io.intr_tx , 0.U))

    io.cio_uart_intr_tx_o := uart_top.io.intr_tx
    io.cio_uart_tx_o := uart_top.io.tx_o
    uart_top.io.rx_i := io.cio_uart_rx_i
}