package tracker.com.security;

import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;

@Getter
@Setter
public class AuthenticatedUser extends org.springframework.security.core.userdetails.User {

    private String langKey;
    private Long id;

    public AuthenticatedUser(String username, String password, Collection<? extends GrantedAuthority> authorities) {
        super(username, password, authorities);
    }

}
