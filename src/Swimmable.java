import java.awt.*;
import java.util.concurrent.CyclicBarrier;

/**
 * * @author Matan Daniel, 315783522 and Ron Bar-Zvi, 304969520
 */

public abstract class Swimmable extends Thread{
    /**
     * horizontal speed
     */
    protected int horSpeed;
    /**
     * vertical speed
     */
    protected int verSpeed;
    /**
     * Default constructor
     */
    public Swimmable()
    {
        horSpeed = 0;
        verSpeed = 0;
    }

    /**
     * converts animal properties in string format
     * @return animal properties in string format
     */
    public String toString() {
        return String.format("%-16s|%-10s|%-10d|%-10d",this.getAnimalName(),this.getColor(),this.getSize(), this.getEatCount());
    }
    /**
     * constructor given parameters
     * @param horSpeed
     * @param verSpeed
     */
    public Swimmable(int horSpeed, int verSpeed)
    {
        this.horSpeed = horSpeed;
        this.verSpeed = verSpeed;
    }

    /**
     * get horizontal speed
     * @return horizontal speed
     */
    public int getHorSpeed() {return horSpeed;}

    /**
     * set Horizontal speed
     * @param horSpeed Horizontal speed
     */
    public void setHorSpeed(int horSpeed) {this.horSpeed = horSpeed;}
    /**
     * get vertical speed
     * @return vertical speed
     */
    public int getVerSpeed() {return verSpeed;}

    /**
     * set vertical speed
     * @param verSpeed Vertical speed
     */
    public void setVerSpeed(int verSpeed) {this.verSpeed = verSpeed;}

    /**
     * gets animal name
     * @return animal name
     */
    public abstract String getAnimalName();

    /**
     * gets value of how much an animal has ate
     * @return how much an animal has ate
     */
    public abstract int getEatCount();

    /**
     * getter of animal size
     * @return animal size
     */
    public abstract int getSize();

    /**
     * getter of animal color
     * @return animal color
     */
    public abstract String getColor();

    /**
     * increases amount that an animal has ate by 1
     */
    public abstract void eatInc();

    /**
     * compares size between current animal and received animal object
     * @param other
     * @return size difference (current minus other)
     */
    public int compareTo(Swimmable other)
    {
        return this.getSize() - other.getSize();
    }

    /**
     * Because of the onion principle if we make equals only in the base class, it will be applied to all
     * derived classes.
     * @param swimmable
     * @return returns whether horSpeed equals to received object's, as well as for verSpeed
     */
    public boolean equals(Swimmable swimmable){
        return this.horSpeed == swimmable.getHorSpeed() && this.verSpeed == swimmable.getVerSpeed() ;
    }

    abstract public void drawAnimal(Graphics g);
    abstract public void setSuspend();
    abstract public void setResume();
    abstract public void setBarrier(CyclicBarrier b);

}
