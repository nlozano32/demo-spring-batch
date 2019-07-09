package com.examplespringbatch.demo.source;

import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import java.io.IOException;

@Configuration
@EnableAsync
@EnableScheduling

public class GetUrl {

    @Scheduled(cron="*/5 * * * * MON-FRI")
    public void example(){

        System.out.println ("test");


        int count = 0;
        System.out.println("Output from Server ....");
        String requestURL = "http://azote.adexflow.com:8080/BdBridgeDashboard/findStateByYear?year1=2016&year2=2017&year3=2018";

        try {
            HttpUtility.sendGetRequest(requestURL);
        } catch (IOException e) {
            e.printStackTrace ( );
        }
        String[] response = new String[0];
        try {
            response = HttpUtility.readMultipleLinesResponse();
        } catch (IOException e) {
            e.printStackTrace ( );
        }
        for (String line : response) {
            count++;
            System.out.println(line);
        }

        HttpUtility.disconnect();
        System.out.println("Successful loading");
        System.out.println("Number of core imported " + count + "\n");
    }

    }


