package com.demo1.pack;

import org.jpos.iso.ISOException;
import org.jpos.iso.ISOMsg;
import org.jpos.iso.packager.GenericPackager;

public class PackData {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		try {

			// create package based xml which is contain Data Elements
			GenericPackager packager = new GenericPackager("basic1.xml");

			ISOMsg isoMsg = new ISOMsg();

			isoMsg.setPackager(packager);
			isoMsg.setMTI("0200");
			isoMsg.set(3, "201234");
			isoMsg.set(4, "10000");
			isoMsg.set(7, "110722180");
			isoMsg.set(11, "123456");
			isoMsg.set(44, "A5DFGR");
			isoMsg.set(105, "ABCDEFGHIJ 1234567890");

			System.out.println(packager);
			displayISOMsgData(isoMsg);

			// pack the data

			byte[] data = isoMsg.pack();
			System.out.println("RESULT : " + new String(data));

		} catch (ISOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	/**
	 * 
	 * @param msg
	 */
	private static void displayISOMsgData(ISOMsg msg) {

		try {
			String mti = msg.getMTI();

			System.out.println("the MTI DATA  =" + mti);

			for (int i = 1; i < msg.getMaxField(); i++) {
				if (msg.hasField(i)) {
					System.out.println(msg.getString(i));
				}

			}

		} catch (ISOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
