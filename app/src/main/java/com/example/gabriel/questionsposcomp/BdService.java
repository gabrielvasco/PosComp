
package com.example.gabriel.questionsposcomp;

import android.os.AsyncTask;
import android.util.Log;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

import javax.net.ssl.HttpsURLConnection;



public class BdService {

    private String resp;
    final BdCredencials credencials= new BdCredencials();
    public void buscarQuestions() {

        final StringBuilder resposta = new StringBuilder();
        AsyncTask.execute(new Runnable() {
            @Override
            public void run() {
                try {
                    URL url = new URL("https://api.mlab.com/api/1/databases/questions/collections/questions?apiKey="+credencials.getApiKey());

                    HttpsURLConnection myConnection =
                            (HttpsURLConnection) url.openConnection();
                    myConnection.setRequestMethod("GET");

                    Scanner scanner = new Scanner(url.openStream());
                    while (scanner.hasNext()) {
                        resposta.append(scanner.next());
                    }
                    resp = resposta.toString();
                } catch (Exception e) {
                }

            }
        });
        Log.d("Final", resposta.toString());
    }

    public String getResp() {
        return this.resp;
    }

    public void inserirQuestions() {

        final StringBuilder resposta = new StringBuilder();
        AsyncTask.execute(new Runnable() {
            @Override
            public void run() {
                try {
                    URL url = new URL("https://api.mlab.com/api/1/databases/questions/collections/questions?apiKey="+credencials.getApiKey());

                    HttpsURLConnection myConnection =
                            (HttpsURLConnection) url.openConnection();
                    myConnection.setRequestMethod("POST");
                    myConnection.setRequestProperty("url", "www.com");
                    myConnection.setRequestProperty("tipo", "port");
                    myConnection.setRequestProperty("opc_cor", "B");

                    Scanner scanner = new Scanner(url.openStream());
                    while (scanner.hasNext()) {
                        resposta.append(scanner.next());
                    }
                    resp = resposta.toString();
                } catch (Exception e) {
                }

            }
        });
    }


    private static String converterInputStreamToString(InputStream is) {
        StringBuffer buffer = new StringBuffer();
        try {
            BufferedReader br;
            String linha;

            br = new BufferedReader(new InputStreamReader(is));
            while ((linha = br.readLine()) != null) {
                buffer.append(linha);
            }

            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return buffer.toString();
    }

    public void sendPost() {

        AsyncTask.execute(new Runnable() {
            @Override
            public void run() {
                try {

                    URL url = new URL("https://api.mlab.com/api/1/databases/questions/collections/questions?apiKey="+credencials.getApiKey());
                    HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                    conn.setDoOutput(true);
                    conn.setRequestMethod("POST");
                    //conn.setRequestProperty("Content-Type", "application/json");

                    String input = "{'url': 'teste','opc_cor':'B','tipo':'B'}";

                    OutputStream os = conn.getOutputStream();
                    os.write(input.getBytes());
                    os.flush();


                    BufferedReader br = new BufferedReader(new InputStreamReader(
                            (conn.getInputStream())));

                    conn.disconnect();


                } catch (Exception e) {



                }
            }
        });
    }
}




