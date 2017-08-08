package com.ltaake.kata.sps.controller;

import com.ltaake.kata.sps.model.ComputerPlayer;
import com.ltaake.kata.sps.model.Game;
import com.ltaake.kata.sps.model.Result;
import com.ltaake.kata.sps.model.Shape;
import org.springframework.web.bind.annotation.RestController;

/**
 * Controller for REST api.
 */
@RestController
public class ApiController {

    private final Game game;
    private final ComputerPlayer player;

    public ApiController(Game game, ComputerPlayer player) {
        this.game = game;
        this.player = player;
    }

    public Result play(Shape shape) {
        return game.play(shape, player.choose());
    }
}
