package com.demo2.unpack;

import org.jpos.iso.ISOException;
import org.jpos.iso.ISOMsg;
import org.jpos.iso.packager.GenericPackager;

public class UnpackData {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		try {
			GenericPackager packger = new GenericPackager("basic1.xml");
			
			
			String data ="0200B2200000001000000000000000800000201234000000010000011072218012345606A5DFGR021ABCDEFGHIJ 1234567890";
			
			ISOMsg isomsg = new ISOMsg();
			isomsg.setPackager(packger);
			
			isomsg.unpack(data.getBytes());
			
			displayData(isomsg);
			
			
			
		} catch (ISOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	private static void displayData(ISOMsg isomsg)
	{
		try {
			System.err.println(" the value of mti "+isomsg.getMTI());
			
			for(int i=1;i<isomsg.getMaxField();i++)
			{
				if(isomsg.hasField(i))
				{
					System.out.println("    Field-"+i+" : "+isomsg.getString(i));
				}
			}
		} catch (ISOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
