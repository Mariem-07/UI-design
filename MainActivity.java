package tn.iac.uiDesign;

import android.os.Bundle;
import android.widget.Toast;

import com.actionbarsherlock.app.ActionBar;
import com.actionbarsherlock.app.SherlockActivity;
import com.actionbarsherlock.view.Menu;
import com.actionbarsherlock.view.MenuItem;
import com.slidingmenu.lib.SlidingMenu;


public class MainActivity extends SherlockActivity {

	private SlidingMenu slidingMenu;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		ActionBar actionBar = getSupportActionBar();
		actionBar.setDisplayHomeAsUpEnabled(true);
		
		slidingMenu = new SlidingMenu(this);
		slidingMenu.setMode(SlidingMenu.LEFT);
		slidingMenu.setShadowDrawable(R.drawable.shadow);
		slidingMenu.setShadowWidth(50);
		slidingMenu.setBehindOffset(60);
		slidingMenu.setFadeDegree(0.35f);
		slidingMenu.attachToActivity(this, SlidingMenu.SLIDING_WINDOW);
		slidingMenu.setMenu(R.layout.slide_menu);
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getSupportMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
	public boolean onOptionsItemSelected(MenuItem item) {

		switch (item.getItemId()) {
		case R.id.itemAbout:
			Toast.makeText(MainActivity.this, "About", Toast.LENGTH_SHORT)
					.show();
			return true;
		case R.id.itemNew:
			Toast.makeText(MainActivity.this, "New", Toast.LENGTH_SHORT).show();
			return true;
		case R.id.itemRefresh:
			Toast.makeText(MainActivity.this, "Refresh", Toast.LENGTH_SHORT)
					.show();
			return true;
		case android.R.id.home:
			slidingMenu.toggle();
		default:
			return super.onOptionsItemSelected(item);
		}

	}

}
