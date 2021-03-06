package edu.galileo.android.androidchat.contactlist;

import com.firebase.client.ChildEventListener;
import com.firebase.client.DataSnapshot;
import com.firebase.client.FirebaseError;

import edu.galileo.android.androidchat.contactlist.events.ContactListEvent;
import edu.galileo.android.androidchat.domain.FirebaseHelper;
import edu.galileo.android.androidchat.entities.User;
import edu.galileo.android.androidchat.lib.EventBus;
import edu.galileo.android.androidchat.lib.GreenRobotEventBus;

/**
 * Created by nacheteam on 10/06/16.
 */
public class ContactListRepositoryImpl implements ContactListRepository {

    private FirebaseHelper helper;
    private ChildEventListener contactEventListener;
    private EventBus eventBus;

    public ContactListRepositoryImpl() {

        this.eventBus = GreenRobotEventBus.getInstance();
        this.helper = FirebaseHelper.getInstance();
    }

    @Override
    public void signOff() {
        helper.signOff();
    }

    @Override
    public String getCurrentUserEmail() {
        return helper.getAuthUserEmail();
    }

    @Override
    public void removeContact(String email) {
        String currentUserEmail = helper.getAuthUserEmail();
        helper.getOneContactReference(currentUserEmail, email).removeValue();
        helper.getOneContactReference(email, currentUserEmail).removeValue();
    }

    @Override
    public void subscribeToContactListEvents() {
        if(contactEventListener==null)
        {
            contactEventListener = new ChildEventListener() {
                @Override
                public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                    handleContact(dataSnapshot, ContactListEvent.OnContactAdded);
                }

                @Override
                public void onChildChanged(DataSnapshot dataSnapshot, String s) {
                    handleContact(dataSnapshot, ContactListEvent.OnContactChanged);
                }

                @Override
                public void onChildRemoved(DataSnapshot dataSnapshot) {
                    handleContact(dataSnapshot, ContactListEvent.OnContactRemoved);
                }

                @Override
                public void onChildMoved(DataSnapshot dataSnapshot, String s) {}

                @Override
                public void onCancelled(FirebaseError firebaseError) {}
            };
        }
        else
        {
            helper.getMyContactsReference().addChildEventListener(contactEventListener);
        }
    }

    private void handleContact(DataSnapshot dataSnapshot, int type) {
        String email = dataSnapshot.getKey();
        email = email.replace("_", ".");
        boolean online = ((Boolean) dataSnapshot.getValue()).booleanValue();
        User user = new User();
        user.setEmail(email);
        user.setOnline(online);
        post(type, user);
    }

    private void post(int type, User user) {
        ContactListEvent event = new ContactListEvent();
        event.setEventType(type);
        event.setUser(user);
        eventBus.post(event);
    }

    @Override
    public void unsubscribeToContactListEvents() {
        if(contactEventListener!=null)
        {
            helper.getMyContactsReference().removeEventListener(contactEventListener);
        }
    }

    @Override
    public void destroyListener() {
        contactEventListener = null;
    }

    @Override
    public void changeConnectionStatus(boolean online) {

    }
}
