package com.demo5.serverisorequestlistenerserver;

import org.jpos.iso.ISOMsg;
import org.jpos.iso.ISOField;
import org.jpos.iso.ISOServer;
import org.jpos.iso.ISOSource;
import org.jpos.iso.ISOChannel;
import org.jpos.iso.ISOException;
import org.jpos.iso.ServerChannel;
import org.jpos.iso.ISORequestListener;
import org.jpos.iso.channel.NACChannel;
import org.jpos.iso.packager.ISO87BPackager;
import org.jpos.util.Logger;
import org.jpos.util.LogSource;
import org.jpos.util.SimpleLogListener;
import org.jpos.util.ThreadPool;
import org.jpos.iso.ISOUtil;
import org.jpos.iso.ISOPackager;

public class rawserver  implements ISORequestListener {

	
	
	public boolean process(ISOSource source, ISOMsg m) {
		try {
		ISOPackager packager = new ISO87BPackager();
		m.setPackager (packager);
		byte[] b;
		b = m.pack();
		System.out.println(ISOUtil.hexString(b));
		m.setMTI("0110");
   		m.set(new ISOField (2, "5546199368915005"));
   		source.send(m);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		
		// TODO Auto-generated method stub
		return true;
	}
	
	
	public static void main(String[] args) {
		
		try
		{
			Logger logger = new Logger();
		    logger.addListener (new SimpleLogListener (System.out));
		    
		    byte b[]={6,0,0,0,0,0,0,0,1,1};

		    ISOChannel clientSideChannel = new NACChannel(new ISO87BPackager(),b);
		    
		    ThreadPool pool = new ThreadPool (5, 30);
		    pool.setLogger (logger, "iso-server-pool");
		    ISOServer server =new ISOServer (8000, (ServerChannel)clientSideChannel, pool);
		    server.setLogger (logger, "iso-server");
		    server.addISORequestListener (new rawserver());
		    new Thread (server).start();
		}catch(Exception e)
		{
			
		}
		
	}

}
