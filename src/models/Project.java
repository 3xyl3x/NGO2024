package models;

import java.time.LocalDate;

/**
 *
 * @author david, petra
 */
public class Project {

    private int id;
    private String title;
    private String description;
    private LocalDate startDate;
    private LocalDate endDate;
    private double cost;
    private String status;
    private String priority;
    private int projectManager;
    private int country;

    public Project(int id, String title, String description, LocalDate startDate, LocalDate endDate, double cost, String status, String priority, int projectManager, int country) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.startDate = startDate;
        this.endDate = endDate;
        this.cost = cost;
        this.status = status;
        this.priority = priority;
        this.projectManager = projectManager;
        this.country = country;
    }
    

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String newTitle) {
        title = newTitle;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String newDescription) {
        description = newDescription;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate newStartDate) {
        startDate = newStartDate;
    }

    public LocalDate getendDate() {
        return endDate;
    }

    public void setEndDate(LocalDate newEndDate) {
        endDate = newEndDate;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(int newCost) {
        cost = newCost;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String newStatus) {
        status = newStatus;
    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(String newPriority) {
        priority = newPriority;
    }

    public int getProjectManager() {
        return projectManager;
    }

    public void setProjectManager(int newProjectManager) {
        projectManager = newProjectManager;
    }

    public int getCountry() {
        return country;
    }

    public void setCountry(int newCountry) {
        country = newCountry;
    }

    public String toString() {
        return "ID: " + id + ", Namn: " + title + ", Prioritering " + priority + ", info: " + description + ".";
    }
}
