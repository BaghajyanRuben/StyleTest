package com.photo.styletest;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class MainActivity extends AppCompatActivity {

	private final int REQUEST_DATA= 123;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		findViewById(R.id.container_1)
				.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				startActivityForResult(new Intent(MainActivity.this,
						SecondActivity.class), REQUEST_DATA);
			}
		});

	}

	@Override
	protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
		super.onActivityResult(requestCode, resultCode, data);

		if (resultCode == RESULT_OK && requestCode == REQUEST_DATA){
			String name = data.getStringExtra("name");
			String type = data.getStringExtra("type");
			boolean isChecked = data.getBooleanExtra("is_checked", false);


			Log.d("test_intent", "name = " + name + " \n " +
					" type = " + type + " \n " +
					" isChecked " + isChecked);
		}
	}
}
