package data;

public class SingletonCompany
{
    private static SingletonCompany instance = null;
    private SingletonCompany() {}

    public static SingletonCompany getInstance()
    {
        if(instance == null)
        {
            instance = new SingletonCompany();
        }
        return instance;
    }
}
