package com.ltaake.kata.sps.controller;

import com.ltaake.kata.sps.model.*;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Controller for REST api.
 */
@RestController
@RequestMapping("/play")
public class ApiController {

    private final Game original;
    private final WellAddedGame wellAddedGame;
    private final ComputerPlayer originalPlayer;
    private final ComputerPlayer wellPlayer;

    public ApiController(OriginalGame original, WellAddedGame wellAddedGame,
                         ComputerPlayer originalPlayer, ComputerPlayer wellPlayer) {
        this.original = original;
        this.wellAddedGame = wellAddedGame;
        this.originalPlayer = originalPlayer;
        this.wellPlayer = wellPlayer;
    }

    @RequestMapping(path = "/original", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public Result original(@RequestBody Shape shape) {
        return original.play(shape, originalPlayer.choose());
    }

    @RequestMapping(path = "/wellAdded", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public Result well(@RequestBody Shape shape) {
        return wellAddedGame.play(shape, wellPlayer.choose());
    }
}
