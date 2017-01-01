package com.dao.perimeter_area_rectangles_circles;

import android.app.Activity;
import android.os.Bundle;
import android.text.style.LineHeightSpan.WithDensity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {

	private EditText edtLength, edtWidth, edtRadius;
	private Button btnCalculateForRectangles, btnCalculateForCircles;
	private TextView txtResultOfRectangles, txtResultOfCircles;
	
	private final double PI = 3.14f;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		//Mapped
		onMapped();
		
		//Catch even when click button
		onClickButton();
	}

	private void onClickButton() {
		btnCalculateForRectangles.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				//Convert input from EditText to String and continue convert to Float number
				Double lengthOfRectangles = Double.valueOf(edtLength.getText().toString());				
				Double widthOfRectangles = Double.valueOf(edtWidth.getText().toString());	
//				//or way 2 to convert:
//				float length_of_rectangles = Float.parseFloat(edtLength.getText().toString());
//				float width_of_rectangles = Float.parseFloat(edtLength.getText().toString());

				if(lengthOfRectangles<widthOfRectangles){
					Toast.makeText(
							MainActivity.this, 
							"Length can not smaller than width!", 
							Toast.LENGTH_SHORT).show();
				}else{
					//Declare variables and calculate perimeter, area of Rectangles
					Double perimeterOfRectangles = (lengthOfRectangles+widthOfRectangles)*2;
					Double areaOfRectangles = lengthOfRectangles*widthOfRectangles;
					
					//Convert result after calculate and display result to screen
					txtResultOfRectangles.setText(
							String.valueOf(perimeterOfRectangles)+ "\n" +
							String.valueOf(areaOfRectangles)
					);
				}
			
			}
		});
		
		btnCalculateForCircles.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				//Convert input from EditText to String and continue convert to Float number
				Double radiusOfCircles = Double.valueOf(edtRadius.getText().toString()); 
//				//or way 2 to convert:
//				float radius_of_circles = Float.parseFloat(edtRadius.getText().toString());
				
				//Declare variables and calculate perimeter, area of Circles
				Double perimeterOfCircles = radiusOfCircles*2*PI;
				Double areaOfCircles = Math.pow(radiusOfCircles, 2)*PI;
				
				//Convert result after calculate and display result to screen
				txtResultOfCircles.setText(
						String.valueOf(perimeterOfCircles)+ "\n" +
						String.valueOf(areaOfCircles)
				);
				
			}
		});
	}

	private void onMapped() {
		edtLength = (EditText) findViewById(R.id.edtLength);
		edtWidth = (EditText) findViewById(R.id.edtWidth);
		edtRadius = (EditText) findViewById(R.id.edtRadius);
		btnCalculateForRectangles = (Button) findViewById(R.id.btnCalculateForRectangles);
		btnCalculateForCircles = (Button) findViewById(R.id.btnCalculateForCircles);
		txtResultOfRectangles = (TextView) findViewById(R.id.txtResultOfRectangles);
		txtResultOfCircles = (TextView) findViewById(R.id.txtResultOfCircles);
	}
}
