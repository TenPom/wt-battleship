package models;

import java.util.Map;
import java.util.TreeMap;

import de.htwg.battleship.model.IBoard;
import de.htwg.battleship.model.IShip;
import de.htwg.battleship.util.StatCollection;

public class Converter {
    
    private static final char FIELD_EMPTY = 'O';
    private static final char FIELD_SHIP  = 'S'; 
    
    private static final int SHIP_DUMMY = -1;
    
    public static Map<Integer, Map<Integer, Character>> createShipMap(IBoard board) {
        
        Map<Integer, Map<Integer, Character>> shipMap = initMap();
        System.out.println(shipMap);
        IShip[] shipList = board.getShipList();
        for(IShip ship : shipList) {
            if(null == ship)
                continue;
            if(ship.getSize() == SHIP_DUMMY) {
                System.out.println("skip Ship ..");
                continue;
            }
            System.out.println("richtiges schiff..");
            if(ship.isOrientation()) {
                int y = ship.getY();
                for(int x = ship.getX(); x < (ship.getX() + ship.getSize()); x++) {
                    shipMap.get(x).remove(y);
                    shipMap.get(x).put(y, FIELD_SHIP);
                }
            } else {
                int x = ship.getX();
                for(int y = ship.getY(); x < (ship.getY() + ship.getSize()); y++) {
                    shipMap.get(x).remove(y);
                    shipMap.get(x).put(y, FIELD_SHIP);
                }
            }
        }
        System.out.println(shipMap);
        return shipMap;
    }
    
    public static Map<Integer, Map<Integer, Character>> initMap() {
        Map<Integer, Map<Integer, Character>> map = new TreeMap<>();
        for(int i = 0; i < StatCollection.STANDARD_HEIGHT_LENGTH; i++) {
            map.put(i, new TreeMap<Integer, Character>());
            for(int j = 0; j < StatCollection.STANDARD_HEIGHT_LENGTH; j++) {
                map.get(i).put(j, FIELD_EMPTY);
            }
        }
        return map;
    }
}