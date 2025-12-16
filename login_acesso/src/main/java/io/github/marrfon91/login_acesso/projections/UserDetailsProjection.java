package io.github.marrfon91.login_acesso.projections;

public interface UserDetailsProjection {

    String getUserName();
    String getPassWord();
    Long getRoleId();
    String getAuthority();
}
