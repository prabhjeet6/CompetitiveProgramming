package leetcode.design;
//https://leetcode.com/problems/design-twitter/

import java.util.*;

class DesignTwitter {
    class Tweet {
        int id;
        int time;
        Tweet next;

        Tweet(int id) {
            this.id = id;
            this.time = timeStamp++;
            this.next = null;
        }
    }

    class User {
        int id;
        Set<Integer> followed;
        public Tweet tweetHead;

        User(int id) {
            followed = new HashSet<>();
            tweetHead = null;
            follow(id);//follow yourself
        }

        void follow(int id) {
            followed.add(id);
        }

        void unfollow(int id) {
            followed.remove(id);
        }

        void post(int id) {
            Tweet tweet = new Tweet(id);
            tweet.next = tweetHead;
            tweetHead = tweet;
        }
    }

    static int timeStamp;
    Map<Integer, User> userMap;

    public DesignTwitter() {
        userMap = new HashMap<>();
    }

    public void postTweet(int userId, int tweetId) {
        if (!userMap.containsKey(userId)) {
            User user = new User(userId);
            userMap.put(userId, user);
        }
        userMap.get(userId).post(tweetId);
    }

    public List<Integer> getNewsFeed(int userId) {
        List<Integer> newsFeed = new ArrayList<>();
        if (!userMap.containsKey(userId)) return newsFeed;
        User user = userMap.get(userId);
        Set<Integer> users = user.followed;
        //Max Heap to give latest tweets in feed
        //Here size should be users.size(), because, if we keep it to the needed number, some tweets
        //which are latest may be missed
        PriorityQueue<Tweet> q = new PriorityQueue<>(users.size(), (a, b) -> b.time - a.time);
        for (int u : users) {
            Tweet t = userMap.get(u).tweetHead;
            if (null != t) {
                q.add(t);
            }
        }
        int n = 0;
        while (!q.isEmpty() && n < 10) {
            Tweet t = q.poll();
            newsFeed.add(t.id);
            n++;
            //imp: move to next pointer of user's tweets after consuming head
            if (t.next != null) {
                q.add(t.next);
            }
        }
        return newsFeed;
    }

    public void follow(int followerId, int followeeId) {
        if (!userMap.containsKey(followerId)) {
            User u = new User(followerId);
            userMap.put(followerId, u);
        }
        if (!userMap.containsKey(followeeId)) {
            User u = new User(followeeId);
            userMap.put(followeeId, u);
        }
        userMap.get(followerId).follow(followeeId);
    }

    /**
     * Follower unfollows a followee. If the operation is invalid, it should be a no-op.
     */
    public void unfollow(int followerId, int followeeId) {
        if (!userMap.containsKey(followerId) || followerId == followeeId)
            return;
        userMap.get(followerId).unfollow(followeeId);
    }
}

/**
 * Your Twitter object will be instantiated and called as such:
 * Twitter obj = new Twitter();
 * obj.postTweet(userId,tweetId);
 * List<Integer> param_2 = obj.getNewsFeed(userId);
 * obj.follow(followerId,followeeId);
 * obj.unfollow(followerId,followeeId);
 */