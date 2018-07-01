package com.cy.synchronizedTest;

/*
 * û��synchronized�ؼ�������
 * ���н����method 1 start
			method 1 execute
			method 2 start
			method 2 execute
			method 2 end
			method 1 end
 * ���ͣ��߳�1���߳�2ͬʱ����ִ��״̬���߳�2��ִ���ٶȱ��߳�1�죬�����߳�2��ִ����ɡ�����������߳�1���߳�2��ͬʱִ�еġ�
 */
public class SynchronizedTest {
	
	//������ͨ����method1
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
	
	//������ͨ����method2
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
