package jp.co.ss_ave.auto_start_button_disabled_menu;

import android.app.Activity;
import android.app.ListActivity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends Activity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
//        setSupportActionBar(toolbar);

//        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
//            }
//        });

        //buttonを取得
        findViewById(R.id.Button01).setOnClickListener(this);
        findViewById(R.id.Button02).setOnClickListener(this);
        findViewById(R.id.Button03).setOnClickListener(this);
        findViewById(R.id.Button04).setOnClickListener(this);
        findViewById(R.id.Button05).setOnClickListener(this);

//        //クラス名取得
//        Intent it = new Intent(Intent.ACTION_MAIN, null);
//        it.addCategory(Intent.CATEGORY_LAUNCHER);
//        PackageManager pManager = getPackageManager();
//        List<ResolveInfo> appList =  pManager.queryIntentActivities(it,0);
//        Collections.sort(appList,new ResolveInfo.DisplayNameComparator(pManager));
//        //Dataにして
//        String textdata = "";
//        for (ResolveInfo info : appList) {
//            textdata = textdata + info.activityInfo.name +"\n";
//        }
//        //暗黙のintentでデータを投げる
//        Intent intent = new Intent();
//        intent.setAction(Intent.ACTION_SEND);
//        intent.putExtra(Intent.EXTRA_TEXT, textdata);
//        intent.setType( "text/plain" );
//        startActivity(intent);
//
//        Log.d("_test_",textdata);

    }



    public void onClick(View v) {
        PackageManager pm = getPackageManager();
        Intent intent = new Intent();

        // 各アプリ起動
        if(v != null){
            switch(v.getId()){
                case R.id.Button01:
                    intent = pm.getLaunchIntentForPackage("com.android.calculator2");
                    break;

                case R.id.Button02:
                    intent = pm.getLaunchIntentForPackage("com.android.calendar");
                    break;

                case R.id.Button03:
                    intent = pm.getLaunchIntentForPackage("com.android.settings");
                    break;

                case R.id.Button04:
                    intent = new Intent(getApplication(), jp.co.ss_ave.auto_start_button_disabled_menu.ListActivity.class);
                    break;

                case R.id.Button05:


                    break;
            }
        }

        try{
            startActivity(intent);
        }catch(Exception e){
            Toast.makeText(MainActivity.this, "対象のアプリがありません", Toast.LENGTH_SHORT).show();

        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {
        // ホームアプリのため、戻るボタン無効
    }

    protected void onActivityResult( int requestCode, int resultCode, Intent intent) {
        super.onActivityResult(requestCode, resultCode, intent);

        if(resultCode == RESULT_OK && null != intent) {
            String res = intent.getStringExtra("appName");
            Toast.makeText(MainActivity.this, res, Toast.LENGTH_SHORT).show();
        }
    }



}