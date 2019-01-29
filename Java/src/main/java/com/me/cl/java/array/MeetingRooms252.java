package com.me.cl.java.array;

/**
 * Given an array of meeting time intervals consisting of start and end times [[s1,e1],[s2,e2],...] (si < ei), determine if a person could attend all meetings.
 *
 * Example 1:
 *
 * Input: [[0,30],[5,10],[15,20]]
 * Output: false
 * Example 2:
 *
 * Input: [[7,10],[2,4]]
 * Output: true
 */
public class MeetingRooms252 {
    public boolean canAttendMeetings(Interval[] intervals) {
        if(intervals.length==0) return true;
        for(int i=0;i<intervals.length;i++){
            int currentStart=intervals[i].start;
            int currentEnd=intervals[i].end;
            for(int j=0;j<=i-1;j++){
                int lastStart=intervals[j].start;
                int lastEnd=intervals[j].end;
                if(currentStart>=lastEnd){

                }else if(currentStart>=lastStart&&currentStart<lastEnd){
                    return false;
                }else if(currentEnd>lastStart){
                    return false;
                }
            }
        }
        return true;
    }
    //Definition for an interval.
    public class Interval {
        int start;
        int end;
        Interval() { start = 0; end = 0; }
        Interval(int s, int e) { start = s; end = e; }
    }
}
