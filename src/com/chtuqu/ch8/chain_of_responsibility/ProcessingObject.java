package com.chtuqu.ch8.chain_of_responsibility;

public abstract class ProcessingObject<T> {

    private ProcessingObject<T> successor;

    public void setSuccessor(ProcessingObject<T> successor) {
        this.successor = successor;
    }

    public T handle(T input) {
        T result = handleWork(input);
        if (successor != null) {
            return successor.handle(result);
        }
        return result;
    }

    protected abstract T handleWork(T input);
}
