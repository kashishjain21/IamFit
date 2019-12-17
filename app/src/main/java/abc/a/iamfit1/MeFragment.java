package abc.a.iamfit1;


import android.media.Image;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.UserInfo;
import com.squareup.picasso.Picasso;

import org.w3c.dom.Text;

import java.util.Objects;

import static com.firebase.ui.auth.AuthUI.getApplicationContext;


/**
 * A simple {@link Fragment} subclass.
 */
public class MeFragment extends Fragment {

    TextView textView;
    ImageView profilepic;
    TextView username;
    FirebaseAuth firebaseAuth;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View rootView = inflater.inflate(R.layout.fragment_me, container, false);
        profilepic = rootView.findViewById(R.id.imageView1);
        username = rootView.findViewById(R.id.username);
        textView = rootView.findViewById(R.id.textView);

        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        if (user != null) {
            // User is signed in
            String displayName = user.getDisplayName();
            Uri profileUri = user.getPhotoUrl();

            // If the above were null, iterate the provider data
            // and set with the first non null data
            for (UserInfo userInfo : user.getProviderData()) {
                if (displayName == null && userInfo.getDisplayName() != null) {
                    displayName = userInfo.getDisplayName();
                }
                if (profileUri == null && userInfo.getPhotoUrl() != null) {
                    profileUri = userInfo.getPhotoUrl();
                }
            }

            username.setText(displayName);
            if (profileUri != null) {
                Picasso.with(getContext())
                        .load(profileUri)
                        .error(R.drawable.common_google_signin_btn_icon_disabled)
                        .into(profilepic);
            }


        }


        /*if(Objects.requireNonNull(FirebaseAuth.getInstance().getCurrentUser()).getPhotoUrl()!=null)
        {
            Picasso.with(getContext())
                    .load(FirebaseAuth.getInstance().getCurrentUser().getPhotoUrl())
                    .error(R.drawable.common_google_signin_btn_icon_disabled)
                    .into(profilepic);
        }
        if(FirebaseAuth.getInstance().getCurrentUser().getDisplayName()!=null)
        {
            username.setText(Objects.requireNonNull(FirebaseAuth.getInstance().getCurrentUser().getDisplayName()));
        }*/
        return rootView;
    }
}
