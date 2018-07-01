package com.cy.synchronizedTest;

/*
 * 没有synchronized关键字修饰
 * 运行结果：method 1 start
			method 1 execute
			method 2 start
			method 2 execute
			method 2 end
			method 1 end
 * 解释：线程1和线程2同时进入执行状态，线程2的执行速度比线程1快，所以线程2先执行完成。但这个过程线程1和线程2是同时执行的。
 */
public class SynchronizedTest {
	
	//修饰普通方法method1
	public void method1() {
		
		System.out.println("method 1 start");
		try {
			System.out.println("method 1 execute");
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("method 1 end");
	}
	
	//修饰普通方法method2
	public void method2() {
		
		System.out.println("method 2 start");
		try {
			System.out.println("method 2 execute");
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("method 2 end");
	}

	public static void main(String[] args) {

		final SynchronizedTest test = new SynchronizedTest();
		new Thread(new Runnable() {
			@Override
			public void run() {
				test.method1();
			}
		}).start();
		
		new Thread(new Runnable() {
			@Override
			public void run() {
				test.method2();
			}
		}).start();
	}

}
