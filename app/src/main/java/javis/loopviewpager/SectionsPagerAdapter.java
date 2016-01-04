package javis.loopviewpager;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

/**
 * Created by Jeffrey Liu on 12/30/15.
 * A {@link FragmentPagerAdapter} that returns a fragment corresponding to
 * one of the sections/tabs/pages.
 */
public class SectionsPagerAdapter extends FragmentPagerAdapter {
    private static final String TAG = "SectionsPagerAdapter";
    boolean isInfiniteLoop = false;
    List<DisplayItem> list;

    public SectionsPagerAdapter(FragmentManager fm, List<DisplayItem> inputTextList, boolean isInfiniteLoop) {
        super(fm);
        list = inputTextList;
        this.isInfiniteLoop = isInfiniteLoop;
    }

    @Override
    public Fragment getItem(int position) {
        // getItem is called to instantiate the fragment for the given page.
        // Return a PlaceholderFragment (defined as a static inner class below).
        return PlaceholderFragment.newInstance(
                list.get(isInfiniteLoop ? getIndex(position, list.size()) : position).getText(),
                list.get(isInfiniteLoop ? getIndex(position, list.size()) : position).getColor()
        );
    }

    @Override
    public int getCount() {
        return isInfiniteLoop ? Integer.MAX_VALUE : list.size();
    }

    public static int getIndex(int position, int listSize) {
        int newPosition = position - Integer.MAX_VALUE / 2;
        if (newPosition >= 0) {
            newPosition = newPosition % listSize;
        } else {
            newPosition = newPosition * -1;
            newPosition = newPosition % listSize;
            newPosition = listSize - newPosition;
            if (newPosition >= listSize)
                newPosition = 0;
        }
        return newPosition;
    }
}
