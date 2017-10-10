/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import ist361defensegame.Score;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;
import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;

/**
 *
 * @author jvl6013
 */
public class HighscoreUI {
    Map<String,Integer> scoreMap;
    DefaultListModel listModel;
    
    public HighscoreUI(TreeMap<String,Integer> scoreMap){
        listModel = new DefaultListModel();
        this.scoreMap = scoreMap;
        
        JFrame scoreFrame = new JFrame();
        scoreFrame.setSize(new Dimension(200, 400));
                
        JPanel scorePanel = new JPanel();
        scorePanel.setLayout(new GridLayout(1,1));
        
        listModel.addElement("Highscore");
        listModel.addElement("---------------------------------------------");
        
        for(Map.Entry<String,Integer> entry : scoreMap.entrySet()) {
            listModel.addElement(entry.getKey() + ":" + entry.getValue());
        }
        
        JList scoreList = new JList(listModel);
        
        scorePanel.add(scoreList);
        scoreFrame.add(scorePanel);
        
        scoreFrame.setVisible(true);
        scoreFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void updateScore(Score sc){
        if(scoreMap.containsKey(sc.getUsername())){
            if(scoreMap.get(sc.getUsername()) < sc.getScore()){
                scoreMap.put(sc.getUsername(), sc.getScore());

            }
        }
        else{
            scoreMap.put(sc.getUsername(), sc.getScore());
            
        }
        
        Map<String, Integer> sortedMap = sortScores(scoreMap);
        
        listModel.removeAllElements();
        
        listModel.addElement("Highscore");
        listModel.addElement("---------------------------------------------");

        for(Map.Entry<String,Integer> entry : sortedMap.entrySet()) {
            listModel.addElement(entry.getKey() + ":" + entry.getValue());
        }
        
    }
    
    private <K, V extends Comparable<V>> Map<K, V> sortScores(final Map<K, V> map) {
        Comparator<K> valueComparator =  new Comparator<K>() {
            public int compare(K k1, K k2) {
                int compare = map.get(k2).compareTo(map.get(k1));
                if (compare == 0) return 1;
                else return compare;
            }
        };
        Map<K, V> sortedByValues = new TreeMap<K, V>(valueComparator);
        sortedByValues.putAll(map);
        
        return sortedByValues;
    }
    
    

}

