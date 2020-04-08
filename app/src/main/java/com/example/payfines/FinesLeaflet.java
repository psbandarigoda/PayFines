package com.example.payfines;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class FinesLeaflet extends AppCompatActivity {

    Button confirm;
    String userName;
    String fineList, finesPriceView;
    String dlNo, oName, oEmail, oAddress, oContact, oLocation;
    int finesPrice;
    Integer fineTotal=0;
    Double sumOfPrice;
    TextView msgView, finesTotalView;
    ArrayList <Integer>  ruleArray1 = new ArrayList <Integer> ();
    ArrayList <Integer>  sumLKR = new ArrayList <Integer> ();
    ArrayList <String>  ruleArray_list = new ArrayList <String> ();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fines_leaflet);

        confirm = findViewById(R.id.btnConfFines);
        msgView = findViewById(R.id.fine_massageView);
        finesTotalView = findViewById(R.id.fine_TotalView);

        Intent uName = getIntent();
        userName = uName.getStringExtra("userName");

        Intent ruleArray = getIntent();
        ruleArray1 = ruleArray.getIntegerArrayListExtra("ruleArray");

        Intent oDetails = getIntent();
        dlNo = oDetails.getStringExtra("dlNo");

        getRule_Price();

        String subject = "TravelMo Guid Booking Service";
        String message = "TravelMo(pvt)ltd Guid Booking Service " +userName+
                "\n\n"+dlNo+"\nI'm --CustomerName-- I want to Book --Count--days\n\n" +ruleArray_list+"\n\n"+
                "my contact number is --ContactNumber-- Can you please inform to this number.\n\n" +
                "Best Regards.";

        for (Integer res : sumLKR ) {
            fineTotal = fineTotal + res;
        }

        msgView.setText(message.replace(","," ").replace("["," ").replace("]"," "));
        finesTotalView.setText("You Have to Pay \n" + "LKR. " + fineTotal.toString());
    }

    protected void onResume() {
        super.onResume();
        confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(FinesLeaflet.this, PayFines.class);
                intent.putExtra("userName", userName);
                startActivity(intent);
                Toast.makeText(getApplicationContext(), "Fines Confirmed", Toast.LENGTH_LONG).show();
            }
        });

    }

    public void getRule_Price(){
        for(int i=0; i<ruleArray1.size(); i++) {
            Integer currentX = ruleArray1.get(i);
            if(currentX == 1) { fineList = getResources().getString(R.string.Rule_01); ruleArray_list.add("\n"); ruleArray_list.add(fineList);
                finesPriceView = getResources().getString(R.string.Rule_01_LKR); ruleArray_list.add("\n LKR. "); ruleArray_list.add(finesPriceView);
                finesPrice = Integer.parseInt(getResources().getString(R.string.Rule_01_LKR)); sumLKR.add(finesPrice);
            }
            if(currentX == 2) { fineList = getResources().getString(R.string.Rule_02); ruleArray_list.add("\n"); ruleArray_list.add(fineList);
                finesPriceView = getResources().getString(R.string.Rule_02_LKR); ruleArray_list.add("\n LKR. "); ruleArray_list.add(finesPriceView);
                finesPrice = Integer.parseInt(getResources().getString(R.string.Rule_02_LKR)); sumLKR.add(finesPrice);
            }
            if(currentX == 3) { fineList = getResources().getString(R.string.Rule_03); ruleArray_list.add("\n"); ruleArray_list.add(fineList);
                finesPriceView = getResources().getString(R.string.Rule_03_LKR); ruleArray_list.add("\n LKR. "); ruleArray_list.add(finesPriceView);
                finesPrice = Integer.parseInt(getResources().getString(R.string.Rule_03_LKR)); sumLKR.add(finesPrice);
            }
            if(currentX == 4) { fineList = getResources().getString(R.string.Rule_04); ruleArray_list.add("\n"); ruleArray_list.add(fineList);
                finesPriceView = getResources().getString(R.string.Rule_04_LKR); ruleArray_list.add("\n LKR. "); ruleArray_list.add(finesPriceView);
                finesPrice = Integer.parseInt(getResources().getString(R.string.Rule_04_LKR)); sumLKR.add(finesPrice);
            }
            if(currentX == 5) { fineList = getResources().getString(R.string.Rule_05); ruleArray_list.add("\n"); ruleArray_list.add(fineList);
                finesPriceView = getResources().getString(R.string.Rule_05_LKR); ruleArray_list.add("\n LKR. "); ruleArray_list.add(finesPriceView);
                finesPrice = Integer.parseInt(getResources().getString(R.string.Rule_05_LKR)); sumLKR.add(finesPrice);
            }
            if(currentX == 6) { fineList = getResources().getString(R.string.Rule_06); ruleArray_list.add("\n"); ruleArray_list.add(fineList);
                finesPriceView = getResources().getString(R.string.Rule_06_LKR); ruleArray_list.add("\n LKR. "); ruleArray_list.add(finesPriceView);
                finesPrice = Integer.parseInt(getResources().getString(R.string.Rule_06_LKR)); sumLKR.add(finesPrice);
            }
            if(currentX == 7) { fineList = getResources().getString(R.string.Rule_06); ruleArray_list.add("\n"); ruleArray_list.add(fineList);
                finesPriceView = getResources().getString(R.string.Rule_07_LKR); ruleArray_list.add("\n LKR. "); ruleArray_list.add(finesPriceView);
                finesPrice = Integer.parseInt(getResources().getString(R.string.Rule_07_LKR)); sumLKR.add(finesPrice);
            }
        }
    }
}
