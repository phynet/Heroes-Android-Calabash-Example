package com.example.bddtest;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

@SuppressLint("ValidFragment")
public class DetailActivity extends Activity {
	private SuperHeroe superHeroe;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		this.superHeroe = (SuperHeroe) getIntent().getExtras().get("superheroe");
		setContentView(R.layout.activity_deatil);
		 

		if (savedInstanceState == null) {
			getFragmentManager().beginTransaction()
					.add(R.id.container, new PlaceholderFragment(superHeroe)).commit();
		}
	}

	/**
	 * A placeholder fragment containing a simple view.
	 */
	public static class PlaceholderFragment extends Fragment {
		private SuperHeroe superHeroe;
		
		public PlaceholderFragment(SuperHeroe superHeroe) {
			super();
			this.superHeroe = superHeroe;
		}

		@Override
		public View onCreateView(LayoutInflater inflater, ViewGroup container,
				Bundle savedInstanceState) {
			View rootView = inflater.inflate(R.layout.fragment_deatil,
					container, false);
			
			ImageView image = (ImageView) rootView.findViewById(R.id.HeroPictureDetail);
			try {
				image.setImageDrawable(getAssetImage(getActivity(), superHeroe.getImg()));
			} catch (IOException e) {
				e.printStackTrace();
			}
			
			TextView textViewHeroesName = (TextView) rootView.findViewById(R.id.HeroNameDetail);
			textViewHeroesName.setText(superHeroe.getName());
			
			TextView textViewHeroesHome = (TextView) rootView.findViewById(R.id.HeroHomeDetail);
			textViewHeroesHome.setText(superHeroe.getHome());
			
			TextView textViewHeroesPower = (TextView) rootView.findViewById(R.id.HeroPowerDetail);
			textViewHeroesPower.setText(superHeroe.getPowers());
			
			
			return rootView;
		}
		
		private Drawable getAssetImage(Context context, String filename) throws IOException {
		    AssetManager assets = context.getResources().getAssets();
		    InputStream buffer = new BufferedInputStream((assets.open(filename)));
		    Bitmap bitmap = BitmapFactory.decodeStream(buffer);
		    return new BitmapDrawable(context.getResources(), bitmap);
		}
	}

}
