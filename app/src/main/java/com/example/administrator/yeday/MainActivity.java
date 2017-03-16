package com.example.administrator.yeday;

import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.MultiAutoCompleteTextView;
import android.widget.QuickContactBadge;

import com.umeng.message.PushAgent;

public class MainActivity extends AppCompatActivity {
    private String[] arrData=new String[]{"2123","1257","3684","8715","6666","7777","11111","15789"};
    private ArrayAdapter<String> arrayAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        PushAgent.getInstance(this).onAppStart();

        QuickContactBadge qcn= (QuickContactBadge) findViewById(R.id.qcn);

        AutoCompleteTextView autv= (AutoCompleteTextView) findViewById(R.id.actv);

        MultiAutoCompleteTextView mautv= (MultiAutoCompleteTextView) findViewById(R.id.mactv);

        qcn.assignContactFromPhone("123456",true);
        qcn.setMode(ContactsContract.QuickContact.MODE_SMALL);


        arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,arrData);
        autv.setAdapter(arrayAdapter);

        mautv.setAdapter(arrayAdapter);
        mautv.setTokenizer(new MultiAutoCompleteTextView.CommaTokenizer());
    }
}
