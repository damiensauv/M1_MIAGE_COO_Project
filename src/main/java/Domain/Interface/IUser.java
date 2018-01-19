package Domain.Interface;

import Util.IDomainObject;

public interface IUser extends IDomainObject {

    public String getUsername();

    public void setUsername(String username);

    public String getPassword();

    public void setPassword(String password);


}
