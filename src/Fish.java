import java.awt.*;

public class Fish extends Swimmable{
    private static final int EAT_DISTANCE = 4;
    private int size;
    private int col;
    private int eatCount;
    private int x_front, y_front, x_dir, y_dir;

    /**
     * default constructor
     */
    public Fish() {
        super();
    }

    /**
     * constructor given parameters
     * @param size base size of fish
     * @param x_front for future use
     * @param y_front for future use
     * @param horSpeed horizontal speed
     * @param verSpeed vertical speed
     * @param col fish color
     */
    public Fish(int size, int x_front, int y_front, int horSpeed, int verSpeed, int col) {
        super(horSpeed, verSpeed);
        this.size = size;
        this.x_front = x_front;
        this.y_front = y_front;
        this.verSpeed = verSpeed;
        this.col = col;
        this.y_dir = 1;
        this.x_dir = 1;
        this.eatCount = 0;
    }


    public String getAnimalName() {
        return "q3.Fish";
    }
    public int getEatCount() {
        return this.eatCount;
    }
    public int getSize() {
        return this.size;
    }
    public String getColor() {
        return switch (col) {
            case 1 -> "Black";
            case 2 -> "Red";
            case 3 -> "Blue";
            case 4 -> "Green";
            case 5 -> "Cyan";
            case 6 -> "Orange";
            case 7 -> "Yellow";
            case 8 -> "Magenta";
            case 9 -> "Pink";
            default -> " ";
        };
    }

    public void eatInc() {
        eatCount++;
        if (eatCount > EAT_DISTANCE) {
            size++;
            eatCount = 0;
        }
    }

    /**
     * getter of how much a fish can eat
     * @return how much a fish can eat
     */
    public int getEAT_DISTANCE() {
        return EAT_DISTANCE;
    }

    /**
     * setter of base size of fish
     * @param size base size of fish
     */
    public void setSize(int size) {
        this.size = size;
    }

    /**
     * getter
     * @return color of fish
     */
    public int getCol() {
        return col;
    }

    /**
     * setter
     * @param col color of fish
     * @return true if successful, otherwise false
     */
    public Boolean setCol(int col) {
        this.col = col;
        return true;
    }

    /**
     * setter
     * @param eatCount how much a fish ate
     * @return true if successful, otherwise false
     */
    public boolean setEatCount(int eatCount) {
        this.eatCount = eatCount;
        return true;
    }

    /**
     * getter (future use)
     * @return future use
     */
    public int getX_front() {
        return x_front;
    }

    /**
     * future use
     * @param x_front
     * @return future use
     */
    public boolean setX_front(int x_front) {
        this.x_front = x_front;
        return true;
    }

    /**
     * getter (future use)
     * @return future use
     */
    public int getY_front() {
        return y_front;
    }

    /**
     * setter (future use)
     * @param y_front
     * @return future use
     */
    public boolean setY_front(int y_front) {
        this.y_front = y_front;
        return true;
    }

    /**
     * getter (future use)
     * @return future use
     */
    public int getX_dir() {
        return x_dir;
    }

    /**
     * setter (future use)
     * @param x_dir
     * @return future use
     */
    public boolean setX_dir(int x_dir) {
        this.x_dir = x_dir;
        return true;
    }

    /**
     * getter future use
     * @return future use
     */
    public int getY_dir() {
        return y_dir;
    }

    /**
     * setter (future use)
     * @param y_dir
     * @return future use
     */
    public boolean setY_dir(int y_dir) {
        this.y_dir = y_dir;
        return true;
    }

    /**
     * change size of fish
     * @return new size of fish
     */
    public int changeFish() {
        if (eatCount == EAT_DISTANCE)
            size++;
        return size;
    }

    /**
     * changes color of fish in a circular form(9-->1)
     */
    public void changeColor() {
        if (col < 9)
            setCol(col + 1);
        else
            setCol(1);
    }

    public void drawAnimal(Graphics g)
    {
        g.setColor(col);
        if(x_dir==1) // fish swims to right side
        {
            // Body of fish
            g.fillOval(x_front - size, y_front - size/4, size, size/2);

            // Tail of fish
            int[] x_t={x_front-size-size/4,x_front-size-size/4,x_front-size};
            int [] y_t = {y_front - size/4, y_front + size/4, y_front};
            Polygon t = new Polygon(x_t,y_t,3);
            g.fillPolygon(t);

            // Eye of fish
            Graphics2D g2 = (Graphics2D) g;
            g2.setColor(new Color(255-col.getRed(),255-col.getGreen(),255- col.getBlue()));
            g2.fillOval(x_front-size/5, y_front-size/10, size/10, size/10);

            // Mouth of fish
            if(size>70)
                g2.setStroke(new BasicStroke(3));
            else if(size>30)
                g2.setStroke(new BasicStroke(2));
            else
                g2.setStroke(new BasicStroke(1));
            g2.drawLine(x_front, y_front, x_front-size/10, y_front+size/10);
            g2.setStroke(new BasicStroke(1));
        }
        else // fish swims to left side
        {
            // Body of fish
            g.fillOval(x_front, y_front - size/4, size, size/2);

            // Tail of fish
            int[] x_t={x_front+size+size/4,x_front+size+size/4,x_front+size};
            int [] y_t = {y_front - size/4, y_front + size/4, y_front};
            Polygon t = new Polygon(x_t,y_t,3);
            g.fillPolygon(t);

            // Eye of fish
            Graphics2D g2 = (Graphics2D) g;
            g2.setColor(new Color(255-col.getRed(),255-col.getGreen(),255-col.getBlue()));
            g2.fillOval(x_front+size/10, y_front-size/10, size/10, size/10);

            // Mouth of fish
            if(size>70)
                g2.setStroke(new BasicStroke(3));
            else if(size>30)
                g2.setStroke(new BasicStroke(2));
            else
                g2.setStroke(new BasicStroke(1));
            g2.drawLine(x_front, y_front, x_front+size/10, y_front+size/10);
            g2.setStroke(new BasicStroke(1));
        }
    }


}
