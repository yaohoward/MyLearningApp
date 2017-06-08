package com.bochk.howard.mylearningapplication;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

/*
这是第二章使用的主activity。
 */
public class FirstActivity extends AppCompatActivity {

    public static final String TAG = "FirstActivity";

    /* P53 活动的生命周期使用
    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG,"onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG,"onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG,"onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG,"onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG,"onDestroy");
    }
*/
    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d(TAG,"onRestart");
    }

    /*P53 活动的生命周期*/


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.first_layout);

        Log.d(TAG,"onCreate: " + this.toString());

        Button button1 = (Button) findViewById(R.id.button_1);

        button1.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                /*p37 在活动中使用Toast*/
//                Toast.makeText(FirstActivity.this,"You clicked Button 1",Toast.LENGTH_SHORT).show();
                /*P43 显式Intent*/
//                Intent intent = new Intent(FirstActivity.this, SecondActivity.class);
//                startActivity(intent);
                /*P46 隐式Intent*/
//                Intent intent = new Intent(Intent.ACTION_VIEW);
//                intent.setData(Uri.parse("http://www.163.com"));
//                startActivity(intent);
                /*P49*/
//                Intent intent = new Intent(Intent.ACTION_DIAL);
//                intent.setData(Uri.parse("tel:10086"));
//                startActivity(intent);
                /*P50 向下一个活动传递数据*/
//                String data = "Hello, Second Activity";
//                Intent intent = new Intent(FirstActivity.this, SecondActivity.class);
//                intent.putExtra("extra_data",data);
//                startActivity(intent);
                /*P51 返回数据给上一个活动*/
//                Intent intent = new Intent(FirstActivity.this,SecondActivity.class);
//                startActivityForResult(intent,1);

                /*P64 活动的启动模式：1. standard; 2. singleTop 需要修改AndroidManifest.xml*/
//                Intent intent = new Intent(FirstActivity.this,FirstActivity.class);
//                startActivity(intent);

                /*P66 singleTop 模式下,firstActivity 不在栈顶时的情况。*/
                Intent intent = new Intent(FirstActivity.this,SecondActivity.class);
                startActivity(intent);

                /*P67 活动的启动模式：3. singleTask 需要修改AndroidManifest.xml,修改onRestart*/

            }
        });

        /*P58 体验活动的生命周期。bengin*/
        Button startNormalActivity = (Button) findViewById(R.id.start_normal_activity);
        Button startDialogActivity = (Button) findViewById(R.id.start_dialog_activity);

        startNormalActivity.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(FirstActivity.this,NormalActivity.class);
                startActivity(intent);
            }
        });

        startDialogActivity.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(FirstActivity.this, DialogActivity.class);
                startActivity(intent);
            }
        });

        /*P58 end*/

    }

    /*P51 First使用startActivityForResult 方法启动Second，Second被销毁之后回调上一个活动的onActivityResult。
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        switch (requestCode){
            case 1:
                if (resultCode == RESULT_OK) {
                    String returnedData = data.getStringExtra("data_return");
                    Log.d("FirstActivity",returnedData);
                }
                break;
            default:
        }
    }

    P51 end*/

    /*P39 在活动中使用menu begin*/
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
//        return super.onCreateOptionsMenu(menu);
        getMenuInflater().inflate(R.menu.main,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
//        return super.onOptionsItemSelected(item);
        switch (item.getItemId())
        {
            case R.id.add_item:
                Toast.makeText(this,"You clicked Add", Toast.LENGTH_SHORT).show();
                break;
            case R.id.remove_item:
                Toast.makeText(this,"You clicked Remove",Toast.LENGTH_SHORT).show();
                break;
            default:
        }
        return true;
    }
    /*P39 在活动中使用menu end*/
}
