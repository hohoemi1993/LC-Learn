package design_pattern.chain_of_responsibility_pattern;

/**
 * 所有具体处理者的父类，
 * 一般定义为抽象类，
 * 定义了一个统一的处理入口，以及维持了一个抽象处理者类型对象的引用，用于形成链式处理者
 */
public abstract class Handler<T> {
    protected Handler<T> successor;

    public void setSuccessor(Handler<T> successor) {
        this.successor = successor;
    }

    public abstract void handleRequest(T request);


}
