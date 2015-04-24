package hr.example.transformpagerscroll;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ToxicBakery.viewpager.transforms.DepthPageTransformer;
import com.viewpagerindicator.TitlePageIndicator;


/**
 * A placeholder fragment containing a simple view.
 */
public class MainActivityFragment extends Fragment {

    public static MainActivityFragment newInstance() {
        return new MainActivityFragment();
    }

    public MainActivityFragment() {
    }

    SectionsPagerAdapter mSectionsPagerAdapter;
    ViewPager pager;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_main, container, false);

        mSectionsPagerAdapter = new SectionsPagerAdapter(getChildFragmentManager());
        pager = (ViewPager) view.findViewById(R.id.pager);
        pager.setOffscreenPageLimit(2);
        pager.setAdapter(mSectionsPagerAdapter);
        pager.setPageTransformer(true, new DepthPageTransformer());

        TitlePageIndicator titleIndicator = (TitlePageIndicator) view.findViewById(R.id.indicator);
        titleIndicator.setViewPager(pager);

        return view;
    }

    public class SectionsPagerAdapter extends FragmentPagerAdapter {

        public SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            switch (position) {
                case 0:
                    return RecyclerFragment.newInstance();
                case 1:
                    return RecyclerFragment.newInstance();
                case 2:
                    return RecyclerFragment.newInstance();
                default:
                    return null;
            }
        }

        @Override
        public int getCount() {
            // Show 3 total pages.
            return 3;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            switch (position) {
                case 0:
                    return "First page";
                case 1:
                    return "Second page";
                case 2:
                    return "Third page";
            }
            return null;
        }
    }
}
