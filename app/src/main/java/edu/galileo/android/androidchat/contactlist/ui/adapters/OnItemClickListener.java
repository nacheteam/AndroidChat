package edu.galileo.android.androidchat.contactlist.ui.adapters;

import edu.galileo.android.androidchat.entities.User;

/**
 * Created by nacheteam on 10/06/16.
 */
public interface OnItemClickListener {

    void onItemClick(User user);
    void onItemLongClick(User user);

}
