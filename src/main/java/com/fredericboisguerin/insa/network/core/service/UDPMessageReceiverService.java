package com.fredericboisguerin.insa.network.core.service;

import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class UDPMessageReceiverService implements MessageReceiverService {

    private final int BUFFER_SIZE = 1000;

    @Override
    public void listenOnPort(int port, IncomingMessageListener incomingMessageListener) throws Exception {

        DatagramSocket receiverSocket = new DatagramSocket(port);
        DatagramPacket receivedPacket = new DatagramPacket(new byte[BUFFER_SIZE], BUFFER_SIZE);
        receiverSocket.receive(receivedPacket);
        byte[] data = receivedPacket.getData();
       // String message = new String(data)
        String message = new String(data);
        System.out.println(message);
    }


    public String openFileToString(byte[] _bytes)
    {
        String file_string = "";
        for(int i = 0; i < _bytes.length; i++)
        {
            //if ((char)_bytes[i] == "\0"){break;}
            file_string += (char)_bytes[i];

        }
        return file_string;
    }
}
