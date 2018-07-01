# Synchronized关键字

  Synchronized是Java中解决并发问题的一种最常用的方法，也是最简单的一种方法。

## 作用
* 确保线程互斥的访问同步代码
* 保证共享变量的修改能够及时可见
* 有效解决重排序问题

## 用法
* 修饰普通方法(见程序[SynchronizedTest1](https://github.com/amateur-RD/Coding-Test/com/cy/synchronizedTest/SynchronizedTest1.java))
* 修饰静态方法(类)(见程序[SynchronizedTest2](https://github.com/amateur-RD/Coding-Test/com/cy/synchronizedTest/SynchronizedTest2.java))
* 修饰代码块(见程序[SynchronizedTest3](https://github.com/amateur-RD/Coding-Test/com/cy/synchronizedTest/SynchronizedTest3.java))

## 原理
* 同步代码块
  * 每个对象有一个监视器锁（monitor）。当monitor被占用时就会处于锁定状态，线程执行monitorenter指令时尝试获取monitor的所有权，过程如下：
    * 如果monitor的进入数为0，则该线程进入monitor，然后将进入数设置为1，该线程即为monitor的所有者。
    * 如果线程已经占有该monitor，只是重新进入，则进入monitor的进入数加1.
    * 如果其他线程已经占用了monitor，则该线程进入阻塞状态，直到monitor的进入数为0，再重新尝试获取monitor的所有权。
    * 执行monitorexit的线程必须是objectref所对应的monitor的所有者。
    * 指令执行时，monitor的进入数减1，如果减1后进入数为0，那线程退出monitor，不再是这个monitor的所有者。其他被这个monitor阻塞的线程可以尝试去获取这个 monitor 的所有权。
  * 我们应该能很清楚的看出 Synchronized的实现原理
    * Synchronized的语义底层是通过一个monitor的对象来完成，其实wait/notify等方法也依赖于monitor对象，这就是为什么只有在同步的块或者方法中才能调用wait/notify等方法，否则会抛出java.lang.IllegalMonitorStateException的异常的原因。
* 同步方法
  * 方法的同步并没有通过指令monitorenter和monitorexit来完成（理论上其实也可以通过这两条指令来实现），不过相对于普通方法，其常量池中多了ACC_SYNCHRONIZED标示符。JVM就是根据该标示符来实现方法的同步的：当方法调用时，调用指令将会检查方法的 ACC_SYNCHRONIZED 访问标志是否被设置，如果设置了，执行线程将先获取monitor，获取成功之后才能执行方法体，方法执行完后再释放monitor。在方法执行期间，其他任何线程都无法再获得同一个monitor对象。 其实本质上没有区别，只是方法的同步是一种隐式的方式来实现，无需通过字节码来完成。 
* 程序解释
  * 程序SynchronizedTest1结果： 虽然method1和method2是不同的方法，但是这两个方法都进行了同步，并且是通过同一个对象去调用的，所以调用之前都需要先去竞争同一个对象上的锁（monitor），也就只能互斥的获取到锁，因此，method1和method2只能顺序的执行。
  * 程序SynchronizedTest2结果： 虽然test和test2属于不同对象，但是test和test2属于同一个类的不同实例，由于method1和method2都属于静态同步方法，所以调用的时候需要获取同一个类上monitor（每个类只对应一个class对象），所以也只能顺序的执行。
  * 程序SynchronizedTest3结果： 对于代码块的同步实质上需要获取Synchronized关键字后面括号中对象的monitor，由于这段代码中括号的内容都是this，而method1和method2又是通过同一的对象去调用的，所以进入同步块之前需要去竞争同一个对象上的锁，因此只能顺序执行同步块。




* Web访问
  * [noVNC](https://github.com/novnc/noVNC)工具实现在线Web访问虚拟机
* 系统实现
  * Java ssh2(Struts2 + Spring + Hibernate)实现整个系统的构建
* 体系结构<br>
  ![系统体系结构](https://github.com/amateur-RD/Embedded-Virtual-Online-System/raw/master/系统截图/体系结构.png)

## 技术路线
* 虚拟化
  * Docker工具实现服务器虚拟化
* Web访问
  * [noVNC](https://github.com/novnc/noVNC)工具实现在线Web访问虚拟机
* 系统实现
  * Java ssh2(Struts2 + Spring + Hibernate)实现整个系统的构建
* 体系结构<br>
  ![系统体系结构](https://github.com/amateur-RD/Embedded-Virtual-Online-System/raw/master/系统截图/体系结构.png)
