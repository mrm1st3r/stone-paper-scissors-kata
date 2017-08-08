package com.ltaake.kata.sps.controller;

import com.ltaake.kata.sps.model.ComputerPlayer;
import com.ltaake.kata.sps.model.Game;
import com.ltaake.kata.sps.model.Result;
import com.ltaake.kata.sps.model.Shape;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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

    @RequestMapping(path = "/play", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public Result play(@RequestBody Shape shape) {
        return game.play(shape, player.choose());
    }
}
