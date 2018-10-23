package com.nuturetech.safelybuy.activities;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.nuturetech.safelybuy.R;
import com.nuturetech.safelybuy.fragment.SliderWelcome1;
import com.nuturetech.safelybuy.fragment.SliderWelcome2;
import com.nuturetech.safelybuy.fragment.SliderWelcome3;
import com.nuturetech.safelybuy.fragment.SliderWelcome4;

public class WelcomeActivity extends AppCompatActivity {

    private static final int NUM_PAGES = 4;

    private ViewPager mPager;
    private PagerAdapter mPagerAdapter;
    private Button btnSkip, btnBack, btnNext, btnStart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        // Instantiate a ViewPager and a PagerAdapter.
        mPager = findViewById(R.id.view_pager);

        TabLayout tabLayout = findViewById(R.id.tab_layout);
        tabLayout.setupWithViewPager(mPager, true);

        btnSkip = findViewById(R.id.btn_skip);
        btnBack = findViewById(R.id.btn_back);
        btnNext = findViewById(R.id.btn_next);
        btnStart = findViewById(R.id.btn_start);

        // animation for the viewpager added
        //mPager.setPageTransformer(true, new ZoomOutPageTransformer());

        mPagerAdapter = new ScreenSlidePagerAdapter(getSupportFragmentManager());
        mPager.setAdapter(mPagerAdapter);

        mPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            }

            @Override
            public void onPageSelected(int position) {
                switch (position) {
                    case 0:
                        btnSkip.setVisibility(View.VISIBLE);
                        btnBack.setVisibility(View.INVISIBLE);
                        btnNext.setText("Next");
                        //SliderWelcome1.PlayGif(getBaseContext());
                        break;
                    case 1:
                        btnSkip.setVisibility(View.VISIBLE);
                        btnBack.setVisibility(View.VISIBLE);
                        btnNext.setText("Next");
                        //SliderWelcome2.PlayGif(getBaseContext());
                        break;
                    case 2:
                        btnSkip.setVisibility(View.VISIBLE);
                        btnBack.setVisibility(View.VISIBLE);
                        btnNext.setText("Next");
                        //SliderWelcome3.PlayGif(getBaseContext());
                        break;
                    case 3:
                        btnSkip.setVisibility(View.INVISIBLE);
                        btnBack.setVisibility(View.VISIBLE);
                        btnNext.setText("Got it");
                        //SliderWelcome4.PlayGif(getBaseContext());
//                        btnStart.setOnClickListener(new View.OnClickListener() {
//                            @Override
//                            public void onClick(View view) {
//                                startActivity(new Intent(WelcomeActivity.this, SignUpActivity.class));
//                                finish();
//                            }
//                        });
                        break;
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {
            }
        });

        btnSkip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                launchHomeScreeen();

            }
        });

        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mPager.getCurrentItem() == 3) {
                    launchHomeScreeen();
                } else {
                    // Otherwise, select the next step.
                    mPager.setCurrentItem(mPager.getCurrentItem() + 1,true);
                }
            }
        });

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mPager.getCurrentItem() == 0) {
                    //do nothing
                } else {
                    // Otherwise, select the previous step.
                    mPager.setCurrentItem(mPager.getCurrentItem() - 1,true);
                }
            }
        });
    }

    private void launchHomeScreeen() {
        startActivity(new Intent(WelcomeActivity.this, SignUpActivity.class));
        //SessionManager.setIsFirstTimeLaunch(false);
        finish();
    }

    @Override
    public void onBackPressed() {
        if (mPager.getCurrentItem() == 0) {
            // If the user is currently looking at the first step, allow the system to handle the
            // Back button. This calls finish() on this activity and pops the back stack.
            super.onBackPressed();
        } else {
            // Otherwise, select the previous step.
            mPager.setCurrentItem(mPager.getCurrentItem() - 1,true);
        }
    }

    private class ScreenSlidePagerAdapter extends FragmentStatePagerAdapter {
        public ScreenSlidePagerAdapter(FragmentManager supportFragmentManager) {
            super(supportFragmentManager);
        }

        @Override
        public Fragment getItem(int position) {
            switch (position) {
                case 0:
                    return new SliderWelcome1();
                case 1:
                    return new SliderWelcome2();
                case 2:
                    return new SliderWelcome3();
                case 3:
                    return new SliderWelcome4();

                default:
                    return null;
            }
        }

        @Override
        public int getCount() {
            return NUM_PAGES;
        }
    }
}
