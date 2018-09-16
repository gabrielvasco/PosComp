
package com.example.gabriel.questionsposcomp;

import android.os.AsyncTask;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.Scanner;

import javax.net.ssl.HttpsURLConnection;

public class BdService {


    public String buscarQuestions() {
        final StringBuilder resposta = new StringBuilder();
        AsyncTask.execute(new Runnable() {
            @Override
            public void run() {
                try {
                    URL url = new URL("https://api.mlab.com/api/1/databases/questions/collections/questions?apiKey=NNUASzvOhixAxOH9Rehk-ItN-UCog5vr");

                    HttpsURLConnection myConnection =
                            (HttpsURLConnection) url.openConnection();
                    myConnection.setRequestMethod("GET");



                    Scanner scanner = new Scanner(url.openStream());
                    while (scanner.hasNext()) {
                        resposta.append(scanner.next());
                    }

                    //t.setText(resposta);
                } catch (Exception e) {

                }

            }
        });
        return resposta.toString();
    }




private static String converterInputStreamToString(InputStream is){
        StringBuffer buffer = new StringBuffer();
        try{
            BufferedReader br;
            String linha;

            br = new BufferedReader(new InputStreamReader(is));
            while((linha = br.readLine())!=null){
                buffer.append(linha);
            }

            br.close();
            }catch(IOException e){
                e.printStackTrace();
            }

            return buffer.toString();
        }
}
