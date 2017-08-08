package com.ltaake.kata.sps;

import com.ltaake.kata.sps.model.ComputerPlayer;
import com.ltaake.kata.sps.model.RoundRobin;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GameConfiguration {

    @Bean
    public ComputerPlayer computerPlayer() {
        return new RoundRobin();
    }
}
