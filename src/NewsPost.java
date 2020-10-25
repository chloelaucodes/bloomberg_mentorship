import java.time.*;
import java.time.format.*;
import java.util.ArrayList;
import java.util.HashSet;

public class NewsPost implements Comparable<NewsPost>{
	
	private String content, title, timeOfPosting;
	private User author;
	//private ArrayList<String> tags;
	private int read;
	private HashSet<String> tags;
	
	public NewsPost(User author, String title, String content, HashSet<String> tags){
		LocalDateTime timeNow = LocalDateTime.now();
		DateTimeFormatter formattedNow = DateTimeFormatter.ofPattern("dd-MM-yy HH:mm:ss");
		this.author = author;
		this.title = title;
		this.content = content;
		this.tags = tags;
		timeOfPosting = timeNow.format(formattedNow);
	}
	
	public void markAsRead(){
		read++;
	}
	
	public int getReads() {
		return read;
	}
	
	public HashSet<String> getTags(){
		return tags;
	}
	
	public String toString() {
		String s = "";
		s += title.toUpperCase() + "\n";
		s += author.toString() + "\n";
		s += content + "\n";
		s += timeOfPosting + "\n";		
		for (String tag:tags) {
			s += "#" + tag + "; ";
		}
		return s; //String.format("|%100d|", s);
	}
	
	@Override
	public int compareTo(NewsPost otherPost) {
		return Integer.compare(getReads(), otherPost.getReads());
	}
}
