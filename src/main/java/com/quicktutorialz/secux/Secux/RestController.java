package com.quicktutorialz.secux.Secux;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.UnsupportedEncodingException;
import java.util.Date;

@org.springframework.web.bind.annotation.RestController
public class RestController {

    @RequestMapping("/")
    public String getHello(){
        return "Hello!";
    }

    @RequestMapping("/login")
    public ResponseEntity<JsonResponseBody> login(@RequestParam(value ="id") String id, @RequestParam(value="password") String pwd){

        try {
            Date expDate = new Date();
            Date datenow = new Date();
            expDate.setTime(datenow.getTime() + (300 * 1000));
            String jwt = JwtUtils.generateJwt(id, expDate, "nome a caso", "user");
            return ResponseEntity.status(HttpStatus.OK).header("jwt", jwt).body(new JsonResponseBody(HttpStatus.OK.value(), "Success! User logged in!"));
        }catch (UnsupportedEncodingException e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new JsonResponseBody(HttpStatus.BAD_REQUEST.value(), "Not logged!"));

        }

    }

    @RequestMapping("/users")
    public String getUsers(){
        return "list of users";
    }


    /* INNER CLASS */
    public class JsonResponseBody{
        private int server;
        private Object response;

        public JsonResponseBody(int s, Object r){
            server = s;
            response = r;
        }

    }

}
