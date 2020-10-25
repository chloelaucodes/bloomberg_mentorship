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
		int count = 0;
		Timestamp start = null;
		ArrayList <Timestamp> top = new ArrayList<Timestamp>();
		for (Timestamp key:keys) {
			count++;
			if (count <= 10)
				top.add(count-1, key);
			else {
				for(int i = 0; i < 5; i++) {
					if (key.after(top.get(i)) && key.before(top.get(i+5)))
						start = key;
					else {
						if (!key.after(top.get(i)))
							top.add(i, start);
						else
							top.add(i+5, start);
						top.remove(top.get(top.size()-1));
					}//else
				}//for
			}//else
		}//for
		for (Timestamp t:top) {
			NewsPost post = newsFeed.get(t);
			topFeed += post.toString() + "\n\n";
		}
		return topFeed;
	}//displayTopTenNews
	
}
