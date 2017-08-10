package com.ltaake.kata.sps;

import com.ltaake.kata.sps.model.ComputerPlayer;
import com.ltaake.kata.sps.model.OriginalGame;
import com.ltaake.kata.sps.model.RoundRobin;
import com.ltaake.kata.sps.model.WellAddedGame;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GameConfiguration {

    @Bean
    public ComputerPlayer originalPlayer() {
        return new RoundRobin(new OriginalGame());
    }

    @Bean
    public ComputerPlayer wellPlayer() {
        return new RoundRobin(new WellAddedGame());
    }
}
