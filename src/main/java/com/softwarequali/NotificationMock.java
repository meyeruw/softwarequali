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
    private boolean wasMaintenanceTeamNotified = false;

    public void notifyMaintenanceTeam() {
        wasMaintenanceTeamNotified = true;
        System.out.println("Maintenance team informed");
    }

    public boolean wasMaintenanceTeamNotified() {
        return wasMaintenanceTeamNotified;
    }

}
