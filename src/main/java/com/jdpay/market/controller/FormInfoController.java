package com.jdpay.market.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


/**
 * @author Zac
 */
@Controller
@SuppressWarnings("UnusedDeclaration")
public class FormInfoController {

    private Logger LOGGER = LoggerFactory.getLogger(FormInfoController.class);

    @RequestMapping(value = "/getFormInfo/{subActivityId}", method = RequestMethod.GET)
    @ResponseBody
    public String getFormInfo(@PathVariable String subActivityId){
        return subActivityId;
    }

    @RequestMapping(value = "/audit/success/{subActivityId}",method = RequestMethod.POST)
    @ResponseBody
    public void success(@PathVariable String subActivityId,@RequestParam String error){
        LOGGER.info("error="+error+"---subActivityId="+subActivityId);
    }

    @RequestMapping(value = "/audit/fail/{subActivityId}",method = RequestMethod.POST)
    @ResponseBody
    public void fail(@PathVariable String subActivityId){
    }
}
