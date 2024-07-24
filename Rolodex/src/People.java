public class People
{
    private String firstName;
    private String lastName;
    private String number;
    private String address;

    public People (String fName, String lName, String num, String add)
    {
        firstName = fName;
        lastName = lName;
        number = num;
        address = add;
    }

    public String getNumber()
    {
        return number;
    }

    public void setNumber(String number)
    {
        this.number = number;
    }

    public void setFName (String firstName)
    {
        this.firstName = firstName;
    }

    public void setLName (String lastName)
    {
        this.lastName = lastName;
    }

    public void setAddress (String address)
    {
        this.address = address;
    }

    public String getFName()
    {
        return firstName;
    }

    public String getLName()
    {
        return lastName;
    }

    public String getAddress()
    {
        return address;
    }

    public String display()
    {
        return lastName + "," + firstName;
    }
}
