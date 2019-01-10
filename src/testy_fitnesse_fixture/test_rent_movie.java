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
import fit.ColumnFixture;
import java.util.ArrayList;
import java.util.Date;
import java.util.IllegalFormatCodePointException;
import wypo.Title;
import fit.ColumnFixture;

public class test_rent_movie extends ColumnFixture{
    
int index_of_movie;
int index_of_user;
Status state;
		
 public boolean rent_movie(){
       String message;
       message=SetUp.fcd.rentMovie(SetUp.fcd.movieList.get(index_of_movie), SetUp.fcd.userList.get(index_of_user));
       if(SetUp.fcd.movieList.get(index_of_movie).getStatus() == state.RENTED && message=="Movie rented successfully") {
            return true;}
       else {} 
          return false;
}
public Status check_status(){
    
    return SetUp.fcd.movieList.get(index_of_movie).getStatus();
    
}
}