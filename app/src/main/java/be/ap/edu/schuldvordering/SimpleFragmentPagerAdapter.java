package be.ap.edu.schuldvordering;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class SimpleFragmentPagerAdapter extends FragmentPagerAdapter {

    private Context mContext;

    public SimpleFragmentPagerAdapter(Context context, FragmentManager fm) {
        super(fm);
        mContext = context;
    }

    // This determines the fragment for each tab
    @Override
    public Fragment getItem(int position) {
        if (position == 0) {
            return new VerplaatsingenActivity();
        } else if (position == 1){
            return new VerblijvenActivity();
        } else if (position == 2){
            return new HotelsActivity();
        } else {
            return new OverigenActivity();
        }
    }

    // This determines the number of tabs
    @Override
    public int getCount() {
        return 4;
    }
}