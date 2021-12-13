package com.dsalgo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

//https://practice.geeksforgeeks.org/problems/n-meetings-in-one-room-1587115620/1
//Same type problem-Activity selection
public class NmeetingRoom {

    public static void main(String[] args) {
        int[] start = {1, 0, 3, 8, 5, 8};
        int[] finish = {2, 6, 4, 9, 7, 9};

        NmeetingRoom nr = new NmeetingRoom();
        List<Integer> maxMeetings = nr.maxMeetings(start, finish, start.length);
        maxMeetings.forEach(System.out::println);
    }

    private List<Integer> maxMeetings(int[] start, int[] finish, int length) {
        List<Meeting> meetings = new ArrayList<>();
        for (int i = 0; i < length; i++) {
            meetings.add(new Meeting(start[i], finish[i], i + 1));
        }

        MeetingComparator mc = new MeetingComparator();
        Collections.sort(meetings, mc);
        List<Integer> result = new ArrayList<>();

        int limit = meetings.get(0).finish;
        result.add(meetings.get(0).pos);
        for (int i = 1; i < length; i++) {
            if (meetings.get(i).start > limit) {
                result.add(meetings.get(i).pos);
                limit = meetings.get(i).finish;
            }
        }

        return result;
    }

    class Meeting {
        int start;
        int finish;
        int pos;

        Meeting(int start, int finish, int pos) {
            this.finish = finish;
            this.pos = pos;
            this.start = start;
        }
    }

    class MeetingComparator implements Comparator<Meeting> {

        @Override
        public int compare(Meeting o1, Meeting o2) {

            if (o1.finish < o2.finish) {
                return -1;
            } else if (o1.finish > o2.finish) {
                return 1;
            } else if (o1.pos < o2.pos) {
                return -1;
            } else {
                return 1;
            }
        }
    }
}
