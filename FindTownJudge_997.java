package InfinityChampionsProgram.Day1;

import Leetcode.Recursion.java;

public class FindTownJudge_997 {
    /* public static void main(String[] args) {
        int n = 3;
        int[][] trust = { {1,3},{1,4},{2,3},{2,4},{4,3} };
        // int[][] trust = { { 1, 2 }, { 2, 3 } };
        int people[] = new int[trust.length];
        int trustPeople[] = new int[trust.length];
        for (int i = 0; i < trust.length; i++) {
            people[i] = trust[i][0];
            trustPeople[i] = trust[i][1];
    
        }
    
        int freq[] = new int[n + 1];
        for (int i = 0; i < people.length; i++) {
            freq[people[i]]++;
        }
        
        int judge = -1;
        for (int i = 1; i < freq.length; i++) {
            if (freq[i] == 0) {
                judge = findJudge(trust, n, i, trustPeople);
            }
            if (judge != -1) {
                System.out.println(judge);
                return;
            }
        }
    
        System.out.println(judge);
         
    
    }
    
    private static int findJudge(int[][] trust, int n, int judge, int[] trustPeople) {
        for (int i = 0; i < trustPeople.length; i++) {
            if (trustPeople[i] == judge) {
                return -1;
            }
        }
        return judge;
    } */
   
    public static void main(String[] args) {
        int n = 4;
        int[][] trust = { { 1, 3 }, { 1, 4 }, { 2, 3 }, { 2, 4 }, { 4, 3 } };
        int[] indegree = new int[n + 1];
        int[] outdegree = new int[n + 1];
        for (int i = 0; i < trust.length; i++) {
            indegree[trust[i][1]]++;
            outdegree[trust[i][0]]++;
        }
        int judge = -1;
        for (int i = 1; i < outdegree.length; i++) {
            if (indegree[i] == n - 1 && outdegree[i] == 0) {
                judge = i;
                break;
            }
        }
        System.out.println(judge);
    }
}
