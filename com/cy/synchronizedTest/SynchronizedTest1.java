package com.cy.synchronizedTest;

/*
 * synchronized 关键字原理测试
 * 作用：1.确保线程互斥的访问同步代码
 *       2.保证共享变量的修改能够及时可见
 *       3.有效解决重排序问题
 * 用法： 1.修饰普通方法(见程序SynchronizedTest1,线程2要等到线程1的method1执行完成后才开始执行method2方法)
 *        2.修饰静态方法(见程序SynchronizedTest2)
 *        3.修饰代码块(见程序SynchronizedTest3)
 * 运行结果：method 1 start
	    method 1 execute
	    method 1 end
	    method 2 start
	    method 2 execute
	    method 2 end
 */
public class SynchronizedTest1 {
	
	//修饰普通方法method1
	public synchronized void method1() {
		
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
	public synchronized void method2() {
		
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

		//创建实例对象
		final SynchronizedTest1 test = new SynchronizedTest1();
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
