package util;

public interface Visitable<T> {

    public void accept(Visitor<T> visitor);
}