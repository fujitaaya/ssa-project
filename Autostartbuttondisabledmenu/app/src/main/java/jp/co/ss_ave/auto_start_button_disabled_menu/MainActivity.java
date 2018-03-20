package jp.co.ss_ave.auto_start_button_disabled_menu;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends FragmentActivity {

    ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        viewPager = (ViewPager) findViewById(R.id.pager);
        viewPager.setAdapter(
                new MyFragmentStatePagerAdapter(
                        getSupportFragmentManager()));
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


}