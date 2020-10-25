import java.util.*;
import java.sql.Timestamp;

public class News {
	private HashMap<Timestamp, NewsPost> newsFeed = new HashMap<Timestamp, NewsPost>();
	
	public News(HashMap<Timestamp, NewsPost> newsFeed) {
		this.newsFeed = newsFeed;
	}
	
	public void addStory(User author, String title, String text, ArrayList<String> tags) {
		NewsPost newStory = new NewsPost(author, title, text, tags);
		Date time = new Date();
		long timestamp = time.getTime(); 
		Timestamp hashKey = new Timestamp(timestamp);
		newsFeed.put(hashKey, newStory);
	}
	
	public void markStoryAsRead(Timestamp storyID) {
		NewsPost justRead = newsFeed.get(storyID);
		justRead.markAsRead();
	}
	
	public String displayTopTenNews() {
		Set<Timestamp> keys = newsFeed.keySet();
		String topFeed = "";
		ArrayList <Timestamp> top = new ArrayList<Timestamp>();
		top.addAll(keys);
		top.sort(Collections.reverseOrder());
		for(int i = 0; i < 10; i++){
			NewsPost post = newsFeed.get(top.get(i));
			topFeed += post.toString() + "\n\n";
		}
		return topFeed;
	}//displayTopTenNews
	
	public String displayStoriesForAuthor(User author) {
		HashMap<Timestamp, NewsPost> AuthorPosts = author.getAuthorPosts();
		Set<Timestamp> keys = AuthorPosts.keySet();
		String userFeed = "";
		int count = 0;
		Timestamp start = null;
		ArrayList <Timestamp> auth = new ArrayList<Timestamp>();
		auth.addAll(keys);
		auth.sort(Collections.reverseOrder());
		for(int i = 0; i < 10; i++){
			NewsPost post = newsFeed.get(auth.get(i));
			userFeed += post.toString() + "\n\n";
		}
		return userFeed;
	}//displayStoriesForAuthor
	
	public String displayStoriesWithTags(Set<String> listOfTags) {
		Set<Timestamp> keys = newsFeed.keySet();
		String tagFeed = "";
		ArrayList <NewsPost> ts = new ArrayList<NewsPost>();
		for(Timestamp key:keys){
			NewsPost check = newsFeed.get(key);
			Set<String> superSet = check.getTags();
			if (superSet.containsAll(listOfTags))
				ts.add(check);
		}
		for(NewsPost t:ts) {
			tagFeed += t.toString() + "\n\n";
		}//for
		return tagFeed;
	}//displayTopTenNews
	
}
