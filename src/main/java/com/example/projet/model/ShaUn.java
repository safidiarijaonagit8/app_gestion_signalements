package com.example.projet.model;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class ShaUn {

	public ShaUn() {

	}

	public String getShaUn(String mdp) {
		String hashStr = null;
		try {
			MessageDigest md = MessageDigest.getInstance("SHA-1");
			md.update(mdp.getBytes());
			BigInteger hash = new BigInteger(1, md.digest());
			hashStr = hash.toString(16);
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		return hashStr;
	}

	public static void main(String[] args) {
		ShaUn un = new ShaUn();
		String mdp = "admin1";
		String t = un.getShaUn(mdp);
		System.out.println("shaUn " + t);
	}

}
