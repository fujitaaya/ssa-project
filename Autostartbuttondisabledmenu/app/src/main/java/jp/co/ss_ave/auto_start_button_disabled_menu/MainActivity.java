package jp.co.ss_ave.auto_start_button_disabled_menu;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.util.Base64;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;
import com.google.gson.Gson;
import java.io.ByteArrayOutputStream;
import java.util.Objects;

import static android.content.Intent.FLAG_ACTIVITY_SINGLE_TOP;

public class MainActivity extends FragmentActivity implements View.OnClickListener,View.OnLongClickListener {

//    //ボタンの位置番号(右上が0で反時計回り)
//    final int button01 = 0;
//    final int button02 = 1;
//    final int button03 = 2;
//    final int button04 = 3;
//    final int iniCheck = 999; //初期化用
//    final int buttonMax = 4;
//
//    //Preference定義
//    public static String preferenceName = "jp.co.ss_ave.auto_start_button_disabled_menu";
//    private SharedPreferences prefPut;
//    private SharedPreferences prefGet;
//    private SharedPreferences.Editor editor;
//    private Gson gson = new Gson();
//
//    //各アプリデータ取得用
//    Bitmap[] getIconDataBitmap = new Bitmap[buttonMax];
//    String[] getPackageName = new String[buttonMax];
//    String[] getAppName = new String[buttonMax];
//
//    //チェック用
//    int clickCheck = iniCheck;
//    boolean[] getButtonFlag = new boolean[buttonMax];
//
//    String flagCheck = "";
//    String pName = "";
//    String appName = "";
//    TextView appLabel;

    ViewPager viewPager;

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



//        //ボタンクリック用定義
//        findViewById(R.id.Button01).setOnClickListener(this);
//        findViewById(R.id.Button02).setOnClickListener(this);
//        findViewById(R.id.Button03).setOnClickListener(this);
//        findViewById(R.id.Button04).setOnClickListener(this);
//
//        //ボタン長押し用定義
//        findViewById(R.id.Button01).setOnLongClickListener(this);
//        findViewById(R.id.Button02).setOnLongClickListener(this);
//        findViewById(R.id.Button03).setOnLongClickListener(this);
//        findViewById(R.id.Button04).setOnLongClickListener(this);
//
//        //Preferencesデータ取得
//        Drawable getIcon = null;
//
//        prefGet = getApplicationContext().getSharedPreferences(preferenceName,MODE_PRIVATE);
//
//        flagCheck = prefGet.getString("buttonFlag",null);
//        getButtonFlag = gson.fromJson(flagCheck,boolean[].class);
//
//        pName = prefGet.getString("packageName",null);
//        getPackageName = gson.fromJson(pName,String[].class);
//
//        appName = prefGet.getString("appName",null);
//        getAppName = gson.fromJson(appName,String[].class);
//
//        if(getIconDataBitmap == null){
//            getIconDataBitmap = new Bitmap[buttonMax];
//        }

        //Preferencesにデータがあれば、アイコン設置
//        if(getButtonFlag != null){
//            for(int i = 0; i < buttonMax; i++){
//                if(getButtonFlag[i]){
//
//                    switch (i){
//                        case button01:
//                            try{
////                                getIcon = pm.getApplicationIcon(getPackageName[i].toString());
//                                getIcon = resizedBitmap(button01, null);
//
//                            }catch(Exception e){
//                                Log.e("Icon_Exception",e.toString());
//                            }
//
//                            ((ImageButton)findViewById(R.id.Button01)).setImageDrawable(getIcon);
//                            ((ImageButton)findViewById(R.id.Button01)).setBackground(null);
//                            appLabel = findViewById(R.id.TextView01);
//                            appLabel.setText(getAppName[i].toString());
//                            break;
//
//                        case button02:
//                            try{
////                                getIcon = pm.getApplicationIcon(getPackageName[i].toString());
//                                getIcon = resizedBitmap(button02, null);
//                            }catch(Exception e){
//                                Log.e("Icon_Exception",e.toString());
//                            }
//
//                            ((ImageButton)findViewById(R.id.Button02)).setImageDrawable(getIcon);
//                            ((ImageButton)findViewById(R.id.Button02)).setBackground(null);
//                            appLabel = findViewById(R.id.TextView02);
//                            appLabel.setText(getAppName[i].toString());
//                            break;
//
//                        case button03:
//                            try{
////                                getIcon = pm.getApplicationIcon(getPackageName[i].toString());
//                                getIcon = resizedBitmap(button03, null);
//                            }catch(Exception e){
//                                Log.e("Icon_Exception",e.toString());
//                            }
//
//                            ((ImageButton)findViewById(R.id.Button03)).setImageDrawable(getIcon);
//                            ((ImageButton)findViewById(R.id.Button03)).setBackground(null);
//                            appLabel = findViewById(R.id.TextView03);
//                            appLabel.setText(getAppName[i].toString());
//                            break;
//
//                        case button04:
//                            try{
////                                getIcon = pm.getApplicationIcon(getPackageName[i].toString());
//                                getIcon = resizedBitmap(button04, null);
//                            }catch(Exception e){
//                                Log.e("Icon_Exception",e.toString());
//                            }
//
//                            ((ImageButton)findViewById(R.id.Button04)).setImageDrawable(getIcon);
//                            ((ImageButton)findViewById(R.id.Button04)).setBackground(null);
//                            appLabel = findViewById(R.id.TextView04);
//                            appLabel.setText(getAppName[i].toString());
//                            break;
//                    }
//                }else{
//                    continue;
//                }
//            }
//        }else{
//            getButtonFlag = new boolean[buttonMax];
//        }

        viewPager = (ViewPager) findViewById(R.id.pager);
        viewPager.setAdapter(
                new MyFragmentStatePagerAdapter(
                        getSupportFragmentManager()));
    }

    public void onClick(View v) {
//        PackageManager pm = getPackageManager();
//        Intent intent = new Intent();
//
//        //Preferencesデータ取得
//        prefPut = getApplicationContext().getSharedPreferences(preferenceName,MODE_PRIVATE);
//        editor = prefPut.edit();
//
//        prefGet = getApplicationContext().getSharedPreferences(preferenceName,MODE_PRIVATE);
//
//        pName = prefGet.getString("packageName",null);
//        getPackageName = gson.fromJson(pName,String[].class);
//
//        flagCheck = prefGet.getString("buttonFlag",null);
//        getButtonFlag = gson.fromJson(flagCheck,boolean[].class);
//
//        if(getButtonFlag == null){
//            getButtonFlag = new boolean[buttonMax];
//        }
//
//        //リスト側でチェックする用
//        editor.putBoolean("listCheck",true);
//        editor.apply();
//
//        // 各アプリ起動
//        // ボタンにアプリが設定されていなければ、リストを開く
//        if(v != null){
//            switch(v.getId()){
//                case R.id.Button01:
//                    if(!getButtonFlag[button01]){
//                        intent = new Intent(getApplication(), jp.co.ss_ave.auto_start_button_disabled_menu.ListActivity.class);
//                        clickCheck = button01;
//
//                        editor.putInt("clickCheck",clickCheck);
//                        editor.apply();
//
//                        startActivityForResult(intent, 1);
//                    }else{
//                        intent = pm.getLaunchIntentForPackage(getPackageName[button01]);
//                    }
//                    break;
//
//                case R.id.Button02:
//                    if(!getButtonFlag[button02]){
//                        intent = new Intent(getApplication(), jp.co.ss_ave.auto_start_button_disabled_menu.ListActivity.class);
//                        clickCheck = button02;
//
//                        editor.putInt("clickCheck",clickCheck);
//                        editor.apply();
//
//                        startActivityForResult(intent, 1);
//                    }else{
//                        intent = pm.getLaunchIntentForPackage(getPackageName[button02]);
//                    }
//                    break;
//
//                case R.id.Button03:
//                    if(!getButtonFlag[button03]){
//                        intent = new Intent(getApplication(), jp.co.ss_ave.auto_start_button_disabled_menu.ListActivity.class);
//                        clickCheck = button03;
//
//                        editor.putInt("clickCheck",clickCheck);
//                        editor.apply();
//
//                        startActivityForResult(intent, 1);
//                    }else{
//                        intent = pm.getLaunchIntentForPackage(getPackageName[button03]);
//                    }
//                    break;
//
//                case R.id.Button04:
//                    if(!getButtonFlag[button04]){
//                        intent = new Intent(getApplication(), jp.co.ss_ave.auto_start_button_disabled_menu.ListActivity.class);
//                        clickCheck = button04;
//
//                        editor.putInt("clickCheck",clickCheck);
//                        editor.apply();
//
//                        startActivityForResult(intent, 1);
//                    }else{
//                        intent = pm.getLaunchIntentForPackage(getPackageName[button04]);
//                    }
//                    break;
//            }
//        }
//
//        try{
//            startActivity(intent);
//        }catch(Exception e){
//            Toast.makeText(MainActivity.this, "対象のアプリがありません", Toast.LENGTH_SHORT).show();
//        }
    }

    //ショートカット削除選択(長押し)
    public boolean onLongClick(View v){

//        flagCheck = prefGet.getString("buttonFlag",null);
//        getButtonFlag = gson.fromJson(flagCheck,boolean[].class);
//
//        if(v != null && getButtonFlag != null) {
//            switch (v.getId()) {
//                case R.id.Button01:
//                    if (getButtonFlag[button01]) {
//                        diaLog(button01);
//                    }
//                    break;
//
//                case R.id.Button02:
//                    if (getButtonFlag[button02]) {
//                        diaLog(button02);
//                    }
//                    break;
//
//                case R.id.Button03:
//                    if (getButtonFlag[button03]) {
//                        diaLog(button03);
//                    }
//                    break;
//
//                case R.id.Button04:
//                    if (getButtonFlag[button04]) {
//                        diaLog(button04);
//                    }
//                    break;
//            }
//        }
        return false;
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

    //ListActivityから受け取る
    protected void onActivityResult( int requestCode, int resultCode, Intent intent) {
        super.onActivityResult(requestCode, resultCode, intent);

//        PackageManager pm = getPackageManager();
//        int getCheck = iniCheck;
//        String pkCheck = "";
//        boolean appCheck = false;
//
//        Bitmap getBitmapIcon = null;
//        Bitmap resizedBitmap = null;
//
//        prefPut = getApplicationContext().getSharedPreferences(preferenceName,MODE_PRIVATE);
//        editor = prefPut.edit();
//
//        prefGet = getApplicationContext().getSharedPreferences(preferenceName,MODE_PRIVATE);
//
//        if(resultCode == RESULT_OK && null != intent) {
//
//            Bitmap bitmapIcon =  (Bitmap) intent.getExtras().get("icon");
//            Drawable getIcon =  new BitmapDrawable(this.getResources(),bitmapIcon);
//
//            getCheck = prefGet.getInt("clickCheck",iniCheck);
//            pkCheck = intent.getStringExtra("packageName");
//
//            pName = prefGet.getString("packageName",null);
//            getPackageName = gson.fromJson(pName,String[].class);
//
//            appName = prefGet.getString("appName",null);
//            getAppName = gson.fromJson(appName,String[].class);
//
//            if(getPackageName == null){
//                getPackageName = new String[buttonMax];
//            }
//            if(getAppName == null){
//                getAppName = new String[buttonMax];
//            }
//
//            //ショートカット被り回避
//            for(int i = 0; i < buttonMax; i++){
//                if(pkCheck.equals(getPackageName[i])) {
//                    Toast.makeText(MainActivity.this, "既にショートカットが作成済です。", Toast.LENGTH_SHORT).show();
//                    appCheck = true;
//                }
//            }
//
//            //押下されたボタンにアプリデータセット
//            if((getCheck != iniCheck) && (!appCheck)){
//
//                switch (getCheck){
//                    case button01:
////                        getBitmapIcon = ((BitmapDrawable)getIcon).getBitmap();
////                        resizedBitmap = Bitmap.createScaledBitmap(getBitmapIcon, 96, 96, false);
////                        getIcon = new BitmapDrawable(getResources(), resizedBitmap);
//                        getIcon = resizedBitmap(button01, getIcon);
//
//                        ((ImageButton)findViewById(R.id.Button01)).setImageDrawable(getIcon);
//                        ((ImageButton)findViewById(R.id.Button01)).setBackground(null);
//
//                        buttonCheck(button01,true);
//
//                        getPackageName[button01] =intent.getStringExtra("packageName");
//                        getAppName[button01] =intent.getStringExtra("appName");
//
//                        appLabel = findViewById(R.id.TextView01);
//                        appLabel.setText(getAppName[button01].toString());
//
//                        pName = gson.toJson(getPackageName);
//                        appName = gson.toJson(getAppName);
//
//                        editor.putString("packageName",pName);
//                        editor.apply();
//
//                        editor.putString("appName",appName);
//                        editor.apply();
//                        break;
//
//                    case button02:
//                        getIcon = resizedBitmap(button02, getIcon);
//
//                        ((ImageButton)findViewById(R.id.Button02)).setImageDrawable(getIcon);
//                        ((ImageButton)findViewById(R.id.Button02)).setBackground(null);
//
//                        buttonCheck(button02,true);
//
//                        getPackageName[button02] =intent.getStringExtra("packageName");
//                        getAppName[button02] =intent.getStringExtra("appName");
//
//                        appLabel = findViewById(R.id.TextView02);
//                        appLabel.setText(getAppName[button02].toString());
//
//                        pName = gson.toJson(getPackageName);
//                        appName = gson.toJson(getAppName);
//
//                        editor.putString("packageName",pName);
//                        editor.apply();
//
//                        editor.putString("appName",appName);
//                        editor.apply();
//                        break;
//
//                    case button03:
//                        getIcon = resizedBitmap(button03, getIcon);
//
//                        ((ImageButton)findViewById(R.id.Button03)).setImageDrawable(getIcon);
//                        ((ImageButton)findViewById(R.id.Button03)).setBackground(null);
//
//                        buttonCheck(button03,true);
//
//                        getPackageName[button03] =intent.getStringExtra("packageName");
//                        getAppName[button03] =intent.getStringExtra("appName");
//
//                        appLabel = findViewById(R.id.TextView03);
//                        appLabel.setText(getAppName[button03].toString());
//
//                        pName = gson.toJson(getPackageName);
//                        appName = gson.toJson(getAppName);
//
//                        editor.putString("packageName",pName);
//                        editor.apply();
//
//                        editor.putString("appName",appName);
//                        editor.apply();
//                        break;
//
//                    case button04:
//                        getIcon = resizedBitmap(button04, getIcon);
//
//                        ((ImageButton)findViewById(R.id.Button04)).setImageDrawable(getIcon);
//                        ((ImageButton)findViewById(R.id.Button04)).setBackground(null);
//
//                        buttonCheck(button04,true);
//
//                        getPackageName[button04] =intent.getStringExtra("packageName");
//                        getAppName[button04] =intent.getStringExtra("appName");
//
//                        appLabel = findViewById(R.id.TextView04);
//                        appLabel.setText(getAppName[button04].toString());
//
//                        pName = gson.toJson(getPackageName);
//                        appName = gson.toJson(getAppName);
//
//                        editor.putString("packageName",pName);
//                        editor.apply();
//
//                        editor.putString("appName",appName);
//                        editor.apply();
//                        break;
//                }
//            }
//            clickCheck = iniCheck;
//
//            editor.putInt("clickCheck",clickCheck);
//            editor.apply();
//        }
    }

    //ボタンのクリック判定(true:アプリセット済)
    protected void buttonCheck(int Flag,boolean check){

//        prefPut = getApplicationContext().getSharedPreferences(preferenceName,MODE_PRIVATE);
//        editor = prefPut.edit();
//
//        String flag = "";
//
//        flagCheck = prefGet.getString("buttonFlag",null);
//        getButtonFlag = gson.fromJson(flagCheck,boolean[].class);
//
//        if(getButtonFlag == null){
//            getButtonFlag = new boolean[buttonMax];
//        }
//
//        switch (Flag){
//            case button01:
//                getButtonFlag[button01] = check;
//
//                flag = gson.toJson(getButtonFlag);
//                editor.putString("buttonFlag",flag);
//                editor.apply();
//
//                break;
//
//            case button02:
//                getButtonFlag[button02] = check;
//
//                flag = gson.toJson(getButtonFlag);
//                editor.putString("buttonFlag",flag);
//                editor.apply();
//                break;
//
//            case button03:
//                getButtonFlag[button03] = check;
//
//                flag = gson.toJson(getButtonFlag);
//                editor.putString("buttonFlag",flag);
//                editor.apply();
//
//                break;
//
//            case button04:
//                getButtonFlag[button04] = check;
//
//                flag = gson.toJson(getButtonFlag);
//                editor.putString("buttonFlag",flag);
//                editor.apply();
//                break;
//        }
    }

    //アイコンを保存
//    protected void bitmapPut(Bitmap icon, int num){
////        prefPut = getApplicationContext().getSharedPreferences("jp.co.ss_ave.auto_start_button_disabled_menu",MODE_PRIVATE);
////        editor = prefPut.edit();
////
////        getIconDataBitmap = bitmapGet();
////
////        if(getIconDataBitmap != null){
////            getIconDataBitmap[num] = icon;
//        Bitmap bitmap = icon;
//            ByteArrayOutputStream baos = new ByteArrayOutputStream();
//            bitmap.compress(Bitmap.CompressFormat.PNG, 100, baos);
//            String bitmapStr = Base64.encodeToString(baos.toByteArray(), Base64.DEFAULT);
//
//            iconData[num] = bitmapStr;
//            iconStr = gson.toJson(iconData);
//
//            editor.putString("icon", iconStr);
//            editor.apply();
////        }else{
////            getIconDataBitmap = new Bitmap[buttonMax];
////        }
//    }

    //アイコンをpreferenceから取得
//    protected Bitmap[] bitmapGet(){
//
//        Bitmap[] bitmap = new Bitmap[buttonMax];
//        prefGet = getApplicationContext().getSharedPreferences("jp.co.ss_ave.auto_start_button_disabled_menu",MODE_PRIVATE);
//
//        iconStr = prefGet.getString("icon", "");
//        getIconData = gson.fromJson(iconStr,String[].class);
//
//        if(getIconData != null) {
//            for (int i = 0; i < buttonMax; i++) {
//                if (getIconData[i] != null) {
//                    BitmapFactory.Options options = new BitmapFactory.Options();
//                    byte[] b = Base64.decode(getIconData[i], Base64.DEFAULT);
//                    bitmap[i] = BitmapFactory.decodeByteArray(b, 0, b.length).copy(Bitmap.Config.ARGB_8888, true);
//                }
//            }
//        }
//        return bitmap;
//    }


    //ショートカット削除の確認ダイアログ
    protected  void diaLog(final int buttonNum){

//        prefPut = getApplicationContext().getSharedPreferences(preferenceName,MODE_PRIVATE);
//        editor = prefPut.edit();
//
//        pName = prefGet.getString("packageName",null);
//        getPackageName = gson.fromJson(pName,String[].class);
//
//        appName = prefGet.getString("appName",null);
//        getAppName = gson.fromJson(appName,String[].class);
//
//        if(getPackageName == null){
//            getPackageName = new String[buttonMax];
//            getAppName = new String[buttonMax];
//        }
//
//        AlertDialog.Builder dialog = new AlertDialog.Builder(this);
//
//        dialog.setTitle("ショートカットの削除");
//        dialog.setMessage("このアプリのショートカットを削除しますか？");
//        dialog.setPositiveButton("Yes", new DialogInterface.OnClickListener(){
//            @Override
//            public void onClick(DialogInterface dialog, int which) {
//
//                // "Yes"が押されたらPreferenceのアプリデータを初期化
//                switch(buttonNum){
//                    case button01:
//                        ((ImageButton)findViewById(R.id.Button01)).setImageDrawable(null);
//                        ((ImageButton)findViewById(R.id.Button01)).setBackgroundResource(R.mipmap.add);
//                        appLabel = findViewById(R.id.TextView01);
//                        appLabel.setText(R.string.textAdd);
//
//                        getPackageName[button01] = null;
//                        getAppName[button01] = null;
//
//                        buttonCheck(button01, false);
//
//                        pName = gson.toJson(getPackageName);
//                        appName = gson.toJson(getAppName);
//
//                        editor.putString("packageName",pName);
//                        editor.apply();
//
//                        editor.putString("appName",appName);
//                        editor.apply();
//                        break;
//
//                    case button02:
//                        ((ImageButton)findViewById(R.id.Button02)).setImageDrawable(null);
//                        ((ImageButton)findViewById(R.id.Button02)).setBackgroundResource(R.mipmap.add);
//                        appLabel = findViewById(R.id.TextView02);
//                        appLabel.setText(R.string.textAdd);
//
//                        getPackageName[button02] = null;
//                        getAppName[button02] = null;
//
//                        buttonCheck(button02, false);
//
//                        pName = gson.toJson(getPackageName);
//                        appName = gson.toJson(getAppName);
//
//                        editor.putString("packageName",pName);
//                        editor.apply();
//
//                        editor.putString("appName",appName);
//                        editor.apply();
//                        break;
//
//                    case button03:
//                        ((ImageButton)findViewById(R.id.Button03)).setImageDrawable(null);
//                        ((ImageButton)findViewById(R.id.Button03)).setBackgroundResource(R.mipmap.add);
//                        appLabel = findViewById(R.id.TextView03);
//                        appLabel.setText(R.string.textAdd);
//
//                        getPackageName[button03] = null;
//                        getAppName[button03] = null;
//
//                        buttonCheck(button03,false);
//
//                        pName = gson.toJson(getPackageName);
//                        appName = gson.toJson(getAppName);
//
//                        editor.putString("packageName",pName);
//                        editor.apply();
//
//                        editor.putString("appName",appName);
//                        editor.apply();
//                        break;
//
//                    case button04:
//                        ((ImageButton)findViewById(R.id.Button04)).setImageDrawable(null);
//                        ((ImageButton)findViewById(R.id.Button04)).setBackgroundResource(R.mipmap.add);
//                        appLabel = findViewById(R.id.TextView04);
//                        appLabel.setText(R.string.textAdd);
//
//                        getPackageName[button04] = null;
//                        getAppName[button04] = null;
//
//                        buttonCheck(button04,false);
//
//                        pName = gson.toJson(getPackageName);
//                        appName = gson.toJson(getAppName);
//
//                        editor.putString("packageName",pName);
//                        editor.apply();
//
//                        editor.putString("appName",appName);
//                        editor.apply();
//                        break;
//                }
//            }
//        });
//        dialog.setNegativeButton("No", null);
//        dialog.show();
    }

//    //アプリアイコンのサイズ変更
//    protected Drawable resizedBitmap(int num, Drawable icon){
//        PackageManager pm = getPackageManager();
//        Bitmap getBitmapIcon = null;
//        Bitmap resizedBitmap = null;
//        Drawable getIcon = null;
//
//        if(icon == null){
//            try {
//                icon = pm.getApplicationIcon(getPackageName[num].toString());
//            } catch (PackageManager.NameNotFoundException e) {
//                e.printStackTrace();
//            }
//        }
//
//        getBitmapIcon = ((BitmapDrawable)icon).getBitmap();
//        resizedBitmap = Bitmap.createScaledBitmap(getBitmapIcon, 96, 96, false);
//        getIcon = new BitmapDrawable(getResources(), resizedBitmap);
//
//        return getIcon;
//    }

}