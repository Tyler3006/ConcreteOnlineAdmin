/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package nz.co.concreteOnlineA.JobHandling;

/**
 *
 * @author Tyler Costa
 */
public class ConcreteJobOrder {

    private String jobID, jobName, jobDescription, timeStamp, jobStatus;

    public ConcreteJobOrder(String jobID, String jobName, String jobDescription, String timeStamp, String jobStatus) {
        this.jobID = jobID;
        this.jobName = jobName;
        this.jobDescription = jobDescription;
        this.timeStamp = timeStamp;
        this.jobStatus = jobStatus;

    }

    /**
     * @return the jobDescription
     */
    public String getJobDescription() {
        return jobDescription;
    }

    /**
     * @param jobDescription the jobDescription to set
     */
    public void setJobDescription(String jobDescription) {
        this.jobDescription = jobDescription;
    }

    /**
     * @return the jobName
     */
    public String getJobName() {
        return jobName;
    }

    /**
     * @param jobName the jobName to set
     */
    public void setJobName(String jobName) {
        this.jobName = jobName;
    }

    /**
     * @return the jobID
     */
    public String getJobID() {
        return jobID;
    }

    /**
     * @param jobID the jobID to set
     */
    public void setJobID(String jobID) {
        this.jobID = jobID;
    }

    /**
     * @return the timeStamp
     */
    public String getTimeStamp() {
        return timeStamp;
    }

    /**
     * @param timeStamp the timeStamp to set
     */
    public void setTimeStamp(String timeStamp) {
        this.timeStamp = timeStamp;
    }

    /**
     * @return the jobStatus
     */
    public String getJobStatus() {
        return jobStatus;
    }

    /**
     * @param jobStatus the jobStatus to set
     */
    public void setJobStatus(String jobStatus) {
        this.jobStatus = jobStatus;
    }

    public String toString(){
        return  jobID + "|" +jobName + "|" + jobDescription + "|" + timeStamp + "|" + jobStatus;
    }
    
}
