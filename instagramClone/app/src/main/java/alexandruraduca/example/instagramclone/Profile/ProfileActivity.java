package alexandruraduca.example.instagramclone.Profile;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ProgressBar;

import com.ittianyu.bottomnavigationviewex.BottomNavigationViewEx;

import java.util.ArrayList;

import alexandruraduca.example.instagramclone.R;
import alexandruraduca.example.instagramclone.Utils.BottomNavigationViewHelper;
import alexandruraduca.example.instagramclone.Utils.GridImageAdapter;
import alexandruraduca.example.instagramclone.Utils.UniversalImageLoader;

public class ProfileActivity extends AppCompatActivity {

    private static final String TAG = "ProfileActivity";
    private Context mContext = ProfileActivity.this;
    private static final int ACTIVITY_NUM = 4;
    private static final int NUM_GRID_COLUMNS = 3;

    private ProgressBar mProgressBar;
    private ImageView profilePhoto;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        Log.d(TAG, "onCreat: starting");


        setupBottomNavigationView();
        setupToolbar();
        setUpActivityWidgets();
        setProfileImage();

        tempGridSetup();
    }

    //----------------------Function definitions below---------------------------

    private void tempGridSetup(){
        ArrayList<String> imgURLs = new ArrayList<>();
        imgURLs.add("https://picsum.photos/200/300/?image=348");
        imgURLs.add("https://picsum.photos/200/300/?image=984");
        imgURLs.add("https://www.milenio.com/uploads/media/2017/04/19/asi-era-originalmente-la-familia.png");
        imgURLs.add("https://picsum.photos/200/300/?image=986");
        imgURLs.add("https://picsum.photos/300/600/?image=987");
        imgURLs.add("https://picsum.photos/200/300/?image=988");
        imgURLs.add("https://picsum.photos/200/300/?image=989");
        imgURLs.add("https://vignette.wikia.nocookie.net/simpsons/images/6/65/Bart_Simpson.png/revision/latest?cb=20180319061933");
        imgURLs.add("https://picsum.photos/200/300/?image=991");
        imgURLs.add("https://picsum.photos/200/300/?image=992");
        imgURLs.add("https://picsum.photos/200/300/?image=993");
        imgURLs.add("https://picsum.photos/200/300/?image=994");
        imgURLs.add("https://picsum.photos/200/300/?image=995");
        imgURLs.add("https://upload.wikimedia.org/wikipedia/en/thumb/0/0d/Simpsons_FamilyPicture.png/220px-Simpsons_FamilyPicture.png");

        setupImageGrid(imgURLs);

    }

    private void setupImageGrid(ArrayList<String> imgURLs){
        GridView gridView = (GridView) findViewById(R.id.gridView);

        int gridWidth = getResources().getDisplayMetrics().widthPixels;
        int imageWidth = gridWidth/NUM_GRID_COLUMNS;
        gridView.setColumnWidth(imageWidth);

        GridImageAdapter adapter = new GridImageAdapter(mContext, R.layout.layout_grid_imageview, "", imgURLs);

        gridView.setAdapter(adapter);
    }

    private void setProfileImage(){
        Log.d(TAG, "setProfileImage: setting profile photo");
        String imgURL = "https://2.bp.blogspot.com/-2ZMkSo7CnUs/WvMvSK0u9RI/AAAAAAAAFZA/zJOCZ8LUM8ol3hcHYHwVyOpc3iiYaxquACLcBGAs/s1600/Jetpack_logo.png";
        UniversalImageLoader.setImage(imgURL, profilePhoto, mProgressBar, "");
    }

    private void setUpActivityWidgets(){
        mProgressBar = (ProgressBar) findViewById(R.id.profileProgressBar);
        mProgressBar.setVisibility(View.GONE);
        profilePhoto = (ImageView) findViewById(R.id.profile_photo);
    }

    private void setupToolbar(){
        Toolbar toolbar = (Toolbar) findViewById(R.id.profileToolBar);
        setSupportActionBar(toolbar);

        ImageView profileMenu = (ImageView) findViewById(R.id.profileMenu);
        profileMenu.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Log.d(TAG, "onClick: navigating to account settings.");
                Intent intent = new Intent(mContext, AccountSettingsActivity.class);
                startActivity(intent);
            }
        });
    }

    /**
     * BottomNavigationView setup
     * */
    private void setupBottomNavigationView(){
        Log.d(TAG, "setupBottomNavigationView: setting up BottomNavigationView");
        BottomNavigationViewEx bottomNavigationViewEx = (BottomNavigationViewEx) findViewById(R.id.bottomNavViewBar);
        BottomNavigationViewHelper.setupBottomNavigationView(bottomNavigationViewEx);
        BottomNavigationViewHelper.enableNavigation(mContext, bottomNavigationViewEx);
        Menu menu = bottomNavigationViewEx.getMenu();
        MenuItem menuItem = menu.getItem(ACTIVITY_NUM);
        menuItem.setChecked(true);
    }

}
