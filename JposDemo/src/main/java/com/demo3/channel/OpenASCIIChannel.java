package com.demo3.channel;

import java.io.IOException;

import org.jpos.iso.ISOChannel;
import org.jpos.iso.ISOException;
import org.jpos.iso.ISOMsg;
import org.jpos.iso.channel.ASCIIChannel;
import org.jpos.iso.packager.ISO87APackager;
import org.jpos.util.LogSource;
import org.jpos.util.Logger;
import org.jpos.util.SimpleLogListener;

public class OpenASCIIChannel {

	public static void main(String[] args) throws IOException, ISOException {
		// TODO Auto-generated method stub
		Logger logger = new Logger();
        logger.addListener (new SimpleLogListener(System.out));
        ISOChannel channel = new ASCIIChannel ("localhost", 7, new ISO87APackager());
        ((LogSource)channel).setLogger (logger, "test-channel");
       
        System.out.println(channel.isConnected()+"-----------------");
        
        channel.connect ();
        
        System.out.println(channel.isConnected()+"-----------------");

        ISOMsg m = new ISOMsg ();
        m.setMTI ("0800");
        m.set (3, "000000");
        m.set (41, "00000001");
        m.set (70, "301");
        channel.send (m);
        ISOMsg r = channel.receive ();
        channel.disconnect ();
		 
		 
		 

	}

}
