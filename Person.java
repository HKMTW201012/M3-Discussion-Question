public abstract class Person
{
    private int yearsOfExperience;

    public Person(int years)
    {
        this.yearsOfExperience = years;
    }

    public int getter()
    {
        return yearsOfExperience;
    }

    public void setter(int workYears)
    {
        this.yearsOfExperience = workYears;
    }
}
