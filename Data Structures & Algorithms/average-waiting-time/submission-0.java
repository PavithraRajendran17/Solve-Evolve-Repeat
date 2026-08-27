class Solution {
    public double averageWaitingTime(int[][] customers) {
        long currentTime = 0;
        long totalWaiting = 0;

        for (int i = 0; i < customers.length; i++) {

            int arrival = customers[i][0];
            int time = customers[i][1];

            if (currentTime < arrival) {
                currentTime = arrival;
            }

            currentTime = currentTime + time;

            totalWaiting = totalWaiting + (currentTime - arrival);
        }

        return (double) totalWaiting / customers.length;
        
    }
}