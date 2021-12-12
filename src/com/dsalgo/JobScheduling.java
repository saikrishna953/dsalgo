package com.dsalgo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

//https://practice.geeksforgeeks.org/problems/job-sequencing-problem-1587115620/1#
public class JobScheduling {

    public static void main(String[] args) {

        List<Job> jobs = new ArrayList<>();
        JobScheduling jobScheduling = new JobScheduling();
        jobScheduling.getJobs(jobs);
        int[] answer = jobScheduling(jobs, jobs.size());
        System.out.println("Number of jobs:" + answer[0]);
        System.out.println("Max profit:" + answer[1]);
    }

    private static int[] jobScheduling(List<Job> jobs, int n) {
        Collections.sort(jobs, (a, b) -> (b.profit - a.profit));

        int maxi = 0;
        for (int i = 0; i < n; i++) {
            maxi = Math.max(maxi, jobs.get(i).deadline);
        }

        int[] result = new int[maxi + 1];
        Arrays.fill(result, -1);
        int countJobs = 0, maxProfit = 0;

        for (int i = 0; i < n; i++) {

            for (int j = jobs.get(i).deadline; j > 0; j--) {
                if (result[j] == -1) {
                    result[j] = i;
                    countJobs++;
                    maxProfit += jobs.get(i).profit;
                    break;
                }
            }

        }
        int[] ans = new int[2];
        ans[0] = countJobs;
        ans[1] = maxProfit;
        return ans;

    }

    private void getJobs(List<Job> jobs) {
        jobs.add(new Job(1, 4, 20));
        jobs.add(new Job(2, 5, 60));
        jobs.add(new Job(3, 6, 70));
        jobs.add(new Job(4, 6, 65));
        jobs.add(new Job(5, 4, 25));
        jobs.add(new Job(6, 2, 80));
        jobs.add(new Job(7, 2, 10));
        jobs.add(new Job(8, 2, 22));
    }

    class Job {
        int id;
        int deadline;
        int profit;

        public Job(int id, int deadline, int profit) {
            this.id = id;
            this.deadline = deadline;
            this.profit = profit;
        }
    }

}
