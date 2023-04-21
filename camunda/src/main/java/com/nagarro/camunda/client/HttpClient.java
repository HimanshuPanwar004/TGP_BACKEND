package com.nagarro.camunda.client;

import com.nagarro.camunda.model.FunderBasicDetails;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class HttpClient {
    private String apiKey;
    private String url;

    public HttpClient(String apiKey, String url) {
        this.apiKey = apiKey;
        this.url = url;
    }

    public String makeRequest(URL url) throws Exception {
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("GET");
        //con.setRequestProperty("Authorization", "Bearer " + apiKey);

        int responseCode = con.getResponseCode();
        if (responseCode != 200) {
            throw new Exception("Request failed with status code " + responseCode);
        }

        BufferedReader in = new BufferedReader(
                new InputStreamReader(con.getInputStream()));
        String inputLine;
        StringBuilder response = new StringBuilder();

        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();

        return response.toString();
    }

    public FunderBasicDetails getDetails() {
        String response = "";

        try {
            java.net.URL url = new URL(this.url+this.apiKey);
            response = this.makeRequest(url);
        } catch (Exception e) {
            System.out.println(e);
        }

        FunderBasicDetails ioSignupDetail = this.parseToIoSignUpDetail(response);
        return ioSignupDetail;
    }

    private FunderBasicDetails parseToIoSignUpDetail(String response) {
        FunderBasicDetails funderBasicDetails = new FunderBasicDetails();
        JSONObject jsonObject = null;
        JSONObject ioObject = null;

        try {
            jsonObject = new JSONObject(response);
            ioObject = jsonObject.getJSONArray("data").getJSONObject(0);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return funderBasicDetails;
    }
}
