package testing;

import org.springframework.stereotype.Repository;

@Repository
public class UserRepositoryImpl implements UserRepository {

    @Override
    public String findUserNameById(int id) {
        return "FetchedUser001";
    }
}
