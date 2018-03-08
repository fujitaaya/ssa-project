package jp.co.ss_ave.auto_start_button_disabled_menu;

import android.app.Activity;
import android.app.ListActivity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Icon;
import android.media.Image;
import android.os.Bundle;
import android.os.Parcelable;
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
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity implements View.OnClickListener {

    final int button01 = 0;
    final int button02 = 1;
    final int button03 = 2;
    final int button04 = 3;
    final int iniCheck = 999;

    public Intent shortcutIntent = null;


    int clickCheck = iniCheck;
    boolean[] buttonFlag = new boolean[4];


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
//        ImageButton button = (ImageButton) findViewById(R.id.Button01);
        findViewById(R.id.Button01).setOnClickListener(this);
        findViewById(R.id.Button02).setOnClickListener(this);
        findViewById(R.id.Button03).setOnClickListener(this);
        findViewById(R.id.Button04).setOnClickListener(this);
//        findViewById(R.id.Button05).setOnClickListener(this);



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
                    if(buttonFlag[button01] == false){
                        intent = new Intent(getApplication(), jp.co.ss_ave.auto_start_button_disabled_menu.ListActivity.class);
                        buttonCheck(button01);
                        clickCheck = button01;
                        startActivityForResult(intent, 1);
                    }else{
                        intent = shortcutIntent;
                    }
                    break;

                case R.id.Button02:
                    if(buttonFlag[button02] == false){
                        intent = new Intent(getApplication(), jp.co.ss_ave.auto_start_button_disabled_menu.ListActivity.class);
                        buttonCheck(button02);
                        clickCheck = button02;
                        startActivityForResult(intent, 1);
                    }else{
                        intent = shortcutIntent;
                    }
                    break;

                case R.id.Button03:
                    if(buttonFlag[button03] == false){
                        intent = new Intent(getApplication(), jp.co.ss_ave.auto_start_button_disabled_menu.ListActivity.class);
                        buttonCheck(button03);
                        clickCheck = button03;
                        startActivityForResult(intent, 1);
                    }else{
                        intent = shortcutIntent;
                    }
                    break;

                case R.id.Button04:
                    if(buttonFlag[button04] == false){
                        intent = new Intent(getApplication(), jp.co.ss_ave.auto_start_button_disabled_menu.ListActivity.class);
                        buttonCheck(button04);
                        clickCheck = button04;
                        startActivityForResult(intent, 1);
                    }else{
                        intent = shortcutIntent;
                    }
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

        PackageManager pm = getPackageManager();

        if(resultCode == RESULT_OK && null != intent) {

            Bitmap icon =  (Bitmap) intent.getExtras().get("icon");

            if(clickCheck != iniCheck){
                switch (clickCheck){
                    case button01:
                        ((ImageButton)findViewById(R.id.Button01)).setImageBitmap(icon);
                        ((ImageButton)findViewById(R.id.Button01)).setBackground(null);
                        break;

                    case button02:
                        ((ImageButton)findViewById(R.id.Button02)).setImageBitmap(icon);
                        ((ImageButton)findViewById(R.id.Button02)).setBackground(null);
                        break;

                    case button03:
                        ((ImageButton)findViewById(R.id.Button03)).setImageBitmap(icon);
                        ((ImageButton)findViewById(R.id.Button03)).setBackground(null);
                        break;

                    case button04:
                        ((ImageButton)findViewById(R.id.Button04)).setImageBitmap(icon);
                        ((ImageButton)findViewById(R.id.Button04)).setBackground(null);
                        break;
                }
            }

            shortcutIntent = pm.getLaunchIntentForPackage(intent.getStringExtra("packageName"));
            clickCheck = iniCheck;
        }
    }

    protected void buttonCheck(int Flag){

        switch (Flag){
            case button01:
                buttonFlag[button01] = true;
                break;

            case button02:
                buttonFlag[button02] = true;
                break;

            case button03:
                buttonFlag[button03] = true;
                break;

            case button04:
                buttonFlag[button04] = true;
                break;
        }
    }

}