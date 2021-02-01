package controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import service.TestService;

@Controller
public class BaseController {

    @Autowired
    protected TestService testService;

    protected Logger LOGGER = LogManager.getLogger();
}
