package com.example.qrhunter;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
/**
 * this interface shows user's rank ordered by user's unique code
 */

public class RankUnique extends AppCompatActivity {
    private ListView userList;
    private ArrayAdapter<User> userAdapter;
    private ArrayList<User> userDataList;
    private int chosenLine = 0;
    //private String userId="1234";
    FirebaseFirestore db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rank_unique);


        TextView content = findViewById(R.id.user_position01);
        userList = findViewById(R.id.amount_rank_list);
        userDataList = new ArrayList<>();
        SharedData appData = (SharedData) getApplication();
        String userId = appData.getUsername();

        TextView name = findViewById(R.id.txtUserCustom);
        TextView score = findViewById(R.id.txtScoreCustom1);


        Button btn =  findViewById(R.id.back_button);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Intent intent = new Intent(RankUnique.this,RankActivity.class);
                //startActivity(intent);
                finish();
            }
        });


        db = FirebaseFirestore.getInstance();
        final CollectionReference collectionReference = db.collection("Users");
        collectionReference.addSnapshotListener(new EventListener<QuerySnapshot>() {
            @Override
            public void onEvent(@Nullable final QuerySnapshot queryDocumentSnapshots, @Nullable
                    FirebaseFirestoreException error) {
                userDataList.clear();
                for (QueryDocumentSnapshot doc : queryDocumentSnapshots) {
                    String city = doc.getId();
                    long  unique = (long) doc.getData().get("unique");
                    int amount = (int)unique;
                    userDataList.add(new User(city,amount));
                }

                Collections.sort(userDataList, new Comparator<User>() {
                    @Override
                    public int compare(User user, User user2) {
                        int i=-1*(user.getUnique()-user2.getUnique());
                        return i;
                    }
                });
                userAdapter = new CustomList(RankUnique.this, userDataList);
                userList.setAdapter(userAdapter);

                for(int i = 0; i< userDataList.size();i++){
                    if( userDataList.get(i).getUserName().equals(userId)){
                        int index = i+1;
                        content.setText("User Rank "+index);
                        break; }
                }

            }
        });
    }
}