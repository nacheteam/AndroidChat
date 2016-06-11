package edu.galileo.android.androidchat.addcontact;

/**
 * Created by nacheteam on 11/06/16.
 */
public class AddContactInteractorImpl implements AddContactInteractor {

    AddContactRepository repository;

    public AddContactInteractorImpl() {
        this.repository = new AddContactRepositoryImpl();
    }

    @Override
    public void execute(String email) {
        repository.addContact(email);
    }
}
