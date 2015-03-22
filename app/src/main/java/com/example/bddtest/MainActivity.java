package com.example.bddtest;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;

import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.content.Intent;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		setTitle("Dashboard");

		if (savedInstanceState == null) {
			getFragmentManager().beginTransaction()
					.add(R.id.container, new PlaceholderFragment()).commit();
		}
	}
	
	public void loadSuperHeroe(View v) {
		int id = v.getId();
		SuperHeroe superHeroe = SUPER_HEROES[id];
		Intent details = new Intent(this, DetailActivity.class);
		details.putExtra("superheroe", superHeroe);
		this.startActivity(details);
		
	}
	//String name, String home, String powers, String img
	private final static SuperHeroe[] SUPER_HEROES = new SuperHeroe[]{
		new SuperHeroe("Superman", "DC", "Fuerza, vuelo", "superman.png"),
		new SuperHeroe("Aquaman", "DC", "Telepático", "aquaman.png"),
		new SuperHeroe("Batman", "DC", "Destreza física e inteligencia", "batman.png"),
		new SuperHeroe("BatGirl", "DC", "Inteligencia", "batgirl.png"),
		new SuperHeroe("Wonder Woman", "DC", "Fuerza e inteligencia", "wonder_woman.png"),
		new SuperHeroe("Deadpool", "Marvel", "Curación rápida", "deadpool.png"),
		new SuperHeroe("Iron Man", "Marverl", "Emanación de energía", "ironman.png"),
		new SuperHeroe("Blackwidow", "Marvel", "Curación rápida y fuerza", "blackwidow.png"),
		new SuperHeroe("Hawk Eye", "Marvel", "Fuerza y resistencia", "hawkeye.png"),
		new SuperHeroe("Hulk", "Marvel", "Fuerza ilimitada", "hulk.png"),
		new SuperHeroe("Captain America", "Marvel", "Inteligencia y fuereza", "captain_america.png"),
		new SuperHeroe("Elektra", "Marvel", "Reflejos, velocidad, resistencia", "elektra.png"),
		new SuperHeroe("Thor", "Marvel", "Fuerza", "thor.png")
	};
	
	/**
	 * A placeholder fragment containing a simple view.
	 */
	public static class PlaceholderFragment extends Fragment {
        

		public PlaceholderFragment() {
		}

		@Override
		public View onCreateView(LayoutInflater inflater, ViewGroup container,
				Bundle savedInstanceState) {
			View rootView = inflater.inflate(R.layout.fragment_main, container,
					false);
			TableLayout table = (TableLayout) rootView.findViewById(R.id.superHeroes);
			fillTableLayout(table);
			return rootView;
		}
		
		private TableLayout fillTableLayout(TableLayout tableLayout) {
			TableLayout.LayoutParams tableLayoutParams = new TableLayout.LayoutParams();
			tableLayout.setBackgroundColor(Color.BLACK);
			TableRow.LayoutParams tableRowParams = new TableRow.LayoutParams();
			tableRowParams.setMargins(1, 1, 1, 1);
			tableRowParams.weight = 1;

			for (int i = 0; i < SUPER_HEROES.length; i++) {
				SuperHeroe superHeroe = SUPER_HEROES[i];
				TableRow tableRow = new TableRow(this.getActivity());
				this.getView();
				RelativeLayout rowLayout = (RelativeLayout)View.inflate(this.getActivity(), R.layout.table_row, null);
				rowLayout.setId(i);
				ImageView heroeImg = (ImageView)rowLayout.findViewById(R.id.HeroPictureCell);
				try {
					heroeImg.setImageDrawable(getAssetImage(this.getActivity().getApplicationContext(), superHeroe.getImg()));
				} catch (IOException e) {
					e.printStackTrace();
				}
			    
				TextView textViewHeroesName = (TextView) rowLayout.findViewById(R.id.HeroNameCell);
				textViewHeroesName.setText(superHeroe.getName());
				
				TextView textViewHeroesHome = (TextView) rowLayout.findViewById(R.id.HeroHomeCell);
				textViewHeroesHome.setText(superHeroe.getHome());
				
				tableRow.addView(rowLayout, tableRowParams);
				tableLayout.addView(tableRow, tableLayoutParams);
			}
			return tableLayout;
		}
		
		private Drawable getAssetImage(Context context, String filename) throws IOException {
		    AssetManager assets = context.getResources().getAssets();
		    InputStream buffer = new BufferedInputStream((assets.open(filename)));
		    Bitmap bitmap = BitmapFactory.decodeStream(buffer);
		    return new BitmapDrawable(context.getResources(), bitmap);
		}
	}

}
