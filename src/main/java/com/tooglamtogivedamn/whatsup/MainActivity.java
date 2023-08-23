package com.tooglamtogivedamn.whatsup;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Switch;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.tooglamtogivedamn.whatsup.Adapters.FragmentsAdapter;
import com.tooglamtogivedamn.whatsup.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;
    FirebaseAuth auth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityMainBinding.inflate(getLayoutInflater());
        View view=binding.getRoot();
        setContentView(view);

        auth=FirebaseAuth.getInstance();

        binding.viewPager.setAdapter(new FragmentsAdapter(getSupportFragmentManager()));
        binding.tabLayout.setupWithViewPager(binding.viewPager);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater=getMenuInflater();
        inflater.inflate(R.menu.menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId())
    {
        case R.id.settings:
            Intent intent2=new Intent(MainActivity.this,SettingsActivity.class);
            startActivity(intent2);
            break;
        case R.id.logout:
            auth.signOut();
            Intent intent =new Intent(MainActivity.this,SignInActivity.class);
            startActivity(intent);
            break;
        case R.id.groupChat:
            Intent intent1 =new Intent(MainActivity.this,GroupChatActivity.class);
            startActivity(intent1);
            break;
        }
        return true;
    }
}