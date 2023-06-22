public class Admin extends User{
    @Override
    public void Blokuj() {
        this.zablokowane = false;
        System.out.println("nie da sie zablokowac admina");
    }

    @Override
    public boolean Czy_admin() {
        return true;
    }

    @Override
    public String toString() {
        return super.toString() + " user to admin";
    }

}
