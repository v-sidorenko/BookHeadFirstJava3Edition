package page299;

class Bees
{
    Honey[] beeHoney;
}

class Raccoon
{
    Kit rk;
    Honey rh;
}

class Kit
{
    Honey honey;
}

class Bear
{
    Honey hunny;
}

public class Honey
{
    public static void main(String[] args)
    {
        Honey honeyPot = new Honey(); //honeyPot=1
        Honey[] ha =
        {
            honeyPot, honeyPot, honeyPot, honeyPot
        }; //honeyPot=5, ha=1
        Bees bees = new Bees(); //bees=1
        bees.beeHoney = ha; //ha=2
        Bear[] bears = new Bear[5];
        for(int i = 0; i < 5; i++)
        {
            bears[i] = new Bear();
            bears[i].hunny = honeyPot;
        } //bears[5]=1, honeyPot=10
        Kit kit = new Kit(); //kit=1
        kit.honey = honeyPot; //honeyPot=11
        Raccoon raccoon = new Raccoon(); //raccoon=1

        raccoon.rh = honeyPot; //honeyPot=12
        raccoon.rk = kit; //kit=2
        kit = null; //kit=1
    } //  end of main
}
//honeyPot=12
//kit=1
//raccoon=1
//bears[5]=1
//bees=1
//ha=2
