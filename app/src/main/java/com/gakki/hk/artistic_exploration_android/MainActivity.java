package com.gakki.hk.artistic_exploration_android;

import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.gakki.hk.artistic_exploration_android.animation.AnimationFragment;
import com.gakki.hk.artistic_exploration_android.intent_filter.IntentFilterFragment;
import com.gakki.hk.artistic_exploration_android.ipc.IpcFragment;
import com.gakki.hk.artistic_exploration_android.view_event_mechanism.ViewEventMechanismFragment;
import com.gakki.hk.artistic_exploration_android.view_theory.ViewTheoryFragment;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initFragments();

        switchFragment(4);
    }

    private void initView() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private Fragment[] fragments;
    private int currentTabIndex;

    /**
     * 初始化Fragments
     */
    private void initFragments() {

        IntentFilterFragment activityFragment = IntentFilterFragment.newInstance();
        IpcFragment ipcFragment = IpcFragment.newInstance();
        ViewEventMechanismFragment viewEventFragment = ViewEventMechanismFragment.newInstance();
        ViewTheoryFragment viewTheoryFragment = ViewTheoryFragment.newInstance();
        AnimationFragment animationFragment = AnimationFragment.newInstance();

        fragments = new Fragment[]{
                activityFragment,
                ipcFragment,
                viewEventFragment,
                viewTheoryFragment,
                animationFragment,
                activityFragment,
                activityFragment,
                activityFragment,
                activityFragment,
                activityFragment,
                activityFragment,
                activityFragment,
                activityFragment
        };

        getSupportFragmentManager().beginTransaction().add(R.id.container, activityFragment).show(activityFragment).commit();
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.nav_activity:
                switchFragment(0);
                break;
            case R.id.nav_ipc:
                switchFragment(1);
                break;
            case R.id.nav_view_touch:
                switchFragment(2);
                break;
            case R.id.nav_view_principle:
                switchFragment(3);
                break;
            case R.id.nav_remote_views:
                switchFragment(4);
                break;
            case R.id.nav_drawable:
                switchFragment(5);
                break;
            case R.id.nav_animation:
                switchFragment(6);
                break;
            case R.id.nav_window:
                switchFragment(7);
                break;
            case R.id.nav_four_component:
                switchFragment(8);
                break;
            case R.id.nav_handler:
                switchFragment(9);
                break;
            case R.id.nav_thread:
                switchFragment(10);
                break;
            case R.id.nav_bitmap:
                switchFragment(11);
                break;
            case R.id.nav_performance:
                switchFragment(12);
                break;
        }

        item.setChecked(true);
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    /**
     * Fragment切换
     * @param index
     */
    private void switchFragment(int index) {
        FragmentTransaction trx = getSupportFragmentManager().beginTransaction();
        trx.hide(fragments[currentTabIndex]);

        Fragment fragment = fragments[index];
        if (!fragment.isAdded()) {
            trx.add(R.id.container, fragment);
        }
        trx.show(fragment).commit();
        currentTabIndex = index;
    }


}
