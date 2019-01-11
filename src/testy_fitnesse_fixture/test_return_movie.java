/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testy_fitnesse_fixture;
import fit.ColumnFixture;
/**
 *
 * @author Max
 */
public class test_return_movie extends ColumnFixture {
      int index_of_movie;
    int index_of_user;
    
    public int returnMovie(){
        
         SetUp.fcd.returnMovie(SetUp.fcd.userList.get(index_of_user), SetUp.fcd.movieList.get(index_of_movie));
        return checkMovie_Uid();
   
    
}
    public int checkMovie_Uid(){
    
    return SetUp.fcd.movieList.get(index_of_movie).getUserId();
}
}