package bgroup.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.rememberme.PersistentTokenBasedRememberMeServices;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import bgroup.dao.UserDao;
import bgroup.model.User;


@Service("userService")
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao dao;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public User findById(int id) {
        return dao.findById(id);
    }

    public User findBySSO(String sso) {
        User user = dao.findBySSO(sso);
        return user;
    }

    public void saveUser(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        if (user.getDeleted() == null) user.setDeleted(false);
        if (user.getBlocked() == null) user.setBlocked(true);
        dao.save(user);
    }

    /*
     * Since the method is running with Transaction, No need to call hibernate update explicitly.
     * Just fetch the entity from db and update it with proper values within transaction.
     * It will be updated in db once transaction ends.
     */
    public void updateUser(User user) {
        User entity = dao.findById(user.getId());
        if (entity != null) {
            entity.setSsoId(user.getSsoId());
            /*
            Пароль меняем другим образом
             */
           /*
            if (!user.getPassword().equals(entity.getPassword())) {
                entity.setPassword(passwordEncoder.encode(user.getPassword()));
            }
             */
            entity.setFirstName(user.getFirstName());
            entity.setLastName(user.getLastName());
            entity.setPatronymicName(user.getPatronymicName());
            entity.setPhone(user.getPhone());
            if (user.getBlocked() != null) {
                entity.setBlocked(user.getBlocked());
            } else {
                entity.setBlocked(false);
            }
            if (user.getDeleted() == null) {
                entity.setDeleted(false);
            }
            //entity.setDel(user.getDel());
            entity.setEmail(user.getEmail());
            entity.setUserProfiles(user.getUserProfiles());
        }
    }

    public void deleteUserBySSO(String sso) {
        User entity = dao.findBySSO(sso);
        if (entity != null) {
            entity.setDeleted(true);
            entity = null;
        }
        //dao.deleteBySSO(sso);
    }

    public List<User> findAllUsers() {
        return dao.findAllUsers();
    }

    public boolean isUserSSOUnique(Integer id, String sso) {
        User user = findBySSO(sso);
        return (user == null || ((id != null) && (user.getId() == id)));
    }

}
