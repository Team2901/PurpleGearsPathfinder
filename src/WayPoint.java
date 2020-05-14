import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class WayPoint extends Circle implements Drawable {
    public Drawable drawBefore = null;
    public Drawable drawAfter = null;
    public Color originalColor;
    public Circle subCircle;

    public WayPoint(int xPoint, int yPoint, int i, int bufferZone) {
        this(xPoint, yPoint, i, bufferZone, Color.BLACK);
    }

    private WayPoint(int xPoint, int yPoint, int i, int bufferZone, Color color) {
        super(xPoint, yPoint, bufferZone, Color.TRANSPARENT);
        originalColor = color;
        subCircle = new Circle(xPoint, yPoint, i, originalColor);
    }

    public WayPoint getPriorPoint(){
        LineConnector line = (LineConnector) this.getBefore();

        if(line == null){
            return null;
        }

        return (WayPoint) line.getBefore();
    }

    public WayPoint getNextPoint() {
        LineConnector line = (LineConnector) this.getAfter();

        if(line == null){
            return null;
        }

        return (WayPoint) line.getAfter();
    }

    @Override
    public void setBefore(Drawable before) {
        this.drawBefore = before;
    }

    @Override
    public void setAfter(Drawable after) {
        this.drawAfter = after;
    }

    @Override
    public Drawable getBefore() {
        return this.drawBefore;
    }

    @Override
    public Drawable getAfter() {
        return this.drawAfter;
    }

    public void setSelected(boolean selected){
        if(selected){
            subCircle.setFill(Color.GREEN);
        }else{
            subCircle.setFill(originalColor);
        }
    }

    boolean isFirstPoint() {
        return originalColor.equals(Color.RED);
    }

    public void setFirstPoint(boolean b) {
        if(b == false){
            subCircle.setFill(Color.BLACK);
            originalColor = Color.BLACK;
        } else {
            subCircle.setFill(Color.RED);
            originalColor = Color.RED;
        }
    }
}
