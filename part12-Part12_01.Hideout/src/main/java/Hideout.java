public class Hideout<T> {
    private T hiddenObject;

    public Hideout() {
        this.hiddenObject = null;
    }

    public void putIntoHideout(T toHide) {
        this.hiddenObject = toHide;
    }

    public T takeFromHideout() {
        T temp = this.hiddenObject;
        this.hiddenObject = null;
        return temp;
    }

    public boolean isInHideout() {
        return this.hiddenObject != null;
    }

}
