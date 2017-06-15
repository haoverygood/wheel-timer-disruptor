package org.throwable.wheel;


/**
 * =========================================================
 * 北京五八信息技术有限公司架构部
 *
 * @author chenyang    E-mail: chenyang@58.com
 * @version Created ：2014-1-17 下午05:37:33
 * 类说明：
 * =========================================================
 * 修订日期	修订人	描述
 */
public class Main {

    public static void main(String[] args) throws Exception {
        final Wheel<String> wheel = Wheel.getInstance(13);

        wheel.addExpirationIntecepter(e -> System.err.println("release element : " + e));

        wheel.add("hello2", 2);
        wheel.add("hello3", 3);

        Thread.sleep(Integer.MAX_VALUE);
    }

}
