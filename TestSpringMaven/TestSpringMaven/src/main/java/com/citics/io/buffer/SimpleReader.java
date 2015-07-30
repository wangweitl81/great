package com.citics.io.buffer;

import java.io.FileInputStream;

public class SimpleReader {
	public static void main(String[] args) {
		if(args.length != 1) 
		{
			System.err.println("no filename provided.");
			System.exit(1);
		} 
		
		try {
			int cnt=1,b;
			FileInputStream fis = new FileInputStream(args[0]);
			while((b=fis.read()) != -1) {
				if(b == '\n')
				{
					cnt++;
				}
			}
			System.out.println(cnt+" lines have been read.");
		} catch (Exception e) {
		}
	}
}
