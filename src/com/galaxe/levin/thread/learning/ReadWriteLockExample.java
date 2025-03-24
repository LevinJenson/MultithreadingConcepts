package com.galaxe.levin.thread.learning;

import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReadWriteLockExample {
	
	private final ReentrantReadWriteLock rwLock = new ReentrantReadWriteLock();
	private final ReentrantReadWriteLock.ReadLock rl = rwLock.readLock();
	private final ReentrantReadWriteLock.WriteLock wl= rwLock.writeLock();
	
	

}
