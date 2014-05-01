package controllers;


import com.avaje.ebean.Ebean;
import com.fasterxml.jackson.databind.JsonNode;
import models.MatchUser;
import play.api.libs.ws.Response;
import play.api.libs.ws.WS;
import play.db.ebean.Model;
import play.libs.Json;
import play.mvc.BodyParser;
import play.mvc.Controller;
import play.mvc.Result;
import play.mvc.Results;
import scala.concurrent.Await;
import scala.concurrent.Future;
import scala.concurrent.duration.Duration;

import java.util.List;
import java.util.concurrent.TimeUnit;

//import play.libs.WS;


/**
 * Created with IntelliJ IDEA.
 * MatchUser: shekhargulati
 * Date: 27/11/13
 * Time: 5:42 PM
 * To change this template use File | Settings | File Templates.
 */
public class MatchUserController {

    public static Result allUsers(){
        //List<MatchUser> users = new Model.Finder(String.class, MatchUser.class).all();
        // Newest First!
        List<MatchUser> users =Ebean.find(MatchUser.class).order().desc("id").findList();
        return Results.ok(Json.toJson(users));
    }

    @BodyParser.Of(BodyParser.Json.class)
    public static Result submitUser(){
        JsonNode jsonNode = Controller.request().body().asJson();
        String username = jsonNode.findPath("username").textValue();
        String password = jsonNode.findPath("password").textValue();
        String email = jsonNode.findPath("email").textValue();
        MatchUser user = new MatchUser(username,password,email);
        user.save();
        return Results.created();
    }

    public static Result getUser(String userId){
        MatchUser user = new Model.Finder<String, MatchUser>(String.class, MatchUser.class).byId(userId);
        if(user == null){
            return Results.notFound("No user found with userId " + userId);
        }
        return Results.ok(Json.toJson(user));
    }

   /* @BodyParser.Of(BodyParser.Json.class)
    public static Result submitStory(){
        JsonNode jsonNode = Controller.request().body().asJson();
        String url = jsonNode.findPath("url").asText();
        String fullname = jsonNode.findPath("fullname").asText();
        JsonNode response = fetchInformation(url);
        Story story = null;
        if(response == null){
            story = new Story(url,fullname);
        }else{
            String image = response.findPath("image").textValue();
            String text = response.findPath("text").textValue();
            String title = response.findPath("title").textValue();
            story = new Story(url,fullname, image , text , title);
        }
        story.save();
        return Results.created();
    }

    public static Result getStory(String storyId){
        Story story = new Model.Finder<String, Story>(String.class, Story.class).byId(storyId);
        if(story == null){
            return Results.notFound("No story found with storyId " + storyId);
        }
        return Results.ok(Json.toJson(story));
    }*/

    private static JsonNode fetchInformation(String url){
        System.out.println("fetching url="+url);
        String restServiceUrl = "http://gooseextractor-t20.rhcloud.com/api/v1/extract?url="+url;
        Future<Response> future = WS.url(restServiceUrl).get();
        //F.Promise<WS.Response> future = WS.url(restServiceUrl).get();
        try {
            Response result = Await.result(future, Duration.apply(30, TimeUnit.SECONDS));
            //WS.Response result = future.get(30, TimeUnit.SECONDS);
            System.out.println("result ="+url);
            JsonNode jsonNode = Json.parse(result.json().toString());
            //JsonNode jsonNode = Json.parse(result.asJson().toString());
            return jsonNode;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }

}