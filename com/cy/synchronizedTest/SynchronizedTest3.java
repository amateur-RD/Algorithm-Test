package com.cy.synchronizedTest;

/*
 * synchronized �ؼ���ԭ�����
 * ���ã� 1.ȷ���̻߳���ķ���ͬ������
 *       2.��֤����������޸��ܹ���ʱ�ɼ�
 *       3.��Ч�������������
 * �÷��� 1.������ͨ����(������SynchronizedTest1,�߳�2Ҫ�ȵ��߳�1��method1ִ����ɺ�ſ�ʼִ��method2����)
 * 		 2.���ξ�̬����(��)(������SynchronizedTest2)
 * 		          ���ͣ���̬������ͬ���������Ƕ����ͬ��(��̬������������������ķ����������Ƕ����ϵķ���)
 *                 ,���Լ�ʹtest��test1���ڲ�ͬ�Ķ��󣬵�������ͬ����SynchronizedTest2���ʵ��
 *                 ,���ֻ��˳��ִ��method1��method2,���ܲ���ִ�С�
 *       3.���δ����(������SynchronizedTest3)
 *           ���ͣ���Ȼ�߳�1���߳�2�������Ӧ�ķ�����ʼִ�У������߳�2�ڽ���ͬ����֮ǰ����Ҫ�ȴ��߳�1��ͬ����ִ����ɡ�
 * ���н����method 1 start
			method 1 execute
			method 2 start
			method 1 end
			method 2 execute
			method 2 end

 */
public class SynchronizedTest3 {
	
	//������ͨ����method1
	public void method1() {
		
		System.out.println("method 1 start");
		try {
			synchronized(this) {
				System.out.println("method 1 execute");
				Thread.sleep(3000);
			}
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
			synchronized(this) {
				System.out.println("method 2 execute");
				Thread.sleep(1000);
			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("method 2 end");
	}

	public static void main(String[] args) {

		final SynchronizedTest3 test = new SynchronizedTest3();
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
