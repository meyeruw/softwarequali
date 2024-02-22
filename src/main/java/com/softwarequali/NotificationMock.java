package com.softwarequali;

public class NotificationMock {

    // Manager Notification
    private boolean wasManagerNotified = false;

    public void notifyManager() {
        wasManagerNotified = true;
        System.out.println("Manager notified");
    }

    public boolean wasManagerNotified() {
        return wasManagerNotified;
    }

    // Maintenance Team Information
    private boolean wasMaintenanceTeamInformed = false;

    public void notifyMaintenanceTeam() {
        wasMaintenanceTeamInformed = true;
        System.out.println("Maintenance team informed");
    }

    public boolean wasMaintenanceTeamInformed() {
        return wasMaintenanceTeamInformed;
    }

}