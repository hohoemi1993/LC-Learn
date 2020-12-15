package design_pattern.chain_of_responsibility_pattern;

/**
 * 继承抽象处理者，实现统一的处理入口，
 * 将自己无法处理的请求转发给下一个处理者
 */
public class ConcreteHandler1 extends Handler<String>{

    @Override
    public void handleRequest(String request) {
        if ("A".equalsIgnoreCase(request)) {
            System.out.println("成功处理了请求：A");
        } else {
            this.successor.handleRequest(request);
        }
    }
}
