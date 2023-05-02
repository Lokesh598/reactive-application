package com.lokesh.cloud.employee.controller;


import org.apache.commons.io.IOUtils;
import org.json.JSONObject;
import org.springframework.core.io.ClassPathResource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Map;

@RestController
@RequestMapping("/api/people")
public class JsonReaderController {
    @GetMapping("/ecom/cartandcheckout")
    public ResponseEntity<Map<String, Object>> getPeopleFromCartAndCheckout() throws IOException {
        ClassPathResource staticDataResource = new ClassPathResource("ecom/cartandcheckout.json");
        String staticDataString = IOUtils.toString(staticDataResource.getInputStream(), StandardCharsets.UTF_8);

        return new ResponseEntity<>(
                new JSONObject(staticDataString).toMap(),
                    HttpStatus.OK
        );
    }
    @GetMapping("/ecom/octx")
    public ResponseEntity<Map<String, Object>> getPeopleFromOmniChannelTaxation() throws IOException {
        ClassPathResource staticDataResource = new ClassPathResource("ecom/octx.json");
        String staticDataString = IOUtils.toString(staticDataResource.getInputStream(), StandardCharsets.UTF_8);

        return new ResponseEntity<>(
                new JSONObject(staticDataString).toMap(),
                HttpStatus.OK
        );
    }
    @GetMapping("/ecom/ospg")
    public ResponseEntity<Map<String, Object>> getPeopleFromOnlineShoppingPaymentGateway() throws IOException {
        ClassPathResource staticDataResource = new ClassPathResource("ecom/ospg.json");
        String staticDataString = IOUtils.toString(staticDataResource.getInputStream(), StandardCharsets.UTF_8);

        return new ResponseEntity<>(
                new JSONObject(staticDataString).toMap(),
                HttpStatus.OK
        );
    }
    @GetMapping("/ecom/storemobility")
    public ResponseEntity<Map<String, Object>> getPeopleFromStoreMobility() throws IOException {
        ClassPathResource staticDataResource = new ClassPathResource("ecom/storemobility.json");
        String staticDataString = IOUtils.toString(staticDataResource.getInputStream(), StandardCharsets.UTF_8);

        return new ResponseEntity<>(
                new JSONObject(staticDataString).toMap(),
                HttpStatus.OK
        );
    }
}
