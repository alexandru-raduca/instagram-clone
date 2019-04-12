package alexandruraduca.example.instagramclone.Profile;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.nostra13.universalimageloader.core.ImageLoader;

import alexandruraduca.example.instagramclone.R;
import alexandruraduca.example.instagramclone.Utils.UniversalImageLoader;

public class EditProfileFragment extends Fragment {

    private static final String TAG = "EditProfileFragment";
    private ImageView mProfilePhoto;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_editprofile, container, false);
        mProfilePhoto = (ImageView) view.findViewById(R.id.profile_photo);

        Log.d(TAG, "onCreateView: EditProfileFragment");

        setProfileImage();

        //back arrow for avigating back to "ProfileActivity"
        ImageView backArrow = (ImageView) view.findViewById(R.id.backArrow);
        backArrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d(TAG, "onClick: navigating back to ProfileActivity");
                getActivity().finish();
            }
        });
        return view;
    }



    private void setProfileImage(){
        Log.d(TAG, "serProfileImage: setting profile image");
        String imgURL = "https://2.bp.blogspot.com/-2ZMkSo7CnUs/WvMvSK0u9RI/AAAAAAAAFZA/zJOCZ8LUM8ol3hcHYHwVyOpc3iiYaxquACLcBGAs/s1600/Jetpack_logo.png";

        UniversalImageLoader.setImage(imgURL, mProfilePhoto, null, "");
    }
}
