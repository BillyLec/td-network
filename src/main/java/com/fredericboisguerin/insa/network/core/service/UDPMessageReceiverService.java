package com.fredericboisguerin.insa.network.core.service;

import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class UDPMessageReceiverService implements MessageReceiverService {

    private final int BUFFER_SIZE = 1024;

    @Override
    public void listenOnPort(int port, IncomingMessageListener incomingMessageListener) throws Exception {
        
        byte[] buffer = new byte[BUFFER_SIZE];
                
        DatagramSocket receiverSocket = new DatagramSocket(port);
        DatagramPacket receivedPacket = new DatagramPacket(buffer, BUFFER_SIZE);
        
        receiverSocket.receive(receivedPacket);
        
        buffer = receivedPacket.getData();
        String message =  new String(buffer, 0, receivedPacket.getLength());
        System.out.println(message);
    }
}
