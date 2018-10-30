package id.co.imastudio.sainsdalamalquran;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.GridView;
import android.widget.ImageView;

import id.co.imastudio.mengenalprofesi.R;

public class MenuActivity extends AppCompatActivity {
    GridView gridMenu;
    private ImageView ivback;
    int[] listMenu = new int[]{R.drawable.menu01, R.drawable.menu02, R.drawable.menu03, R.drawable.menu04, R.drawable.menu05, R.drawable.menu06, R.drawable.menu07, R.drawable.menu08, R.drawable.menu09, R.drawable.menu10, R.drawable.menu11, R.drawable.menu12, R.drawable.menu13, R.drawable.menu14, R.drawable.menu15, R.drawable.menu16, R.drawable.menu17, R.drawable.menu18, R.drawable.menu19};
    private String[] listu = new String[]{"1", "1"};
    String[] startPage = new String[]{"0", "2", "8", "10", "11", "12", "15", "17", "18", "20", "23", "25", "28", "30", "33", "35", "41", "47", "49"};

    public void onBackPressed() {
        super.onBackPressed();
        startActivity(new Intent(this, MainActivity.class));
    }

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        getWindow().setFlags(1024, 1024);
        this.gridMenu = (GridView) findViewById(R.id.gridView);
        this.gridMenu.setAdapter(new MenuAdapter(this, this.listMenu, this.startPage));
        this.gridMenu.setNumColumns(1);
        this.gridMenu.setOnItemClickListener(new OnItemClickListener() {
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                Intent pindah = new Intent(MenuActivity.this, PlayActivity.class);
                pindah.putExtra("posisi", Integer.valueOf(MenuActivity.this.startPage[position]));
                MenuActivity.this.startActivity(pindah);
            }
        });
        this.ivback = (ImageView) findViewById(R.id.iv_back);
        this.ivback.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                MenuActivity.this.finish();
            }
        });
    }
}
