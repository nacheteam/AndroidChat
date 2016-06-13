package edu.galileo.android.androidchat.chat;

/**
 * Created by nacheteam on 12/06/16.
 */
public class ChatSessionInteractorImpl implements ChatSessionInteractor {

    ChatRepository repository;

    public ChatSessionInteractorImpl() {
        this.repository = new ChatRepositoryImpl();
    }

    @Override
    public void changeConnectionStatus(boolean online) {
        repository.onChangeConnectionStatus(online);
    }
}
