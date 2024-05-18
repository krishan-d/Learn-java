package com.learning._3_io_networking.io.noi_apis;

public class NioVsIo {

    public static void main(String[] args) {

        //Key Features:
        /*
        * IO
        * - InputStream and OutputStream – that provide data one byte at a time
        * - Reader and Writer – convenience wrappers for the streams
        * - blocking mode – to wait for a complete message
        *
        * NIO [Introduced in Java 1.4 and updated in 1.7(NIO.2)]
        * With enhanced File operations and as ASynchronousSocketChannel. It provides:
        *
        * - Buffer – to read chunks of data at a time
        * - CharsetDecoder – for mapping raw bytes to/from readable characters
        * - Channel – for communicating with the outside world
        * - Selector – to enable multiplexing on a SelectableChannel and provide access to any Channels that are ready for I/O
        * - non-blocking mode – to read whatever is ready
        *
        *
        * */

    }
}
