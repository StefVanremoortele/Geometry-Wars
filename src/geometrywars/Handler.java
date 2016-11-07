

package geometrywars;

import java.awt.Graphics;
import java.util.LinkedList;

// Handler voert x-aantal keer per seconde tick() en render(Graphics) uit
// Dit zorgt voor de frames
public class Handler {
    
    // Object houdt alle game object bij van de game die gerenderd moeten worden
    LinkedList<GameObject> object = new LinkedList<>();
    
    // Dit is voor het update van de objecten (nieuwe locX en locY)
    public void tick(){
        for (int i = 0; i < object.size(); i++){
            GameObject tempObject = object.get(i);
            tempObject.tick();
        }
    }
    public void render(Graphics g){
        for(int i = 0; i < object.size(); i++){
            GameObject tempObject = object.get(i); 
            tempObject.render(g);
        }
    }
    public void addObject(GameObject obj){
        this.object.add(obj);
    }
    public void removeObject(GameObject obj){
        this.object.remove(obj);
    }
}
