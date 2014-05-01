package controllers;


//import views.html.index;


import models.Bar;
import models.MatchUser;
import org.springframework.beans.factory.annotation.Autowired;
import play.data.Form;
import play.libs.Json;
import play.mvc.Result;
import views.html.index;


@org.springframework.stereotype.Controller
public class Application {

   /* @Autowired
    private BarService barService;
*/
    public static Result index() {
        return play.mvc.Controller.ok(index.render());
    }





  /* public Result addBar() {
        Form<Bar> form = Form.form(Bar.class).bindFromRequest();
        Bar bar = form.get();
        barService.addBar(bar);
        return play.mvc.Controller.redirect(controllers.routes.Application.index());
    }

    public Result listUsers() {
        return play.mvc.Controller.ok(Json.toJson(barService.getAllBars()));
    }*/
    
}