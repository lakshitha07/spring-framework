package componentscanning;

import org.springframework.stereotype.Repository;

@Repository
public class AccountRepositoryImpl implements AccountRepository {

    @Override
    public void save() {
        System.out.println("persisting the transaction!");
    }
}
