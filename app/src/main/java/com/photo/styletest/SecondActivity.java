package com.photo.styletest;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.MotionEvent;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioGroup;

public class SecondActivity extends AppCompatActivity {

	private String type = "default";
	private CheckBox checkBox;

	private TextWatcher asd = new TextWatcher() {
		@Override
		public void beforeTextChanged(CharSequence s, int start, int count, int after) {

		}

		@Override
		public void onTextChanged(CharSequence s, int start, int before, int count) {

		}

		@Override
		public void afterTextChanged(Editable s) {

		}
	};

	private EditText editText;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_second);

		checkBox = findViewById(R.id.checkBox);
		editText = findViewById(R.id.et_name);


		editText.addTextChangedListener(new TextWatcher() {
			@Override
			public void beforeTextChanged(CharSequence s, int start, int count, int after) {

			}

			@Override
			public void onTextChanged(CharSequence s, int start, int before, int count) {

			}

			@Override
			public void afterTextChanged(Editable s) {

			}
		});


		RadioGroup radioGroup = findViewById(R.id.radioButton);

		radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
			@Override
			public void onCheckedChanged(RadioGroup group, int checkedId) {
				switch (checkedId){
					case R.id.rb_high:
						type = "high";
						break;
					case R.id.rb_medium:
						type = "medium";
						break;
					case R.id.rb_law:
						type = "law";
						default:
							break;

				}
			}
		});

		findViewById(R.id.toggleButton)
				.setOnClickListener(new View.OnClickListener() {
					@Override
					public void onClick(View v) {
						String name = editText.getText().toString();
						boolean isChecked = checkBox.isChecked();

						Intent data = new Intent();

						data.putExtra("name", name);
						data.putExtra("type", type);
						data.putExtra("is_checked", isChecked);

//						Bundle bundle = new Bundle();
//						bundle.putString("name", name);
//						bundle.putString("type", type);
//						bundle.putBoolean("is_checked", isChecked);
//						data.putExtras(bundle);
						setResult(RESULT_OK, data);
						finish();
					}
				});


	}
}
