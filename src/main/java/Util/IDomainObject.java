package Util;

public interface IDomainObject extends Observable, Visitable {

    public Integer getId();
    public void setId(Integer id);

}
