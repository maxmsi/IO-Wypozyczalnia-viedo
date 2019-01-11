/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testy_fitnesse_fixture;


import wypo.Movie;
import wypo.Status;
import wypo.Form;
import fit.ColumnFixture;


public class test_add_movie extends ColumnFixture {
    
    int index_of_title;
    Status sts;
    Form frm;
   
    
    int s1,s2;
     
    
    public boolean addMovie(){
        s1=check_size();
        try{
            SetUp.movie= new Movie(SetUp.fcd.titleList.get(index_of_title), SetUp.sts,SetUp.frm);
            SetUp.fcd.addMovie(SetUp.movie);
            }
        catch (IndexOutOfBoundsException e) {
            return false;
            }
        s2=check_size();
        return s1!=s2;
      
}
    
    public int check_size(){
        
       return SetUp.fcd.movieList.size();
        
}
}