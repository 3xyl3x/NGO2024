
package models;

public class Goal {
    private int id;
    private String name;
    private int number;
    private String description;
    private int priority;


public Goal(int id, String name, int number, String description, int priority)
{
    this.id = id;
    this.name = name;
    this.number = number;
    this.description = description;
    this.priority = priority;
}


public int getId()
{
    return id;
}
public String getName()
{
    return name;
}
public int getNumber()
{
    return number;
}
public String getDescription()
{
    return description;
}
public int getPriority()
{
    return priority;
}

public void setId(int id)
{
    this.id = id;
}
public void setName(String name)
{
    this.name = name;
}
public void setNumber(int number)
{
    this.number = number;
}
public void setDescription(String description)
{
    this.description = description;
}
public void setPriority(int priority)
{
    this.priority = priority;
}
}
