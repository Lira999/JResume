package com.softserveinc.ita.jresume.common.entity.entityListener;

/**
 * Class for save email of user logged in system.
 */
public final class LoggedUser {
    
    /**
     * Constructor for class LoggedUser.
     */
    private LoggedUser() {
    }
    
    /**
     * ThreadLocal variable for saving email of current user.
     */
    private static ThreadLocal<String> loggedUser = new ThreadLocal<>();
    
    /**
     * Method for set email.
     * 
     * @param email
     *            is email of current user
     */
    public static void setLoggedUser(final String email) {
        loggedUser.set(email);
    }
    
    /**
     * Method for get email.
     * 
     * @return email of current user
     */
    public static String getLoggedUser() {
        return loggedUser.get();
    }
    
}
