/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testy_fitnesse_fixture;

import wypo.App;
import wypo.Facade;
import wypo.User;
import wypo.Movie;
import wypo.Status;
import wypo.Form;
import fit.Fixture;

public class SetUp extends Fixture{
   static App app;
   static Facade fcd;
   static Status sts;
    static Movie movie;
    static User usr;
    public SetUp(){
       app=new App();
       fcd = new Facade(app.userList) ;
       movie = new Movie();
      
	
	

}
}
