package com.example.dell.navbot;

import android.app.ActionBar;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private DrawerLayout dl;
    private ActionBarDrawerToggle t;
    private NavigationView nv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView recyclerView=(RecyclerView)findViewById(R.id.list_recycler);
        Itemdata itemdata[]={
                new Itemdata("first","this is first picture in my app","detail2","number worker",R.drawable.a),
                new Itemdata("scont","this type to show for you that i can make racycler view without use a picture","detail2","number worker",1000),
                new Itemdata("first","this is first picture in my app","detail2","number worker",R.drawable.c),
                new Itemdata("scont","this type to show for you that i can make racycler view without use a picture","detail2","number worker",1000),
                new Itemdata("first","this is first picture in my app","detail2","number worker",R.drawable.a),
                new Itemdata("scont","this is first picture in my app","detail2","number worker",R.drawable.b),
                new Itemdata("first","this is first picture in my app","detail2","number worker",R.drawable.c),
                new Itemdata("scont","this is first picture in my app","detail2","number worker",R.drawable.d),
                new Itemdata("first","this is first picture in my app","detail2","number worker",R.drawable.a),
                new Itemdata("scont","this is first picture in my app","detail2","number worker",R.drawable.b),
                new Itemdata("first","this is first picture in my app","detail2","number worker",R.drawable.c),
                new Itemdata("scont","this is first picture in my app","detail2","number worker",R.drawable.d),
                new Itemdata("thread","this is first picture in my app","detail2","number worker",R.drawable.s)
        };

        //new gridLayoutManager(this,2)
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        MyAdapter myAdapter=new MyAdapter(itemdata,MainActivity.this,1);
        recyclerView.setAdapter(myAdapter);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        // Intent intent = new Intent(this, login.class);
        // startActivity(intent);
        //////////navigation///////////
            dl = (DrawerLayout) findViewById(R.id.activity_main);
            t = new ActionBarDrawerToggle(this, dl, R.string.Open, R.string.Close);
            setTitle("");
            dl.addDrawerListener(t);
            t.syncState();
            getSupportActionBar().hide();
            nv = (NavigationView) findViewById(R.id.nv);
           // dl.openDrawer(nv);
            //nv.inflateMenu(R.menu.menu_nav);
           /* nv.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
               /* @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                    int id = item.getItemId();
                  /*  switch (id) {
                        case R.id.account:
                            Toast.makeText(MainActivity.this, "My Account", Toast.LENGTH_SHORT).show();
                            break;
                        case R.id.settings:
                            Toast.makeText(MainActivity.this, "Settings", Toast.LENGTH_SHORT).show();
                            break;
                        case R.id.mycart:
                            Toast.makeText(MainActivity.this, "My Cart", Toast.LENGTH_SHORT).show();
                            break;
                        default:
                            return true;
                    }


                    return true;

                }
            });*/
        ////////////////////


    }

    public void profile(MenuItem item) {
        Intent intent = new Intent(getApplicationContext(), profile.class);
        // startActivity(intent);
        startActivityForResult(intent, 0);
        finish();
        overridePendingTransition(R.anim.push_left_in, R.anim.push_left_out);
    }

    public void home(MenuItem item) {
        try {
            Intent intent = new Intent(getApplicationContext(), MainActivity.class);
            // startActivity(intent);
            startActivityForResult(intent, 0);
            finish();
            overridePendingTransition(R.anim.push_left_in, R.anim.push_left_out);
        }catch (Exception e){}
    }

    public void notify(MenuItem item) {
        Toast.makeText(getApplicationContext(),"( setting )",Toast.LENGTH_SHORT).show();

    }
   /* public void side_navigation(MenuItem item) {
        dl.openDrawer(nv);
    }*/
        /////////.....navigation/////////

   /* @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_nav,menu);
        return  true;
    }*/

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if(t.onOptionsItemSelected(item))
            return true;

        return super.onOptionsItemSelected(item);
    }



    public void posts_company(MenuItem item)
    {
        RecyclerView recyclerView=(RecyclerView)findViewById(R.id.list_recycler);
        Itemdata itemdata[]={
                new Itemdata("first","this is first picture in my app","detail2","number worker",R.drawable.a),
                new Itemdata("scont","this type to show for you that i can make racycler view without use a picture","detail2","number worker",1000),
                new Itemdata("first","this is first picture in my app","detail2","number worker",R.drawable.c),
                new Itemdata("scont","this type to show for you that i can make racycler view without use a picture","detail2","number worker",1000),
                new Itemdata("first","this is first picture in my app","detail2","number worker",R.drawable.a),
                new Itemdata("scont","this is first picture in my app","detail2","number worker",R.drawable.b),
                new Itemdata("first","this is first picture in my app","detail2","number worker",R.drawable.c),
                new Itemdata("scont","this is first picture in my app","detail2","number worker",R.drawable.d),
                new Itemdata("first","this is first picture in my app","detail2","number worker",R.drawable.a),
                new Itemdata("scont","this is first picture in my app","detail2","number worker",R.drawable.b),
                new Itemdata("first","this is first picture in my app","detail2","number worker",R.drawable.c),
                new Itemdata("scont","this is first picture in my app","detail2","number worker",R.drawable.d),
                new Itemdata("thread","this is first picture in my app","detail2","number worker",R.drawable.s)
        };

        //new gridLayoutManager(this,2)
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        MyAdapter myAdapter=new MyAdapter(itemdata,MainActivity.this,1);
        recyclerView.setAdapter(myAdapter);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        dl.closeDrawers();
        dl.animate();
    }
    public void worker_profile(MenuItem item)
    {
        RecyclerView recyclerView=(RecyclerView)findViewById(R.id.list_recycler);
        Itemdata_profile itemdata_pro[]={
                new Itemdata_profile("Mahmoud Tantora","Syria","enginring software",R.drawable.a),
                new Itemdata_profile("Ammar Kiali","Syria","enginring software",R.drawable.s),
                new Itemdata_profile("Mohammad Ali","Syria","enginring software",R.drawable.c),
                new Itemdata_profile("Ali Mahmoud","Syria","enginring software",R.drawable.d),
                new Itemdata_profile("Ahmad Saeed","Syria","enginring software",R.drawable.a),
                new Itemdata_profile("Zaeed Al_Ahmad","Syria","enginring software",R.drawable.b),
                new Itemdata_profile("Abo Baker","Syria","enginring software",R.drawable.c),
                new Itemdata_profile("Abo Zaeed","Syria","enginring software",R.drawable.d),
                new Itemdata_profile("Mohmmad Kialy","Syria","enginring software",R.drawable.a),
                new Itemdata_profile("Khalid Al_Yousf","Syria","enginring software",R.drawable.b),
                new Itemdata_profile("Maohmmad Al_Aliway","Syria","enginring software",R.drawable.c),
                new Itemdata_profile("Diaa Omar","Syria","enginring software",R.drawable.d),
                new Itemdata_profile("Abd Al_kareem","Syria","enginring software",R.drawable.s)
        };
        //new GridLayoutManager(this,2)
        recyclerView.setLayoutManager(new GridLayoutManager(this,2));
        My_Adapter_Profile myAdapter=new My_Adapter_Profile(itemdata_pro,MainActivity.this);
        recyclerView.setAdapter(myAdapter);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        dl.closeDrawers();
        dl.animate();
    }

    public void project(MenuItem item)
    {
        RecyclerView recyclerView=(RecyclerView)findViewById(R.id.list_recycler);
        itemdata_project[] projects={
                new itemdata_project("Mahmoud Tantora","1000$","enginring software",R.drawable.a),
                new itemdata_project("Ammar Kiali","200$","enginring software",R.drawable.s),
                new itemdata_project("Mohammad Ali","300$","enginring software",R.drawable.c),
                new itemdata_project("Ali Mahmoud","1500$","enginring software",R.drawable.d),
                new itemdata_project("Ahmad Saeed","2500$","enginring software",R.drawable.a),
                new itemdata_project("Zaeed Al_Ahmad","100$","enginring software",R.drawable.b),
                new itemdata_project("Abo Baker","3200$","enginring software",R.drawable.c),
                new itemdata_project("Abo Zaeed","2500$","enginring software",R.drawable.d),
                new itemdata_project("Mohmmad Kialy","2500$","enginring software",R.drawable.a),
                new itemdata_project("Khalid Al_Yousf","2500$","enginring software",R.drawable.b),
                new itemdata_project("Maohmmad Al_Aliway","2500$","enginring software",R.drawable.c),
                new itemdata_project("Diaa Omar","2500$","enginring software",R.drawable.d),
                new itemdata_project("Abd Al_kareem","2500$","enginring software",R.drawable.s)
        };
        //new GridLayoutManager(this,2)
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        My_Adapter_project myAdapter=new My_Adapter_project(projects,MainActivity.this);
        recyclerView.setAdapter(myAdapter);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        dl.closeDrawers();
        dl.animate();
    }

    public void company(MenuItem item)
    {
        RecyclerView recyclerView=(RecyclerView)findViewById(R.id.list_recycler);
        Itemdata_profile itemdata_pro[]={
                new Itemdata_profile("Al Borak","Syria","enginring software",R.drawable.a),
                new Itemdata_profile("Al Mostaql","Syria","enginring software",R.drawable.s),
                new Itemdata_profile("Antaliq","Syria","enginring software",R.drawable.c),
                new Itemdata_profile("Google","Syria","enginring software",R.drawable.d),
                new Itemdata_profile("Yahoo","Syria","enginring software",R.drawable.a),
                new Itemdata_profile("Amazon","Syria","enginring software",R.drawable.b),
                new Itemdata_profile("Samsung","Syria","enginring software",R.drawable.c),
                new Itemdata_profile("Hwawy","Syria","enginring software",R.drawable.d),
                new Itemdata_profile("Kialy","Syria","enginring software",R.drawable.a),
                new Itemdata_profile("Orange","Syria","enginring software",R.drawable.b),
                new Itemdata_profile("Maohmmad Al_Aliway","Syria","enginring software",R.drawable.c),
                new Itemdata_profile("Diaa Omar","Syria","enginring software",R.drawable.d),
                new Itemdata_profile("Abd Al_kareem","Syria","enginring software",R.drawable.s)
        };
        //new GridLayoutManager(this,2)
        recyclerView.setLayoutManager(new GridLayoutManager(this,2));
        My_Adapter_Profile myAdapter=new My_Adapter_Profile(itemdata_pro,MainActivity.this);
        recyclerView.setAdapter(myAdapter);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        dl.closeDrawers();
        dl.animate();
    }

    public void groups(MenuItem item) {
        dl.closeDrawers();
        dl.animate();
    }

    public void log_out(MenuItem item) {
        dl.closeDrawers();
        dl.animate();
    }

    public void settings(MenuItem item)
    {
        dl.closeDrawers();
        dl.animate();
    }




    //////////////////////////////////


}
