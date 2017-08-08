package com.ltaake.kata.sps.model;

import org.springframework.stereotype.Component;

/**
 * Interface for computer players.
 */
@Component
public interface ComputerPlayer {

    Shape choose();
}
