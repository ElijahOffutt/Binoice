package com.binoice.binoice.tts;

import java.io.ByteArrayInputStream;
import java.util.Map;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;

import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
public class TTSService {

    private final WebClient webClient;

    public TTSService(WebClient webClient) {
        this.webClient = webClient;
    }

    private void playAudio(byte[] audioBytes) {

        try {

            AudioInputStream audioStream =
                    AudioSystem.getAudioInputStream(
                            new ByteArrayInputStream(audioBytes)
                    );

            var format = audioStream.getFormat();

            var line = AudioSystem.getSourceDataLine(format);

            line.open(format);
            line.start();

            byte[] buffer = new byte[4096];

            int bytesRead;

            while ((bytesRead = audioStream.read(buffer)) != -1) {
                line.write(buffer, 0, bytesRead);
            }

            line.drain();
            line.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void sendTTSRequest(String text) {
        String ttsEndpoint = "http://192.168.1.201:8000/v1/audio/speech"; // Replace with your TTS server endpoint

        Map<String, String> request = Map.of(
                "model", "tts-1-hd",
                "input", text,
                "voice", "testuser",
                "response_format", "wav"
        );

        webClient.post()
                .uri(ttsEndpoint)
                .bodyValue(request)
                .retrieve()
                .bodyToMono(byte[].class)
                // .toEntity(byte[].class)
                .subscribe(
                        response -> {
                            // System.out.println("Content-Type: " + response.getHeaders().getContentType());
                            // System.out.println("Audio bytes: " + response.getBody().length);
                            System.out.println("Received audio bytes: " + response.length);
                            playAudio(response);
                        },
                        error -> System.err.println("Error sending TTS request: " + error.getMessage())
                );
    }

}