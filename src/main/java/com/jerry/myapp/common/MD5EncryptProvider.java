package com.jerry.myapp.common;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MD5EncryptProvider {
    public String getDigest(byte[] originData) throws NoSuchAlgorithmException {
        try {
            MessageDigest alga = MessageDigest.getInstance("MD5");
            alga.update(originData);
            byte[] digest = alga.digest();
            return getMD5ofStr(digest);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            throw e;
        }
    }

    private String getMD5ofStr(byte[] digest) {
            String digestHexStr = "";
            for (int i = 0; i < 16; i++) {
                    digestHexStr += byteHEX(digest[i]);
            }
            return digestHexStr;
    }

    private String byteHEX(byte ib) {
            char[] Digit = { '0','1','2','3','4','5','6','7','8','9',
            'A','B','C','D','E','F' };
            char [] ob = new char[2];
            ob[0] = Digit[(ib >>> 4) & 0X0F];
            ob[1] = Digit[ib & 0X0F];
            String s = new String(ob);
            return s;
    }

	public String getName() {
		return "MD5";
	}
	
	public static void main(String[] args) {
		MD5EncryptProvider md5 = new MD5EncryptProvider();
		try {
			System.out.println("MD5:"+md5.getDigest("1".getBytes()));
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
