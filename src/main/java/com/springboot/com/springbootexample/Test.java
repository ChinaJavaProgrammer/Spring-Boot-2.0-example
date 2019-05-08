package com.springboot.com.springbootexample;

import java.util.concurrent.atomic.AtomicInteger;

public class Test {
  	AtomicInteger   inc = new AtomicInteger(0);
	public   void crease() {
		inc.getAndIncrement();
	}
	
	public static native void sleep(long mill);
	public static void main(String [] args) {
		Test test = new Test();
		for(int i=0;i<10;i++) {
			new Thread() {
				public void run() {
					for(int j=0;j<1000;j++)
					test.crease();
				}
			}.start();
		}
		 while(Thread.activeCount()>1)  
			 Thread.yield();
		System.out.println(test.inc);
	}
}
