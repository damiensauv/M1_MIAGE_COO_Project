package util;

public interface Visitor<T>{

    public void visit(T visitable);

    public Object getResult(T visitable);
}