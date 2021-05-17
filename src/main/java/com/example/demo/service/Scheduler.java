package com.example.demo.service;

import com.example.demo.DemoApplication;
import com.example.demo.model.Response;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;
import org.springframework.web.client.RestTemplate;

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.LineUnavailableException;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
public class Scheduler {

    @Autowired
    private RestTemplate template;
    private final List<String> ignore = new ArrayList<>();

    private final static String url = "https://cdn-api.co-vin.in/api/v2/appointment/sessions/calendarByDistrict?district_id=513&date=16-05-2021";

    @Scheduled(cron = "0/5 * * * * ?")
    public void start() {
        ignore.add("SDH Ajeetgarh");
        ignore.add("S K School Sikar Site - II");
        ignore.add("Guhala CHC");
        ignore.add("SK Hospital Sikar");
        ignore.add("Shrimadhopur Govt Hospital");
        ignore.add("MCH SIKAR");
        ignore.add("PHC Mawanda Khurd");
        ignore.add("Laxmangarh CHC");
        ignore.add("Govt Hospital Patan");
        ignore.add("SDH Neemkathana");
        ignore.add("PHC Roopgarh May");
        ignore.add("CHC Jajod Lax");
        ignore.add("PHC GANERI LAX");
        ignore.add("CHC Losal");
        ignore.add("PHC Jasrasar Lax");
        ignore.add("PHC Paritampuri");
        ignore.add("PHC Dansroli");
        ignore.add("PHC Kheerwa Lax");
        ignore.add("Khud PHC");
        ignore.add("PHC Hanspur Smpr");
        ignore.add("Jeelo Chc");
        ignore.add("Phc Patoda Lax");
        ignore.add("CHC GANESHWAR");
        ignore.add("Khud PHC");
        ignore.add("S K School Sikar Site -I");
        ignore.add("UPHC Khel Stadium Lax");
        ignore.add("CHC KANWAT 18 PULS");
        ignore.add("Phc Sirohi");
        ignore.add("Goriya PHC");
        ignore.add("DANTA CHC");
        ignore.add("CHC NECHWA LAX");
        ignore.add("Mirjwas Phc Lax");
        ignore.add("Shri K M Memorial Hospital Skr");
        ignore.add("Kochhore PHC");
        ignore.add("PHC NANGAL");
        ignore.add("CHC KHANDELA 18 PULS");
        ignore.add("PHC MANGLUNA LAX");
        ignore.add("Phc Chokri");
        ignore.add("PHC Hathideh");
        ignore.add("PHC Lisariya Smpr");
        ignore.add("PHC Nimeda");
        ignore.add("PHC Bhudoli");
        ignore.add("PHC Kotari Luharwas");
        ignore.add("UPHC Kayasth Mohlla");
        ignore.add("PHC Garoda Lax");
        ignore.add("Khachariyawas CHC");
        ignore.add("CHC Dhod");
        ignore.add("Kudan CHC");
        ignore.add("PHC Kashi Ka Bas");
        ignore.add("CHC KASLI");
        ignore.add("PHC Fatehpura Kudan");
        ignore.add("Chc Kolida PIP");
        ignore.add("PHC BAJOR PIP");
        ignore.add("CHC Gungara PIP");
        ignore.add("PHC SHYAMGARH PIP");
        ignore.add("Ranoli PHC PIP");
        ignore.add("Chc Piprali");
        ignore.add("PHC REWASA");
        ignore.add("CHC PALASARA PIP");
        ignore.add("FTR Rolsabsar CHC");
        ignore.add("FTR BESWA CHC");
        ignore.add("FTR Bhagasara PHC");
        ignore.add("FTR Batranau PHC");
        ignore.add("FTR Fatehpur CHC");
        ignore.add("FTR Harsawa Bara PHC");
        ignore.add("FTR Ramgarh Shekhawati CHC");
        ignore.add("FTR Kayamsar PHC");
        ignore.add("FTR Disnau PHC");
        ignore.add("UPHC Salaser Bus Stand");
        ignore.add("FTR Balaran PHC");
        ignore.add("PHC HOD");
        ignore.add("PHC JHARALI 18 PULS");
        ignore.add("PHC Theekhariya");
        ignore.add("Jajod CHC");
        ignore.add("Khandela CHC");
        ignore.add("BAMANWAS PHC");
        ignore.add("CHC Thoi");
        ignore.add("Chala PHC");
        ignore.add("SC Mawanda Kalan");
        ignore.add("SC MAHAWA Nkt");
        ignore.add("SC Puranabas Nkt");
        ignore.add("SC KUDLI Tarpura PIP");
        ignore.add("PHC RAJPURA PIP");
        ignore.add("Sc Vaid Ki Dhani Sangarwa PIP");
        ignore.add("Sc Bhadwasi Block Piprali");
        ignore.add("SC KUSHALPURA PHC Nada PIP");
        ignore.add("PHC Dujod");
        ignore.add("SC Khakholi Kud");
        ignore.add("FTR Jaleu PHC");
        ignore.add("FTR Raghunathpura UPHC");
        ignore.add("PHC Kirdoli Kud");
        ignore.add("PHC Banuda");
        ignore.add("PHC Mandota");
        ignore.add("PHC Kundalpur");
        ignore.add("PHC Sargoth Smpr");
        ignore.add("PHC Umara");
        ignore.add("PHC SARWADI Kudan");
        ignore.add("PHC Jugrajpura Smpr");
        ignore.add("PHC Jorawarnagar Smpr");
        ignore.add("CHC Mau Srimadhopur");
        ignore.add("PHC Jeenmata");
        ignore.add("PHC Divrala Smpr");
        ignore.add("Phc Mundru Smpr");
        ignore.add("PHC Garhbhopaji");
        ignore.add("PHC Bhadwari");
        ignore.add("PHC Gurara");
        ignore.add("PHC Panlawa Lax");
        log.info("------------------------------------------------------------------------------------------");
        log.info("------------------------------------------------------------------------------------------");
        final var headers = new HttpHeaders();
        headers.set("user-agent", "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_15_7) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/90.0.4430.212 Safari/537.36");
        final var entity = new HttpEntity(headers);
        final var response = template.exchange(url, HttpMethod.GET, entity, Response.class).getBody();
        response.getCenters().forEach(center -> {
            if(ignore.contains(center.getName())) {
                return;
            }
            center.getSessions().forEach(session -> {
                log.info("{} -- {} -- {} --- {} ----------    {} , dose1: {}", center.getName(), center.getBlockName(), center.getPincode(), session.getDate(), session.getCapacity(), session.getDose1());
                if(session.getCapacity() > 0 || session.getDose1() > 0) {
                    playAudio();
                }
            });
        });
    }

    @Async
    public void playAudio(){
        try {
            final var clip = AudioSystem.getClip();
            final var stream = AudioSystem.getAudioInputStream(new BufferedInputStream(new FileInputStream("1.wav")));
            clip.open(stream);
            clip.start();
        } catch (Exception ex) {
            log.error("Something bad happened", ex);
        }
    }
}
