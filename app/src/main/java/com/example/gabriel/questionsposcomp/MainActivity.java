package com.example.gabriel.questionsposcomp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.mongodb.BasicDBObject;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.Mongo;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.MongoIterable;
import com.mongodb.util.JSON;

import org.bson.Document;
import org.json.JSONObject;
import org.w3c.dom.Text;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MongoClientURI uri = new MongoClientURI("mongodb://Vasco:vasco123@ds251022.mlab.com:51022/questions");
        MongoClient mongoClient = new MongoClient(uri);
        MongoDatabase data = mongoClient.getDatabase(uri.getDatabase());

        MongoCollection<Document> doc = data.getCollection("questions");

        TextView t = (TextView) findViewById(R.id.text);

        FindIterable<Document> docs = doc.find();


        if (docs == null) {
           t.setText("nao deu");
        }

        for(Document dd : docs) {
            //access documents e.g. doc.get()
            t.setText(dd.getString("url"));
        }




    }




}
