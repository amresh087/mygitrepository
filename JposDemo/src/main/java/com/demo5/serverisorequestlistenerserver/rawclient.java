package com.demo5.serverisorequestlistenerserver;

import org.jpos.iso.ISOMsg;
import org.jpos.iso.ISOField;
import org.jpos.iso.ISOChannel;
import org.jpos.iso.ISOPackager;
import org.jpos.iso.ISOUtil;
import org.jpos.iso.ISOException;
import org.jpos.util.LogSource;
import org.jpos.util.LogEvent;
import org.jpos.util.SimpleLogListener;
import org.jpos.util.Logger;
import org.jpos.util.SimpleLogSource;
import org.jpos.core.Configuration;
import org.jpos.core.SimpleConfiguration;

import java.util.Properties;
import java.io.IOException;
import java.io.FileInputStream;
import org.jpos.iso.packager.ISO87BPackager;
import org.jpos.iso.ISOUtil;
import org.jpos.iso.channel.NACChannel;

public class rawclient extends SimpleLogSource {
	
	private ISOChannel channel;
    ISOPackager packager=null;
    private static final String COUNTERNAME = "test.counter";
    
    public rawclient()	throws ISOException, IOException
    {
    	super();
		byte b[]={6,0,0,0,1,1,0,0,0,0};
		
		System.out.println("================================================");
		
		System.out.println("Length   "+b.length);
		packager= new ISO87BPackager();
		setLogger (logger, realm);
		channel=new NACChannel("localhost",8000,packager,b);
		channel.connect();
    }
    
    
    public void send (String mti)
    {
    	try
    	{
    		byte b1[]={6,0,0,0,1,1,0,0,0,0};

			ISOPackager packager = new ISO87BPackager();
			ISOMsg m = new ISOMsg();
			ISOMsg m1 = new ISOMsg();
			
			m1.setPackager (packager);
			m.setHeader(b1);
			
			m.setMTI (mti);
	   		m.set(new ISOField (2, "5546199368915005"));
	   		
	   		channel.send (m);
	   		
	   		ISOMsg response = channel.receive();
			byte[] b = response.pack();
			
			System.out.println("header   "+ISOUtil.hexString(b));
    		
    		
    		
    	}
    	catch (ISOException e)
		{
			Logger.log (new LogEvent (this, "send", e));
		}
		catch (IOException e)
		{
			Logger.log (new LogEvent (this, "send", e));
		}
    	
    }
    
    
    public void disconnect () throws IOException
    {
		channel.disconnect();
    }
    
    
    public static void main(String[] args) {
    	
    	
    	
    	try
    	{
    		rawclient r = new rawclient();
    		r.send ("0100");
	    	r.disconnect();
    		
    	}catch (ISOException e)
		{
	    	e.printStackTrace();
		}
		catch (IOException e)
		{
		    e.printStackTrace();
		}
		
	}

}
