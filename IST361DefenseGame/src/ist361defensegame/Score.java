/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ist361defensegame;

/**
 *
 * @author lvb5297
 */
public class Score {
    private String username;
    private int score;
    
    public Score(String u, int s){
        this.username = u;
        this.score = s;
    }
    
    public int getScore(){
        return this.score;
    }
    
    public String getUsername(){
        return this.username;
    }
}
