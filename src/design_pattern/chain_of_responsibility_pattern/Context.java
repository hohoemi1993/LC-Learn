package design_pattern.chain_of_responsibility_pattern;

public class Context<T> {

    private Handler<T> head;

    private Handler<T> tail;

    public void addLast(Handler<T> handler) {
        tail.setSuccessor(handler);
        tail = handler;
    }

    public Handler<T> getChain() {
        return head;
    }
}
